package com.baidu.tbadk.gift;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class s implements TextWatcher {
    final /* synthetic */ BuyGiftActivity Uy;

    private s(BuyGiftActivity buyGiftActivity) {
        this.Uy = buyGiftActivity;
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
        int f = com.baidu.adp.lib.g.c.f(editable.toString(), 0);
        if (editable.toString().length() == String.valueOf(f).length()) {
            BuyGiftActivity.b(this.Uy, true);
            return;
        }
        int i = f >= 0 ? f : 0;
        BuyGiftActivity.c(this.Uy).setText(new StringBuilder().append(i).toString());
        BuyGiftActivity.c(this.Uy).setSelection(String.valueOf(i).length());
    }
}
