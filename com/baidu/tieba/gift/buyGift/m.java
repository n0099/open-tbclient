package com.baidu.tieba.gift.buyGift;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity buJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BuyGiftActivity buyGiftActivity) {
        this.buJ = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.buJ.buo.getVisibility() == 0) {
            this.buJ.buo.setVisibility(8);
        } else {
            this.buJ.closeActivity();
        }
    }
}
