package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
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
    public static final String eyb = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/dynamicimgtmp";
    private b eyc;
    private boolean eyd;
    private ImageFileInfo eyf;
    private d eyg;
    private d eyh;
    private d eyi;
    private d eyj;

    public e() {
        this.eyd = false;
        this.eyg = new d() { // from class: com.baidu.tbadk.img.e.1
            @Override // com.baidu.tbadk.img.d
            public String a(ImageFileInfo imageFileInfo) {
                String saveTempUploadFile;
                if (imageFileInfo == null) {
                    return null;
                }
                if (e.this.eyc == null) {
                    e.this.eyc = new b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                com.baidu.adp.widget.ImageView.a a = e.this.eyc.a(imageFileInfo, true);
                if (a == null) {
                    Bitmap b = e.this.b(imageFileInfo);
                    if (b == null) {
                        return null;
                    }
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0 && b != null) {
                        b = BitmapHelper.rotateBitmapBydegree(b, readPictureDegree);
                    }
                    saveTempUploadFile = e.this.saveTempUploadFile(b, 85);
                } else {
                    saveTempUploadFile = e.this.saveTempUploadFile(a.getRawBitmap(), 85);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
                return saveTempUploadFile;
            }
        };
        this.eyh = new d() { // from class: com.baidu.tbadk.img.e.2
            @Override // com.baidu.tbadk.img.d
            public String a(ImageFileInfo imageFileInfo) {
                if (imageFileInfo == null) {
                    return null;
                }
                return e.this.compressOriginalImageFile(imageFileInfo.getFilePath());
            }
        };
        this.eyi = this.eyh;
        this.eyj = new d() { // from class: com.baidu.tbadk.img.e.3
            @Override // com.baidu.tbadk.img.d
            public String a(ImageFileInfo imageFileInfo) {
                if (imageFileInfo == null) {
                    return null;
                }
                return e.this.saveTempUploadFile(e.this.getUploadFileBitmap(imageFileInfo.getFilePath()), 85);
            }
        };
    }

    public e(boolean z) {
        this.eyd = false;
        this.eyg = new d() { // from class: com.baidu.tbadk.img.e.1
            @Override // com.baidu.tbadk.img.d
            public String a(ImageFileInfo imageFileInfo) {
                String saveTempUploadFile;
                if (imageFileInfo == null) {
                    return null;
                }
                if (e.this.eyc == null) {
                    e.this.eyc = new b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                com.baidu.adp.widget.ImageView.a a = e.this.eyc.a(imageFileInfo, true);
                if (a == null) {
                    Bitmap b = e.this.b(imageFileInfo);
                    if (b == null) {
                        return null;
                    }
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0 && b != null) {
                        b = BitmapHelper.rotateBitmapBydegree(b, readPictureDegree);
                    }
                    saveTempUploadFile = e.this.saveTempUploadFile(b, 85);
                } else {
                    saveTempUploadFile = e.this.saveTempUploadFile(a.getRawBitmap(), 85);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
                return saveTempUploadFile;
            }
        };
        this.eyh = new d() { // from class: com.baidu.tbadk.img.e.2
            @Override // com.baidu.tbadk.img.d
            public String a(ImageFileInfo imageFileInfo) {
                if (imageFileInfo == null) {
                    return null;
                }
                return e.this.compressOriginalImageFile(imageFileInfo.getFilePath());
            }
        };
        this.eyi = this.eyh;
        this.eyj = new d() { // from class: com.baidu.tbadk.img.e.3
            @Override // com.baidu.tbadk.img.d
            public String a(ImageFileInfo imageFileInfo) {
                if (imageFileInfo == null) {
                    return null;
                }
                return e.this.saveTempUploadFile(e.this.getUploadFileBitmap(imageFileInfo.getFilePath()), 85);
            }
        };
        this.eyd = z;
    }

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        this.eyf = imageFileInfo;
        String filePath = imageFileInfo.getFilePath();
        boolean checkIsLongImage = n.checkIsLongImage(filePath);
        boolean wu = n.wu(filePath);
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize() && !wu)) {
            if (checkIsLongImage) {
                dVar = this.eyi;
            } else {
                dVar = this.eyh;
            }
        } else if (checkIsLongImage) {
            dVar = this.eyj;
        } else {
            dVar = this.eyg;
        }
        return dVar.a(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap b(ImageFileInfo imageFileInfo) {
        com.baidu.adp.lib.e.e an;
        if (imageFileInfo == null) {
            return null;
        }
        if (this.eyc == null) {
            this.eyc = new b();
        }
        if (imageFileInfo.getImageType() == 0) {
            return this.eyc.b(imageFileInfo, true);
        }
        if (imageFileInfo.getImageType() == 1 && (an = com.baidu.adp.lib.e.c.ln().an(20)) != null) {
            try {
                Object a = an.a(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), false, null);
                if (a instanceof com.baidu.adp.widget.ImageView.a) {
                    return ((com.baidu.adp.widget.ImageView.a) a).getRawBitmap();
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
        if (fileSize >= 20971520) {
            i = 60;
        } else if (fileSize >= 10485760 && fileSize < 20971520) {
            i = 75;
        } else if (fileSize >= ImageUploadStrategy.FILE_SIZE_7M && fileSize < 10485760) {
            i = 85;
        } else {
            i = (fileSize < ImageUploadStrategy.FILE_SIZE_5M || fileSize >= ImageUploadStrategy.FILE_SIZE_7M) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap uploadFileBitmap = getUploadFileBitmap(str);
                if (readPictureDegree != 0 && uploadFileBitmap != null) {
                    return saveTempUploadFile(BitmapHelper.rotateBitmapBydegree(uploadFileBitmap, readPictureDegree), i);
                }
                return saveTempUploadFile(uploadFileBitmap, i);
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
            int i3 = 0;
            int i4 = 1;
            while (true) {
                int i5 = i3;
                if (i5 >= 3) {
                    return null;
                }
                newSizeBitmapOptions.inSampleSize = i4 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, newSizeBitmapOptions);
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

    private BitmapFactory.Options newSizeBitmapOptions(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String saveTempUploadFile(Bitmap bitmap, int i) {
        if (this.eyd) {
            if (this.eyf != null && !TextUtils.isEmpty(this.eyf.getFilePath())) {
                return n.a(eyb, s.toMd5(this.eyf.toCachedKey(false)) + yP(this.eyf.getFilePath()), bitmap, 5242880.0f, i);
            }
            return "";
        }
        return n.compressBitmapToFile("img_upload_temp_file.temp", bitmap, 5242880.0f, i);
    }

    private String yP(String str) {
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
}
