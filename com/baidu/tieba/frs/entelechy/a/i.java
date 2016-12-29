package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.at;
import com.baidu.tieba.card.cb;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<at, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.am>> implements com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GO;
    private com.baidu.tieba.frs.entelechy.view.am bER;
    private cb bES;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, at atVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.am> aVar) {
        return a2(i, view, viewGroup, atVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bES = new j(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a a(ViewGroup viewGroup) {
        this.bER = new com.baidu.tieba.frs.entelechy.view.am(this.GO);
        this.bER.i(this.GO.getUniqueId());
        return new com.baidu.tieba.card.a.a(this.bER);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, at atVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Po() == null) {
            return null;
        }
        aVar.Po().onBindDataToView(atVar);
        aVar.Po().setOnSubCardOnClickListenner(this.bES);
        com.baidu.tieba.frs.g.b.abq().a(bMV, atVar);
        return aVar.getView();
    }
}
