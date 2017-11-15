package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e {
    private b aGg;
    private d aGh = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String b(ImageFileInfo imageFileInfo) {
            String str = null;
            if (imageFileInfo != null) {
                if (e.this.aGg == null) {
                    e.this.aGg = new b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                com.baidu.adp.widget.a.a a = e.this.aGg.a(imageFileInfo, true);
                if (a == null) {
                    Bitmap b = e.this.aGg.b(imageFileInfo, true);
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
    private d aGi = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String b(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.gr(imageFileInfo.getFilePath());
        }
    };
    private d aGj = this.aGi;
    private d aGk = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String b(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.b(e.this.gt(imageFileInfo.getFilePath()), 85);
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
                dVar = this.aGj;
            } else {
                dVar = this.aGi;
            }
        } else if (dr) {
            dVar = this.aGk;
        } else {
            dVar = this.aGh;
        }
        return dVar.b(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gr(String str) {
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
                Bitmap gt = gt(str);
                if (readPictureDegree != 0 && gt != null) {
                    return b(BitmapHelper.rotateBitmapBydegree(gt, readPictureDegree), i);
                }
                return b(gt, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap gt(String str) {
        BitmapFactory.Options gu = gu(str);
        int i = gu.outWidth;
        int i2 = gu.outHeight;
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
                gu.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, gu);
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

    private BitmapFactory.Options gu(String str) {
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
