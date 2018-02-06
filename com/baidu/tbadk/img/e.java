package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e {
    private b bxk;
    private d bxl = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            String str = null;
            if (imageFileInfo != null) {
                if (e.this.bxk == null) {
                    e.this.bxk = new b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                com.baidu.adp.widget.a.a a = e.this.bxk.a(imageFileInfo, true);
                if (a == null) {
                    Bitmap b = e.this.bxk.b(imageFileInfo, true);
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0 && b != null) {
                        b = BitmapHelper.rotateBitmapBydegree(b, readPictureDegree);
                    }
                    str = e.this.d(b, 85);
                } else {
                    str = e.this.d(a.sh(), 85);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
            }
            return str;
        }
    };
    private d bxm = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.gR(imageFileInfo.getFilePath());
        }
    };
    private d bxn = this.bxm;
    private d bxo = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.d(e.this.gS(imageFileInfo.getFilePath()), 85);
        }
    };

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        boolean dN = k.dN(imageFileInfo.getFilePath());
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize())) {
            if (dN) {
                dVar = this.bxn;
            } else {
                dVar = this.bxm;
            }
        } else if (dN) {
            dVar = this.bxo;
        } else {
            dVar = this.bxl;
        }
        return dVar.a(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gR(String str) {
        int i;
        long dV = k.dV(str);
        if (dV >= 20971520) {
            i = 60;
        } else if (dV >= 10485760 && dV < 20971520) {
            i = 75;
        } else if (dV >= 7340032 && dV < 10485760) {
            i = 85;
        } else {
            i = (dV < 5242880 || dV >= 7340032) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap gS = gS(str);
                if (readPictureDegree != 0 && gS != null) {
                    return d(BitmapHelper.rotateBitmapBydegree(gS, readPictureDegree), i);
                }
                return d(gS, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap gS(String str) {
        BitmapFactory.Options gT = gT(str);
        int i = gT.outWidth;
        int i2 = gT.outHeight;
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
                gT.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, gT);
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

    private BitmapFactory.Options gT(String str) {
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
