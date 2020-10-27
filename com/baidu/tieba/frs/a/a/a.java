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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.o;
import com.baidu.tieba.card.p;
import com.baidu.tieba.frs.k;
/* loaded from: classes22.dex */
public class a extends k<o, C0711a> {
    private boolean iOZ;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.iOZ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public C0711a c(ViewGroup viewGroup) {
        p pVar = new p(this.mPageContext);
        pVar.setStatKey(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C0711a(pVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, C0711a c0711a) {
        TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (oVar != null) {
            oVar.locate = i + 1;
            c0711a.iPa.wT(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0711a.iPa.showBottomLine(this.iOZ);
            c0711a.iPa.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0711a.iPa.a(oVar);
        return c0711a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0711a extends af.a {
        public p iPa;

        public C0711a(p pVar) {
            super(pVar.getView());
            this.iPa = pVar;
        }
    }
}
