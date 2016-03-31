package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity bYh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.bYh = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.bYh;
        i2 = this.bYh.mIndex;
        absMsgImageActivity.aq(i2, i);
        this.bYh.mIndex = i;
        this.bYh.abE();
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
            j = this.bYh.bYd;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.bYh.bXR;
                if (linkedHashMap != null) {
                    i2 = this.bYh.mIndex;
                    linkedHashMap2 = this.bYh.bXR;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.bYh.bYe;
                        linkedHashMap3 = this.bYh.bXR;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.bYh.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
