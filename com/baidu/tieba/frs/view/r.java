package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.av;
import com.baidu.tieba.frs.bv;
/* loaded from: classes.dex */
public class r extends bv<com.baidu.tieba.card.a.u, a> {
    private BaseActivity<?> bdK;

    public r(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bdK = baseActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: M */
    public a b(ViewGroup viewGroup) {
        av avVar = new av(this.bdK.getPageContext());
        avVar.an(null, "c10819");
        return new a(avVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.u uVar, a aVar) {
        if (uVar != null) {
            uVar.aSK = i + 1;
            aVar.brt.fA(com.baidu.adp.lib.util.k.dip2px(this.bdK.getActivity(), 7.0f));
            aVar.brt.bS(false);
            aVar.brt.d(this.bdK.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        aVar.brt.a(uVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public av brt;

        public a(av avVar) {
            super(avVar.getView());
            this.brt = avVar;
        }
    }
}
