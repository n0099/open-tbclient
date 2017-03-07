package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity cOc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.cOc = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.cOc;
        i2 = this.cOc.mIndex;
        absMsgImageActivity.aP(i2, i);
        this.cOc.mIndex = i;
        this.cOc.amR();
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
            j = this.cOc.cNY;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.cOc.cNM;
                if (linkedHashMap != null) {
                    i2 = this.cOc.mIndex;
                    linkedHashMap2 = this.cOc.cNM;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.cOc.cNZ;
                        linkedHashMap3 = this.cOc.cNM;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.cOc.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
