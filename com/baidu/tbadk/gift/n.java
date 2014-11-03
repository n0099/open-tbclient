package com.baidu.tbadk.gift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnFocusChangeListener {
    final /* synthetic */ BuyGiftActivity Uy;
    private final /* synthetic */ InputMethodManager Uz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BuyGiftActivity buyGiftActivity, InputMethodManager inputMethodManager) {
        this.Uy = buyGiftActivity;
        this.Uz = inputMethodManager;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        if (z) {
            BuyGiftActivity buyGiftActivity = this.Uy;
            InputMethodManager inputMethodManager = this.Uz;
            editText2 = this.Uy.TU;
            buyGiftActivity.ShowSoftKeyPad(inputMethodManager, editText2);
            return;
        }
        BuyGiftActivity buyGiftActivity2 = this.Uy;
        InputMethodManager inputMethodManager2 = this.Uz;
        editText = this.Uy.TU;
        buyGiftActivity2.HidenSoftKeyPad(inputMethodManager2, editText);
    }
}
