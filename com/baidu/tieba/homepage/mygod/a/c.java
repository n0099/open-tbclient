package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.f, a> {
    private TbPageContext<?> ajU;
    private cf<com.baidu.tieba.card.data.f> bUw;
    public BdUniqueId bbE;
    private com.baidu.tieba.card.e cyu;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bUw = new d(this);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cyu = new com.baidu.tieba.card.e(this.ajU);
        this.cyu.btK = false;
        this.cyu.j(this.bbE);
        return new a(this.cyu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.f fVar, a aVar) {
        aVar.cyw.onBindDataToView(fVar);
        aVar.cyw.setOnSubCardOnClickListenner(this.bUw);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.e cyw;

        public a(com.baidu.tieba.card.e eVar) {
            super(eVar.getView());
            this.cyw = eVar;
        }
    }
}
