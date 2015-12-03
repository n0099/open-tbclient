package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity bGz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.bGz = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.bGz;
        i2 = this.bGz.mIndex;
        absMsgImageActivity.ah(i2, i);
        this.bGz.mIndex = i;
        this.bGz.UL();
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
            j = this.bGz.bGv;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.bGz.bGj;
                if (linkedHashMap != null) {
                    i2 = this.bGz.mIndex;
                    linkedHashMap2 = this.bGz.bGj;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.bGz.bGw;
                        linkedHashMap3 = this.bGz.bGj;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.bGz.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
