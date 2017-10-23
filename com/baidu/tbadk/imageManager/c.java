package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    private static c aEF = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aEG;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> aEH;
    private com.baidu.adp.lib.e.a<String, Bitmap> aEI;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.a.a.a> aEJ;
    private com.baidu.tbadk.widget.a.c.b aEK;

    public static c DT() {
        return aEF;
    }

    private c() {
        this.aEG = null;
        this.aEH = null;
        this.aEI = null;
        this.aEG = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.kM();
                }
            }
        };
        this.aEH = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: d */
            public int sizeOf(String str, com.baidu.adp.widget.ImageView.a aVar) {
                if (aVar != null) {
                    return aVar.size();
                }
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    if (BdLog.isDebugMode()) {
                    }
                    aVar.kM();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE, str));
                }
            }
        };
        this.aEI = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.aEJ != null && this.aEK != null) {
            if (this.aEK.getBlockSize() == i) {
                return this.aEJ;
            }
            this.aEK.fE(i);
            this.aEJ.clear();
        }
        if (this.aEK == null) {
            this.aEK = new com.baidu.tbadk.widget.a.c.b(i);
        }
        if (this.aEJ == null) {
            this.aEJ = new com.baidu.adp.lib.e.b<>(this.aEK, 6, 0);
        }
        return this.aEJ;
    }

    public void DU() {
        if (this.aEJ != null) {
            this.aEJ.an(0);
            this.aEJ.am(0);
            this.aEJ.clear();
            this.aEJ = null;
        }
    }

    public int DV() {
        return this.aEH.getMaxSize();
    }

    public void J(int i, int i2) {
        fe(i);
        ff(i2);
        fg(30);
    }

    public void fe(int i) {
        this.aEG.aj(i);
    }

    public void ff(int i) {
        this.aEH.aj(i);
    }

    public void fg(int i) {
        this.aEI.aj(i);
    }

    public void b(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.aEI.put(str, bitmap);
        }
    }

    public Bitmap gc(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.aEI.get(str);
    }

    public void gd(String str) {
        this.aEI.remove(str);
    }

    public void DW() {
        this.aEI.clear();
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aEG != null) {
            this.aEG.put(str, aVar);
        }
    }

    public boolean fh(int i) {
        return this.aEH.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.aEH != null) {
            if (BdLog.isDebugMode()) {
            }
            this.aEH.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void ge(String str) {
        this.aEG.remove(str);
    }

    public void gf(String str) {
        this.aEH.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a gg(String str) {
        return this.aEG.get(str);
    }

    public com.baidu.adp.widget.ImageView.a gh(String str) {
        return this.aEH.get(str);
    }

    public void DX() {
        this.aEG.clear();
        this.aEH.clear();
    }

    public String toString() {
        return "pic:" + this.aEH.toString() + "  photo:" + this.aEG.toString();
    }

    public String ei() {
        return this.aEH.size() + "/" + this.aEH.getMaxSize() + "/" + this.aEH.evictionCount() + "_" + this.aEG.size() + "/" + this.aEG.getMaxSize() + "/" + this.aEG.evictionCount();
    }
}
