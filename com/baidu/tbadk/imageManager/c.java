package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c aFx = new c();
    private com.baidu.adp.lib.e.a<String, Bitmap> aFA;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aFB;
    private com.baidu.tbadk.widget.a.c.b aFC;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aFy;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aFz;

    public static c Es() {
        return aFx;
    }

    private c() {
        this.aFy = null;
        this.aFz = null;
        this.aFA = null;
        this.aFy = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.aFz = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.aFA = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> fd(int i) {
        if (this.aFB != null && this.aFC != null) {
            if (this.aFC.getBlockSize() == i) {
                return this.aFB;
            }
            this.aFC.fE(i);
            this.aFB.clear();
        }
        if (this.aFC == null) {
            this.aFC = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.aFB == null) {
            this.aFB = new com.baidu.adp.lib.e.b<>(this.aFC, 6, 0);
        }
        return this.aFB;
    }

    public void Et() {
        if (this.aFB != null) {
            this.aFB.an(0);
            this.aFB.am(0);
            this.aFB.clear();
            this.aFB = null;
        }
    }

    public int Eu() {
        return this.aFz.getMaxSize();
    }

    public void J(int i, int i2) {
        fe(i);
        ff(i2);
        fg(30);
    }

    public void fe(int i) {
        this.aFy.aj(i);
    }

    public void ff(int i) {
        this.aFz.aj(i);
    }

    public void fg(int i) {
        this.aFA.aj(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aFA.put(str, bitmap);
        }
    }

    public Bitmap gk(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aFA.get(str);
    }

    public void gl(String str) {
        this.aFA.remove(str);
    }

    public void Ev() {
        this.aFA.clear();
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aFy != null) {
            this.aFy.put(str, aVar);
        }
    }

    public boolean fh(int i) {
        return this.aFz.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aFz != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aFz.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gm(String str) {
        this.aFy.remove(str);
    }

    public void gn(String str) {
        this.aFz.remove(str);
    }

    public com.baidu.adp.widget.a.a go(String str) {
        return this.aFy.get(str);
    }

    public com.baidu.adp.widget.a.a gp(String str) {
        return this.aFz.get(str);
    }

    public void Ew() {
        this.aFy.clear();
        this.aFz.clear();
    }

    public String toString() {
        return "pic:" + this.aFz.toString() + "  photo:" + this.aFy.toString();
    }

    public String ei() {
        return this.aFz.size() + "/" + this.aFz.getMaxSize() + "/" + this.aFz.evictionCount() + "_" + this.aFy.size() + "/" + this.aFy.getMaxSize() + "/" + this.aFy.evictionCount();
    }
}
