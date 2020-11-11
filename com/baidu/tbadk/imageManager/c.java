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
    private static c frS = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> frT;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> frU;
    private com.baidu.adp.lib.d.a<String, Bitmap> frV;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> frW;
    private com.baidu.tbadk.widget.largeImage.b.b frX;

    public static c bBd() {
        return frS;
    }

    private c() {
        this.frT = null;
        this.frU = null;
        this.frV = null;
        this.frT = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.frU = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.frV = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> rz(int i) {
        if (this.frW != null && this.frX != null) {
            if (this.frX.getBlockSize() == i) {
                return this.frW;
            }
            this.frX.setBlockSize(i);
            this.frW.clear();
        }
        if (this.frX == null) {
            this.frX = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.frW == null) {
            this.frW = new com.baidu.adp.lib.d.b<>(this.frX, 6, 0);
        }
        return this.frW;
    }

    public void releaseBlockBitmapPool() {
        if (this.frW != null) {
            this.frW.setMinIdle(0);
            this.frW.setMaxIdle(0);
            this.frW.clear();
            this.frW = null;
        }
    }

    public int getPicCacheSize() {
        return this.frU.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.frT.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.frU.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.frV.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.frV.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.frV.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.frT != null) {
            this.frT.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.frU.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.frU != null) {
            if (BdLog.isDebugMode()) {
            }
            this.frU.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.frT.remove(str);
    }

    public void deletePic(String str) {
        this.frU.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a Ea(String str) {
        return this.frT.get(str);
    }

    public com.baidu.adp.widget.ImageView.a Eb(String str) {
        return this.frU.get(str);
    }

    public String toString() {
        return "pic:" + this.frU.toString() + "  photo:" + this.frT.toString();
    }

    public String toLogString() {
        return this.frU.size() + "/" + this.frU.getMaxSize() + "/" + this.frU.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.frT.size() + "/" + this.frT.getMaxSize() + "/" + this.frT.evictionCount();
    }
}
