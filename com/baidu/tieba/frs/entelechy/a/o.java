package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.frs.entelechy.view.bb;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<bg, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.t>> implements bb, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GO;
    private com.baidu.tieba.frs.entelechy.view.t bFk;
    private cb<bg> bFl;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bFm;
    private com.baidu.adp.lib.f.b<TbImageView> bFn;
    private String mForumName;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.t> aVar) {
        return a2(i, view, viewGroup, bgVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bFl = new p(this);
        this.bFm = new com.baidu.adp.lib.f.b<>(new q(this), 6, 0);
        this.bFn = new com.baidu.adp.lib.f.b<>(new r(this), 12, 0);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a a(ViewGroup viewGroup) {
        this.bFk = new com.baidu.tieba.frs.entelechy.view.t(this.GO);
        this.bFk.setConstrainLayoutPool(this.bFm);
        this.bFk.setConstrainImagePool(this.bFn);
        this.bFk.setForumName(this.mForumName);
        this.bFk.j(this.GO.getUniqueId());
        return new com.baidu.tieba.card.a.a(this.bFk);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Po() == null) {
            return null;
        }
        aVar.Po().onBindDataToView(bgVar);
        aVar.Po().setOnSubCardOnClickListenner(this.bFl);
        com.baidu.tieba.frs.g.b.abq().a(bMV, bgVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bFk != null) {
            this.bFk.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.bb
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
