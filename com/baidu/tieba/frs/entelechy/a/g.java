package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.frs.h<bc, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d>> implements com.baidu.tieba.a.f, ab, com.baidu.tieba.frs.e.c {
    private boolean ayb;
    private ad<bc> bGJ;
    private String bGM;
    private int drk;
    private com.baidu.tieba.frs.e.a drl;
    private com.baidu.tieba.frs.entelechy.view.d drt;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ayb = false;
        this.drk = 3;
        this.drl = new com.baidu.tieba.frs.e.a();
        this.bGJ = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.azw().a(g.this.drl, bcVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.azw().a(g.this.drl, bcVar, 7);
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
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> onCreateViewHolder(ViewGroup viewGroup) {
        this.drt = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        this.drt.j(this.mPageId);
        if (this.drt.bGZ != null) {
            this.drt.bGZ.setInFrsAllThread(this.ayb);
        }
        this.drt.hf(this.drk);
        return new com.baidu.tieba.card.a.a<>(this.drt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bc bcVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> aVar) {
        if (aVar == null || aVar.aja() == null) {
            return null;
        }
        super.onFillViewHolder(i, view, viewGroup, bcVar, aVar);
        if (aVar.aja() instanceof com.baidu.tieba.a.e) {
            aVar.aja().setPage(this.bGM);
        }
        com.baidu.tieba.frs.g.a(aVar.aja().Vr(), this.djc);
        com.baidu.tieba.frs.g.a(aVar.aja().Vs(), this.djc);
        aVar.aja().a(bcVar);
        aVar.aja().setForumName(this.mForumName);
        aVar.aja().b(this.bGJ);
        com.baidu.tieba.frs.e.b.azw().a(this.drl, bcVar);
        if (bcVar != null) {
            bcVar.wq();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hf(int i) {
        this.drk = i;
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.ayb = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a awC() {
        return this.drl;
    }
}
