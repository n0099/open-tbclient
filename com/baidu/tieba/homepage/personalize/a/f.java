package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.m, a> {
    private TbPageContext<?> Ea;
    public BdUniqueId aSq;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bHW;
    private com.baidu.adp.lib.f.b<TbImageView> bHX;
    private bx bJH;
    private ap cro;
    private com.baidu.tieba.homepage.personalize.b.f crp;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJH = new g(this);
        this.bHW = new com.baidu.adp.lib.f.b<>(new h(this), 6, 0);
        this.bHX = new com.baidu.adp.lib.f.b<>(new i(this), 12, 0);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public a a(ViewGroup viewGroup) {
        this.cro = new ap(this.Ea);
        this.cro.setConstrainLayoutPool(this.bHW);
        this.cro.setConstrainImagePool(this.bHX);
        this.cro.j(this.aSq);
        return new a(this.cro);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.m mVar, a aVar) {
        if (mVar != null) {
            mVar.fI(i + 1);
        }
        aVar.crr.a(mVar);
        aVar.crr.a(this.bJH);
        if (mVar.threadData != null && mVar.threadData.getTid() != null) {
            bw.Lg().a(new ay("c11003").ab("tid", mVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cro != null) {
            this.cro.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public ap crr;

        public a(ap apVar) {
            super(apVar.getView());
            this.crr = apVar;
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.crp = fVar;
    }
}
