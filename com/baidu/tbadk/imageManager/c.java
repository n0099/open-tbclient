package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aQf = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aQg;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aQh;
    private com.baidu.adp.lib.e.a<String, Bitmap> aQi;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aQj;
    private com.baidu.tbadk.widget.largeImage.b.b aQk;

    public static c IQ() {
        return aQf;
    }

    private c() {
        this.aQg = null;
        this.aQh = null;
        this.aQi = null;
        this.aQg = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.aQh = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.aQi = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.aQj != null && this.aQk != null) {
            if (this.aQk.getBlockSize() == i) {
                return this.aQj;
            }
            this.aQk.fG(i);
            this.aQj.clear();
        }
        if (this.aQk == null) {
            this.aQk = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.aQj == null) {
            this.aQj = new com.baidu.adp.lib.e.b<>(this.aQk, 6, 0);
        }
        return this.aQj;
    }

    public void IR() {
        if (this.aQj != null) {
            this.aQj.ai(0);
            this.aQj.ah(0);
            this.aQj.clear();
            this.aQj = null;
        }
    }

    public int IS() {
        return this.aQh.getMaxSize();
    }

    public void H(int i, int i2) {
        fa(i);
        fb(i2);
        fc(30);
    }

    public void fa(int i) {
        this.aQg.ae(i);
    }

    public void fb(int i) {
        this.aQh.ae(i);
    }

    public void fc(int i) {
        this.aQi.ae(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aQi.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aQi.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aQg != null) {
            this.aQg.put(str, aVar);
        }
    }

    public boolean fd(int i) {
        return this.aQh.ad(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aQh != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aQh.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void hb(String str) {
        this.aQg.remove(str);
    }

    public void hc(String str) {
        this.aQh.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a hd(String str) {
        return this.aQg.get(str);
    }

    public com.baidu.adp.widget.ImageView.a he(String str) {
        return this.aQh.get(str);
    }

    public void IT() {
        this.aQg.clear();
        this.aQh.clear();
    }

    public String toString() {
        return "pic:" + this.aQh.toString() + "  photo:" + this.aQg.toString();
    }

    public String gH() {
        return this.aQh.size() + "/" + this.aQh.getMaxSize() + "/" + this.aQh.evictionCount() + "_" + this.aQg.size() + "/" + this.aQg.getMaxSize() + "/" + this.aQg.evictionCount();
    }
}
