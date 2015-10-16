package com.baidu.tieba.gift.buyGift;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity bmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BuyGiftActivity buyGiftActivity) {
        this.bmC = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bmC.bmh.getVisibility() == 0) {
            this.bmC.bmh.setVisibility(8);
        } else {
            this.bmC.closeActivity();
        }
    }
}
