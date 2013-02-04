package com.baidu.tieba.home;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements TextWatcher {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        Button button6;
        if (editable.toString().trim().length() == 0) {
            button4 = this.a.d;
            button4.setEnabled(false);
            button5 = this.a.d;
            button5.setTextColor(this.a.getResources().getColor(R.color.gray));
            button6 = this.a.c;
            button6.setVisibility(8);
            return;
        }
        button = this.a.d;
        button.setEnabled(true);
        button2 = this.a.d;
        button2.setTextColor(this.a.getResources().getColor(17170444));
        button3 = this.a.c;
        button3.setVisibility(0);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        this.a.r = charSequence.toString().trim();
        str = this.a.r;
        if (str.length() > 0) {
            this.a.l();
            return;
        }
        this.a.g();
        this.a.k();
    }
}
