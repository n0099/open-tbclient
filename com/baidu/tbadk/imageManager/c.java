package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
/* loaded from: classes.dex */
public class c {
    private static c bcl = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> bcm;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> bcn;
    private com.baidu.adp.lib.e.a<String, Bitmap> bco;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> bcp;
    private com.baidu.tbadk.widget.largeImage.b.b bcq;

    public static c Nv() {
        return bcl;
    }

    private c() {
        this.bcm = null;
        this.bcn = null;
        this.bco = null;
        this.bcm = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.oo();
                }
            }
        };
        this.bcn = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.oo();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.bco = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.bcp != null && this.bcq != null) {
            if (this.bcq.getBlockSize() == i) {
                return this.bcp;
            }
            this.bcq.gE(i);
            this.bcp.clear();
        }
        if (this.bcq == null) {
            this.bcq = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.bcp == null) {
            this.bcp = new com.baidu.adp.lib.e.b<>(this.bcq, 6, 0);
        }
        return this.bcp;
    }

    public void Nw() {
        if (this.bcp != null) {
            this.bcp.aH(0);
            this.bcp.aG(0);
            this.bcp.clear();
            this.bcp = null;
        }
    }

    public int Nx() {
        return this.bcn.getMaxSize();
    }

    public void K(int i, int i2) {
        fY(i);
        fZ(i2);
        ga(30);
    }

    public void fY(int i) {
        this.bcm.aD(i);
    }

    public void fZ(int i) {
        this.bcn.aD(i);
    }

    public void ga(int i) {
        this.bco.aD(i);
    }

    public void d(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.bco.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.bco.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.bcm != null) {
            this.bcm.put(str, aVar);
        }
    }

    public boolean gb(int i) {
        return this.bcn.aC(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.bcn != null) {
            if (BdLog.isDebugMode()) {
            }
            this.bcn.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    /* renamed from: if  reason: not valid java name */
    public void m17if(String str) {
        this.bcm.remove(str);
    }

    public void ig(String str) {
        this.bcn.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a ih(String str) {
        return this.bcm.get(str);
    }

    public com.baidu.adp.widget.ImageView.a ii(String str) {
        return this.bcn.get(str);
    }

    public void Ny() {
        this.bcm.clear();
        this.bcn.clear();
    }

    public String toString() {
        return "pic:" + this.bcn.toString() + "  photo:" + this.bcm.toString();
    }

    public String ib() {
        return this.bcn.size() + "/" + this.bcn.getMaxSize() + "/" + this.bcn.evictionCount() + BaseRequestAction.SPLITE + this.bcm.size() + "/" + this.bcm.getMaxSize() + "/" + this.bcm.evictionCount();
    }
}
