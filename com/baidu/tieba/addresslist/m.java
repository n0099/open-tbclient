package com.baidu.tieba.addresslist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnFocusChangeListener {
    final /* synthetic */ QuickSearchActivity aoo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(QuickSearchActivity quickSearchActivity) {
        this.aoo = quickSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.l.c(this.aoo.getPageContext().getPageActivity(), view);
        }
    }
}
