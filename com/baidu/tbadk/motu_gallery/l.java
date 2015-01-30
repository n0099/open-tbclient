package com.baidu.tbadk.motu_gallery;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {
    final /* synthetic */ JigsawAlbumActivity adc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(JigsawAlbumActivity jigsawAlbumActivity) {
        this.adc = jigsawAlbumActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] bArr;
        ArrayList arrayList;
        c dC;
        Map map;
        u uVar;
        Map map2;
        bArr = this.adc.acW;
        synchronized (bArr) {
            try {
                arrayList = this.adc.acL;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    dC = this.adc.dC(((c) it.next()).type);
                    map = this.adc.acM;
                    if (!map.containsKey(dC.path)) {
                        uVar = this.adc.acP;
                        Bitmap a = uVar.a(this.adc.getPageContext().getPageActivity(), dC, this.adc.t(70.0f));
                        map2 = this.adc.acM;
                        map2.put(dC.path, a);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
