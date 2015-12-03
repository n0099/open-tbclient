package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity aHl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.aHl = appealActivity;
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
        textView = this.aHl.aHg;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.aHl.aHh;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.aHl.aHh;
            textView4.setTextColor(this.aHl.getResources().getColor(n.c.red));
            return;
        }
        textView3 = this.aHl.aHh;
        as.b(textView3, n.c.appeal_hint, 1);
    }
}
