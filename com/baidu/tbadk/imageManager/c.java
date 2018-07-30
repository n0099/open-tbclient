package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aQi = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aQj;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aQk;
    private com.baidu.adp.lib.e.a<String, Bitmap> aQl;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aQm;
    private com.baidu.tbadk.widget.largeImage.b.b aQn;

    public static c IQ() {
        return aQi;
    }

    private c() {
        this.aQj = null;
        this.aQk = null;
        this.aQl = null;
        this.aQj = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.na();
                }
            }
        };
        this.aQk = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.na();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.aQl = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> fa(int i) {
        if (this.aQm != null && this.aQn != null) {
            if (this.aQn.getBlockSize() == i) {
                return this.aQm;
            }
            this.aQn.fH(i);
            this.aQm.clear();
        }
        if (this.aQn == null) {
            this.aQn = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.aQm == null) {
            this.aQm = new com.baidu.adp.lib.e.b<>(this.aQn, 6, 0);
        }
        return this.aQm;
    }

    public void IR() {
        if (this.aQm != null) {
            this.aQm.ai(0);
            this.aQm.ah(0);
            this.aQm.clear();
            this.aQm = null;
        }
    }

    public int IS() {
        return this.aQk.getMaxSize();
    }

    public void H(int i, int i2) {
        fb(i);
        fc(i2);
        fd(30);
    }

    public void fb(int i) {
        this.aQj.ae(i);
    }

    public void fc(int i) {
        this.aQk.ae(i);
    }

    public void fd(int i) {
        this.aQl.ae(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aQl.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aQl.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aQj != null) {
            this.aQj.put(str, aVar);
        }
    }

    public boolean fe(int i) {
        return this.aQk.ad(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aQk != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aQk.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void hb(String str) {
        this.aQj.remove(str);
    }

    public void hc(String str) {
        this.aQk.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a hd(String str) {
        return this.aQj.get(str);
    }

    public com.baidu.adp.widget.ImageView.a he(String str) {
        return this.aQk.get(str);
    }

    public void IT() {
        this.aQj.clear();
        this.aQk.clear();
    }

    public String toString() {
        return "pic:" + this.aQk.toString() + "  photo:" + this.aQj.toString();
    }

    public String gH() {
        return this.aQk.size() + "/" + this.aQk.getMaxSize() + "/" + this.aQk.evictionCount() + "_" + this.aQj.size() + "/" + this.aQj.getMaxSize() + "/" + this.aQj.evictionCount();
    }
}
