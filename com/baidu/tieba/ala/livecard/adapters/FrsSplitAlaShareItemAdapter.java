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
/* loaded from: classes9.dex */
public class FrsSplitAlaShareItemAdapter extends k<ca, FrsPageAlaShareHolder> implements com.baidu.tieba.a.f, z {
    private String ajx;
    private com.baidu.tieba.ala.livecard.a.c hoP;
    private ab<cb> hoQ;
    private String mForumName;

    public FrsSplitAlaShareItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hoQ = new ab<cb>() { // from class: com.baidu.tieba.ala.livecard.adapters.FrsSplitAlaShareItemAdapter.1
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
        this.hoP = new com.baidu.tieba.ala.livecard.a.c(this.mPageContext, this.mPageId);
        this.hoP.o(this.mPageId);
        this.hoP.setForumName(this.mForumName);
        this.hoP.c(this.hoQ);
        return new FrsPageAlaShareHolder(this.hoP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, FrsPageAlaShareHolder frsPageAlaShareHolder) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.jhD != null) {
            i2 = this.jhD.getTopThreadSize();
        }
        caVar.eLr.ePT = (caVar.position + 1) - i2;
        customMessage.setData(caVar.eLr);
        this.mPageContext.sendMessage(customMessage);
        if (caVar != null) {
            if (frsPageAlaShareHolder.hoS instanceof com.baidu.tieba.a.e) {
                frsPageAlaShareHolder.hoS.setPage(this.ajx);
            }
            frsPageAlaShareHolder.hoS.setForumName(this.mForumName);
            j.a(frsPageAlaShareHolder.hoS.bZd(), this.jhD);
            j.a(frsPageAlaShareHolder.hoS.bZe(), this.jhD);
            frsPageAlaShareHolder.hoS.a(caVar.eLr);
            caVar.eLr.bpf();
        }
        return frsPageAlaShareHolder.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uZ(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    /* loaded from: classes9.dex */
    public static class FrsPageAlaShareHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.ala.livecard.a.c hoS;

        public FrsPageAlaShareHolder(com.baidu.tieba.ala.livecard.a.c cVar) {
            super(cVar.getView());
            this.hoS = cVar;
        }
    }
}
