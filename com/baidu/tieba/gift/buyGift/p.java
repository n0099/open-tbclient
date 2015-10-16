package com.baidu.tieba.gift.buyGift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnFocusChangeListener {
    final /* synthetic */ BuyGiftActivity bmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BuyGiftActivity buyGiftActivity) {
        this.bmC = buyGiftActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        InputMethodManager inputMethodManager;
        InputMethodManager inputMethodManager2;
        if (z) {
            BuyGiftActivity buyGiftActivity = this.bmC;
            inputMethodManager2 = this.bmC.bmx;
            buyGiftActivity.ShowSoftKeyPad(inputMethodManager2, this.bmC.blZ);
            return;
        }
        BuyGiftActivity buyGiftActivity2 = this.bmC;
        inputMethodManager = this.bmC.bmx;
        buyGiftActivity2.HidenSoftKeyPad(inputMethodManager, this.bmC.blZ);
    }
}
