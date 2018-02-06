package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c bwB = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> bwC;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> bwD;
    private com.baidu.adp.lib.e.a<String, Bitmap> bwE;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> bwF;
    private com.baidu.tbadk.widget.a.c.b bwG;

    public static c Mx() {
        return bwB;
    }

    private c() {
        this.bwC = null;
        this.bwD = null;
        this.bwE = null;
        this.bwC = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.bwD = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.bwE = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.bwF != null && this.bwG != null) {
            if (this.bwG.getBlockSize() == i) {
                return this.bwF;
            }
            this.bwG.iD(i);
            this.bwF.clear();
        }
        if (this.bwG == null) {
            this.bwG = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.bwF == null) {
            this.bwF = new com.baidu.adp.lib.e.b<>(this.bwG, 6, 0);
        }
        return this.bwF;
    }

    public void My() {
        if (this.bwF != null) {
            this.bwF.dg(0);
            this.bwF.df(0);
            this.bwF.clear();
            this.bwF = null;
        }
    }

    public int Mz() {
        return this.bwD.getMaxSize();
    }

    public void aH(int i, int i2) {
        hV(i);
        hW(i2);
        hX(30);
    }

    public void hV(int i) {
        this.bwC.dc(i);
    }

    public void hW(int i) {
        this.bwD.dc(i);
    }

    public void hX(int i) {
        this.bwE.dc(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.bwC != null) {
            this.bwC.put(str, aVar);
        }
    }

    public boolean hY(int i) {
        return this.bwD.db(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.bwD != null) {
            if (BdLog.isDebugMode()) {
            }
            this.bwD.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gM(String str) {
        this.bwC.remove(str);
    }

    public void gN(String str) {
        this.bwD.remove(str);
    }

    public com.baidu.adp.widget.a.a gO(String str) {
        return this.bwC.get(str);
    }

    public com.baidu.adp.widget.a.a gP(String str) {
        return this.bwD.get(str);
    }

    public void MA() {
        this.bwC.clear();
        this.bwD.clear();
    }

    public String toString() {
        return "pic:" + this.bwD.toString() + "  photo:" + this.bwC.toString();
    }

    public String lN() {
        return this.bwD.size() + "/" + this.bwD.getMaxSize() + "/" + this.bwD.evictionCount() + "_" + this.bwC.size() + "/" + this.bwC.getMaxSize() + "/" + this.bwC.evictionCount();
    }
}
