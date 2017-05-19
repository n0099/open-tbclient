package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.b.a<al>> {
    public BdUniqueId aLk;
    private TbPageContext<?> ajr;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSJ;
    private com.baidu.adp.lib.e.b<TbImageView> bSK;
    private cd bbX;
    private al cvt;
    private com.baidu.tieba.homepage.personalize.model.f cvu;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bbX = new h(this);
        this.bSJ = new com.baidu.adp.lib.e.b<>(new i(this), 6, 0);
        this.bSK = new com.baidu.adp.lib.e.b<>(new j(this), 12, 0);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cvt = new al(this.ajr);
        this.cvt.setSingleImageRatio(0.75d);
        this.cvt.setConstrainLayoutPool(this.bSJ);
        this.cvt.setConstrainImagePool(this.bSK);
        this.cvt.j(this.aLk);
        return new com.baidu.tieba.card.b.a(this.cvt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.b.a aVar) {
        if (lVar == null || aVar == null || aVar.TU() == null) {
            return null;
        }
        lVar.gN(i + 1);
        aVar.TU().onBindDataToView(lVar);
        aVar.TU().setOnSubCardOnClickListenner(this.bbX);
        if (lVar.threadData != null && lVar.threadData.getTid() != null) {
            ca.To().a(new as("c11003").aa("tid", lVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cvt != null) {
            this.cvt.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cvu = fVar;
    }
}
