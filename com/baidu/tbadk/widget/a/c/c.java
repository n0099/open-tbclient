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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aGj;
    private final com.baidu.tbadk.widget.a.a.b aSa;
    private final BitmapRegionDecoder aSu;
    private final List<BdAsyncTask> aSv = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0079a, com.baidu.tbadk.widget.a.a.a> aSw;

    public void IT() {
        for (BdAsyncTask bdAsyncTask : this.aSv) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.aSv.clear();
    }

    public void onDestory() {
        IT();
        if (this.aSw != null) {
            this.aSw.ai(0);
            this.aSw.clear();
            this.aSw = null;
        }
        this.aGj = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.aSa = bVar;
        this.aSu = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.EA().fe((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.aSw = new com.baidu.adp.lib.e.a<a.C0079a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0079a c0079a, com.baidu.tbadk.widget.a.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0079a c0079a, com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.a aVar2) {
                if (z && c.this.aGj != null && aVar != null) {
                    aVar.Iq();
                    c.this.aGj.m(aVar);
                }
            }
        };
        this.aGj = com.baidu.tbadk.imageManager.c.EA().fc(this.aSa.getBlockSize());
        this.aGj.al(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.aSa, this.aSu, IU());
        aVar.execute(new Object[0]);
        this.aSv.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0079a, com.baidu.tbadk.widget.a.a.a> IU() {
        return this.aSw;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> IV() {
        return this.aGj;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int aRN;
        private c aSA;
        private BitmapRegionDecoder aSu;
        private com.baidu.adp.lib.e.a<a.C0079a, com.baidu.tbadk.widget.a.a.a> aSw;
        private com.baidu.tbadk.widget.a.a.b aSy;
        private com.baidu.tbadk.widget.a.b.a aSz;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a Iy;
            if (this.aSw != null && this.aSy.q(this.row, this.column, this.aRN)) {
                Rect r = this.aSy.r(this.row, this.column, this.aRN);
                this.aSy.e(r);
                if (!f(r)) {
                    try {
                        Iy = this.aSA.IV().fH();
                        if (Iy != null) {
                            if (!Iy.d(r)) {
                                System.currentTimeMillis();
                                Iy.Iq();
                            }
                        } else {
                            Iy = this.aSy.Iy();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.aSw.ai((int) (this.aSw.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            Iy = this.aSy.Iy();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.aRN;
                    options.inBitmap = Iy.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.aSu.decodeRegion(r, options);
                    decodeRegion.prepareToDraw();
                    Iy.setBitmap(decodeRegion);
                    Iy.p(this.row, this.column, this.aRN);
                    this.aSw.put(Iy.It(), Iy);
                    if (this.aSz != null) {
                        this.aSz.BP();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aRN = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0079a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.aSy = bVar;
            this.aSu = bitmapRegionDecoder;
            this.aSw = aVar;
            this.aSA = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.aSz = aVar;
        }

        private boolean f(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
