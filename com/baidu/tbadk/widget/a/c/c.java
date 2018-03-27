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
    private final com.baidu.tbadk.widget.a.a.b bHX;
    private final BitmapRegionDecoder bIr;
    private final List<BdAsyncTask> bIs = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0117a, com.baidu.tbadk.widget.a.a.a> bIt;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> bwv;

    public void QM() {
        for (BdAsyncTask bdAsyncTask : this.bIs) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.bIs.clear();
    }

    public void onDestory() {
        QM();
        if (this.bIt != null) {
            this.bIt.dc(0);
            this.bIt.clear();
            this.bIt = null;
        }
        this.bwv = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bHX = bVar;
        this.bIr = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Mx().hW((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bIt = new com.baidu.adp.lib.e.a<a.C0117a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0117a c0117a, com.baidu.tbadk.widget.a.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0117a c0117a, com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.a aVar2) {
                if (z && c.this.bwv != null && aVar != null) {
                    aVar.Qk();
                    c.this.bwv.ar(aVar);
                }
            }
        };
        this.bwv = com.baidu.tbadk.imageManager.c.Mx().hU(this.bHX.getBlockSize());
        this.bwv.df(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bHX, this.bIr, QN());
        aVar.execute(new Object[0]);
        this.bIs.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0117a, com.baidu.tbadk.widget.a.a.a> QN() {
        return this.bIt;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> QO() {
        return this.bwv;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int bHK;
        private BitmapRegionDecoder bIr;
        private com.baidu.adp.lib.e.a<a.C0117a, com.baidu.tbadk.widget.a.a.a> bIt;
        private com.baidu.tbadk.widget.a.a.b bIv;
        private com.baidu.tbadk.widget.a.b.a bIw;
        private c bIx;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a Qs;
            if (this.bIt != null && this.bIv.A(this.row, this.column, this.bHK)) {
                Rect B = this.bIv.B(this.row, this.column, this.bHK);
                this.bIv.j(B);
                if (!k(B)) {
                    try {
                        Qs = this.bIx.QO().nk();
                        if (Qs != null) {
                            if (!Qs.i(B)) {
                                System.currentTimeMillis();
                                Qs.Qk();
                            }
                        } else {
                            Qs = this.bIv.Qs();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bIt.dc((int) (this.bIt.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            Qs = this.bIv.Qs();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bHK;
                    options.inBitmap = Qs.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bIr.decodeRegion(B, options);
                    decodeRegion.prepareToDraw();
                    Qs.setBitmap(decodeRegion);
                    Qs.z(this.row, this.column, this.bHK);
                    this.bIt.put(Qs.Qn(), Qs);
                    if (this.bIw != null) {
                        this.bIw.JP();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bHK = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0117a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.bIv = bVar;
            this.bIr = bitmapRegionDecoder;
            this.bIt = aVar;
            this.bIx = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.bIw = aVar;
        }

        private boolean k(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
