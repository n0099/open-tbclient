package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity aIY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.aIY = appealActivity;
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
        textView = this.aIY.aIT;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.aIY.aIU;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.aIY.aIU;
            textView4.setTextColor(this.aIY.getResources().getColor(t.d.red));
            return;
        }
        textView3 = this.aIY.aIU;
        at.c(textView3, t.d.appeal_hint, 1);
    }
}
