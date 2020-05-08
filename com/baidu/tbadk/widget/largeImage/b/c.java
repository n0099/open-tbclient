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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eaH;
    private final com.baidu.tbadk.widget.largeImage.a.b elE;
    private com.baidu.adp.lib.d.a<a.C0451a, com.baidu.tbadk.widget.largeImage.a.a> elM;
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
        if (this.elM != null) {
            this.elM.setMaxSize(0);
            this.elM.clear();
            this.elM = null;
        }
        this.eaH = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.elE = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.aYk().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.elM = new com.baidu.adp.lib.d.a<a.C0451a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0451a c0451a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0451a c0451a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.eaH != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.eaH.returnObject(aVar);
                }
            }
        };
        this.eaH = com.baidu.tbadk.imageManager.c.aYk().mO(this.elE.getBlockSize());
        this.eaH.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.elE, this.mDecoder, bbI());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0451a, com.baidu.tbadk.widget.largeImage.a.a> bbI() {
        return this.elM;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bbJ() {
        return this.eaH;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0451a, com.baidu.tbadk.widget.largeImage.a.a> elM;
        private com.baidu.tbadk.widget.largeImage.a.b elO;
        private com.baidu.tbadk.widget.largeImage.logic.a elP;
        private c elQ;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bbF;
            if (this.elM != null && this.elO.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.elO.getRect(this.row, this.column, this.sampleScale);
                this.elO.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bbF = this.elQ.bbJ().borrowObject();
                        if (bbF != null) {
                            if (!bbF.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bbF.clearBitmap();
                            }
                        } else {
                            bbF = this.elO.bbF();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.elM.setMaxSize((int) (this.elM.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bbF = this.elO.bbF();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bbF.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bbF.setBitmap(decodeRegion);
                        bbF.setPosition(this.row, this.column, this.sampleScale);
                        this.elM.put(bbF.bbE(), bbF);
                        if (this.elP != null) {
                            this.elP.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0451a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.elO = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.elM = aVar;
            this.elQ = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.elP = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
