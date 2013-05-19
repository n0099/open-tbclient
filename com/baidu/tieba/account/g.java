package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class g implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        editText = this.a.k;
        if (view == editText) {
            if (z) {
                imageView2 = this.a.f;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.a.f;
            imageView.setVisibility(8);
        }
    }
}
