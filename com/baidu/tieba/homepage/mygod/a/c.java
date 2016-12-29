package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cb;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.f, a> {
    private TbPageContext<?> GO;
    private cb<com.baidu.tieba.card.data.f> bES;
    public BdUniqueId bbl;
    private com.baidu.tieba.card.e cpc;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bES = new d(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public a a(ViewGroup viewGroup) {
        this.cpc = new com.baidu.tieba.card.e(this.GO);
        this.cpc.baU = false;
        this.cpc.j(this.bbl);
        return new a(this.cpc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.f fVar, a aVar) {
        aVar.cpe.onBindDataToView(fVar);
        aVar.cpe.setOnSubCardOnClickListenner(this.bES);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.e cpe;

        public a(com.baidu.tieba.card.e eVar) {
            super(eVar.getView());
            this.cpe = eVar;
        }
    }
}
