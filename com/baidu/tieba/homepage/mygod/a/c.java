package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.data.g;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<g, a> {
    private TbPageContext<?> GO;
    private bz<g> bZe;
    public BdUniqueId bcf;
    private com.baidu.tieba.card.e cJH;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bZe = new d(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public a a(ViewGroup viewGroup) {
        this.cJH = new com.baidu.tieba.card.e(this.GO);
        this.cJH.bbO = false;
        this.cJH.j(this.bcf);
        return new a(this.cJH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        aVar.cJJ.onBindDataToView(gVar);
        aVar.cJJ.setOnSubCardOnClickListenner(this.bZe);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.e cJJ;

        public a(com.baidu.tieba.card.e eVar) {
            super(eVar.getView());
            this.cJJ = eVar;
        }
    }
}
