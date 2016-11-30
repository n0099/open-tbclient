package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.bj;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.q, a> {
    private TbPageContext<?> GO;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.q.bfz);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public a a(ViewGroup viewGroup) {
        bj bjVar = new bj(this.GO);
        bjVar.ay("c10716", "c10717");
        return new a(bjVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.q qVar, a aVar) {
        if (qVar != null) {
            qVar.bfE = i + 1;
            aVar.cbF.onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        }
        aVar.cbF.onBindDataToView(qVar);
        bx.Pl().hU("c10716");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bj cbF;

        public a(bj bjVar) {
            super(bjVar.getView());
            this.cbF = bjVar;
        }
    }
}
