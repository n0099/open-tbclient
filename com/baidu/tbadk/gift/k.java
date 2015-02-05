package com.baidu.tbadk.gift;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity abb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BuyGiftActivity buyGiftActivity) {
        this.abb = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        view2 = this.abb.aaF;
        if (view2.getVisibility() != 0) {
            this.abb.closeActivity();
            return;
        }
        view3 = this.abb.aaF;
        view3.setVisibility(8);
    }
}
