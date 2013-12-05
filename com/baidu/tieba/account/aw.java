package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class aw implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1070a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(Register2Activity register2Activity) {
        this.f1070a = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.f1070a.t;
        if (view == editText) {
            imageView = this.f1070a.k;
        } else {
            editText2 = this.f1070a.v;
            if (view == editText2) {
                imageView = this.f1070a.l;
            }
        }
        if (imageView != null) {
            if (z) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }
}
