package com.baidu.tieba.gift.buyGift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity bng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BuyGiftActivity buyGiftActivity) {
        this.bng = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        BuyGiftActivity buyGiftActivity = this.bng;
        inputMethodManager = this.bng.bnb;
        buyGiftActivity.HidenSoftKeyPad(inputMethodManager, this.bng.bmD);
        this.bng.mHandler.postDelayed(new o(this), 200L);
    }
}
