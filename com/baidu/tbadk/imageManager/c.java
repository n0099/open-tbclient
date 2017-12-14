package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c aGc = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aGd;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aGe;
    private com.baidu.adp.lib.e.a<String, Bitmap> aGf;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aGg;
    private com.baidu.tbadk.widget.a.c.b aGh;

    public static c EA() {
        return aGc;
    }

    private c() {
        this.aGd = null;
        this.aGe = null;
        this.aGf = null;
        this.aGd = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.a.a aVar, com.baidu.adp.widget.a.a aVar2) {
                if (aVar != null) {
                    aVar.kJ();
                }
            }
        };
        this.aGe = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.kJ();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE, str));
                }
            }
        };
        this.aGf = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> fc(int i) {
        if (this.aGg != null && this.aGh != null) {
            if (this.aGh.getBlockSize() == i) {
                return this.aGg;
            }
            this.aGh.fL(i);
            this.aGg.clear();
        }
        if (this.aGh == null) {
            this.aGh = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.aGg == null) {
            this.aGg = new com.baidu.adp.lib.e.b<>(this.aGh, 6, 0);
        }
        return this.aGg;
    }

    public void EB() {
        if (this.aGg != null) {
            this.aGg.am(0);
            this.aGg.al(0);
            this.aGg.clear();
            this.aGg = null;
        }
    }

    public int EC() {
        return this.aGe.getMaxSize();
    }

    public void I(int i, int i2) {
        fd(i);
        fe(i2);
        ff(30);
    }

    public void fd(int i) {
        this.aGd.ai(i);
    }

    public void fe(int i) {
        this.aGe.ai(i);
    }

    public void ff(int i) {
        this.aGf.ai(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aGf.put(str, bitmap);
        }
    }

    public Bitmap gm(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aGf.get(str);
    }

    public void gn(String str) {
        this.aGf.remove(str);
    }

    public void ED() {
        this.aGf.clear();
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aGd != null) {
            this.aGd.put(str, aVar);
        }
    }

    public boolean fg(int i) {
        return this.aGe.ah(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aGe != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aGe.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void go(String str) {
        this.aGd.remove(str);
    }

    public void gp(String str) {
        this.aGe.remove(str);
    }

    public com.baidu.adp.widget.a.a gq(String str) {
        return this.aGd.get(str);
    }

    public com.baidu.adp.widget.a.a gr(String str) {
        return this.aGe.get(str);
    }

    public void EE() {
        this.aGd.clear();
        this.aGe.clear();
    }

    public String toString() {
        return "pic:" + this.aGe.toString() + "  photo:" + this.aGd.toString();
    }

    public String ei() {
        return this.aGe.size() + "/" + this.aGe.getMaxSize() + "/" + this.aGe.evictionCount() + "_" + this.aGd.size() + "/" + this.aGd.getMaxSize() + "/" + this.aGd.evictionCount();
    }
}
