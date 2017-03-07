package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity aVN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.aVN = appealActivity;
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
        textView = this.aVN.aVI;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.aVN.aVJ;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.aVN.aVJ;
            textView4.setTextColor(this.aVN.getResources().getColor(w.e.common_color_10253));
            return;
        }
        textView3 = this.aVN.aVJ;
        aq.c(textView3, w.e.common_color_10005, 1);
    }
}
