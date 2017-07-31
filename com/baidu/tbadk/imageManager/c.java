package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c aGi = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aGj;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aGk;
    private com.baidu.adp.lib.e.a<String, Bitmap> aGl;

    public static c Ex() {
        return aGi;
    }

    private c() {
        this.aGj = null;
        this.aGk = null;
        this.aGl = null;
        this.aGj = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.aGk = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.aGl = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        return this.aGk.getMaxSize();
    }

    public void L(int i, int i2) {
        eU(i);
        eV(i2);
        eW(30);
    }

    public void eU(int i) {
        this.aGj.am(i);
    }

    public void eV(int i) {
        this.aGk.am(i);
    }

    public void eW(int i) {
        this.aGl.am(i);
    }

    public void d(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aGl.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aGl.get(str);
    }

    public void gl(String str) {
        this.aGl.remove(str);
    }

    public void Ez() {
        this.aGl.clear();
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aGj != null) {
            this.aGj.put(str, aVar);
        }
    }

    public boolean eX(int i) {
        return this.aGk.al(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aGk != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aGk.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gm(String str) {
        this.aGj.remove(str);
    }

    public void gn(String str) {
        this.aGk.remove(str);
    }

    public com.baidu.adp.widget.a.a go(String str) {
        return this.aGj.get(str);
    }

    public com.baidu.adp.widget.a.a gp(String str) {
        return this.aGk.get(str);
    }

    public void EA() {
        this.aGj.clear();
        this.aGk.clear();
    }

    public String toString() {
        return "pic:" + this.aGk.toString() + "  photo:" + this.aGj.toString();
    }

    public String eu() {
        return this.aGk.size() + "/" + this.aGk.getMaxSize() + "/" + this.aGk.evictionCount() + "_" + this.aGj.size() + "/" + this.aGj.getMaxSize() + "/" + this.aGj.evictionCount();
    }
}
