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
    private final com.baidu.tbadk.widget.largeImage.a.b cIL;
    private final BitmapRegionDecoder cJh;
    private final List<BdAsyncTask> cJi = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0263a, com.baidu.tbadk.widget.largeImage.a.a> cJj;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cwg;

    public void ayn() {
        for (BdAsyncTask bdAsyncTask : this.cJi) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.cJi.clear();
    }

    public void onDestory() {
        ayn();
        if (this.cJj != null) {
            this.cJj.ae(0);
            this.cJj.clear();
            this.cJj = null;
        }
        this.cwg = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.cIL = bVar;
        this.cJh = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.aty().kE((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.cJj = new com.baidu.adp.lib.e.a<a.C0263a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0263a c0263a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0263a c0263a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.cwg != null && aVar != null) {
                    aVar.axM();
                    c.this.cwg.t(aVar);
                }
            }
        };
        this.cwg = com.baidu.tbadk.imageManager.c.aty().kC(this.cIL.qe());
        this.cwg.ah(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.cIL, this.cJh, ayo());
        aVar.execute(new Object[0]);
        this.cJi.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0263a, com.baidu.tbadk.widget.largeImage.a.a> ayo() {
        return this.cJj;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> ayp() {
        return this.cwg;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int KX;
        private int cIy;
        private BitmapRegionDecoder cJh;
        private com.baidu.adp.lib.e.a<a.C0263a, com.baidu.tbadk.widget.largeImage.a.a> cJj;
        private com.baidu.tbadk.widget.largeImage.a.b cJl;
        private com.baidu.tbadk.widget.largeImage.logic.a cJm;
        private c cJn;
        private int cuU;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a axU;
            if (this.cJj != null && this.cJl.v(this.cuU, this.KX, this.cIy)) {
                Rect w = this.cJl.w(this.cuU, this.KX, this.cIy);
                this.cJl.h(w);
                if (!i(w)) {
                    try {
                        axU = this.cJn.ayp().iD();
                        if (axU != null) {
                            if (!axU.g(w)) {
                                System.currentTimeMillis();
                                axU.axM();
                            }
                        } else {
                            axU = this.cJl.axU();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.cJj.ae((int) (this.cJj.hs() * 0.8d));
                        System.gc();
                        try {
                            axU = this.cJl.axU();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.cIy;
                    options.inBitmap = axU.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.cJh.decodeRegion(w, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        axU.setBitmap(decodeRegion);
                        axU.u(this.cuU, this.KX, this.cIy);
                        this.cJj.put(axU.axP(), axU);
                        if (this.cJm != null) {
                            this.cJm.aqO();
                        }
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.cuU = i;
            this.KX = i2;
            this.cIy = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0263a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.cJl = bVar;
            this.cJh = bitmapRegionDecoder;
            this.cJj = aVar;
            this.cJn = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.cJm = aVar;
        }

        private boolean i(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
