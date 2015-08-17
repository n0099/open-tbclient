package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity aFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.aFs = appealActivity;
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
        textView = this.aFs.aFn;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.aFs.aFo;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.aFs.aFo;
            textView4.setTextColor(this.aFs.getResources().getColor(i.c.red));
            return;
        }
        textView3 = this.aFs.aFo;
        al.b(textView3, i.c.appeal_hint, 1);
    }
}
