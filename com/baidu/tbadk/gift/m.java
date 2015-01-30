package com.baidu.tbadk.gift;

import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ l abh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.abh = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        BuyGiftActivity buyGiftActivity2;
        View view;
        buyGiftActivity = this.abh.abe;
        buyGiftActivity.aM(false);
        buyGiftActivity2 = this.abh.abe;
        view = buyGiftActivity2.aaI;
        view.setVisibility(0);
    }
}
