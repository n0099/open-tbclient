package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
/* loaded from: classes.dex */
public class c {
    private static c bcW = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> bcX;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> bcY;
    private com.baidu.adp.lib.e.a<String, Bitmap> bcZ;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> bda;
    private com.baidu.tbadk.widget.largeImage.b.b bdb;

    public static c NM() {
        return bcW;
    }

    private c() {
        this.bcX = null;
        this.bcY = null;
        this.bcZ = null;
        this.bcX = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.os();
                }
            }
        };
        this.bcY = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.os();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.bcZ = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> fX(int i) {
        if (this.bda != null && this.bdb != null) {
            if (this.bdb.getBlockSize() == i) {
                return this.bda;
            }
            this.bdb.gE(i);
            this.bda.clear();
        }
        if (this.bdb == null) {
            this.bdb = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.bda == null) {
            this.bda = new com.baidu.adp.lib.e.b<>(this.bdb, 6, 0);
        }
        return this.bda;
    }

    public void NN() {
        if (this.bda != null) {
            this.bda.aH(0);
            this.bda.aG(0);
            this.bda.clear();
            this.bda = null;
        }
    }

    public int NO() {
        return this.bcY.getMaxSize();
    }

    public void K(int i, int i2) {
        fY(i);
        fZ(i2);
        ga(30);
    }

    public void fY(int i) {
        this.bcX.aD(i);
    }

    public void fZ(int i) {
        this.bcY.aD(i);
    }

    public void ga(int i) {
        this.bcZ.aD(i);
    }

    public void d(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.bcZ.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.bcZ.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.bcX != null) {
            this.bcX.put(str, aVar);
        }
    }

    public boolean gb(int i) {
        return this.bcY.aC(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.bcY != null) {
            if (BdLog.isDebugMode()) {
            }
            this.bcY.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void it(String str) {
        this.bcX.remove(str);
    }

    public void iu(String str) {
        this.bcY.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a iv(String str) {
        return this.bcX.get(str);
    }

    public com.baidu.adp.widget.ImageView.a iw(String str) {
        return this.bcY.get(str);
    }

    public void NP() {
        this.bcX.clear();
        this.bcY.clear();
    }

    public String toString() {
        return "pic:" + this.bcY.toString() + "  photo:" + this.bcX.toString();
    }

    public String ib() {
        return this.bcY.size() + "/" + this.bcY.getMaxSize() + "/" + this.bcY.evictionCount() + BaseRequestAction.SPLITE + this.bcX.size() + "/" + this.bcX.getMaxSize() + "/" + this.bcX.evictionCount();
    }
}
