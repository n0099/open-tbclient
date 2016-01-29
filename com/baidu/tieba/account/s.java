package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class s implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aJA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ActivationActivity activationActivity) {
        this.aJA = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (view == this.aJA.aJl) {
            if (z) {
                imageView2 = this.aJA.aJh;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aJA.aJh;
            imageView.setVisibility(8);
        }
    }
}
