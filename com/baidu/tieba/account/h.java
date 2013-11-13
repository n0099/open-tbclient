package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class h implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f1079a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ActivationActivity activationActivity) {
        this.f1079a = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        editText = this.f1079a.i;
        if (view == editText) {
            if (z) {
                imageView2 = this.f1079a.d;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.f1079a.d;
            imageView.setVisibility(8);
        }
    }
}
