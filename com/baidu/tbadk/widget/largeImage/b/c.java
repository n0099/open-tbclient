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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> dAt;
    private final com.baidu.tbadk.widget.largeImage.a.b dLf;
    private com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> dLn;
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
        if (this.dLn != null) {
            this.dLn.setMaxSize(0);
            this.dLn.clear();
            this.dLn = null;
        }
        this.dAt = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.dLf = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.aPQ().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.dLn = new com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
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
                if (z && c.this.dAt != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.dAt.returnObject(aVar);
                }
            }
        };
        this.dAt = com.baidu.tbadk.imageManager.c.aPQ().mB(this.dLf.getBlockSize());
        this.dAt.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.dLf, this.mDecoder, aTv());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> aTv() {
        return this.dLn;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> aTw() {
        return this.dAt;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> dLn;
        private com.baidu.tbadk.widget.largeImage.a.b dLp;
        private com.baidu.tbadk.widget.largeImage.logic.a dLq;
        private c dLr;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a aTs;
            if (this.dLn != null && this.dLp.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.dLp.getRect(this.row, this.column, this.sampleScale);
                this.dLp.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        aTs = this.dLr.aTw().borrowObject();
                        if (aTs != null) {
                            if (!aTs.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                aTs.clearBitmap();
                            }
                        } else {
                            aTs = this.dLp.aTs();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.dLn.setMaxSize((int) (this.dLn.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            aTs = this.dLp.aTs();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = aTs.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        aTs.setBitmap(decodeRegion);
                        aTs.setPosition(this.row, this.column, this.sampleScale);
                        this.dLn.put(aTs.aTr(), aTs);
                        if (this.dLq != null) {
                            this.dLq.onLoadFinished();
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
            this.dLp = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.dLn = aVar;
            this.dLr = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.dLq = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
