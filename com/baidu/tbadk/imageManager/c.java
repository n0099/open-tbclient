package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c aGj = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aGk;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aGl;
    private com.baidu.adp.lib.e.a<String, Bitmap> aGm;

    public static c Ex() {
        return aGj;
    }

    private c() {
        this.aGk = null;
        this.aGl = null;
        this.aGm = null;
        this.aGk = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.a.a aVar, com.baidu.adp.widget.a.a aVar2) {
                if (aVar != null) {
                    aVar.kW();
                }
            }
        };
        this.aGl = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
                    aVar.kW();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE, str));
                }
            }
        };
        this.aGm = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        return this.aGl.getMaxSize();
    }

    public void L(int i, int i2) {
        eU(i);
        eV(i2);
        eW(30);
    }

    public void eU(int i) {
        this.aGk.am(i);
    }

    public void eV(int i) {
        this.aGl.am(i);
    }

    public void eW(int i) {
        this.aGm.am(i);
    }

    public void d(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aGm.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aGm.get(str);
    }

    public void gl(String str) {
        this.aGm.remove(str);
    }

    public void Ez() {
        this.aGm.clear();
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aGk != null) {
            this.aGk.put(str, aVar);
        }
    }

    public boolean eX(int i) {
        return this.aGl.al(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aGl != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aGl.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gm(String str) {
        this.aGk.remove(str);
    }

    public void gn(String str) {
        this.aGl.remove(str);
    }

    public com.baidu.adp.widget.a.a go(String str) {
        return this.aGk.get(str);
    }

    public com.baidu.adp.widget.a.a gp(String str) {
        return this.aGl.get(str);
    }

    public void EA() {
        this.aGk.clear();
        this.aGl.clear();
    }

    public String toString() {
        return "pic:" + this.aGl.toString() + "  photo:" + this.aGk.toString();
    }

    public String eu() {
        return this.aGl.size() + "/" + this.aGl.getMaxSize() + "/" + this.aGl.evictionCount() + "_" + this.aGk.size() + "/" + this.aGk.getMaxSize() + "/" + this.aGk.evictionCount();
    }
}
