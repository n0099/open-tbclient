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
public class a extends h<n, C0321a> {
    private boolean fGT;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.fGT = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public C0321a onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.mPageContext);
        pVar.setStatKey(null, "c10819");
        return new C0321a(pVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, C0321a c0321a) {
        TiebaStatic.log(new an("c10835"));
        if (nVar != null) {
            nVar.locate = i + 1;
            c0321a.fGU.pK(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0321a.fGU.showBottomLine(this.fGT);
            c0321a.fGU.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0321a.fGU.a(nVar);
        return c0321a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0321a extends v.a {
        public p fGU;

        public C0321a(p pVar) {
            super(pVar.getView());
            this.fGU = pVar;
        }
    }
}
