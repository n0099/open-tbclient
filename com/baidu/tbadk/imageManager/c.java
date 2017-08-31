package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c aFC = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aFD;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aFE;
    private com.baidu.adp.lib.e.a<String, Bitmap> aFF;

    public static c Ev() {
        return aFC;
    }

    private c() {
        this.aFD = null;
        this.aFE = null;
        this.aFF = null;
        this.aFD = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.a.a aVar, com.baidu.adp.widget.a.a aVar2) {
                if (aVar != null) {
                    aVar.kN();
                }
            }
        };
        this.aFE = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: d */
            public int sizeOf(String str, com.baidu.adp.widget.a.a aVar) {
                if (aVar != null) {
                    return aVar.size();
                }
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.a.a aVar, com.baidu.adp.widget.a.a aVar2) {
                if (aVar != null) {
                    if (BdLog.isDebugMode()) {
                    }
                    aVar.kN();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE, str));
                }
            }
        };
        this.aFF = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public int Ew() {
        return this.aFE.getMaxSize();
    }

    public void I(int i, int i2) {
        eU(i);
        eV(i2);
        eW(30);
    }

    public void eU(int i) {
        this.aFD.aj(i);
    }

    public void eV(int i) {
        this.aFE.aj(i);
    }

    public void eW(int i) {
        this.aFF.aj(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aFF.put(str, bitmap);
        }
    }

    public Bitmap gj(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aFF.get(str);
    }

    public void gk(String str) {
        this.aFF.remove(str);
    }

    public void Ex() {
        this.aFF.clear();
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aFD != null) {
            this.aFD.put(str, aVar);
        }
    }

    public boolean eX(int i) {
        return this.aFE.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aFE != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aFE.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gl(String str) {
        this.aFD.remove(str);
    }

    public void gm(String str) {
        this.aFE.remove(str);
    }

    public com.baidu.adp.widget.a.a gn(String str) {
        return this.aFD.get(str);
    }

    public com.baidu.adp.widget.a.a go(String str) {
        return this.aFE.get(str);
    }

    public void Ey() {
        this.aFD.clear();
        this.aFE.clear();
    }

    public String toString() {
        return "pic:" + this.aFE.toString() + "  photo:" + this.aFD.toString();
    }

    public String ej() {
        return this.aFE.size() + "/" + this.aFE.getMaxSize() + "/" + this.aFE.evictionCount() + "_" + this.aFD.size() + "/" + this.aFD.getMaxSize() + "/" + this.aFD.evictionCount();
    }
}
