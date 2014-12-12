package com.baidu.tbadk.gift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity aaD;
    private final /* synthetic */ InputMethodManager aaE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BuyGiftActivity buyGiftActivity, InputMethodManager inputMethodManager) {
        this.aaD = buyGiftActivity;
        this.aaE = inputMethodManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BuyGiftActivity buyGiftActivity = this.aaD;
        InputMethodManager inputMethodManager = this.aaE;
        editText = this.aaD.ZZ;
        buyGiftActivity.HidenSoftKeyPad(inputMethodManager, editText);
        this.aaD.mHandler.postDelayed(new m(this), 200L);
    }
}
