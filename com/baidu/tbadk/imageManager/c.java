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
    private static c cJi = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cJj;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a> cJk;
    private com.baidu.adp.lib.e.a<String, Bitmap> cJl;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> cJm;
    private com.baidu.tbadk.widget.largeImage.b.b cJn;

    public static c avu() {
        return cJi;
    }

    private c() {
        this.cJj = null;
        this.cJk = null;
        this.cJl = null;
        this.cJj = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.cJk = new com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.cJl = new com.baidu.adp.lib.e.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.largeImage.a.a> jX(int i) {
        if (this.cJm != null && this.cJn != null) {
            if (this.cJn.getBlockSize() == i) {
                return this.cJm;
            }
            this.cJn.setBlockSize(i);
            this.cJm.clear();
        }
        if (this.cJn == null) {
            this.cJn = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.cJm == null) {
            this.cJm = new com.baidu.adp.lib.e.b<>(this.cJn, 6, 0);
        }
        return this.cJm;
    }

    public void releaseBlockBitmapPool() {
        if (this.cJm != null) {
            this.cJm.setMinIdle(0);
            this.cJm.setMaxIdle(0);
            this.cJm.clear();
            this.cJm = null;
        }
    }

    public int getPicCacheSize() {
        return this.cJk.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.cJj.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.cJk.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.cJl.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.cJl.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.cJl.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cJj != null) {
            this.cJj.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.cJk.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.cJk != null) {
            if (BdLog.isDebugMode()) {
            }
            this.cJk.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.cJj.remove(str);
    }

    public void deletePic(String str) {
        this.cJk.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a pX(String str) {
        return this.cJj.get(str);
    }

    public com.baidu.adp.widget.ImageView.a pY(String str) {
        return this.cJk.get(str);
    }

    public String toString() {
        return "pic:" + this.cJk.toString() + "  photo:" + this.cJj.toString();
    }

    public String toLogString() {
        return this.cJk.size() + "/" + this.cJk.getMaxSize() + "/" + this.cJk.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.cJj.size() + "/" + this.cJj.getMaxSize() + "/" + this.cJj.evictionCount();
    }
}
