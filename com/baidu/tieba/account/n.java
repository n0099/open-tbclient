package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class n implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aER;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ActivationActivity activationActivity) {
        this.aER = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (view == this.aER.aED) {
            if (z) {
                imageView2 = this.aER.aEz;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aER.aEz;
            imageView.setVisibility(8);
        }
    }
}
