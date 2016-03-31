package com.baidu.tieba.card.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, C0060a> {
    private TbPageContext<?> ND;
    private c aWG;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.TC);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public C0060a b(ViewGroup viewGroup) {
        this.aWG = new c(this.ND);
        return new C0060a(this.aWG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, C0060a c0060a) {
        if (c0060a == null || c0060a.aWH == null) {
            return null;
        }
        c0060a.aWH.a(bVar);
        return c0060a.getView();
    }

    /* renamed from: com.baidu.tieba.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0060a extends x.a {
        public c aWH;

        public C0060a(c cVar) {
            super(cVar.getView());
            this.aWH = cVar;
        }
    }
}
