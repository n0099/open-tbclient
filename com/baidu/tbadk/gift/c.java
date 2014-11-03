package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b UA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.UA = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        EditText editText;
        BuyGiftActivity buyGiftActivity2;
        View view;
        buyGiftActivity = this.UA.Uy;
        editText = buyGiftActivity.Uq;
        editText.clearFocus();
        buyGiftActivity2 = this.UA.Uy;
        view = buyGiftActivity2.Uo;
        view.setVisibility(8);
    }
}
