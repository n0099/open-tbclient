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
    private final com.baidu.tbadk.widget.largeImage.a.b eKd;
    private com.baidu.adp.lib.d.a<a.C0506a, com.baidu.tbadk.widget.largeImage.a.a> eKl;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> exI;
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
        if (this.eKl != null) {
            this.eKl.setMaxSize(0);
            this.eKl.clear();
            this.eKl = null;
        }
        this.exI = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.eKd = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bgz().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.eKl = new com.baidu.adp.lib.d.a<a.C0506a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0506a c0506a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0506a c0506a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.exI != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.exI.returnObject(aVar);
                }
            }
        };
        this.exI = com.baidu.tbadk.imageManager.c.bgz().nM(this.eKd.getBlockSize());
        this.exI.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.eKd, this.mDecoder, bkr());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0506a, com.baidu.tbadk.widget.largeImage.a.a> bkr() {
        return this.eKl;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bks() {
        return this.exI;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0506a, com.baidu.tbadk.widget.largeImage.a.a> eKl;
        private com.baidu.tbadk.widget.largeImage.a.b eKn;
        private com.baidu.tbadk.widget.largeImage.logic.a eKo;
        private c eKp;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bko;
            if (this.eKl != null && this.eKn.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.eKn.getRect(this.row, this.column, this.sampleScale);
                this.eKn.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bko = this.eKp.bks().borrowObject();
                        if (bko != null) {
                            if (!bko.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bko.clearBitmap();
                            }
                        } else {
                            bko = this.eKn.bko();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.eKl.setMaxSize((int) (this.eKl.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bko = this.eKn.bko();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bko.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bko.setBitmap(decodeRegion);
                        bko.setPosition(this.row, this.column, this.sampleScale);
                        this.eKl.put(bko.bkn(), bko);
                        if (this.eKo != null) {
                            this.eKo.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0506a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.eKn = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.eKl = aVar;
            this.eKp = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.eKo = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
