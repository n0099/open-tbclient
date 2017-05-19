package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity cIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.cIT = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.cIT;
        i2 = this.cIT.mIndex;
        absMsgImageActivity.aK(i2, i);
        this.cIT.mIndex = i;
        this.cIT.akF();
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
            j = this.cIT.cIP;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.cIT.cID;
                if (linkedHashMap != null) {
                    i2 = this.cIT.mIndex;
                    linkedHashMap2 = this.cIT.cID;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.cIT.cIQ;
                        linkedHashMap3 = this.cIT.cID;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.cIT.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
