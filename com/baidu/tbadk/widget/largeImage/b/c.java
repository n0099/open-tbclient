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
    private final com.baidu.tbadk.widget.largeImage.a.b bbG;
    private final BitmapRegionDecoder bcb;
    private final List<BdAsyncTask> bcc = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0123a, com.baidu.tbadk.widget.largeImage.a.a> bcd;

    public void Na() {
        for (BdAsyncTask bdAsyncTask : this.bcc) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.bcc.clear();
    }

    public void onDestory() {
        Na();
        if (this.bcd != null) {
            this.bcd.ad(0);
            this.bcd.clear();
            this.bcd = null;
        }
        this.aQm = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bbG = bVar;
        this.bcb = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.IV().fb((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bcd = new com.baidu.adp.lib.e.a<a.C0123a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0123a c0123a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0123a c0123a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.aQm != null && aVar != null) {
                    aVar.My();
                    c.this.aQm.p(aVar);
                }
            }
        };
        this.aQm = com.baidu.tbadk.imageManager.c.IV().eZ(this.bbG.getBlockSize());
        this.aQm.ag(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bbG, this.bcb, Nb());
        aVar.execute(new Object[0]);
        this.bcc.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0123a, com.baidu.tbadk.widget.largeImage.a.a> Nb() {
        return this.bcd;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> Nc() {
        return this.aQm;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int bbt;
        private BitmapRegionDecoder bcb;
        private com.baidu.adp.lib.e.a<a.C0123a, com.baidu.tbadk.widget.largeImage.a.a> bcd;
        private com.baidu.tbadk.widget.largeImage.a.b bcf;
        private com.baidu.tbadk.widget.largeImage.logic.a bcg;
        private c bch;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a MG;
            if (this.bcd != null && this.bcf.p(this.row, this.column, this.bbt)) {
                Rect q = this.bcf.q(this.row, this.column, this.bbt);
                this.bcf.f(q);
                if (!g(q)) {
                    try {
                        MG = this.bch.Nc().ie();
                        if (MG != null) {
                            if (!MG.e(q)) {
                                System.currentTimeMillis();
                                MG.My();
                            }
                        } else {
                            MG = this.bcf.MG();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bcd.ad((int) (this.bcd.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            MG = this.bcf.MG();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bbt;
                    options.inBitmap = MG.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bcb.decodeRegion(q, options);
                    decodeRegion.prepareToDraw();
                    MG.setBitmap(decodeRegion);
                    MG.o(this.row, this.column, this.bbt);
                    this.bcd.put(MG.MB(), MG);
                    if (this.bcg != null) {
                        this.bcg.Go();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bbt = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0123a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.bcf = bVar;
            this.bcb = bitmapRegionDecoder;
            this.bcd = aVar;
            this.bch = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.bcg = aVar;
        }

        private boolean g(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
