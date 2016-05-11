package com.baidu.tieba.card.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, C0054a> {
    private TbPageContext<?> DV;
    private c aSA;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.Oq);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: e */
    public C0054a b(ViewGroup viewGroup) {
        this.aSA = new c(this.DV);
        return new C0054a(this.aSA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, C0054a c0054a) {
        if (c0054a == null || c0054a.aSB == null) {
            return null;
        }
        c0054a.aSB.a(bVar);
        return c0054a.getView();
    }

    /* renamed from: com.baidu.tieba.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0054a extends y.a {
        public c aSB;

        public C0054a(c cVar) {
            super(cVar.getView());
            this.aSB = cVar;
        }
    }
}
