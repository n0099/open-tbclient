package com.baidu.tbadk.gift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity aaD;
    private final /* synthetic */ InputMethodManager aaE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BuyGiftActivity buyGiftActivity, InputMethodManager inputMethodManager) {
        this.aaD = buyGiftActivity;
        this.aaE = inputMethodManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BuyGiftActivity buyGiftActivity = this.aaD;
        InputMethodManager inputMethodManager = this.aaE;
        editText = this.aaD.aav;
        buyGiftActivity.HidenSoftKeyPad(inputMethodManager, editText);
        this.aaD.mHandler.postDelayed(new c(this), 200L);
    }
}
