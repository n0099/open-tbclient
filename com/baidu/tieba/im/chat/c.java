package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity cDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.cDW = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.cDW;
        i2 = this.cDW.mIndex;
        absMsgImageActivity.aG(i2, i);
        this.cDW.mIndex = i;
        this.cDW.ajR();
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
            j = this.cDW.cDS;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.cDW.cDG;
                if (linkedHashMap != null) {
                    i2 = this.cDW.mIndex;
                    linkedHashMap2 = this.cDW.cDG;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.cDW.cDT;
                        linkedHashMap3 = this.cDW.cDG;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.cDW.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
