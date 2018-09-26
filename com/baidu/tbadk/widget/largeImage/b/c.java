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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aTB;
    private final BitmapRegionDecoder bfE;
    private final List<BdAsyncTask> bfF = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0120a, com.baidu.tbadk.widget.largeImage.a.a> bfG;
    private final com.baidu.tbadk.widget.largeImage.a.b bfi;

    public void Os() {
        for (BdAsyncTask bdAsyncTask : this.bfF) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.bfF.clear();
    }

    public void onDestory() {
        Os();
        if (this.bfG != null) {
            this.bfG.am(0);
            this.bfG.clear();
            this.bfG = null;
        }
        this.aTB = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bfi = bVar;
        this.bfE = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Kg().fn((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bfG = new com.baidu.adp.lib.e.a<a.C0120a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0120a c0120a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0120a c0120a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.aTB != null && aVar != null) {
                    aVar.NQ();
                    c.this.aTB.q(aVar);
                }
            }
        };
        this.aTB = com.baidu.tbadk.imageManager.c.Kg().fl(this.bfi.getBlockSize());
        this.aTB.ap(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bfi, this.bfE, Ot());
        aVar.execute(new Object[0]);
        this.bfF.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0120a, com.baidu.tbadk.widget.largeImage.a.a> Ot() {
        return this.bfG;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> Ou() {
        return this.aTB;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int beU;
        private BitmapRegionDecoder bfE;
        private com.baidu.adp.lib.e.a<a.C0120a, com.baidu.tbadk.widget.largeImage.a.a> bfG;
        private com.baidu.tbadk.widget.largeImage.a.b bfI;
        private com.baidu.tbadk.widget.largeImage.logic.a bfJ;
        private c bfK;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a NY;
            if (this.bfG != null && this.bfI.r(this.row, this.column, this.beU)) {
                Rect s = this.bfI.s(this.row, this.column, this.beU);
                this.bfI.g(s);
                if (!h(s)) {
                    try {
                        NY = this.bfK.Ou().jl();
                        if (NY != null) {
                            if (!NY.f(s)) {
                                System.currentTimeMillis();
                                NY.NQ();
                            }
                        } else {
                            NY = this.bfI.NY();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bfG.am((int) (this.bfG.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            NY = this.bfI.NY();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.beU;
                    options.inBitmap = NY.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bfE.decodeRegion(s, options);
                    decodeRegion.prepareToDraw();
                    NY.setBitmap(decodeRegion);
                    NY.q(this.row, this.column, this.beU);
                    this.bfG.put(NY.NT(), NY);
                    if (this.bfJ != null) {
                        this.bfJ.HA();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.beU = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0120a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.bfI = bVar;
            this.bfE = bitmapRegionDecoder;
            this.bfG = aVar;
            this.bfK = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.bfJ = aVar;
        }

        private boolean h(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
