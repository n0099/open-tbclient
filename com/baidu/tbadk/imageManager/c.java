package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c btY = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> btZ;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> bua;
    private com.baidu.adp.lib.e.a<String, Bitmap> bub;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> buc;
    private com.baidu.tbadk.widget.a.c.b bud;

    public static c Mb() {
        return btY;
    }

    private c() {
        this.btZ = null;
        this.bua = null;
        this.bub = null;
        this.btZ = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.bua = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.bub = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> ia(int i) {
        if (this.buc != null && this.bud != null) {
            if (this.bud.getBlockSize() == i) {
                return this.buc;
            }
            this.bud.iK(i);
            this.buc.clear();
        }
        if (this.bud == null) {
            this.bud = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.buc == null) {
            this.buc = new com.baidu.adp.lib.e.b<>(this.bud, 6, 0);
        }
        return this.buc;
    }

    public void Mc() {
        if (this.buc != null) {
            this.buc.dg(0);
            this.buc.df(0);
            this.buc.clear();
            this.buc = null;
        }
    }

    public int Md() {
        return this.bua.getMaxSize();
    }

    public void aH(int i, int i2) {
        ib(i);
        ic(i2);
        id(30);
    }

    public void ib(int i) {
        this.btZ.dc(i);
    }

    public void ic(int i) {
        this.bua.dc(i);
    }

    public void id(int i) {
        this.bub.dc(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.btZ != null) {
            this.btZ.put(str, aVar);
        }
    }

    public boolean ie(int i) {
        return this.bua.db(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.bua != null) {
            if (BdLog.isDebugMode()) {
            }
            this.bua.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gu(String str) {
        this.btZ.remove(str);
    }

    public void gv(String str) {
        this.bua.remove(str);
    }

    public com.baidu.adp.widget.a.a gw(String str) {
        return this.btZ.get(str);
    }

    public com.baidu.adp.widget.a.a gx(String str) {
        return this.bua.get(str);
    }

    public void Me() {
        this.btZ.clear();
        this.bua.clear();
    }

    public String toString() {
        return "pic:" + this.bua.toString() + "  photo:" + this.btZ.toString();
    }

    public String lM() {
        return this.bua.size() + "/" + this.bua.getMaxSize() + "/" + this.bua.evictionCount() + "_" + this.btZ.size() + "/" + this.btZ.getMaxSize() + "/" + this.btZ.evictionCount();
    }
}
