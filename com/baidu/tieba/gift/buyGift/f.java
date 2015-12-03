package com.baidu.tieba.gift.buyGift;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ BuyGiftActivity buJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BuyGiftActivity buyGiftActivity) {
        this.buJ = buyGiftActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.a aVar;
        aVar = this.buJ.buz;
        aVar.tv();
    }
}
