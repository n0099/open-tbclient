package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.b.a<ap>> {
    public BdUniqueId aKZ;
    private TbPageContext<?> ajh;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bYA;
    private com.baidu.adp.lib.e.b<TbImageView> bYB;
    private ci bdm;
    private ap cBL;
    private com.baidu.tieba.homepage.personalize.model.f cBM;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bdm = new h(this);
        this.bYA = new com.baidu.adp.lib.e.b<>(new i(this), 6, 0);
        this.bYB = new com.baidu.adp.lib.e.b<>(new j(this), 12, 0);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cBL = new ap(this.ajh);
        this.cBL.setSingleImageRatio(0.75d);
        this.cBL.setConstrainLayoutPool(this.bYA);
        this.cBL.setConstrainImagePool(this.bYB);
        this.cBL.j(this.aKZ);
        return new com.baidu.tieba.card.b.a(this.cBL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.b.a aVar) {
        if (lVar == null || aVar == null || aVar.UY() == null) {
            return null;
        }
        lVar.hl(i + 1);
        aVar.UY().a((com.baidu.tieba.card.a) lVar);
        aVar.UY().a(this.bdm);
        if (lVar.threadData != null && lVar.threadData.getTid() != null) {
            cf.Uw().a(new as("c11003").Z("tid", lVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cBL != null) {
            this.cBL.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cBM = fVar;
    }
}
