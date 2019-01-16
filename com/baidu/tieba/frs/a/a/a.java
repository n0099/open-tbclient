package com.baidu.tieba.frs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.q;
import com.baidu.tieba.frs.h;
/* loaded from: classes3.dex */
public class a extends h<n, C0219a> {
    private boolean dVH;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dVH = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ay */
    public C0219a onCreateViewHolder(ViewGroup viewGroup) {
        q qVar = new q(this.mPageContext);
        qVar.setStatKey(null, "c10819");
        return new C0219a(qVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, C0219a c0219a) {
        TiebaStatic.log(new am("c10835"));
        if (nVar != null) {
            nVar.locate = i + 1;
            c0219a.dVI.kM(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0219a.dVI.showBottomLine(this.dVH);
            c0219a.dVI.d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0219a.dVI.a(nVar);
        return c0219a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0219a extends q.a {
        public com.baidu.tieba.card.q dVI;

        public C0219a(com.baidu.tieba.card.q qVar) {
            super(qVar.getView());
            this.dVI = qVar;
        }
    }
}
