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
    private static c eaD = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eaE;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eaF;
    private com.baidu.adp.lib.d.a<String, Bitmap> eaG;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eaH;
    private com.baidu.tbadk.widget.largeImage.b.b eaI;

    public static c aYk() {
        return eaD;
    }

    private c() {
        this.eaE = null;
        this.eaF = null;
        this.eaG = null;
        this.eaE = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.eaF = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.eaG = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.eaH != null && this.eaI != null) {
            if (this.eaI.getBlockSize() == i) {
                return this.eaH;
            }
            this.eaI.setBlockSize(i);
            this.eaH.clear();
        }
        if (this.eaI == null) {
            this.eaI = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.eaH == null) {
            this.eaH = new com.baidu.adp.lib.d.b<>(this.eaI, 6, 0);
        }
        return this.eaH;
    }

    public void releaseBlockBitmapPool() {
        if (this.eaH != null) {
            this.eaH.setMinIdle(0);
            this.eaH.setMaxIdle(0);
            this.eaH.clear();
            this.eaH = null;
        }
    }

    public int getPicCacheSize() {
        return this.eaF.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.eaE.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.eaF.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.eaG.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.eaG.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.eaG.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eaE != null) {
            this.eaE.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.eaF.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eaF != null) {
            if (BdLog.isDebugMode()) {
            }
            this.eaF.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.eaE.remove(str);
    }

    public void deletePic(String str) {
        this.eaF.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a wO(String str) {
        return this.eaE.get(str);
    }

    public com.baidu.adp.widget.ImageView.a wP(String str) {
        return this.eaF.get(str);
    }

    public String toString() {
        return "pic:" + this.eaF.toString() + "  photo:" + this.eaE.toString();
    }

    public String toLogString() {
        return this.eaF.size() + "/" + this.eaF.getMaxSize() + "/" + this.eaF.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.eaE.size() + "/" + this.eaE.getMaxSize() + "/" + this.eaE.evictionCount();
    }
}
