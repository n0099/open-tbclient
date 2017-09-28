package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c aES = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aET;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aEU;
    private com.baidu.adp.lib.e.a<String, Bitmap> aEV;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aEW;
    private com.baidu.tbadk.widget.a.c.b aEX;

    public static c DZ() {
        return aES;
    }

    private c() {
        this.aET = null;
        this.aEU = null;
        this.aEV = null;
        this.aET = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.kM();
                }
            }
        };
        this.aEU = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.kM();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE, str));
                }
            }
        };
        this.aEV = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> fe(int i) {
        if (this.aEW != null && this.aEX != null) {
            if (this.aEX.getBlockSize() == i) {
                return this.aEW;
            }
            this.aEX.fF(i);
            this.aEW.clear();
        }
        if (this.aEX == null) {
            this.aEX = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.aEW == null) {
            this.aEW = new com.baidu.adp.lib.e.b<>(this.aEX, 6, 0);
        }
        return this.aEW;
    }

    public void Ea() {
        if (this.aEW != null) {
            this.aEW.an(0);
            this.aEW.am(0);
            this.aEW.clear();
            this.aEW = null;
        }
    }

    public int Eb() {
        return this.aEU.getMaxSize();
    }

    public void J(int i, int i2) {
        ff(i);
        fg(i2);
        fh(30);
    }

    public void ff(int i) {
        this.aET.aj(i);
    }

    public void fg(int i) {
        this.aEU.aj(i);
    }

    public void fh(int i) {
        this.aEV.aj(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aEV.put(str, bitmap);
        }
    }

    public Bitmap gd(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aEV.get(str);
    }

    public void ge(String str) {
        this.aEV.remove(str);
    }

    public void Ec() {
        this.aEV.clear();
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aET != null) {
            this.aET.put(str, aVar);
        }
    }

    public boolean fi(int i) {
        return this.aEU.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aEU != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aEU.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void gf(String str) {
        this.aET.remove(str);
    }

    public void gg(String str) {
        this.aEU.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a gh(String str) {
        return this.aET.get(str);
    }

    public com.baidu.adp.widget.ImageView.a gi(String str) {
        return this.aEU.get(str);
    }

    public void Ed() {
        this.aET.clear();
        this.aEU.clear();
    }

    public String toString() {
        return "pic:" + this.aEU.toString() + "  photo:" + this.aET.toString();
    }

    public String ei() {
        return this.aEU.size() + "/" + this.aEU.getMaxSize() + "/" + this.aEU.evictionCount() + "_" + this.aET.size() + "/" + this.aET.getMaxSize() + "/" + this.aET.evictionCount();
    }
}
