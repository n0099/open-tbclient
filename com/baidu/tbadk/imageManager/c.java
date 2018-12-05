package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
/* loaded from: classes.dex */
public class c {
    private static c bci = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> bcj;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> bck;
    private com.baidu.adp.lib.e.a<String, Bitmap> bcl;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> bcm;
    private com.baidu.tbadk.widget.largeImage.b.b bcn;

    public static c Nu() {
        return bci;
    }

    private c() {
        this.bcj = null;
        this.bck = null;
        this.bcl = null;
        this.bcj = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.bck = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.bcl = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> fW(int i) {
        if (this.bcm != null && this.bcn != null) {
            if (this.bcn.getBlockSize() == i) {
                return this.bcm;
            }
            this.bcn.gD(i);
            this.bcm.clear();
        }
        if (this.bcn == null) {
            this.bcn = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.bcm == null) {
            this.bcm = new com.baidu.adp.lib.e.b<>(this.bcn, 6, 0);
        }
        return this.bcm;
    }

    public void Nv() {
        if (this.bcm != null) {
            this.bcm.aH(0);
            this.bcm.aG(0);
            this.bcm.clear();
            this.bcm = null;
        }
    }

    public int Nw() {
        return this.bck.getMaxSize();
    }

    public void K(int i, int i2) {
        fX(i);
        fY(i2);
        fZ(30);
    }

    public void fX(int i) {
        this.bcj.aD(i);
    }

    public void fY(int i) {
        this.bck.aD(i);
    }

    public void fZ(int i) {
        this.bcl.aD(i);
    }

    public void d(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.bcl.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.bcl.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.bcj != null) {
            this.bcj.put(str, aVar);
        }
    }

    public boolean ga(int i) {
        return this.bck.aC(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.bck != null) {
            if (BdLog.isDebugMode()) {
            }
            this.bck.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void ie(String str) {
        this.bcj.remove(str);
    }

    /* renamed from: if  reason: not valid java name */
    public void m17if(String str) {
        this.bck.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a ig(String str) {
        return this.bcj.get(str);
    }

    public com.baidu.adp.widget.ImageView.a ih(String str) {
        return this.bck.get(str);
    }

    public void Nx() {
        this.bcj.clear();
        this.bck.clear();
    }

    public String toString() {
        return "pic:" + this.bck.toString() + "  photo:" + this.bcj.toString();
    }

    public String ib() {
        return this.bck.size() + "/" + this.bck.getMaxSize() + "/" + this.bck.evictionCount() + BaseRequestAction.SPLITE + this.bcj.size() + "/" + this.bcj.getMaxSize() + "/" + this.bcj.evictionCount();
    }
}
