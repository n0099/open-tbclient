package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class s implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aMd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ActivationActivity activationActivity) {
        this.aMd = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (view == this.aMd.aLO) {
            if (z) {
                imageView2 = this.aMd.aLK;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aMd.aLK;
            imageView.setVisibility(8);
        }
    }
}
