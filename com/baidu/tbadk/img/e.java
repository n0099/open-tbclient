package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.img.ImageUploadStrategy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e {
    public static final String eaZ = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/dynamicimgtmp";
    private b eba;
    private boolean ebb;
    private ImageFileInfo ebc;
    private d ebd;
    private d ebe;
    private d ebf;
    private d ebg;

    public e() {
        this.ebb = false;
        this.ebd = new d() { // from class: com.baidu.tbadk.img.e.1
            @Override // com.baidu.tbadk.img.d
            public String a(ImageFileInfo imageFileInfo) {
                String saveTempUploadFile;
                if (imageFileInfo == null) {
                    return null;
                }
                if (e.this.eba == null) {
                    e.this.eba = new b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                com.baidu.adp.widget.ImageView.a a = e.this.eba.a(imageFileInfo, true);
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
        this.ebe = new d() { // from class: com.baidu.tbadk.img.e.2
            @Override // com.baidu.tbadk.img.d
            public String a(ImageFileInfo imageFileInfo) {
                if (imageFileInfo == null) {
                    return null;
                }
                return e.this.compressOriginalImageFile(imageFileInfo.getFilePath());
            }
        };
        this.ebf = this.ebe;
        this.ebg = new d() { // from class: com.baidu.tbadk.img.e.3
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
        this.ebb = false;
        this.ebd = new d() { // from class: com.baidu.tbadk.img.e.1
            @Override // com.baidu.tbadk.img.d
            public String a(ImageFileInfo imageFileInfo) {
                String saveTempUploadFile;
                if (imageFileInfo == null) {
                    return null;
                }
                if (e.this.eba == null) {
                    e.this.eba = new b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                com.baidu.adp.widget.ImageView.a a = e.this.eba.a(imageFileInfo, true);
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
        this.ebe = new d() { // from class: com.baidu.tbadk.img.e.2
            @Override // com.baidu.tbadk.img.d
            public String a(ImageFileInfo imageFileInfo) {
                if (imageFileInfo == null) {
                    return null;
                }
                return e.this.compressOriginalImageFile(imageFileInfo.getFilePath());
            }
        };
        this.ebf = this.ebe;
        this.ebg = new d() { // from class: com.baidu.tbadk.img.e.3
            @Override // com.baidu.tbadk.img.d
            public String a(ImageFileInfo imageFileInfo) {
                if (imageFileInfo == null) {
                    return null;
                }
                return e.this.saveTempUploadFile(e.this.getUploadFileBitmap(imageFileInfo.getFilePath()), 85);
            }
        };
        this.ebb = z;
    }

    public String c(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        if (imageFileInfo == null) {
            return null;
        }
        this.ebc = imageFileInfo;
        String filePath = imageFileInfo.getFilePath();
        boolean checkIsLongImage = m.checkIsLongImage(filePath);
        boolean uy = m.uy(filePath);
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize() && !uy)) {
            if (checkIsLongImage) {
                dVar = this.ebf;
            } else {
                dVar = this.ebe;
            }
        } else if (checkIsLongImage) {
            dVar = this.ebg;
        } else {
            dVar = this.ebd;
        }
        return dVar.a(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap b(ImageFileInfo imageFileInfo) {
        com.baidu.adp.lib.e.e ag;
        if (imageFileInfo == null) {
            return null;
        }
        if (this.eba == null) {
            this.eba = new b();
        }
        if (imageFileInfo.getImageType() == 0) {
            return this.eba.b(imageFileInfo, true);
        }
        if (imageFileInfo.getImageType() == 1 && (ag = com.baidu.adp.lib.e.c.kV().ag(20)) != null) {
            try {
                Object a = ag.a(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), false, null);
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
        long fileSize = m.getFileSize(str);
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
        if (this.ebb) {
            if (this.ebc != null && !TextUtils.isEmpty(this.ebc.getFilePath())) {
                return m.a(eaZ, s.toMd5(this.ebc.toCachedKey(false)) + wQ(this.ebc.getFilePath()), bitmap, 5242880.0f, i);
            }
            return "";
        }
        return m.compressBitmapToFile("img_upload_temp_file.temp", bitmap, 5242880.0f, i);
    }

    private String wQ(String str) {
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
