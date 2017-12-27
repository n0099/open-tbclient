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
    private final com.baidu.tbadk.widget.a.a.b bFN;
    private final BitmapRegionDecoder bGh;
    private final List<BdAsyncTask> bGi = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0093a, com.baidu.tbadk.widget.a.a.a> bGj;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> buc;

    public void Qr() {
        for (BdAsyncTask bdAsyncTask : this.bGi) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.bGi.clear();
    }

    public void onDestory() {
        Qr();
        if (this.bGj != null) {
            this.bGj.dc(0);
            this.bGj.clear();
            this.bGj = null;
        }
        this.buc = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bFN = bVar;
        this.bGh = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Mb().ic((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bGj = new com.baidu.adp.lib.e.a<a.C0093a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
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
                if (z && c.this.buc != null && aVar != null) {
                    aVar.PP();
                    c.this.buc.ar(aVar);
                }
            }
        };
        this.buc = com.baidu.tbadk.imageManager.c.Mb().ia(this.bFN.getBlockSize());
        this.buc.df(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bFN, this.bGh, Qs());
        aVar.execute(new Object[0]);
        this.bGi.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0093a, com.baidu.tbadk.widget.a.a.a> Qs() {
        return this.bGj;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> Qt() {
        return this.buc;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int bFA;
        private BitmapRegionDecoder bGh;
        private com.baidu.adp.lib.e.a<a.C0093a, com.baidu.tbadk.widget.a.a.a> bGj;
        private com.baidu.tbadk.widget.a.a.b bGl;
        private com.baidu.tbadk.widget.a.b.a bGm;
        private c bGn;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a PX;
            if (this.bGj != null && this.bGl.z(this.row, this.column, this.bFA)) {
                Rect A = this.bGl.A(this.row, this.column, this.bFA);
                this.bGl.i(A);
                if (!j(A)) {
                    try {
                        PX = this.bGn.Qt().nj();
                        if (PX != null) {
                            if (!PX.h(A)) {
                                System.currentTimeMillis();
                                PX.PP();
                            }
                        } else {
                            PX = this.bGl.PX();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bGj.dc((int) (this.bGj.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            PX = this.bGl.PX();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bFA;
                    options.inBitmap = PX.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bGh.decodeRegion(A, options);
                    decodeRegion.prepareToDraw();
                    PX.setBitmap(decodeRegion);
                    PX.y(this.row, this.column, this.bFA);
                    this.bGj.put(PX.PS(), PX);
                    if (this.bGm != null) {
                        this.bGm.Jr();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bFA = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0093a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.bGl = bVar;
            this.bGh = bitmapRegionDecoder;
            this.bGj = aVar;
            this.bGn = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.bGm = aVar;
        }

        private boolean j(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
