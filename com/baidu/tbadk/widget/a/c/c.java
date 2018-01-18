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
    private final com.baidu.tbadk.widget.a.a.b bFV;
    private final BitmapRegionDecoder bGp;
    private final List<BdAsyncTask> bGq = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0092a, com.baidu.tbadk.widget.a.a.a> bGr;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> bum;

    public void Qf() {
        for (BdAsyncTask bdAsyncTask : this.bGq) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.bGq.clear();
    }

    public void onDestory() {
        Qf();
        if (this.bGr != null) {
            this.bGr.dc(0);
            this.bGr.clear();
            this.bGr = null;
        }
        this.bum = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bFV = bVar;
        this.bGp = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.LP().hY((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bGr = new com.baidu.adp.lib.e.a<a.C0092a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0092a c0092a, com.baidu.tbadk.widget.a.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0092a c0092a, com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.a aVar2) {
                if (z && c.this.bum != null && aVar != null) {
                    aVar.PD();
                    c.this.bum.ar(aVar);
                }
            }
        };
        this.bum = com.baidu.tbadk.imageManager.c.LP().hW(this.bFV.getBlockSize());
        this.bum.df(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bFV, this.bGp, Qg());
        aVar.execute(new Object[0]);
        this.bGq.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0092a, com.baidu.tbadk.widget.a.a.a> Qg() {
        return this.bGr;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> Qh() {
        return this.bum;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int bFI;
        private BitmapRegionDecoder bGp;
        private com.baidu.adp.lib.e.a<a.C0092a, com.baidu.tbadk.widget.a.a.a> bGr;
        private com.baidu.tbadk.widget.a.a.b bGt;
        private com.baidu.tbadk.widget.a.b.a bGu;
        private c bGv;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a PL;
            if (this.bGr != null && this.bGt.z(this.row, this.column, this.bFI)) {
                Rect A = this.bGt.A(this.row, this.column, this.bFI);
                this.bGt.i(A);
                if (!j(A)) {
                    try {
                        PL = this.bGv.Qh().nj();
                        if (PL != null) {
                            if (!PL.h(A)) {
                                System.currentTimeMillis();
                                PL.PD();
                            }
                        } else {
                            PL = this.bGt.PL();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bGr.dc((int) (this.bGr.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            PL = this.bGt.PL();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bFI;
                    options.inBitmap = PL.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bGp.decodeRegion(A, options);
                    decodeRegion.prepareToDraw();
                    PL.setBitmap(decodeRegion);
                    PL.y(this.row, this.column, this.bFI);
                    this.bGr.put(PL.PG(), PL);
                    if (this.bGu != null) {
                        this.bGu.Jg();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bFI = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0092a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.bGt = bVar;
            this.bGp = bitmapRegionDecoder;
            this.bGr = aVar;
            this.bGv = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.bGu = aVar;
        }

        private boolean j(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
