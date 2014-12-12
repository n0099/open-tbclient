package com.baidu.tieba.addresslist;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class o implements TextWatcher {
    final /* synthetic */ QuickSearchActivity aoo;

    private o(QuickSearchActivity quickSearchActivity) {
        this.aoo = quickSearchActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(QuickSearchActivity quickSearchActivity, o oVar) {
        this(quickSearchActivity);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.toString().trim().length() != 0) {
            QuickSearchActivity.a(this.aoo, charSequence.toString());
            return;
        }
        QuickSearchActivity.a(this.aoo).setVisibility(8);
        QuickSearchActivity.b(this.aoo).setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.toString().trim().length() == 0) {
            QuickSearchActivity.c(this.aoo).setVisibility(8);
        } else {
            QuickSearchActivity.c(this.aoo).setVisibility(0);
        }
    }
}
