package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity bqE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.bqE = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.bqE;
        i2 = this.bqE.mIndex;
        absMsgImageActivity.ad(i2, i);
        this.bqE.mIndex = i;
        this.bqE.Rn();
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
            j = this.bqE.bqA;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.bqE.bqo;
                if (linkedHashMap != null) {
                    i2 = this.bqE.mIndex;
                    linkedHashMap2 = this.bqE.bqo;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.bqE.bqB;
                        linkedHashMap3 = this.bqE.bqo;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.bqE.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
