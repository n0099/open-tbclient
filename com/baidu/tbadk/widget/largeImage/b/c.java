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
    private final com.baidu.tbadk.widget.largeImage.a.b dGZ;
    private com.baidu.adp.lib.d.a<a.C0387a, com.baidu.tbadk.widget.largeImage.a.a> dHh;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> dwm;
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
        if (this.dHh != null) {
            this.dHh.setMaxSize(0);
            this.dHh.clear();
            this.dHh = null;
        }
        this.dwm = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.dGZ = bVar;
        this.mDecoder = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.aNs().setPicMaxSize((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.dHh = new com.baidu.adp.lib.d.a<a.C0387a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public int sizeOf(a.C0387a c0387a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0387a c0387a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.dwm != null && aVar != null) {
                    aVar.clearBitmap();
                    c.this.dwm.returnObject(aVar);
                }
            }
        };
        this.dwm = com.baidu.tbadk.imageManager.c.aNs().mj(this.dGZ.getBlockSize());
        this.dwm.setMaxIdle(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.dGZ, this.mDecoder, aRc());
        aVar.execute(new Object[0]);
        this.taskList.add(aVar);
    }

    public com.baidu.adp.lib.d.a<a.C0387a, com.baidu.tbadk.widget.largeImage.a.a> aRc() {
        return this.dHh;
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> aRd() {
        return this.dwm;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int column;
        private com.baidu.adp.lib.d.a<a.C0387a, com.baidu.tbadk.widget.largeImage.a.a> dHh;
        private com.baidu.tbadk.widget.largeImage.a.b dHj;
        private com.baidu.tbadk.widget.largeImage.logic.a dHk;
        private c dHl;
        private BitmapRegionDecoder mDecoder;
        private int row;
        private int sampleScale;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a aQZ;
            if (this.dHh != null && this.dHj.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.dHj.getRect(this.row, this.column, this.sampleScale);
                this.dHj.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        aQZ = this.dHl.aRd().borrowObject();
                        if (aQZ != null) {
                            if (!aQZ.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                aQZ.clearBitmap();
                            }
                        } else {
                            aQZ = this.dHj.aQZ();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.dHh.setMaxSize((int) (this.dHh.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            aQZ = this.dHj.aQZ();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = aQZ.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        decodeRegion.prepareToDraw();
                        aQZ.setBitmap(decodeRegion);
                        aQZ.setPosition(this.row, this.column, this.sampleScale);
                        this.dHh.put(aQZ.aQY(), aQZ);
                        if (this.dHk != null) {
                            this.dHk.onLoadFinished();
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
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.d.a<a.C0387a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.dHj = bVar;
            this.mDecoder = bitmapRegionDecoder;
            this.dHh = aVar;
            this.dHl = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.dHk = aVar;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
