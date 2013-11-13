package com.baidu.tieba.home;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(SearchActivity searchActivity) {
        this.f1414a = searchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        int i4;
        int i5;
        this.f1414a.A = charSequence.toString();
        str = this.f1414a.A;
        if (str.trim().length() > 0) {
            i5 = this.f1414a.B;
            if (i5 == 0) {
                this.f1414a.g();
                return;
            }
            return;
        }
        this.f1414a.a();
        i4 = this.f1414a.B;
        if (i4 == 0) {
            this.f1414a.f();
        } else {
            this.f1414a.h();
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
            button2 = this.f1414a.d;
            button2.setVisibility(8);
            return;
        }
        button = this.f1414a.d;
        button.setVisibility(0);
    }
}
