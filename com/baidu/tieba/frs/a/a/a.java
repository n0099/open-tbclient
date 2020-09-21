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
import com.baidu.tieba.frs.k;
/* loaded from: classes21.dex */
public class a extends k<o, C0677a> {
    private boolean inK;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.inK = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public C0677a c(ViewGroup viewGroup) {
        com.baidu.tieba.card.o oVar = new com.baidu.tieba.card.o(this.mPageContext);
        oVar.setStatKey(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C0677a(oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, C0677a c0677a) {
        TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (oVar != null) {
            oVar.locate = i + 1;
            c0677a.inL.vU(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0677a.inL.showBottomLine(this.inK);
            c0677a.inL.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0677a.inL.a(oVar);
        return c0677a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C0677a extends af.a {
        public com.baidu.tieba.card.o inL;

        public C0677a(com.baidu.tieba.card.o oVar) {
            super(oVar.getView());
            this.inL = oVar;
        }
    }
}
