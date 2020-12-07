package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class g extends k<bx, a> implements com.baidu.tieba.a.f, z {
    private String aiw;
    private com.baidu.tieba.ala.livecard.b.c hbw;
    private ab<by> hbx;
    private String mForumName;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hbx = new ab<by>() { // from class: com.baidu.tieba.ala.livecard.adapters.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && g.this.mPageContext != null) {
                    customMessage.setData(byVar);
                    g.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public a c(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.hbw = new com.baidu.tieba.ala.livecard.b.c(this.mPageContext, this.mPageId);
        this.hbw.o(this.mPageId);
        this.hbw.setForumName(this.mForumName);
        this.hbw.c(this.hbx);
        return new a(this.hbw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, a aVar) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.iSt != null) {
            i2 = this.iSt.getTopThreadSize();
        }
        bxVar.eCR.eHa = (bxVar.position + 1) - i2;
        customMessage.setData(bxVar.eCR);
        this.mPageContext.sendMessage(customMessage);
        if (bxVar != null) {
            if (aVar.hbz instanceof com.baidu.tieba.a.e) {
                aVar.hbz.setPage(this.aiw);
            }
            aVar.hbz.setForumName(this.mForumName);
            j.a(aVar.hbz.bZb(), this.iSt);
            j.a(aVar.hbz.bZc(), this.iSt);
            aVar.hbz.a(bxVar.eCR);
            bxVar.eCR.bqd();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    /* loaded from: classes6.dex */
    public static class a extends af.a {
        public com.baidu.tieba.ala.livecard.b.c hbz;

        public a(com.baidu.tieba.ala.livecard.b.c cVar) {
            super(cVar.getView());
            this.hbz = cVar;
        }
    }
}
