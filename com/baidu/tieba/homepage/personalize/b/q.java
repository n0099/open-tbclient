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
    private TbPageContext<?> ajT;
    public BdUniqueId baI;
    private com.baidu.tieba.card.m cya;
    private cf<com.baidu.tieba.card.data.j> cyb;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.j.TYPE);
        this.cyb = new r(this);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cya = new com.baidu.tieba.card.m(this.ajT, this.baI);
        return new com.baidu.tieba.card.b.a(this.cya);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.b.a<com.baidu.tieba.card.m> aVar) {
        this.cya = aVar.Tz();
        aVar.Tz().a(jVar);
        aVar.Tz().setOnSubCardOnClickListenner(this.cyb);
        aVar.Tz().onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        cc.ST().a(new as("c11006"));
        return aVar.getView();
    }

    public void jS(int i) {
        if (this.cya != null) {
            this.cya.onChangeSkinType(this.ajT, i);
        }
    }
}
