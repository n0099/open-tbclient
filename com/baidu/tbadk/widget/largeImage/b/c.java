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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> dAG;
    private com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> dLA;
    private final com.baidu.tbadk.widget.largeImage.a.b dLs;
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
        if (this.dLA != null) {
            this.dLA.setMaxSize(0);
            this.dLA.clear();
            this.dLA = null;
        }
        this.dAG = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.dLs = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.aPR().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.dLA = new com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
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
                if (z && c.this.dAG != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.dAG.returnObject(aVar);
                }
            }
        };
        this.dAG = com.baidu.tbadk.imageManager.c.aPR().mB(this.dLs.getBlockSize());
        this.dAG.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.dLs, this.mDecoder, aTw());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> aTw() {
        return this.dLA;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> aTx() {
        return this.dAG;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0398a, com.baidu.tbadk.widget.largeImage.a.a> dLA;
        private com.baidu.tbadk.widget.largeImage.a.b dLC;
        private com.baidu.tbadk.widget.largeImage.logic.a dLD;
        private c dLE;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a aTt;
            if (this.dLA != null && this.dLC.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.dLC.getRect(this.row, this.column, this.sampleScale);
                this.dLC.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        aTt = this.dLE.aTx().borrowObject();
                        if (aTt != null) {
                            if (!aTt.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                aTt.clearBitmap();
                            }
                        } else {
                            aTt = this.dLC.aTt();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.dLA.setMaxSize((int) (this.dLA.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            aTt = this.dLC.aTt();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = aTt.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        aTt.setBitmap(decodeRegion);
                        aTt.setPosition(this.row, this.column, this.sampleScale);
                        this.dLA.put(aTt.aTs(), aTt);
                        if (this.dLD != null) {
                            this.dLD.onLoadFinished();
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
            this.dLC = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.dLA = aVar;
            this.dLE = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.dLD = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
