package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity aUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.aUL = appealActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        textView = this.aUL.aUF;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.aUL.aUG;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.aUL.aUG;
            textView4.setTextColor(this.aUL.getResources().getColor(r.d.common_color_10253));
            return;
        }
        textView3 = this.aUL.aUG;
        ar.c(textView3, r.d.common_color_10005, 1);
    }
}
