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
public class a extends g<o, C0148a> {
    private boolean dNg;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dNg = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aC */
    public C0148a onCreateViewHolder(ViewGroup viewGroup) {
        m mVar = new m(this.mPageContext);
        mVar.aI(null, "c10819");
        return new C0148a(mVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, o oVar, C0148a c0148a) {
        TiebaStatic.log(new ak("c10835"));
        if (oVar != null) {
            oVar.bZz = i + 1;
            c0148a.dNh.lA(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0148a.dNh.showBottomLine(this.dNg);
            c0148a.dNh.d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0148a.dNh.a(oVar);
        return c0148a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0148a extends r.a {
        public m dNh;

        public C0148a(m mVar) {
            super(mVar.getView());
            this.dNh = mVar;
        }
    }
}
