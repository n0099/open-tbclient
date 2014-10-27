package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h bhR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bhR = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ImageView imageView;
        EditText editText;
        TextView textView2;
        textView = this.bhR.bhN;
        if (view == textView) {
            editText = this.bhR.bhM;
            String a = com.baidu.adp.lib.util.l.a(editText.getText(), null);
            if (TextUtils.isEmpty(a) || a.trim().length() == 0) {
                return;
            }
            this.bhR.fz(a.trim());
            textView2 = this.bhR.bhN;
            textView2.setClickable(false);
            return;
        }
        imageView = this.bhR.bhO;
        if (view == imageView) {
            this.bhR.gC("");
        }
    }
}
