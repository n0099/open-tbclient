package com.baidu.tieba.frs;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.t;
import java.util.List;
/* renamed from: com.baidu.tieba.frs.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends bv<com.baidu.tbadk.core.data.w, dq> implements View.OnClickListener, PhotoLiveCardView.b {
    private dq bkF;
    com.baidu.tbadk.core.data.w bkG;
    private Handler mHandler;
    private Runnable mRunnable;

    /* JADX INFO: Access modifiers changed from: protected */
    public Cdo(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.mHandler = new Handler();
        this.mRunnable = new dp(this);
        this.mHandler.post(this.mRunnable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public dq b(ViewGroup viewGroup) {
        if (this.bkF == null) {
            Qv();
        }
        return this.bkF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qv() {
        if (this.mContext != null) {
            this.bkF = new dq(LayoutInflater.from(this.mContext).inflate(t.h.frs_photo_live_view_pager_div, (ViewGroup) null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, dq dqVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) dqVar);
        dqVar.bkN.setTag(wVar);
        dqVar.bkN.setOnClickListener(this);
        dqVar.bkL.setTag(wVar);
        dqVar.bkL.setOnClickListener(this);
        dqVar.bkL.setPortraitClicklistener(this);
        dqVar.bkJ.setOnClickListener(this);
        if (this.bkG != wVar && wVar != null && wVar.sz() != null && wVar.sz().size() > 0) {
            this.bkG = wVar;
            dqVar.bkL.setData(wVar.sz().get(0));
        }
        dqVar.xf();
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.w) {
            com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) view.getTag();
            int id = view.getId();
            if (id == t.g.item_live_card) {
                List<PhotoLiveCardData> sz = wVar.sz();
                if (sz != null && sz.size() > 0) {
                    PhotoLiveCardData photoLiveCardData = sz.get(0);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mContext, String.valueOf(photoLiveCardData.getThreadId())).co("from_frs").bD(18003).rC()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10242").aa(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", 1));
                }
            } else if (id == t.g.all_live_list) {
                this.bim.a(id, 0, view, null, wVar);
            }
        }
    }

    public int Qw() {
        return t.g.all_live_list;
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        if (view.getTag() instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) view.getTag();
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10178").aa(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", 1));
        }
    }
}
