package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.cb;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.tieba.card.a.a<al>> {
    private TbPageContext<?> GO;
    private cb bFl;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bFm;
    private com.baidu.adp.lib.f.b<TbImageView> bFn;
    public BdUniqueId bbl;
    private al cqR;
    private com.baidu.tieba.homepage.personalize.c.f cqS;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.tieba.card.a.a<al> aVar) {
        return a2(i, view, viewGroup, mVar, (com.baidu.tieba.card.a.a) aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bFl = new f(this);
        this.bFm = new com.baidu.adp.lib.f.b<>(new g(this), 6, 0);
        this.bFn = new com.baidu.adp.lib.f.b<>(new h(this), 12, 0);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a a(ViewGroup viewGroup) {
        this.cqR = new al(this.GO);
        this.cqR.setSingleImageRatio(0.75d);
        this.cqR.setConstrainLayoutPool(this.bFm);
        this.cqR.setConstrainImagePool(this.bFn);
        this.cqR.j(this.bbl);
        return new com.baidu.tieba.card.a.a(this.cqR);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.tieba.card.a.a aVar) {
        if (mVar != null) {
            mVar.gj(i + 1);
        }
        aVar.Po().onBindDataToView(mVar);
        aVar.Po().setOnSubCardOnClickListenner(this.bFl);
        if (mVar.threadData != null && mVar.threadData.getTid() != null) {
            bz.OH().a(new at("c11003").ab("tid", mVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cqR != null) {
            this.cqR.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cqS = fVar;
    }
}
