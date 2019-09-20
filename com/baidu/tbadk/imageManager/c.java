package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c cwY = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cwZ;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cxa;
    private com.baidu.adp.lib.e.a<String, Bitmap> cxb;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cxc;
    private com.baidu.tbadk.widget.largeImage.b.b cxd;

    public static c atK() {
        return cwY;
    }

    private c() {
        this.cwZ = null;
        this.cxa = null;
        this.cxb = null;
        this.cwZ = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.cxa = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.cxb = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> kF(int i) {
        if (this.cxc != null && this.cxd != null) {
            if (this.cxd.qf() == i) {
                return this.cxc;
            }
            this.cxd.lr(i);
            this.cxc.clear();
        }
        if (this.cxd == null) {
            this.cxd = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.cxc == null) {
            this.cxc = new com.baidu.adp.lib.e.b<>(this.cxd, 6, 0);
        }
        return this.cxc;
    }

    public void atL() {
        if (this.cxc != null) {
            this.cxc.ai(0);
            this.cxc.ah(0);
            this.cxc.clear();
            this.cxc = null;
        }
    }

    public int atM() {
        return this.cxa.hs();
    }

    public void ak(int i, int i2) {
        kG(i);
        kH(i2);
        kI(60);
    }

    public void kG(int i) {
        this.cwZ.ae(i);
    }

    public void kH(int i) {
        this.cxa.ae(i);
    }

    public void kI(int i) {
        this.cxb.ae(i);
    }

    public void e(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.cxb.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.cxb.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cwZ != null) {
            this.cwZ.put(str, aVar);
        }
    }

    public boolean kJ(int i) {
        return this.cxa.ad(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cxa != null) {
            if (BdLog.isDebugMode()) {
            }
            this.cxa.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void qP(String str) {
        this.cwZ.remove(str);
    }

    public void qQ(String str) {
        this.cxa.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a qR(String str) {
        return this.cwZ.get(str);
    }

    public com.baidu.adp.widget.ImageView.a qS(String str) {
        return this.cxa.get(str);
    }

    public void atN() {
        this.cwZ.clear();
        this.cxa.clear();
    }

    public String toString() {
        return "pic:" + this.cxa.toString() + "  photo:" + this.cwZ.toString();
    }

    public String hd() {
        return this.cxa.size() + "/" + this.cxa.hs() + "/" + this.cxa.evictionCount() + "_" + this.cwZ.size() + "/" + this.cwZ.hs() + "/" + this.cwZ.evictionCount();
    }
}
