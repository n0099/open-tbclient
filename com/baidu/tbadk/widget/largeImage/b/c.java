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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cmB;
    private final com.baidu.tbadk.widget.largeImage.a.b cyZ;
    private final BitmapRegionDecoder czv;
    private final List<BdAsyncTask> czw = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a> czx;

    public void arT() {
        for (BdAsyncTask bdAsyncTask : this.czw) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.czw.clear();
    }

    public void onDestory() {
        arT();
        if (this.czx != null) {
            this.czx.al(0);
            this.czx.clear();
            this.czx = null;
        }
        this.cmB = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.cyZ = bVar;
        this.czv = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.anm().jJ((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.czx = new com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0246a c0246a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0246a c0246a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.cmB != null && aVar != null) {
                    aVar.arr();
                    c.this.cmB.t(aVar);
                }
            }
        };
        this.cmB = com.baidu.tbadk.imageManager.c.anm().jH(this.cyZ.getBlockSize());
        this.cmB.ao(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.cyZ, this.czv, arU());
        aVar.execute(new Object[0]);
        this.czw.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a> arU() {
        return this.czx;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> arV() {
        return this.cmB;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private int cyM;
        private com.baidu.tbadk.widget.largeImage.logic.a czA;
        private c czB;
        private BitmapRegionDecoder czv;
        private com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a> czx;
        private com.baidu.tbadk.widget.largeImage.a.b czz;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a arz;
            if (this.czx != null && this.czz.u(this.row, this.column, this.cyM)) {
                Rect v = this.czz.v(this.row, this.column, this.cyM);
                this.czz.h(v);
                if (!i(v)) {
                    try {
                        arz = this.czB.arV().jA();
                        if (arz != null) {
                            if (!arz.g(v)) {
                                System.currentTimeMillis();
                                arz.arr();
                            }
                        } else {
                            arz = this.czz.arz();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.czx.al((int) (this.czx.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            arz = this.czz.arz();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.cyM;
                    options.inBitmap = arz.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.czv.decodeRegion(v, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        arz.setBitmap(decodeRegion);
                        arz.t(this.row, this.column, this.cyM);
                        this.czx.put(arz.aru(), arz);
                        if (this.czA != null) {
                            this.czA.akE();
                        }
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.cyM = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0246a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.czz = bVar;
            this.czv = bitmapRegionDecoder;
            this.czx = aVar;
            this.czB = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.czA = aVar;
        }

        private boolean i(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
