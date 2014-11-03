package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h bih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bih = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ImageView imageView;
        EditText editText;
        TextView textView2;
        textView = this.bih.bib;
        if (view == textView) {
            editText = this.bih.bia;
            String a = com.baidu.adp.lib.util.l.a(editText.getText(), null);
            if (TextUtils.isEmpty(a) || a.trim().length() == 0) {
                return;
            }
            this.bih.fz(a.trim());
            textView2 = this.bih.bib;
            textView2.setClickable(false);
            return;
        }
        imageView = this.bih.bic;
        if (view == imageView) {
            this.bih.gC("");
        }
    }
}
