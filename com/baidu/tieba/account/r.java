package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class r implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity amw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ActivationActivity activationActivity) {
        this.amw = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        editText = this.amw.amh;
        if (view == editText) {
            if (z) {
                imageView2 = this.amw.amd;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.amw.amd;
            imageView.setVisibility(8);
        }
    }
}
