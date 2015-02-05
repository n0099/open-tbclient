package com.baidu.tbadk.gift;

import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ l abe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.abe = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        BuyGiftActivity buyGiftActivity2;
        View view;
        buyGiftActivity = this.abe.abb;
        buyGiftActivity.aM(false);
        buyGiftActivity2 = this.abe.abb;
        view = buyGiftActivity2.aaF;
        view.setVisibility(0);
    }
}
