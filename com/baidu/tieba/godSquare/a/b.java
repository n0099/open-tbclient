package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.k;
import com.baidu.tieba.card.cj;
import com.baidu.tieba.card.s;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<k, a> {
    private TbPageContext<?> ND;
    private s bKd;
    private cj bKe;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.aVL);
        this.bKe = new c(this);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public a b(ViewGroup viewGroup) {
        this.bKd = new s(this.ND);
        this.bKd.i(this.ND.getUniqueId());
        this.bKd.a(this.bKe);
        return new a(this.bKd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, a aVar) {
        if (aVar == null || aVar.bKg == null) {
            return null;
        }
        aVar.bKg.a(kVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        public s bKg;

        public a(s sVar) {
            super(sVar.getView());
            this.bKg = sVar;
        }
    }
}
