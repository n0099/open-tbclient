package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class d extends k<bw, a> implements com.baidu.tieba.a.f, z {
    private String ahu;
    private com.baidu.tieba.ala.livecard.b.c gSC;
    private ab<bw> gSD;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gSD = new ab<bw>() { // from class: com.baidu.tieba.ala.livecard.adapters.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && d.this.mPageContext != null) {
                    customMessage.setData(bwVar);
                    d.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public a c(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.gSC = new com.baidu.tieba.ala.livecard.b.c(this.mPageContext, this.mPageId);
        this.gSC.setForumName(this.mForumName);
        this.gSC.c(this.gSD);
        return new a(this.gSC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, a aVar) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.iGN != null) {
            i2 = this.iGN.getTopThreadSize();
        }
        bwVar.eBK = (i + 1) - i2;
        customMessage.setData(bwVar);
        this.mPageContext.sendMessage(customMessage);
        if (bwVar != null) {
            if (aVar.gSF instanceof com.baidu.tieba.a.e) {
                aVar.gSF.setPage(this.ahu);
            }
            aVar.gSF.setForumName(this.mForumName);
            j.a(aVar.gSF.bVY(), this.iGN);
            j.a(aVar.gSF.bVZ(), this.iGN);
            aVar.gSF.a(bwVar);
            bwVar.bnM();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vd(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public com.baidu.tieba.ala.livecard.b.c gSF;

        public a(com.baidu.tieba.ala.livecard.b.c cVar) {
            super(cVar.getView());
            this.gSF = cVar;
        }
    }
}
