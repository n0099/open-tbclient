package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e {
    private b buI;
    private d buJ = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            String str = null;
            if (imageFileInfo != null) {
                if (e.this.buI == null) {
                    e.this.buI = new b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                com.baidu.adp.widget.a.a a = e.this.buI.a(imageFileInfo, true);
                if (a == null) {
                    Bitmap b = e.this.buI.b(imageFileInfo, true);
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0 && b != null) {
                        b = BitmapHelper.rotateBitmapBydegree(b, readPictureDegree);
                    }
                    str = e.this.d(b, 85);
                } else {
                    str = e.this.d(a.si(), 85);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
            }
            return str;
        }
    };
    private d buK = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.gz(imageFileInfo.getFilePath());
        }
    };
    private d buL = this.buK;
    private d buM = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.d(e.this.gA(imageFileInfo.getFilePath()), 85);
        }
    };

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        boolean dy = k.dy(imageFileInfo.getFilePath());
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize())) {
            if (dy) {
                dVar = this.buL;
            } else {
                dVar = this.buK;
            }
        } else if (dy) {
            dVar = this.buM;
        } else {
            dVar = this.buJ;
        }
        return dVar.a(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gz(String str) {
        int i;
        long dE = k.dE(str);
        if (dE >= 20971520) {
            i = 60;
        } else if (dE >= 10485760 && dE < 20971520) {
            i = 75;
        } else if (dE >= 7340032 && dE < 10485760) {
            i = 85;
        } else {
            i = (dE < 5242880 || dE >= 7340032) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap gA = gA(str);
                if (readPictureDegree != 0 && gA != null) {
                    return d(BitmapHelper.rotateBitmapBydegree(gA, readPictureDegree), i);
                }
                return d(gA, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap gA(String str) {
        BitmapFactory.Options gB = gB(str);
        int i = gB.outWidth;
        int i2 = gB.outHeight;
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
                gB.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, gB);
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

    private BitmapFactory.Options gB(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(Bitmap bitmap, int i) {
        return k.a("img_upload_temp_file.temp", bitmap, 5242880.0f, i);
    }
}
