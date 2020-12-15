package com.baidu.tieba.frs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.p;
import com.baidu.tieba.frs.k;
/* loaded from: classes22.dex */
public class a extends k<n, C0740a> {
    private boolean jgG;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.jgG = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public C0740a c(ViewGroup viewGroup) {
        p pVar = new p(this.mPageContext);
        pVar.setStatKey(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C0740a(pVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, C0740a c0740a) {
        TiebaStatic.log(new ar(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (nVar != null) {
            nVar.locate = i + 1;
            c0740a.jgH.yk(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0740a.jgH.showBottomLine(this.jgG);
            c0740a.jgH.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0740a.jgH.a(nVar);
        return c0740a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0740a extends af.a {
        public p jgH;

        public C0740a(p pVar) {
            super(pVar.getView());
            this.jgH = pVar;
        }
    }
}
