package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.bt;
import com.baidu.tieba.card.bw;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.q, a> {
    private TbPageContext<?> Ea;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.q.aVI);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public a a(ViewGroup viewGroup) {
        bt btVar = new bt(this.Ea);
        btVar.aw("c10716", "c10717");
        return new a(btVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.q qVar, a aVar) {
        if (qVar != null) {
            qVar.aVL = i + 1;
            aVar.bLp.d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        }
        aVar.bLp.a(qVar);
        bw.Lg().he("c10716");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bt bLp;

        public a(bt btVar) {
            super(btVar.getView());
            this.bLp = btVar;
        }
    }
}
