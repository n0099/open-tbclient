package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class s implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity anq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ActivationActivity activationActivity) {
        this.anq = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        editText = this.anq.anb;
        if (view == editText) {
            if (z) {
                imageView2 = this.anq.amX;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.anq.amX;
            imageView.setVisibility(8);
        }
    }
}
