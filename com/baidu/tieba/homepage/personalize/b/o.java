package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYW;
    private com.baidu.tieba.card.m cGC;
    private cd<com.baidu.tieba.card.data.k> cGD;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.k.Ru);
        this.cGD = new p(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public a a(ViewGroup viewGroup) {
        this.cGC = new com.baidu.tieba.card.m(this.GM, this.aYW);
        return new a(this.cGC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        this.cGC = aVar.cGF;
        aVar.cGF.onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.cGF.a(kVar);
        aVar.cGF.setOnSubCardOnClickListenner(this.cGD);
        cb.Oj().a(new ax("c11006"));
        return aVar.getView();
    }

    public void ki(int i) {
        if (this.cGC != null) {
            this.cGC.onChangeSkinType(this.GM, i);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.m cGF;

        public a(com.baidu.tieba.card.m mVar) {
            super(mVar.getView());
            this.cGF = mVar;
        }
    }
}
