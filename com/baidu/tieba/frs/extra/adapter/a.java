package com.baidu.tieba.frs.extra.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.o;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class a extends k<n, C0734a> {
    private boolean jtg;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.jtg = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bz */
    public C0734a e(ViewGroup viewGroup) {
        o oVar = new o(this.mPageContext);
        oVar.setStatKey(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C0734a(oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, C0734a c0734a) {
        TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (nVar != null) {
            nVar.locate = i + 1;
            c0734a.jth.yy(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0734a.jth.showBottomLine(this.jtg);
            c0734a.jth.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0734a.jth.a(nVar);
        return c0734a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.extra.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0734a extends TypeAdapter.ViewHolder {
        public o jth;

        public C0734a(o oVar) {
            super(oVar.getView());
            this.jth = oVar;
        }
    }
}
