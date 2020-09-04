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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eOF;
    private final com.baidu.tbadk.widget.largeImage.a.b fbj;
    private com.baidu.adp.lib.d.a<a.C0564a, com.baidu.tbadk.widget.largeImage.a.a> fbr;
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
        if (this.fbr != null) {
            this.fbr.setMaxSize(0);
            this.fbr.clear();
            this.fbr = null;
        }
        this.eOF = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.fbj = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bsX().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.fbr = new com.baidu.adp.lib.d.a<a.C0564a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
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
                if (z && c.this.eOF != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.eOF.returnObject(aVar);
                }
            }
        };
        this.eOF = com.baidu.tbadk.imageManager.c.bsX().qp(this.fbj.getBlockSize());
        this.eOF.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.fbj, this.mDecoder, bwZ());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0564a, com.baidu.tbadk.widget.largeImage.a.a> bwZ() {
        return this.fbr;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bxa() {
        return this.eOF;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0564a, com.baidu.tbadk.widget.largeImage.a.a> fbr;
        private com.baidu.tbadk.widget.largeImage.a.b fbt;
        private com.baidu.tbadk.widget.largeImage.logic.a fbu;
        private c fbv;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bwW;
            if (this.fbr != null && this.fbt.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.fbt.getRect(this.row, this.column, this.sampleScale);
                this.fbt.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bwW = this.fbv.bxa().borrowObject();
                        if (bwW != null) {
                            if (!bwW.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bwW.clearBitmap();
                            }
                        } else {
                            bwW = this.fbt.bwW();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.fbr.setMaxSize((int) (this.fbr.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bwW = this.fbt.bwW();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bwW.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bwW.setBitmap(decodeRegion);
                        bwW.setPosition(this.row, this.column, this.sampleScale);
                        this.fbr.put(bwW.bwV(), bwW);
                        if (this.fbu != null) {
                            this.fbu.onLoadFinished();
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
            this.fbt = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.fbr = aVar;
            this.fbv = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.fbu = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
