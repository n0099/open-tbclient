package com.baidu.tieba.addresslist;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class n implements TextWatcher {
    final /* synthetic */ QuickSearchActivity agY;

    private n(QuickSearchActivity quickSearchActivity) {
        this.agY = quickSearchActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(QuickSearchActivity quickSearchActivity, n nVar) {
        this(quickSearchActivity);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.toString().trim().length() != 0) {
            QuickSearchActivity.a(this.agY, charSequence.toString());
            return;
        }
        QuickSearchActivity.a(this.agY).setVisibility(8);
        QuickSearchActivity.b(this.agY).setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.toString().trim().length() == 0) {
            QuickSearchActivity.c(this.agY).setVisibility(8);
        } else {
            QuickSearchActivity.c(this.agY).setVisibility(0);
        }
    }
}
