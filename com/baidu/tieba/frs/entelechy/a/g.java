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
public class g extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d>> implements com.baidu.tieba.a.f, ab, com.baidu.tieba.frs.e.c {
    private boolean aFr;
    private ad<bb> bVP;
    private String bVS;
    private int dIA;
    private com.baidu.tieba.frs.e.a dIB;
    private com.baidu.tieba.frs.entelechy.view.d dIJ;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aFr = false;
        this.dIA = 3;
        this.dIB = new com.baidu.tieba.frs.e.a();
        this.bVP = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aFC().a(g.this.dIB, bbVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aFC().a(g.this.dIB, bbVar, 7);
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
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> onCreateViewHolder(ViewGroup viewGroup) {
        this.dIJ = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        this.dIJ.j(this.mPageId);
        if (this.dIJ.bWf != null) {
            this.dIJ.bWf.setInFrsAllThread(this.aFr);
        }
        this.dIJ.ii(this.dIA);
        return new com.baidu.tieba.card.a.a<>(this.dIJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> aVar) {
        if (aVar == null || aVar.aoP() == null) {
            return null;
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (aVar.aoP() instanceof com.baidu.tieba.a.e) {
            aVar.aoP().setPage(this.bVS);
        }
        com.baidu.tieba.frs.g.a(aVar.aoP().aaX(), this.dzP);
        com.baidu.tieba.frs.g.a(aVar.aoP().aaY(), this.dzP);
        aVar.aoP().a(bbVar);
        aVar.aoP().setForumName(this.mForumName);
        aVar.aoP().b(this.bVP);
        com.baidu.tieba.frs.e.b.aFC().a(this.dIB, bbVar);
        if (bbVar != null) {
            bbVar.zs();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void ii(int i) {
        this.dIA = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aFr = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aCM() {
        return this.dIB;
    }
}
