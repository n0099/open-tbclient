package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c aGf = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aGg;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aGh;
    private com.baidu.adp.lib.e.a<String, Bitmap> aGi;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aGj;
    private com.baidu.tbadk.widget.a.c.b aGk;

    public static c EA() {
        return aGf;
    }

    private c() {
        this.aGg = null;
        this.aGh = null;
        this.aGi = null;
        this.aGg = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.aGh = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.aGi = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.aGj != null && this.aGk != null) {
            if (this.aGk.getBlockSize() == i) {
                return this.aGj;
            }
            this.aGk.fL(i);
            this.aGj.clear();
        }
        if (this.aGk == null) {
            this.aGk = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.aGj == null) {
            this.aGj = new com.baidu.adp.lib.e.b<>(this.aGk, 6, 0);
        }
        return this.aGj;
    }

    public void EB() {
        if (this.aGj != null) {
            this.aGj.am(0);
            this.aGj.al(0);
            this.aGj.clear();
            this.aGj = null;
        }
    }

    public int EC() {
        return this.aGh.getMaxSize();
    }

    public void I(int i, int i2) {
        fd(i);
        fe(i2);
        ff(30);
    }

    public void fd(int i) {
        this.aGg.ai(i);
    }

    public void fe(int i) {
        this.aGh.ai(i);
    }

    public void ff(int i) {
        this.aGi.ai(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aGi.put(str, bitmap);
        }
    }

    public Bitmap gm(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aGi.get(str);
    }

    public void gn(String str) {
        this.aGi.remove(str);
    }

    public void ED() {
        this.aGi.clear();
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aGg != null) {
            this.aGg.put(str, aVar);
        }
    }

    public boolean fg(int i) {
        return this.aGh.ah(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aGh != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aGh.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void go(String str) {
        this.aGg.remove(str);
    }

    public void gp(String str) {
        this.aGh.remove(str);
    }

    public com.baidu.adp.widget.a.a gq(String str) {
        return this.aGg.get(str);
    }

    public com.baidu.adp.widget.a.a gr(String str) {
        return this.aGh.get(str);
    }

    public void EE() {
        this.aGg.clear();
        this.aGh.clear();
    }

    public String toString() {
        return "pic:" + this.aGh.toString() + "  photo:" + this.aGg.toString();
    }

    public String ei() {
        return this.aGh.size() + "/" + this.aGh.getMaxSize() + "/" + this.aGh.evictionCount() + "_" + this.aGg.size() + "/" + this.aGg.getMaxSize() + "/" + this.aGg.evictionCount();
    }
}
