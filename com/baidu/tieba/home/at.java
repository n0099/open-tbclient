package com.baidu.tieba.home;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1132a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(SearchActivity searchActivity) {
        this.f1132a = searchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        int i4;
        int i5;
        this.f1132a.A = charSequence.toString();
        str = this.f1132a.A;
        if (str.trim().length() > 0) {
            i5 = this.f1132a.B;
            if (i5 != 0) {
                return;
            }
            this.f1132a.n();
            return;
        }
        this.f1132a.b();
        i4 = this.f1132a.B;
        if (i4 == 0) {
            this.f1132a.m();
        } else {
            this.f1132a.o();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        Button button2;
        Button button3;
        Button button4;
        if (editable.toString().trim().length() == 0) {
            button3 = this.f1132a.c;
            button3.setText(this.f1132a.getString(R.string.cancel));
            button4 = this.f1132a.b;
            button4.setVisibility(8);
            return;
        }
        button = this.f1132a.c;
        button.setText(this.f1132a.getString(R.string.search));
        button2 = this.f1132a.b;
        button2.setVisibility(0);
    }
}
