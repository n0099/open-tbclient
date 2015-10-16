package com.baidu.tieba.gift.buyGift;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    final /* synthetic */ BuyGiftActivity bmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BuyGiftActivity buyGiftActivity) {
        this.bmC = buyGiftActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EditText editText;
        InputMethodManager inputMethodManager;
        EditText editText2;
        com.baidu.tbadk.core.dialog.a aVar2;
        this.bmC.mPassword = "";
        editText = this.bmC.bmu;
        editText.clearFocus();
        BuyGiftActivity buyGiftActivity = this.bmC;
        inputMethodManager = this.bmC.bmx;
        editText2 = this.bmC.bmu;
        buyGiftActivity.HidenSoftKeyPad(inputMethodManager, editText2);
        aVar2 = this.bmC.bms;
        aVar2.dismiss();
    }
}
