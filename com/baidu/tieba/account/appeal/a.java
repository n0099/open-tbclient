package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity afT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.afT = appealActivity;
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
        textView = this.afT.afO;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.afT.afP;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.afT.afP;
            textView4.setTextColor(this.afT.getResources().getColor(s.red));
            return;
        }
        TbadkApplication.m251getInst().getSkinType();
        textView3 = this.afT.afP;
        aw.b(textView3, s.appeal_hint, 1);
    }
}
