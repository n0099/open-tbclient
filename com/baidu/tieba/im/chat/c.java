package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity bnF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.bnF = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.bnF;
        i2 = this.bnF.mIndex;
        absMsgImageActivity.ac(i2, i);
        this.bnF.mIndex = i;
        this.bnF.QG();
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
            j = this.bnF.bnB;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.bnF.bnp;
                if (linkedHashMap != null) {
                    i2 = this.bnF.mIndex;
                    linkedHashMap2 = this.bnF.bnp;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.bnF.bnC;
                        linkedHashMap3 = this.bnF.bnp;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.bnF.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
