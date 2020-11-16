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
    private static c fqY = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fqZ;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fra;
    private com.baidu.adp.lib.d.a<String, Bitmap> frb;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> frd;
    private com.baidu.tbadk.widget.largeImage.b.b fre;

    public static c bAt() {
        return fqY;
    }

    private c() {
        this.fqZ = null;
        this.fra = null;
        this.frb = null;
        this.fqZ = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.fra = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.frb = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> rX(int i) {
        if (this.frd != null && this.fre != null) {
            if (this.fre.getBlockSize() == i) {
                return this.frd;
            }
            this.fre.setBlockSize(i);
            this.frd.clear();
        }
        if (this.fre == null) {
            this.fre = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.frd == null) {
            this.frd = new com.baidu.adp.lib.d.b<>(this.fre, 6, 0);
        }
        return this.frd;
    }

    public void releaseBlockBitmapPool() {
        if (this.frd != null) {
            this.frd.setMinIdle(0);
            this.frd.setMaxIdle(0);
            this.frd.clear();
            this.frd = null;
        }
    }

    public int getPicCacheSize() {
        return this.fra.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.fqZ.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.fra.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.frb.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.frb.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.frb.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fqZ != null) {
            this.fqZ.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.fra.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fra != null) {
            if (BdLog.isDebugMode()) {
            }
            this.fra.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.fqZ.remove(str);
    }

    public void deletePic(String str) {
        this.fra.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a Dz(String str) {
        return this.fqZ.get(str);
    }

    public com.baidu.adp.widget.ImageView.a DA(String str) {
        return this.fra.get(str);
    }

    public String toString() {
        return "pic:" + this.fra.toString() + "  photo:" + this.fqZ.toString();
    }

    public String toLogString() {
        return this.fra.size() + "/" + this.fra.getMaxSize() + "/" + this.fra.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.fqZ.size() + "/" + this.fqZ.getMaxSize() + "/" + this.fqZ.evictionCount();
    }
}
