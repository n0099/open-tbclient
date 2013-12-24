package com.baidu.tieba.account.appeal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class a implements TextWatcher {
    final /* synthetic */ AppealActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.a = appealActivity;
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
        textView = this.a.d;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.a.e;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView4 = this.a.e;
            textView4.setTextColor(this.a.getResources().getColor(R.color.red));
            return;
        }
        int an = TiebaApplication.h().an();
        textView3 = this.a.e;
        textView3.setTextColor(this.a.getResources().getColor(an == 1 ? R.color.appeal_hint : R.color.appeal_hint_1));
    }
}
