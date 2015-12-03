package com.baidu.tieba.gift.buyGift;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ n buK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.buK = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        BuyGiftActivity buyGiftActivity2;
        buyGiftActivity = this.buK.buJ;
        buyGiftActivity.cR(false);
        buyGiftActivity2 = this.buK.buJ;
        buyGiftActivity2.buo.setVisibility(0);
    }
}
