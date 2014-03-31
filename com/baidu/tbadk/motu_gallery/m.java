package com.baidu.tbadk.motu_gallery;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends Thread {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        byte[] bArr;
        ArrayList arrayList;
        Map map;
        Map map2;
        w unused;
        bArr = this.a.s;
        synchronized (bArr) {
            try {
                arrayList = this.a.f;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c a = d.a(this.a, ((c) it.next()).a);
                    map = this.a.h;
                    if (!map.containsKey(a.b)) {
                        unused = this.a.k;
                        Bitmap a2 = w.a(this.a, a, this.a.a(70.0f));
                        map2 = this.a.h;
                        map2.put(a.b, a2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
