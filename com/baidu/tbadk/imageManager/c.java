package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
/* loaded from: classes.dex */
public class c {
    private static c bcV = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> bcW;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> bcX;
    private com.baidu.adp.lib.e.a<String, Bitmap> bcY;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> bcZ;
    private com.baidu.tbadk.widget.largeImage.b.b bda;

    public static c NM() {
        return bcV;
    }

    private c() {
        this.bcW = null;
        this.bcX = null;
        this.bcY = null;
        this.bcW = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.bcX = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.bcY = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.bcZ != null && this.bda != null) {
            if (this.bda.getBlockSize() == i) {
                return this.bcZ;
            }
            this.bda.gE(i);
            this.bcZ.clear();
        }
        if (this.bda == null) {
            this.bda = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.bcZ == null) {
            this.bcZ = new com.baidu.adp.lib.e.b<>(this.bda, 6, 0);
        }
        return this.bcZ;
    }

    public void NN() {
        if (this.bcZ != null) {
            this.bcZ.aH(0);
            this.bcZ.aG(0);
            this.bcZ.clear();
            this.bcZ = null;
        }
    }

    public int NO() {
        return this.bcX.getMaxSize();
    }

    public void K(int i, int i2) {
        fY(i);
        fZ(i2);
        ga(30);
    }

    public void fY(int i) {
        this.bcW.aD(i);
    }

    public void fZ(int i) {
        this.bcX.aD(i);
    }

    public void ga(int i) {
        this.bcY.aD(i);
    }

    public void d(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.bcY.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.bcY.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.bcW != null) {
            this.bcW.put(str, aVar);
        }
    }

    public boolean gb(int i) {
        return this.bcX.aC(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.bcX != null) {
            if (BdLog.isDebugMode()) {
            }
            this.bcX.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void it(String str) {
        this.bcW.remove(str);
    }

    public void iu(String str) {
        this.bcX.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a iv(String str) {
        return this.bcW.get(str);
    }

    public com.baidu.adp.widget.ImageView.a iw(String str) {
        return this.bcX.get(str);
    }

    public void NP() {
        this.bcW.clear();
        this.bcX.clear();
    }

    public String toString() {
        return "pic:" + this.bcX.toString() + "  photo:" + this.bcW.toString();
    }

    public String ib() {
        return this.bcX.size() + "/" + this.bcX.getMaxSize() + "/" + this.bcX.evictionCount() + BaseRequestAction.SPLITE + this.bcW.size() + "/" + this.bcW.getMaxSize() + "/" + this.bcW.evictionCount();
    }
}
