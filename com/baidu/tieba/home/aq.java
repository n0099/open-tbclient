package com.baidu.tieba.home;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements TextWatcher {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        int i4;
        int i5;
        this.a.A = charSequence.toString();
        str = this.a.A;
        if (str.trim().length() > 0) {
            i5 = this.a.B;
            if (i5 == 0) {
                this.a.g();
                return;
            }
            return;
        }
        this.a.a();
        i4 = this.a.B;
        if (i4 == 0) {
            this.a.f();
        } else {
            this.a.h();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        Button button2;
        if (editable.toString().trim().length() == 0) {
            button2 = this.a.d;
            button2.setVisibility(8);
            return;
        }
        button = this.a.d;
        button.setVisibility(0);
    }
}
