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
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class dj extends bp<com.baidu.tbadk.core.data.s, dl> implements View.OnClickListener, PhotoLiveCardView.b {
    private dl bhN;
    com.baidu.tbadk.core.data.s bhO;
    private Handler mHandler;
    private Runnable mRunnable;

    /* JADX INFO: Access modifiers changed from: protected */
    public dj(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.mHandler = new Handler();
        this.mRunnable = new dk(this);
        this.mHandler.post(this.mRunnable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public dl a(ViewGroup viewGroup) {
        if (this.bhN == null) {
            Ot();
        }
        return this.bhN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ot() {
        if (this.mContext != null) {
            this.bhN = new dl(LayoutInflater.from(this.mContext).inflate(n.h.frs_photo_live_view_pager_div, (ViewGroup) null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.s sVar, dl dlVar) {
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tbadk.core.data.s) dlVar);
        dlVar.bhV.setTag(sVar);
        dlVar.bhV.setOnClickListener(this);
        dlVar.bhT.setTag(sVar);
        dlVar.bhT.setOnClickListener(this);
        dlVar.bhT.setPortraitClicklistener(this);
        dlVar.bhR.setOnClickListener(this);
        if (this.bhO != sVar && sVar != null && sVar.rS() != null && sVar.rS().size() > 0) {
            this.bhO = sVar;
            dlVar.bhT.setData(sVar.rS().get(0));
        }
        dlVar.vR();
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.s) {
            com.baidu.tbadk.core.data.s sVar = (com.baidu.tbadk.core.data.s) view.getTag();
            int id = view.getId();
            if (id == n.g.item_live_card) {
                List<PhotoLiveCardData> rS = sVar.rS();
                if (rS != null && rS.size() > 0) {
                    PhotoLiveCardData photoLiveCardData = rS.get(0);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mContext, String.valueOf(photoLiveCardData.getThreadId())).cp("from_frs").bo(18003).rf()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10242").aa(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", 1));
                }
            } else if (id == n.g.all_live_list) {
                this.bfE.a(id, 0, view, null, sVar);
            }
        }
    }

    public int Ou() {
        return n.g.all_live_list;
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        if (view.getTag() instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) view.getTag();
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10178").aa(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", 1));
        }
    }
}
