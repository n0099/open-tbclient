package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aGO = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aGP;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aGQ;
    private com.baidu.adp.lib.e.a<String, Bitmap> aGR;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aGS;
    private com.baidu.tbadk.widget.largeImage.b.b aGT;

    public static c Fa() {
        return aGO;
    }

    private c() {
        this.aGP = null;
        this.aGQ = null;
        this.aGR = null;
        this.aGP = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.kl();
                }
            }
        };
        this.aGQ = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.kl();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.aGR = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.aGS != null && this.aGT != null) {
            if (this.aGT.getBlockSize() == i) {
                return this.aGS;
            }
            this.aGT.fE(i);
            this.aGS.clear();
        }
        if (this.aGT == null) {
            this.aGT = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.aGS == null) {
            this.aGS = new com.baidu.adp.lib.e.b<>(this.aGT, 6, 0);
        }
        return this.aGS;
    }

    public void Fb() {
        if (this.aGS != null) {
            this.aGS.ag(0);
            this.aGS.af(0);
            this.aGS.clear();
            this.aGS = null;
        }
    }

    public int Fc() {
        return this.aGQ.getMaxSize();
    }

    public void F(int i, int i2) {
        eV(i);
        eW(i2);
        eX(30);
    }

    public void eV(int i) {
        this.aGP.ac(i);
    }

    public void eW(int i) {
        this.aGQ.ac(i);
    }

    public void eX(int i) {
        this.aGR.ac(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aGR.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aGR.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aGP != null) {
            this.aGP.put(str, aVar);
        }
    }

    public boolean eY(int i) {
        return this.aGQ.ab(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aGQ != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aGQ.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void gD(String str) {
        this.aGP.remove(str);
    }

    public void gE(String str) {
        this.aGQ.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a gF(String str) {
        return this.aGP.get(str);
    }

    public com.baidu.adp.widget.ImageView.a gG(String str) {
        return this.aGQ.get(str);
    }

    public void Fd() {
        this.aGP.clear();
        this.aGQ.clear();
    }

    public String toString() {
        return "pic:" + this.aGQ.toString() + "  photo:" + this.aGP.toString();
    }

    public String dR() {
        return this.aGQ.size() + "/" + this.aGQ.getMaxSize() + "/" + this.aGQ.evictionCount() + "_" + this.aGP.size() + "/" + this.aGP.getMaxSize() + "/" + this.aGP.evictionCount();
    }
}
