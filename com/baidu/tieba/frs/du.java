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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class du extends bx<com.baidu.tbadk.core.data.ae, dw> implements View.OnClickListener, PhotoLiveCardView.b {
    private dw bpU;
    com.baidu.tbadk.core.data.ae bpV;
    private Handler mHandler;
    private Runnable mRunnable;

    /* JADX INFO: Access modifiers changed from: protected */
    public du(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.mHandler = new Handler();
        this.mRunnable = new dv(this);
        this.mHandler.post(this.mRunnable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public dw b(ViewGroup viewGroup) {
        if (this.bpU == null) {
            So();
        }
        return this.bpU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void So() {
        if (this.mContext != null) {
            this.bpU = new dw(LayoutInflater.from(this.mContext).inflate(t.h.frs_photo_live_view_pager_div, (ViewGroup) null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ae aeVar, dw dwVar) {
        super.a(i, view, viewGroup, (ViewGroup) aeVar, (com.baidu.tbadk.core.data.ae) dwVar);
        dwVar.bqc.setTag(aeVar);
        dwVar.bqc.setOnClickListener(this);
        dwVar.bqa.setTag(aeVar);
        dwVar.bqa.setOnClickListener(this);
        dwVar.bqa.setPortraitClicklistener(this);
        dwVar.bpY.setOnClickListener(this);
        if (this.bpV != aeVar && aeVar != null && aeVar.su() != null && aeVar.su().size() > 0) {
            this.bpV = aeVar;
            dwVar.bqa.setData(aeVar.su().get(0));
        }
        dwVar.xy();
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.ae) {
            com.baidu.tbadk.core.data.ae aeVar = (com.baidu.tbadk.core.data.ae) view.getTag();
            int id = view.getId();
            if (id == t.g.item_live_card) {
                List<PhotoLiveCardData> su = aeVar.su();
                if (su != null && su.size() > 0) {
                    PhotoLiveCardData photoLiveCardData = su.get(0);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mContext, String.valueOf(photoLiveCardData.getThreadId())).cl("from_frs").bC(18003).qT()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10242").ac("fid", String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", 1).r("obj_type", 1));
                }
            } else if (id == t.g.all_live_list) {
                this.bmX.a(id, 0, view, null, aeVar);
            }
        }
    }

    public int Sp() {
        return t.g.all_live_list;
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        if (view.getTag() instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) view.getTag();
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10178").ac("fid", String.valueOf(photoLiveCardData.getForumId())).r("obj_locate", 1).r("obj_type", 1));
        }
    }
}
