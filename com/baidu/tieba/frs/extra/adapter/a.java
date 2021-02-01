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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.o;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class a extends k<n, C0724a> {
    private boolean jug;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.jug = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bz */
    public C0724a e(ViewGroup viewGroup) {
        o oVar = new o(this.mPageContext);
        oVar.setStatKey(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C0724a(oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, C0724a c0724a) {
        TiebaStatic.log(new ar(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (nVar != null) {
            nVar.locate = i + 1;
            c0724a.juh.xb(l.dip2px(this.mPageContext.getPageActivity(), 7.0f));
            c0724a.juh.showBottomLine(this.jug);
            c0724a.juh.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        c0724a.juh.a(nVar);
        return c0724a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.frs.extra.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0724a extends TypeAdapter.ViewHolder {
        public o juh;

        public C0724a(o oVar) {
            super(oVar.getView());
            this.juh = oVar;
        }
    }
}
