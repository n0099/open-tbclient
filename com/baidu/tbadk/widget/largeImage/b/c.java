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
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> bcp;
    private final com.baidu.tbadk.widget.largeImage.a.b bnK;
    private final BitmapRegionDecoder bog;
    private final List<BdAsyncTask> boh = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> boi;

    public void RF() {
        for (BdAsyncTask bdAsyncTask : this.boh) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.boh.clear();
    }

    public void onDestory() {
        RF();
        if (this.boi != null) {
            this.boi.aD(0);
            this.boi.clear();
            this.boi = null;
        }
        this.bcp = null;
    }

    public c(com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.bnK = bVar;
        this.bog = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Nv().fZ((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.boi = new com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.largeImage.b.c.1
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
                if (z && c.this.bcp != null && aVar != null) {
                    aVar.Rd();
                    c.this.bcp.t(aVar);
                }
            }
        };
        this.bcp = com.baidu.tbadk.imageManager.c.Nv().fX(this.bnK.getBlockSize());
        this.bcp.aG(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.bnK, this.bog, RG());
        aVar.execute(new Object[0]);
        this.boh.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> RG() {
        return this.boi;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> RH() {
        return this.bcp;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int bnx;
        private BitmapRegionDecoder bog;
        private com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> boi;
        private com.baidu.tbadk.widget.largeImage.a.b bok;
        private com.baidu.tbadk.widget.largeImage.logic.a bol;
        private c bom;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.largeImage.a.a Rl;
            if (this.boi != null && this.bok.r(this.row, this.column, this.bnx)) {
                Rect s = this.bok.s(this.row, this.column, this.bnx);
                this.bok.g(s);
                if (!h(s)) {
                    try {
                        Rl = this.bom.RH().jy();
                        if (Rl != null) {
                            if (!Rl.f(s)) {
                                System.currentTimeMillis();
                                Rl.Rd();
                            }
                        } else {
                            Rl = this.bok.Rl();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.boi.aD((int) (this.boi.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            Rl = this.bok.Rl();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.bnx;
                    options.inBitmap = Rl.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.bog.decodeRegion(s, options);
                    decodeRegion.prepareToDraw();
                    Rl.setBitmap(decodeRegion);
                    Rl.q(this.row, this.column, this.bnx);
                    this.boi.put(Rl.Rg(), Rl);
                    if (this.bol != null) {
                        this.bol.KS();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bnx = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.largeImage.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0178a, com.baidu.tbadk.widget.largeImage.a.a> aVar) {
            this.bok = bVar;
            this.bog = bitmapRegionDecoder;
            this.boi = aVar;
            this.bom = cVar;
        }

        public void b(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
            this.bol = aVar;
        }

        private boolean h(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
