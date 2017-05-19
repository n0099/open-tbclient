package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aq;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.b.a<aq>> {
    public BdUniqueId aLk;
    private o.a ajA;
    private TbPageContext<?> ajr;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSJ;
    private com.baidu.adp.lib.e.b<TbImageView> bSK;
    private cd cvq;
    private aq cvy;
    private com.baidu.tieba.homepage.personalize.model.f cvz;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajA = null;
        this.bSJ = new com.baidu.adp.lib.e.b<>(new n(this), 6, 0);
        this.bSK = new com.baidu.adp.lib.e.b<>(new o(this), 12, 0);
        this.cvq = new p(this);
        this.ajr = tbPageContext;
        ahN();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a<aq> onCreateViewHolder(ViewGroup viewGroup) {
        this.cvy = new aq(this.ajr);
        this.cvy.setConstrainLayoutPool(this.bSJ);
        this.cvy.setConstrainImagePool(this.bSK);
        this.cvy.j(this.aLk);
        return new com.baidu.tieba.card.b.a<>(this.cvy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.b.a<aq> aVar) {
        if (lVar == null || aVar == null || aVar.TU() == null) {
            return null;
        }
        lVar.gN(i + 1);
        ca.To().a(lVar.TG());
        aVar.TU().onBindDataToView(lVar);
        aVar.TU().setOnSubCardOnClickListenner(this.cvq);
        aVar.TU().a(this.ajA);
        return aVar.getView();
    }

    private void ahN() {
        com.baidu.tieba.card.data.l.bxk = "c10705";
        com.baidu.tieba.card.data.l.bxl = "c10730";
        com.baidu.tieba.card.data.l.bxm = "c10731";
        com.baidu.tieba.card.data.l.bxn = "c10704";
        com.baidu.tieba.card.data.l.bxo = "c10755";
        com.baidu.tieba.card.data.l.bxp = "c10710";
        com.baidu.tieba.card.data.l.bxq = "c10736";
        com.baidu.tieba.card.data.l.bxr = "c10737";
        com.baidu.tieba.card.data.l.bxs = "c10711";
        com.baidu.tieba.card.data.l.bxt = "c10758";
        com.baidu.tieba.card.data.l.bxu = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cvy != null) {
            this.cvy.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cvz = fVar;
    }

    public void setEventCallback(o.a aVar) {
        this.ajA = aVar;
    }
}
