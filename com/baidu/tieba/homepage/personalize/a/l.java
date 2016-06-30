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
    private TbPageContext<?> Ea;
    public BdUniqueId aSq;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bHW;
    private com.baidu.adp.lib.f.b<TbImageView> bHX;
    private au crv;
    private com.baidu.tieba.homepage.personalize.b.f crw;
    private bx crx;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bHW = new com.baidu.adp.lib.f.b<>(new m(this), 6, 0);
        this.bHX = new com.baidu.adp.lib.f.b<>(new n(this), 12, 0);
        this.crx = new o(this);
        this.Ea = tbPageContext;
        ahg();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public a a(ViewGroup viewGroup) {
        this.crv = new au(this.Ea);
        this.crv.setConstrainLayoutPool(this.bHW);
        this.crv.setConstrainImagePool(this.bHX);
        this.crv.j(this.aSq);
        return new a(this.crv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.m mVar, a aVar) {
        if (mVar != null) {
            mVar.fI(i + 1);
        }
        bw.Lg().a(mVar.Lv());
        aVar.crz.a(mVar);
        aVar.crz.a(this.crx);
        return aVar.getView();
    }

    private void ahg() {
        com.baidu.tieba.card.a.m.aVh = "c10705";
        com.baidu.tieba.card.a.m.aVi = "c10730";
        com.baidu.tieba.card.a.m.aVj = "c10731";
        com.baidu.tieba.card.a.m.aVk = "c10704";
        com.baidu.tieba.card.a.m.aVl = "c10755";
        com.baidu.tieba.card.a.m.aVm = "c10710";
        com.baidu.tieba.card.a.m.aVn = "c10736";
        com.baidu.tieba.card.a.m.aVo = "c10737";
        com.baidu.tieba.card.a.m.aVp = "c10711";
        com.baidu.tieba.card.a.m.aVq = "c10758";
        com.baidu.tieba.card.a.m.aVr = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.crv != null) {
            this.crv.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public au crz;

        public a(au auVar) {
            super(auVar.getView());
            this.crz = auVar;
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.crw = fVar;
    }
}
