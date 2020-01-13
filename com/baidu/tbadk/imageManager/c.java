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
    private static c dwi = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> dwj;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> dwk;
    private com.baidu.adp.lib.d.a<String, Bitmap> dwl;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> dwm;
    private com.baidu.tbadk.widget.largeImage.b.b dwn;

    public static c aNs() {
        return dwi;
    }

    private c() {
        this.dwj = null;
        this.dwk = null;
        this.dwl = null;
        this.dwj = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.dwk = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.dwl = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.dwm != null && this.dwn != null) {
            if (this.dwn.getBlockSize() == i) {
                return this.dwm;
            }
            this.dwn.setBlockSize(i);
            this.dwm.clear();
        }
        if (this.dwn == null) {
            this.dwn = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.dwm == null) {
            this.dwm = new com.baidu.adp.lib.d.b<>(this.dwn, 6, 0);
        }
        return this.dwm;
    }

    public void releaseBlockBitmapPool() {
        if (this.dwm != null) {
            this.dwm.setMinIdle(0);
            this.dwm.setMaxIdle(0);
            this.dwm.clear();
            this.dwm = null;
        }
    }

    public int getPicCacheSize() {
        return this.dwk.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.dwj.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.dwk.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.dwl.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.dwl.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.dwl.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.dwj != null) {
            this.dwj.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.dwk.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.dwk != null) {
            if (BdLog.isDebugMode()) {
            }
            this.dwk.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.dwj.remove(str);
    }

    public void deletePic(String str) {
        this.dwk.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a vf(String str) {
        return this.dwj.get(str);
    }

    public com.baidu.adp.widget.ImageView.a vg(String str) {
        return this.dwk.get(str);
    }

    public String toString() {
        return "pic:" + this.dwk.toString() + "  photo:" + this.dwj.toString();
    }

    public String toLogString() {
        return this.dwk.size() + "/" + this.dwk.getMaxSize() + "/" + this.dwk.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.dwj.size() + "/" + this.dwj.getMaxSize() + "/" + this.dwj.evictionCount();
    }
}
