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
    private final com.baidu.tbadk.widget.largeImage.a.b dGQ;
    private com.baidu.adp.lib.d.a<a.C0385a, com.baidu.tbadk.widget.largeImage.a.a> dGY;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> dwe;
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
        if (this.dGY != null) {
            this.dGY.setMaxSize(0);
            this.dGY.clear();
            this.dGY = null;
        }
        this.dwe = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.dGQ = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.aMZ().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.dGY = new com.baidu.adp.lib.d.a<a.C0385a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0385a c0385a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0385a c0385a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.dwe != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.dwe.returnObject(aVar);
                }
            }
        };
        this.dwe = com.baidu.tbadk.imageManager.c.aMZ().mj(this.dGQ.getBlockSize());
        this.dwe.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.dGQ, this.mDecoder, aQJ());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0385a, com.baidu.tbadk.widget.largeImage.a.a> aQJ() {
        return this.dGY;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> aQK() {
        return this.dwe;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0385a, com.baidu.tbadk.widget.largeImage.a.a> dGY;
        private com.baidu.tbadk.widget.largeImage.a.b dHa;
        private com.baidu.tbadk.widget.largeImage.logic.a dHb;
        private c dHc;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a aQG;
            if (this.dGY != null && this.dHa.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.dHa.getRect(this.row, this.column, this.sampleScale);
                this.dHa.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        aQG = this.dHc.aQK().borrowObject();
                        if (aQG != null) {
                            if (!aQG.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                aQG.clearBitmap();
                            }
                        } else {
                            aQG = this.dHa.aQG();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.dGY.setMaxSize((int) (this.dGY.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            aQG = this.dHa.aQG();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = aQG.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        aQG.setBitmap(decodeRegion);
                        aQG.setPosition(this.row, this.column, this.sampleScale);
                        this.dGY.put(aQG.aQF(), aQG);
                        if (this.dHb != null) {
                            this.dHb.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0385a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.dHa = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.dGY = aVar;
            this.dHc = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.dHb = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
