package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.k;
import com.baidu.tieba.card.cj;
import com.baidu.tieba.card.t;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<k, a> {
    private TbPageContext<?> ND;
    private cj bKe;
    private t bKh;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), k.aVM);
        this.bKe = new e(this);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public a b(ViewGroup viewGroup) {
        this.bKh = new t(this.ND);
        this.bKh.i(this.ND.getUniqueId());
        this.bKh.a(this.bKe);
        return new a(this.bKh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, a aVar) {
        if (aVar == null || aVar.bKj == null) {
            return null;
        }
        aVar.bKj.a(kVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        public t bKj;

        public a(t tVar) {
            super(tVar.getView());
            this.bKj = tVar;
        }
    }
}
