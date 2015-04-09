package com.baidu.tieba.addresslist;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class m implements TextWatcher {
    final /* synthetic */ QuickSearchActivity axI;

    private m(QuickSearchActivity quickSearchActivity) {
        this.axI = quickSearchActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(QuickSearchActivity quickSearchActivity, m mVar) {
        this(quickSearchActivity);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.toString().trim().length() != 0) {
            QuickSearchActivity.a(this.axI, charSequence.toString());
            return;
        }
        QuickSearchActivity.a(this.axI).setVisibility(8);
        QuickSearchActivity.b(this.axI).setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.toString().trim().length() == 0) {
            QuickSearchActivity.c(this.axI).setVisibility(8);
        } else {
            QuickSearchActivity.c(this.axI).setVisibility(0);
        }
    }
}
