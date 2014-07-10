package com.baidu.tieba.addresslist;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class l implements TextWatcher {
    final /* synthetic */ QuickSearchActivity a;

    private l(QuickSearchActivity quickSearchActivity) {
        this.a = quickSearchActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(QuickSearchActivity quickSearchActivity, l lVar) {
        this(quickSearchActivity);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.toString().trim().length() != 0) {
            QuickSearchActivity.a(this.a, charSequence.toString());
            return;
        }
        QuickSearchActivity.a(this.a).setVisibility(8);
        QuickSearchActivity.b(this.a).setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.toString().trim().length() == 0) {
            QuickSearchActivity.c(this.a).setVisibility(8);
        } else {
            QuickSearchActivity.c(this.a).setVisibility(0);
        }
    }
}
