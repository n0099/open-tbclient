package com.baidu.tieba.gift.buyGift;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    final /* synthetic */ BuyGiftActivity buJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BuyGiftActivity buyGiftActivity) {
        this.buJ = buyGiftActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EditText editText;
        InputMethodManager inputMethodManager;
        EditText editText2;
        com.baidu.tbadk.core.dialog.a aVar2;
        this.buJ.mPassword = "";
        editText = this.buJ.buB;
        editText.clearFocus();
        BuyGiftActivity buyGiftActivity = this.buJ;
        inputMethodManager = this.buJ.buE;
        editText2 = this.buJ.buB;
        buyGiftActivity.HidenSoftKeyPad(inputMethodManager, editText2);
        aVar2 = this.buJ.buz;
        aVar2.dismiss();
    }
}
