package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class x implements View.OnFocusChangeListener {
    final /* synthetic */ Register2Activity aoa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Register2Activity register2Activity) {
        this.aoa = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.aoa.anH;
        if (view == editText) {
            imageView = this.aoa.anz;
        } else {
            editText2 = this.aoa.anJ;
            if (view == editText2) {
                imageView = this.aoa.anA;
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
