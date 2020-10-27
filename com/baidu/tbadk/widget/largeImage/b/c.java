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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fmc;
    private final com.baidu.tbadk.widget.largeImage.a.b fyO;
    private com.baidu.adp.lib.d.a<a.C0591a, com.baidu.tbadk.widget.largeImage.a.a> fyW;
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
        if (this.fyW != null) {
            this.fyW.setMaxSize(0);
            this.fyW.clear();
            this.fyW = null;
        }
        this.fmc = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.fyO = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.byE().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.fyW = new com.baidu.adp.lib.d.a<a.C0591a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0591a c0591a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0591a c0591a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.fmc != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.fmc.returnObject(aVar);
                }
            }
        };
        this.fmc = com.baidu.tbadk.imageManager.c.byE().rp(this.fyO.getBlockSize());
        this.fmc.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.fyO, this.mDecoder, bCL());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0591a, com.baidu.tbadk.widget.largeImage.a.a> bCL() {
        return this.fyW;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bCM() {
        return this.fmc;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0591a, com.baidu.tbadk.widget.largeImage.a.a> fyW;
        private com.baidu.tbadk.widget.largeImage.a.b fyY;
        private com.baidu.tbadk.widget.largeImage.logic.a fyZ;
        private c fza;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bCI;
            if (this.fyW != null && this.fyY.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.fyY.getRect(this.row, this.column, this.sampleScale);
                this.fyY.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bCI = this.fza.bCM().borrowObject();
                        if (bCI != null) {
                            if (!bCI.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bCI.clearBitmap();
                            }
                        } else {
                            bCI = this.fyY.bCI();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.fyW.setMaxSize((int) (this.fyW.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bCI = this.fyY.bCI();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bCI.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bCI.setBitmap(decodeRegion);
                        bCI.setPosition(this.row, this.column, this.sampleScale);
                        this.fyW.put(bCI.bCH(), bCI);
                        if (this.fyZ != null) {
                            this.fyZ.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0591a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.fyY = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.fyW = aVar;
            this.fza = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.fyZ = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
