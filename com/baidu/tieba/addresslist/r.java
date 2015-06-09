package com.baidu.tieba.addresslist;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class r implements TextWatcher {
    final /* synthetic */ QuickSearchActivity azv;

    private r(QuickSearchActivity quickSearchActivity) {
        this.azv = quickSearchActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(QuickSearchActivity quickSearchActivity, r rVar) {
        this(quickSearchActivity);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.toString().trim().length() != 0) {
            QuickSearchActivity.a(this.azv, charSequence.toString());
            return;
        }
        QuickSearchActivity.a(this.azv).setVisibility(8);
        QuickSearchActivity.b(this.azv).setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.toString().trim().length() == 0) {
            QuickSearchActivity.c(this.azv).setVisibility(8);
        } else {
            QuickSearchActivity.c(this.azv).setVisibility(0);
        }
    }
}
