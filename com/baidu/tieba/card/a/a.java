package com.baidu.tieba.card.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, C0054a> {
    private TbPageContext<?> GM;
    private c bcL;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.Ro);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d */
    public C0054a a(ViewGroup viewGroup) {
        this.bcL = new c(this.GM);
        return new C0054a(this.bcL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, C0054a c0054a) {
        if (c0054a == null || c0054a.bcM == null) {
            return null;
        }
        c0054a.bcM.onBindDataToView(bVar);
        return c0054a.getView();
    }

    /* renamed from: com.baidu.tieba.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0054a extends y.a {
        public c bcM;

        public C0054a(c cVar) {
            super(cVar.getView());
            this.bcM = cVar;
        }
    }
}
