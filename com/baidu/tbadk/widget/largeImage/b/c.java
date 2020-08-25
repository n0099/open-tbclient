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
/* loaded from: classes2.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eOB;
    private final com.baidu.tbadk.widget.largeImage.a.b fbf;
    private com.baidu.adp.lib.d.a<a.C0564a, com.baidu.tbadk.widget.largeImage.a.a> fbn;
    private final BitmapRegionDecoder mDecoder;
    private final List<BdAsyncTask> taskList = new LinkedList();

    public void clearAllTask() {
        for (BdAsyncTask bdAsyncTask : this.taskList) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.taskList.clear();
    }

    public void onDestory() {
        clearAllTask();
        if (this.fbn != null) {
            this.fbn.setMaxSize(0);
            this.fbn.clear();
            this.fbn = null;
        }
        this.eOB = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.fbf = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bsW().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.fbn = new com.baidu.adp.lib.d.a<a.C0564a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0564a c0564a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0564a c0564a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.eOB != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.eOB.returnObject(aVar);
                }
            }
        };
        this.eOB = com.baidu.tbadk.imageManager.c.bsW().qp(this.fbf.getBlockSize());
        this.eOB.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.fbf, this.mDecoder, bwY());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0564a, com.baidu.tbadk.widget.largeImage.a.a> bwY() {
        return this.fbn;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bwZ() {
        return this.eOB;
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0564a, com.baidu.tbadk.widget.largeImage.a.a> fbn;
        private com.baidu.tbadk.widget.largeImage.a.b fbp;
        private com.baidu.tbadk.widget.largeImage.logic.a fbq;
        private c fbr;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bwV;
            if (this.fbn != null && this.fbp.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.fbp.getRect(this.row, this.column, this.sampleScale);
                this.fbp.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bwV = this.fbr.bwZ().borrowObject();
                        if (bwV != null) {
                            if (!bwV.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bwV.clearBitmap();
                            }
                        } else {
                            bwV = this.fbp.bwV();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.fbn.setMaxSize((int) (this.fbn.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bwV = this.fbp.bwV();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bwV.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bwV.setBitmap(decodeRegion);
                        bwV.setPosition(this.row, this.column, this.sampleScale);
                        this.fbn.put(bwV.bwU(), bwV);
                        if (this.fbq != null) {
                            this.fbq.onLoadFinished();
                        }
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.sampleScale = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0564a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.fbp = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.fbn = aVar;
            this.fbr = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.fbq = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
