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
import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fGc;
    private final com.baidu.tbadk.widget.largeImage.a.b fTe;
    private com.baidu.adp.lib.d.a<a.C0586a, com.baidu.tbadk.widget.largeImage.a.a> fTm;
    private final ThreadPoolExecutor fTn;
    private BdAsyncTask<Void, Void, Void> fTo;
    private final BitmapRegionDecoder mDecoder;

    public void lG(boolean z) {
        this.fTn.purge();
        if (z && this.fTo == null) {
            this.fTo = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void[] voidArr) throws IOException {
                    try {
                        c.this.fTn.shutdownNow();
                        c.this.fTn.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (c.this.mDecoder != null) {
                        c.this.mDecoder.recycle();
                        return null;
                    }
                    return null;
                }
            };
            this.fTo.execute(new Void[0]);
        }
    }

    public void onDestory() {
        lG(true);
        if (this.fTm != null) {
            this.fTm.setMaxSize(0);
            this.fTm.clear();
            this.fTm = null;
        }
        this.fGc = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.fTe = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bCP().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.fTn = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new RejectedExecutionHandler() { // from class: com.baidu.tbadk.widget.largeImage.b.c.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        });
        this.fTm = new com.baidu.adp.lib.d.a<a.C0586a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0586a c0586a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0586a c0586a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.fGc != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.fGc.returnObject(aVar);
                }
            }
        };
        this.fGc = com.baidu.tbadk.imageManager.c.bCP().rj(this.fTe.getBlockSize());
        this.fGc.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null || this.fTo != null) {
            return;
        }
        aVar.a(this, this.fTe, this.mDecoder, bHb());
        this.fTn.submit(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0586a, com.baidu.tbadk.widget.largeImage.a.a> bHb() {
        return this.fTm;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bHc() {
        return this.fGc;
    }

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0586a, com.baidu.tbadk.widget.largeImage.a.a> fTm;
        private com.baidu.tbadk.widget.largeImage.a.b fTq;
        private com.baidu.tbadk.widget.largeImage.logic.a fTr;
        private c fTs;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.tbadk.widget.largeImage.a.a bGY;
            if (this.fTm != null && this.fTq.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.fTq.getRect(this.row, this.column, this.sampleScale);
                this.fTq.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bGY = this.fTs.bHc().borrowObject();
                        if (bGY != null) {
                            if (!bGY.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bGY.clearBitmap();
                            }
                        } else {
                            bGY = this.fTq.bGY();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.fTm.setMaxSize((int) (this.fTm.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bGY = this.fTq.bGY();
                        } catch (Throwable th2) {
                            return;
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bGY.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion == null) {
                        options.inBitmap = null;
                        decodeRegion = this.mDecoder.decodeRegion(rect, options);
                        if (decodeRegion == null) {
                            return;
                        }
                    }
                    decodeRegion.prepareToDraw();
                    bGY.setBitmap(decodeRegion);
                    bGY.setPosition(this.row, this.column, this.sampleScale);
                    this.fTm.put(bGY.bGX(), bGY);
                    if (this.fTr != null) {
                        this.fTr.onLoadFinished();
                    }
                }
            }
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.sampleScale = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0586a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.fTq = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.fTm = aVar;
            this.fTs = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.fTr = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
