package com.baidu.tieba.addresslist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnFocusChangeListener {
    final /* synthetic */ QuickSearchActivity azu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(QuickSearchActivity quickSearchActivity) {
        this.azu = quickSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.n.c(this.azu.getPageContext().getPageActivity(), view);
        }
    }
}
