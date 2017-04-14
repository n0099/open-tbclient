package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.data.g;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, a> {
    private TbPageContext<?> ajT;
    private cf<com.baidu.tieba.card.data.f> bSf;
    public BdUniqueId baI;
    private com.baidu.tieba.card.d cwg;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bSf = new f(this);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cwg = new com.baidu.tieba.card.d(this.ajT);
        this.cwg.i(this.baI);
        return new a(this.cwg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        aVar.cwi.onBindDataToView(gVar);
        if (aVar.cwi.SF() != null) {
            aVar.cwi.SF().setOnSubCardOnClickListenner(this.bSf);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.d cwi;

        public a(com.baidu.tieba.card.d dVar) {
            super(dVar.getView());
            this.cwi = dVar;
        }
    }
}
