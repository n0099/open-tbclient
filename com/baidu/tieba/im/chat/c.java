package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity bKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.bKg = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.bKg;
        i2 = this.bKg.mIndex;
        absMsgImageActivity.at(i2, i);
        this.bKg.mIndex = i;
        this.bKg.VR();
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
            j = this.bKg.bKc;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.bKg.bJQ;
                if (linkedHashMap != null) {
                    i2 = this.bKg.mIndex;
                    linkedHashMap2 = this.bKg.bJQ;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.bKg.bKd;
                        linkedHashMap3 = this.bKg.bJQ;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.bKg.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
