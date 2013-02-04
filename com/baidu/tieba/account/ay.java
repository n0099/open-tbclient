package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class ay implements View.OnFocusChangeListener {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(Register2Activity register2Activity) {
        this.a = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.a.s;
        if (view == editText) {
            imageView = this.a.j;
        } else {
            editText2 = this.a.u;
            if (view == editText2) {
                imageView = this.a.k;
            }
        }
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }
}
