package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
/* loaded from: classes10.dex */
public class FrsAlaShareItemAdapter extends k<cb, FrsPageAlaShareHolder> implements com.baidu.tieba.a.f, z {
    private String aif;
    private com.baidu.tieba.ala.livecard.a.c hmR;
    private ab<cb> hmS;
    private String mForumName;

    public FrsAlaShareItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hmS = new ab<cb>() { // from class: com.baidu.tieba.ala.livecard.adapters.FrsAlaShareItemAdapter.1
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
                if (customMessage != null && FrsAlaShareItemAdapter.this.mPageContext != null) {
                    customMessage.setData(cbVar);
                    FrsAlaShareItemAdapter.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public FrsPageAlaShareHolder e(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.hmR = new com.baidu.tieba.ala.livecard.a.c(this.mPageContext, this.mPageId);
        this.hmR.o(this.mPageId);
        this.hmR.setForumName(this.mForumName);
        this.hmR.c(this.hmS);
        return new FrsPageAlaShareHolder(this.hmR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cb cbVar, FrsPageAlaShareHolder frsPageAlaShareHolder) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.jfG != null) {
            i2 = this.jfG.getTopThreadSize();
        }
        cbVar.eOs = (i + 1) - i2;
        customMessage.setData(cbVar);
        this.mPageContext.sendMessage(customMessage);
        if (cbVar != null) {
            if (frsPageAlaShareHolder.hmU instanceof com.baidu.tieba.a.e) {
                frsPageAlaShareHolder.hmU.setPage(this.aif);
            }
            frsPageAlaShareHolder.hmU.setForumName(this.mForumName);
            j.a(frsPageAlaShareHolder.hmU.bYQ(), this.jfG);
            j.a(frsPageAlaShareHolder.hmU.bYR(), this.jfG);
            frsPageAlaShareHolder.hmU.a(cbVar);
            cbVar.bpd();
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
    public void Ey(String str) {
        this.aif = str;
    }

    /* loaded from: classes10.dex */
    public static class FrsPageAlaShareHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.ala.livecard.a.c hmU;

        public FrsPageAlaShareHolder(com.baidu.tieba.ala.livecard.a.c cVar) {
            super(cVar.getView());
            this.hmU = cVar;
        }
    }
}
