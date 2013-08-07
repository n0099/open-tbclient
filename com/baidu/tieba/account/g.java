package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class g implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f878a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ActivationActivity activationActivity) {
        this.f878a = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        editText = this.f878a.k;
        if (view == editText) {
            if (z) {
                imageView2 = this.f878a.d;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.f878a.d;
            imageView.setVisibility(8);
        }
    }
}
