package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class y implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity awW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ActivationActivity activationActivity) {
        this.awW = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        editText = this.awW.awI;
        if (view == editText) {
            if (z) {
                imageView2 = this.awW.awE;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.awW.awE;
            imageView.setVisibility(8);
        }
    }
}
