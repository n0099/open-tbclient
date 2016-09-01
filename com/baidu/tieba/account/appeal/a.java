package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity aSJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.aSJ = appealActivity;
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
        textView = this.aSJ.aSE;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.aSJ.aSF;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.aSJ.aSF;
            textView4.setTextColor(this.aSJ.getResources().getColor(t.d.common_color_10253));
            return;
        }
        textView3 = this.aSJ.aSF;
        av.c(textView3, t.d.common_color_10005, 1);
    }
}
