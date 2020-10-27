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
    private static c flY = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> flZ;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fma;
    private com.baidu.adp.lib.d.a<String, Bitmap> fmb;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fmc;
    private com.baidu.tbadk.widget.largeImage.b.b fmd;

    public static c byE() {
        return flY;
    }

    private c() {
        this.flZ = null;
        this.fma = null;
        this.fmb = null;
        this.flZ = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.fma = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.fmb = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> rp(int i) {
        if (this.fmc != null && this.fmd != null) {
            if (this.fmd.getBlockSize() == i) {
                return this.fmc;
            }
            this.fmd.setBlockSize(i);
            this.fmc.clear();
        }
        if (this.fmd == null) {
            this.fmd = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.fmc == null) {
            this.fmc = new com.baidu.adp.lib.d.b<>(this.fmd, 6, 0);
        }
        return this.fmc;
    }

    public void releaseBlockBitmapPool() {
        if (this.fmc != null) {
            this.fmc.setMinIdle(0);
            this.fmc.setMaxIdle(0);
            this.fmc.clear();
            this.fmc = null;
        }
    }

    public int getPicCacheSize() {
        return this.fma.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.flZ.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.fma.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.fmb.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.fmb.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.fmb.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.flZ != null) {
            this.flZ.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.fma.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fma != null) {
            if (BdLog.isDebugMode()) {
            }
            this.fma.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.flZ.remove(str);
    }

    public void deletePic(String str) {
        this.fma.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a DM(String str) {
        return this.flZ.get(str);
    }

    public com.baidu.adp.widget.ImageView.a DN(String str) {
        return this.fma.get(str);
    }

    public String toString() {
        return "pic:" + this.fma.toString() + "  photo:" + this.flZ.toString();
    }

    public String toLogString() {
        return this.fma.size() + "/" + this.fma.getMaxSize() + "/" + this.fma.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.flZ.size() + "/" + this.flZ.getMaxSize() + "/" + this.flZ.evictionCount();
    }
}
