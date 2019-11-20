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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cIv;
    private final com.baidu.tbadk.widget.largeImage.a.b cSA;
    private com.baidu.adp.lib.e.a<a.C0304a, com.baidu.tbadk.widget.largeImage.a.a> cSI;
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
        if (this.cSI != null) {
            this.cSI.setMaxSize(0);
            this.cSI.clear();
            this.cSI = null;
        }
        this.cIv = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.cSA = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.avs().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.cSI = new com.baidu.adp.lib.e.a<a.C0304a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0304a c0304a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0304a c0304a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.cIv != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.cIv.returnObject(aVar);
                }
            }
        };
        this.cIv = com.baidu.tbadk.imageManager.c.avs().jW(this.cSA.getBlockSize());
        this.cIv.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.cSA, this.mDecoder, ayK());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0304a, com.baidu.tbadk.widget.largeImage.a.a> ayK() {
        return this.cSI;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> ayL() {
        return this.cIv;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private com.baidu.adp.lib.e.a<a.C0304a, com.baidu.tbadk.widget.largeImage.a.a> cSI;
        private com.baidu.tbadk.widget.largeImage.a.b cSK;
        private com.baidu.tbadk.widget.largeImage.logic.a cSL;
        private c cSM;
        private int column;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a ayH;
            if (this.cSI != null && this.cSK.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.cSK.getRect(this.row, this.column, this.sampleScale);
                this.cSK.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        ayH = this.cSM.ayL().borrowObject();
                        if (ayH != null) {
                            if (!ayH.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                ayH.clearBitmap();
                            }
                        } else {
                            ayH = this.cSK.ayH();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.cSI.setMaxSize((int) (this.cSI.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            ayH = this.cSK.ayH();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = ayH.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        ayH.setBitmap(decodeRegion);
                        ayH.setPosition(this.row, this.column, this.sampleScale);
                        this.cSI.put(ayH.ayG(), ayH);
                        if (this.cSL != null) {
                            this.cSL.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0304a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.cSK = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.cSI = aVar;
            this.cSM = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.cSL = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
