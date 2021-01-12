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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fDQ;
    private final com.baidu.tbadk.widget.largeImage.a.b fQR;
    private com.baidu.adp.lib.d.a<a.C0589a, com.baidu.tbadk.widget.largeImage.a.a> fQZ;
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
        if (this.fQZ != null) {
            this.fQZ.setMaxSize(0);
            this.fQZ.clear();
            this.fQZ = null;
        }
        this.fDQ = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.fQR = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bCx().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.fQZ = new com.baidu.adp.lib.d.a<a.C0589a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0589a c0589a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0589a c0589a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.fDQ != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.fDQ.returnObject(aVar);
                }
            }
        };
        this.fDQ = com.baidu.tbadk.imageManager.c.bCx().re(this.fQR.getBlockSize());
        this.fDQ.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.fQR, this.mDecoder, bGH());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0589a, com.baidu.tbadk.widget.largeImage.a.a> bGH() {
        return this.fQZ;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bGI() {
        return this.fDQ;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0589a, com.baidu.tbadk.widget.largeImage.a.a> fQZ;
        private com.baidu.tbadk.widget.largeImage.a.b fRb;
        private com.baidu.tbadk.widget.largeImage.logic.a fRc;
        private c fRd;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bGE;
            if (this.fQZ != null && this.fRb.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.fRb.getRect(this.row, this.column, this.sampleScale);
                this.fRb.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bGE = this.fRd.bGI().borrowObject();
                        if (bGE != null) {
                            if (!bGE.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bGE.clearBitmap();
                            }
                        } else {
                            bGE = this.fRb.bGE();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.fQZ.setMaxSize((int) (this.fQZ.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bGE = this.fRb.bGE();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bGE.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bGE.setBitmap(decodeRegion);
                        bGE.setPosition(this.row, this.column, this.sampleScale);
                        this.fQZ.put(bGE.bGD(), bGE);
                        if (this.fRc != null) {
                            this.fRc.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0589a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.fRb = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.fQZ = aVar;
            this.fRd = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.fRc = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
