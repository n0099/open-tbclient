package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity brt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.brt = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.brt;
        i2 = this.brt.mIndex;
        absMsgImageActivity.af(i2, i);
        this.brt.mIndex = i;
        this.brt.RF();
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
            j = this.brt.brp;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.brt.brd;
                if (linkedHashMap != null) {
                    i2 = this.brt.mIndex;
                    linkedHashMap2 = this.brt.brd;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.brt.brq;
                        linkedHashMap3 = this.brt.brd;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.brt.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
