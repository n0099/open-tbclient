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
    private static c cIr = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cIs;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cIt;
    private com.baidu.adp.lib.e.a<String, Bitmap> cIu;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cIv;
    private com.baidu.tbadk.widget.largeImage.b.b cIw;

    public static c avs() {
        return cIr;
    }

    private c() {
        this.cIs = null;
        this.cIt = null;
        this.cIu = null;
        this.cIs = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, com.baidu.adp.widget.ImageView.a aVar, com.baidu.adp.widget.ImageView.a aVar2) {
                if (aVar != null) {
                    aVar.recycle();
                }
            }
        };
        this.cIt = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            /* renamed from: d */
            public int sizeOf(String str, com.baidu.adp.widget.ImageView.a aVar) {
                if (aVar != null) {
                    return aVar.size();
                }
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
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
        this.cIu = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.a
            public void entryRemoved(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
        };
    }

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> jW(int i) {
        if (this.cIv != null && this.cIw != null) {
            if (this.cIw.getBlockSize() == i) {
                return this.cIv;
            }
            this.cIw.setBlockSize(i);
            this.cIv.clear();
        }
        if (this.cIw == null) {
            this.cIw = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.cIv == null) {
            this.cIv = new com.baidu.adp.lib.e.b<>(this.cIw, 6, 0);
        }
        return this.cIv;
    }

    public void releaseBlockBitmapPool() {
        if (this.cIv != null) {
            this.cIv.setMinIdle(0);
            this.cIv.setMaxIdle(0);
            this.cIv.clear();
            this.cIv = null;
        }
    }

    public int getPicCacheSize() {
        return this.cIt.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.cIs.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.cIt.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.cIu.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.cIu.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.cIu.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cIs != null) {
            this.cIs.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.cIt.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cIt != null) {
            if (BdLog.isDebugMode()) {
            }
            this.cIt.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.cIs.remove(str);
    }

    public void deletePic(String str) {
        this.cIt.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a pX(String str) {
        return this.cIs.get(str);
    }

    public com.baidu.adp.widget.ImageView.a pY(String str) {
        return this.cIt.get(str);
    }

    public String toString() {
        return "pic:" + this.cIt.toString() + "  photo:" + this.cIs.toString();
    }

    public String toLogString() {
        return this.cIt.size() + "/" + this.cIt.getMaxSize() + "/" + this.cIt.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.cIs.size() + "/" + this.cIs.getMaxSize() + "/" + this.cIs.evictionCount();
    }
}
