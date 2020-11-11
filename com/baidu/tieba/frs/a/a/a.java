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
public class a extends k<o, C0725a> {
    private boolean iUW;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.iUW = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public C0725a c(ViewGroup viewGroup) {
        p pVar = new p(this.mPageContext);
        pVar.setStatKey(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C0725a(pVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, C0725a c0725a) {
        TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (oVar != null) {
            oVar.locate = i + 1;
            c0725a.iUX.xg(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0725a.iUX.showBottomLine(this.iUW);
            c0725a.iUX.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0725a.iUX.a(oVar);
        return c0725a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0725a extends af.a {
        public p iUX;

        public C0725a(p pVar) {
            super(pVar.getView());
            this.iUX = pVar;
        }
    }
}
