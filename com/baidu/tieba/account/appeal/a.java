package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity aGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.aGo = appealActivity;
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
        textView = this.aGo.aGj;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.aGo.aGk;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.aGo.aGk;
            textView4.setTextColor(this.aGo.getResources().getColor(i.c.red));
            return;
        }
        textView3 = this.aGo.aGk;
        al.b(textView3, i.c.appeal_hint, 1);
    }
}
