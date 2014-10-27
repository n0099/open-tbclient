package com.baidu.tbadk.gift;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity Uu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BuyGiftActivity buyGiftActivity) {
        this.Uu = buyGiftActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        view2 = this.Uu.TY;
        if (view2.getVisibility() != 0) {
            this.Uu.closeActivity();
            return;
        }
        view3 = this.Uu.TY;
        view3.setVisibility(8);
    }
}
