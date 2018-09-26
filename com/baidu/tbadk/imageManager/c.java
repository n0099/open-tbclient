package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aTx = new c();
    private com.baidu.adp.lib.e.a<String, Bitmap> aTA;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aTB;
    private com.baidu.tbadk.widget.largeImage.b.b aTC;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aTy;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aTz;

    public static c Kg() {
        return aTx;
    }

    private c() {
        this.aTy = null;
        this.aTz = null;
        this.aTA = null;
        this.aTy = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.og();
                }
            }
        };
        this.aTz = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.og();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.aTA = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> fl(int i) {
        if (this.aTB != null && this.aTC != null) {
            if (this.aTC.getBlockSize() == i) {
                return this.aTB;
            }
            this.aTC.fS(i);
            this.aTB.clear();
        }
        if (this.aTC == null) {
            this.aTC = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.aTB == null) {
            this.aTB = new com.baidu.adp.lib.e.b<>(this.aTC, 6, 0);
        }
        return this.aTB;
    }

    public void Kh() {
        if (this.aTB != null) {
            this.aTB.aq(0);
            this.aTB.ap(0);
            this.aTB.clear();
            this.aTB = null;
        }
    }

    public int Ki() {
        return this.aTz.getMaxSize();
    }

    public void J(int i, int i2) {
        fm(i);
        fn(i2);
        fo(30);
    }

    public void fm(int i) {
        this.aTy.am(i);
    }

    public void fn(int i) {
        this.aTz.am(i);
    }

    public void fo(int i) {
        this.aTA.am(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aTA.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aTA.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aTy != null) {
            this.aTy.put(str, aVar);
        }
    }

    public boolean fp(int i) {
        return this.aTz.al(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aTz != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aTz.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void hx(String str) {
        this.aTy.remove(str);
    }

    public void hy(String str) {
        this.aTz.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a hz(String str) {
        return this.aTy.get(str);
    }

    public com.baidu.adp.widget.ImageView.a hA(String str) {
        return this.aTz.get(str);
    }

    public void Kj() {
        this.aTy.clear();
        this.aTz.clear();
    }

    public String toString() {
        return "pic:" + this.aTz.toString() + "  photo:" + this.aTy.toString();
    }

    public String hN() {
        return this.aTz.size() + "/" + this.aTz.getMaxSize() + "/" + this.aTz.evictionCount() + "_" + this.aTy.size() + "/" + this.aTy.getMaxSize() + "/" + this.aTy.evictionCount();
    }
}
