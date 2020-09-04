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
    private static c eOB = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eOC;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eOD;
    private com.baidu.adp.lib.d.a<String, Bitmap> eOE;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eOF;
    private com.baidu.tbadk.widget.largeImage.b.b eOG;

    public static c bsX() {
        return eOB;
    }

    private c() {
        this.eOC = null;
        this.eOD = null;
        this.eOE = null;
        this.eOC = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.eOD = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.eOE = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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
        if (this.eOF != null && this.eOG != null) {
            if (this.eOG.getBlockSize() == i) {
                return this.eOF;
            }
            this.eOG.setBlockSize(i);
            this.eOF.clear();
        }
        if (this.eOG == null) {
            this.eOG = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.eOF == null) {
            this.eOF = new com.baidu.adp.lib.d.b<>(this.eOG, 6, 0);
        }
        return this.eOF;
    }

    public void releaseBlockBitmapPool() {
        if (this.eOF != null) {
            this.eOF.setMinIdle(0);
            this.eOF.setMaxIdle(0);
            this.eOF.clear();
            this.eOF = null;
        }
    }

    public int getPicCacheSize() {
        return this.eOD.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.eOC.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.eOD.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.eOE.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.eOE.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.eOE.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eOC != null) {
            this.eOC.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.eOD.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eOD != null) {
            if (BdLog.isDebugMode()) {
            }
            this.eOD.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.eOC.remove(str);
    }

    public void deletePic(String str) {
        this.eOD.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a Cl(String str) {
        return this.eOC.get(str);
    }

    public com.baidu.adp.widget.ImageView.a Cm(String str) {
        return this.eOD.get(str);
    }

    public String toString() {
        return "pic:" + this.eOD.toString() + "  photo:" + this.eOC.toString();
    }

    public String toLogString() {
        return this.eOD.size() + "/" + this.eOD.getMaxSize() + "/" + this.eOD.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.eOC.size() + "/" + this.eOC.getMaxSize() + "/" + this.eOC.evictionCount();
    }
}
