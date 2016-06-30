package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity aMv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.aMv = appealActivity;
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
        textView = this.aMv.aMq;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.aMv.aMr;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.aMv.aMr;
            textView4.setTextColor(this.aMv.getResources().getColor(u.d.common_color_10253));
            return;
        }
        textView3 = this.aMv.aMr;
        av.c(textView3, u.d.common_color_10005, 1);
    }
}
