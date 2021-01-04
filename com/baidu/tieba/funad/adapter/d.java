package com.baidu.tieba.funad.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.o;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<bz, FunAdEmptyHolder> implements k, o {
    private BaseFragmentActivity iJr;

    public d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.iJr = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public FunAdEmptyHolder e(ViewGroup viewGroup) {
        View view = new View(this.iJr.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new FunAdEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bz bzVar, FunAdEmptyHolder funAdEmptyHolder) {
        return funAdEmptyHolder.getView();
    }

    @Override // com.baidu.tieba.recapp.o
    public void setIsFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.recapp.k
    public void onPause() {
    }

    @Override // com.baidu.tieba.recapp.k
    public void onResume() {
    }

    @Override // com.baidu.tieba.recapp.k
    public void onDestroy() {
    }
}
