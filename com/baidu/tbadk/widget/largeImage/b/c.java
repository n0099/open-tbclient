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
    private final BitmapRegionDecoder cHF;
    private final List<BdAsyncTask> cHG = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0261a, com.baidu.tbadk.widget.largeImage.a.a> cHH;
    private final com.baidu.tbadk.widget.largeImage.a.b cHj;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cuK;

    public void awZ() {
        for (BdAsyncTask bdAsyncTask : this.cHG) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.cHG.clear();
    }

    public void onDestory() {
        awZ();
        if (this.cHH != null) {
            this.cHH.ae(0);
            this.cHH.clear();
            this.cHH = null;
        }
        this.cuK = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.cHj = bVar;
        this.cHF = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.asp().kx((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.cHH = new com.baidu.adp.lib.e.a<a.C0261a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
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
                if (z && c.this.cuK != null && aVar != null) {
                    aVar.awy();
                    c.this.cuK.t(aVar);
                }
            }
        };
        this.cuK = com.baidu.tbadk.imageManager.c.asp().kv(this.cHj.getBlockSize());
        this.cuK.ah(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.cHj, this.cHF, axa());
        aVar.execute(new Object[0]);
        this.cHG.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0261a, com.baidu.tbadk.widget.largeImage.a.a> axa() {
        return this.cHH;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> axb() {
        return this.cuK;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int cGW;
        private BitmapRegionDecoder cHF;
        private com.baidu.adp.lib.e.a<a.C0261a, com.baidu.tbadk.widget.largeImage.a.a> cHH;
        private com.baidu.tbadk.widget.largeImage.a.b cHJ;
        private com.baidu.tbadk.widget.largeImage.logic.a cHK;
        private c cHL;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a awG;
            if (this.cHH != null && this.cHJ.v(this.row, this.column, this.cGW)) {
                Rect w = this.cHJ.w(this.row, this.column, this.cGW);
                this.cHJ.h(w);
                if (!i(w)) {
                    try {
                        awG = this.cHL.axb().iu();
                        if (awG != null) {
                            if (!awG.g(w)) {
                                System.currentTimeMillis();
                                awG.awy();
                            }
                        } else {
                            awG = this.cHJ.awG();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.cHH.ae((int) (this.cHH.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            awG = this.cHJ.awG();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.cGW;
                    options.inBitmap = awG.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.cHF.decodeRegion(w, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        awG.setBitmap(decodeRegion);
                        awG.u(this.row, this.column, this.cGW);
                        this.cHH.put(awG.awB(), awG);
                        if (this.cHK != null) {
                            this.cHK.apH();
                        }
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.cGW = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0261a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.cHJ = bVar;
            this.cHF = bitmapRegionDecoder;
            this.cHH = aVar;
            this.cHL = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.cHK = aVar;
        }

        private boolean i(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
