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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aYO;
    private final BitmapRegionDecoder bkF;
    private final List<BdAsyncTask> bkG = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0168a, com.baidu.tbadk.widget.largeImage.a.a> bkH;
    private final com.baidu.tbadk.widget.largeImage.a.b bkj;

    public void Qx() {
        for (BdAsyncTask bdAsyncTask : this.bkG) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.bkG.clear();
    }

    public void onDestory() {
        Qx();
        if (this.bkH != null) {
            this.bkH.aD(0);
            this.bkH.clear();
            this.bkH = null;
        }
        this.aYO = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bkj = bVar;
        this.bkF = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Mq().fK((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bkH = new com.baidu.adp.lib.e.a<a.C0168a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0168a c0168a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0168a c0168a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.aYO != null && aVar != null) {
                    aVar.PV();
                    c.this.aYO.t(aVar);
                }
            }
        };
        this.aYO = com.baidu.tbadk.imageManager.c.Mq().fI(this.bkj.getBlockSize());
        this.aYO.aG(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bkj, this.bkF, Qy());
        aVar.execute(new Object[0]);
        this.bkG.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0168a, com.baidu.tbadk.widget.largeImage.a.a> Qy() {
        return this.bkH;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> Qz() {
        return this.aYO;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int bjW;
        private BitmapRegionDecoder bkF;
        private com.baidu.adp.lib.e.a<a.C0168a, com.baidu.tbadk.widget.largeImage.a.a> bkH;
        private com.baidu.tbadk.widget.largeImage.a.b bkJ;
        private com.baidu.tbadk.widget.largeImage.logic.a bkK;
        private c bkL;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a Qd;
            if (this.bkH != null && this.bkJ.r(this.row, this.column, this.bjW)) {
                Rect s = this.bkJ.s(this.row, this.column, this.bjW);
                this.bkJ.g(s);
                if (!h(s)) {
                    try {
                        Qd = this.bkL.Qz().jy();
                        if (Qd != null) {
                            if (!Qd.f(s)) {
                                System.currentTimeMillis();
                                Qd.PV();
                            }
                        } else {
                            Qd = this.bkJ.Qd();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bkH.aD((int) (this.bkH.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            Qd = this.bkJ.Qd();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bjW;
                    options.inBitmap = Qd.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bkF.decodeRegion(s, options);
                    decodeRegion.prepareToDraw();
                    Qd.setBitmap(decodeRegion);
                    Qd.q(this.row, this.column, this.bjW);
                    this.bkH.put(Qd.PY(), Qd);
                    if (this.bkK != null) {
                        this.bkK.JN();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bjW = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0168a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.bkJ = bVar;
            this.bkF = bitmapRegionDecoder;
            this.bkH = aVar;
            this.bkL = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.bkK = aVar;
        }

        private boolean h(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
