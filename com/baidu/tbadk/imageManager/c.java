package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c bui = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> buj;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> buk;
    private com.baidu.adp.lib.e.a<String, Bitmap> bul;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> bum;
    private com.baidu.tbadk.widget.a.c.b bun;

    public static c LP() {
        return bui;
    }

    private c() {
        this.buj = null;
        this.buk = null;
        this.bul = null;
        this.buj = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.a.a aVar, com.baidu.adp.widget.a.a aVar2) {
                if (aVar != null) {
                    aVar.sh();
                }
            }
        };
        this.buk = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.sh();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE, str));
                }
            }
        };
        this.bul = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.bum != null && this.bun != null) {
            if (this.bun.getBlockSize() == i) {
                return this.bum;
            }
            this.bun.iG(i);
            this.bum.clear();
        }
        if (this.bun == null) {
            this.bun = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.bum == null) {
            this.bum = new com.baidu.adp.lib.e.b<>(this.bun, 6, 0);
        }
        return this.bum;
    }

    public void LQ() {
        if (this.bum != null) {
            this.bum.dg(0);
            this.bum.df(0);
            this.bum.clear();
            this.bum = null;
        }
    }

    public int LR() {
        return this.buk.getMaxSize();
    }

    public void aH(int i, int i2) {
        hX(i);
        hY(i2);
        hZ(30);
    }

    public void hX(int i) {
        this.buj.dc(i);
    }

    public void hY(int i) {
        this.buk.dc(i);
    }

    public void hZ(int i) {
        this.bul.dc(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.buj != null) {
            this.buj.put(str, aVar);
        }
    }

    public boolean ia(int i) {
        return this.buk.db(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.buk != null) {
            if (BdLog.isDebugMode()) {
            }
            this.buk.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gv(String str) {
        this.buj.remove(str);
    }

    public void gw(String str) {
        this.buk.remove(str);
    }

    public com.baidu.adp.widget.a.a gx(String str) {
        return this.buj.get(str);
    }

    public com.baidu.adp.widget.a.a gy(String str) {
        return this.buk.get(str);
    }

    public void LS() {
        this.buj.clear();
        this.buk.clear();
    }

    public String toString() {
        return "pic:" + this.buk.toString() + "  photo:" + this.buj.toString();
    }

    public String lM() {
        return this.buk.size() + "/" + this.buk.getMaxSize() + "/" + this.buk.evictionCount() + "_" + this.buj.size() + "/" + this.buj.getMaxSize() + "/" + this.buj.evictionCount();
    }
}
