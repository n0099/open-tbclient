package com.baidu.tbadk.gift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnFocusChangeListener {
    final /* synthetic */ BuyGiftActivity abe;
    private final /* synthetic */ InputMethodManager abf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BuyGiftActivity buyGiftActivity, InputMethodManager inputMethodManager) {
        this.abe = buyGiftActivity;
        this.abf = inputMethodManager;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        if (z) {
            BuyGiftActivity buyGiftActivity = this.abe;
            InputMethodManager inputMethodManager = this.abf;
            editText2 = this.abe.aaA;
            buyGiftActivity.ShowSoftKeyPad(inputMethodManager, editText2);
            return;
        }
        BuyGiftActivity buyGiftActivity2 = this.abe;
        InputMethodManager inputMethodManager2 = this.abf;
        editText = this.abe.aaA;
        buyGiftActivity2.HidenSoftKeyPad(inputMethodManager2, editText);
    }
}
