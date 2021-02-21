package com.baidu.tieba.funad.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tieba.recapp.l;
import com.baidu.tieba.recapp.p;
/* loaded from: classes5.dex */
public class b extends com.baidu.adp.widget.ListView.a<ca, FunAdEmptyHolder> implements l, p {
    private BaseFragmentActivity iKH;

    public b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.iKH = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public FunAdEmptyHolder e(ViewGroup viewGroup) {
        View view = new View(this.iKH.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new FunAdEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, FunAdEmptyHolder funAdEmptyHolder) {
        return funAdEmptyHolder.getView();
    }

    @Override // com.baidu.tieba.recapp.p
    public void setIsFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.recapp.l
    public void onPause() {
    }

    @Override // com.baidu.tieba.recapp.l
    public void onResume() {
    }

    @Override // com.baidu.tieba.recapp.l
    public void onDestroy() {
    }
}
