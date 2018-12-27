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
    private boolean aJJ;
    private ad<bb> caw;
    private String caz;
    private int dSY;
    private com.baidu.tieba.frs.e.b dSZ;
    private com.baidu.tieba.frs.entelechy.view.d dTh;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aJJ = false;
        this.dSY = 3;
        this.dSZ = new com.baidu.tieba.frs.e.b();
        this.caw = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.c.aHz().a(g.this.dSZ, bbVar, 2);
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, g.this.mPageId, g.this.dSZ);
                    } else if (view.getId() != e.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.e.c.aHz().a(g.this.dSZ, bbVar, 7);
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, g.this.mPageId, g.this.dSZ);
                    } else {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, g.this.mPageId, g.this.dSZ);
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
        this.dTh = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        this.dTh.j(this.mPageId);
        if (this.dTh.caM != null) {
            this.dTh.caM.setInFrsAllThread(this.aJJ);
        }
        this.dTh.iK(this.dSY);
        return new com.baidu.tieba.card.a.a<>(this.dTh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> aVar) {
        if (aVar == null || aVar.aqT() == null) {
            return null;
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (aVar.aqT() instanceof com.baidu.tieba.a.e) {
            aVar.aqT().setPage(this.caz);
        }
        com.baidu.tieba.frs.g.a(aVar.aqT().acq(), this.dKt);
        com.baidu.tieba.frs.g.a(aVar.aqT().acr(), this.dKt);
        aVar.aqT().a(bbVar);
        aVar.aqT().setForumName(this.mForumName);
        aVar.aqT().b(this.caw);
        if (this.dSZ != null) {
            int i2 = 0;
            if (this.dKt != null) {
                i2 = this.dKt.aHd();
            }
            bbVar.avH = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHz().a(this.dSZ, bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dSZ);
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
    public void iK(int i) {
        this.dSY = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jL(String str) {
        this.caz = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aJJ = z;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aEI() {
        return this.dSZ;
    }
}
