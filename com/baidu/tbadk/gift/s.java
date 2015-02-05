package com.baidu.tbadk.gift;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class s implements TextWatcher {
    final /* synthetic */ BuyGiftActivity abb;

    private s(BuyGiftActivity buyGiftActivity) {
        this.abb = buyGiftActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(BuyGiftActivity buyGiftActivity, s sVar) {
        this(buyGiftActivity);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v2 int)] */
    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i = com.baidu.adp.lib.g.c.toInt(editable.toString(), 0);
        if (editable.toString().length() == String.valueOf(i).length()) {
            BuyGiftActivity.b(this.abb, true);
            return;
        }
        int i2 = i >= 0 ? i : 0;
        BuyGiftActivity.c(this.abb).setText(new StringBuilder().append(i2).toString());
        BuyGiftActivity.c(this.abb).setSelection(String.valueOf(i2).length());
    }
}
