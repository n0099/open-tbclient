package com.baidu.tbadk.widget.a.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.widget.a.a.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aFt;
    private final com.baidu.tbadk.widget.a.a.b aOP;
    private final BitmapRegionDecoder aPj;
    private final List<BdAsyncTask> aPk = new LinkedList();
    private com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aPl;

    public void Ik() {
        for (BdAsyncTask bdAsyncTask : this.aPk) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.aPk.clear();
    }

    public void onDestory() {
        Ik();
        if (this.aPl != null) {
            this.aPl.aj(0);
            this.aPl.clear();
            this.aPl = null;
        }
        this.aFt = null;
    }

    public c(com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.aOP = bVar;
        this.aPj = bitmapRegionDecoder;
        com.baidu.tbadk.imageManager.c.Eg().fg((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.aPl = new com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a>((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.tbadk.widget.a.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public int sizeOf(a.C0066a c0066a, com.baidu.tbadk.widget.a.a.a aVar) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, a.C0066a c0066a, com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.a aVar2) {
                if (z && c.this.aFt != null && aVar != null) {
                    aVar.HH();
                    c.this.aFt.m(aVar);
                }
            }
        };
        this.aFt = com.baidu.tbadk.imageManager.c.Eg().fe(this.aOP.getBlockSize());
        this.aFt.am(6);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(this, this.aOP, this.aPj, Il());
        aVar.execute(new Object[0]);
        this.aPk.add(aVar);
    }

    public com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> Il() {
        return this.aPl;
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> Im() {
        return this.aFt;
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask {
        private int aOC;
        private BitmapRegionDecoder aPj;
        private com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aPl;
        private com.baidu.tbadk.widget.a.a.b aPn;
        private com.baidu.tbadk.widget.a.b.a aPo;
        private c aPp;
        private int column;
        private int row;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            com.baidu.tbadk.widget.a.a.a HP;
            if (this.aPl != null && this.aPn.p(this.row, this.column, this.aOC)) {
                Rect q = this.aPn.q(this.row, this.column, this.aOC);
                this.aPn.e(q);
                if (!f(q)) {
                    try {
                        HP = this.aPp.Im().fH();
                        if (HP != null) {
                            if (!HP.d(q)) {
                                System.currentTimeMillis();
                                HP.HH();
                            }
                        } else {
                            HP = this.aPn.HP();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.aPl.aj((int) (this.aPl.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            HP = this.aPn.HP();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.aOC;
                    options.inBitmap = HP.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.aPj.decodeRegion(q, options);
                    decodeRegion.prepareToDraw();
                    HP.setBitmap(decodeRegion);
                    HP.o(this.row, this.column, this.aOC);
                    this.aPl.put(HP.HK(), HP);
                    if (this.aPo != null) {
                        this.aPo.Bs();
                    }
                }
            }
            return null;
        }

        public a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aOC = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar, com.baidu.tbadk.widget.a.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, com.baidu.adp.lib.e.a<a.C0066a, com.baidu.tbadk.widget.a.a.a> aVar) {
            this.aPn = bVar;
            this.aPj = bitmapRegionDecoder;
            this.aPl = aVar;
            this.aPp = cVar;
        }

        public void b(com.baidu.tbadk.widget.a.b.a aVar) {
            this.aPo = aVar;
        }

        private boolean f(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }
}
