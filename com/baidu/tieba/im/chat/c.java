package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity aRi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.aRi = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.aRi;
        i2 = this.aRi.mIndex;
        absMsgImageActivity.P(i2, i);
        this.aRi.mIndex = i;
        this.aRi.Ka();
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
            j = this.aRi.aRe;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.aRi.aQU;
                if (linkedHashMap != null) {
                    i2 = this.aRi.mIndex;
                    linkedHashMap2 = this.aRi.aQU;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.aRi.aRf;
                        linkedHashMap3 = this.aRi.aQU;
                        i3 = this.aRi.mIndex;
                        hashMap.put((String) linkedHashMap3.get(Integer.valueOf(i3)), true);
                    }
                }
            }
        }
    }
}
