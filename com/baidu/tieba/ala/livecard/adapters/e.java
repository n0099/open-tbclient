package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
import com.baidu.tieba.card.x;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.frs.h;
/* loaded from: classes3.dex */
public class e extends h<bi, a> implements com.baidu.tieba.a.f, x {
    private String LC;
    private com.baidu.tieba.ala.livecard.b.c eNo;
    private z<bj> eNp;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.eNp = new z<bj>() { // from class: com.baidu.tieba.ala.livecard.adapters.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && e.this.mPageContext != null) {
                    customMessage.setData(bjVar);
                    e.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public a b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.eNo = new com.baidu.tieba.ala.livecard.b.c(this.mPageContext, this.mPageId);
        this.eNo.setForumName(this.mForumName);
        this.eNo.c(this.eNp);
        return new a(this.eNo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, a aVar) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.gnZ != null) {
            i2 = this.gnZ.getTopThreadSize();
        }
        biVar.cRg.cPG = (biVar.position + 1) - i2;
        customMessage.setData(biVar.cRg);
        this.mPageContext.sendMessage(customMessage);
        if (biVar != null) {
            if (aVar.eNr instanceof com.baidu.tieba.a.e) {
                aVar.eNr.setPage(this.LC);
            }
            aVar.eNr.setForumName(this.mForumName);
            g.a(aVar.eNr.bha(), this.gnZ);
            g.a(aVar.eNr.bhb(), this.gnZ);
            aVar.eNr.a(biVar.cRg);
            biVar.cRg.aDw();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public com.baidu.tieba.ala.livecard.b.c eNr;

        public a(com.baidu.tieba.ala.livecard.b.c cVar) {
            super(cVar.getView());
            this.eNr = cVar;
        }
    }
}
