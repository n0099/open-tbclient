package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity awu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.awu = appealActivity;
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
        textView = this.awu.awp;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.awu.awq;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.awu.awq;
            textView4.setTextColor(this.awu.getResources().getColor(s.red));
            return;
        }
        textView3 = this.awu.awq;
        ba.b(textView3, s.appeal_hint, 1);
    }
}
