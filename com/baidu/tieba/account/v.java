package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class v implements View.OnFocusChangeListener {
    final /* synthetic */ Register2Activity afR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Register2Activity register2Activity) {
        this.afR = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.afR.afy;
        if (view == editText) {
            imageView = this.afR.afq;
        } else {
            editText2 = this.afR.afA;
            if (view == editText2) {
                imageView = this.afR.afr;
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
