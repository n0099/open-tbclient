package com.baidu.tbadk.gift;

import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ l Ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.Ux = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        BuyGiftActivity buyGiftActivity2;
        View view;
        buyGiftActivity = this.Ux.Uu;
        buyGiftActivity.aw(false);
        buyGiftActivity2 = this.Ux.Uu;
        view = buyGiftActivity2.TY;
        view.setVisibility(0);
    }
}
