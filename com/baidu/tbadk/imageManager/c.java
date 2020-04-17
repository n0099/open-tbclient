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
    private static c eay = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eaA;
    private com.baidu.adp.lib.d.a<String, Bitmap> eaB;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eaC;
    private com.baidu.tbadk.widget.largeImage.b.b eaD;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eaz;

    public static c aYm() {
        return eay;
    }

    private c() {
        this.eaz = null;
        this.eaA = null;
        this.eaB = null;
        this.eaz = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.eaA = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.eaB = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> mO(int i) {
        if (this.eaC != null && this.eaD != null) {
            if (this.eaD.getBlockSize() == i) {
                return this.eaC;
            }
            this.eaD.setBlockSize(i);
            this.eaC.clear();
        }
        if (this.eaD == null) {
            this.eaD = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.eaC == null) {
            this.eaC = new com.baidu.adp.lib.d.b<>(this.eaD, 6, 0);
        }
        return this.eaC;
    }

    public void releaseBlockBitmapPool() {
        if (this.eaC != null) {
            this.eaC.setMinIdle(0);
            this.eaC.setMaxIdle(0);
            this.eaC.clear();
            this.eaC = null;
        }
    }

    public int getPicCacheSize() {
        return this.eaA.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.eaz.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.eaA.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.eaB.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.eaB.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.eaB.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eaz != null) {
            this.eaz.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.eaA.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eaA != null) {
            if (BdLog.isDebugMode()) {
            }
            this.eaA.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.eaz.remove(str);
    }

    public void deletePic(String str) {
        this.eaA.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a wL(String str) {
        return this.eaz.get(str);
    }

    public com.baidu.adp.widget.ImageView.a wM(String str) {
        return this.eaA.get(str);
    }

    public String toString() {
        return "pic:" + this.eaA.toString() + "  photo:" + this.eaz.toString();
    }

    public String toLogString() {
        return this.eaA.size() + "/" + this.eaA.getMaxSize() + "/" + this.eaA.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.eaz.size() + "/" + this.eaz.getMaxSize() + "/" + this.eaz.evictionCount();
    }
}
