package com.baidu.tbadk.gift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity abe;
    private final /* synthetic */ InputMethodManager abf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BuyGiftActivity buyGiftActivity, InputMethodManager inputMethodManager) {
        this.abe = buyGiftActivity;
        this.abf = inputMethodManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BuyGiftActivity buyGiftActivity = this.abe;
        InputMethodManager inputMethodManager = this.abf;
        editText = this.abe.aaW;
        buyGiftActivity.HidenSoftKeyPad(inputMethodManager, editText);
        this.abe.mHandler.postDelayed(new c(this), 200L);
    }
}
