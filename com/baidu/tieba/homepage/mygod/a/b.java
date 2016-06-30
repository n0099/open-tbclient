package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.g;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.k;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<g, a> {
    private TbPageContext<?> Ea;
    public BdUniqueId aSq;
    private bx<g> bJf;
    private k cqc;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJf = new c(this);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public a a(ViewGroup viewGroup) {
        this.cqc = new k(this.Ea);
        this.cqc.aRZ = false;
        this.cqc.j(this.aSq);
        return new a(this.cqc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        aVar.cqe.a(gVar);
        aVar.cqe.a(this.bJf);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public k cqe;

        public a(k kVar) {
            super(kVar.getView());
            this.cqe = kVar;
        }
    }
}
