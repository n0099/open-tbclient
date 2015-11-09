package com.baidu.tieba.gift.buyGift;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    final /* synthetic */ BuyGiftActivity bng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BuyGiftActivity buyGiftActivity) {
        this.bng = buyGiftActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EditText editText;
        InputMethodManager inputMethodManager;
        EditText editText2;
        com.baidu.tbadk.core.dialog.a aVar2;
        this.bng.mPassword = "";
        editText = this.bng.bmY;
        editText.clearFocus();
        BuyGiftActivity buyGiftActivity = this.bng;
        inputMethodManager = this.bng.bnb;
        editText2 = this.bng.bmY;
        buyGiftActivity.HidenSoftKeyPad(inputMethodManager, editText2);
        aVar2 = this.bng.bmW;
        aVar2.dismiss();
    }
}
