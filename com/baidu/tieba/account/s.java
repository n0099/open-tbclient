package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class s implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aEn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ActivationActivity activationActivity) {
        this.aEn = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (view == this.aEn.aDZ) {
            if (z) {
                imageView2 = this.aEn.aDV;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aEn.aDV;
            imageView.setVisibility(8);
        }
    }
}
