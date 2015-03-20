package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class ad implements View.OnFocusChangeListener {
    final /* synthetic */ Register2Activity awc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(Register2Activity register2Activity) {
        this.awc = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.awc.avH;
        if (view == editText) {
            imageView = this.awc.avy;
        } else {
            editText2 = this.awc.avJ;
            if (view == editText2) {
                imageView = this.awc.avz;
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
