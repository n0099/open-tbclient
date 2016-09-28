package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity cTL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.cTL = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.cTL;
        i2 = this.cTL.mIndex;
        absMsgImageActivity.aP(i2, i);
        this.cTL.mIndex = i;
        this.cTL.apP();
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
            j = this.cTL.cTH;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.cTL.cTv;
                if (linkedHashMap != null) {
                    i2 = this.cTL.mIndex;
                    linkedHashMap2 = this.cTL.cTv;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.cTL.cTI;
                        linkedHashMap3 = this.cTL.cTv;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.cTL.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
