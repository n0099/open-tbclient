package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity aZl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.aZl = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.aZl;
        i2 = this.aZl.mIndex;
        absMsgImageActivity.R(i2, i);
        this.aZl.mIndex = i;
        this.aZl.OS();
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
            j = this.aZl.aZh;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.aZl.aYV;
                if (linkedHashMap != null) {
                    i2 = this.aZl.mIndex;
                    linkedHashMap2 = this.aZl.aYV;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.aZl.aZi;
                        linkedHashMap3 = this.aZl.aYV;
                        i3 = this.aZl.mIndex;
                        hashMap.put((String) linkedHashMap3.get(Integer.valueOf(i3)), true);
                    }
                }
            }
        }
    }
}
