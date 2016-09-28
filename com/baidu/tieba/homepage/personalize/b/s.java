package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.bn;
import com.baidu.tieba.card.cb;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.q, a> {
    private TbPageContext<?> GM;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.q.bcA);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public a a(ViewGroup viewGroup) {
        bn bnVar = new bn(this.GM);
        bnVar.ax("c10716", "c10717");
        return new a(bnVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.q qVar, a aVar) {
        if (qVar != null) {
            qVar.bcF = i + 1;
            aVar.bYn.onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        }
        aVar.bYn.onBindDataToView(qVar);
        cb.Oj().hQ("c10716");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bn bYn;

        public a(bn bnVar) {
            super(bnVar.getView());
            this.bYn = bnVar;
        }
    }
}
