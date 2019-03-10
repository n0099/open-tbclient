package com.baidu.tbadk.widget.largeImage.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.widget.largeImage.a.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cmz;
    private final com.baidu.tbadk.widget.largeImage.a.b cza;
    private final BitmapRegionDecoder czw;
    private final List<BdAsyncTask> czx = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0212a, com.baidu.tbadk.widget.largeImage.a.a> czy;

    public void arX() {
        for (BdAsyncTask bdAsyncTask : this.czx) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.czx.clear();
    }

    public void onDestory() {
        arX();
        if (this.czy != null) {
            this.czy.am(0);
            this.czy.clear();
            this.czy = null;
        }
        this.cmz = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.cza = bVar;
        this.czw = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.anq().jK((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.czy = new com.baidu.adp.lib.e.a<a.C0212a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0212a c0212a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0212a c0212a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.cmz != null && aVar != null) {
                    aVar.arv();
                    c.this.cmz.t(aVar);
                }
            }
        };
        this.cmz = com.baidu.tbadk.imageManager.c.anq().jI(this.cza.getBlockSize());
        this.cmz.ap(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.cza, this.czw, arY());
        aVar.execute(new Object[0]);
        this.czx.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0212a, com.baidu.tbadk.widget.largeImage.a.a> arY() {
        return this.czy;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> arZ() {
        return this.cmz;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private int cyN;
        private com.baidu.tbadk.widget.largeImage.a.b czA;
        private com.baidu.tbadk.widget.largeImage.logic.a czB;
        private c czC;
        private BitmapRegionDecoder czw;
        private com.baidu.adp.lib.e.a<a.C0212a, com.baidu.tbadk.widget.largeImage.a.a> czy;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a arD;
            if (this.czy != null && this.czA.u(this.row, this.column, this.cyN)) {
                Rect v = this.czA.v(this.row, this.column, this.cyN);
                this.czA.h(v);
                if (!i(v)) {
                    try {
                        arD = this.czC.arZ().jA();
                        if (arD != null) {
                            if (!arD.g(v)) {
                                System.currentTimeMillis();
                                arD.arv();
                            }
                        } else {
                            arD = this.czA.arD();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.czy.am((int) (this.czy.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            arD = this.czA.arD();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.cyN;
                    options.inBitmap = arD.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.czw.decodeRegion(v, options);
                    decodeRegion.prepareToDraw();
                    arD.setBitmap(decodeRegion);
                    arD.t(this.row, this.column, this.cyN);
                    this.czy.put(arD.ary(), arD);
                    if (this.czB != null) {
                        this.czB.akI();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.cyN = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0212a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.czA = bVar;
            this.czw = bitmapRegionDecoder;
            this.czy = aVar;
            this.czC = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.czB = aVar;
        }

        private boolean i(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
