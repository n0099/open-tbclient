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
    private static c dAP = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> dAQ;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> dAR;
    private com.baidu.adp.lib.d.a<String, Bitmap> dAS;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> dAT;
    private com.baidu.tbadk.widget.largeImage.b.b dAU;

    public static c aPV() {
        return dAP;
    }

    private c() {
        this.dAQ = null;
        this.dAR = null;
        this.dAS = null;
        this.dAQ = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.dAR = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.dAS = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> mD(int i) {
        if (this.dAT != null && this.dAU != null) {
            if (this.dAU.getBlockSize() == i) {
                return this.dAT;
            }
            this.dAU.setBlockSize(i);
            this.dAT.clear();
        }
        if (this.dAU == null) {
            this.dAU = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.dAT == null) {
            this.dAT = new com.baidu.adp.lib.d.b<>(this.dAU, 6, 0);
        }
        return this.dAT;
    }

    public void releaseBlockBitmapPool() {
        if (this.dAT != null) {
            this.dAT.setMinIdle(0);
            this.dAT.setMaxIdle(0);
            this.dAT.clear();
            this.dAT = null;
        }
    }

    public int getPicCacheSize() {
        return this.dAR.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.dAQ.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.dAR.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.dAS.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.dAS.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.dAS.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.dAQ != null) {
            this.dAQ.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.dAR.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.dAR != null) {
            if (BdLog.isDebugMode()) {
            }
            this.dAR.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.dAQ.remove(str);
    }

    public void deletePic(String str) {
        this.dAR.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a vw(String str) {
        return this.dAQ.get(str);
    }

    public com.baidu.adp.widget.ImageView.a vx(String str) {
        return this.dAR.get(str);
    }

    public String toString() {
        return "pic:" + this.dAR.toString() + "  photo:" + this.dAQ.toString();
    }

    public String toLogString() {
        return this.dAR.size() + "/" + this.dAR.getMaxSize() + "/" + this.dAR.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.dAQ.size() + "/" + this.dAQ.getMaxSize() + "/" + this.dAQ.evictionCount();
    }
}
