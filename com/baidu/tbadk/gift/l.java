package com.baidu.tbadk.gift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity abb;
    private final /* synthetic */ InputMethodManager abc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BuyGiftActivity buyGiftActivity, InputMethodManager inputMethodManager) {
        this.abb = buyGiftActivity;
        this.abc = inputMethodManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BuyGiftActivity buyGiftActivity = this.abb;
        InputMethodManager inputMethodManager = this.abc;
        editText = this.abb.aax;
        buyGiftActivity.HidenSoftKeyPad(inputMethodManager, editText);
        this.abb.mHandler.postDelayed(new m(this), 200L);
    }
}
