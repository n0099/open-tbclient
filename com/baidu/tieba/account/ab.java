package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class ab implements View.OnFocusChangeListener {
    final /* synthetic */ Register2Activity aFh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(Register2Activity register2Activity) {
        this.aFh = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.aFh.aEM;
        if (view == editText) {
            imageView = this.aFh.aED;
        } else {
            editText2 = this.aFh.aEO;
            if (view == editText2) {
                imageView = this.aFh.aEE;
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
