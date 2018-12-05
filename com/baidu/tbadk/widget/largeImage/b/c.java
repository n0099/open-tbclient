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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> bcm;
    private final com.baidu.tbadk.widget.largeImage.a.b bnH;
    private final BitmapRegionDecoder bod;
    private final List<BdAsyncTask> boe = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> bof;

    public void RD() {
        for (BdAsyncTask bdAsyncTask : this.boe) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.boe.clear();
    }

    public void onDestory() {
        RD();
        if (this.bof != null) {
            this.bof.aD(0);
            this.bof.clear();
            this.bof = null;
        }
        this.bcm = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bnH = bVar;
        this.bod = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Nu().fY((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.bof = new com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0178a c0178a, com.baidu.tbadk.widget.largeImage.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0178a c0178a, com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.a aVar2) {
                if (z && c.this.bcm != null && aVar != null) {
                    aVar.Rb();
                    c.this.bcm.t(aVar);
                }
            }
        };
        this.bcm = com.baidu.tbadk.imageManager.c.Nu().fW(this.bnH.getBlockSize());
        this.bcm.aG(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bnH, this.bod, RE());
        aVar.execute(new Object[0]);
        this.boe.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> RE() {
        return this.bof;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> RF() {
        return this.bcm;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int bnu;
        private BitmapRegionDecoder bod;
        private com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> bof;
        private com.baidu.tbadk.widget.largeImage.a.b boh;
        private com.baidu.tbadk.widget.largeImage.logic.a boi;
        private c boj;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a Rj;
            if (this.bof != null && this.boh.r(this.row, this.column, this.bnu)) {
                Rect s = this.boh.s(this.row, this.column, this.bnu);
                this.boh.g(s);
                if (!h(s)) {
                    try {
                        Rj = this.boj.RF().jy();
                        if (Rj != null) {
                            if (!Rj.f(s)) {
                                System.currentTimeMillis();
                                Rj.Rb();
                            }
                        } else {
                            Rj = this.boh.Rj();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.bof.aD((int) (this.bof.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            Rj = this.boh.Rj();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bnu;
                    options.inBitmap = Rj.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bod.decodeRegion(s, options);
                    decodeRegion.prepareToDraw();
                    Rj.setBitmap(decodeRegion);
                    Rj.q(this.row, this.column, this.bnu);
                    this.bof.put(Rj.Re(), Rj);
                    if (this.boi != null) {
                        this.boi.KR();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bnu = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.boh = bVar;
            this.bod = bitmapRegionDecoder;
            this.bof = aVar;
            this.boj = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.boi = aVar;
        }

        private boolean h(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
