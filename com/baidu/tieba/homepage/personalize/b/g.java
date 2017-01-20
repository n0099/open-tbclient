package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, com.baidu.tieba.card.b.a<ap>> {
    private TbPageContext<?> FY;
    public BdUniqueId aUC;
    private cf aUz;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bLE;
    private com.baidu.adp.lib.e.b<TbImageView> bLF;
    private ap cxW;
    private com.baidu.tieba.homepage.personalize.model.f cxX;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aUz = new h(this);
        this.bLE = new com.baidu.adp.lib.e.b<>(new i(this), 6, 0);
        this.bLF = new com.baidu.adp.lib.e.b<>(new j(this), 12, 0);
        this.FY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cxW = new ap(this.FY);
        this.cxW.setSingleImageRatio(0.75d);
        this.cxW.setConstrainLayoutPool(this.bLE);
        this.cxW.setConstrainImagePool(this.bLF);
        this.cxW.j(this.aUC);
        return new com.baidu.tieba.card.b.a(this.cxW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, com.baidu.tieba.card.b.a aVar) {
        if (nVar == null || aVar == null || aVar.Sd() == null) {
            return null;
        }
        nVar.gL(i + 1);
        aVar.Sd().onBindDataToView(nVar);
        aVar.Sd().setOnSubCardOnClickListenner(this.aUz);
        if (nVar.threadData != null && nVar.threadData.getTid() != null) {
            cc.Rx().a(new ar("c11003").ab("tid", nVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cxW != null) {
            this.cxW.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cxX = fVar;
    }
}
