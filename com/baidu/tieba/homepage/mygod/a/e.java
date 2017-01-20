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
    private TbPageContext<?> FY;
    public BdUniqueId aUC;
    private cf<com.baidu.tieba.card.data.f> bLl;
    private com.baidu.tieba.card.d cwh;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bLl = new f(this);
        this.FY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cwh = new com.baidu.tieba.card.d(this.FY);
        this.cwh.i(this.aUC);
        return new a(this.cwh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        aVar.cwj.onBindDataToView(gVar);
        if (aVar.cwj.Rk() != null) {
            aVar.cwj.Rk().setOnSubCardOnClickListenner(this.bLl);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.d cwj;

        public a(com.baidu.tieba.card.d dVar) {
            super(dVar.getView());
            this.cwj = dVar;
        }
    }
}
