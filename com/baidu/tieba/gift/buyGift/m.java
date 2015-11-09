package com.baidu.tieba.gift.buyGift;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity bng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BuyGiftActivity buyGiftActivity) {
        this.bng = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bng.bmL.getVisibility() == 0) {
            this.bng.bmL.setVisibility(8);
        } else {
            this.bng.closeActivity();
        }
    }
}
