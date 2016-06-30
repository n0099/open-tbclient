package com.baidu.tieba.card.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, C0052a> {
    private TbPageContext<?> Ea;
    private c aVV;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.Op);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d */
    public C0052a a(ViewGroup viewGroup) {
        this.aVV = new c(this.Ea);
        return new C0052a(this.aVV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, C0052a c0052a) {
        if (c0052a == null || c0052a.aVW == null) {
            return null;
        }
        c0052a.aVW.a(bVar);
        return c0052a.getView();
    }

    /* renamed from: com.baidu.tieba.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0052a extends y.a {
        public c aVW;

        public C0052a(c cVar) {
            super(cVar.getView());
            this.aVW = cVar;
        }
    }
}
