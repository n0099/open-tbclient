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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eEa;
    private com.baidu.adp.lib.d.a<a.C0518a, com.baidu.tbadk.widget.largeImage.a.a> eQH;
    private final com.baidu.tbadk.widget.largeImage.a.b eQz;
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
        if (this.eQH != null) {
            this.eQH.setMaxSize(0);
            this.eQH.clear();
            this.eQH = null;
        }
        this.eEa = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.eQz = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bkk().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.eQH = new com.baidu.adp.lib.d.a<a.C0518a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0518a c0518a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0518a c0518a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.eEa != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.eEa.returnObject(aVar);
                }
            }
        };
        this.eEa = com.baidu.tbadk.imageManager.c.bkk().oe(this.eQz.getBlockSize());
        this.eEa.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.eQz, this.mDecoder, bol());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0518a, com.baidu.tbadk.widget.largeImage.a.a> bol() {
        return this.eQH;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bom() {
        return this.eEa;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0518a, com.baidu.tbadk.widget.largeImage.a.a> eQH;
        private com.baidu.tbadk.widget.largeImage.a.b eQJ;
        private com.baidu.tbadk.widget.largeImage.logic.a eQK;
        private c eQL;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a boi;
            if (this.eQH != null && this.eQJ.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.eQJ.getRect(this.row, this.column, this.sampleScale);
                this.eQJ.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        boi = this.eQL.bom().borrowObject();
                        if (boi != null) {
                            if (!boi.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                boi.clearBitmap();
                            }
                        } else {
                            boi = this.eQJ.boi();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.eQH.setMaxSize((int) (this.eQH.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            boi = this.eQJ.boi();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = boi.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        boi.setBitmap(decodeRegion);
                        boi.setPosition(this.row, this.column, this.sampleScale);
                        this.eQH.put(boi.boh(), boi);
                        if (this.eQK != null) {
                            this.eQK.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0518a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.eQJ = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.eQH = aVar;
            this.eQL = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.eQK = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
