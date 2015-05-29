package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity aya;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.aya = appealActivity;
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
        textView = this.aya.axV;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.aya.axW;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.aya.axW;
            textView4.setTextColor(this.aya.getResources().getColor(n.red));
            return;
        }
        textView3 = this.aya.axW;
        ay.b(textView3, n.appeal_hint, 1);
    }
}
