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
    private static c fDM = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fDN;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fDO;
    private com.baidu.adp.lib.d.a<String, Bitmap> fDP;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fDQ;
    private com.baidu.tbadk.widget.largeImage.b.b fDR;

    public static c bCx() {
        return fDM;
    }

    private c() {
        this.fDN = null;
        this.fDO = null;
        this.fDP = null;
        this.fDN = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.fDO = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.fDP = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> re(int i) {
        if (this.fDQ != null && this.fDR != null) {
            if (this.fDR.getBlockSize() == i) {
                return this.fDQ;
            }
            this.fDR.setBlockSize(i);
            this.fDQ.clear();
        }
        if (this.fDR == null) {
            this.fDR = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.fDQ == null) {
            this.fDQ = new com.baidu.adp.lib.d.b<>(this.fDR, 6, 0);
        }
        return this.fDQ;
    }

    public void releaseBlockBitmapPool() {
        if (this.fDQ != null) {
            this.fDQ.setMinIdle(0);
            this.fDQ.setMaxIdle(0);
            this.fDQ.clear();
            this.fDQ = null;
        }
    }

    public int getPicCacheSize() {
        return this.fDO.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.fDN.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.fDO.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.fDP.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.fDP.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.fDP.get(str);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fDN != null) {
            this.fDN.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.fDO.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fDO != null) {
            if (BdLog.isDebugMode()) {
            }
            this.fDO.put(str, aVar);
        }
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.fDN.remove(str);
    }

    public void deletePic(String str) {
        this.fDO.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a CS(String str) {
        return this.fDN.get(str);
    }

    public com.baidu.adp.widget.ImageView.a CT(String str) {
        return this.fDO.get(str);
    }

    public String toString() {
        return "pic:" + this.fDO.toString() + "  photo:" + this.fDN.toString();
    }

    public String toLogString() {
        return this.fDO.size() + "/" + this.fDO.getMaxSize() + "/" + this.fDO.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.fDN.size() + "/" + this.fDN.getMaxSize() + "/" + this.fDN.evictionCount();
    }
}
