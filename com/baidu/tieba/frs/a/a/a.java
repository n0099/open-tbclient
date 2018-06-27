package com.baidu.tieba.frs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.q;
import com.baidu.tieba.frs.h;
/* loaded from: classes3.dex */
public class a extends h<n, C0152a> {
    private boolean dti;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dti = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public C0152a onCreateViewHolder(ViewGroup viewGroup) {
        q qVar = new q(this.mPageContext);
        qVar.setStatKey(null, "c10819");
        return new C0152a(qVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, C0152a c0152a) {
        TiebaStatic.log(new an("c10835"));
        if (nVar != null) {
            nVar.btk = i + 1;
            c0152a.dtj.iI(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0152a.dtj.showBottomLine(this.dti);
            c0152a.dtj.d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0152a.dtj.a(nVar);
        return c0152a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0152a extends q.a {
        public com.baidu.tieba.card.q dtj;

        public C0152a(com.baidu.tieba.card.q qVar) {
            super(qVar.getView());
            this.dtj = qVar;
        }
    }
}
