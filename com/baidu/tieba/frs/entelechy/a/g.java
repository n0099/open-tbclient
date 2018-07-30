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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d>> implements com.baidu.tieba.a.f, ab, com.baidu.tieba.frs.e.c {
    private boolean axH;
    private String bHB;
    private ad<bb> bHy;
    private int dtX;
    private com.baidu.tieba.frs.e.a dtY;
    private com.baidu.tieba.frs.entelechy.view.d dug;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.axH = false;
        this.dtX = 3;
        this.dtY = new com.baidu.tieba.frs.e.a();
        this.bHy = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aAd().a(g.this.dtY, bbVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aAd().a(g.this.dtY, bbVar, 7);
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
        this.dug = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        this.dug.j(this.mPageId);
        if (this.dug.bHO != null) {
            this.dug.bHO.setInFrsAllThread(this.axH);
        }
        this.dug.hl(this.dtX);
        return new com.baidu.tieba.card.a.a<>(this.dug);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> aVar) {
        if (aVar == null || aVar.ajz() == null) {
            return null;
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (aVar.ajz() instanceof com.baidu.tieba.a.e) {
            aVar.ajz().setPage(this.bHB);
        }
        com.baidu.tieba.frs.g.a(aVar.ajz().VA(), this.dlS);
        com.baidu.tieba.frs.g.a(aVar.ajz().VB(), this.dlS);
        aVar.ajz().a(bbVar);
        aVar.ajz().setForumName(this.mForumName);
        aVar.ajz().b(this.bHy);
        com.baidu.tieba.frs.e.b.aAd().a(this.dtY, bbVar);
        if (bbVar != null) {
            bbVar.wf();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hl(int i) {
        this.dtX = i;
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.axH = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axh() {
        return this.dtY;
    }
}
