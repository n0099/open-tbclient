package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class s implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aFV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ActivationActivity activationActivity) {
        this.aFV = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (view == this.aFV.aFH) {
            if (z) {
                imageView2 = this.aFV.aFD;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aFV.aFD;
            imageView.setVisibility(8);
        }
    }
}
