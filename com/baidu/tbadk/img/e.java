package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e {
    private b aQR;
    private d aQS = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            String str = null;
            if (imageFileInfo != null) {
                if (e.this.aQR == null) {
                    e.this.aQR = new b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                com.baidu.adp.widget.ImageView.a a = e.this.aQR.a(imageFileInfo, true);
                if (a == null) {
                    Bitmap b = e.this.aQR.b(imageFileInfo, true);
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0 && b != null) {
                        b = BitmapHelper.rotateBitmapBydegree(b, readPictureDegree);
                    }
                    str = e.this.b(b, 85);
                } else {
                    str = e.this.b(a.nb(), 85);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
            }
            return str;
        }
    };
    private d aQT = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.hg(imageFileInfo.getFilePath());
        }
    };
    private d aQU = this.aQT;
    private d aQV = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.b(e.this.hh(imageFileInfo.getFilePath()), 85);
        }
    };

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        String filePath = imageFileInfo.getFilePath();
        boolean ef = l.ef(filePath);
        boolean eg = l.eg(filePath);
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize() && !eg)) {
            if (ef) {
                dVar = this.aQU;
            } else {
                dVar = this.aQT;
            }
        } else if (ef) {
            dVar = this.aQV;
        } else {
            dVar = this.aQS;
        }
        return dVar.a(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hg(String str) {
        int i;
        long en = l.en(str);
        if (en >= 20971520) {
            i = 60;
        } else if (en >= 10485760 && en < 20971520) {
            i = 75;
        } else if (en >= 7340032 && en < 10485760) {
            i = 85;
        } else {
            i = (en < 5242880 || en >= 7340032) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap hh = hh(str);
                if (readPictureDegree != 0 && hh != null) {
                    return b(BitmapHelper.rotateBitmapBydegree(hh, readPictureDegree), i);
                }
                return b(hh, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap hh(String str) {
        BitmapFactory.Options hi = hi(str);
        int i = hi.outWidth;
        int i2 = hi.outHeight;
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
                hi.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, hi);
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

    private BitmapFactory.Options hi(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(Bitmap bitmap, int i) {
        return l.a("img_upload_temp_file.temp", bitmap, 5242880.0f, i);
    }
}
