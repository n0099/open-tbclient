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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> bcZ;
    private final BitmapRegionDecoder boU;
    private final List<BdAsyncTask> boV = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> boW;
    private final com.baidu.tbadk.widget.largeImage.a.b boy;

    public void Sb() {
        for (BdAsyncTask bdAsyncTask : this.boV) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.boV.clear();
    }

    public void onDestory() {
        Sb();
        if (this.boW != null) {
            this.boW.aD(0);
            this.boW.clear();
            this.boW = null;
        }
        this.bcZ = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.boy = bVar;
        this.boU = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.NM().fZ((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.boW = new com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
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
                if (z && c.this.bcZ != null && aVar != null) {
                    aVar.Rz();
                    c.this.bcZ.t(aVar);
                }
            }
        };
        this.bcZ = com.baidu.tbadk.imageManager.c.NM().fX(this.boy.getBlockSize());
        this.bcZ.aG(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.boy, this.boU, Sc());
        aVar.execute(new Object[0]);
        this.boV.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> Sc() {
        return this.boW;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> Sd() {
        return this.bcZ;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private BitmapRegionDecoder boU;
        private com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> boW;
        private com.baidu.tbadk.widget.largeImage.a.b boY;
        private com.baidu.tbadk.widget.largeImage.logic.a boZ;
        private int bol;
        private c bpa;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a RH;
            if (this.boW != null && this.boY.r(this.row, this.column, this.bol)) {
                Rect s = this.boY.s(this.row, this.column, this.bol);
                this.boY.g(s);
                if (!h(s)) {
                    try {
                        RH = this.bpa.Sd().jy();
                        if (RH != null) {
                            if (!RH.f(s)) {
                                System.currentTimeMillis();
                                RH.Rz();
                            }
                        } else {
                            RH = this.boY.RH();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.boW.aD((int) (this.boW.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            RH = this.boY.RH();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bol;
                    options.inBitmap = RH.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.boU.decodeRegion(s, options);
                    decodeRegion.prepareToDraw();
                    RH.setBitmap(decodeRegion);
                    RH.q(this.row, this.column, this.bol);
                    this.boW.put(RH.RC(), RH);
                    if (this.boZ != null) {
                        this.boZ.Lh();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bol = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.boY = bVar;
            this.boU = bitmapRegionDecoder;
            this.boW = aVar;
            this.bpa = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.boZ = aVar;
        }

        private boolean h(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
