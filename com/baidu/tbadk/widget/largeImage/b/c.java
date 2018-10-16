package com.baidu.tbadk.widget.largeImage.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.widget.largeImage.a.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aYa;
    private final BitmapRegionDecoder bjU;
    private final List<BdAsyncTask> bjV = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0144a, com.baidu.tbadk.widget.largeImage.a.a> bjW;
    private final com.baidu.tbadk.widget.largeImage.a.b bjy;

    public void Qo() {
        for (BdAsyncTask bdAsyncTask : this.bjV) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.bjV.clear();
    }

    public void onDestory() {
        Qo();
        if (this.bjW != null) {
            this.bjW.am(0);
            this.bjW.clear();
            this.bjW = null;
        }
        this.aYa = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bjy = bVar;
        this.bjU = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Me().fw((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bjW = new com.baidu.adp.lib.e.a<a.C0144a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0144a c0144a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0144a c0144a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.aYa != null && aVar != null) {
                    aVar.PM();
                    c.this.aYa.t(aVar);
                }
            }
        };
        this.aYa = com.baidu.tbadk.imageManager.c.Me().fu(this.bjy.getBlockSize());
        this.aYa.ap(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bjy, this.bjU, Qp());
        aVar.execute(new Object[0]);
        this.bjV.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0144a, com.baidu.tbadk.widget.largeImage.a.a> Qp() {
        return this.bjW;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> Qq() {
        return this.aYa;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private BitmapRegionDecoder bjU;
        private com.baidu.adp.lib.e.a<a.C0144a, com.baidu.tbadk.widget.largeImage.a.a> bjW;
        private com.baidu.tbadk.widget.largeImage.a.b bjY;
        private com.baidu.tbadk.widget.largeImage.logic.a bjZ;
        private int bjl;
        private c bka;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a PU;
            if (this.bjW != null && this.bjY.r(this.row, this.column, this.bjl)) {
                Rect s = this.bjY.s(this.row, this.column, this.bjl);
                this.bjY.g(s);
                if (!h(s)) {
                    try {
                        PU = this.bka.Qq().jA();
                        if (PU != null) {
                            if (!PU.f(s)) {
                                System.currentTimeMillis();
                                PU.PM();
                            }
                        } else {
                            PU = this.bjY.PU();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bjW.am((int) (this.bjW.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            PU = this.bjY.PU();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bjl;
                    options.inBitmap = PU.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bjU.decodeRegion(s, options);
                    decodeRegion.prepareToDraw();
                    PU.setBitmap(decodeRegion);
                    PU.q(this.row, this.column, this.bjl);
                    this.bjW.put(PU.PP(), PU);
                    if (this.bjZ != null) {
                        this.bjZ.JB();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bjl = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0144a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.bjY = bVar;
            this.bjU = bitmapRegionDecoder;
            this.bjW = aVar;
            this.bka = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.bjZ = aVar;
        }

        private boolean h(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
