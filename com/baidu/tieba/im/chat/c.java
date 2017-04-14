package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity cMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.cMz = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.cMz;
        i2 = this.cMz.mIndex;
        absMsgImageActivity.aN(i2, i);
        this.cMz.mIndex = i;
        this.cMz.amL();
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
            j = this.cMz.cMv;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.cMz.cMj;
                if (linkedHashMap != null) {
                    i2 = this.cMz.mIndex;
                    linkedHashMap2 = this.cMz.cMj;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.cMz.cMw;
                        linkedHashMap3 = this.cMz.cMj;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.cMz.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
