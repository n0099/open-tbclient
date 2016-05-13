package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AbsMsgImageActivity bYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.bYM = absMsgImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        AbsMsgImageActivity absMsgImageActivity = this.bYM;
        i2 = this.bYM.mIndex;
        absMsgImageActivity.ap(i2, i);
        this.bYM.mIndex = i;
        this.bYM.abF();
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
            j = this.bYM.bYI;
            if (nanoTime - j > 300000000) {
                linkedHashMap = this.bYM.bYw;
                if (linkedHashMap != null) {
                    i2 = this.bYM.mIndex;
                    linkedHashMap2 = this.bYM.bYw;
                    if (i2 < linkedHashMap2.size()) {
                        hashMap = this.bYM.bYJ;
                        linkedHashMap3 = this.bYM.bYw;
                        StringBuilder sb = new StringBuilder();
                        i3 = this.bYM.mIndex;
                        hashMap.put((String) linkedHashMap3.get(sb.append(i3).toString()), true);
                    }
                }
            }
        }
    }
}
