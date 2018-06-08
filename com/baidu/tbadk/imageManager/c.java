package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aPm = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aPn;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aPo;
    private com.baidu.adp.lib.e.a<String, Bitmap> aPp;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aPq;
    private com.baidu.tbadk.widget.largeImage.b.b aPr;

    public static c ID() {
        return aPm;
    }

    private c() {
        this.aPn = null;
        this.aPo = null;
        this.aPp = null;
        this.aPn = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.mY();
                }
            }
        };
        this.aPo = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.mY();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.aPp = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> eY(int i) {
        if (this.aPq != null && this.aPr != null) {
            if (this.aPr.getBlockSize() == i) {
                return this.aPq;
            }
            this.aPr.fF(i);
            this.aPq.clear();
        }
        if (this.aPr == null) {
            this.aPr = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.aPq == null) {
            this.aPq = new com.baidu.adp.lib.e.b<>(this.aPr, 6, 0);
        }
        return this.aPq;
    }

    public void IE() {
        if (this.aPq != null) {
            this.aPq.ah(0);
            this.aPq.ag(0);
            this.aPq.clear();
            this.aPq = null;
        }
    }

    public int IF() {
        return this.aPo.getMaxSize();
    }

    public void G(int i, int i2) {
        eZ(i);
        fa(i2);
        fb(30);
    }

    public void eZ(int i) {
        this.aPn.ad(i);
    }

    public void fa(int i) {
        this.aPo.ad(i);
    }

    public void fb(int i) {
        this.aPp.ad(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aPp.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aPp.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aPn != null) {
            this.aPn.put(str, aVar);
        }
    }

    public boolean fc(int i) {
        return this.aPo.ac(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aPo != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aPo.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void hb(String str) {
        this.aPn.remove(str);
    }

    public void hc(String str) {
        this.aPo.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a hd(String str) {
        return this.aPn.get(str);
    }

    public com.baidu.adp.widget.ImageView.a he(String str) {
        return this.aPo.get(str);
    }

    public void IG() {
        this.aPn.clear();
        this.aPo.clear();
    }

    public String toString() {
        return "pic:" + this.aPo.toString() + "  photo:" + this.aPn.toString();
    }

    public String gI() {
        return this.aPo.size() + "/" + this.aPo.getMaxSize() + "/" + this.aPo.evictionCount() + "_" + this.aPn.size() + "/" + this.aPn.getMaxSize() + "/" + this.aPn.evictionCount();
    }
}
