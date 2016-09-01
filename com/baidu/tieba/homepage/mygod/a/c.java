package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.data.g;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<g, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYu;
    private cf<g> bVU;
    private com.baidu.tieba.card.e cDQ;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVU = new d(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public a a(ViewGroup viewGroup) {
        this.cDQ = new com.baidu.tieba.card.e(this.GM);
        this.cDQ.aYb = false;
        this.cDQ.j(this.aYu);
        return new a(this.cDQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        aVar.cDS.onBindDataToView(gVar);
        aVar.cDS.setOnSubCardOnClickListenner(this.bVU);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.e cDS;

        public a(com.baidu.tieba.card.e eVar) {
            super(eVar.getView());
            this.cDS = eVar;
        }
    }
}
