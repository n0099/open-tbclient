package com.baidu.tieba.gift.buyGift;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity bmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BuyGiftActivity buyGiftActivity) {
        this.bmC = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bmC.Qp();
    }
}
