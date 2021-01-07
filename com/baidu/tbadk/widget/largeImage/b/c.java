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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fIx;
    private com.baidu.adp.lib.d.a<a.C0606a, com.baidu.tbadk.widget.largeImage.a.a> fVG;
    private final com.baidu.tbadk.widget.largeImage.a.b fVy;
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
        if (this.fVG != null) {
            this.fVG.setMaxSize(0);
            this.fVG.clear();
            this.fVG = null;
        }
        this.fIx = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.fVy = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bGq().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.fVG = new com.baidu.adp.lib.d.a<a.C0606a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0606a c0606a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0606a c0606a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.fIx != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.fIx.returnObject(aVar);
                }
            }
        };
        this.fIx = com.baidu.tbadk.imageManager.c.bGq().sK(this.fVy.getBlockSize());
        this.fIx.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.fVy, this.mDecoder, bKz());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0606a, com.baidu.tbadk.widget.largeImage.a.a> bKz() {
        return this.fVG;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bKA() {
        return this.fIx;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0606a, com.baidu.tbadk.widget.largeImage.a.a> fVG;
        private com.baidu.tbadk.widget.largeImage.a.b fVI;
        private com.baidu.tbadk.widget.largeImage.logic.a fVJ;
        private c fVK;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bKw;
            if (this.fVG != null && this.fVI.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.fVI.getRect(this.row, this.column, this.sampleScale);
                this.fVI.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bKw = this.fVK.bKA().borrowObject();
                        if (bKw != null) {
                            if (!bKw.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bKw.clearBitmap();
                            }
                        } else {
                            bKw = this.fVI.bKw();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.fVG.setMaxSize((int) (this.fVG.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bKw = this.fVI.bKw();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bKw.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bKw.setBitmap(decodeRegion);
                        bKw.setPosition(this.row, this.column, this.sampleScale);
                        this.fVG.put(bKw.bKv(), bKw);
                        if (this.fVJ != null) {
                            this.fVJ.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0606a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.fVI = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.fVG = aVar;
            this.fVK = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.fVJ = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
