package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c cwc = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cwd;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cwe;
    private com.baidu.adp.lib.e.a<String, Bitmap> cwf;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cwg;
    private com.baidu.tbadk.widget.largeImage.b.b cwh;

    public static c aty() {
        return cwc;
    }

    private c() {
        this.cwd = null;
        this.cwe = null;
        this.cwf = null;
        this.cwd = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.cwe = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.cwf = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> kC(int i) {
        if (this.cwg != null && this.cwh != null) {
            if (this.cwh.qe() == i) {
                return this.cwg;
            }
            this.cwh.ln(i);
            this.cwg.clear();
        }
        if (this.cwh == null) {
            this.cwh = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.cwg == null) {
            this.cwg = new com.baidu.adp.lib.e.b<>(this.cwh, 6, 0);
        }
        return this.cwg;
    }

    public void atz() {
        if (this.cwg != null) {
            this.cwg.ai(0);
            this.cwg.ah(0);
            this.cwg.clear();
            this.cwg = null;
        }
    }

    public int atA() {
        return this.cwe.hs();
    }

    public void ak(int i, int i2) {
        kD(i);
        kE(i2);
        kF(60);
    }

    public void kD(int i) {
        this.cwd.ae(i);
    }

    public void kE(int i) {
        this.cwe.ae(i);
    }

    public void kF(int i) {
        this.cwf.ae(i);
    }

    public void e(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.cwf.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.cwf.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cwd != null) {
            this.cwd.put(str, aVar);
        }
    }

    public boolean kG(int i) {
        return this.cwe.ad(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cwe != null) {
            if (BdLog.isDebugMode()) {
            }
            this.cwe.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void qE(String str) {
        this.cwd.remove(str);
    }

    public void qF(String str) {
        this.cwe.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a qG(String str) {
        return this.cwd.get(str);
    }

    public com.baidu.adp.widget.ImageView.a qH(String str) {
        return this.cwe.get(str);
    }

    public void atB() {
        this.cwd.clear();
        this.cwe.clear();
    }

    public String toString() {
        return "pic:" + this.cwe.toString() + "  photo:" + this.cwd.toString();
    }

    public String hd() {
        return this.cwe.size() + "/" + this.cwe.hs() + "/" + this.cwe.evictionCount() + "_" + this.cwd.size() + "/" + this.cwd.hs() + "/" + this.cwd.evictionCount();
    }
}
