package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.card.cb;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.r, a> {
    private TbPageContext<?> GM;

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.r.bcW);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public a a(ViewGroup viewGroup) {
        ca caVar = new ca(this.GM);
        caVar.t("c10718", "c10719", "c10742");
        return new a(caVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.r rVar, a aVar) {
        aVar.cHc.onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.cHc.onBindDataToView(rVar);
        cb.Oj().a(new ax("c10718").ab("obj_id", String.valueOf(rVar.bcX)));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public ca cHc;

        public a(ca caVar) {
            super(caVar.getView());
            this.cHc = caVar;
        }
    }
}
