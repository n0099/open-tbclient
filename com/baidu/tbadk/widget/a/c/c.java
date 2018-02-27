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
    private final com.baidu.tbadk.widget.a.a.b bHU;
    private final BitmapRegionDecoder bIo;
    private final List<BdAsyncTask> bIp = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0117a, com.baidu.tbadk.widget.a.a.a> bIq;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> bws;

    public void QL() {
        for (BdAsyncTask bdAsyncTask : this.bIp) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.bIp.clear();
    }

    public void onDestory() {
        QL();
        if (this.bIq != null) {
            this.bIq.dc(0);
            this.bIq.clear();
            this.bIq = null;
        }
        this.bws = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bHU = bVar;
        this.bIo = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Mw().hW((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bIq = new com.baidu.adp.lib.e.a<a.C0117a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
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
                if (z && c.this.bws != null && aVar != null) {
                    aVar.Qj();
                    c.this.bws.ar(aVar);
                }
            }
        };
        this.bws = com.baidu.tbadk.imageManager.c.Mw().hU(this.bHU.getBlockSize());
        this.bws.df(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bHU, this.bIo, QM());
        aVar.execute(new Object[0]);
        this.bIp.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0117a, com.baidu.tbadk.widget.a.a.a> QM() {
        return this.bIq;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> QN() {
        return this.bws;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int bHH;
        private BitmapRegionDecoder bIo;
        private com.baidu.adp.lib.e.a<a.C0117a, com.baidu.tbadk.widget.a.a.a> bIq;
        private com.baidu.tbadk.widget.a.a.b bIs;
        private com.baidu.tbadk.widget.a.b.a bIt;
        private c bIu;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a Qr;
            if (this.bIq != null && this.bIs.A(this.row, this.column, this.bHH)) {
                Rect B = this.bIs.B(this.row, this.column, this.bHH);
                this.bIs.j(B);
                if (!k(B)) {
                    try {
                        Qr = this.bIu.QN().nk();
                        if (Qr != null) {
                            if (!Qr.i(B)) {
                                System.currentTimeMillis();
                                Qr.Qj();
                            }
                        } else {
                            Qr = this.bIs.Qr();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bIq.dc((int) (this.bIq.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            Qr = this.bIs.Qr();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bHH;
                    options.inBitmap = Qr.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bIo.decodeRegion(B, options);
                    decodeRegion.prepareToDraw();
                    Qr.setBitmap(decodeRegion);
                    Qr.z(this.row, this.column, this.bHH);
                    this.bIq.put(Qr.Qm(), Qr);
                    if (this.bIt != null) {
                        this.bIt.JO();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bHH = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0117a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.bIs = bVar;
            this.bIo = bitmapRegionDecoder;
            this.bIq = aVar;
            this.bIu = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.bIt = aVar;
        }

        private boolean k(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
