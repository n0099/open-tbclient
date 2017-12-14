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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aGg;
    private final com.baidu.tbadk.widget.a.a.b aRX;
    private final BitmapRegionDecoder aSr;
    private final List<BdAsyncTask> aSs = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0080a, com.baidu.tbadk.widget.a.a.a> aSt;

    public void IT() {
        for (BdAsyncTask bdAsyncTask : this.aSs) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.aSs.clear();
    }

    public void onDestory() {
        IT();
        if (this.aSt != null) {
            this.aSt.ai(0);
            this.aSt.clear();
            this.aSt = null;
        }
        this.aGg = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.aRX = bVar;
        this.aSr = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.EA().fe((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.aSt = new com.baidu.adp.lib.e.a<a.C0080a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0080a c0080a, com.baidu.tbadk.widget.a.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0080a c0080a, com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.a aVar2) {
                if (z && c.this.aGg != null && aVar != null) {
                    aVar.Iq();
                    c.this.aGg.m(aVar);
                }
            }
        };
        this.aGg = com.baidu.tbadk.imageManager.c.EA().fc(this.aRX.getBlockSize());
        this.aGg.al(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.aRX, this.aSr, IU());
        aVar.execute(new Object[0]);
        this.aSs.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0080a, com.baidu.tbadk.widget.a.a.a> IU() {
        return this.aSt;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> IV() {
        return this.aGg;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int aRK;
        private BitmapRegionDecoder aSr;
        private com.baidu.adp.lib.e.a<a.C0080a, com.baidu.tbadk.widget.a.a.a> aSt;
        private com.baidu.tbadk.widget.a.a.b aSv;
        private com.baidu.tbadk.widget.a.b.a aSw;
        private c aSx;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a Iy;
            if (this.aSt != null && this.aSv.q(this.row, this.column, this.aRK)) {
                Rect r = this.aSv.r(this.row, this.column, this.aRK);
                this.aSv.e(r);
                if (!f(r)) {
                    try {
                        Iy = this.aSx.IV().fH();
                        if (Iy != null) {
                            if (!Iy.d(r)) {
                                System.currentTimeMillis();
                                Iy.Iq();
                            }
                        } else {
                            Iy = this.aSv.Iy();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.aSt.ai((int) (this.aSt.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            Iy = this.aSv.Iy();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.aRK;
                    options.inBitmap = Iy.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.aSr.decodeRegion(r, options);
                    decodeRegion.prepareToDraw();
                    Iy.setBitmap(decodeRegion);
                    Iy.p(this.row, this.column, this.aRK);
                    this.aSt.put(Iy.It(), Iy);
                    if (this.aSw != null) {
                        this.aSw.BP();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aRK = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0080a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.aSv = bVar;
            this.aSr = bitmapRegionDecoder;
            this.aSt = aVar;
            this.aSx = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.aSw = aVar;
        }

        private boolean f(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
