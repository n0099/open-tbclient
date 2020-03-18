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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> dAT;
    private final com.baidu.tbadk.widget.largeImage.a.b dLI;
    private com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> dLQ;
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
        if (this.dLQ != null) {
            this.dLQ.setMaxSize(0);
            this.dLQ.clear();
            this.dLQ = null;
        }
        this.dAT = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.dLI = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.aPV().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.dLQ = new com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
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
                if (z && c.this.dAT != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.dAT.returnObject(aVar);
                }
            }
        };
        this.dAT = com.baidu.tbadk.imageManager.c.aPV().mD(this.dLI.getBlockSize());
        this.dAT.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.dLI, this.mDecoder, aTA());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> aTA() {
        return this.dLQ;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> aTB() {
        return this.dAT;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> dLQ;
        private com.baidu.tbadk.widget.largeImage.a.b dLS;
        private com.baidu.tbadk.widget.largeImage.logic.a dLT;
        private c dLU;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a aTx;
            if (this.dLQ != null && this.dLS.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.dLS.getRect(this.row, this.column, this.sampleScale);
                this.dLS.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        aTx = this.dLU.aTB().borrowObject();
                        if (aTx != null) {
                            if (!aTx.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                aTx.clearBitmap();
                            }
                        } else {
                            aTx = this.dLS.aTx();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.dLQ.setMaxSize((int) (this.dLQ.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            aTx = this.dLS.aTx();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = aTx.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        aTx.setBitmap(decodeRegion);
                        aTx.setPosition(this.row, this.column, this.sampleScale);
                        this.dLQ.put(aTx.aTw(), aTx);
                        if (this.dLT != null) {
                            this.dLT.onLoadFinished();
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
            this.dLS = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.dLQ = aVar;
            this.dLU = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.dLT = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
