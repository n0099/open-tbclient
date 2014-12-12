package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class w implements View.OnFocusChangeListener {
    final /* synthetic */ Register2Activity ani;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Register2Activity register2Activity) {
        this.ani = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.ani.amP;
        if (view == editText) {
            imageView = this.ani.amH;
        } else {
            editText2 = this.ani.amR;
            if (view == editText2) {
                imageView = this.ani.amI;
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
