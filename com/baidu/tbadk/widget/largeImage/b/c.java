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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eaC;
    private com.baidu.adp.lib.d.a<a.C0430a, com.baidu.tbadk.widget.largeImage.a.a> elH;
    private final com.baidu.tbadk.widget.largeImage.a.b elz;
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
        if (this.elH != null) {
            this.elH.setMaxSize(0);
            this.elH.clear();
            this.elH = null;
        }
        this.eaC = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.elz = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.aYm().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.elH = new com.baidu.adp.lib.d.a<a.C0430a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0430a c0430a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0430a c0430a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.eaC != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.eaC.returnObject(aVar);
                }
            }
        };
        this.eaC = com.baidu.tbadk.imageManager.c.aYm().mO(this.elz.getBlockSize());
        this.eaC.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.elz, this.mDecoder, bbK());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0430a, com.baidu.tbadk.widget.largeImage.a.a> bbK() {
        return this.elH;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bbL() {
        return this.eaC;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0430a, com.baidu.tbadk.widget.largeImage.a.a> elH;
        private com.baidu.tbadk.widget.largeImage.a.b elJ;
        private com.baidu.tbadk.widget.largeImage.logic.a elK;
        private c elL;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bbH;
            if (this.elH != null && this.elJ.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.elJ.getRect(this.row, this.column, this.sampleScale);
                this.elJ.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bbH = this.elL.bbL().borrowObject();
                        if (bbH != null) {
                            if (!bbH.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bbH.clearBitmap();
                            }
                        } else {
                            bbH = this.elJ.bbH();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.elH.setMaxSize((int) (this.elH.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bbH = this.elJ.bbH();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bbH.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bbH.setBitmap(decodeRegion);
                        bbH.setPosition(this.row, this.column, this.sampleScale);
                        this.elH.put(bbH.bbG(), bbH);
                        if (this.elK != null) {
                            this.elK.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0430a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.elJ = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.elH = aVar;
            this.elL = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.elK = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
