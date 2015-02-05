package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity aok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.aok = appealActivity;
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
        textView = this.aok.aof;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.aok.aog;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.aok.aog;
            textView4.setTextColor(this.aok.getResources().getColor(t.red));
            return;
        }
        textView3 = this.aok.aog;
        bc.b(textView3, t.appeal_hint, 1);
    }
}
