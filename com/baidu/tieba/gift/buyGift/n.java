package com.baidu.tieba.gift.buyGift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity bmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BuyGiftActivity buyGiftActivity) {
        this.bmC = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        BuyGiftActivity buyGiftActivity = this.bmC;
        inputMethodManager = this.bmC.bmx;
        buyGiftActivity.HidenSoftKeyPad(inputMethodManager, this.bmC.blZ);
        this.bmC.mHandler.postDelayed(new o(this), 200L);
    }
}
