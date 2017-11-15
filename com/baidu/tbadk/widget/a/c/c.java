package com.baidu.tbadk.widget.a.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.widget.a.a.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aFB;
    private final com.baidu.tbadk.widget.a.a.b aOX;
    private final BitmapRegionDecoder aPr;
    private final List<BdAsyncTask> aPs = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aPt;

    public void Iv() {
        for (BdAsyncTask bdAsyncTask : this.aPs) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.aPs.clear();
    }

    public void onDestory() {
        Iv();
        if (this.aPt != null) {
            this.aPt.aj(0);
            this.aPt.clear();
            this.aPt = null;
        }
        this.aFB = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.aOX = bVar;
        this.aPr = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Es().ff((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.aPt = new com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0066a c0066a, com.baidu.tbadk.widget.a.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0066a c0066a, com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.a aVar2) {
                if (z && c.this.aFB != null && aVar != null) {
                    aVar.HS();
                    c.this.aFB.m(aVar);
                }
            }
        };
        this.aFB = com.baidu.tbadk.imageManager.c.Es().fd(this.aOX.getBlockSize());
        this.aFB.am(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.aOX, this.aPr, Iw());
        aVar.execute(new Object[0]);
        this.aPs.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> Iw() {
        return this.aPt;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> Ix() {
        return this.aFB;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int aOK;
        private BitmapRegionDecoder aPr;
        private com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aPt;
        private com.baidu.tbadk.widget.a.a.b aPv;
        private com.baidu.tbadk.widget.a.b.a aPw;
        private c aPx;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a Ia;
            if (this.aPt != null && this.aPv.p(this.row, this.column, this.aOK)) {
                Rect q = this.aPv.q(this.row, this.column, this.aOK);
                this.aPv.e(q);
                if (!f(q)) {
                    try {
                        Ia = this.aPx.Ix().fH();
                        if (Ia != null) {
                            if (!Ia.d(q)) {
                                System.currentTimeMillis();
                                Ia.HS();
                            }
                        } else {
                            Ia = this.aPv.Ia();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.aPt.aj((int) (this.aPt.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            Ia = this.aPv.Ia();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.aOK;
                    options.inBitmap = Ia.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.aPr.decodeRegion(q, options);
                    decodeRegion.prepareToDraw();
                    Ia.setBitmap(decodeRegion);
                    Ia.o(this.row, this.column, this.aOK);
                    this.aPt.put(Ia.HV(), Ia);
                    if (this.aPw != null) {
                        this.aPw.BE();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aOK = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.aPv = bVar;
            this.aPr = bitmapRegionDecoder;
            this.aPt = aVar;
            this.aPx = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.aPw = aVar;
        }

        private boolean f(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
