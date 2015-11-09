package com.baidu.tieba.gift.buyGift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnFocusChangeListener {
    final /* synthetic */ BuyGiftActivity bng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BuyGiftActivity buyGiftActivity) {
        this.bng = buyGiftActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        InputMethodManager inputMethodManager;
        InputMethodManager inputMethodManager2;
        if (z) {
            BuyGiftActivity buyGiftActivity = this.bng;
            inputMethodManager2 = this.bng.bnb;
            buyGiftActivity.ShowSoftKeyPad(inputMethodManager2, this.bng.bmD);
            return;
        }
        BuyGiftActivity buyGiftActivity2 = this.bng;
        inputMethodManager = this.bng.bnb;
        buyGiftActivity2.HidenSoftKeyPad(inputMethodManager, this.bng.bmD);
    }
}
