package com.baidu.tieba.gift.buyGift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity buJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BuyGiftActivity buyGiftActivity) {
        this.buJ = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        BuyGiftActivity buyGiftActivity = this.buJ;
        inputMethodManager = this.buJ.buE;
        buyGiftActivity.HidenSoftKeyPad(inputMethodManager, this.buJ.bug);
        this.buJ.mHandler.postDelayed(new o(this), 200L);
    }
}
