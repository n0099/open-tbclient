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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.o;
import com.baidu.tieba.frs.j;
/* loaded from: classes16.dex */
public class a extends j<n, C0629a> {
    private boolean hSu;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.hSu = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public C0629a b(ViewGroup viewGroup) {
        o oVar = new o(this.mPageContext);
        oVar.setStatKey(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C0629a(oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, C0629a c0629a) {
        TiebaStatic.log(new ap(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (nVar != null) {
            nVar.locate = i + 1;
            c0629a.hSv.tg(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0629a.hSv.showBottomLine(this.hSu);
            c0629a.hSv.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0629a.hSv.a(nVar);
        return c0629a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0629a extends ad.a {
        public o hSv;

        public C0629a(o oVar) {
            super(oVar.getView());
            this.hSv = oVar;
        }
    }
}
