package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class s implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aMX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ActivationActivity activationActivity) {
        this.aMX = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (view == this.aMX.aMI) {
            if (z) {
                imageView2 = this.aMX.aME;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aMX.aME;
            imageView.setVisibility(8);
        }
    }
}
