package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
/* loaded from: classes.dex */
public class c {
    private static c aXW = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aXX;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aXY;
    private com.baidu.adp.lib.e.a<String, Bitmap> aXZ;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> aYa;
    private com.baidu.tbadk.widget.largeImage.b.b aYb;

    public static c Me() {
        return aXW;
    }

    private c() {
        this.aXX = null;
        this.aXY = null;
        this.aXZ = null;
        this.aXX = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.or();
                }
            }
        };
        this.aXY = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.or();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
                }
            }
        };
        this.aXZ = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> fu(int i) {
        if (this.aYa != null && this.aYb != null) {
            if (this.aYb.getBlockSize() == i) {
                return this.aYa;
            }
            this.aYb.gb(i);
            this.aYa.clear();
        }
        if (this.aYb == null) {
            this.aYb = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.aYa == null) {
            this.aYa = new com.baidu.adp.lib.e.b<>(this.aYb, 6, 0);
        }
        return this.aYa;
    }

    public void Mf() {
        if (this.aYa != null) {
            this.aYa.aq(0);
            this.aYa.ap(0);
            this.aYa.clear();
            this.aYa = null;
        }
    }

    public int Mg() {
        return this.aXY.getMaxSize();
    }

    public void J(int i, int i2) {
        fv(i);
        fw(i2);
        fx(30);
    }

    public void fv(int i) {
        this.aXX.am(i);
    }

    public void fw(int i) {
        this.aXY.am(i);
    }

    public void fx(int i) {
        this.aXZ.am(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aXZ.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aXZ.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aXX != null) {
            this.aXX.put(str, aVar);
        }
    }

    public boolean fy(int i) {
        return this.aXY.al(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aXY != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aXY.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void hL(String str) {
        this.aXX.remove(str);
    }

    public void hM(String str) {
        this.aXY.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a hN(String str) {
        return this.aXX.get(str);
    }

    public com.baidu.adp.widget.ImageView.a hO(String str) {
        return this.aXY.get(str);
    }

    public void Mh() {
        this.aXX.clear();
        this.aXY.clear();
    }

    public String toString() {
        return "pic:" + this.aXY.toString() + "  photo:" + this.aXX.toString();
    }

    public String ic() {
        return this.aXY.size() + "/" + this.aXY.getMaxSize() + "/" + this.aXY.evictionCount() + BaseRequestAction.SPLITE + this.aXX.size() + "/" + this.aXX.getMaxSize() + "/" + this.aXX.evictionCount();
    }
}
