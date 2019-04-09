package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c cmy = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cmA;
    private com.baidu.adp.lib.e.a<String, Bitmap> cmB;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cmC;
    private com.baidu.tbadk.widget.largeImage.b.b cmD;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cmz;

    public static c anm() {
        return cmy;
    }

    private c() {
        this.cmz = null;
        this.cmA = null;
        this.cmB = null;
        this.cmz = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.ox();
                }
            }
        };
        this.cmA = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.ox();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.cmB = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> jH(int i) {
        if (this.cmC != null && this.cmD != null) {
            if (this.cmD.getBlockSize() == i) {
                return this.cmC;
            }
            this.cmD.kr(i);
            this.cmC.clear();
        }
        if (this.cmD == null) {
            this.cmD = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.cmC == null) {
            this.cmC = new com.baidu.adp.lib.e.b<>(this.cmD, 6, 0);
        }
        return this.cmC;
    }

    public void ann() {
        if (this.cmC != null) {
            this.cmC.ap(0);
            this.cmC.ao(0);
            this.cmC.clear();
            this.cmC = null;
        }
    }

    public int ano() {
        return this.cmA.getMaxSize();
    }

    public void ah(int i, int i2) {
        jI(i);
        jJ(i2);
        jK(60);
    }

    public void jI(int i) {
        this.cmz.al(i);
    }

    public void jJ(int i) {
        this.cmA.al(i);
    }

    public void jK(int i) {
        this.cmB.al(i);
    }

    public void e(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.cmB.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.cmB.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cmz != null) {
            this.cmz.put(str, aVar);
        }
    }

    public boolean jL(int i) {
        return this.cmA.ak(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cmA != null) {
            if (BdLog.isDebugMode()) {
            }
            this.cmA.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void pg(String str) {
        this.cmz.remove(str);
    }

    public void ph(String str) {
        this.cmA.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a pi(String str) {
        return this.cmz.get(str);
    }

    public com.baidu.adp.widget.ImageView.a pj(String str) {
        return this.cmA.get(str);
    }

    public void anp() {
        this.cmz.clear();
        this.cmA.clear();
    }

    public String toString() {
        return "pic:" + this.cmA.toString() + "  photo:" + this.cmz.toString();
    }

    public String ia() {
        return this.cmA.size() + "/" + this.cmA.getMaxSize() + "/" + this.cmA.evictionCount() + "_" + this.cmz.size() + "/" + this.cmz.getMaxSize() + "/" + this.cmz.evictionCount();
    }
}
