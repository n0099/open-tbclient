package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity bnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.bnh = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.bnh;
        i2 = this.bnh.mIndex;
        absMsgImageActivity.ac(i2, i);
        this.bnh.mIndex = i;
        this.bnh.QE();
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
            j = this.bnh.bnd;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.bnh.bmR;
                if (linkedHashMap != null) {
                    i2 = this.bnh.mIndex;
                    linkedHashMap2 = this.bnh.bmR;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.bnh.bne;
                        linkedHashMap3 = this.bnh.bmR;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.bnh.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
