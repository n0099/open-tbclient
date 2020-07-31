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
    private static c eDW = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eDX;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eDY;
    private com.baidu.adp.lib.d.a<String, Bitmap> eDZ;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eEa;
    private com.baidu.tbadk.widget.largeImage.b.b eEb;

    public static c bkk() {
        return eDW;
    }

    private c() {
        this.eDX = null;
        this.eDY = null;
        this.eDZ = null;
        this.eDX = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.eDY = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.eDZ = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> oe(int i) {
        if (this.eEa != null && this.eEb != null) {
            if (this.eEb.getBlockSize() == i) {
                return this.eEa;
            }
            this.eEb.setBlockSize(i);
            this.eEa.clear();
        }
        if (this.eEb == null) {
            this.eEb = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.eEa == null) {
            this.eEa = new com.baidu.adp.lib.d.b<>(this.eEb, 6, 0);
        }
        return this.eEa;
    }

    public void releaseBlockBitmapPool() {
        if (this.eEa != null) {
            this.eEa.setMinIdle(0);
            this.eEa.setMaxIdle(0);
            this.eEa.clear();
            this.eEa = null;
        }
    }

    public int getPicCacheSize() {
        return this.eDY.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.eDX.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.eDY.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.eDZ.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.eDZ.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.eDZ.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eDX != null) {
            this.eDX.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.eDY.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eDY != null) {
            if (BdLog.isDebugMode()) {
            }
            this.eDY.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.eDX.remove(str);
    }

    public void deletePic(String str) {
        this.eDY.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a zU(String str) {
        return this.eDX.get(str);
    }

    public com.baidu.adp.widget.ImageView.a zV(String str) {
        return this.eDY.get(str);
    }

    public String toString() {
        return "pic:" + this.eDY.toString() + "  photo:" + this.eDX.toString();
    }

    public String toLogString() {
        return this.eDY.size() + "/" + this.eDY.getMaxSize() + "/" + this.eDY.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.eDX.size() + "/" + this.eDX.getMaxSize() + "/" + this.eDX.evictionCount();
    }
}
