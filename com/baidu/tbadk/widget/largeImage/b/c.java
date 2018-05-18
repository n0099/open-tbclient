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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aGT;
    private final com.baidu.tbadk.widget.largeImage.a.b aSQ;
    private final BitmapRegionDecoder aTl;
    private final List<BdAsyncTask> aTm = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0106a, com.baidu.tbadk.widget.largeImage.a.a> aTn;

    public void Jm() {
        for (BdAsyncTask bdAsyncTask : this.aTm) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.aTm.clear();
    }

    public void onDestory() {
        Jm();
        if (this.aTn != null) {
            this.aTn.ac(0);
            this.aTn.clear();
            this.aTn = null;
        }
        this.aGT = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.aSQ = bVar;
        this.aTl = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.EY().eW((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.aTn = new com.baidu.adp.lib.e.a<a.C0106a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
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
                if (z && c.this.aGT != null && aVar != null) {
                    aVar.IK();
                    c.this.aGT.m(aVar);
                }
            }
        };
        this.aGT = com.baidu.tbadk.imageManager.c.EY().eU(this.aSQ.getBlockSize());
        this.aGT.af(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.aSQ, this.aTl, Jn());
        aVar.execute(new Object[0]);
        this.aTm.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0106a, com.baidu.tbadk.widget.largeImage.a.a> Jn() {
        return this.aTn;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> Jo() {
        return this.aGT;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int aSD;
        private BitmapRegionDecoder aTl;
        private com.baidu.adp.lib.e.a<a.C0106a, com.baidu.tbadk.widget.largeImage.a.a> aTn;
        private com.baidu.tbadk.widget.largeImage.a.b aTp;
        private com.baidu.tbadk.widget.largeImage.logic.a aTq;
        private c aTr;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a IS;
            if (this.aTn != null && this.aTp.p(this.row, this.column, this.aSD)) {
                Rect q = this.aTp.q(this.row, this.column, this.aSD);
                this.aTp.f(q);
                if (!g(q)) {
                    try {
                        IS = this.aTr.Jo().fn();
                        if (IS != null) {
                            if (!IS.e(q)) {
                                System.currentTimeMillis();
                                IS.IK();
                            }
                        } else {
                            IS = this.aTp.IS();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.aTn.ac((int) (this.aTn.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            IS = this.aTp.IS();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.aSD;
                    options.inBitmap = IS.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.aTl.decodeRegion(q, options);
                    decodeRegion.prepareToDraw();
                    IS.setBitmap(decodeRegion);
                    IS.o(this.row, this.column, this.aSD);
                    this.aTn.put(IS.IN(), IS);
                    if (this.aTq != null) {
                        this.aTq.Ct();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aSD = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0106a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.aTp = bVar;
            this.aTl = bitmapRegionDecoder;
            this.aTn = aVar;
            this.aTr = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.aTq = aVar;
        }

        private boolean g(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
