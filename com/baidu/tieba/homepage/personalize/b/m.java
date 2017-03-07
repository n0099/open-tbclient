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
    private TbPageContext<?> ajF;
    private o.a ajO;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSK;
    private com.baidu.adp.lib.e.b<TbImageView> bSL;
    public BdUniqueId baP;
    private cf czp;
    private au czx;
    private com.baidu.tieba.homepage.personalize.model.f czy;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajO = null;
        this.bSK = new com.baidu.adp.lib.e.b<>(new n(this), 6, 0);
        this.bSL = new com.baidu.adp.lib.e.b<>(new o(this), 12, 0);
        this.czp = new p(this);
        this.ajF = tbPageContext;
        ajG();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<au> onCreateViewHolder(ViewGroup viewGroup) {
        this.czx = new au(this.ajF);
        if (this.czx.brM != null) {
            this.czx.brM.setReplyTimeVisible(false);
            this.czx.brM.setViewNumEnabled(true);
        }
        this.czx.Sm();
        this.czx.setSingleImageRatio(0.75d);
        this.czx.setConstrainLayoutPool(this.bSK);
        this.czx.setConstrainImagePool(this.bSL);
        this.czx.j(this.baP);
        return new com.baidu.tieba.card.b.a<>(this.czx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, com.baidu.tieba.card.b.a<au> aVar) {
        if (nVar == null || aVar == null || aVar.Tb() == null) {
            return null;
        }
        nVar.gI(i + 1);
        cc.Sv().a(nVar.SN());
        aVar.Tb().onBindDataToView(nVar);
        aVar.Tb().setOnSubCardOnClickListenner(this.czp);
        aVar.Tb().a(this.ajO);
        return aVar.getView();
    }

    private void ajG() {
        com.baidu.tieba.card.data.n.bvc = "c10705";
        com.baidu.tieba.card.data.n.bvd = "c10730";
        com.baidu.tieba.card.data.n.bve = "c10731";
        com.baidu.tieba.card.data.n.bvf = "c10704";
        com.baidu.tieba.card.data.n.bvg = "c10755";
        com.baidu.tieba.card.data.n.bvh = "c10710";
        com.baidu.tieba.card.data.n.bvi = "c10736";
        com.baidu.tieba.card.data.n.bvj = "c10737";
        com.baidu.tieba.card.data.n.bvk = "c10711";
        com.baidu.tieba.card.data.n.bvl = "c10758";
        com.baidu.tieba.card.data.n.bvm = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.czx != null) {
            this.czx.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.czy = fVar;
    }

    public void setEventCallback(o.a aVar) {
        this.ajO = aVar;
    }
}
