package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.aQe = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.aQe;
        i2 = this.aQe.mIndex;
        absMsgImageActivity.N(i2, i);
        this.aQe.mIndex = i;
        this.aQe.JK();
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
            j = this.aQe.aQa;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.aQe.aPQ;
                if (linkedHashMap != null) {
                    i2 = this.aQe.mIndex;
                    linkedHashMap2 = this.aQe.aPQ;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.aQe.aQb;
                        linkedHashMap3 = this.aQe.aPQ;
                        i3 = this.aQe.mIndex;
                        hashMap.put((String) linkedHashMap3.get(Integer.valueOf(i3)), true);
                    }
                }
            }
        }
    }
}
