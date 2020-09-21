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
    private static c eRs = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eRt;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eRu;
    private com.baidu.adp.lib.d.a<String, Bitmap> eRv;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eRw;
    private com.baidu.tbadk.widget.largeImage.b.b eRx;

    public static c bub() {
        return eRs;
    }

    private c() {
        this.eRt = null;
        this.eRu = null;
        this.eRv = null;
        this.eRt = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.eRu = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.eRv = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> qG(int i) {
        if (this.eRw != null && this.eRx != null) {
            if (this.eRx.getBlockSize() == i) {
                return this.eRw;
            }
            this.eRx.setBlockSize(i);
            this.eRw.clear();
        }
        if (this.eRx == null) {
            this.eRx = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.eRw == null) {
            this.eRw = new com.baidu.adp.lib.d.b<>(this.eRx, 6, 0);
        }
        return this.eRw;
    }

    public void releaseBlockBitmapPool() {
        if (this.eRw != null) {
            this.eRw.setMinIdle(0);
            this.eRw.setMaxIdle(0);
            this.eRw.clear();
            this.eRw = null;
        }
    }

    public int getPicCacheSize() {
        return this.eRu.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.eRt.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.eRu.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.eRv.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.eRv.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.eRv.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eRt != null) {
            this.eRt.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.eRu.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eRu != null) {
            if (BdLog.isDebugMode()) {
            }
            this.eRu.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.eRt.remove(str);
    }

    public void deletePic(String str) {
        this.eRu.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a CH(String str) {
        return this.eRt.get(str);
    }

    public com.baidu.adp.widget.ImageView.a CI(String str) {
        return this.eRu.get(str);
    }

    public String toString() {
        return "pic:" + this.eRu.toString() + "  photo:" + this.eRt.toString();
    }

    public String toLogString() {
        return this.eRu.size() + "/" + this.eRu.getMaxSize() + "/" + this.eRu.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.eRt.size() + "/" + this.eRt.getMaxSize() + "/" + this.eRt.evictionCount();
    }
}
