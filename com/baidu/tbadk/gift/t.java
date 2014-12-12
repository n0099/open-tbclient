package com.baidu.tbadk.gift;

import android.util.SparseIntArray;
import android.view.View;
import com.baidu.tbadk.core.view.BaseViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity aaD;
    private int mPosition;

    public t(BuyGiftActivity buyGiftActivity, int i) {
        this.aaD = buyGiftActivity;
        this.mPosition = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseIntArray sparseIntArray;
        BaseViewPager baseViewPager;
        int i;
        SparseIntArray sparseIntArray2;
        int i2 = this.mPosition;
        sparseIntArray = this.aaD.aar;
        int min = Math.min(i2, sparseIntArray.size());
        int i3 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            sparseIntArray2 = this.aaD.aar;
            i3 += sparseIntArray2.get(i4);
        }
        this.aaD.aan = i3;
        baseViewPager = this.aaD.aac;
        i = this.aaD.aan;
        baseViewPager.setCurrentItem(i);
        this.aaD.vI();
    }
}
