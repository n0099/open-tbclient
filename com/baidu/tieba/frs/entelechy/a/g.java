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
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d>> implements com.baidu.tieba.a.f, ab, com.baidu.tieba.frs.e.c {
    private boolean aAK;
    private ad<bb> bNn;
    private String bNq;
    private int dAA;
    private com.baidu.tieba.frs.e.a dAB;
    private com.baidu.tieba.frs.entelechy.view.d dAJ;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aAK = false;
        this.dAA = 3;
        this.dAB = new com.baidu.tieba.frs.e.a();
        this.bNn = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aCj().a(g.this.dAB, bbVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aCj().a(g.this.dAB, bbVar, 7);
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
        this.dAJ = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        this.dAJ.j(this.mPageId);
        if (this.dAJ.bND != null) {
            this.dAJ.bND.setInFrsAllThread(this.aAK);
        }
        this.dAJ.hK(this.dAA);
        return new com.baidu.tieba.card.a.a<>(this.dAJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> aVar) {
        if (aVar == null || aVar.aln() == null) {
            return null;
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        com.baidu.tieba.frs.g.a(aVar.aln().Xq(), this.drN);
        com.baidu.tieba.frs.g.a(aVar.aln().Xr(), this.drN);
        aVar.aln().a(bbVar);
        aVar.aln().setForumName(this.mForumName);
        aVar.aln().b(this.bNn);
        com.baidu.tieba.frs.e.b.aCj().a(this.dAB, bbVar);
        if (bbVar != null) {
            bbVar.xj();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hK(int i) {
        this.dAA = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aAK = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a azt() {
        return this.dAB;
    }
}
