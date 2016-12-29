package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.data.g;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, a> {
    private TbPageContext<?> GO;
    private cb<com.baidu.tieba.card.data.f> bES;
    public BdUniqueId bbl;
    private com.baidu.tieba.card.d cpf;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bES = new f(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: W */
    public a a(ViewGroup viewGroup) {
        this.cpf = new com.baidu.tieba.card.d(this.GO);
        this.cpf.i(this.bbl);
        return new a(this.cpf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        aVar.cph.onBindDataToView(gVar);
        if (aVar.cph.Or() != null) {
            aVar.cph.Or().setOnSubCardOnClickListenner(this.bES);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.d cph;

        public a(com.baidu.tieba.card.d dVar) {
            super(dVar.getView());
            this.cph = dVar;
        }
    }
}
