package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class r implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aIw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ActivationActivity activationActivity) {
        this.aIw = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (view == this.aIw.aIi) {
            if (z) {
                imageView2 = this.aIw.aIe;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aIw.aIe;
            imageView.setVisibility(8);
        }
    }
}
