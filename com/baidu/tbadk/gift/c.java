package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b Uw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.Uw = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        EditText editText;
        BuyGiftActivity buyGiftActivity2;
        View view;
        buyGiftActivity = this.Uw.Uu;
        editText = buyGiftActivity.Um;
        editText.clearFocus();
        buyGiftActivity2 = this.Uw.Uu;
        view = buyGiftActivity2.Uk;
        view.setVisibility(8);
    }
}
