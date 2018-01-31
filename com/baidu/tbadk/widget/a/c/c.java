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
    private final com.baidu.tbadk.widget.a.a.b bGd;
    private final BitmapRegionDecoder bGx;
    private final List<BdAsyncTask> bGy = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0093a, com.baidu.tbadk.widget.a.a.a> bGz;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> buv;

    public void Qh() {
        for (BdAsyncTask bdAsyncTask : this.bGy) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.bGy.clear();
    }

    public void onDestory() {
        Qh();
        if (this.bGz != null) {
            this.bGz.dc(0);
            this.bGz.clear();
            this.bGz = null;
        }
        this.buv = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bGd = bVar;
        this.bGx = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.LR().hY((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bGz = new com.baidu.adp.lib.e.a<a.C0093a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0093a c0093a, com.baidu.tbadk.widget.a.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0093a c0093a, com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.a aVar2) {
                if (z && c.this.buv != null && aVar != null) {
                    aVar.PF();
                    c.this.buv.ar(aVar);
                }
            }
        };
        this.buv = com.baidu.tbadk.imageManager.c.LR().hW(this.bGd.getBlockSize());
        this.buv.df(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bGd, this.bGx, Qi());
        aVar.execute(new Object[0]);
        this.bGy.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0093a, com.baidu.tbadk.widget.a.a.a> Qi() {
        return this.bGz;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> Qj() {
        return this.buv;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int bFQ;
        private com.baidu.tbadk.widget.a.a.b bGB;
        private com.baidu.tbadk.widget.a.b.a bGC;
        private c bGD;
        private BitmapRegionDecoder bGx;
        private com.baidu.adp.lib.e.a<a.C0093a, com.baidu.tbadk.widget.a.a.a> bGz;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a PN;
            if (this.bGz != null && this.bGB.z(this.row, this.column, this.bFQ)) {
                Rect A = this.bGB.A(this.row, this.column, this.bFQ);
                this.bGB.i(A);
                if (!j(A)) {
                    try {
                        PN = this.bGD.Qj().nk();
                        if (PN != null) {
                            if (!PN.h(A)) {
                                System.currentTimeMillis();
                                PN.PF();
                            }
                        } else {
                            PN = this.bGB.PN();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bGz.dc((int) (this.bGz.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            PN = this.bGB.PN();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bFQ;
                    options.inBitmap = PN.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bGx.decodeRegion(A, options);
                    decodeRegion.prepareToDraw();
                    PN.setBitmap(decodeRegion);
                    PN.y(this.row, this.column, this.bFQ);
                    this.bGz.put(PN.PI(), PN);
                    if (this.bGC != null) {
                        this.bGC.Ji();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bFQ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0093a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.bGB = bVar;
            this.bGx = bitmapRegionDecoder;
            this.bGz = aVar;
            this.bGD = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.bGC = aVar;
        }

        private boolean j(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
