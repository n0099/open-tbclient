package com.baidu.tbadk.gift;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BuyGiftActivity abb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BuyGiftActivity buyGiftActivity) {
        this.abb = buyGiftActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        editText = this.abb.aaT;
        this.abb.ShowSoftKeyPad((InputMethodManager) this.abb.getSystemService("input_method"), editText);
    }
}
