package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.b.a<com.baidu.tieba.card.m>> {
    private TbPageContext<?> ajU;
    public BdUniqueId bbE;
    private com.baidu.tieba.card.m cAr;
    private cf<com.baidu.tieba.card.data.j> cAs;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.j.TYPE);
        this.cAs = new r(this);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cAr = new com.baidu.tieba.card.m(this.ajU, this.bbE);
        return new com.baidu.tieba.card.b.a(this.cAr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.b.a<com.baidu.tieba.card.m> aVar) {
        this.cAr = aVar.UB();
        aVar.UB().a(jVar);
        aVar.UB().setOnSubCardOnClickListenner(this.cAs);
        aVar.UB().onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        cc.TV().a(new as("c11006"));
        return aVar.getView();
    }

    public void jY(int i) {
        if (this.cAr != null) {
            this.cAr.onChangeSkinType(this.ajU, i);
        }
    }
}
