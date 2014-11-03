package com.baidu.tieba.im.groupInfo;

import android.support.v4.view.ViewPager;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GroupImageActivity baw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GroupImageActivity groupImageActivity) {
        this.baw = groupImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        GroupImageActivity groupImageActivity = this.baw;
        i2 = this.baw.mIndex;
        groupImageActivity.M(i2, i);
        this.baw.mIndex = i;
        this.baw.OD();
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
            j = this.baw.aNK;
            if (nanoTime - j > 300000000) {
                arrayList = this.baw.bat;
                if (arrayList != null) {
                    i2 = this.baw.mIndex;
                    arrayList2 = this.baw.bat;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.baw.aNL;
                        arrayList3 = this.baw.bat;
                        i3 = this.baw.mIndex;
                        hashMap.put((String) arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
