package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.img.ImageUploadStrategy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e {
    public static final String fIQ = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/dynamicimgtmp";
    private b fIR;
    private ImageFileInfo fIT;
    private boolean fIS = false;
    private d fIU = new d() { // from class: com.baidu.tbadk.img.e.1
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            String a2;
            if (imageFileInfo == null) {
                return null;
            }
            if (e.this.fIR == null) {
                e.this.fIR = new b();
            }
            String filePath = imageFileInfo.getFilePath();
            LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
            imageFileInfo.setPageActionsList(null);
            com.baidu.adp.widget.ImageView.a a3 = e.this.fIR.a(imageFileInfo, true);
            if (a3 == null) {
                Bitmap b2 = e.this.b(imageFileInfo);
                if (b2 == null) {
                    return null;
                }
                int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                if (readPictureDegree != 0) {
                    b2 = BitmapHelper.rotateBitmapBydegree(b2, readPictureDegree);
                }
                a2 = e.this.a(b2, ImageUploadStrategy.FILE_SIZE_5M, 100);
            } else {
                a2 = e.this.a(a3.getRawBitmap(), ImageUploadStrategy.FILE_SIZE_5M, 100);
            }
            imageFileInfo.setPageActionsList(pageActionsList);
            return a2;
        }
    };
    private d fIV = new d() { // from class: com.baidu.tbadk.img.e.2
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.compressOriginalImageFile(imageFileInfo.getFilePath());
        }
    };
    private d fIW = this.fIV;
    private d fIX = new d() { // from class: com.baidu.tbadk.img.e.3
        @Override // com.baidu.tbadk.img.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.a(e.this.getUploadFileBitmap(imageFileInfo.getFilePath()), ImageUploadStrategy.FILE_SIZE_5M, 100);
        }
    };

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        String str;
        if (imageFileInfo == null) {
            return null;
        }
        this.fIT = imageFileInfo;
        String filePath = imageFileInfo.getFilePath();
        boolean checkIsLongImage = n.checkIsLongImage(filePath);
        boolean BJ = n.BJ(filePath);
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize() && !BJ)) {
            if (checkIsLongImage) {
                dVar = this.fIW;
                str = "原始·长图";
            } else {
                dVar = this.fIV;
                str = "原始·图";
            }
        } else if (checkIsLongImage) {
            dVar = this.fIX;
            str = "正常·长图";
        } else {
            dVar = this.fIU;
            str = "正常·图";
        }
        if (isDebugMode()) {
            int[] imageFileWH = n.getImageFileWH(filePath);
            Log.d("UPLOAD_IMG", "" + filePath + "\n   w =" + imageFileWH[0] + " h =" + imageFileWH[1] + "  size =" + (((float) n.getFileSize(filePath)) / 1048576.0f) + "MB\n   isLongImage =" + checkIsLongImage + "  isHeifImage =" + BJ + " resize =" + imageFileInfo.hasActionsWithoutResize() + " uploadStrategy =" + str);
        }
        String a2 = dVar.a(imageFileInfo);
        if (isDebugMode()) {
            int[] imageFileWH2 = n.getImageFileWH(a2);
            Log.d("UPLOAD_IMG", "temp =" + a2 + "\n   w =" + imageFileWH2[0] + " h =" + imageFileWH2[1] + "  size =" + (((float) n.getFileSize(a2)) / 1048576.0f) + "MB");
            return a2;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap b(ImageFileInfo imageFileInfo) {
        com.baidu.adp.lib.e.e ay;
        if (imageFileInfo == null) {
            return null;
        }
        if (this.fIR == null) {
            this.fIR = new b();
        }
        if (imageFileInfo.getImageType() == 0) {
            return this.fIR.b(imageFileInfo, true);
        }
        if (imageFileInfo.getImageType() == 1 && (ay = com.baidu.adp.lib.e.d.mx().ay(20)) != null) {
            try {
                Object a2 = ay.a(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, (com.baidu.adp.lib.e.b) null, null, imageFileInfo.getFilePath(), false, null);
                if (a2 instanceof com.baidu.adp.widget.ImageView.a) {
                    return ((com.baidu.adp.widget.ImageView.a) a2).getRawBitmap();
                }
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String compressOriginalImageFile(String str) {
        int i;
        long fileSize = n.getFileSize(str);
        if (fileSize >= 31457280) {
            i = 80;
        } else if (fileSize >= 20971520) {
            i = 85;
        } else if (fileSize >= 15728640) {
            i = 90;
        } else {
            i = fileSize >= 10485760 ? 95 : 100;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap uploadFileBitmap = getUploadFileBitmap(str);
                if (readPictureDegree != 0 && uploadFileBitmap != null) {
                    return a(BitmapHelper.rotateBitmapBydegree(uploadFileBitmap, readPictureDegree), 10485760L, i);
                }
                return a(uploadFileBitmap, 10485760L, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getUploadFileBitmap(String str) {
        BitmapFactory.Options newSizeBitmapOptions = newSizeBitmapOptions(str);
        int i = newSizeBitmapOptions.outWidth;
        int i2 = newSizeBitmapOptions.outHeight;
        if (i == 0 || i2 == 0) {
            return null;
        }
        Bitmap loadBitmap = BitmapHelper.loadBitmap(str);
        if (loadBitmap == null || loadBitmap.isRecycled()) {
            int i3 = 2;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= 3) {
                    return null;
                }
                newSizeBitmapOptions.inSampleSize = i3;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, newSizeBitmapOptions);
                if (loadBitmap2 == null || loadBitmap2.isRecycled()) {
                    i3 *= 2;
                    i4 = i5 + 1;
                } else {
                    return loadBitmap2;
                }
            }
        } else {
            return loadBitmap;
        }
    }

    private BitmapFactory.Options newSizeBitmapOptions(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Bitmap bitmap, long j, int i) {
        if (this.fIS) {
            if (this.fIT != null && !TextUtils.isEmpty(this.fIT.getFilePath())) {
                return n.a(fIQ, s.toMd5(this.fIT.toCachedKey(false)) + Ef(this.fIT.getFilePath()), bitmap, (float) j, i);
            }
            return "";
        }
        return n.compressBitmapToFile("img_upload_temp_file.temp", bitmap, (float) j, i);
    }

    private String Ef(String str) {
        if (TextUtils.isEmpty(str)) {
            return ".jpg";
        }
        try {
            String substring = str.substring(str.lastIndexOf("."));
            return !TextUtils.isEmpty(substring) ? substring : ".jpg";
        } catch (Exception e) {
            return ".jpg";
        }
    }

    public static boolean isDebugMode() {
        if (BdBaseApplication.getInst() == null) {
            return false;
        }
        return BdBaseApplication.getInst().isDebugMode();
    }
}
