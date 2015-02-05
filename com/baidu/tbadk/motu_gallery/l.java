package com.baidu.tbadk.motu_gallery;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {
    final /* synthetic */ JigsawAlbumActivity acZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(JigsawAlbumActivity jigsawAlbumActivity) {
        this.acZ = jigsawAlbumActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] bArr;
        ArrayList arrayList;
        c dC;
        Map map;
        u uVar;
        Map map2;
        bArr = this.acZ.acT;
        synchronized (bArr) {
            try {
                arrayList = this.acZ.acI;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    dC = this.acZ.dC(((c) it.next()).type);
                    map = this.acZ.acJ;
                    if (!map.containsKey(dC.path)) {
                        uVar = this.acZ.acM;
                        Bitmap a = uVar.a(this.acZ.getPageContext().getPageActivity(), dC, this.acZ.t(70.0f));
                        map2 = this.acZ.acJ;
                        map2.put(dC.path, a);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
