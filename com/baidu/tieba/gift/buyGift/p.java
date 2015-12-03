package com.baidu.tieba.gift.buyGift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnFocusChangeListener {
    final /* synthetic */ BuyGiftActivity buJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BuyGiftActivity buyGiftActivity) {
        this.buJ = buyGiftActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        InputMethodManager inputMethodManager;
        InputMethodManager inputMethodManager2;
        if (z) {
            BuyGiftActivity buyGiftActivity = this.buJ;
            inputMethodManager2 = this.buJ.buE;
            buyGiftActivity.ShowSoftKeyPad(inputMethodManager2, this.buJ.bug);
            return;
        }
        BuyGiftActivity buyGiftActivity2 = this.buJ;
        inputMethodManager = this.buJ.buE;
        buyGiftActivity2.HidenSoftKeyPad(inputMethodManager, this.buJ.bug);
    }
}
