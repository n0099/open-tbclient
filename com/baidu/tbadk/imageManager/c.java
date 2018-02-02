package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c bur = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> bus;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> but;
    private com.baidu.adp.lib.e.a<String, Bitmap> buu;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> buv;
    private com.baidu.tbadk.widget.a.c.b buw;

    public static c LR() {
        return bur;
    }

    private c() {
        this.bus = null;
        this.but = null;
        this.buu = null;
        this.bus = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.a.a aVar, com.baidu.adp.widget.a.a aVar2) {
                if (aVar != null) {
                    aVar.si();
                }
            }
        };
        this.but = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: d */
            public int sizeOf(String str, com.baidu.adp.widget.a.a aVar) {
                if (aVar != null) {
                    return aVar.size();
                }
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.a.a aVar, com.baidu.adp.widget.a.a aVar2) {
                if (aVar != null) {
                    if (BdLog.isDebugMode()) {
                    }
                    aVar.si();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE, str));
                }
            }
        };
        this.buu = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
        };
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> hW(int i) {
        if (this.buv != null && this.buw != null) {
            if (this.buw.getBlockSize() == i) {
                return this.buv;
            }
            this.buw.iG(i);
            this.buv.clear();
        }
        if (this.buw == null) {
            this.buw = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.buv == null) {
            this.buv = new com.baidu.adp.lib.e.b<>(this.buw, 6, 0);
        }
        return this.buv;
    }

    public void LS() {
        if (this.buv != null) {
            this.buv.dg(0);
            this.buv.df(0);
            this.buv.clear();
            this.buv = null;
        }
    }

    public int LT() {
        return this.but.getMaxSize();
    }

    public void aH(int i, int i2) {
        hX(i);
        hY(i2);
        hZ(30);
    }

    public void hX(int i) {
        this.bus.dc(i);
    }

    public void hY(int i) {
        this.but.dc(i);
    }

    public void hZ(int i) {
        this.buu.dc(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.bus != null) {
            this.bus.put(str, aVar);
        }
    }

    public boolean ia(int i) {
        return this.but.db(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.but != null) {
            if (BdLog.isDebugMode()) {
            }
            this.but.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gD(String str) {
        this.bus.remove(str);
    }

    public void gE(String str) {
        this.but.remove(str);
    }

    public com.baidu.adp.widget.a.a gF(String str) {
        return this.bus.get(str);
    }

    public com.baidu.adp.widget.a.a gG(String str) {
        return this.but.get(str);
    }

    public void LU() {
        this.bus.clear();
        this.but.clear();
    }

    public String toString() {
        return "pic:" + this.but.toString() + "  photo:" + this.bus.toString();
    }

    public String lN() {
        return this.but.size() + "/" + this.but.getMaxSize() + "/" + this.but.evictionCount() + "_" + this.bus.size() + "/" + this.bus.getMaxSize() + "/" + this.bus.evictionCount();
    }
}
