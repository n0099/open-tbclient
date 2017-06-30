package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.au;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.b.a<au>> {
    public BdUniqueId aMp;
    private TbPageContext<?> ajP;
    private o.a akb;
    private ci cJF;
    private au cJP;
    private com.baidu.tieba.homepage.personalize.model.f cJQ;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> cgJ;
    private com.baidu.adp.lib.e.b<TbImageView> cgK;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akb = null;
        this.cgJ = new com.baidu.adp.lib.e.b<>(new p(this), 6, 0);
        this.cgK = new com.baidu.adp.lib.e.b<>(new q(this), 12, 0);
        this.cJF = new r(this);
        this.ajP = tbPageContext;
        amO();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a<au> onCreateViewHolder(ViewGroup viewGroup) {
        this.cJP = new au(this.ajP);
        this.cJP.setConstrainLayoutPool(this.cgJ);
        this.cJP.setConstrainImagePool(this.cgK);
        this.cJP.j(this.aMp);
        return new com.baidu.tieba.card.b.a<>(this.cJP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.b.a<au> aVar) {
        if (lVar == null || aVar == null || aVar.Wp() == null) {
            return null;
        }
        lVar.ho(i + 1);
        cf.VN().a(lVar.Wb());
        aVar.Wp().a(lVar);
        aVar.Wp().a(this.cJF);
        aVar.Wp().a(this.akb);
        return aVar.getView();
    }

    private void amO() {
        com.baidu.tieba.card.data.l.bDZ = "c10705";
        com.baidu.tieba.card.data.l.bEa = "c10730";
        com.baidu.tieba.card.data.l.bEb = "c10731";
        com.baidu.tieba.card.data.l.bEc = "c10704";
        com.baidu.tieba.card.data.l.bEd = "c10755";
        com.baidu.tieba.card.data.l.bEe = "c10710";
        com.baidu.tieba.card.data.l.bEf = "c10736";
        com.baidu.tieba.card.data.l.bEg = "c10737";
        com.baidu.tieba.card.data.l.bEh = "c10711";
        com.baidu.tieba.card.data.l.bEi = "c10758";
        com.baidu.tieba.card.data.l.bEj = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cJP != null) {
            this.cJP.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cJQ = fVar;
    }

    public void setEventCallback(o.a aVar) {
        this.akb = aVar;
    }
}
