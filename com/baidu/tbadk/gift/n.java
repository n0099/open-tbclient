package com.baidu.tbadk.gift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnFocusChangeListener {
    final /* synthetic */ BuyGiftActivity Uu;
    private final /* synthetic */ InputMethodManager Uv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BuyGiftActivity buyGiftActivity, InputMethodManager inputMethodManager) {
        this.Uu = buyGiftActivity;
        this.Uv = inputMethodManager;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        if (z) {
            BuyGiftActivity buyGiftActivity = this.Uu;
            InputMethodManager inputMethodManager = this.Uv;
            editText2 = this.Uu.TQ;
            buyGiftActivity.ShowSoftKeyPad(inputMethodManager, editText2);
            return;
        }
        BuyGiftActivity buyGiftActivity2 = this.Uu;
        InputMethodManager inputMethodManager2 = this.Uv;
        editText = this.Uu.TQ;
        buyGiftActivity2.HidenSoftKeyPad(inputMethodManager2, editText);
    }
}
