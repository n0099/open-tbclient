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
    private TbPageContext<?> ajF;
    private cf<com.baidu.tieba.card.data.f> bSr;
    public BdUniqueId baP;
    private com.baidu.tieba.card.d cxG;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bSr = new f(this);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cxG = new com.baidu.tieba.card.d(this.ajF);
        this.cxG.i(this.baP);
        return new a(this.cxG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        aVar.cxI.onBindDataToView(gVar);
        if (aVar.cxI.Sh() != null) {
            aVar.cxI.Sh().setOnSubCardOnClickListenner(this.bSr);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.d cxI;

        public a(com.baidu.tieba.card.d dVar) {
            super(dVar.getView());
            this.cxI = dVar;
        }
    }
}
