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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aEW;
    private final com.baidu.tbadk.widget.a.a.b aOV;
    private final BitmapRegionDecoder aPq;
    private final List<BdAsyncTask> aPr = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aPs;

    public void Ig() {
        for (BdAsyncTask bdAsyncTask : this.aPr) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.aPr.clear();
    }

    public void onDestory() {
        Ig();
        if (this.aPs != null) {
            this.aPs.aj(0);
            this.aPs.clear();
            this.aPs = null;
        }
        this.aEW = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.aOV = bVar;
        this.aPq = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.DZ().fg((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.aPs = new com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
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
                if (z && c.this.aEW != null && aVar != null) {
                    aVar.HF();
                    c.this.aEW.m(aVar);
                }
            }
        };
        this.aEW = com.baidu.tbadk.imageManager.c.DZ().fe(this.aOV.getBlockSize());
        this.aEW.am(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.aOV, this.aPq, Ih());
        aVar.execute(new Object[0]);
        this.aPr.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> Ih() {
        return this.aPs;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> Ii() {
        return this.aEW;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int aOI;
        private BitmapRegionDecoder aPq;
        private com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aPs;
        private com.baidu.tbadk.widget.a.a.b aPu;
        private com.baidu.tbadk.widget.a.b.a aPv;
        private c aPw;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a HN;
            if (this.aPs != null && this.aPu.q(this.row, this.column, this.aOI)) {
                Rect r = this.aPu.r(this.row, this.column, this.aOI);
                this.aPu.e(r);
                if (!f(r)) {
                    try {
                        HN = this.aPw.Ii().fH();
                        if (HN != null) {
                            if (!HN.d(r)) {
                                System.currentTimeMillis();
                                HN.HF();
                            }
                        } else {
                            HN = this.aPu.HN();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.aPs.aj((int) (this.aPs.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            HN = this.aPu.HN();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.aOI;
                    options.inBitmap = HN.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.aPq.decodeRegion(r, options);
                    decodeRegion.prepareToDraw();
                    HN.setBitmap(decodeRegion);
                    HN.p(this.row, this.column, this.aOI);
                    this.aPs.put(HN.HI(), HN);
                    if (this.aPv != null) {
                        this.aPv.Bk();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aOI = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.aPu = bVar;
            this.aPq = bitmapRegionDecoder;
            this.aPs = aVar;
            this.aPw = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.aPv = aVar;
        }

        private boolean f(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
