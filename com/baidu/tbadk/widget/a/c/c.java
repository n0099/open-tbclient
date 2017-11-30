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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aGc;
    private final com.baidu.tbadk.widget.a.a.b aRU;
    private final BitmapRegionDecoder aSo;
    private final List<BdAsyncTask> aSp = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aSq;

    public void IS() {
        for (BdAsyncTask bdAsyncTask : this.aSp) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.aSp.clear();
    }

    public void onDestory() {
        IS();
        if (this.aSq != null) {
            this.aSq.aj(0);
            this.aSq.clear();
            this.aSq = null;
        }
        this.aGc = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.aRU = bVar;
        this.aSo = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Ez().fe((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.aSq = new com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
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
                if (z && c.this.aGc != null && aVar != null) {
                    aVar.Ip();
                    c.this.aGc.m(aVar);
                }
            }
        };
        this.aGc = com.baidu.tbadk.imageManager.c.Ez().fc(this.aRU.getBlockSize());
        this.aGc.am(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.aRU, this.aSo, IT());
        aVar.execute(new Object[0]);
        this.aSp.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> IT() {
        return this.aSq;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> IU() {
        return this.aGc;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int aRH;
        private BitmapRegionDecoder aSo;
        private com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aSq;
        private com.baidu.tbadk.widget.a.a.b aSs;
        private com.baidu.tbadk.widget.a.b.a aSt;
        private c aSu;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a Ix;
            if (this.aSq != null && this.aSs.q(this.row, this.column, this.aRH)) {
                Rect r = this.aSs.r(this.row, this.column, this.aRH);
                this.aSs.e(r);
                if (!f(r)) {
                    try {
                        Ix = this.aSu.IU().fH();
                        if (Ix != null) {
                            if (!Ix.d(r)) {
                                System.currentTimeMillis();
                                Ix.Ip();
                            }
                        } else {
                            Ix = this.aSs.Ix();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.aSq.aj((int) (this.aSq.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            Ix = this.aSs.Ix();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.aRH;
                    options.inBitmap = Ix.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.aSo.decodeRegion(r, options);
                    decodeRegion.prepareToDraw();
                    Ix.setBitmap(decodeRegion);
                    Ix.p(this.row, this.column, this.aRH);
                    this.aSq.put(Ix.Is(), Ix);
                    if (this.aSt != null) {
                        this.aSt.BO();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aRH = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.aSs = bVar;
            this.aSo = bitmapRegionDecoder;
            this.aSq = aVar;
            this.aSu = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.aSt = aVar;
        }

        private boolean f(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
