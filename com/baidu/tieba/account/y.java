package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class y implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity awV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ActivationActivity activationActivity) {
        this.awV = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        editText = this.awV.awH;
        if (view == editText) {
            if (z) {
                imageView2 = this.awV.awD;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.awV.awD;
            imageView.setVisibility(8);
        }
    }
}
