package com.baidu.tieba.gift.buyGift;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ n bmD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bmD = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        BuyGiftActivity buyGiftActivity2;
        buyGiftActivity = this.bmD.bmC;
        buyGiftActivity.cz(false);
        buyGiftActivity2 = this.bmD.bmC;
        buyGiftActivity2.bmh.setVisibility(0);
    }
}
