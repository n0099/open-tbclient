package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class n implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aFc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ActivationActivity activationActivity) {
        this.aFc = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (view == this.aFc.aEO) {
            if (z) {
                imageView2 = this.aFc.aEK;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aFc.aEK;
            imageView.setVisibility(8);
        }
    }
}
