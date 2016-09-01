package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.bp;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.q, a> {
    private TbPageContext<?> GM;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.q.bci);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public a a(ViewGroup viewGroup) {
        bp bpVar = new bp(this.GM);
        bpVar.ax("c10716", "c10717");
        return new a(bpVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.q qVar, a aVar) {
        if (qVar != null) {
            qVar.bcl = i + 1;
            aVar.bYs.onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        }
        aVar.bYs.onBindDataToView(qVar);
        cd.NI().hJ("c10716");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bp bYs;

        public a(bp bpVar) {
            super(bpVar.getView());
            this.bYs = bpVar;
        }
    }
}
