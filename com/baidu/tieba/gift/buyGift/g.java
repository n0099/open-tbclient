package com.baidu.tieba.gift.buyGift;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BuyGiftActivity buJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BuyGiftActivity buyGiftActivity) {
        this.buJ = buyGiftActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        editText = this.buJ.buB;
        this.buJ.ShowSoftKeyPad((InputMethodManager) this.buJ.getSystemService("input_method"), editText);
    }
}
