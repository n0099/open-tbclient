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
    private final com.baidu.tbadk.widget.largeImage.a.b fEh;
    private com.baidu.adp.lib.d.a<a.C0602a, com.baidu.tbadk.widget.largeImage.a.a> fEp;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> frd;
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
        if (this.fEp != null) {
            this.fEp.setMaxSize(0);
            this.fEp.clear();
            this.fEp = null;
        }
        this.frd = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.fEh = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bAt().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.fEp = new com.baidu.adp.lib.d.a<a.C0602a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0602a c0602a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0602a c0602a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.frd != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.frd.returnObject(aVar);
                }
            }
        };
        this.frd = com.baidu.tbadk.imageManager.c.bAt().rX(this.fEh.getBlockSize());
        this.frd.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.fEh, this.mDecoder, bED());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0602a, com.baidu.tbadk.widget.largeImage.a.a> bED() {
        return this.fEp;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bEE() {
        return this.frd;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0602a, com.baidu.tbadk.widget.largeImage.a.a> fEp;
        private com.baidu.tbadk.widget.largeImage.a.b fEr;
        private com.baidu.tbadk.widget.largeImage.logic.a fEs;
        private c fEt;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bEA;
            if (this.fEp != null && this.fEr.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.fEr.getRect(this.row, this.column, this.sampleScale);
                this.fEr.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bEA = this.fEt.bEE().borrowObject();
                        if (bEA != null) {
                            if (!bEA.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bEA.clearBitmap();
                            }
                        } else {
                            bEA = this.fEr.bEA();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.fEp.setMaxSize((int) (this.fEp.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bEA = this.fEr.bEA();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bEA.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bEA.setBitmap(decodeRegion);
                        bEA.setPosition(this.row, this.column, this.sampleScale);
                        this.fEp.put(bEA.bEz(), bEA);
                        if (this.fEs != null) {
                            this.fEs.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0602a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.fEr = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.fEp = aVar;
            this.fEt = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.fEs = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
