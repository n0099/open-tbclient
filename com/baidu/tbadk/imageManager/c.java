package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
/* loaded from: classes.dex */
public class c {
    private static c aYK = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aYL;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aYM;
    private com.baidu.adp.lib.e.a<String, Bitmap> aYN;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aYO;
    private com.baidu.tbadk.widget.largeImage.b.b aYP;

    public static c Mq() {
        return aYK;
    }

    private c() {
        this.aYL = null;
        this.aYM = null;
        this.aYN = null;
        this.aYL = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.op();
                }
            }
        };
        this.aYM = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.op();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.aYN = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> fI(int i) {
        if (this.aYO != null && this.aYP != null) {
            if (this.aYP.getBlockSize() == i) {
                return this.aYO;
            }
            this.aYP.gp(i);
            this.aYO.clear();
        }
        if (this.aYP == null) {
            this.aYP = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.aYO == null) {
            this.aYO = new com.baidu.adp.lib.e.b<>(this.aYP, 6, 0);
        }
        return this.aYO;
    }

    public void Mr() {
        if (this.aYO != null) {
            this.aYO.aH(0);
            this.aYO.aG(0);
            this.aYO.clear();
            this.aYO = null;
        }
    }

    public int Ms() {
        return this.aYM.getMaxSize();
    }

    public void J(int i, int i2) {
        fJ(i);
        fK(i2);
        fL(30);
    }

    public void fJ(int i) {
        this.aYL.aD(i);
    }

    public void fK(int i) {
        this.aYM.aD(i);
    }

    public void fL(int i) {
        this.aYN.aD(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aYN.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aYN.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aYL != null) {
            this.aYL.put(str, aVar);
        }
    }

    public boolean fM(int i) {
        return this.aYM.aC(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aYM != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aYM.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void hM(String str) {
        this.aYL.remove(str);
    }

    public void hN(String str) {
        this.aYM.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a hO(String str) {
        return this.aYL.get(str);
    }

    public com.baidu.adp.widget.ImageView.a hP(String str) {
        return this.aYM.get(str);
    }

    public void Mt() {
        this.aYL.clear();
        this.aYM.clear();
    }

    public String toString() {
        return "pic:" + this.aYM.toString() + "  photo:" + this.aYL.toString();
    }

    public String ib() {
        return this.aYM.size() + "/" + this.aYM.getMaxSize() + "/" + this.aYM.evictionCount() + BaseRequestAction.SPLITE + this.aYL.size() + "/" + this.aYL.getMaxSize() + "/" + this.aYL.evictionCount();
    }
}
