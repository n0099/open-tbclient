package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity bNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.bNP = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.bNP;
        i2 = this.bNP.mIndex;
        absMsgImageActivity.at(i2, i);
        this.bNP.mIndex = i;
        this.bNP.Yl();
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
            j = this.bNP.bNL;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.bNP.bNz;
                if (linkedHashMap != null) {
                    i2 = this.bNP.mIndex;
                    linkedHashMap2 = this.bNP.bNz;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.bNP.bNM;
                        linkedHashMap3 = this.bNP.bNz;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.bNP.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
