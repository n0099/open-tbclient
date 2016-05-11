package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.h;
import com.baidu.tieba.card.by;
import com.baidu.tieba.card.n;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<h, a> {
    private TbPageContext<?> DV;
    private n bKj;
    private by boZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.aRI);
        this.boZ = new c(this);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public a b(ViewGroup viewGroup) {
        this.bKj = new n(this.DV);
        this.bKj.i(this.DV.getUniqueId());
        this.bKj.a(this.boZ);
        return new a(this.bKj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.bKl == null) {
            return null;
        }
        aVar.bKl.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public n bKl;

        public a(n nVar) {
            super(nVar.getView());
            this.bKl = nVar;
        }
    }
}
