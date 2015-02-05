package com.baidu.tbadk.gift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnFocusChangeListener {
    final /* synthetic */ BuyGiftActivity abb;
    private final /* synthetic */ InputMethodManager abc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BuyGiftActivity buyGiftActivity, InputMethodManager inputMethodManager) {
        this.abb = buyGiftActivity;
        this.abc = inputMethodManager;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        if (z) {
            BuyGiftActivity buyGiftActivity = this.abb;
            InputMethodManager inputMethodManager = this.abc;
            editText2 = this.abb.aax;
            buyGiftActivity.ShowSoftKeyPad(inputMethodManager, editText2);
            return;
        }
        BuyGiftActivity buyGiftActivity2 = this.abb;
        InputMethodManager inputMethodManager2 = this.abc;
        editText = this.abb.aax;
        buyGiftActivity2.HidenSoftKeyPad(inputMethodManager2, editText);
    }
}
