package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.by;
import com.baidu.tieba.card.bz;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.r, com.baidu.tieba.card.a.a<by>> {
    private TbPageContext<?> GO;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.r rVar, com.baidu.tieba.card.a.a<by> aVar) {
        return a2(i, view, viewGroup, rVar, (com.baidu.tieba.card.a.a) aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.r.bfk);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a a(ViewGroup viewGroup) {
        by byVar = new by(this.GO);
        byVar.t("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.a.a(byVar);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.r rVar, com.baidu.tieba.card.a.a aVar) {
        aVar.Po().onBindDataToView(rVar);
        aVar.Po().onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        bz.OH().a(new at("c10718").ab("obj_id", String.valueOf(rVar.bfl)));
        return aVar.getView();
    }
}
