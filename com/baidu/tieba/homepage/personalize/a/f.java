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
    private TbPageContext<?> EA;
    public BdUniqueId aTm;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bJr;
    private com.baidu.adp.lib.f.b<TbImageView> bJs;
    private bx bLl;
    private ap ctY;
    private com.baidu.tieba.homepage.personalize.b.f ctZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bLl = new g(this);
        this.bJr = new com.baidu.adp.lib.f.b<>(new h(this), 6, 0);
        this.bJs = new com.baidu.adp.lib.f.b<>(new i(this), 12, 0);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public a a(ViewGroup viewGroup) {
        this.ctY = new ap(this.EA);
        this.ctY.setConstrainLayoutPool(this.bJr);
        this.ctY.setConstrainImagePool(this.bJs);
        this.ctY.j(this.aTm);
        return new a(this.ctY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.m mVar, a aVar) {
        if (mVar != null) {
            mVar.fH(i + 1);
        }
        aVar.cub.a(mVar);
        aVar.cub.a(this.bLl);
        if (mVar.threadData != null && mVar.threadData.getTid() != null) {
            bw.Lf().b(new ay("c11003").ab("tid", mVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.ctY != null) {
            this.ctY.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public ap cub;

        public a(ap apVar) {
            super(apVar.getView());
            this.cub = apVar;
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.ctZ = fVar;
    }
}
