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
    private TbPageContext<?> ajU;
    private o.a akd;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bUP;
    private com.baidu.adp.lib.e.b<TbImageView> bUQ;
    public BdUniqueId bbE;
    private cf cAg;
    private au cAo;
    private com.baidu.tieba.homepage.personalize.model.f cAp;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akd = null;
        this.bUP = new com.baidu.adp.lib.e.b<>(new n(this), 6, 0);
        this.bUQ = new com.baidu.adp.lib.e.b<>(new o(this), 12, 0);
        this.cAg = new p(this);
        this.ajU = tbPageContext;
        akB();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a<au> onCreateViewHolder(ViewGroup viewGroup) {
        this.cAo = new au(this.ajU);
        if (this.cAo.btW != null) {
            this.cAo.btW.setReplyTimeVisible(false);
            this.cAo.btW.setViewNumEnabled(true);
        }
        this.cAo.TM();
        this.cAo.setSingleImageRatio(0.75d);
        this.cAo.setConstrainLayoutPool(this.bUP);
        this.cAo.setConstrainImagePool(this.bUQ);
        this.cAo.j(this.bbE);
        return new com.baidu.tieba.card.b.a<>(this.cAo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, com.baidu.tieba.card.b.a<au> aVar) {
        if (nVar == null || aVar == null || aVar.UB() == null) {
            return null;
        }
        nVar.gR(i + 1);
        cc.TV().a(nVar.Un());
        aVar.UB().onBindDataToView(nVar);
        aVar.UB().setOnSubCardOnClickListenner(this.cAg);
        aVar.UB().a(this.akd);
        return aVar.getView();
    }

    private void akB() {
        com.baidu.tieba.card.data.n.bxm = "c10705";
        com.baidu.tieba.card.data.n.bxn = "c10730";
        com.baidu.tieba.card.data.n.bxo = "c10731";
        com.baidu.tieba.card.data.n.bxp = "c10704";
        com.baidu.tieba.card.data.n.bxq = "c10755";
        com.baidu.tieba.card.data.n.bxr = "c10710";
        com.baidu.tieba.card.data.n.bxs = "c10736";
        com.baidu.tieba.card.data.n.bxt = "c10737";
        com.baidu.tieba.card.data.n.bxu = "c10711";
        com.baidu.tieba.card.data.n.bxv = "c10758";
        com.baidu.tieba.card.data.n.bxw = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cAo != null) {
            this.cAo.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cAp = fVar;
    }

    public void setEventCallback(o.a aVar) {
        this.akd = aVar;
    }
}
