package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity cLO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.cLO = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.cLO;
        i2 = this.cLO.mIndex;
        absMsgImageActivity.aL(i2, i);
        this.cLO.mIndex = i;
        this.cLO.anx();
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
            j = this.cLO.cLK;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.cLO.cLy;
                if (linkedHashMap != null) {
                    i2 = this.cLO.mIndex;
                    linkedHashMap2 = this.cLO.cLy;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.cLO.cLL;
                        linkedHashMap3 = this.cLO.cLy;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.cLO.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
