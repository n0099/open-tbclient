package com.baidu.tbadk.motu_gallery;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {
    final /* synthetic */ JigsawAlbumActivity Wv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(JigsawAlbumActivity jigsawAlbumActivity) {
        this.Wv = jigsawAlbumActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] bArr;
        ArrayList arrayList;
        c cZ;
        Map map;
        u uVar;
        Map map2;
        bArr = this.Wv.Wp;
        synchronized (bArr) {
            try {
                arrayList = this.Wv.We;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    cZ = this.Wv.cZ(((c) it.next()).type);
                    map = this.Wv.Wf;
                    if (!map.containsKey(cZ.path)) {
                        uVar = this.Wv.Wi;
                        Bitmap a = uVar.a(this.Wv, cZ, this.Wv.s(70.0f));
                        map2 = this.Wv.Wf;
                        map2.put(cZ.path, a);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
