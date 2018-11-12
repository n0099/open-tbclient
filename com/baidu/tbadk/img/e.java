package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e {
    private b aZt;
    private d aZu = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            String str = null;
            if (imageFileInfo != null) {
                if (e.this.aZt == null) {
                    e.this.aZt = new b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                com.baidu.adp.widget.ImageView.a a = e.this.aZt.a(imageFileInfo, true);
                if (a == null) {
                    Bitmap b = e.this.aZt.b(imageFileInfo, true);
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0 && b != null) {
                        b = BitmapHelper.rotateBitmapBydegree(b, readPictureDegree);
                    }
                    str = e.this.b(b, 85);
                } else {
                    str = e.this.b(a.oq(), 85);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
            }
            return str;
        }
    };
    private d aZv = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.hR(imageFileInfo.getFilePath());
        }
    };
    private d aZw = this.aZv;
    private d aZx = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.b(e.this.hS(imageFileInfo.getFilePath()), 85);
        }
    };

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        String filePath = imageFileInfo.getFilePath();
        boolean eN = l.eN(filePath);
        boolean eO = l.eO(filePath);
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize() && !eO)) {
            if (eN) {
                dVar = this.aZw;
            } else {
                dVar = this.aZv;
            }
        } else if (eN) {
            dVar = this.aZx;
        } else {
            dVar = this.aZu;
        }
        return dVar.a(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hR(String str) {
        int i;
        long eV = l.eV(str);
        if (eV >= 20971520) {
            i = 60;
        } else if (eV >= 10485760 && eV < 20971520) {
            i = 75;
        } else if (eV >= 7340032 && eV < 10485760) {
            i = 85;
        } else {
            i = (eV < 5242880 || eV >= 7340032) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap hS = hS(str);
                if (readPictureDegree != 0 && hS != null) {
                    return b(BitmapHelper.rotateBitmapBydegree(hS, readPictureDegree), i);
                }
                return b(hS, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap hS(String str) {
        BitmapFactory.Options hT = hT(str);
        int i = hT.outWidth;
        int i2 = hT.outHeight;
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
                hT.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, hT);
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

    private BitmapFactory.Options hT(String str) {
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
