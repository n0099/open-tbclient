package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity cEF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.cEF = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.cEF;
        i2 = this.cEF.mIndex;
        absMsgImageActivity.aL(i2, i);
        this.cEF.mIndex = i;
        this.cEF.amo();
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
            j = this.cEF.cEB;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.cEF.cEp;
                if (linkedHashMap != null) {
                    i2 = this.cEF.mIndex;
                    linkedHashMap2 = this.cEF.cEp;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.cEF.cEC;
                        linkedHashMap3 = this.cEF.cEp;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.cEF.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
