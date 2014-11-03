package com.baidu.tieba.addresslist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnFocusChangeListener {
    final /* synthetic */ QuickSearchActivity agY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(QuickSearchActivity quickSearchActivity) {
        this.agY = quickSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.m.b(this.agY, view);
        }
    }
}
