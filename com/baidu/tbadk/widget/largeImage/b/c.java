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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cmC;
    private final com.baidu.tbadk.widget.largeImage.a.b cza;
    private final BitmapRegionDecoder czw;
    private final List<BdAsyncTask> czx = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a> czy;

    public void arT() {
        for (BdAsyncTask bdAsyncTask : this.czx) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.czx.clear();
    }

    public void onDestory() {
        arT();
        if (this.czy != null) {
            this.czy.al(0);
            this.czy.clear();
            this.czy = null;
        }
        this.cmC = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.cza = bVar;
        this.czw = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.anm().jJ((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.czy = new com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0246a c0246a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0246a c0246a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.cmC != null && aVar != null) {
                    aVar.arr();
                    c.this.cmC.t(aVar);
                }
            }
        };
        this.cmC = com.baidu.tbadk.imageManager.c.anm().jH(this.cza.getBlockSize());
        this.cmC.ao(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.cza, this.czw, arU());
        aVar.execute(new Object[0]);
        this.czx.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a> arU() {
        return this.czy;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> arV() {
        return this.cmC;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private int cyN;
        private com.baidu.tbadk.widget.largeImage.a.b czA;
        private com.baidu.tbadk.widget.largeImage.logic.a czB;
        private c czC;
        private BitmapRegionDecoder czw;
        private com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a> czy;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a arz;
            if (this.czy != null && this.czA.u(this.row, this.column, this.cyN)) {
                Rect v = this.czA.v(this.row, this.column, this.cyN);
                this.czA.h(v);
                if (!i(v)) {
                    try {
                        arz = this.czC.arV().jA();
                        if (arz != null) {
                            if (!arz.g(v)) {
                                System.currentTimeMillis();
                                arz.arr();
                            }
                        } else {
                            arz = this.czA.arz();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.czy.al((int) (this.czy.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            arz = this.czA.arz();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.cyN;
                    options.inBitmap = arz.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.czw.decodeRegion(v, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        arz.setBitmap(decodeRegion);
                        arz.t(this.row, this.column, this.cyN);
                        this.czy.put(arz.aru(), arz);
                        if (this.czB != null) {
                            this.czB.akE();
                        }
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
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
