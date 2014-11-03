package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity aNO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsMsgImageActivity absMsgImageActivity) {
        this.aNO = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.aNO;
        i2 = this.aNO.mIndex;
        absMsgImageActivity.M(i2, i);
        this.aNO.mIndex = i;
        this.aNO.Jp();
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
            j = this.aNO.aNK;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.aNO.aNC;
                if (linkedHashMap != null) {
                    i2 = this.aNO.mIndex;
                    linkedHashMap2 = this.aNO.aNC;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.aNO.aNL;
                        linkedHashMap3 = this.aNO.aNC;
                        i3 = this.aNO.mIndex;
                        hashMap.put((String) linkedHashMap3.get(Integer.valueOf(i3)), true);
                    }
                }
            }
        }
    }
}
