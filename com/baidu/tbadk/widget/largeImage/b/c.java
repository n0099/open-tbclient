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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aQm;
    private final com.baidu.tbadk.widget.largeImage.a.b bbO;
    private final BitmapRegionDecoder bck;
    private final List<BdAsyncTask> bcl = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0120a, com.baidu.tbadk.widget.largeImage.a.a> bcm;

    public void MW() {
        for (BdAsyncTask bdAsyncTask : this.bcl) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.bcl.clear();
    }

    public void onDestory() {
        MW();
        if (this.bcm != null) {
            this.bcm.ae(0);
            this.bcm.clear();
            this.bcm = null;
        }
        this.aQm = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bbO = bVar;
        this.bck = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.IQ().fc((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bcm = new com.baidu.adp.lib.e.a<a.C0120a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0120a c0120a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0120a c0120a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.aQm != null && aVar != null) {
                    aVar.Mu();
                    c.this.aQm.p(aVar);
                }
            }
        };
        this.aQm = com.baidu.tbadk.imageManager.c.IQ().fa(this.bbO.getBlockSize());
        this.aQm.ah(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bbO, this.bck, MX());
        aVar.execute(new Object[0]);
        this.bcl.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0120a, com.baidu.tbadk.widget.largeImage.a.a> MX() {
        return this.bcm;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> MY() {
        return this.aQm;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int bbB;
        private BitmapRegionDecoder bck;
        private com.baidu.adp.lib.e.a<a.C0120a, com.baidu.tbadk.widget.largeImage.a.a> bcm;
        private com.baidu.tbadk.widget.largeImage.a.b bco;
        private com.baidu.tbadk.widget.largeImage.logic.a bcp;
        private c bcq;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a MC;
            if (this.bcm != null && this.bco.p(this.row, this.column, this.bbB)) {
                Rect q = this.bco.q(this.row, this.column, this.bbB);
                this.bco.g(q);
                if (!h(q)) {
                    try {
                        MC = this.bcq.MY().m9if();
                        if (MC != null) {
                            if (!MC.f(q)) {
                                System.currentTimeMillis();
                                MC.Mu();
                            }
                        } else {
                            MC = this.bco.MC();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bcm.ae((int) (this.bcm.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            MC = this.bco.MC();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bbB;
                    options.inBitmap = MC.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bck.decodeRegion(q, options);
                    decodeRegion.prepareToDraw();
                    MC.setBitmap(decodeRegion);
                    MC.o(this.row, this.column, this.bbB);
                    this.bcm.put(MC.Mx(), MC);
                    if (this.bcp != null) {
                        this.bcp.Gk();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bbB = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0120a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.bco = bVar;
            this.bck = bitmapRegionDecoder;
            this.bcm = aVar;
            this.bcq = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.bcp = aVar;
        }

        private boolean h(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
