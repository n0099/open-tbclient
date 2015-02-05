package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b abd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.abd = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        EditText editText;
        BuyGiftActivity buyGiftActivity2;
        View view;
        buyGiftActivity = this.abd.abb;
        editText = buyGiftActivity.aaT;
        editText.clearFocus();
        buyGiftActivity2 = this.abd.abb;
        view = buyGiftActivity2.aaR;
        view.setVisibility(8);
    }
}
