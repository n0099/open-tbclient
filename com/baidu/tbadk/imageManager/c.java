package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c cuH = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cuI;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cuJ;
    private com.baidu.adp.lib.e.a<String, Bitmap> cuK;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cuL;
    private com.baidu.tbadk.widget.largeImage.b.b cuM;

    public static c asp() {
        return cuH;
    }

    private c() {
        this.cuI = null;
        this.cuJ = null;
        this.cuK = null;
        this.cuI = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.cuJ = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.cuK = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.cuL != null && this.cuM != null) {
            if (this.cuM.getBlockSize() == i) {
                return this.cuL;
            }
            this.cuM.lg(i);
            this.cuL.clear();
        }
        if (this.cuM == null) {
            this.cuM = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.cuL == null) {
            this.cuL = new com.baidu.adp.lib.e.b<>(this.cuM, 6, 0);
        }
        return this.cuL;
    }

    public void asq() {
        if (this.cuL != null) {
            this.cuL.ai(0);
            this.cuL.ah(0);
            this.cuL.clear();
            this.cuL = null;
        }
    }

    public int asr() {
        return this.cuJ.getMaxSize();
    }

    public void ah(int i, int i2) {
        kw(i);
        kx(i2);
        ky(60);
    }

    public void kw(int i) {
        this.cuI.ae(i);
    }

    public void kx(int i) {
        this.cuJ.ae(i);
    }

    public void ky(int i) {
        this.cuK.ae(i);
    }

    public void e(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.cuK.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.cuK.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cuI != null) {
            this.cuI.put(str, aVar);
        }
    }

    public boolean kz(int i) {
        return this.cuJ.ad(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cuJ != null) {
            if (BdLog.isDebugMode()) {
            }
            this.cuJ.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void qn(String str) {
        this.cuI.remove(str);
    }

    public void qo(String str) {
        this.cuJ.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a qp(String str) {
        return this.cuI.get(str);
    }

    public com.baidu.adp.widget.ImageView.a qq(String str) {
        return this.cuJ.get(str);
    }

    public void ass() {
        this.cuI.clear();
        this.cuJ.clear();
    }

    public String toString() {
        return "pic:" + this.cuJ.toString() + "  photo:" + this.cuI.toString();
    }

    public String gU() {
        return this.cuJ.size() + "/" + this.cuJ.getMaxSize() + "/" + this.cuJ.evictionCount() + "_" + this.cuI.size() + "/" + this.cuI.getMaxSize() + "/" + this.cuI.evictionCount();
    }
}
