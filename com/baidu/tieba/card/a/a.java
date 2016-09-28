package com.baidu.tieba.card.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, C0057a> {
    private TbPageContext<?> GM;
    private c bdf;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.Ru);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d */
    public C0057a a(ViewGroup viewGroup) {
        this.bdf = new c(this.GM);
        return new C0057a(this.bdf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, C0057a c0057a) {
        if (c0057a == null || c0057a.bdg == null) {
            return null;
        }
        c0057a.bdg.onBindDataToView(bVar);
        return c0057a.getView();
    }

    /* renamed from: com.baidu.tieba.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0057a extends y.a {
        public c bdg;

        public C0057a(c cVar) {
            super(cVar.getView());
            this.bdg = cVar;
        }
    }
}
