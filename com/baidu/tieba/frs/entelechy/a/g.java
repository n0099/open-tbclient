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
    private boolean aGh;
    private ad<bb> bWB;
    private String bWE;
    private int dJE;
    private com.baidu.tieba.frs.e.a dJF;
    private com.baidu.tieba.frs.entelechy.view.d dJN;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aGh = false;
        this.dJE = 3;
        this.dJF = new com.baidu.tieba.frs.e.a();
        this.bWB = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aEY().a(g.this.dJF, bbVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aEY().a(g.this.dJF, bbVar, 7);
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
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> onCreateViewHolder(ViewGroup viewGroup) {
        this.dJN = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        this.dJN.j(this.mPageId);
        if (this.dJN.bWR != null) {
            this.dJN.bWR.setInFrsAllThread(this.aGh);
        }
        this.dJN.iv(this.dJE);
        return new com.baidu.tieba.card.a.a<>(this.dJN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> aVar) {
        if (aVar == null || aVar.aor() == null) {
            return null;
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (aVar.aor() instanceof com.baidu.tieba.a.e) {
            aVar.aor().setPage(this.bWE);
        }
        com.baidu.tieba.frs.g.a(aVar.aor().abi(), this.dBg);
        com.baidu.tieba.frs.g.a(aVar.aor().abj(), this.dBg);
        aVar.aor().a(bbVar);
        aVar.aor().setForumName(this.mForumName);
        aVar.aor().b(this.bWB);
        com.baidu.tieba.frs.e.b.aEY().a(this.dJF, bbVar);
        if (bbVar != null) {
            bbVar.zz();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iv(int i) {
        this.dJE = i;
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aGh = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aCh() {
        return this.dJF;
    }
}
