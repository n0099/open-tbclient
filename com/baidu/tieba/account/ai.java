package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class ai implements View.OnFocusChangeListener {
    final /* synthetic */ Register2Activity axQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(Register2Activity register2Activity) {
        this.axQ = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.axQ.axv;
        if (view == editText) {
            imageView = this.axQ.axm;
        } else {
            editText2 = this.axQ.axx;
            if (view == editText2) {
                imageView = this.axQ.axn;
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
