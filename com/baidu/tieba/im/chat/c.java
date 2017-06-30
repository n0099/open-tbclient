package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity cWn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.cWn = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.cWn;
        i2 = this.cWn.mIndex;
        absMsgImageActivity.aP(i2, i);
        this.cWn.mIndex = i;
        this.cWn.apq();
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
            j = this.cWn.cWj;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.cWn.cVX;
                if (linkedHashMap != null) {
                    i2 = this.cWn.mIndex;
                    linkedHashMap2 = this.cWn.cVX;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.cWn.cWk;
                        linkedHashMap3 = this.cWn.cVX;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.cWn.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
