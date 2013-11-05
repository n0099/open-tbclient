package com.baidu.tieba.im.groupInfo;

import android.support.v4.view.bq;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupImageActivity f1601a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GroupImageActivity groupImageActivity) {
        this.f1601a = groupImageActivity;
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        int i2;
        GroupImageActivity groupImageActivity = this.f1601a;
        i2 = this.f1601a.c;
        groupImageActivity.b(i2, i);
        this.f1601a.c = i;
        this.f1601a.c();
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
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
            j = this.f1601a.t;
            if (nanoTime - j > 300000000) {
                arrayList = this.f1601a.b;
                if (arrayList != null) {
                    i2 = this.f1601a.c;
                    arrayList2 = this.f1601a.b;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.f1601a.u;
                        arrayList3 = this.f1601a.b;
                        i3 = this.f1601a.c;
                        hashMap.put(arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
