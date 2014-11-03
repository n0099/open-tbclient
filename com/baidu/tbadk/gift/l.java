package com.baidu.tbadk.gift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity Uy;
    private final /* synthetic */ InputMethodManager Uz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BuyGiftActivity buyGiftActivity, InputMethodManager inputMethodManager) {
        this.Uy = buyGiftActivity;
        this.Uz = inputMethodManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BuyGiftActivity buyGiftActivity = this.Uy;
        InputMethodManager inputMethodManager = this.Uz;
        editText = this.Uy.TU;
        buyGiftActivity.HidenSoftKeyPad(inputMethodManager, editText);
        this.Uy.mHandler.postDelayed(new m(this), 200L);
    }
}
