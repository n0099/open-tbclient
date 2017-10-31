package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e {
    private b aFY;
    private d aFZ = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String b(ImageFileInfo imageFileInfo) {
            String str = null;
            if (imageFileInfo != null) {
                if (e.this.aFY == null) {
                    e.this.aFY = new b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                com.baidu.adp.widget.a.a a = e.this.aFY.a(imageFileInfo, true);
                if (a == null) {
                    Bitmap b = e.this.aFY.b(imageFileInfo, true);
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0 && b != null) {
                        b = BitmapHelper.rotateBitmapBydegree(b, readPictureDegree);
                    }
                    str = e.this.b(b, 85);
                } else {
                    str = e.this.b(a.kK(), 85);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
            }
            return str;
        }
    };
    private d aGa = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String b(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.gq(imageFileInfo.getFilePath());
        }
    };
    private d aGb = this.aGa;
    private d aGc = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String b(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.b(e.this.gr(imageFileInfo.getFilePath()), 85);
        }
    };

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        boolean dr = k.dr(imageFileInfo.getFilePath());
        if (z && !imageFileInfo.hasActionsWithoutResize()) {
            if (dr) {
                dVar = this.aGb;
            } else {
                dVar = this.aGa;
            }
        } else if (dr) {
            dVar = this.aGc;
        } else {
            dVar = this.aFZ;
        }
        return dVar.b(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gq(String str) {
        int i;
        long dx = k.dx(str);
        if (dx >= 20971520) {
            i = 60;
        } else if (dx >= 10485760 && dx < 20971520) {
            i = 75;
        } else if (dx >= 7340032 && dx < 10485760) {
            i = 85;
        } else {
            i = (dx < 5242880 || dx >= 7340032) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap gr = gr(str);
                if (readPictureDegree != 0 && gr != null) {
                    return b(BitmapHelper.rotateBitmapBydegree(gr, readPictureDegree), i);
                }
                return b(gr, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap gr(String str) {
        BitmapFactory.Options gt = gt(str);
        int i = gt.outWidth;
        int i2 = gt.outHeight;
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
                gt.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, gt);
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

    private BitmapFactory.Options gt(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(Bitmap bitmap, int i) {
        return k.a("img_upload_temp_file.temp", bitmap, 5242880.0f, i);
    }
}
