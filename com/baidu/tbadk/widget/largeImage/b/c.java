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
    private final com.baidu.tbadk.widget.largeImage.a.b eAj;
    private com.baidu.adp.lib.d.a<a.C0498a, com.baidu.tbadk.widget.largeImage.a.a> eAr;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eoT;
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
        if (this.eAr != null) {
            this.eAr.setMaxSize(0);
            this.eAr.clear();
            this.eAr = null;
        }
        this.eoT = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.eAj = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bet().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.eAr = new com.baidu.adp.lib.d.a<a.C0498a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0498a c0498a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0498a c0498a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.eoT != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.eoT.returnObject(aVar);
                }
            }
        };
        this.eoT = com.baidu.tbadk.imageManager.c.bet().nq(this.eAj.getBlockSize());
        this.eoT.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.eAj, this.mDecoder, bhT());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0498a, com.baidu.tbadk.widget.largeImage.a.a> bhT() {
        return this.eAr;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bhU() {
        return this.eoT;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0498a, com.baidu.tbadk.widget.largeImage.a.a> eAr;
        private com.baidu.tbadk.widget.largeImage.a.b eAt;
        private com.baidu.tbadk.widget.largeImage.logic.a eAu;
        private c eAv;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bhQ;
            if (this.eAr != null && this.eAt.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.eAt.getRect(this.row, this.column, this.sampleScale);
                this.eAt.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bhQ = this.eAv.bhU().borrowObject();
                        if (bhQ != null) {
                            if (!bhQ.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bhQ.clearBitmap();
                            }
                        } else {
                            bhQ = this.eAt.bhQ();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.eAr.setMaxSize((int) (this.eAr.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bhQ = this.eAt.bhQ();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bhQ.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bhQ.setBitmap(decodeRegion);
                        bhQ.setPosition(this.row, this.column, this.sampleScale);
                        this.eAr.put(bhQ.bhP(), bhQ);
                        if (this.eAu != null) {
                            this.eAu.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0498a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.eAt = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.eAr = aVar;
            this.eAv = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.eAu = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
