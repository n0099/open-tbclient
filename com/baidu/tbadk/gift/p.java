package com.baidu.tbadk.gift;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity abe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BuyGiftActivity buyGiftActivity) {
        this.abe = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        view2 = this.abe.aaI;
        view2.setVisibility(8);
    }
}
