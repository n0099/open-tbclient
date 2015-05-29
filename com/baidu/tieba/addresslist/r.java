package com.baidu.tieba.addresslist;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class r implements TextWatcher {
    final /* synthetic */ QuickSearchActivity azu;

    private r(QuickSearchActivity quickSearchActivity) {
        this.azu = quickSearchActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(QuickSearchActivity quickSearchActivity, r rVar) {
        this(quickSearchActivity);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.toString().trim().length() != 0) {
            QuickSearchActivity.a(this.azu, charSequence.toString());
            return;
        }
        QuickSearchActivity.a(this.azu).setVisibility(8);
        QuickSearchActivity.b(this.azu).setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.toString().trim().length() == 0) {
            QuickSearchActivity.c(this.azu).setVisibility(8);
        } else {
            QuickSearchActivity.c(this.azu).setVisibility(0);
        }
    }
}
