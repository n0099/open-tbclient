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
    private final com.baidu.tbadk.widget.largeImage.a.b cJB;
    private final BitmapRegionDecoder cJX;
    private final List<BdAsyncTask> cJY = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0272a, com.baidu.tbadk.widget.largeImage.a.a> cJZ;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cxc;

    public void ayz() {
        for (BdAsyncTask bdAsyncTask : this.cJY) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.cJY.clear();
    }

    public void onDestory() {
        ayz();
        if (this.cJZ != null) {
            this.cJZ.ae(0);
            this.cJZ.clear();
            this.cJZ = null;
        }
        this.cxc = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.cJB = bVar;
        this.cJX = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.atK().kH((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.cJZ = new com.baidu.adp.lib.e.a<a.C0272a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0272a c0272a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0272a c0272a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.cxc != null && aVar != null) {
                    aVar.axY();
                    c.this.cxc.t(aVar);
                }
            }
        };
        this.cxc = com.baidu.tbadk.imageManager.c.atK().kF(this.cJB.qf());
        this.cxc.ah(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.cJB, this.cJX, ayA());
        aVar.execute(new Object[0]);
        this.cJY.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0272a, com.baidu.tbadk.widget.largeImage.a.a> ayA() {
        return this.cJZ;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> ayB() {
        return this.cxc;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int KX;
        private BitmapRegionDecoder cJX;
        private com.baidu.adp.lib.e.a<a.C0272a, com.baidu.tbadk.widget.largeImage.a.a> cJZ;
        private int cJp;
        private com.baidu.tbadk.widget.largeImage.a.b cKb;
        private com.baidu.tbadk.widget.largeImage.logic.a cKc;
        private c cKd;
        private int cvQ;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a ayg;
            if (this.cJZ != null && this.cKb.w(this.cvQ, this.KX, this.cJp)) {
                Rect x = this.cKb.x(this.cvQ, this.KX, this.cJp);
                this.cKb.h(x);
                if (!i(x)) {
                    try {
                        ayg = this.cKd.ayB().iD();
                        if (ayg != null) {
                            if (!ayg.g(x)) {
                                System.currentTimeMillis();
                                ayg.axY();
                            }
                        } else {
                            ayg = this.cKb.ayg();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.cJZ.ae((int) (this.cJZ.hs() * 0.8d));
                        System.gc();
                        try {
                            ayg = this.cKb.ayg();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.cJp;
                    options.inBitmap = ayg.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.cJX.decodeRegion(x, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        ayg.setBitmap(decodeRegion);
                        ayg.v(this.cvQ, this.KX, this.cJp);
                        this.cJZ.put(ayg.ayb(), ayg);
                        if (this.cKc != null) {
                            this.cKc.ara();
                        }
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.cvQ = i;
            this.KX = i2;
            this.cJp = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0272a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.cKb = bVar;
            this.cJX = bitmapRegionDecoder;
            this.cJZ = aVar;
            this.cKd = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.cKc = aVar;
        }

        private boolean i(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
