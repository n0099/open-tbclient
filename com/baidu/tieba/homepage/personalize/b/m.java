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
    private TbPageContext<?> ajT;
    private o.a akc;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSy;
    private com.baidu.adp.lib.e.b<TbImageView> bSz;
    public BdUniqueId baI;
    private cf cxP;
    private au cxX;
    private com.baidu.tieba.homepage.personalize.model.f cxY;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akc = null;
        this.bSy = new com.baidu.adp.lib.e.b<>(new n(this), 6, 0);
        this.bSz = new com.baidu.adp.lib.e.b<>(new o(this), 12, 0);
        this.cxP = new p(this);
        this.ajT = tbPageContext;
        ajA();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<au> onCreateViewHolder(ViewGroup viewGroup) {
        this.cxX = new au(this.ajT);
        if (this.cxX.brE != null) {
            this.cxX.brE.setReplyTimeVisible(false);
            this.cxX.brE.setViewNumEnabled(true);
        }
        this.cxX.SK();
        this.cxX.setSingleImageRatio(0.75d);
        this.cxX.setConstrainLayoutPool(this.bSy);
        this.cxX.setConstrainImagePool(this.bSz);
        this.cxX.j(this.baI);
        return new com.baidu.tieba.card.b.a<>(this.cxX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, com.baidu.tieba.card.b.a<au> aVar) {
        if (nVar == null || aVar == null || aVar.Tz() == null) {
            return null;
        }
        nVar.gL(i + 1);
        cc.ST().a(nVar.Tl());
        aVar.Tz().onBindDataToView(nVar);
        aVar.Tz().setOnSubCardOnClickListenner(this.cxP);
        aVar.Tz().a(this.akc);
        return aVar.getView();
    }

    private void ajA() {
        com.baidu.tieba.card.data.n.buV = "c10705";
        com.baidu.tieba.card.data.n.buW = "c10730";
        com.baidu.tieba.card.data.n.buX = "c10731";
        com.baidu.tieba.card.data.n.buY = "c10704";
        com.baidu.tieba.card.data.n.buZ = "c10755";
        com.baidu.tieba.card.data.n.bva = "c10710";
        com.baidu.tieba.card.data.n.bvb = "c10736";
        com.baidu.tieba.card.data.n.bvc = "c10737";
        com.baidu.tieba.card.data.n.bvd = "c10711";
        com.baidu.tieba.card.data.n.bve = "c10758";
        com.baidu.tieba.card.data.n.bvf = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cxX != null) {
            this.cxX.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cxY = fVar;
    }

    public void setEventCallback(o.a aVar) {
        this.akc = aVar;
    }
}
