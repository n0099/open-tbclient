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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fHB;
    private final com.baidu.tbadk.widget.largeImage.a.b fUE;
    private com.baidu.adp.lib.d.a<a.C0592a, com.baidu.tbadk.widget.largeImage.a.a> fUM;
    private final ThreadPoolExecutor fUN;
    private BdAsyncTask<Void, Void, Void> fUO;
    private final BitmapRegionDecoder mDecoder;

    public void lG(boolean z) {
        this.fUN.purge();
        if (z && this.fUO == null) {
            this.fUO = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void[] voidArr) throws IOException {
                    try {
                        c.this.fUN.shutdownNow();
                        c.this.fUN.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
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
            this.fUO.execute(new Void[0]);
        }
    }

    public void onDestory() {
        lG(true);
        if (this.fUM != null) {
            this.fUM.setMaxSize(0);
            this.fUM.clear();
            this.fUM = null;
        }
        this.fHB = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.fUE = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bCS().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.fUN = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new RejectedExecutionHandler() { // from class: com.baidu.tbadk.widget.largeImage.b.c.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        });
        this.fUM = new com.baidu.adp.lib.d.a<a.C0592a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0592a c0592a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0592a c0592a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.fHB != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.fHB.returnObject(aVar);
                }
            }
        };
        this.fHB = com.baidu.tbadk.imageManager.c.bCS().rk(this.fUE.getBlockSize());
        this.fHB.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null || this.fUO != null) {
            return;
        }
        aVar.a(this, this.fUE, this.mDecoder, bHf());
        this.fUN.submit(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0592a, com.baidu.tbadk.widget.largeImage.a.a> bHf() {
        return this.fUM;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bHg() {
        return this.fHB;
    }

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0592a, com.baidu.tbadk.widget.largeImage.a.a> fUM;
        private com.baidu.tbadk.widget.largeImage.a.b fUQ;
        private com.baidu.tbadk.widget.largeImage.logic.a fUR;
        private c fUS;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.tbadk.widget.largeImage.a.a bHc;
            if (this.fUM != null && this.fUQ.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.fUQ.getRect(this.row, this.column, this.sampleScale);
                this.fUQ.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bHc = this.fUS.bHg().borrowObject();
                        if (bHc != null) {
                            if (!bHc.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bHc.clearBitmap();
                            }
                        } else {
                            bHc = this.fUQ.bHc();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.fUM.setMaxSize((int) (this.fUM.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bHc = this.fUQ.bHc();
                        } catch (Throwable th2) {
                            return;
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bHc.getBitmap();
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
                    bHc.setBitmap(decodeRegion);
                    bHc.setPosition(this.row, this.column, this.sampleScale);
                    this.fUM.put(bHc.bHb(), bHc);
                    if (this.fUR != null) {
                        this.fUR.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0592a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.fUQ = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.fUM = aVar;
            this.fUS = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.fUR = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
