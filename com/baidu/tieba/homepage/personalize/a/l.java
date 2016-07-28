package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.au;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.m, a> {
    private TbPageContext<?> EA;
    public BdUniqueId aTm;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bJr;
    private com.baidu.adp.lib.f.b<TbImageView> bJs;
    private au cuf;
    private com.baidu.tieba.homepage.personalize.b.f cug;
    private bx cuh;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJr = new com.baidu.adp.lib.f.b<>(new m(this), 6, 0);
        this.bJs = new com.baidu.adp.lib.f.b<>(new n(this), 12, 0);
        this.cuh = new o(this);
        this.EA = tbPageContext;
        ahP();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public a a(ViewGroup viewGroup) {
        this.cuf = new au(this.EA);
        this.cuf.setConstrainLayoutPool(this.bJr);
        this.cuf.setConstrainImagePool(this.bJs);
        this.cuf.j(this.aTm);
        return new a(this.cuf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.m mVar, a aVar) {
        if (mVar != null) {
            mVar.fH(i + 1);
        }
        bw.Lf().b(mVar.Lu());
        aVar.cuj.a(mVar);
        aVar.cuj.a(this.cuh);
        return aVar.getView();
    }

    private void ahP() {
        com.baidu.tieba.card.a.m.aWf = "c10705";
        com.baidu.tieba.card.a.m.aWg = "c10730";
        com.baidu.tieba.card.a.m.aWh = "c10731";
        com.baidu.tieba.card.a.m.aWi = "c10704";
        com.baidu.tieba.card.a.m.aWj = "c10755";
        com.baidu.tieba.card.a.m.aWk = "c10710";
        com.baidu.tieba.card.a.m.aWl = "c10736";
        com.baidu.tieba.card.a.m.aWm = "c10737";
        com.baidu.tieba.card.a.m.aWn = "c10711";
        com.baidu.tieba.card.a.m.aWo = "c10758";
        com.baidu.tieba.card.a.m.aWp = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cuf != null) {
            this.cuf.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public au cuj;

        public a(au auVar) {
            super(auVar.getView());
            this.cuj = auVar;
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.cug = fVar;
    }
}
