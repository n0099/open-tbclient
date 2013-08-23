package com.baidu.tieba.home;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(SearchActivity searchActivity) {
        this.f1167a = searchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        int i4;
        int i5;
        this.f1167a.D = charSequence.toString();
        str = this.f1167a.D;
        if (str.trim().length() > 0) {
            i5 = this.f1167a.E;
            if (i5 != 0) {
                return;
            }
            this.f1167a.n();
            return;
        }
        this.f1167a.b();
        i4 = this.f1167a.E;
        if (i4 == 0) {
            this.f1167a.m();
        } else {
            this.f1167a.o();
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
            button2 = this.f1167a.d;
            button2.setVisibility(8);
            return;
        }
        button = this.f1167a.d;
        button.setVisibility(0);
    }
}
