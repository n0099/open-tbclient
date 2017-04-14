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
    private TbPageContext<?> ajT;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSy;
    private com.baidu.adp.lib.e.b<TbImageView> bSz;
    private cf baF;
    public BdUniqueId baI;
    private ap cxS;
    private com.baidu.tieba.homepage.personalize.model.f cxT;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.baF = new h(this);
        this.bSy = new com.baidu.adp.lib.e.b<>(new i(this), 6, 0);
        this.bSz = new com.baidu.adp.lib.e.b<>(new j(this), 12, 0);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cxS = new ap(this.ajT);
        if (this.cxS.brE != null) {
            this.cxS.brE.setReplyTimeVisible(false);
            this.cxS.brE.setViewNumEnabled(true);
        }
        this.cxS.SK();
        this.cxS.setSingleImageRatio(0.75d);
        this.cxS.setConstrainLayoutPool(this.bSy);
        this.cxS.setConstrainImagePool(this.bSz);
        this.cxS.j(this.baI);
        return new com.baidu.tieba.card.b.a(this.cxS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, com.baidu.tieba.card.b.a aVar) {
        if (nVar == null || aVar == null || aVar.Tz() == null) {
            return null;
        }
        nVar.gL(i + 1);
        aVar.Tz().onBindDataToView(nVar);
        aVar.Tz().setOnSubCardOnClickListenner(this.baF);
        if (nVar.threadData != null && nVar.threadData.getTid() != null) {
            cc.ST().a(new as("c11003").aa("tid", nVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cxS != null) {
            this.cxS.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cxT = fVar;
    }
}
