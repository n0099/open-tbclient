package com.baidu.tbadk.gift;

import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ l aaG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aaG = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        BuyGiftActivity buyGiftActivity2;
        View view;
        buyGiftActivity = this.aaG.aaD;
        buyGiftActivity.aK(false);
        buyGiftActivity2 = this.aaG.aaD;
        view = buyGiftActivity2.aah;
        view.setVisibility(0);
    }
}
