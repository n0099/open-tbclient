package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity bqP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.bqP = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.bqP;
        i2 = this.bqP.mIndex;
        absMsgImageActivity.ad(i2, i);
        this.bqP.mIndex = i;
        this.bqP.Rj();
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
            j = this.bqP.bqL;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.bqP.bqz;
                if (linkedHashMap != null) {
                    i2 = this.bqP.mIndex;
                    linkedHashMap2 = this.bqP.bqz;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.bqP.bqM;
                        linkedHashMap3 = this.bqP.bqz;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.bqP.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
