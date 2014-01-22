package com.baidu.tieba.im.chat;

import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements android.support.v4.view.bq {
    final /* synthetic */ MsgImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(MsgImageActivity msgImageActivity) {
        this.a = msgImageActivity;
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        int i2;
        MsgImageActivity msgImageActivity = this.a;
        i2 = this.a.c;
        msgImageActivity.a(i2, i);
        this.a.c = i;
        this.a.b();
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
        long j;
        ArrayList arrayList;
        int i2;
        ArrayList arrayList2;
        HashMap hashMap;
        ArrayList arrayList3;
        int i3;
        if (i == 1) {
            long nanoTime = System.nanoTime();
            j = this.a.t;
            if (nanoTime - j > 300000000) {
                arrayList = this.a.b;
                if (arrayList != null) {
                    i2 = this.a.c;
                    arrayList2 = this.a.b;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.a.u;
                        arrayList3 = this.a.b;
                        i3 = this.a.c;
                        hashMap.put(arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
