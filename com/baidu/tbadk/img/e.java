package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e {
    private b cwL;
    private d cwM = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            String b;
            if (imageFileInfo == null) {
                return null;
            }
            if (e.this.cwL == null) {
                e.this.cwL = new b();
            }
            String filePath = imageFileInfo.getFilePath();
            LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
            imageFileInfo.setPageActionsList(null);
            com.baidu.adp.widget.ImageView.a a = e.this.cwL.a(imageFileInfo, true);
            if (a == null) {
                Bitmap b2 = e.this.b(imageFileInfo);
                if (b2 == null) {
                    return null;
                }
                int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                if (readPictureDegree != 0 && b2 != null) {
                    b2 = BitmapHelper.rotateBitmapBydegree(b2, readPictureDegree);
                }
                b = e.this.b(b2, 85);
            } else {
                b = e.this.b(a.nK(), 85);
            }
            imageFileInfo.setPageActionsList(pageActionsList);
            return b;
        }
    };
    private d cwN = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.qJ(imageFileInfo.getFilePath());
        }
    };
    private d cwO = this.cwN;
    private d cwP = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.b(e.this.qK(imageFileInfo.getFilePath()), 85);
        }
    };

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        String filePath = imageFileInfo.getFilePath();
        boolean nv = m.nv(filePath);
        boolean nw = m.nw(filePath);
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize() && !nw)) {
            if (nv) {
                dVar = this.cwO;
            } else {
                dVar = this.cwN;
            }
        } else if (nv) {
            dVar = this.cwP;
        } else {
            dVar = this.cwM;
        }
        return dVar.a(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap b(ImageFileInfo imageFileInfo) {
        com.baidu.adp.lib.f.e ak;
        if (imageFileInfo == null) {
            return null;
        }
        if (this.cwL == null) {
            this.cwL = new b();
        }
        if (imageFileInfo.getImageType() == 0) {
            return this.cwL.b(imageFileInfo, true);
        }
        if (imageFileInfo.getImageType() == 1 && (ak = com.baidu.adp.lib.f.c.iE().ak(20)) != null) {
            try {
                Object a = ak.a(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), false, null);
                if (a instanceof com.baidu.adp.widget.ImageView.a) {
                    return ((com.baidu.adp.widget.ImageView.a) a).nK();
                }
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String qJ(String str) {
        int i;
        long ju = m.ju(str);
        if (ju >= 20971520) {
            i = 60;
        } else if (ju >= Config.FULL_TRACE_LOG_LIMIT && ju < 20971520) {
            i = 75;
        } else if (ju >= 7340032 && ju < Config.FULL_TRACE_LOG_LIMIT) {
            i = 85;
        } else {
            i = (ju < 5242880 || ju >= 7340032) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap qK = qK(str);
                if (readPictureDegree != 0 && qK != null) {
                    return b(BitmapHelper.rotateBitmapBydegree(qK, readPictureDegree), i);
                }
                return b(qK, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap qK(String str) {
        BitmapFactory.Options qL = qL(str);
        int i = qL.outWidth;
        int i2 = qL.outHeight;
        if (i == 0 || i2 == 0) {
            return null;
        }
        Bitmap loadBitmap = BitmapHelper.loadBitmap(str);
        if (loadBitmap == null || loadBitmap.isRecycled()) {
            int i3 = 0;
            int i4 = 1;
            while (true) {
                int i5 = i3;
                if (i5 >= 3) {
                    return null;
                }
                qL.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, qL);
                if (loadBitmap2 == null || loadBitmap2.isRecycled()) {
                    i4++;
                    i3 = i5 + 1;
                } else {
                    return loadBitmap2;
                }
            }
        } else {
            return loadBitmap;
        }
    }

    private BitmapFactory.Options qL(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(Bitmap bitmap, int i) {
        return m.a("img_upload_temp_file.temp", bitmap, 5242880.0f, i);
    }
}
