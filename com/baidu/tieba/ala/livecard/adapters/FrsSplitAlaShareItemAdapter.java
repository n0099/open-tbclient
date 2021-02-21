package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
/* loaded from: classes10.dex */
public class FrsSplitAlaShareItemAdapter extends k<ca, FrsPageAlaShareHolder> implements com.baidu.tieba.a.f, z {
    private String aif;
    private com.baidu.tieba.ala.livecard.a.c hnf;
    private ab<cb> hng;
    private String mForumName;

    public FrsSplitAlaShareItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hng = new ab<cb>() { // from class: com.baidu.tieba.ala.livecard.adapters.FrsSplitAlaShareItemAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && FrsSplitAlaShareItemAdapter.this.mPageContext != null) {
                    customMessage.setData(cbVar);
                    FrsSplitAlaShareItemAdapter.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aE */
    public FrsPageAlaShareHolder e(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.hnf = new com.baidu.tieba.ala.livecard.a.c(this.mPageContext, this.mPageId);
        this.hnf.o(this.mPageId);
        this.hnf.setForumName(this.mForumName);
        this.hnf.c(this.hng);
        return new FrsPageAlaShareHolder(this.hnf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, FrsPageAlaShareHolder frsPageAlaShareHolder) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.jfU != null) {
            i2 = this.jfU.getTopThreadSize();
        }
        caVar.eJQ.eOs = (caVar.position + 1) - i2;
        customMessage.setData(caVar.eJQ);
        this.mPageContext.sendMessage(customMessage);
        if (caVar != null) {
            if (frsPageAlaShareHolder.hni instanceof com.baidu.tieba.a.e) {
                frsPageAlaShareHolder.hni.setPage(this.aif);
            }
            frsPageAlaShareHolder.hni.setForumName(this.mForumName);
            j.a(frsPageAlaShareHolder.hni.bYX(), this.jfU);
            j.a(frsPageAlaShareHolder.hni.bYY(), this.jfU);
            frsPageAlaShareHolder.hni.a(caVar.eJQ);
            caVar.eJQ.bpd();
        }
        return frsPageAlaShareHolder.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    /* loaded from: classes10.dex */
    public static class FrsPageAlaShareHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.ala.livecard.a.c hni;

        public FrsPageAlaShareHolder(com.baidu.tieba.ala.livecard.a.c cVar) {
            super(cVar.getView());
            this.hni = cVar;
        }
    }
}
