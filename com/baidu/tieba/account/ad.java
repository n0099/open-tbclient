package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class ad implements View.OnFocusChangeListener {
    final /* synthetic */ Register2Activity awk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(Register2Activity register2Activity) {
        this.awk = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.awk.avP;
        if (view == editText) {
            imageView = this.awk.avG;
        } else {
            editText2 = this.awk.avR;
            if (view == editText2) {
                imageView = this.awk.avH;
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
