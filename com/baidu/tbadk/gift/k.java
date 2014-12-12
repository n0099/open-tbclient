package com.baidu.tbadk.gift;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity aaD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BuyGiftActivity buyGiftActivity) {
        this.aaD = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        view2 = this.aaD.aah;
        if (view2.getVisibility() != 0) {
            this.aaD.closeActivity();
            return;
        }
        view3 = this.aaD.aah;
        view3.setVisibility(8);
    }
}
