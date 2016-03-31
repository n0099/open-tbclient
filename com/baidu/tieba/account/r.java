package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class r implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aMw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ActivationActivity activationActivity) {
        this.aMw = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (view == this.aMw.aMh) {
            if (z) {
                imageView2 = this.aMw.aMd;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aMw.aMd;
            imageView.setVisibility(8);
        }
    }
}
