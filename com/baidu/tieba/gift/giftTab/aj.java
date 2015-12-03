package com.baidu.tieba.gift.giftTab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnFocusChangeListener {
    final /* synthetic */ ad bwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ad adVar) {
        this.bwb = adVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            com.baidu.adp.lib.util.k.d(this.bwb.bvG.getPageContext().getPageActivity(), this.bwb.bug);
        } else {
            com.baidu.adp.lib.util.k.c(this.bwb.bvG.getPageContext().getPageActivity(), this.bwb.bug);
        }
    }
}
