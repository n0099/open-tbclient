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
    private TbPageContext<?> ajF;
    public BdUniqueId baP;
    private com.baidu.tieba.card.m czA;
    private cf<com.baidu.tieba.card.data.j> czB;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.j.TYPE);
        this.czB = new r(this);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.czA = new com.baidu.tieba.card.m(this.ajF, this.baP);
        return new com.baidu.tieba.card.b.a(this.czA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.b.a<com.baidu.tieba.card.m> aVar) {
        this.czA = aVar.Tb();
        aVar.Tb().a(jVar);
        aVar.Tb().setOnSubCardOnClickListenner(this.czB);
        aVar.Tb().onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        cc.Sv().a(new as("c11006"));
        return aVar.getView();
    }

    public void jR(int i) {
        if (this.czA != null) {
            this.czA.onChangeSkinType(this.ajF, i);
        }
    }
}
