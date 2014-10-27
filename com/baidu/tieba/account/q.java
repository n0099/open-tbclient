package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class q implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aeY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.aeY = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        editText = this.aeY.aeI;
        if (view == editText) {
            if (z) {
                imageView2 = this.aeY.aeE;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aeY.aeE;
            imageView.setVisibility(8);
        }
    }
}
