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
    private b cnh;
    private d cni = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            String b;
            if (imageFileInfo == null) {
                return null;
            }
            if (e.this.cnh == null) {
                e.this.cnh = new b();
            }
            String filePath = imageFileInfo.getFilePath();
            LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
            imageFileInfo.setPageActionsList(null);
            com.baidu.adp.widget.ImageView.a a = e.this.cnh.a(imageFileInfo, true);
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
    private d cnj = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.pl(imageFileInfo.getFilePath());
        }
    };
    private d cnk = this.cnj;
    private d cnl = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.b(e.this.pm(imageFileInfo.getFilePath()), 85);
        }
    };

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        String filePath = imageFileInfo.getFilePath();
        boolean mc = m.mc(filePath);
        boolean md = m.md(filePath);
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize() && !md)) {
            if (mc) {
                dVar = this.cnk;
            } else {
                dVar = this.cnj;
            }
        } else if (mc) {
            dVar = this.cnl;
        } else {
            dVar = this.cni;
        }
        return dVar.a(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap b(ImageFileInfo imageFileInfo) {
        com.baidu.adp.lib.f.e ar;
        if (imageFileInfo == null) {
            return null;
        }
        if (this.cnh == null) {
            this.cnh = new b();
        }
        if (imageFileInfo.getImageType() == 0) {
            return this.cnh.b(imageFileInfo, true);
        }
        if (imageFileInfo.getImageType() == 1 && (ar = com.baidu.adp.lib.f.c.jB().ar(20)) != null) {
            try {
                Object a = ar.a(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), false, null);
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
    public String pl(String str) {
        int i;
        long iD = m.iD(str);
        if (iD >= 20971520) {
            i = 60;
        } else if (iD >= Config.FULL_TRACE_LOG_LIMIT && iD < 20971520) {
            i = 75;
        } else if (iD >= 7340032 && iD < Config.FULL_TRACE_LOG_LIMIT) {
            i = 85;
        } else {
            i = (iD < 5242880 || iD >= 7340032) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap pm = pm(str);
                if (readPictureDegree != 0 && pm != null) {
                    return b(BitmapHelper.rotateBitmapBydegree(pm, readPictureDegree), i);
                }
                return b(pm, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap pm(String str) {
        BitmapFactory.Options pn = pn(str);
        int i = pn.outWidth;
        int i2 = pn.outHeight;
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
                pn.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, pn);
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

    private BitmapFactory.Options pn(String str) {
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
