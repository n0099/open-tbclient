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
    private final com.baidu.tbadk.widget.largeImage.a.b cyX;
    private final BitmapRegionDecoder czt;
    private final List<BdAsyncTask> czu = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a> czv;

    public void arW() {
        for (BdAsyncTask bdAsyncTask : this.czu) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.czu.clear();
    }

    public void onDestory() {
        arW();
        if (this.czv != null) {
            this.czv.am(0);
            this.czv.clear();
            this.czv = null;
        }
        this.cmz = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.cyX = bVar;
        this.czt = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.anp().jK((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.czv = new com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
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
                if (z && c.this.cmz != null && aVar != null) {
                    aVar.aru();
                    c.this.cmz.t(aVar);
                }
            }
        };
        this.cmz = com.baidu.tbadk.imageManager.c.anp().jI(this.cyX.getBlockSize());
        this.cmz.ap(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.cyX, this.czt, arX());
        aVar.execute(new Object[0]);
        this.czu.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a> arX() {
        return this.czv;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> arY() {
        return this.cmz;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private int cyK;
        private BitmapRegionDecoder czt;
        private com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a> czv;
        private com.baidu.tbadk.widget.largeImage.a.b czx;
        private com.baidu.tbadk.widget.largeImage.logic.a czy;
        private c czz;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a arC;
            if (this.czv != null && this.czx.u(this.row, this.column, this.cyK)) {
                Rect v = this.czx.v(this.row, this.column, this.cyK);
                this.czx.h(v);
                if (!i(v)) {
                    try {
                        arC = this.czz.arY().jA();
                        if (arC != null) {
                            if (!arC.g(v)) {
                                System.currentTimeMillis();
                                arC.aru();
                            }
                        } else {
                            arC = this.czx.arC();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.czv.am((int) (this.czv.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            arC = this.czx.arC();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.cyK;
                    options.inBitmap = arC.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.czt.decodeRegion(v, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        arC.setBitmap(decodeRegion);
                        arC.t(this.row, this.column, this.cyK);
                        this.czv.put(arC.arx(), arC);
                        if (this.czy != null) {
                            this.czy.akH();
                        }
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.cyK = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.czx = bVar;
            this.czt = bitmapRegionDecoder;
            this.czv = aVar;
            this.czz = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.czy = aVar;
        }

        private boolean i(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
