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
    private boolean aJH;
    private ad<bb> cat;
    private String caw;
    private int dQh;
    private com.baidu.tieba.frs.e.a dQi;
    private com.baidu.tieba.frs.entelechy.view.d dQq;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aJH = false;
        this.dQh = 3;
        this.dQi = new com.baidu.tieba.frs.e.a();
        this.cat = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aGK().a(g.this.dQi, bbVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aGK().a(g.this.dQi, bbVar, 7);
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
        this.dQq = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        this.dQq.j(this.mPageId);
        if (this.dQq.caJ != null) {
            this.dQq.caJ.setInFrsAllThread(this.aJH);
        }
        this.dQq.iJ(this.dQh);
        return new com.baidu.tieba.card.a.a<>(this.dQq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> aVar) {
        if (aVar == null || aVar.aqe() == null) {
            return null;
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (aVar.aqe() instanceof com.baidu.tieba.a.e) {
            aVar.aqe().setPage(this.caw);
        }
        com.baidu.tieba.frs.g.a(aVar.aqe().aco(), this.dHF);
        com.baidu.tieba.frs.g.a(aVar.aqe().acp(), this.dHF);
        aVar.aqe().a(bbVar);
        aVar.aqe().setForumName(this.mForumName);
        aVar.aqe().b(this.cat);
        com.baidu.tieba.frs.e.b.aGK().a(this.dQi, bbVar);
        if (bbVar != null) {
            bbVar.AD();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iJ(int i) {
        this.dQh = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aJH = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aDT() {
        return this.dQi;
    }
}
