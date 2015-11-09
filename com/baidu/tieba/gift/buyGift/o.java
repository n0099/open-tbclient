package com.baidu.tieba.gift.buyGift;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ n bnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bnh = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuyGiftActivity buyGiftActivity;
        BuyGiftActivity buyGiftActivity2;
        buyGiftActivity = this.bnh.bng;
        buyGiftActivity.cB(false);
        buyGiftActivity2 = this.bnh.bng;
        buyGiftActivity2.bmL.setVisibility(0);
    }
}
