package com.baidu.tbadk.gift;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity Uu;
    private final /* synthetic */ InputMethodManager Uv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BuyGiftActivity buyGiftActivity, InputMethodManager inputMethodManager) {
        this.Uu = buyGiftActivity;
        this.Uv = inputMethodManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BuyGiftActivity buyGiftActivity = this.Uu;
        InputMethodManager inputMethodManager = this.Uv;
        editText = this.Uu.TQ;
        buyGiftActivity.HidenSoftKeyPad(inputMethodManager, editText);
        this.Uu.mHandler.postDelayed(new m(this), 200L);
    }
}
