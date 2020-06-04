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
    private com.baidu.adp.lib.d.a<a.C0498a, com.baidu.tbadk.widget.largeImage.a.a> eAC;
    private final com.baidu.tbadk.widget.largeImage.a.b eAu;
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
        if (this.eAC != null) {
            this.eAC.setMaxSize(0);
            this.eAC.clear();
            this.eAC = null;
        }
        this.eoT = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.eAu = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.beu().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.eAC = new com.baidu.adp.lib.d.a<a.C0498a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
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
        this.eoT = com.baidu.tbadk.imageManager.c.beu().ns(this.eAu.getBlockSize());
        this.eoT.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.eAu, this.mDecoder, bhV());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0498a, com.baidu.tbadk.widget.largeImage.a.a> bhV() {
        return this.eAC;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bhW() {
        return this.eoT;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0498a, com.baidu.tbadk.widget.largeImage.a.a> eAC;
        private com.baidu.tbadk.widget.largeImage.a.b eAE;
        private com.baidu.tbadk.widget.largeImage.logic.a eAF;
        private c eAG;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bhS;
            if (this.eAC != null && this.eAE.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.eAE.getRect(this.row, this.column, this.sampleScale);
                this.eAE.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bhS = this.eAG.bhW().borrowObject();
                        if (bhS != null) {
                            if (!bhS.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bhS.clearBitmap();
                            }
                        } else {
                            bhS = this.eAE.bhS();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.eAC.setMaxSize((int) (this.eAC.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bhS = this.eAE.bhS();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bhS.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bhS.setBitmap(decodeRegion);
                        bhS.setPosition(this.row, this.column, this.sampleScale);
                        this.eAC.put(bhS.bhR(), bhS);
                        if (this.eAF != null) {
                            this.eAF.onLoadFinished();
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
            this.eAE = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.eAC = aVar;
            this.eAG = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.eAF = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
