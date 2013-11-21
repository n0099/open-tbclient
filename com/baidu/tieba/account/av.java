package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class av implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1059a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(Register2Activity register2Activity) {
        this.f1059a = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.f1059a.t;
        if (view == editText) {
            imageView = this.f1059a.k;
        } else {
            editText2 = this.f1059a.v;
            if (view == editText2) {
                imageView = this.f1059a.l;
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
