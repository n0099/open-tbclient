package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity aaD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BuyGiftActivity buyGiftActivity) {
        this.aaD = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        View view2;
        this.aaD.mPassword = "";
        editText = this.aaD.aav;
        editText.clearFocus();
        view2 = this.aaD.aat;
        view2.setVisibility(8);
    }
}
