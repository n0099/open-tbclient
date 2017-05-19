package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.b.a<com.baidu.tieba.card.i>> {
    public BdUniqueId aLk;
    private TbPageContext<?> ajr;
    private com.baidu.tieba.card.i cvB;
    private cd<com.baidu.tieba.card.data.h> cvC;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.cvC = new r(this);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cvB = new com.baidu.tieba.card.i(this.ajr, this.aLk);
        return new com.baidu.tieba.card.b.a(this.cvB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.b.a<com.baidu.tieba.card.i> aVar) {
        this.cvB = aVar.TU();
        aVar.TU().a(hVar);
        aVar.TU().setOnSubCardOnClickListenner(this.cvC);
        aVar.TU().onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        ca.To().a(new as("c11006"));
        return aVar.getView();
    }

    public void jP(int i) {
        if (this.cvB != null) {
            this.cvB.onChangeSkinType(this.ajr, i);
        }
    }
}
