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
    private static c dwa = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> dwb;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> dwc;
    private com.baidu.adp.lib.d.a<String, Bitmap> dwd;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> dwe;
    private com.baidu.tbadk.widget.largeImage.b.b dwf;

    public static c aMZ() {
        return dwa;
    }

    private c() {
        this.dwb = null;
        this.dwc = null;
        this.dwd = null;
        this.dwb = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.dwc = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.dwd = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> mj(int i) {
        if (this.dwe != null && this.dwf != null) {
            if (this.dwf.getBlockSize() == i) {
                return this.dwe;
            }
            this.dwf.setBlockSize(i);
            this.dwe.clear();
        }
        if (this.dwf == null) {
            this.dwf = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.dwe == null) {
            this.dwe = new com.baidu.adp.lib.d.b<>(this.dwf, 6, 0);
        }
        return this.dwe;
    }

    public void releaseBlockBitmapPool() {
        if (this.dwe != null) {
            this.dwe.setMinIdle(0);
            this.dwe.setMaxIdle(0);
            this.dwe.clear();
            this.dwe = null;
        }
    }

    public int getPicCacheSize() {
        return this.dwc.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.dwb.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.dwc.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.dwd.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.dwd.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.dwd.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.dwb != null) {
            this.dwb.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.dwc.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.dwc != null) {
            if (BdLog.isDebugMode()) {
            }
            this.dwc.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.dwb.remove(str);
    }

    public void deletePic(String str) {
        this.dwc.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a va(String str) {
        return this.dwb.get(str);
    }

    public com.baidu.adp.widget.ImageView.a vb(String str) {
        return this.dwc.get(str);
    }

    public String toString() {
        return "pic:" + this.dwc.toString() + "  photo:" + this.dwb.toString();
    }

    public String toLogString() {
        return this.dwc.size() + "/" + this.dwc.getMaxSize() + "/" + this.dwc.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.dwb.size() + "/" + this.dwb.getMaxSize() + "/" + this.dwb.evictionCount();
    }
}
