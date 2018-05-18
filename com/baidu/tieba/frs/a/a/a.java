package com.baidu.tieba.frs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.q;
import com.baidu.tieba.frs.f;
/* loaded from: classes3.dex */
public class a extends f<n, C0135a> {
    private boolean dgK;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dgK = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ay */
    public C0135a onCreateViewHolder(ViewGroup viewGroup) {
        q qVar = new q(this.mPageContext);
        qVar.setStatKey(null, "c10819");
        return new C0135a(qVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n nVar, C0135a c0135a) {
        TiebaStatic.log(new al("c10835"));
        if (nVar != null) {
            nVar.bjG = i + 1;
            c0135a.dgL.iK(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0135a.dgL.showBottomLine(this.dgK);
            c0135a.dgL.d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0135a.dgL.a(nVar);
        return c0135a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0135a extends q.a {
        public com.baidu.tieba.card.q dgL;

        public C0135a(com.baidu.tieba.card.q qVar) {
            super(qVar.getView());
            this.dgL = qVar;
        }
    }
}
