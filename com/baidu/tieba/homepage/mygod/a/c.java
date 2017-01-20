package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.f, a> {
    private TbPageContext<?> FY;
    public BdUniqueId aUC;
    private cf<com.baidu.tieba.card.data.f> bLl;
    private com.baidu.tieba.card.e cwe;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bLl = new d(this);
        this.FY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cwe = new com.baidu.tieba.card.e(this.FY);
        this.cwe.bkI = false;
        this.cwe.j(this.aUC);
        return new a(this.cwe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.f fVar, a aVar) {
        aVar.cwg.onBindDataToView(fVar);
        aVar.cwg.setOnSubCardOnClickListenner(this.bLl);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.e cwg;

        public a(com.baidu.tieba.card.e eVar) {
            super(eVar.getView());
            this.cwg = eVar;
        }
    }
}
