package com.baidu.tieba.addresslist;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class o implements TextWatcher {
    final /* synthetic */ QuickSearchActivity apg;

    private o(QuickSearchActivity quickSearchActivity) {
        this.apg = quickSearchActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(QuickSearchActivity quickSearchActivity, o oVar) {
        this(quickSearchActivity);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.toString().trim().length() != 0) {
            QuickSearchActivity.a(this.apg, charSequence.toString());
            return;
        }
        QuickSearchActivity.a(this.apg).setVisibility(8);
        QuickSearchActivity.b(this.apg).setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.toString().trim().length() == 0) {
            QuickSearchActivity.c(this.apg).setVisibility(8);
        } else {
            QuickSearchActivity.c(this.apg).setVisibility(0);
        }
    }
}
