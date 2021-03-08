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
    private static c fHx = new c();
    private com.baidu.adp.lib.d.a<String, Bitmap> fHA;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fHB;
    private com.baidu.tbadk.widget.largeImage.b.b fHC;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fHy;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fHz;

    public static c bCS() {
        return fHx;
    }

    private c() {
        this.fHy = null;
        this.fHz = null;
        this.fHA = null;
        this.fHy = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.fHz = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.d.a
            /* renamed from: c */
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
        this.fHA = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> rk(int i) {
        if (this.fHB != null && this.fHC != null) {
            if (this.fHC.getBlockSize() == i) {
                return this.fHB;
            }
            this.fHC.setBlockSize(i);
            this.fHB.clear();
        }
        if (this.fHC == null) {
            this.fHC = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.fHB == null) {
            this.fHB = new com.baidu.adp.lib.d.b<>(this.fHC, 6, 0);
        }
        return this.fHB;
    }

    public void releaseBlockBitmapPool() {
        if (this.fHB != null) {
            this.fHB.setMinIdle(0);
            this.fHB.setMaxIdle(0);
            this.fHB.clear();
            this.fHB = null;
        }
    }

    public int getPicCacheSize() {
        return this.fHz.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.fHy.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.fHz.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.fHA.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.fHA.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.fHA.get(str);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fHy != null) {
            this.fHy.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.fHz.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fHz != null) {
            if (BdLog.isDebugMode()) {
            }
            this.fHz.put(str, aVar);
        }
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.fHy.remove(str);
    }

    public void deletePic(String str) {
        this.fHz.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a Do(String str) {
        return this.fHy.get(str);
    }

    public com.baidu.adp.widget.ImageView.a Dp(String str) {
        return this.fHz.get(str);
    }

    public String toString() {
        return "pic:" + this.fHz.toString() + "  photo:" + this.fHy.toString();
    }

    public String toLogString() {
        return this.fHz.size() + "/" + this.fHz.getMaxSize() + "/" + this.fHz.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.fHy.size() + "/" + this.fHy.getMaxSize() + "/" + this.fHy.evictionCount();
    }
}
