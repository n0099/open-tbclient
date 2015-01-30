package com.baidu.tbadk.gift;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity abe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(BuyGiftActivity buyGiftActivity) {
        this.abe = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.abe.vZ();
    }
}
