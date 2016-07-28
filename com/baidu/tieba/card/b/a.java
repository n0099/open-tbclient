package com.baidu.tieba.card.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, C0053a> {
    private TbPageContext<?> EA;
    private c aWT;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.OB);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d */
    public C0053a a(ViewGroup viewGroup) {
        this.aWT = new c(this.EA);
        return new C0053a(this.aWT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, C0053a c0053a) {
        if (c0053a == null || c0053a.aWU == null) {
            return null;
        }
        c0053a.aWU.a(bVar);
        return c0053a.getView();
    }

    /* renamed from: com.baidu.tieba.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0053a extends y.a {
        public c aWU;

        public C0053a(c cVar) {
            super(cVar.getView());
            this.aWU = cVar;
        }
    }
}
