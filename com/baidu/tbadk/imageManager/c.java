package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c aGk = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aGl;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aGm;
    private com.baidu.adp.lib.e.a<String, Bitmap> aGn;

    public static c Ex() {
        return aGk;
    }

    private c() {
        this.aGl = null;
        this.aGm = null;
        this.aGn = null;
        this.aGl = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.a.a aVar, com.baidu.adp.widget.a.a aVar2) {
                if (aVar != null) {
                    aVar.kV();
                }
            }
        };
        this.aGm = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.kV();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE, str));
                }
            }
        };
        this.aGn = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public int Ey() {
        return this.aGm.getMaxSize();
    }

    public void L(int i, int i2) {
        eU(i);
        eV(i2);
        eW(30);
    }

    public void eU(int i) {
        this.aGl.am(i);
    }

    public void eV(int i) {
        this.aGm.am(i);
    }

    public void eW(int i) {
        this.aGn.am(i);
    }

    public void d(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aGn.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aGn.get(str);
    }

    public void gp(String str) {
        this.aGn.remove(str);
    }

    public void Ez() {
        this.aGn.clear();
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aGl != null) {
            this.aGl.put(str, aVar);
        }
    }

    public boolean eX(int i) {
        return this.aGm.al(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aGm != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aGm.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gq(String str) {
        this.aGl.remove(str);
    }

    public void gr(String str) {
        this.aGm.remove(str);
    }

    public com.baidu.adp.widget.a.a gs(String str) {
        return this.aGl.get(str);
    }

    public com.baidu.adp.widget.a.a gt(String str) {
        return this.aGm.get(str);
    }

    public void EA() {
        this.aGl.clear();
        this.aGm.clear();
    }

    public String toString() {
        return "pic:" + this.aGm.toString() + "  photo:" + this.aGl.toString();
    }

    public String eu() {
        return this.aGm.size() + "/" + this.aGm.getMaxSize() + "/" + this.aGm.evictionCount() + "_" + this.aGl.size() + "/" + this.aGl.getMaxSize() + "/" + this.aGl.evictionCount();
    }
}
