package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.f, a> {
    private TbPageContext<?> ajF;
    private cf<com.baidu.tieba.card.data.f> bSr;
    public BdUniqueId baP;
    private com.baidu.tieba.card.e cxD;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bSr = new d(this);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cxD = new com.baidu.tieba.card.e(this.ajF);
        this.cxD.brA = false;
        this.cxD.j(this.baP);
        return new a(this.cxD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.f fVar, a aVar) {
        aVar.cxF.onBindDataToView(fVar);
        aVar.cxF.setOnSubCardOnClickListenner(this.bSr);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.e cxF;

        public a(com.baidu.tieba.card.e eVar) {
            super(eVar.getView());
            this.cxF = eVar;
        }
    }
}
