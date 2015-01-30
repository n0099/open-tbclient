package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b abg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.abg = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        EditText editText;
        BuyGiftActivity buyGiftActivity2;
        View view;
        buyGiftActivity = this.abg.abe;
        editText = buyGiftActivity.aaW;
        editText.clearFocus();
        buyGiftActivity2 = this.abg.abe;
        view = buyGiftActivity2.aaU;
        view.setVisibility(8);
    }
}
