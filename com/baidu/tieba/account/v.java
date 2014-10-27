package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/* loaded from: classes.dex */
class v implements View.OnFocusChangeListener {
    final /* synthetic */ Register2Activity afJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Register2Activity register2Activity) {
        this.afJ = register2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        ImageView imageView = null;
        editText = this.afJ.afq;
        if (view == editText) {
            imageView = this.afJ.afi;
        } else {
            editText2 = this.afJ.afs;
            if (view == editText2) {
                imageView = this.afJ.afj;
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
