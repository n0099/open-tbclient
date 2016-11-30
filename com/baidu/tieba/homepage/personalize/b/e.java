package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aj;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.bz;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, a> {
    private TbPageContext<?> GO;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bXs;
    private com.baidu.adp.lib.f.b<TbImageView> bXt;
    private bz bZL;
    public BdUniqueId bcf;
    private aj cLB;
    private com.baidu.tieba.homepage.personalize.c.f cLC;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bZL = new f(this);
        this.bXs = new com.baidu.adp.lib.f.b<>(new g(this), 6, 0);
        this.bXt = new com.baidu.adp.lib.f.b<>(new h(this), 12, 0);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public a a(ViewGroup viewGroup) {
        this.cLB = new aj(this.GO);
        this.cLB.setSingleImageRatio(0.75d);
        this.cLB.setConstrainLayoutPool(this.bXs);
        this.cLB.setConstrainImagePool(this.bXt);
        this.cLB.j(this.bcf);
        return new a(this.cLB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, a aVar) {
        if (mVar != null) {
            mVar.gk(i + 1);
        }
        aVar.cLE.a(mVar);
        aVar.cLE.setOnSubCardOnClickListenner(this.bZL);
        if (mVar.threadData != null && mVar.threadData.getTid() != null) {
            bx.Pl().a(new av("c11003").ab("tid", mVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cLB != null) {
            this.cLB.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public aj cLE;

        public a(aj ajVar) {
            super(ajVar.getView());
            this.cLE = ajVar;
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cLC = fVar;
    }
}
