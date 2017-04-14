package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.f, a> {
    private TbPageContext<?> ajT;
    private cf<com.baidu.tieba.card.data.f> bSf;
    public BdUniqueId baI;
    private com.baidu.tieba.card.e cwd;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bSf = new d(this);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cwd = new com.baidu.tieba.card.e(this.ajT);
        this.cwd.brs = false;
        this.cwd.j(this.baI);
        return new a(this.cwd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.f fVar, a aVar) {
        aVar.cwf.onBindDataToView(fVar);
        aVar.cwf.setOnSubCardOnClickListenner(this.bSf);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.e cwf;

        public a(com.baidu.tieba.card.e eVar) {
            super(eVar.getView());
            this.cwf = eVar;
        }
    }
}
