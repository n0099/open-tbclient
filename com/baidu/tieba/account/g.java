package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class g implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f899a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ActivationActivity activationActivity) {
        this.f899a = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        editText = this.f899a.k;
        if (view == editText) {
            if (z) {
                imageView2 = this.f899a.d;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.f899a.d;
            imageView.setVisibility(8);
        }
    }
}
