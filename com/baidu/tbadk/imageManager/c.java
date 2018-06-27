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

    public static c IV() {
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
                    aVar.mY();
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
                    aVar.mY();
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> eZ(int i) {
        if (this.aQm != null && this.aQn != null) {
            if (this.aQn.getBlockSize() == i) {
                return this.aQm;
            }
            this.aQn.fG(i);
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

    public void IW() {
        if (this.aQm != null) {
            this.aQm.ah(0);
            this.aQm.ag(0);
            this.aQm.clear();
            this.aQm = null;
        }
    }

    public int IX() {
        return this.aQk.getMaxSize();
    }

    public void G(int i, int i2) {
        fa(i);
        fb(i2);
        fc(30);
    }

    public void fa(int i) {
        this.aQj.ad(i);
    }

    public void fb(int i) {
        this.aQk.ad(i);
    }

    public void fc(int i) {
        this.aQl.ad(i);
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

    public boolean fd(int i) {
        return this.aQk.ac(i);
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

    public void hf(String str) {
        this.aQj.remove(str);
    }

    public void hg(String str) {
        this.aQk.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a hh(String str) {
        return this.aQj.get(str);
    }

    public com.baidu.adp.widget.ImageView.a hi(String str) {
        return this.aQk.get(str);
    }

    public void IY() {
        this.aQj.clear();
        this.aQk.clear();
    }

    public String toString() {
        return "pic:" + this.aQk.toString() + "  photo:" + this.aQj.toString();
    }

    public String gI() {
        return this.aQk.size() + "/" + this.aQk.getMaxSize() + "/" + this.aQk.evictionCount() + "_" + this.aQj.size() + "/" + this.aQj.getMaxSize() + "/" + this.aQj.evictionCount();
    }
}
