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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cJm;
    private final com.baidu.tbadk.widget.largeImage.a.b cTr;
    private com.baidu.adp.lib.e.a<a.C0304a, com.baidu.tbadk.widget.largeImage.a.a> cTz;
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
        if (this.cTz != null) {
            this.cTz.setMaxSize(0);
            this.cTz.clear();
            this.cTz = null;
        }
        this.cJm = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.cTr = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.avu().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.cTz = new com.baidu.adp.lib.e.a<a.C0304a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
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
                if (z && c.this.cJm != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.cJm.returnObject(aVar);
                }
            }
        };
        this.cJm = com.baidu.tbadk.imageManager.c.avu().jX(this.cTr.getBlockSize());
        this.cJm.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.cTr, this.mDecoder, ayM());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0304a, com.baidu.tbadk.widget.largeImage.a.a> ayM() {
        return this.cTz;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> ayN() {
        return this.cJm;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private com.baidu.tbadk.widget.largeImage.a.b cTB;
        private com.baidu.tbadk.widget.largeImage.logic.a cTC;
        private c cTD;
        private com.baidu.adp.lib.e.a<a.C0304a, com.baidu.tbadk.widget.largeImage.a.a> cTz;
        private int column;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a ayJ;
            if (this.cTz != null && this.cTB.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.cTB.getRect(this.row, this.column, this.sampleScale);
                this.cTB.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        ayJ = this.cTD.ayN().borrowObject();
                        if (ayJ != null) {
                            if (!ayJ.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                ayJ.clearBitmap();
                            }
                        } else {
                            ayJ = this.cTB.ayJ();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.cTz.setMaxSize((int) (this.cTz.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            ayJ = this.cTB.ayJ();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = ayJ.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        ayJ.setBitmap(decodeRegion);
                        ayJ.setPosition(this.row, this.column, this.sampleScale);
                        this.cTz.put(ayJ.ayI(), ayJ);
                        if (this.cTC != null) {
                            this.cTC.onLoadFinished();
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
            this.cTB = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.cTz = aVar;
            this.cTD = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.cTC = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
