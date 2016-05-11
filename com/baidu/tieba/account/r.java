package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class r implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ActivationActivity activationActivity) {
        this.aIG = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (view == this.aIG.aIr) {
            if (z) {
                imageView2 = this.aIG.aIn;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aIG.aIn;
            imageView.setVisibility(8);
        }
    }
}
