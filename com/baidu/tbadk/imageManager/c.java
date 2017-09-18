package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c aFz = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aFA;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aFB;
    private com.baidu.adp.lib.e.a<String, Bitmap> aFC;

    public static c Ev() {
        return aFz;
    }

    private c() {
        this.aFA = null;
        this.aFB = null;
        this.aFC = null;
        this.aFA = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.aFB = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.aFC = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        return this.aFB.getMaxSize();
    }

    public void I(int i, int i2) {
        eU(i);
        eV(i2);
        eW(30);
    }

    public void eU(int i) {
        this.aFA.aj(i);
    }

    public void eV(int i) {
        this.aFB.aj(i);
    }

    public void eW(int i) {
        this.aFC.aj(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aFC.put(str, bitmap);
        }
    }

    public Bitmap gj(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aFC.get(str);
    }

    public void gk(String str) {
        this.aFC.remove(str);
    }

    public void Ex() {
        this.aFC.clear();
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aFA != null) {
            this.aFA.put(str, aVar);
        }
    }

    public boolean eX(int i) {
        return this.aFB.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aFB != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aFB.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gl(String str) {
        this.aFA.remove(str);
    }

    public void gm(String str) {
        this.aFB.remove(str);
    }

    public com.baidu.adp.widget.a.a gn(String str) {
        return this.aFA.get(str);
    }

    public com.baidu.adp.widget.a.a go(String str) {
        return this.aFB.get(str);
    }

    public void Ey() {
        this.aFA.clear();
        this.aFB.clear();
    }

    public String toString() {
        return "pic:" + this.aFB.toString() + "  photo:" + this.aFA.toString();
    }

    public String ej() {
        return this.aFB.size() + "/" + this.aFB.getMaxSize() + "/" + this.aFB.evictionCount() + "_" + this.aFA.size() + "/" + this.aFA.getMaxSize() + "/" + this.aFA.evictionCount();
    }
}
