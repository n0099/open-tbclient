package com.baidu.tbadk.gift;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity abe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BuyGiftActivity buyGiftActivity) {
        this.abe = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        view2 = this.abe.aaI;
        if (view2.getVisibility() != 0) {
            this.abe.closeActivity();
            return;
        }
        view3 = this.abe.aaI;
        view3.setVisibility(8);
    }
}
