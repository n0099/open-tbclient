package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity aZm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.aZm = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.aZm;
        i2 = this.aZm.mIndex;
        absMsgImageActivity.R(i2, i);
        this.aZm.mIndex = i;
        this.aZm.OT();
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
            j = this.aZm.aZi;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.aZm.aYW;
                if (linkedHashMap != null) {
                    i2 = this.aZm.mIndex;
                    linkedHashMap2 = this.aZm.aYW;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.aZm.aZj;
                        linkedHashMap3 = this.aZm.aYW;
                        i3 = this.aZm.mIndex;
                        hashMap.put((String) linkedHashMap3.get(Integer.valueOf(i3)), true);
                    }
                }
            }
        }
    }
}
