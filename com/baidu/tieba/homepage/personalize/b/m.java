package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.au;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, com.baidu.tieba.card.b.a<au>> {
    private TbPageContext<?> FY;
    public BdUniqueId aUC;
    private o.a aez;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bLE;
    private com.baidu.adp.lib.e.b<TbImageView> bLF;
    private cf cxT;
    private au cyb;
    private com.baidu.tieba.homepage.personalize.model.f cyc;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aez = null;
        this.bLE = new com.baidu.adp.lib.e.b<>(new n(this), 6, 0);
        this.bLF = new com.baidu.adp.lib.e.b<>(new o(this), 12, 0);
        this.cxT = new p(this);
        this.FY = tbPageContext;
        aku();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<au> onCreateViewHolder(ViewGroup viewGroup) {
        this.cyb = new au(this.FY);
        this.cyb.setSingleImageRatio(0.75d);
        this.cyb.setConstrainLayoutPool(this.bLE);
        this.cyb.setConstrainImagePool(this.bLF);
        this.cyb.j(this.aUC);
        return new com.baidu.tieba.card.b.a<>(this.cyb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, com.baidu.tieba.card.b.a<au> aVar) {
        if (nVar == null || aVar == null || aVar.Sd() == null) {
            return null;
        }
        nVar.gL(i + 1);
        cc.Rx().a(nVar.RP());
        aVar.Sd().onBindDataToView(nVar);
        aVar.Sd().setOnSubCardOnClickListenner(this.cxT);
        aVar.Sd().a(this.aez);
        return aVar.getView();
    }

    private void aku() {
        com.baidu.tieba.card.data.n.boh = "c10705";
        com.baidu.tieba.card.data.n.boi = "c10730";
        com.baidu.tieba.card.data.n.boj = "c10731";
        com.baidu.tieba.card.data.n.bok = "c10704";
        com.baidu.tieba.card.data.n.bol = "c10755";
        com.baidu.tieba.card.data.n.bom = "c10710";
        com.baidu.tieba.card.data.n.bon = "c10736";
        com.baidu.tieba.card.data.n.boo = "c10737";
        com.baidu.tieba.card.data.n.bop = "c10711";
        com.baidu.tieba.card.data.n.boq = "c10758";
        com.baidu.tieba.card.data.n.bor = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cyb != null) {
            this.cyb.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cyc = fVar;
    }

    public void setEventCallback(o.a aVar) {
        this.aez = aVar;
    }
}
