package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e {
    private b aFo;
    private d aFp = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String b(ImageFileInfo imageFileInfo) {
            String str = null;
            if (imageFileInfo != null) {
                if (e.this.aFo == null) {
                    e.this.aFo = new b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                com.baidu.adp.widget.ImageView.a a = e.this.aFo.a(imageFileInfo, true);
                if (a == null) {
                    Bitmap b = e.this.aFo.b(imageFileInfo, true);
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0 && b != null) {
                        b = BitmapHelper.rotateBitmapBydegree(b, readPictureDegree);
                    }
                    str = e.this.b(b, 85);
                } else {
                    str = e.this.b(a.kN(), 85);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
            }
            return str;
        }
    };
    private d aFq = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String b(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.gj(imageFileInfo.getFilePath());
        }
    };
    private d aFr = this.aFq;
    private d aFs = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String b(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.b(e.this.gk(imageFileInfo.getFilePath()), 85);
        }
    };

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        boolean dk = k.dk(imageFileInfo.getFilePath());
        if (z && !imageFileInfo.hasActionsWithoutResize()) {
            if (dk) {
                dVar = this.aFr;
            } else {
                dVar = this.aFq;
            }
        } else if (dk) {
            dVar = this.aFs;
        } else {
            dVar = this.aFp;
        }
        return dVar.b(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gj(String str) {
        int i;
        long dq = k.dq(str);
        if (dq >= 20971520) {
            i = 60;
        } else if (dq >= 10485760 && dq < 20971520) {
            i = 75;
        } else if (dq >= 7340032 && dq < 10485760) {
            i = 85;
        } else {
            i = (dq < 5242880 || dq >= 7340032) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap gk = gk(str);
                if (readPictureDegree != 0 && gk != null) {
                    return b(BitmapHelper.rotateBitmapBydegree(gk, readPictureDegree), i);
                }
                return b(gk, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap gk(String str) {
        BitmapFactory.Options gl = gl(str);
        int i = gl.outWidth;
        int i2 = gl.outHeight;
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
                gl.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, gl);
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

    private BitmapFactory.Options gl(String str) {
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
