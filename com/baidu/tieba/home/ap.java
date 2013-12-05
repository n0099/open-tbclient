package com.baidu.tieba.home;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(SearchActivity searchActivity) {
        this.f1455a = searchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        int i4;
        int i5;
        this.f1455a.A = charSequence.toString();
        str = this.f1455a.A;
        if (str.trim().length() > 0) {
            i5 = this.f1455a.B;
            if (i5 == 0) {
                this.f1455a.g();
                return;
            }
            return;
        }
        this.f1455a.a();
        i4 = this.f1455a.B;
        if (i4 == 0) {
            this.f1455a.f();
        } else {
            this.f1455a.h();
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
            button2 = this.f1455a.d;
            button2.setVisibility(8);
            return;
        }
        button = this.f1455a.d;
        button.setVisibility(0);
    }
}
