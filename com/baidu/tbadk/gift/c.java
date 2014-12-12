package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b aaF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aaF = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        EditText editText;
        BuyGiftActivity buyGiftActivity2;
        View view;
        buyGiftActivity = this.aaF.aaD;
        editText = buyGiftActivity.aav;
        editText.clearFocus();
        buyGiftActivity2 = this.aaF.aaD;
        view = buyGiftActivity2.aat;
        view.setVisibility(8);
    }
}
