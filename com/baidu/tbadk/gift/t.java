package com.baidu.tbadk.gift;

import android.util.SparseIntArray;
import android.view.View;
import com.baidu.tbadk.core.view.BaseViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ BuyGiftActivity Uu;
    private int Uy;

    public t(BuyGiftActivity buyGiftActivity, int i) {
        this.Uu = buyGiftActivity;
        this.Uy = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseIntArray sparseIntArray;
        BaseViewPager baseViewPager;
        int i;
        SparseIntArray sparseIntArray2;
        int i2 = this.Uy;
        sparseIntArray = this.Uu.Ui;
        int min = Math.min(i2, sparseIntArray.size());
        int i3 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            sparseIntArray2 = this.Uu.Ui;
            i3 += sparseIntArray2.get(i4);
        }
        this.Uu.Ue = i3;
        baseViewPager = this.Uu.TT;
        i = this.Uu.Ue;
        baseViewPager.setCurrentItem(i);
        this.Uu.sd();
    }
}
