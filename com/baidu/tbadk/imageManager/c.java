package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c bwo = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> bwp;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> bwq;
    private com.baidu.adp.lib.e.a<String, Bitmap> bwr;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> bws;
    private com.baidu.tbadk.widget.a.c.b bwt;

    public static c Mw() {
        return bwo;
    }

    private c() {
        this.bwp = null;
        this.bwq = null;
        this.bwr = null;
        this.bwp = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.bwq = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.bwr = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.bws != null && this.bwt != null) {
            if (this.bwt.getBlockSize() == i) {
                return this.bws;
            }
            this.bwt.iD(i);
            this.bws.clear();
        }
        if (this.bwt == null) {
            this.bwt = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.bws == null) {
            this.bws = new com.baidu.adp.lib.e.b<>(this.bwt, 6, 0);
        }
        return this.bws;
    }

    public void Mx() {
        if (this.bws != null) {
            this.bws.dg(0);
            this.bws.df(0);
            this.bws.clear();
            this.bws = null;
        }
    }

    public int My() {
        return this.bwq.getMaxSize();
    }

    public void aH(int i, int i2) {
        hV(i);
        hW(i2);
        hX(30);
    }

    public void hV(int i) {
        this.bwp.dc(i);
    }

    public void hW(int i) {
        this.bwq.dc(i);
    }

    public void hX(int i) {
        this.bwr.dc(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.bwp != null) {
            this.bwp.put(str, aVar);
        }
    }

    public boolean hY(int i) {
        return this.bwq.db(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.bwq != null) {
            if (BdLog.isDebugMode()) {
            }
            this.bwq.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gM(String str) {
        this.bwp.remove(str);
    }

    public void gN(String str) {
        this.bwq.remove(str);
    }

    public com.baidu.adp.widget.a.a gO(String str) {
        return this.bwp.get(str);
    }

    public com.baidu.adp.widget.a.a gP(String str) {
        return this.bwq.get(str);
    }

    public void Mz() {
        this.bwp.clear();
        this.bwq.clear();
    }

    public String toString() {
        return "pic:" + this.bwq.toString() + "  photo:" + this.bwp.toString();
    }

    public String lN() {
        return this.bwq.size() + "/" + this.bwq.getMaxSize() + "/" + this.bwq.evictionCount() + "_" + this.bwp.size() + "/" + this.bwp.getMaxSize() + "/" + this.bwp.evictionCount();
    }
}
