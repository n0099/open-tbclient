package com.baidu.tieba.im.groupInfo;

import android.support.v4.view.ViewPager;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
final class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GroupImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GroupImageActivity groupImageActivity) {
        this.a = groupImageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        int i2;
        GroupImageActivity groupImageActivity = this.a;
        i2 = this.a.c;
        groupImageActivity.a(i2);
        this.a.c = i;
        this.a.a();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
        long j;
        ArrayList arrayList;
        int i2;
        ArrayList arrayList2;
        HashMap hashMap;
        ArrayList arrayList3;
        int i3;
        if (i == 1) {
            long nanoTime = System.nanoTime();
            j = this.a.s;
            if (nanoTime - j > 300000000) {
                arrayList = this.a.b;
                if (arrayList != null) {
                    i2 = this.a.c;
                    arrayList2 = this.a.b;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.a.t;
                        arrayList3 = this.a.b;
                        i3 = this.a.c;
                        hashMap.put((String) arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
