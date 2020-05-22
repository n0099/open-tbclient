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
    private static c eoP = new c();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eoQ;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a> eoR;
    private com.baidu.adp.lib.d.a<String, Bitmap> eoS;
    private com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> eoT;
    private com.baidu.tbadk.widget.largeImage.b.b eoU;

    public static c bet() {
        return eoP;
    }

    private c() {
        this.eoQ = null;
        this.eoR = null;
        this.eoS = null;
        this.eoQ = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.1
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
        this.eoR = new com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.a>(0) { // from class: com.baidu.tbadk.imageManager.c.2
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
        this.eoS = new com.baidu.adp.lib.d.a<String, Bitmap>(0) { // from class: com.baidu.tbadk.imageManager.c.3
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

    public com.baidu.adp.lib.d.b<com.baidu.tbadk.widget.largeImage.a.a> nq(int i) {
        if (this.eoT != null && this.eoU != null) {
            if (this.eoU.getBlockSize() == i) {
                return this.eoT;
            }
            this.eoU.setBlockSize(i);
            this.eoT.clear();
        }
        if (this.eoU == null) {
            this.eoU = new com.baidu.tbadk.widget.largeImage.b.b(i);
        }
        if (this.eoT == null) {
            this.eoT = new com.baidu.adp.lib.d.b<>(this.eoU, 6, 0);
        }
        return this.eoT;
    }

    public void releaseBlockBitmapPool() {
        if (this.eoT != null) {
            this.eoT.setMinIdle(0);
            this.eoT.setMaxIdle(0);
            this.eoT.clear();
            this.eoT = null;
        }
    }

    public int getPicCacheSize() {
        return this.eoR.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(60);
    }

    public void setPhotoMaxNum(int i) {
        this.eoQ.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.eoR.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.eoS.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.eoS.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.eoS.get(str);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eoQ != null) {
            this.eoQ.put(str, aVar);
        }
    }

    public boolean freePicCache(int i) {
        return this.eoR.freeMemory(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null && this.eoR != null) {
            if (BdLog.isDebugMode()) {
            }
            this.eoR.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar) {
        b(str, aVar, false);
    }

    public void deletePhoto(String str) {
        this.eoQ.remove(str);
    }

    public void deletePic(String str) {
        this.eoR.remove(str);
    }

    public com.baidu.adp.widget.ImageView.a yu(String str) {
        return this.eoQ.get(str);
    }

    public com.baidu.adp.widget.ImageView.a yv(String str) {
        return this.eoR.get(str);
    }

    public String toString() {
        return "pic:" + this.eoR.toString() + "  photo:" + this.eoQ.toString();
    }

    public String toLogString() {
        return this.eoR.size() + "/" + this.eoR.getMaxSize() + "/" + this.eoR.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.eoQ.size() + "/" + this.eoQ.getMaxSize() + "/" + this.eoQ.evictionCount();
    }
}
