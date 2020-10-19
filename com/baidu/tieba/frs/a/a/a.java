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
/* loaded from: classes22.dex */
public class a extends k<o, C0695a> {
    private boolean iCD;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.iCD = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public C0695a c(ViewGroup viewGroup) {
        com.baidu.tieba.card.o oVar = new com.baidu.tieba.card.o(this.mPageContext);
        oVar.setStatKey(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C0695a(oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, C0695a c0695a) {
        TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (oVar != null) {
            oVar.locate = i + 1;
            c0695a.iCE.wA(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0695a.iCE.showBottomLine(this.iCD);
            c0695a.iCE.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0695a.iCE.a(oVar);
        return c0695a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0695a extends af.a {
        public com.baidu.tieba.card.o iCE;

        public C0695a(com.baidu.tieba.card.o oVar) {
            super(oVar.getView());
            this.iCE = oVar;
        }
    }
}
