package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity aNA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsMsgImageActivity absMsgImageActivity) {
        this.aNA = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.aNA;
        i2 = this.aNA.mIndex;
        absMsgImageActivity.M(i2, i);
        this.aNA.mIndex = i;
        this.aNA.Jl();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        long j;
        LinkedHashMap linkedHashMap;
        int i2;
        LinkedHashMap linkedHashMap2;
        HashMap hashMap;
        LinkedHashMap linkedHashMap3;
        int i3;
        if (i == 1) {
            long nanoTime = System.nanoTime();
            j = this.aNA.aNw;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.aNA.aNo;
                if (linkedHashMap != null) {
                    i2 = this.aNA.mIndex;
                    linkedHashMap2 = this.aNA.aNo;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.aNA.aNx;
                        linkedHashMap3 = this.aNA.aNo;
                        i3 = this.aNA.mIndex;
                        hashMap.put((String) linkedHashMap3.get(Integer.valueOf(i3)), true);
                    }
                }
            }
        }
    }
}
