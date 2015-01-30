package com.baidu.tbadk.gift;

import android.util.SparseIntArray;
import android.view.View;
import com.baidu.tbadk.core.view.BaseViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity abe;
    private int mPosition;

    public t(BuyGiftActivity buyGiftActivity, int i) {
        this.abe = buyGiftActivity;
        this.mPosition = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseIntArray sparseIntArray;
        BaseViewPager baseViewPager;
        int i;
        SparseIntArray sparseIntArray2;
        int i2 = this.mPosition;
        sparseIntArray = this.abe.aaS;
        int min = Math.min(i2, sparseIntArray.size());
        int i3 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            sparseIntArray2 = this.abe.aaS;
            i3 += sparseIntArray2.get(i4);
        }
        this.abe.aaO = i3;
        baseViewPager = this.abe.aaD;
        i = this.abe.aaO;
        baseViewPager.setCurrentItem(i);
        this.abe.wb();
    }
}
