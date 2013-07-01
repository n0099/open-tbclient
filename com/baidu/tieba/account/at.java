package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class at implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f657a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(Register2Activity register2Activity) {
        this.f657a = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.f657a.x;
        if (view == editText) {
            imageView = this.f657a.o;
        } else {
            editText2 = this.f657a.z;
            if (view == editText2) {
                imageView = this.f657a.p;
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
