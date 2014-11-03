package com.baidu.tbadk.gift;

import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ l UB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.UB = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        BuyGiftActivity buyGiftActivity2;
        View view;
        buyGiftActivity = this.UB.Uy;
        buyGiftActivity.aw(false);
        buyGiftActivity2 = this.UB.Uy;
        view = buyGiftActivity2.Uc;
        view.setVisibility(0);
    }
}
