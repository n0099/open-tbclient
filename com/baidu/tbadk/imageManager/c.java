package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c aFY = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aFZ;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aGa;
    private com.baidu.adp.lib.e.a<String, Bitmap> aGb;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aGc;
    private com.baidu.tbadk.widget.a.c.b aGd;

    public static c Ez() {
        return aFY;
    }

    private c() {
        this.aFZ = null;
        this.aGa = null;
        this.aGb = null;
        this.aFZ = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.aGa = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.aGb = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.aGc != null && this.aGd != null) {
            if (this.aGd.getBlockSize() == i) {
                return this.aGc;
            }
            this.aGd.fL(i);
            this.aGc.clear();
        }
        if (this.aGd == null) {
            this.aGd = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.aGc == null) {
            this.aGc = new com.baidu.adp.lib.e.b<>(this.aGd, 6, 0);
        }
        return this.aGc;
    }

    public void EA() {
        if (this.aGc != null) {
            this.aGc.an(0);
            this.aGc.am(0);
            this.aGc.clear();
            this.aGc = null;
        }
    }

    public int EB() {
        return this.aGa.getMaxSize();
    }

    public void H(int i, int i2) {
        fd(i);
        fe(i2);
        ff(30);
    }

    public void fd(int i) {
        this.aFZ.aj(i);
    }

    public void fe(int i) {
        this.aGa.aj(i);
    }

    public void ff(int i) {
        this.aGb.aj(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aGb.put(str, bitmap);
        }
    }

    public Bitmap gn(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aGb.get(str);
    }

    public void go(String str) {
        this.aGb.remove(str);
    }

    public void EC() {
        this.aGb.clear();
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aFZ != null) {
            this.aFZ.put(str, aVar);
        }
    }

    public boolean fg(int i) {
        return this.aGa.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aGa != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aGa.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gp(String str) {
        this.aFZ.remove(str);
    }

    public void gq(String str) {
        this.aGa.remove(str);
    }

    public com.baidu.adp.widget.a.a gr(String str) {
        return this.aFZ.get(str);
    }

    public com.baidu.adp.widget.a.a gt(String str) {
        return this.aGa.get(str);
    }

    public void ED() {
        this.aFZ.clear();
        this.aGa.clear();
    }

    public String toString() {
        return "pic:" + this.aGa.toString() + "  photo:" + this.aFZ.toString();
    }

    public String ei() {
        return this.aGa.size() + "/" + this.aGa.getMaxSize() + "/" + this.aGa.evictionCount() + "_" + this.aFZ.size() + "/" + this.aFZ.getMaxSize() + "/" + this.aFZ.evictionCount();
    }
}
