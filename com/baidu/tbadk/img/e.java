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
    private b cvp;
    private d cvq = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            String b;
            if (imageFileInfo == null) {
                return null;
            }
            if (e.this.cvp == null) {
                e.this.cvp = new b();
            }
            String filePath = imageFileInfo.getFilePath();
            LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
            imageFileInfo.setPageActionsList(null);
            com.baidu.adp.widget.ImageView.a a = e.this.cvp.a(imageFileInfo, true);
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
                b = e.this.b(a.ns(), 85);
            }
            imageFileInfo.setPageActionsList(pageActionsList);
            return b;
        }
    };
    private d cvr = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.qt(imageFileInfo.getFilePath());
        }
    };
    private d cvs = this.cvr;
    private d cvt = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.b(e.this.qu(imageFileInfo.getFilePath()), 85);
        }
    };

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        String filePath = imageFileInfo.getFilePath();
        boolean nk = m.nk(filePath);
        boolean nl = m.nl(filePath);
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize() && !nl)) {
            if (nk) {
                dVar = this.cvs;
            } else {
                dVar = this.cvr;
            }
        } else if (nk) {
            dVar = this.cvt;
        } else {
            dVar = this.cvq;
        }
        return dVar.a(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap b(ImageFileInfo imageFileInfo) {
        com.baidu.adp.lib.f.e ak;
        if (imageFileInfo == null) {
            return null;
        }
        if (this.cvp == null) {
            this.cvp = new b();
        }
        if (imageFileInfo.getImageType() == 0) {
            return this.cvp.b(imageFileInfo, true);
        }
        if (imageFileInfo.getImageType() == 1 && (ak = com.baidu.adp.lib.f.c.iv().ak(20)) != null) {
            try {
                Object a = ak.a(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), false, null);
                if (a instanceof com.baidu.adp.widget.ImageView.a) {
                    return ((com.baidu.adp.widget.ImageView.a) a).ns();
                }
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String qt(String str) {
        int i;
        long jn = m.jn(str);
        if (jn >= 20971520) {
            i = 60;
        } else if (jn >= Config.FULL_TRACE_LOG_LIMIT && jn < 20971520) {
            i = 75;
        } else if (jn >= 7340032 && jn < Config.FULL_TRACE_LOG_LIMIT) {
            i = 85;
        } else {
            i = (jn < 5242880 || jn >= 7340032) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap qu = qu(str);
                if (readPictureDegree != 0 && qu != null) {
                    return b(BitmapHelper.rotateBitmapBydegree(qu, readPictureDegree), i);
                }
                return b(qu, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap qu(String str) {
        BitmapFactory.Options qv = qv(str);
        int i = qv.outWidth;
        int i2 = qv.outHeight;
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
                qv.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, qv);
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

    private BitmapFactory.Options qv(String str) {
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
