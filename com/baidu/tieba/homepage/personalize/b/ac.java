package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.ca;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.q, com.baidu.tieba.card.b.a<bz>> {
    private TbPageContext<?> ajr;

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.q.byi);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        bz bzVar = new bz(this.ajr);
        bzVar.q("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.b.a(bzVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.q qVar, com.baidu.tieba.card.b.a aVar) {
        aVar.TU().onBindDataToView(qVar);
        aVar.TU().onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        ca.To().a(new as("c10718").aa("obj_id", String.valueOf(qVar.byj)));
        return aVar.getView();
    }
}
