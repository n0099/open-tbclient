package com.baidu.tieba.im.chat;

import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements android.support.v4.view.bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgImageActivity f1542a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(MsgImageActivity msgImageActivity) {
        this.f1542a = msgImageActivity;
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        int i2;
        MsgImageActivity msgImageActivity = this.f1542a;
        i2 = this.f1542a.c;
        msgImageActivity.a(i2, i);
        this.f1542a.c = i;
        this.f1542a.b();
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
            j = this.f1542a.t;
            if (nanoTime - j > 300000000) {
                arrayList = this.f1542a.b;
                if (arrayList != null) {
                    i2 = this.f1542a.c;
                    arrayList2 = this.f1542a.b;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.f1542a.u;
                        arrayList3 = this.f1542a.b;
                        i3 = this.f1542a.c;
                        hashMap.put(arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
