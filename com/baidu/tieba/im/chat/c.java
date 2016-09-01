package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity cSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.cSr = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.cSr;
        i2 = this.cSr.mIndex;
        absMsgImageActivity.aN(i2, i);
        this.cSr.mIndex = i;
        this.cSr.apq();
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
            j = this.cSr.cSn;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.cSr.cSb;
                if (linkedHashMap != null) {
                    i2 = this.cSr.mIndex;
                    linkedHashMap2 = this.cSr.cSb;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.cSr.cSo;
                        linkedHashMap3 = this.cSr.cSb;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.cSr.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
