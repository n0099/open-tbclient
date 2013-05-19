package com.baidu.tieba.home;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements TextWatcher {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SearchActivity searchActivity) {
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
            if (i5 != 0) {
                return;
            }
            this.a.p();
            return;
        }
        this.a.b();
        i4 = this.a.B;
        if (i4 == 0) {
            this.a.o();
        } else {
            this.a.q();
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
            button3 = this.a.e;
            button3.setText(this.a.getString(R.string.cancel));
            button4 = this.a.d;
            button4.setVisibility(8);
            return;
        }
        button = this.a.e;
        button.setText(this.a.getString(R.string.search));
        button2 = this.a.d;
        button2.setVisibility(0);
    }
}
