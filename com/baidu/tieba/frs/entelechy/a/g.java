package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class g extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d>> implements com.baidu.tieba.a.f, ab, com.baidu.tieba.frs.e.d {
    private boolean aKm;
    private ad<bb> cbi;
    private String cbl;
    private int dTF;
    private com.baidu.tieba.frs.e.b dTG;
    private com.baidu.tieba.frs.entelechy.view.d dTO;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aKm = false;
        this.dTF = 3;
        this.dTG = new com.baidu.tieba.frs.e.b();
        this.cbi = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.c.aHW().a(g.this.dTG, bbVar, 2);
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, g.this.mPageId, g.this.dTG);
                    } else if (view.getId() != e.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.e.c.aHW().a(g.this.dTG, bbVar, 7);
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, g.this.mPageId, g.this.dTG);
                    } else {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, g.this.mPageId, g.this.dTG);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> onCreateViewHolder(ViewGroup viewGroup) {
        this.dTO = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        this.dTO.j(this.mPageId);
        if (this.dTO.cby != null) {
            this.dTO.cby.setInFrsAllThread(this.aKm);
        }
        this.dTO.iK(this.dTF);
        return new com.baidu.tieba.card.a.a<>(this.dTO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> aVar) {
        if (aVar == null || aVar.arr() == null) {
            return null;
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbl);
        }
        com.baidu.tieba.frs.g.a(aVar.arr().acN(), this.dLd);
        com.baidu.tieba.frs.g.a(aVar.arr().acO(), this.dLd);
        aVar.arr().a(bbVar);
        aVar.arr().setForumName(this.mForumName);
        aVar.arr().b(this.cbi);
        if (this.dTG != null) {
            int i2 = 0;
            if (this.dLd != null) {
                i2 = this.dLd.aHA();
            }
            bbVar.awk = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHW().a(this.dTG, bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dTG);
        if (bbVar != null) {
            bbVar.AQ();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.dTF = i;
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbl = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aKm = z;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aFf() {
        return this.dTG;
    }
}
