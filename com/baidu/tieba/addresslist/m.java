package com.baidu.tieba.addresslist;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class m implements TextWatcher {
    final /* synthetic */ QuickSearchActivity axA;

    private m(QuickSearchActivity quickSearchActivity) {
        this.axA = quickSearchActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(QuickSearchActivity quickSearchActivity, m mVar) {
        this(quickSearchActivity);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.toString().trim().length() != 0) {
            QuickSearchActivity.a(this.axA, charSequence.toString());
            return;
        }
        QuickSearchActivity.a(this.axA).setVisibility(8);
        QuickSearchActivity.b(this.axA).setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.toString().trim().length() == 0) {
            QuickSearchActivity.c(this.axA).setVisibility(8);
        } else {
            QuickSearchActivity.c(this.axA).setVisibility(0);
        }
    }
}
