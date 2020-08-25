package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes2.dex */
public class c {
    private static c eOx = new c();
    private com.baidu.adp.lib.d.a<String, Bitmap> eOA;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eOB;
    private com.baidu.tbadk.widget.largeImage.b.b eOC;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eOy;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eOz;

    public static c bsW() {
        return eOx;
    }

    private c() {
        this.eOy = null;
        this.eOz = null;
        this.eOA = null;
        this.eOy = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.eOz = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.eOA = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> qp(int i) {
        if (this.eOB != null && this.eOC != null) {
            if (this.eOC.getBlockSize() == i) {
                return this.eOB;
            }
            this.eOC.setBlockSize(i);
            this.eOB.clear();
        }
        if (this.eOC == null) {
            this.eOC = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.eOB == null) {
            this.eOB = new com.baidu.adp.lib.d.b<>(this.eOC, 6, 0);
        }
        return this.eOB;
    }

    public void releaseBlockBitmapPool() {
        if (this.eOB != null) {
            this.eOB.setMinIdle(0);
            this.eOB.setMaxIdle(0);
            this.eOB.clear();
            this.eOB = null;
        }
    }

    public int getPicCacheSize() {
        return this.eOz.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.eOy.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.eOz.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.eOA.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.eOA.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.eOA.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eOy != null) {
            this.eOy.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.eOz.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eOz != null) {
            if (BdLog.isDebugMode()) {
            }
            this.eOz.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.eOy.remove(str);
    }

    public void deletePic(String str) {
        this.eOz.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a Ck(String str) {
        return this.eOy.get(str);
    }

    public com.baidu.adp.widget.ImageView.a Cl(String str) {
        return this.eOz.get(str);
    }

    public String toString() {
        return "pic:" + this.eOz.toString() + "  photo:" + this.eOy.toString();
    }

    public String toLogString() {
        return this.eOz.size() + "/" + this.eOz.getMaxSize() + "/" + this.eOz.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.eOy.size() + "/" + this.eOy.getMaxSize() + "/" + this.eOy.evictionCount();
    }
}
