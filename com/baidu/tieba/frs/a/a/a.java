package com.baidu.tieba.frs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.p;
import com.baidu.tieba.frs.h;
/* loaded from: classes4.dex */
public class a extends h<n, C0310a> {
    private boolean fEq;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.fEq = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public C0310a onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.mPageContext);
        pVar.setStatKey(null, "c10819");
        return new C0310a(pVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, C0310a c0310a) {
        TiebaStatic.log(new an("c10835"));
        if (nVar != null) {
            nVar.locate = i + 1;
            c0310a.fEr.pF(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0310a.fEr.showBottomLine(this.fEq);
            c0310a.fEr.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0310a.fEr.a(nVar);
        return c0310a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0310a extends v.a {
        public p fEr;

        public C0310a(p pVar) {
            super(pVar.getView());
            this.fEr = pVar;
        }
    }
}
