package com.baidu.tieba.im.groupInfo;

import android.support.v4.view.ViewPager;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GroupImageActivity bah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GroupImageActivity groupImageActivity) {
        this.bah = groupImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        GroupImageActivity groupImageActivity = this.bah;
        i2 = this.bah.mIndex;
        groupImageActivity.M(i2, i);
        this.bah.mIndex = i;
        this.bah.OA();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        long j;
        ArrayList arrayList;
        int i2;
        ArrayList arrayList2;
        HashMap hashMap;
        ArrayList arrayList3;
        int i3;
        if (i == 1) {
            long nanoTime = System.nanoTime();
            j = this.bah.aNw;
            if (nanoTime - j > 300000000) {
                arrayList = this.bah.baf;
                if (arrayList != null) {
                    i2 = this.bah.mIndex;
                    arrayList2 = this.bah.baf;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.bah.aNx;
                        arrayList3 = this.bah.baf;
                        i3 = this.bah.mIndex;
                        hashMap.put((String) arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
