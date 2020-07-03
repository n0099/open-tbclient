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
    private static c exE = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> exF;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> exG;
    private com.baidu.adp.lib.d.a<String, Bitmap> exH;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> exI;
    private com.baidu.tbadk.widget.largeImage.b.b exJ;

    public static c bgz() {
        return exE;
    }

    private c() {
        this.exF = null;
        this.exG = null;
        this.exH = null;
        this.exF = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.exG = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.exH = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> nM(int i) {
        if (this.exI != null && this.exJ != null) {
            if (this.exJ.getBlockSize() == i) {
                return this.exI;
            }
            this.exJ.setBlockSize(i);
            this.exI.clear();
        }
        if (this.exJ == null) {
            this.exJ = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.exI == null) {
            this.exI = new com.baidu.adp.lib.d.b<>(this.exJ, 6, 0);
        }
        return this.exI;
    }

    public void releaseBlockBitmapPool() {
        if (this.exI != null) {
            this.exI.setMinIdle(0);
            this.exI.setMaxIdle(0);
            this.exI.clear();
            this.exI = null;
        }
    }

    public int getPicCacheSize() {
        return this.exG.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.exF.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.exG.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.exH.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.exH.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.exH.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.exF != null) {
            this.exF.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.exG.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.exG != null) {
            if (BdLog.isDebugMode()) {
            }
            this.exG.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.exF.remove(str);
    }

    public void deletePic(String str) {
        this.exG.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a yN(String str) {
        return this.exF.get(str);
    }

    public com.baidu.adp.widget.ImageView.a yO(String str) {
        return this.exG.get(str);
    }

    public String toString() {
        return "pic:" + this.exG.toString() + "  photo:" + this.exF.toString();
    }

    public String toLogString() {
        return this.exG.size() + "/" + this.exG.getMaxSize() + "/" + this.exG.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.exF.size() + "/" + this.exF.getMaxSize() + "/" + this.exF.evictionCount();
    }
}
