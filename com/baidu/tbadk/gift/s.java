package com.baidu.tbadk.gift;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class s implements TextWatcher {
    final /* synthetic */ BuyGiftActivity aaD;

    private s(BuyGiftActivity buyGiftActivity) {
        this.aaD = buyGiftActivity;
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
            BuyGiftActivity.b(this.aaD, true);
            return;
        }
        int i2 = i >= 0 ? i : 0;
        BuyGiftActivity.c(this.aaD).setText(new StringBuilder().append(i2).toString());
        BuyGiftActivity.c(this.aaD).setSelection(String.valueOf(i2).length());
    }
}
