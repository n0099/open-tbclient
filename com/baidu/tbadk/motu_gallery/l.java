package com.baidu.tbadk.motu_gallery;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {
    final /* synthetic */ JigsawAlbumActivity Wz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(JigsawAlbumActivity jigsawAlbumActivity) {
        this.Wz = jigsawAlbumActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] bArr;
        ArrayList arrayList;
        c cZ;
        Map map;
        u uVar;
        Map map2;
        bArr = this.Wz.Wt;
        synchronized (bArr) {
            try {
                arrayList = this.Wz.Wi;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    cZ = this.Wz.cZ(((c) it.next()).type);
                    map = this.Wz.Wj;
                    if (!map.containsKey(cZ.path)) {
                        uVar = this.Wz.Wm;
                        Bitmap a = uVar.a(this.Wz, cZ, this.Wz.s(70.0f));
                        map2 = this.Wz.Wj;
                        map2.put(cZ.path, a);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
