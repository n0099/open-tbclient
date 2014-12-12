package com.baidu.tbadk.gift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnFocusChangeListener {
    final /* synthetic */ BuyGiftActivity aaD;
    private final /* synthetic */ InputMethodManager aaE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BuyGiftActivity buyGiftActivity, InputMethodManager inputMethodManager) {
        this.aaD = buyGiftActivity;
        this.aaE = inputMethodManager;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        if (z) {
            BuyGiftActivity buyGiftActivity = this.aaD;
            InputMethodManager inputMethodManager = this.aaE;
            editText2 = this.aaD.ZZ;
            buyGiftActivity.ShowSoftKeyPad(inputMethodManager, editText2);
            return;
        }
        BuyGiftActivity buyGiftActivity2 = this.aaD;
        InputMethodManager inputMethodManager2 = this.aaE;
        editText = this.aaD.ZZ;
        buyGiftActivity2.HidenSoftKeyPad(inputMethodManager2, editText);
    }
}
