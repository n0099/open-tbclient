package com.baidu.tieba.gift.buyGift;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BuyGiftActivity bng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BuyGiftActivity buyGiftActivity) {
        this.bng = buyGiftActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        editText = this.bng.bmY;
        this.bng.ShowSoftKeyPad((InputMethodManager) this.bng.getSystemService("input_method"), editText);
    }
}
