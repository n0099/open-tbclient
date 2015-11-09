package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class n implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ActivationActivity activationActivity) {
        this.aDW = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (view == this.aDW.aDI) {
            if (z) {
                imageView2 = this.aDW.aDE;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aDW.aDE;
            imageView.setVisibility(8);
        }
    }
}
