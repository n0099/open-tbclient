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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aPq;
    private final com.baidu.tbadk.widget.largeImage.a.b baL;
    private final BitmapRegionDecoder bbg;
    private final List<BdAsyncTask> bbh = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0122a, com.baidu.tbadk.widget.largeImage.a.a> bbi;

    public void MI() {
        for (BdAsyncTask bdAsyncTask : this.bbh) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.bbh.clear();
    }

    public void onDestory() {
        MI();
        if (this.bbi != null) {
            this.bbi.ad(0);
            this.bbi.clear();
            this.bbi = null;
        }
        this.aPq = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.baL = bVar;
        this.bbg = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.ID().fa((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bbi = new com.baidu.adp.lib.e.a<a.C0122a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0122a c0122a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0122a c0122a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.aPq != null && aVar != null) {
                    aVar.Mg();
                    c.this.aPq.p(aVar);
                }
            }
        };
        this.aPq = com.baidu.tbadk.imageManager.c.ID().eY(this.baL.getBlockSize());
        this.aPq.ag(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.baL, this.bbg, MJ());
        aVar.execute(new Object[0]);
        this.bbh.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0122a, com.baidu.tbadk.widget.largeImage.a.a> MJ() {
        return this.bbi;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> MK() {
        return this.aPq;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int bay;
        private BitmapRegionDecoder bbg;
        private com.baidu.adp.lib.e.a<a.C0122a, com.baidu.tbadk.widget.largeImage.a.a> bbi;
        private com.baidu.tbadk.widget.largeImage.a.b bbk;
        private com.baidu.tbadk.widget.largeImage.logic.a bbl;
        private c bbm;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a Mo;
            if (this.bbi != null && this.bbk.p(this.row, this.column, this.bay)) {
                Rect q = this.bbk.q(this.row, this.column, this.bay);
                this.bbk.f(q);
                if (!g(q)) {
                    try {
                        Mo = this.bbm.MK().ie();
                        if (Mo != null) {
                            if (!Mo.e(q)) {
                                System.currentTimeMillis();
                                Mo.Mg();
                            }
                        } else {
                            Mo = this.bbk.Mo();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bbi.ad((int) (this.bbi.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            Mo = this.bbk.Mo();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bay;
                    options.inBitmap = Mo.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bbg.decodeRegion(q, options);
                    decodeRegion.prepareToDraw();
                    Mo.setBitmap(decodeRegion);
                    Mo.o(this.row, this.column, this.bay);
                    this.bbi.put(Mo.Mj(), Mo);
                    if (this.bbl != null) {
                        this.bbl.FW();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bay = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0122a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.bbk = bVar;
            this.bbg = bitmapRegionDecoder;
            this.bbi = aVar;
            this.bbm = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.bbl = aVar;
        }

        private boolean g(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
