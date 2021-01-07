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
    private static c fIt = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fIu;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fIv;
    private com.baidu.adp.lib.d.a<String, Bitmap> fIw;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fIx;
    private com.baidu.tbadk.widget.largeImage.b.b fIy;

    public static c bGq() {
        return fIt;
    }

    private c() {
        this.fIu = null;
        this.fIv = null;
        this.fIw = null;
        this.fIu = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.fIv = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.fIw = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> sK(int i) {
        if (this.fIx != null && this.fIy != null) {
            if (this.fIy.getBlockSize() == i) {
                return this.fIx;
            }
            this.fIy.setBlockSize(i);
            this.fIx.clear();
        }
        if (this.fIy == null) {
            this.fIy = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.fIx == null) {
            this.fIx = new com.baidu.adp.lib.d.b<>(this.fIy, 6, 0);
        }
        return this.fIx;
    }

    public void releaseBlockBitmapPool() {
        if (this.fIx != null) {
            this.fIx.setMinIdle(0);
            this.fIx.setMaxIdle(0);
            this.fIx.clear();
            this.fIx = null;
        }
    }

    public int getPicCacheSize() {
        return this.fIv.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.fIu.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.fIv.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.fIw.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.fIw.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.fIw.get(str);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fIu != null) {
            this.fIu.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.fIv.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fIv != null) {
            if (BdLog.isDebugMode()) {
            }
            this.fIv.put(str, aVar);
        }
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.fIu.remove(str);
    }

    public void deletePic(String str) {
        this.fIv.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a Ed(String str) {
        return this.fIu.get(str);
    }

    public com.baidu.adp.widget.ImageView.a Ee(String str) {
        return this.fIv.get(str);
    }

    public String toString() {
        return "pic:" + this.fIv.toString() + "  photo:" + this.fIu.toString();
    }

    public String toLogString() {
        return this.fIv.size() + "/" + this.fIv.getMaxSize() + "/" + this.fIv.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.fIu.size() + "/" + this.fIu.getMaxSize() + "/" + this.fIu.evictionCount();
    }
}
