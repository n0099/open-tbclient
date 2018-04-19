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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aGS;
    private final com.baidu.tbadk.widget.largeImage.a.b aSP;
    private final BitmapRegionDecoder aTk;
    private final List<BdAsyncTask> aTl = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0106a, com.baidu.tbadk.widget.largeImage.a.a> aTm;

    public void Jo() {
        for (BdAsyncTask bdAsyncTask : this.aTl) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.aTl.clear();
    }

    public void onDestory() {
        Jo();
        if (this.aTm != null) {
            this.aTm.ac(0);
            this.aTm.clear();
            this.aTm = null;
        }
        this.aGS = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.aSP = bVar;
        this.aTk = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Fa().eV((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.aTm = new com.baidu.adp.lib.e.a<a.C0106a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0106a c0106a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0106a c0106a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.aGS != null && aVar != null) {
                    aVar.IM();
                    c.this.aGS.m(aVar);
                }
            }
        };
        this.aGS = com.baidu.tbadk.imageManager.c.Fa().eT(this.aSP.getBlockSize());
        this.aGS.af(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.aSP, this.aTk, Jp());
        aVar.execute(new Object[0]);
        this.aTl.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0106a, com.baidu.tbadk.widget.largeImage.a.a> Jp() {
        return this.aTm;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> Jq() {
        return this.aGS;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int aSC;
        private BitmapRegionDecoder aTk;
        private com.baidu.adp.lib.e.a<a.C0106a, com.baidu.tbadk.widget.largeImage.a.a> aTm;
        private com.baidu.tbadk.widget.largeImage.a.b aTo;
        private com.baidu.tbadk.widget.largeImage.logic.a aTp;
        private c aTq;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a IU;
            if (this.aTm != null && this.aTo.p(this.row, this.column, this.aSC)) {
                Rect q = this.aTo.q(this.row, this.column, this.aSC);
                this.aTo.f(q);
                if (!g(q)) {
                    try {
                        IU = this.aTq.Jq().fn();
                        if (IU != null) {
                            if (!IU.e(q)) {
                                System.currentTimeMillis();
                                IU.IM();
                            }
                        } else {
                            IU = this.aTo.IU();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.aTm.ac((int) (this.aTm.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            IU = this.aTo.IU();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.aSC;
                    options.inBitmap = IU.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.aTk.decodeRegion(q, options);
                    decodeRegion.prepareToDraw();
                    IU.setBitmap(decodeRegion);
                    IU.o(this.row, this.column, this.aSC);
                    this.aTm.put(IU.IP(), IU);
                    if (this.aTp != null) {
                        this.aTp.Cv();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aSC = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0106a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.aTo = bVar;
            this.aTk = bitmapRegionDecoder;
            this.aTm = aVar;
            this.aTq = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.aTp = aVar;
        }

        private boolean g(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
