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
    private b cxH;
    private d cxI = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            String b;
            if (imageFileInfo == null) {
                return null;
            }
            if (e.this.cxH == null) {
                e.this.cxH = new b();
            }
            String filePath = imageFileInfo.getFilePath();
            LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
            imageFileInfo.setPageActionsList(null);
            com.baidu.adp.widget.ImageView.a a = e.this.cxH.a(imageFileInfo, true);
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
    private d cxJ = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.qU(imageFileInfo.getFilePath());
        }
    };
    private d cxK = this.cxJ;
    private d cxL = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.b(e.this.qV(imageFileInfo.getFilePath()), 85);
        }
    };

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        String filePath = imageFileInfo.getFilePath();
        boolean nx = m.nx(filePath);
        boolean ny = m.ny(filePath);
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize() && !ny)) {
            if (nx) {
                dVar = this.cxK;
            } else {
                dVar = this.cxJ;
            }
        } else if (nx) {
            dVar = this.cxL;
        } else {
            dVar = this.cxI;
        }
        return dVar.a(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap b(ImageFileInfo imageFileInfo) {
        com.baidu.adp.lib.f.e ak;
        if (imageFileInfo == null) {
            return null;
        }
        if (this.cxH == null) {
            this.cxH = new b();
        }
        if (imageFileInfo.getImageType() == 0) {
            return this.cxH.b(imageFileInfo, true);
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
    public String qU(String str) {
        int i;
        long jw = m.jw(str);
        if (jw >= 20971520) {
            i = 60;
        } else if (jw >= Config.FULL_TRACE_LOG_LIMIT && jw < 20971520) {
            i = 75;
        } else if (jw >= 7340032 && jw < Config.FULL_TRACE_LOG_LIMIT) {
            i = 85;
        } else {
            i = (jw < 5242880 || jw >= 7340032) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap qV = qV(str);
                if (readPictureDegree != 0 && qV != null) {
                    return b(BitmapHelper.rotateBitmapBydegree(qV, readPictureDegree), i);
                }
                return b(qV, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap qV(String str) {
        BitmapFactory.Options qW = qW(str);
        int i = qW.outWidth;
        int i2 = qW.outHeight;
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
                qW.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, qW);
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

    private BitmapFactory.Options qW(String str) {
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
