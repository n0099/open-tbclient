package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.r, a> {
    private TbPageContext<?> GO;

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.r.bfV);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public a a(ViewGroup viewGroup) {
        bw bwVar = new bw(this.GO);
        bwVar.t("c10718", "c10719", "c10742");
        return new a(bwVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.r rVar, a aVar) {
        aVar.cMn.onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.cMn.onBindDataToView(rVar);
        bx.Pl().a(new av("c10718").ab("obj_id", String.valueOf(rVar.bfW)));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bw cMn;

        public a(bw bwVar) {
            super(bwVar.getView());
            this.cMn = bwVar;
        }
    }
}
