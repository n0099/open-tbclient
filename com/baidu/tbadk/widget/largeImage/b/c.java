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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> dAs;
    private final com.baidu.tbadk.widget.largeImage.a.b dLe;
    private com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> dLm;
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
        if (this.dLm != null) {
            this.dLm.setMaxSize(0);
            this.dLm.clear();
            this.dLm = null;
        }
        this.dAs = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.dLe = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.aPO().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.dLm = new com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0398a c0398a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0398a c0398a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.dAs != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.dAs.returnObject(aVar);
                }
            }
        };
        this.dAs = com.baidu.tbadk.imageManager.c.aPO().mB(this.dLe.getBlockSize());
        this.dAs.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.dLe, this.mDecoder, aTt());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> aTt() {
        return this.dLm;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> aTu() {
        return this.dAs;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> dLm;
        private com.baidu.tbadk.widget.largeImage.a.b dLo;
        private com.baidu.tbadk.widget.largeImage.logic.a dLp;
        private c dLq;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a aTq;
            if (this.dLm != null && this.dLo.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.dLo.getRect(this.row, this.column, this.sampleScale);
                this.dLo.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        aTq = this.dLq.aTu().borrowObject();
                        if (aTq != null) {
                            if (!aTq.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                aTq.clearBitmap();
                            }
                        } else {
                            aTq = this.dLo.aTq();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.dLm.setMaxSize((int) (this.dLm.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            aTq = this.dLo.aTq();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = aTq.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        aTq.setBitmap(decodeRegion);
                        aTq.setPosition(this.row, this.column, this.sampleScale);
                        this.dLm.put(aTq.aTp(), aTq);
                        if (this.dLp != null) {
                            this.dLp.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.dLo = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.dLm = aVar;
            this.dLq = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.dLp = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
