package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.bz;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.h>> {
    private TbPageContext<?> GO;
    private BdUniqueId bbl;
    private com.baidu.tieba.card.h cqO;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.h> aVar) {
        return a2(i, view, viewGroup, bVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.crQ);
        this.GO = tbPageContext;
        this.cqO = new com.baidu.tieba.card.h(this.GO);
        this.cqO.j("c10714", "c10739", "c10712", "c10738");
        this.cqO.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bbl = bdUniqueId;
        if (this.cqO != null) {
            this.cqO.i(this.bbl);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.Po() == null) {
            return null;
        }
        aVar.Po().onBindDataToView(bVar);
        bz.OH().a(new at("c10714").ab("obj_param3", ap.OA()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a a(ViewGroup viewGroup) {
        if (this.cqO == null) {
            this.cqO = new com.baidu.tieba.card.h(this.GO);
            this.cqO.i(this.bbl);
            this.cqO.j("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.cqO);
    }

    public void onChangeSkinType(int i) {
        if (this.cqO != null) {
            this.cqO.onChangeSkinType(this.GO, i);
        }
    }
}
