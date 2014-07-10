package com.baidu.tieba.addresslist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnFocusChangeListener {
    final /* synthetic */ QuickSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(QuickSearchActivity quickSearchActivity) {
        this.a = quickSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.j.a(this.a, view);
        }
    }
}
