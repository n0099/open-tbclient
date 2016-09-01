package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.r, a> {
    private TbPageContext<?> GM;

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.r.bcC);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public a a(ViewGroup viewGroup) {
        cc ccVar = new cc(this.GM);
        ccVar.t("c10718", "c10719", "c10742");
        return new a(ccVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.r rVar, a aVar) {
        aVar.cGo.onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.cGo.onBindDataToView(rVar);
        cd.NI().b(new ay("c10718").ab("obj_id", String.valueOf(rVar.bcD)));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public cc cGo;

        public a(cc ccVar) {
            super(ccVar.getView());
            this.cGo = ccVar;
        }
    }
}
