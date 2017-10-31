package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c aFp = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aFq;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aFr;
    private com.baidu.adp.lib.e.a<String, Bitmap> aFs;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aFt;
    private com.baidu.tbadk.widget.a.c.b aFu;

    public static c Eg() {
        return aFp;
    }

    private c() {
        this.aFq = null;
        this.aFr = null;
        this.aFs = null;
        this.aFq = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.aFr = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.aFs = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.aFt != null && this.aFu != null) {
            if (this.aFu.getBlockSize() == i) {
                return this.aFt;
            }
            this.aFu.fF(i);
            this.aFt.clear();
        }
        if (this.aFu == null) {
            this.aFu = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.aFt == null) {
            this.aFt = new com.baidu.adp.lib.e.b<>(this.aFu, 6, 0);
        }
        return this.aFt;
    }

    public void Eh() {
        if (this.aFt != null) {
            this.aFt.an(0);
            this.aFt.am(0);
            this.aFt.clear();
            this.aFt = null;
        }
    }

    public int Ei() {
        return this.aFr.getMaxSize();
    }

    public void J(int i, int i2) {
        ff(i);
        fg(i2);
        fh(30);
    }

    public void ff(int i) {
        this.aFq.aj(i);
    }

    public void fg(int i) {
        this.aFr.aj(i);
    }

    public void fh(int i) {
        this.aFs.aj(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aFs.put(str, bitmap);
        }
    }

    public Bitmap gj(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aFs.get(str);
    }

    public void gk(String str) {
        this.aFs.remove(str);
    }

    public void Ej() {
        this.aFs.clear();
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aFq != null) {
            this.aFq.put(str, aVar);
        }
    }

    public boolean fi(int i) {
        return this.aFr.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aFr != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aFr.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gl(String str) {
        this.aFq.remove(str);
    }

    public void gm(String str) {
        this.aFr.remove(str);
    }

    public com.baidu.adp.widget.a.a gn(String str) {
        return this.aFq.get(str);
    }

    public com.baidu.adp.widget.a.a go(String str) {
        return this.aFr.get(str);
    }

    public void Ek() {
        this.aFq.clear();
        this.aFr.clear();
    }

    public String toString() {
        return "pic:" + this.aFr.toString() + "  photo:" + this.aFq.toString();
    }

    public String ei() {
        return this.aFr.size() + "/" + this.aFr.getMaxSize() + "/" + this.aFr.evictionCount() + "_" + this.aFq.size() + "/" + this.aFq.getMaxSize() + "/" + this.aFq.evictionCount();
    }
}
