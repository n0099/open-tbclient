package com.baidu.tieba.frs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.o;
import com.baidu.tieba.frs.j;
/* loaded from: classes9.dex */
public class a extends j<n, C0620a> {
    private boolean hMt;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.hMt = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public C0620a b(ViewGroup viewGroup) {
        o oVar = new o(this.mPageContext);
        oVar.setStatKey(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C0620a(oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, C0620a c0620a) {
        TiebaStatic.log(new ao(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (nVar != null) {
            nVar.locate = i + 1;
            c0620a.hMu.sO(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0620a.hMu.showBottomLine(this.hMt);
            c0620a.hMu.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0620a.hMu.a(nVar);
        return c0620a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0620a extends ad.a {
        public o hMu;

        public C0620a(o oVar) {
            super(oVar.getView());
            this.hMu = oVar;
        }
    }
}
