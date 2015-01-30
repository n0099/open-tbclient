package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class x implements View.OnFocusChangeListener {
    final /* synthetic */ Register2Activity aod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Register2Activity register2Activity) {
        this.aod = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.aod.anK;
        if (view == editText) {
            imageView = this.aod.anC;
        } else {
            editText2 = this.aod.anM;
            if (view == editText2) {
                imageView = this.aod.anD;
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
