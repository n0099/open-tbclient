package com.baidu.tbadk.gift;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BuyGiftActivity Uy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BuyGiftActivity buyGiftActivity) {
        this.Uy = buyGiftActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        editText = this.Uy.Uq;
        this.Uy.ShowSoftKeyPad((InputMethodManager) this.Uy.getSystemService("input_method"), editText);
    }
}
