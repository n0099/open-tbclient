package com.baidu.tieba.account.appeal;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class a implements TextWatcher {
    final /* synthetic */ AppealActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppealActivity appealActivity) {
        this.a = appealActivity;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Resources resources;
        int i;
        textView = this.a.d;
        int length = 150 - textView.getText().toString().length();
        textView2 = this.a.e;
        textView2.setText(String.valueOf(length));
        if (length < 0) {
            textView3 = this.a.e;
            resources = this.a.getResources();
            i = R.color.red;
        } else {
            int ae = TiebaApplication.g().ae();
            textView3 = this.a.e;
            resources = this.a.getResources();
            i = ae == 1 ? R.color.appeal_hint : R.color.appeal_hint_1;
        }
        textView3.setTextColor(resources.getColor(i));
    }
}
