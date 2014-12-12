package com.baidu.tbadk.gift;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BuyGiftActivity aaD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BuyGiftActivity buyGiftActivity) {
        this.aaD = buyGiftActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        editText = this.aaD.aav;
        this.aaD.ShowSoftKeyPad((InputMethodManager) this.aaD.getSystemService("input_method"), editText);
    }
}
