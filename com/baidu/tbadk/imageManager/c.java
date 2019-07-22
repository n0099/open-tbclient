package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c cvV = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cvW;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cvX;
    private com.baidu.adp.lib.e.a<String, Bitmap> cvY;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cvZ;
    private com.baidu.tbadk.widget.largeImage.b.b cwa;

    public static c atw() {
        return cvV;
    }

    private c() {
        this.cvW = null;
        this.cvX = null;
        this.cvY = null;
        this.cvW = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.nJ();
                }
            }
        };
        this.cvX = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.nJ();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.cvY = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> kB(int i) {
        if (this.cvZ != null && this.cwa != null) {
            if (this.cwa.qe() == i) {
                return this.cvZ;
            }
            this.cwa.lm(i);
            this.cvZ.clear();
        }
        if (this.cwa == null) {
            this.cwa = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.cvZ == null) {
            this.cvZ = new com.baidu.adp.lib.e.b<>(this.cwa, 6, 0);
        }
        return this.cvZ;
    }

    public void atx() {
        if (this.cvZ != null) {
            this.cvZ.ai(0);
            this.cvZ.ah(0);
            this.cvZ.clear();
            this.cvZ = null;
        }
    }

    public int aty() {
        return this.cvX.hs();
    }

    public void ak(int i, int i2) {
        kC(i);
        kD(i2);
        kE(60);
    }

    public void kC(int i) {
        this.cvW.ae(i);
    }

    public void kD(int i) {
        this.cvX.ae(i);
    }

    public void kE(int i) {
        this.cvY.ae(i);
    }

    public void e(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.cvY.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.cvY.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cvW != null) {
            this.cvW.put(str, aVar);
        }
    }

    public boolean kF(int i) {
        return this.cvX.ad(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cvX != null) {
            if (BdLog.isDebugMode()) {
            }
            this.cvX.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void qE(String str) {
        this.cvW.remove(str);
    }

    public void qF(String str) {
        this.cvX.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a qG(String str) {
        return this.cvW.get(str);
    }

    public com.baidu.adp.widget.ImageView.a qH(String str) {
        return this.cvX.get(str);
    }

    public void atz() {
        this.cvW.clear();
        this.cvX.clear();
    }

    public String toString() {
        return "pic:" + this.cvX.toString() + "  photo:" + this.cvW.toString();
    }

    public String hd() {
        return this.cvX.size() + "/" + this.cvX.hs() + "/" + this.cvX.evictionCount() + "_" + this.cvW.size() + "/" + this.cvW.hs() + "/" + this.cvW.evictionCount();
    }
}
