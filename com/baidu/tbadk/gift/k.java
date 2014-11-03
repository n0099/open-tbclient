package com.baidu.tbadk.gift;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity Uy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BuyGiftActivity buyGiftActivity) {
        this.Uy = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        view2 = this.Uy.Uc;
        if (view2.getVisibility() != 0) {
            this.Uy.closeActivity();
            return;
        }
        view3 = this.Uy.Uc;
        view3.setVisibility(8);
    }
}
