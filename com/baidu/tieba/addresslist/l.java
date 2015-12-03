package com.baidu.tieba.addresslist;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnFocusChangeListener {
    final /* synthetic */ QuickSearchActivity aHY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(QuickSearchActivity quickSearchActivity) {
        this.aHY = quickSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.k.c(this.aHY.getPageContext().getPageActivity(), view);
        }
    }
}
