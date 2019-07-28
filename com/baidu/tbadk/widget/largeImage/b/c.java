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
    private final com.baidu.tbadk.widget.largeImage.a.b cIE;
    private final BitmapRegionDecoder cJa;
    private final List<BdAsyncTask> cJb = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0263a, com.baidu.tbadk.widget.largeImage.a.a> cJc;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cvZ;

    public void ayl() {
        for (BdAsyncTask bdAsyncTask : this.cJb) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.cJb.clear();
    }

    public void onDestory() {
        ayl();
        if (this.cJc != null) {
            this.cJc.ae(0);
            this.cJc.clear();
            this.cJc = null;
        }
        this.cvZ = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.cIE = bVar;
        this.cJa = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.atw().kD((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.cJc = new com.baidu.adp.lib.e.a<a.C0263a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
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
                if (z && c.this.cvZ != null && aVar != null) {
                    aVar.axK();
                    c.this.cvZ.t(aVar);
                }
            }
        };
        this.cvZ = com.baidu.tbadk.imageManager.c.atw().kB(this.cIE.qe());
        this.cvZ.ah(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.cIE, this.cJa, aym());
        aVar.execute(new Object[0]);
        this.cJb.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0263a, com.baidu.tbadk.widget.largeImage.a.a> aym() {
        return this.cJc;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> ayn() {
        return this.cvZ;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int KX;
        private int cIr;
        private BitmapRegionDecoder cJa;
        private com.baidu.adp.lib.e.a<a.C0263a, com.baidu.tbadk.widget.largeImage.a.a> cJc;
        private com.baidu.tbadk.widget.largeImage.a.b cJe;
        private com.baidu.tbadk.widget.largeImage.logic.a cJf;
        private c cJg;
        private int cuN;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a axS;
            if (this.cJc != null && this.cJe.v(this.cuN, this.KX, this.cIr)) {
                Rect w = this.cJe.w(this.cuN, this.KX, this.cIr);
                this.cJe.h(w);
                if (!i(w)) {
                    try {
                        axS = this.cJg.ayn().iD();
                        if (axS != null) {
                            if (!axS.g(w)) {
                                System.currentTimeMillis();
                                axS.axK();
                            }
                        } else {
                            axS = this.cJe.axS();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.cJc.ae((int) (this.cJc.hs() * 0.8d));
                        System.gc();
                        try {
                            axS = this.cJe.axS();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.cIr;
                    options.inBitmap = axS.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.cJa.decodeRegion(w, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        axS.setBitmap(decodeRegion);
                        axS.u(this.cuN, this.KX, this.cIr);
                        this.cJc.put(axS.axN(), axS);
                        if (this.cJf != null) {
                            this.cJf.aqM();
                        }
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.cuN = i;
            this.KX = i2;
            this.cIr = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0263a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.cJe = bVar;
            this.cJa = bitmapRegionDecoder;
            this.cJc = aVar;
            this.cJg = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.cJf = aVar;
        }

        private boolean i(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
