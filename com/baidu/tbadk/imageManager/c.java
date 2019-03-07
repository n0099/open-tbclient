package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c cmv = new c();
    private com.baidu.tbadk.widget.largeImage.b.b cmA;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cmw;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cmx;
    private com.baidu.adp.lib.e.a<String, Bitmap> cmy;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cmz;

    public static c anq() {
        return cmv;
    }

    private c() {
        this.cmw = null;
        this.cmx = null;
        this.cmy = null;
        this.cmw = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.cmx = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.cmy = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> jI(int i) {
        if (this.cmz != null && this.cmA != null) {
            if (this.cmA.getBlockSize() == i) {
                return this.cmz;
            }
            this.cmA.ks(i);
            this.cmz.clear();
        }
        if (this.cmA == null) {
            this.cmA = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.cmz == null) {
            this.cmz = new com.baidu.adp.lib.e.b<>(this.cmA, 6, 0);
        }
        return this.cmz;
    }

    public void anr() {
        if (this.cmz != null) {
            this.cmz.aq(0);
            this.cmz.ap(0);
            this.cmz.clear();
            this.cmz = null;
        }
    }

    public int ans() {
        return this.cmx.getMaxSize();
    }

    public void ah(int i, int i2) {
        jJ(i);
        jK(i2);
        jL(60);
    }

    public void jJ(int i) {
        this.cmw.am(i);
    }

    public void jK(int i) {
        this.cmx.am(i);
    }

    public void jL(int i) {
        this.cmy.am(i);
    }

    public void e(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.cmy.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.cmy.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cmw != null) {
            this.cmw.put(str, aVar);
        }
    }

    public boolean jM(int i) {
        return this.cmx.al(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cmx != null) {
            if (BdLog.isDebugMode()) {
            }
            this.cmx.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void pf(String str) {
        this.cmw.remove(str);
    }

    public void pg(String str) {
        this.cmx.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a ph(String str) {
        return this.cmw.get(str);
    }

    public com.baidu.adp.widget.ImageView.a pi(String str) {
        return this.cmx.get(str);
    }

    public void ant() {
        this.cmw.clear();
        this.cmx.clear();
    }

    public String toString() {
        return "pic:" + this.cmx.toString() + "  photo:" + this.cmw.toString();
    }

    public String ia() {
        return this.cmx.size() + "/" + this.cmx.getMaxSize() + "/" + this.cmx.evictionCount() + "_" + this.cmw.size() + "/" + this.cmw.getMaxSize() + "/" + this.cmw.evictionCount();
    }
}
