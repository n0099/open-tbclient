package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes.dex */
public class c {
    private static c dAC = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> dAD;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> dAE;
    private com.baidu.adp.lib.d.a<String, Bitmap> dAF;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> dAG;
    private com.baidu.tbadk.widget.largeImage.b.b dAH;

    public static c aPR() {
        return dAC;
    }

    private c() {
        this.dAD = null;
        this.dAE = null;
        this.dAF = null;
        this.dAD = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.recycle();
                }
            }
        };
        this.dAE = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: d */
            public int sizeOf(String str, com.baidu.adp.widget.ImageView.a aVar) {
                if (aVar != null) {
                    return aVar.size();
                }
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    if (BdLog.isDebugMode()) {
                    }
                    aVar.recycle();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE, str));
                }
            }
        };
        this.dAF = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            public void entryRemoved(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
        };
    }

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> mB(int i) {
        if (this.dAG != null && this.dAH != null) {
            if (this.dAH.getBlockSize() == i) {
                return this.dAG;
            }
            this.dAH.setBlockSize(i);
            this.dAG.clear();
        }
        if (this.dAH == null) {
            this.dAH = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.dAG == null) {
            this.dAG = new com.baidu.adp.lib.d.b<>(this.dAH, 6, 0);
        }
        return this.dAG;
    }

    public void releaseBlockBitmapPool() {
        if (this.dAG != null) {
            this.dAG.setMinIdle(0);
            this.dAG.setMaxIdle(0);
            this.dAG.clear();
            this.dAG = null;
        }
    }

    public int getPicCacheSize() {
        return this.dAE.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.dAD.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.dAE.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.dAF.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.dAF.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.dAF.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.dAD != null) {
            this.dAD.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.dAE.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.dAE != null) {
            if (BdLog.isDebugMode()) {
            }
            this.dAE.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.dAD.remove(str);
    }

    public void deletePic(String str) {
        this.dAE.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a vx(String str) {
        return this.dAD.get(str);
    }

    public com.baidu.adp.widget.ImageView.a vy(String str) {
        return this.dAE.get(str);
    }

    public String toString() {
        return "pic:" + this.dAE.toString() + "  photo:" + this.dAD.toString();
    }

    public String toLogString() {
        return this.dAE.size() + "/" + this.dAE.getMaxSize() + "/" + this.dAE.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.dAD.size() + "/" + this.dAD.getMaxSize() + "/" + this.dAD.evictionCount();
    }
}
