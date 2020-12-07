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
    private static c fyO = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fyP;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> fyQ;
    private com.baidu.adp.lib.d.a<String, Bitmap> fyR;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> fyS;
    private com.baidu.tbadk.widget.largeImage.b.b fyT;

    public static c bDV() {
        return fyO;
    }

    private c() {
        this.fyP = null;
        this.fyQ = null;
        this.fyR = null;
        this.fyP = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.fyQ = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.fyR = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> sy(int i) {
        if (this.fyS != null && this.fyT != null) {
            if (this.fyT.getBlockSize() == i) {
                return this.fyS;
            }
            this.fyT.setBlockSize(i);
            this.fyS.clear();
        }
        if (this.fyT == null) {
            this.fyT = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.fyS == null) {
            this.fyS = new com.baidu.adp.lib.d.b<>(this.fyT, 6, 0);
        }
        return this.fyS;
    }

    public void releaseBlockBitmapPool() {
        if (this.fyS != null) {
            this.fyS.setMinIdle(0);
            this.fyS.setMaxIdle(0);
            this.fyS.clear();
            this.fyS = null;
        }
    }

    public int getPicCacheSize() {
        return this.fyQ.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.fyP.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.fyQ.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.fyR.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.fyR.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.fyR.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fyP != null) {
            this.fyP.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.fyQ.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.fyQ != null) {
            if (BdLog.isDebugMode()) {
            }
            this.fyQ.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.fyP.remove(str);
    }

    public void deletePic(String str) {
        this.fyQ.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a Eh(String str) {
        return this.fyP.get(str);
    }

    public com.baidu.adp.widget.ImageView.a Ei(String str) {
        return this.fyQ.get(str);
    }

    public String toString() {
        return "pic:" + this.fyQ.toString() + "  photo:" + this.fyP.toString();
    }

    public String toLogString() {
        return this.fyQ.size() + "/" + this.fyQ.getMaxSize() + "/" + this.fyQ.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.fyP.size() + "/" + this.fyP.getMaxSize() + "/" + this.fyP.evictionCount();
    }
}
