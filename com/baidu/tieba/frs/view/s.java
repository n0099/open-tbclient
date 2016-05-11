package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.bu;
import com.baidu.tieba.frs.bw;
/* loaded from: classes.dex */
public class s extends bw<com.baidu.tieba.card.a.p, a> {
    private BaseActivity<?> bek;
    private boolean bwk;

    public s(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseActivity, bdUniqueId);
        this.bek = baseActivity;
        this.bwk = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: T */
    public a b(ViewGroup viewGroup) {
        bu buVar = new bu(this.bek.getPageContext());
        buVar.ax(null, "c10819");
        return new a(buVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.p pVar, a aVar) {
        TiebaStatic.log(new aw("c10835"));
        if (pVar != null) {
            pVar.aSq = i + 1;
            aVar.bwl.fw(com.baidu.adp.lib.util.k.dip2px(this.bek.getActivity(), 7.0f));
            aVar.bwl.showBottomLine(this.bwk);
            aVar.bwl.d(this.bek.getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
        }
        aVar.bwl.a(pVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bu bwl;

        public a(bu buVar) {
            super(buVar.getView());
            this.bwl = buVar;
        }
    }
}
