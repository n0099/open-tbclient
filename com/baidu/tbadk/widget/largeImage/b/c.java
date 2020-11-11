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
    private final com.baidu.tbadk.widget.largeImage.a.b fEE;
    private com.baidu.adp.lib.d.a<a.C0603a, com.baidu.tbadk.widget.largeImage.a.a> fEM;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> frW;
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
        if (this.fEM != null) {
            this.fEM.setMaxSize(0);
            this.fEM.clear();
            this.fEM = null;
        }
        this.frW = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.fEE = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bBd().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.fEM = new com.baidu.adp.lib.d.a<a.C0603a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0603a c0603a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0603a c0603a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.frW != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.frW.returnObject(aVar);
                }
            }
        };
        this.frW = com.baidu.tbadk.imageManager.c.bBd().rz(this.fEE.getBlockSize());
        this.frW.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.fEE, this.mDecoder, bFk());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0603a, com.baidu.tbadk.widget.largeImage.a.a> bFk() {
        return this.fEM;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bFl() {
        return this.frW;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0603a, com.baidu.tbadk.widget.largeImage.a.a> fEM;
        private com.baidu.tbadk.widget.largeImage.a.b fEO;
        private com.baidu.tbadk.widget.largeImage.logic.a fEP;
        private c fEQ;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bFh;
            if (this.fEM != null && this.fEO.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.fEO.getRect(this.row, this.column, this.sampleScale);
                this.fEO.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bFh = this.fEQ.bFl().borrowObject();
                        if (bFh != null) {
                            if (!bFh.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bFh.clearBitmap();
                            }
                        } else {
                            bFh = this.fEO.bFh();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.fEM.setMaxSize((int) (this.fEM.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bFh = this.fEO.bFh();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bFh.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bFh.setBitmap(decodeRegion);
                        bFh.setPosition(this.row, this.column, this.sampleScale);
                        this.fEM.put(bFh.bFg(), bFh);
                        if (this.fEP != null) {
                            this.fEP.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0603a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.fEO = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.fEM = aVar;
            this.fEQ = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.fEP = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
