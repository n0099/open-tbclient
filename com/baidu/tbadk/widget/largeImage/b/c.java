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
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fdE;
    private final com.baidu.tbadk.widget.largeImage.a.b fqp;
    private com.baidu.adp.lib.d.a<a.C0577a, com.baidu.tbadk.widget.largeImage.a.a> fqx;
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
        if (this.fqx != null) {
            this.fqx.setMaxSize(0);
            this.fqx.clear();
            this.fqx = null;
        }
        this.fdE = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.fqp = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.bwL().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.fqx = new com.baidu.adp.lib.d.a<a.C0577a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0577a c0577a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0577a c0577a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.fdE != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.fdE.returnObject(aVar);
                }
            }
        };
        this.fdE = com.baidu.tbadk.imageManager.c.bwL().re(this.fqp.getBlockSize());
        this.fdE.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.fqp, this.mDecoder, bAS());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0577a, com.baidu.tbadk.widget.largeImage.a.a> bAS() {
        return this.fqx;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> bAT() {
        return this.fdE;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.tbadk.widget.largeImage.logic.a fqA;
        private c fqB;
        private com.baidu.adp.lib.d.a<a.C0577a, com.baidu.tbadk.widget.largeImage.a.a> fqx;
        private com.baidu.tbadk.widget.largeImage.a.b fqz;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a bAP;
            if (this.fqx != null && this.fqz.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.fqz.getRect(this.row, this.column, this.sampleScale);
                this.fqz.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        bAP = this.fqB.bAT().borrowObject();
                        if (bAP != null) {
                            if (!bAP.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                bAP.clearBitmap();
                            }
                        } else {
                            bAP = this.fqz.bAP();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.fqx.setMaxSize((int) (this.fqx.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            bAP = this.fqz.bAP();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = bAP.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        bAP.setBitmap(decodeRegion);
                        bAP.setPosition(this.row, this.column, this.sampleScale);
                        this.fqx.put(bAP.bAO(), bAP);
                        if (this.fqA != null) {
                            this.fqA.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0577a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.fqz = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.fqx = aVar;
            this.fqB = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.fqA = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
