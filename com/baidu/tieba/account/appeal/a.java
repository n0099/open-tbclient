package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity awm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.awm = appealActivity;
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
        textView = this.awm.awh;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.awm.awi;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.awm.awi;
            textView4.setTextColor(this.awm.getResources().getColor(s.red));
            return;
        }
        textView3 = this.awm.awi;
        ba.b(textView3, s.appeal_hint, 1);
    }
}
