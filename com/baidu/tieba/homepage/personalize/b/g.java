package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, com.baidu.tieba.card.b.a<ap>> {
    private TbPageContext<?> ajU;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bUP;
    private com.baidu.adp.lib.e.b<TbImageView> bUQ;
    private cf bbB;
    public BdUniqueId bbE;
    private ap cAj;
    private com.baidu.tieba.homepage.personalize.model.f cAk;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bbB = new h(this);
        this.bUP = new com.baidu.adp.lib.e.b<>(new i(this), 6, 0);
        this.bUQ = new com.baidu.adp.lib.e.b<>(new j(this), 12, 0);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cAj = new ap(this.ajU);
        if (this.cAj.btW != null) {
            this.cAj.btW.setReplyTimeVisible(false);
            this.cAj.btW.setViewNumEnabled(true);
        }
        this.cAj.TM();
        this.cAj.setSingleImageRatio(0.75d);
        this.cAj.setConstrainLayoutPool(this.bUP);
        this.cAj.setConstrainImagePool(this.bUQ);
        this.cAj.j(this.bbE);
        return new com.baidu.tieba.card.b.a(this.cAj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, com.baidu.tieba.card.b.a aVar) {
        if (nVar == null || aVar == null || aVar.UB() == null) {
            return null;
        }
        nVar.gR(i + 1);
        aVar.UB().onBindDataToView(nVar);
        aVar.UB().setOnSubCardOnClickListenner(this.bbB);
        if (nVar.threadData != null && nVar.threadData.getTid() != null) {
            cc.TV().a(new as("c11003").aa("tid", nVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cAj != null) {
            this.cAj.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cAk = fVar;
    }
}
