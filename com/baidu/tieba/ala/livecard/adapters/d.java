package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.j;
/* loaded from: classes4.dex */
public class d extends j<bv, a> implements com.baidu.tieba.a.f, y {
    private String afx;
    private com.baidu.tieba.ala.livecard.b.c fWM;
    private aa<bv> fWN;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fWN = new aa<bv>() { // from class: com.baidu.tieba.ala.livecard.adapters.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && d.this.mPageContext != null) {
                    customMessage.setData(bvVar);
                    d.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public a b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.fWM = new com.baidu.tieba.ala.livecard.b.c(this.mPageContext, this.mPageId);
        this.fWM.setForumName(this.mForumName);
        this.fWM.c(this.fWN);
        return new a(this.fWM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, a aVar) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.hEX != null) {
            i2 = this.hEX.getTopThreadSize();
        }
        bvVar.dPI = (i + 1) - i2;
        customMessage.setData(bvVar);
        this.mPageContext.sendMessage(customMessage);
        if (bvVar != null) {
            if (aVar.fWP instanceof com.baidu.tieba.a.e) {
                aVar.fWP.setPage(this.afx);
            }
            aVar.fWP.setForumName(this.mForumName);
            i.a(aVar.fWP.bCx(), this.hEX);
            i.a(aVar.fWP.bCy(), this.hEX);
            aVar.fWP.a(bvVar);
            bvVar.aXx();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    /* loaded from: classes4.dex */
    public static class a extends ad.a {
        public com.baidu.tieba.ala.livecard.b.c fWP;

        public a(com.baidu.tieba.ala.livecard.b.c cVar) {
            super(cVar.getView());
            this.fWP = cVar;
        }
    }
}
