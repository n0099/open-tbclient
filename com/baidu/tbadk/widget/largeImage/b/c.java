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
    private final com.baidu.tbadk.widget.largeImage.a.b fLT;
    private com.baidu.adp.lib.d.a<a.C0615a, com.baidu.tbadk.widget.largeImage.a.a> fMb;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fyS;
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
        if (this.fMb != null) {
            this.fMb.setMaxSize(0);
            this.fMb.clear();
            this.fMb = null;
        }
        this.fyS = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.fLT = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bDV().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.fMb = new com.baidu.adp.lib.d.a<a.C0615a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0615a c0615a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0615a c0615a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.fyS != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.fyS.returnObject(aVar);
                }
            }
        };
        this.fyS = com.baidu.tbadk.imageManager.c.bDV().sy(this.fLT.getBlockSize());
        this.fyS.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.fLT, this.mDecoder, bIe());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0615a, com.baidu.tbadk.widget.largeImage.a.a> bIe() {
        return this.fMb;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bIf() {
        return this.fyS;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0615a, com.baidu.tbadk.widget.largeImage.a.a> fMb;
        private com.baidu.tbadk.widget.largeImage.a.b fMd;
        private com.baidu.tbadk.widget.largeImage.logic.a fMe;
        private c fMf;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bIb;
            if (this.fMb != null && this.fMd.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.fMd.getRect(this.row, this.column, this.sampleScale);
                this.fMd.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bIb = this.fMf.bIf().borrowObject();
                        if (bIb != null) {
                            if (!bIb.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bIb.clearBitmap();
                            }
                        } else {
                            bIb = this.fMd.bIb();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.fMb.setMaxSize((int) (this.fMb.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bIb = this.fMd.bIb();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bIb.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bIb.setBitmap(decodeRegion);
                        bIb.setPosition(this.row, this.column, this.sampleScale);
                        this.fMb.put(bIb.bIa(), bIb);
                        if (this.fMe != null) {
                            this.fMe.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0615a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.fMd = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.fMb = aVar;
            this.fMf = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.fMe = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
