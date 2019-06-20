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
    private final BitmapRegionDecoder cHG;
    private final List<BdAsyncTask> cHH = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0261a, com.baidu.tbadk.widget.largeImage.a.a> cHI;
    private final com.baidu.tbadk.widget.largeImage.a.b cHk;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cuL;

    public void awZ() {
        for (BdAsyncTask bdAsyncTask : this.cHH) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.cHH.clear();
    }

    public void onDestory() {
        awZ();
        if (this.cHI != null) {
            this.cHI.ae(0);
            this.cHI.clear();
            this.cHI = null;
        }
        this.cuL = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.cHk = bVar;
        this.cHG = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.asp().kx((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.cHI = new com.baidu.adp.lib.e.a<a.C0261a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0261a c0261a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0261a c0261a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.cuL != null && aVar != null) {
                    aVar.awy();
                    c.this.cuL.t(aVar);
                }
            }
        };
        this.cuL = com.baidu.tbadk.imageManager.c.asp().kv(this.cHk.getBlockSize());
        this.cuL.ah(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.cHk, this.cHG, axa());
        aVar.execute(new Object[0]);
        this.cHH.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0261a, com.baidu.tbadk.widget.largeImage.a.a> axa() {
        return this.cHI;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> axb() {
        return this.cuL;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int cGX;
        private BitmapRegionDecoder cHG;
        private com.baidu.adp.lib.e.a<a.C0261a, com.baidu.tbadk.widget.largeImage.a.a> cHI;
        private com.baidu.tbadk.widget.largeImage.a.b cHK;
        private com.baidu.tbadk.widget.largeImage.logic.a cHL;
        private c cHM;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a awG;
            if (this.cHI != null && this.cHK.v(this.row, this.column, this.cGX)) {
                Rect w = this.cHK.w(this.row, this.column, this.cGX);
                this.cHK.h(w);
                if (!i(w)) {
                    try {
                        awG = this.cHM.axb().iu();
                        if (awG != null) {
                            if (!awG.g(w)) {
                                System.currentTimeMillis();
                                awG.awy();
                            }
                        } else {
                            awG = this.cHK.awG();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.cHI.ae((int) (this.cHI.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            awG = this.cHK.awG();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.cGX;
                    options.inBitmap = awG.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.cHG.decodeRegion(w, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        awG.setBitmap(decodeRegion);
                        awG.u(this.row, this.column, this.cGX);
                        this.cHI.put(awG.awB(), awG);
                        if (this.cHL != null) {
                            this.cHL.apH();
                        }
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.cGX = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0261a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.cHK = bVar;
            this.cHG = bitmapRegionDecoder;
            this.cHI = aVar;
            this.cHM = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.cHL = aVar;
        }

        private boolean i(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
