package com.baidu.tieba.frs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.o;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.g;
/* loaded from: classes3.dex */
public class a extends g<o, C0149a> {
    private boolean dMZ;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dMZ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aC */
    public C0149a onCreateViewHolder(ViewGroup viewGroup) {
        m mVar = new m(this.mPageContext);
        mVar.aI(null, "c10819");
        return new C0149a(mVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, o oVar, C0149a c0149a) {
        TiebaStatic.log(new ak("c10835"));
        if (oVar != null) {
            oVar.bZq = i + 1;
            c0149a.dNa.lA(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0149a.dNa.showBottomLine(this.dMZ);
            c0149a.dNa.d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0149a.dNa.a(oVar);
        return c0149a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0149a extends r.a {
        public m dNa;

        public C0149a(m mVar) {
            super(mVar.getView());
            this.dNa = mVar;
        }
    }
}
