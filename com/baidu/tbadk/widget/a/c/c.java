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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aEJ;
    private final com.baidu.tbadk.widget.a.a.b aOI;
    private final BitmapRegionDecoder aPd;
    private final List<BdAsyncTask> aPe = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aPf;

    public void Ia() {
        for (BdAsyncTask bdAsyncTask : this.aPe) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.aPe.clear();
    }

    public void onDestory() {
        Ia();
        if (this.aPf != null) {
            this.aPf.aj(0);
            this.aPf.clear();
            this.aPf = null;
        }
        this.aEJ = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.aOI = bVar;
        this.aPd = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.DT().ff((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.aPf = new com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
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
                if (z && c.this.aEJ != null && aVar != null) {
                    aVar.Hz();
                    c.this.aEJ.m(aVar);
                }
            }
        };
        this.aEJ = com.baidu.tbadk.imageManager.c.DT().fd(this.aOI.getBlockSize());
        this.aEJ.am(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.aOI, this.aPd, Ib());
        aVar.execute(new Object[0]);
        this.aPe.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> Ib() {
        return this.aPf;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> Ic() {
        return this.aEJ;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int aOv;
        private BitmapRegionDecoder aPd;
        private com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aPf;
        private com.baidu.tbadk.widget.a.a.b aPh;
        private com.baidu.tbadk.widget.a.b.a aPi;
        private c aPj;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a HH;
            if (this.aPf != null && this.aPh.q(this.row, this.column, this.aOv)) {
                Rect r = this.aPh.r(this.row, this.column, this.aOv);
                this.aPh.e(r);
                if (!f(r)) {
                    try {
                        HH = this.aPj.Ic().fH();
                        if (HH != null) {
                            if (!HH.d(r)) {
                                System.currentTimeMillis();
                                HH.Hz();
                            }
                        } else {
                            HH = this.aPh.HH();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.aPf.aj((int) (this.aPf.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            HH = this.aPh.HH();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.aOv;
                    options.inBitmap = HH.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.aPd.decodeRegion(r, options);
                    decodeRegion.prepareToDraw();
                    HH.setBitmap(decodeRegion);
                    HH.p(this.row, this.column, this.aOv);
                    this.aPf.put(HH.HC(), HH);
                    if (this.aPi != null) {
                        this.aPi.Be();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aOv = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.aPh = bVar;
            this.aPd = bitmapRegionDecoder;
            this.aPf = aVar;
            this.aPj = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.aPi = aVar;
        }

        private boolean f(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
