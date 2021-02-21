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
    private static c fFY = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fFZ;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fGa;
    private com.baidu.adp.lib.d.a<String, Bitmap> fGb;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fGc;
    private com.baidu.tbadk.widget.largeImage.b.b fGd;

    public static c bCP() {
        return fFY;
    }

    private c() {
        this.fFZ = null;
        this.fGa = null;
        this.fGb = null;
        this.fFZ = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.fGa = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.fGb = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> rj(int i) {
        if (this.fGc != null && this.fGd != null) {
            if (this.fGd.getBlockSize() == i) {
                return this.fGc;
            }
            this.fGd.setBlockSize(i);
            this.fGc.clear();
        }
        if (this.fGd == null) {
            this.fGd = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.fGc == null) {
            this.fGc = new com.baidu.adp.lib.d.b<>(this.fGd, 6, 0);
        }
        return this.fGc;
    }

    public void releaseBlockBitmapPool() {
        if (this.fGc != null) {
            this.fGc.setMinIdle(0);
            this.fGc.setMaxIdle(0);
            this.fGc.clear();
            this.fGc = null;
        }
    }

    public int getPicCacheSize() {
        return this.fGa.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.fFZ.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.fGa.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.fGb.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.fGb.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.fGb.get(str);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fFZ != null) {
            this.fFZ.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.fGa.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fGa != null) {
            if (BdLog.isDebugMode()) {
            }
            this.fGa.put(str, aVar);
        }
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.fFZ.remove(str);
    }

    public void deletePic(String str) {
        this.fGa.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a Dh(String str) {
        return this.fFZ.get(str);
    }

    public com.baidu.adp.widget.ImageView.a Di(String str) {
        return this.fGa.get(str);
    }

    public String toString() {
        return "pic:" + this.fGa.toString() + "  photo:" + this.fFZ.toString();
    }

    public String toLogString() {
        return this.fGa.size() + "/" + this.fGa.getMaxSize() + "/" + this.fGa.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.fFZ.size() + "/" + this.fFZ.getMaxSize() + "/" + this.fFZ.evictionCount();
    }
}
