package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ImageView imageView;
        EditText editText;
        TextView textView2;
        textView = this.a.b;
        if (view == textView) {
            editText = this.a.a;
            String a = com.baidu.adp.lib.util.i.a(editText.getText(), (String) null);
            if (TextUtils.isEmpty(a) || a.trim().length() == 0 || a.trim().length() > 20) {
                return;
            }
            this.a.b(a.trim());
            textView2 = this.a.b;
            textView2.setClickable(false);
            return;
        }
        imageView = this.a.c;
        if (view == imageView) {
            this.a.a("");
        }
    }
}
