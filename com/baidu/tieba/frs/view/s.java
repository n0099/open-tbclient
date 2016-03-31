package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.frs.bx;
/* loaded from: classes.dex */
public class s extends bx<com.baidu.tieba.card.a.x, a> {
    private BaseActivity<?> bix;

    public s(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bix = baseActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public a b(ViewGroup viewGroup) {
        cc ccVar = new cc(this.bix.getPageContext());
        ccVar.at(null, "c10819");
        return new a(ccVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.x xVar, a aVar) {
        TiebaStatic.log(new aw("c10835"));
        if (xVar != null) {
            xVar.aWw = i + 1;
            aVar.bwB.fO(com.baidu.adp.lib.util.k.dip2px(this.bix.getActivity(), 7.0f));
            aVar.bwB.cb(false);
            aVar.bwB.d(this.bix.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        aVar.bwB.a(xVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public cc bwB;

        public a(cc ccVar) {
            super(ccVar.getView());
            this.bwB = ccVar;
        }
    }
}
