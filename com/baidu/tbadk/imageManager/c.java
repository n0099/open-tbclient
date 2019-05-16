package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c cuG = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cuH;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cuI;
    private com.baidu.adp.lib.e.a<String, Bitmap> cuJ;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cuK;
    private com.baidu.tbadk.widget.largeImage.b.b cuL;

    public static c asp() {
        return cuG;
    }

    private c() {
        this.cuH = null;
        this.cuI = null;
        this.cuJ = null;
        this.cuH = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.nr();
                }
            }
        };
        this.cuI = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.nr();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.cuJ = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> kv(int i) {
        if (this.cuK != null && this.cuL != null) {
            if (this.cuL.getBlockSize() == i) {
                return this.cuK;
            }
            this.cuL.lg(i);
            this.cuK.clear();
        }
        if (this.cuL == null) {
            this.cuL = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.cuK == null) {
            this.cuK = new com.baidu.adp.lib.e.b<>(this.cuL, 6, 0);
        }
        return this.cuK;
    }

    public void asq() {
        if (this.cuK != null) {
            this.cuK.ai(0);
            this.cuK.ah(0);
            this.cuK.clear();
            this.cuK = null;
        }
    }

    public int asr() {
        return this.cuI.getMaxSize();
    }

    public void ah(int i, int i2) {
        kw(i);
        kx(i2);
        ky(60);
    }

    public void kw(int i) {
        this.cuH.ae(i);
    }

    public void kx(int i) {
        this.cuI.ae(i);
    }

    public void ky(int i) {
        this.cuJ.ae(i);
    }

    public void e(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.cuJ.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.cuJ.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cuH != null) {
            this.cuH.put(str, aVar);
        }
    }

    public boolean kz(int i) {
        return this.cuI.ad(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cuI != null) {
            if (BdLog.isDebugMode()) {
            }
            this.cuI.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void qo(String str) {
        this.cuH.remove(str);
    }

    public void qp(String str) {
        this.cuI.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a qq(String str) {
        return this.cuH.get(str);
    }

    public com.baidu.adp.widget.ImageView.a qr(String str) {
        return this.cuI.get(str);
    }

    public void ass() {
        this.cuH.clear();
        this.cuI.clear();
    }

    public String toString() {
        return "pic:" + this.cuI.toString() + "  photo:" + this.cuH.toString();
    }

    public String gU() {
        return this.cuI.size() + "/" + this.cuI.getMaxSize() + "/" + this.cuI.evictionCount() + "_" + this.cuH.size() + "/" + this.cuH.getMaxSize() + "/" + this.cuH.evictionCount();
    }
}
