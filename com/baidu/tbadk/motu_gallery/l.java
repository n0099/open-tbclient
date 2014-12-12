package com.baidu.tbadk.motu_gallery;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {
    final /* synthetic */ JigsawAlbumActivity acF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(JigsawAlbumActivity jigsawAlbumActivity) {
        this.acF = jigsawAlbumActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] bArr;
        ArrayList arrayList;
        c dw;
        Map map;
        u uVar;
        Map map2;
        bArr = this.acF.acz;
        synchronized (bArr) {
            try {
                arrayList = this.acF.acn;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    dw = this.acF.dw(((c) it.next()).type);
                    map = this.acF.aco;
                    if (!map.containsKey(dw.path)) {
                        uVar = this.acF.acr;
                        Bitmap a = uVar.a(this.acF.getPageContext().getPageActivity(), dw, this.acF.dip2px(70.0f));
                        map2 = this.acF.aco;
                        map2.put(dw.path, a);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
