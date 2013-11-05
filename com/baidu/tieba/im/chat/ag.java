package com.baidu.tieba.im.chat;

import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements android.support.v4.view.bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgImageActivity f1409a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(MsgImageActivity msgImageActivity) {
        this.f1409a = msgImageActivity;
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        int i2;
        MsgImageActivity msgImageActivity = this.f1409a;
        i2 = this.f1409a.c;
        msgImageActivity.b(i2, i);
        this.f1409a.c = i;
        this.f1409a.c();
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
            j = this.f1409a.u;
            if (nanoTime - j > 300000000) {
                arrayList = this.f1409a.b;
                if (arrayList != null) {
                    i2 = this.f1409a.c;
                    arrayList2 = this.f1409a.b;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.f1409a.v;
                        arrayList3 = this.f1409a.b;
                        i3 = this.f1409a.c;
                        hashMap.put(arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
