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
    private static c dAo = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> dAp;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> dAq;
    private com.baidu.adp.lib.d.a<String, Bitmap> dAr;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> dAs;
    private com.baidu.tbadk.widget.largeImage.b.b dAt;

    public static c aPO() {
        return dAo;
    }

    private c() {
        this.dAp = null;
        this.dAq = null;
        this.dAr = null;
        this.dAp = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.dAq = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.dAr = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.dAs != null && this.dAt != null) {
            if (this.dAt.getBlockSize() == i) {
                return this.dAs;
            }
            this.dAt.setBlockSize(i);
            this.dAs.clear();
        }
        if (this.dAt == null) {
            this.dAt = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.dAs == null) {
            this.dAs = new com.baidu.adp.lib.d.b<>(this.dAt, 6, 0);
        }
        return this.dAs;
    }

    public void releaseBlockBitmapPool() {
        if (this.dAs != null) {
            this.dAs.setMinIdle(0);
            this.dAs.setMaxIdle(0);
            this.dAs.clear();
            this.dAs = null;
        }
    }

    public int getPicCacheSize() {
        return this.dAq.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.dAp.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.dAq.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.dAr.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.dAr.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.dAr.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.dAp != null) {
            this.dAp.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.dAq.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.dAq != null) {
            if (BdLog.isDebugMode()) {
            }
            this.dAq.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.dAp.remove(str);
    }

    public void deletePic(String str) {
        this.dAq.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a vw(String str) {
        return this.dAp.get(str);
    }

    public com.baidu.adp.widget.ImageView.a vx(String str) {
        return this.dAq.get(str);
    }

    public String toString() {
        return "pic:" + this.dAq.toString() + "  photo:" + this.dAp.toString();
    }

    public String toLogString() {
        return this.dAq.size() + "/" + this.dAq.getMaxSize() + "/" + this.dAq.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.dAp.size() + "/" + this.dAp.getMaxSize() + "/" + this.dAp.evictionCount();
    }
}
