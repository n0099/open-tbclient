package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.b.a<com.baidu.tieba.card.m>> {
    private TbPageContext<?> FY;
    public BdUniqueId aUC;
    private com.baidu.tieba.card.m cye;
    private cf<com.baidu.tieba.card.data.j> cyf;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.j.TYPE);
        this.cyf = new r(this);
        this.FY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cye = new com.baidu.tieba.card.m(this.FY, this.aUC);
        return new com.baidu.tieba.card.b.a(this.cye);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.b.a<com.baidu.tieba.card.m> aVar) {
        this.cye = aVar.Sd();
        aVar.Sd().a(jVar);
        aVar.Sd().setOnSubCardOnClickListenner(this.cyf);
        aVar.Sd().onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        cc.Rx().a(new ar("c11006"));
        return aVar.getView();
    }

    public void kn(int i) {
        if (this.cye != null) {
            this.cye.onChangeSkinType(this.FY, i);
        }
    }
}
