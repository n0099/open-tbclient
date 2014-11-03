package com.baidu.tbadk.gift;

import android.util.SparseIntArray;
import android.view.View;
import com.baidu.tbadk.core.view.BaseViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    private int UC;
    final /* synthetic */ BuyGiftActivity Uy;

    public t(BuyGiftActivity buyGiftActivity, int i) {
        this.Uy = buyGiftActivity;
        this.UC = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseIntArray sparseIntArray;
        BaseViewPager baseViewPager;
        int i;
        SparseIntArray sparseIntArray2;
        int i2 = this.UC;
        sparseIntArray = this.Uy.Um;
        int min = Math.min(i2, sparseIntArray.size());
        int i3 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            sparseIntArray2 = this.Uy.Um;
            i3 += sparseIntArray2.get(i4);
        }
        this.Uy.Ui = i3;
        baseViewPager = this.Uy.TX;
        i = this.Uy.Ui;
        baseViewPager.setCurrentItem(i);
        this.Uy.sf();
    }
}
