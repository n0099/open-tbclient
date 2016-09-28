package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aj;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYW;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bUl;
    private com.baidu.adp.lib.f.b<TbImageView> bUm;
    private cd bWu;
    private aj cGq;
    private com.baidu.tieba.homepage.personalize.c.f cGr;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bWu = new f(this);
        this.bUl = new com.baidu.adp.lib.f.b<>(new g(this), 6, 0);
        this.bUm = new com.baidu.adp.lib.f.b<>(new h(this), 12, 0);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public a a(ViewGroup viewGroup) {
        this.cGq = new aj(this.GM);
        this.cGq.setConstrainLayoutPool(this.bUl);
        this.cGq.setConstrainImagePool(this.bUm);
        this.cGq.j(this.aYW);
        return new a(this.cGq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, a aVar) {
        if (mVar != null) {
            mVar.gj(i + 1);
        }
        aVar.cGt.a(mVar);
        aVar.cGt.setOnSubCardOnClickListenner(this.bWu);
        if (mVar.threadData != null && mVar.threadData.getTid() != null) {
            cb.Oj().a(new ax("c11003").ab("tid", mVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cGq != null) {
            this.cGq.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public aj cGt;

        public a(aj ajVar) {
            super(ajVar.getView());
            this.cGt = ajVar;
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cGr = fVar;
    }
}
