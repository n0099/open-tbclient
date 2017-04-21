package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cc;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.s, com.baidu.tieba.card.b.a<cb>> {
    private TbPageContext<?> ajU;

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.s.byi);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        cb cbVar = new cb(this.ajU);
        cbVar.q("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.b.a(cbVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.s sVar, com.baidu.tieba.card.b.a aVar) {
        aVar.UB().onBindDataToView(sVar);
        aVar.UB().onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        cc.TV().a(new as("c10718").aa("obj_id", String.valueOf(sVar.byj)));
        return aVar.getView();
    }
}
