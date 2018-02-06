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
    private final BitmapRegionDecoder bIB;
    private final List<BdAsyncTask> bIC = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0116a, com.baidu.tbadk.widget.a.a.a> bID;
    private final com.baidu.tbadk.widget.a.a.b bIh;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> bwF;

    public void QM() {
        for (BdAsyncTask bdAsyncTask : this.bIC) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.bIC.clear();
    }

    public void onDestory() {
        QM();
        if (this.bID != null) {
            this.bID.dc(0);
            this.bID.clear();
            this.bID = null;
        }
        this.bwF = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bIh = bVar;
        this.bIB = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Mx().hW((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bID = new com.baidu.adp.lib.e.a<a.C0116a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0116a c0116a, com.baidu.tbadk.widget.a.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0116a c0116a, com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.a aVar2) {
                if (z && c.this.bwF != null && aVar != null) {
                    aVar.Qk();
                    c.this.bwF.ar(aVar);
                }
            }
        };
        this.bwF = com.baidu.tbadk.imageManager.c.Mx().hU(this.bIh.getBlockSize());
        this.bwF.df(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bIh, this.bIB, QN());
        aVar.execute(new Object[0]);
        this.bIC.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0116a, com.baidu.tbadk.widget.a.a.a> QN() {
        return this.bID;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> QO() {
        return this.bwF;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int bHU;
        private BitmapRegionDecoder bIB;
        private com.baidu.adp.lib.e.a<a.C0116a, com.baidu.tbadk.widget.a.a.a> bID;
        private com.baidu.tbadk.widget.a.a.b bIF;
        private com.baidu.tbadk.widget.a.b.a bIG;
        private c bIH;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a Qs;
            if (this.bID != null && this.bIF.A(this.row, this.column, this.bHU)) {
                Rect B = this.bIF.B(this.row, this.column, this.bHU);
                this.bIF.j(B);
                if (!k(B)) {
                    try {
                        Qs = this.bIH.QO().nk();
                        if (Qs != null) {
                            if (!Qs.i(B)) {
                                System.currentTimeMillis();
                                Qs.Qk();
                            }
                        } else {
                            Qs = this.bIF.Qs();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bID.dc((int) (this.bID.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            Qs = this.bIF.Qs();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bHU;
                    options.inBitmap = Qs.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bIB.decodeRegion(B, options);
                    decodeRegion.prepareToDraw();
                    Qs.setBitmap(decodeRegion);
                    Qs.z(this.row, this.column, this.bHU);
                    this.bID.put(Qs.Qn(), Qs);
                    if (this.bIG != null) {
                        this.bIG.JP();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bHU = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0116a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.bIF = bVar;
            this.bIB = bitmapRegionDecoder;
            this.bID = aVar;
            this.bIH = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.bIG = aVar;
        }

        private boolean k(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
