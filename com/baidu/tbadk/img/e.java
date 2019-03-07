package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e {
    private b cne;
    private d cnf = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            String b;
            if (imageFileInfo == null) {
                return null;
            }
            if (e.this.cne == null) {
                e.this.cne = new b();
            }
            String filePath = imageFileInfo.getFilePath();
            LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
            imageFileInfo.setPageActionsList(null);
            com.baidu.adp.widget.ImageView.a a = e.this.cne.a(imageFileInfo, true);
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
                b = e.this.b(a.oy(), 85);
            }
            imageFileInfo.setPageActionsList(pageActionsList);
            return b;
        }
    };
    private d cng = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.pk(imageFileInfo.getFilePath());
        }
    };
    private d cnh = this.cng;
    private d cni = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.b(e.this.pl(imageFileInfo.getFilePath()), 85);
        }
    };

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        String filePath = imageFileInfo.getFilePath();
        boolean mb = m.mb(filePath);
        boolean mc = m.mc(filePath);
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize() && !mc)) {
            if (mb) {
                dVar = this.cnh;
            } else {
                dVar = this.cng;
            }
        } else if (mb) {
            dVar = this.cni;
        } else {
            dVar = this.cnf;
        }
        return dVar.a(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap b(ImageFileInfo imageFileInfo) {
        com.baidu.adp.lib.f.e as;
        if (imageFileInfo == null) {
            return null;
        }
        if (this.cne == null) {
            this.cne = new b();
        }
        if (imageFileInfo.getImageType() == 0) {
            return this.cne.b(imageFileInfo, true);
        }
        if (imageFileInfo.getImageType() == 1 && (as = com.baidu.adp.lib.f.c.jB().as(20)) != null) {
            try {
                Object a = as.a(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), false, null);
                if (a instanceof com.baidu.adp.widget.ImageView.a) {
                    return ((com.baidu.adp.widget.ImageView.a) a).oy();
                }
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String pk(String str) {
        int i;
        long iC = m.iC(str);
        if (iC >= 20971520) {
            i = 60;
        } else if (iC >= 10485760 && iC < 20971520) {
            i = 75;
        } else if (iC >= 7340032 && iC < 10485760) {
            i = 85;
        } else {
            i = (iC < 5242880 || iC >= 7340032) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap pl = pl(str);
                if (readPictureDegree != 0 && pl != null) {
                    return b(BitmapHelper.rotateBitmapBydegree(pl, readPictureDegree), i);
                }
                return b(pl, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap pl(String str) {
        BitmapFactory.Options pm = pm(str);
        int i = pm.outWidth;
        int i2 = pm.outHeight;
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
                pm.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, pm);
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

    private BitmapFactory.Options pm(String str) {
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
