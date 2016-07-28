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
    private TbPageContext<?> EA;
    public BdUniqueId aTm;
    private bx<g> bKK;
    private k csH;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bKK = new c(this);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public a a(ViewGroup viewGroup) {
        this.csH = new k(this.EA);
        this.csH.aST = false;
        this.csH.j(this.aTm);
        return new a(this.csH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        aVar.csJ.a(gVar);
        aVar.csJ.a(this.bKK);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public k csJ;

        public a(k kVar) {
            super(kVar.getView());
            this.csJ = kVar;
        }
    }
}
