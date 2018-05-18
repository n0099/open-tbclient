package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aGP = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aGQ;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aGR;
    private com.baidu.adp.lib.e.a<String, Bitmap> aGS;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aGT;
    private com.baidu.tbadk.widget.largeImage.b.b aGU;

    public static c EY() {
        return aGP;
    }

    private c() {
        this.aGQ = null;
        this.aGR = null;
        this.aGS = null;
        this.aGQ = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.kk();
                }
            }
        };
        this.aGR = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: d */
            public int sizeOf(String str, com.baidu.adp.widget.ImageView.a aVar) {
                if (aVar != null) {
                    return aVar.size();
                }
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    if (BdLog.isDebugMode()) {
                    }
                    aVar.kk();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.aGS = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> eU(int i) {
        if (this.aGT != null && this.aGU != null) {
            if (this.aGU.getBlockSize() == i) {
                return this.aGT;
            }
            this.aGU.fE(i);
            this.aGT.clear();
        }
        if (this.aGU == null) {
            this.aGU = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.aGT == null) {
            this.aGT = new com.baidu.adp.lib.e.b<>(this.aGU, 6, 0);
        }
        return this.aGT;
    }

    public void EZ() {
        if (this.aGT != null) {
            this.aGT.ag(0);
            this.aGT.af(0);
            this.aGT.clear();
            this.aGT = null;
        }
    }

    public int Fa() {
        return this.aGR.getMaxSize();
    }

    public void F(int i, int i2) {
        eV(i);
        eW(i2);
        eX(30);
    }

    public void eV(int i) {
        this.aGQ.ac(i);
    }

    public void eW(int i) {
        this.aGR.ac(i);
    }

    public void eX(int i) {
        this.aGS.ac(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aGS.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aGS.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aGQ != null) {
            this.aGQ.put(str, aVar);
        }
    }

    public boolean eY(int i) {
        return this.aGR.ab(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aGR != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aGR.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void gD(String str) {
        this.aGQ.remove(str);
    }

    public void gE(String str) {
        this.aGR.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a gF(String str) {
        return this.aGQ.get(str);
    }

    public com.baidu.adp.widget.ImageView.a gG(String str) {
        return this.aGR.get(str);
    }

    public void Fb() {
        this.aGQ.clear();
        this.aGR.clear();
    }

    public String toString() {
        return "pic:" + this.aGR.toString() + "  photo:" + this.aGQ.toString();
    }

    public String dR() {
        return this.aGR.size() + "/" + this.aGR.getMaxSize() + "/" + this.aGR.evictionCount() + "_" + this.aGQ.size() + "/" + this.aGQ.getMaxSize() + "/" + this.aGQ.evictionCount();
    }
}
