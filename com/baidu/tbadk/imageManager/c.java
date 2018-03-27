package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c bwr = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> bws;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> bwt;
    private com.baidu.adp.lib.e.a<String, Bitmap> bwu;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> bwv;
    private com.baidu.tbadk.widget.a.c.b bww;

    public static c Mx() {
        return bwr;
    }

    private c() {
        this.bws = null;
        this.bwt = null;
        this.bwu = null;
        this.bws = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.a.a aVar, com.baidu.adp.widget.a.a aVar2) {
                if (aVar != null) {
                    aVar.sg();
                }
            }
        };
        this.bwt = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.sg();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.bwu = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> hU(int i) {
        if (this.bwv != null && this.bww != null) {
            if (this.bww.getBlockSize() == i) {
                return this.bwv;
            }
            this.bww.iD(i);
            this.bwv.clear();
        }
        if (this.bww == null) {
            this.bww = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.bwv == null) {
            this.bwv = new com.baidu.adp.lib.e.b<>(this.bww, 6, 0);
        }
        return this.bwv;
    }

    public void My() {
        if (this.bwv != null) {
            this.bwv.dg(0);
            this.bwv.df(0);
            this.bwv.clear();
            this.bwv = null;
        }
    }

    public int Mz() {
        return this.bwt.getMaxSize();
    }

    public void aH(int i, int i2) {
        hV(i);
        hW(i2);
        hX(30);
    }

    public void hV(int i) {
        this.bws.dc(i);
    }

    public void hW(int i) {
        this.bwt.dc(i);
    }

    public void hX(int i) {
        this.bwu.dc(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.bws != null) {
            this.bws.put(str, aVar);
        }
    }

    public boolean hY(int i) {
        return this.bwt.db(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.bwt != null) {
            if (BdLog.isDebugMode()) {
            }
            this.bwt.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gM(String str) {
        this.bws.remove(str);
    }

    public void gN(String str) {
        this.bwt.remove(str);
    }

    public com.baidu.adp.widget.a.a gO(String str) {
        return this.bws.get(str);
    }

    public com.baidu.adp.widget.a.a gP(String str) {
        return this.bwt.get(str);
    }

    public void MA() {
        this.bws.clear();
        this.bwt.clear();
    }

    public String toString() {
        return "pic:" + this.bwt.toString() + "  photo:" + this.bws.toString();
    }

    public String lN() {
        return this.bwt.size() + "/" + this.bwt.getMaxSize() + "/" + this.bwt.evictionCount() + "_" + this.bws.size() + "/" + this.bws.getMaxSize() + "/" + this.bws.evictionCount();
    }
}
