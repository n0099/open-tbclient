package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.data.g;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<g, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYW;
    private cd<g> bVT;
    private com.baidu.tieba.card.e cEu;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVT = new d(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public a a(ViewGroup viewGroup) {
        this.cEu = new com.baidu.tieba.card.e(this.GM);
        this.cEu.aYF = false;
        this.cEu.j(this.aYW);
        return new a(this.cEu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        aVar.cEw.onBindDataToView(gVar);
        aVar.cEw.setOnSubCardOnClickListenner(this.bVT);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.e cEw;

        public a(com.baidu.tieba.card.e eVar) {
            super(eVar.getView());
            this.cEw = eVar;
        }
    }
}
