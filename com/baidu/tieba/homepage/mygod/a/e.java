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
    private TbPageContext<?> ajU;
    private cf<com.baidu.tieba.card.data.f> bUw;
    public BdUniqueId bbE;
    private com.baidu.tieba.card.d cyx;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bUw = new f(this);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cyx = new com.baidu.tieba.card.d(this.ajU);
        this.cyx.i(this.bbE);
        return new a(this.cyx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        aVar.cyz.onBindDataToView(gVar);
        if (aVar.cyz.TH() != null) {
            aVar.cyz.TH().setOnSubCardOnClickListenner(this.bUw);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.d cyz;

        public a(com.baidu.tieba.card.d dVar) {
            super(dVar.getView());
            this.cyz = dVar;
        }
    }
}
