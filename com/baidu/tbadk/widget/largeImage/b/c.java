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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> bda;
    private final BitmapRegionDecoder boV;
    private final List<BdAsyncTask> boW = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> boX;
    private final com.baidu.tbadk.widget.largeImage.a.b boz;

    public void Sb() {
        for (BdAsyncTask bdAsyncTask : this.boW) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.boW.clear();
    }

    public void onDestory() {
        Sb();
        if (this.boX != null) {
            this.boX.aD(0);
            this.boX.clear();
            this.boX = null;
        }
        this.bda = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.boz = bVar;
        this.boV = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.NM().fZ((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.boX = new com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0178a c0178a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0178a c0178a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.bda != null && aVar != null) {
                    aVar.Rz();
                    c.this.bda.t(aVar);
                }
            }
        };
        this.bda = com.baidu.tbadk.imageManager.c.NM().fX(this.boz.getBlockSize());
        this.bda.aG(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.boz, this.boV, Sc());
        aVar.execute(new Object[0]);
        this.boW.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> Sc() {
        return this.boX;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> Sd() {
        return this.bda;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private BitmapRegionDecoder boV;
        private com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> boX;
        private com.baidu.tbadk.widget.largeImage.a.b boZ;
        private int bom;
        private com.baidu.tbadk.widget.largeImage.logic.a bpa;
        private c bpb;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a RH;
            if (this.boX != null && this.boZ.r(this.row, this.column, this.bom)) {
                Rect s = this.boZ.s(this.row, this.column, this.bom);
                this.boZ.g(s);
                if (!h(s)) {
                    try {
                        RH = this.bpb.Sd().jy();
                        if (RH != null) {
                            if (!RH.f(s)) {
                                System.currentTimeMillis();
                                RH.Rz();
                            }
                        } else {
                            RH = this.boZ.RH();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.boX.aD((int) (this.boX.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            RH = this.boZ.RH();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bom;
                    options.inBitmap = RH.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.boV.decodeRegion(s, options);
                    decodeRegion.prepareToDraw();
                    RH.setBitmap(decodeRegion);
                    RH.q(this.row, this.column, this.bom);
                    this.boX.put(RH.RC(), RH);
                    if (this.bpa != null) {
                        this.bpa.Lh();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bom = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.boZ = bVar;
            this.boV = bitmapRegionDecoder;
            this.boX = aVar;
            this.bpb = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.bpa = aVar;
        }

        private boolean h(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
