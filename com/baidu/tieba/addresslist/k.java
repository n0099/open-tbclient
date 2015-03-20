package com.baidu.tieba.addresslist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnFocusChangeListener {
    final /* synthetic */ QuickSearchActivity axA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(QuickSearchActivity quickSearchActivity) {
        this.axA = quickSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.n.c(this.axA.getPageContext().getPageActivity(), view);
        }
    }
}
