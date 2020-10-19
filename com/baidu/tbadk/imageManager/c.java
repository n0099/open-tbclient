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
    private static c fdA = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fdB;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fdC;
    private com.baidu.adp.lib.d.a<String, Bitmap> fdD;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fdE;
    private com.baidu.tbadk.widget.largeImage.b.b fdF;

    public static c bwL() {
        return fdA;
    }

    private c() {
        this.fdB = null;
        this.fdC = null;
        this.fdD = null;
        this.fdB = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.fdC = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.fdD = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> re(int i) {
        if (this.fdE != null && this.fdF != null) {
            if (this.fdF.getBlockSize() == i) {
                return this.fdE;
            }
            this.fdF.setBlockSize(i);
            this.fdE.clear();
        }
        if (this.fdF == null) {
            this.fdF = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.fdE == null) {
            this.fdE = new com.baidu.adp.lib.d.b<>(this.fdF, 6, 0);
        }
        return this.fdE;
    }

    public void releaseBlockBitmapPool() {
        if (this.fdE != null) {
            this.fdE.setMinIdle(0);
            this.fdE.setMaxIdle(0);
            this.fdE.clear();
            this.fdE = null;
        }
    }

    public int getPicCacheSize() {
        return this.fdC.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.fdB.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.fdC.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.fdD.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.fdD.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.fdD.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fdB != null) {
            this.fdB.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.fdC.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fdC != null) {
            if (BdLog.isDebugMode()) {
            }
            this.fdC.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.fdB.remove(str);
    }

    public void deletePic(String str) {
        this.fdC.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a Dt(String str) {
        return this.fdB.get(str);
    }

    public com.baidu.adp.widget.ImageView.a Du(String str) {
        return this.fdC.get(str);
    }

    public String toString() {
        return "pic:" + this.fdC.toString() + "  photo:" + this.fdB.toString();
    }

    public String toLogString() {
        return this.fdC.size() + "/" + this.fdC.getMaxSize() + "/" + this.fdC.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.fdB.size() + "/" + this.fdB.getMaxSize() + "/" + this.fdB.evictionCount();
    }
}
