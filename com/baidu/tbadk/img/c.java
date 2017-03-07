package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.w;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c {
    private b aDa;
    private a aDb;
    private Object aDc;
    private int bigHeight;
    private int bigWidth;
    private String from;
    private boolean isCancelled;
    private int smallHeight;
    private int smallWidth;
    private int aCZ = 512000;
    private String groupId = "1";
    private z mNetwork = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, Object obj, long j, long j2);
    }

    public c(String str) {
        this.from = str;
    }

    public void g(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(a aVar, Object obj) {
        this.aDb = aVar;
        this.aDc = obj;
        if (aVar != null) {
            this.aCZ = 10240;
        }
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.fm();
        }
    }

    public boolean b(WriteImagesInfo writeImagesInfo, boolean z) {
        UploadedImageInfo uploadedPicInfo;
        if (writeImagesInfo == null || writeImagesInfo.size() == 0) {
            return false;
        }
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        for (int i = 0; i < chosedFiles.size(); i++) {
            ImageFileInfo imageFileInfo = chosedFiles.get(i);
            if (!imageFileInfo.isAlreadyUploadedToServer()) {
                if (this.isCancelled) {
                    break;
                }
                ImageUploadResult a2 = a(imageFileInfo, writeImagesInfo.isOriginalImg(), z);
                if (a2 == null || (uploadedPicInfo = a2.getUploadedPicInfo()) == null || TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                    return false;
                }
                imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
            }
        }
        return true;
    }

    public void c(WriteImagesInfo writeImagesInfo, boolean z) {
        UploadedImageInfo uploadedPicInfo;
        if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < chosedFiles.size()) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                    if (!imageFileInfo.isAlreadyUploadedToServer()) {
                        if (!this.isCancelled) {
                            ImageUploadResult a2 = a(imageFileInfo, writeImagesInfo.isOriginalImg(), z);
                            if (a2 != null && (uploadedPicInfo = a2.getUploadedPicInfo()) != null) {
                                imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                                imageFileInfo.serverPicInfo = a2.picInfo;
                            }
                        } else {
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public ImageUploadResult a(ImageFileInfo imageFileInfo, boolean z, boolean z2) {
        Bitmap bitmap;
        String a2;
        if (imageFileInfo == null) {
            return null;
        }
        if (z && !imageFileInfo.hasActionsWithoutResize() && l.getFileSize(imageFileInfo.getFilePath()) <= 5242880) {
            String filePath = imageFileInfo.getFilePath();
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(imageFileInfo.getFilePath());
                if (readPictureDegree != 0) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    Bitmap decodeFile = BitmapFactory.decodeFile(imageFileInfo.getFilePath(), options);
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(imageFileInfo.getFilePath(), options.outWidth, options.outHeight);
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    filePath = l.a(TbConfig.LOCAL_CAMERA_DIR, "camera.jpg", rotateBitmapBydegree, 95);
                    rotateBitmapBydegree.recycle();
                    if (decodeFile != null) {
                    }
                }
            } catch (Exception e) {
            }
            return f(filePath, z, z2);
        }
        if (this.aDa == null) {
            this.aDa = new b();
        }
        LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
        imageFileInfo.setPageActionsList(null);
        com.baidu.adp.widget.a.a a3 = this.aDa.a(imageFileInfo, true);
        if (a3 != null) {
            bitmap = a3.kN();
        } else {
            Bitmap b = this.aDa.b(imageFileInfo, true);
            try {
                int readPictureDegree2 = BitmapHelper.readPictureDegree(imageFileInfo.getFilePath());
                if (readPictureDegree2 != 0) {
                    bitmap = BitmapHelper.rotateBitmapBydegree(b, readPictureDegree2);
                    if (b != bitmap) {
                        b.recycle();
                    }
                }
            } catch (Exception e2) {
            }
            bitmap = b;
        }
        imageFileInfo.setPageActionsList(pageActionsList);
        if (bitmap != null && (a2 = l.a(TbConfig.IMAGE_RESIZED_FILE, bitmap, 80)) != null) {
            return f(a2, z, z2);
        }
        return null;
    }

    public ImageUploadResult c(ImageFileInfo imageFileInfo, boolean z) {
        return a(imageFileInfo, false, z);
    }

    public ImageUploadResult u(String str, boolean z) {
        return f(str, false, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x03ff, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0144, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r4 = r3;
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02a4, code lost:
        if (r11 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02a6, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x02a7, code lost:
        r19.append(r3);
        r19.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02b4, code lost:
        if (r11 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02b6, code lost:
        r19.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02bd, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0358, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03cf A[Catch: all -> 0x03d8, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x03d8, blocks: (B:89:0x030b, B:91:0x0311, B:92:0x0319, B:120:0x03cf), top: B:140:0x030b }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0311 A[Catch: all -> 0x03d8, TryCatch #2 {all -> 0x03d8, blocks: (B:89:0x030b, B:91:0x0311, B:92:0x0319, B:120:0x03cf), top: B:140:0x030b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult f(String str, boolean z, boolean z2) {
        RandomAccessFile randomAccessFile;
        Exception e;
        RandomAccessFile randomAccessFile2;
        Throwable th;
        ImageUploadResult imageUploadResult;
        int i;
        byte[] bArr;
        long j;
        ImageUploadResult imageUploadResult2 = null;
        RandomAccessFile randomAccessFile3 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                File file = new File(str);
                long length = file.length();
                String k = t.k(l.n(file));
                sb.append("path=");
                sb.append(str);
                sb.append("|length=");
                sb.append(length);
                sb.append("|md5=");
                sb.append(k);
                if (length == 0 || k == null) {
                    imageUploadResult = new ImageUploadResult();
                    try {
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.file_not_exist);
                        TiebaStatic.imgError(TbErrInfo.ERR_IMG_FILE, "file error: " + imageUploadResult.error_msg, sb.toString());
                    } catch (Exception e2) {
                        randomAccessFile = null;
                        imageUploadResult2 = imageUploadResult;
                        e = e2;
                        try {
                            if (!this.isCancelled) {
                            }
                            com.baidu.tbadk.core.log.b.a("img", -1L, -1, "imageUpload", imageUploadResult2.error_code, imageUploadResult2.error_msg, "comment", sb.toString());
                            com.baidu.adp.lib.g.a.b(randomAccessFile);
                            this.mNetwork = null;
                            return imageUploadResult2;
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile;
                            com.baidu.adp.lib.g.a.b(randomAccessFile2);
                            this.mNetwork = null;
                            throw th;
                        }
                    }
                } else {
                    String str2 = String.valueOf(k) + this.aCZ;
                    long j2 = length % ((long) this.aCZ) == 0 ? length / this.aCZ : (length / this.aCZ) + 1;
                    sb.append("|chunkNo=");
                    sb.append(j2);
                    randomAccessFile2 = new RandomAccessFile(str, "r");
                    byte[] bArr2 = null;
                    try {
                        try {
                            sb.append("|width=");
                            sb.append(this.bigWidth);
                            sb.append("|height=");
                            sb.append(this.bigHeight);
                            sb.append("|smallWidth=");
                            sb.append(this.smallWidth);
                            sb.append("|smallHeight=");
                            sb.append(this.smallHeight);
                            sb.append("|groupId=");
                            sb.append(this.groupId);
                            int i2 = 1;
                            int i3 = 0;
                            long j3 = 0;
                            while (true) {
                                i = i2;
                                randomAccessFile3 = imageUploadResult2;
                                if (i > j2) {
                                    imageUploadResult = randomAccessFile3;
                                    randomAccessFile3 = randomAccessFile2;
                                    break;
                                }
                                try {
                                    if (this.isCancelled) {
                                        break;
                                    }
                                    int i4 = 0;
                                    if (i > j2) {
                                        i4 = 0;
                                        bArr = null;
                                    } else {
                                        if (i < j2) {
                                            i4 = this.aCZ;
                                        } else if (i == j2) {
                                            i4 = (int) (length - (this.aCZ * (j2 - 1)));
                                        }
                                        if (bArr2 == null || bArr2.length != i4) {
                                            bArr2 = new byte[i4];
                                        }
                                        randomAccessFile2.seek(this.aCZ * (i - 1));
                                        randomAccessFile2.read(bArr2, 0, i4);
                                        bArr = bArr2;
                                    }
                                    this.mNetwork = new z(TbConfig.UPLOAD_IMG_URL);
                                    this.mNetwork.n("resourceId", str2);
                                    this.mNetwork.n("chunkNo", String.valueOf(i));
                                    if (i >= j2) {
                                        this.mNetwork.n("isFinish", String.valueOf(1));
                                    } else {
                                        this.mNetwork.n("isFinish", String.valueOf(0));
                                    }
                                    if (this.bigWidth > 0 && this.bigHeight > 0) {
                                        this.mNetwork.n("width", String.valueOf(this.bigWidth));
                                        this.mNetwork.n("height", String.valueOf(this.bigHeight));
                                    }
                                    if (this.smallWidth > 0 && this.smallHeight > 0) {
                                        this.mNetwork.n("smallWidth", String.valueOf(this.smallWidth));
                                        this.mNetwork.n("smallHeight", String.valueOf(this.smallHeight));
                                    }
                                    this.mNetwork.n("groupId", String.valueOf(this.groupId));
                                    this.mNetwork.n("alt", "json");
                                    if (bArr != null) {
                                        this.mNetwork.d("chunk", bArr);
                                    }
                                    if (z) {
                                        this.mNetwork.n("saveOrigin", "1");
                                    } else {
                                        this.mNetwork.n("saveOrigin", "0");
                                    }
                                    if (z2) {
                                        int oU = com.baidu.tbadk.core.l.oQ().oU();
                                        if (oU != 0) {
                                            this.mNetwork.n("pic_water_type", String.valueOf(oU));
                                        }
                                        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                        if (!StringUtils.isNull(currentAccountName) && oU == 1) {
                                            this.mNetwork.n("user_name", currentAccountName);
                                        }
                                        String oV = com.baidu.tbadk.core.l.oQ().oV();
                                        if (!StringUtils.isNull(oV) && oU == 2) {
                                            this.mNetwork.n("forum_name", oV);
                                        }
                                    }
                                    String uE = this.mNetwork.uE();
                                    imageUploadResult2 = ImageUploadResult.parser(uE);
                                    if (uE == null || imageUploadResult2 == null || !(imageUploadResult2.error_code == 0 || imageUploadResult2.error_code == ImageUploadResult.CHUNK_ERROR)) {
                                        break;
                                    }
                                    if (imageUploadResult2.error_code == ImageUploadResult.CHUNK_ERROR) {
                                        if (i == imageUploadResult2.chunkNo || imageUploadResult2.chunkNo <= 0) {
                                            break;
                                        }
                                        i2 = imageUploadResult2.chunkNo;
                                        j = j3;
                                    } else {
                                        int i5 = i + 1;
                                        long j4 = j3 + i4;
                                        long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.aCZ) : j4;
                                        if (this.aDb != null) {
                                            this.aDb.a(str, this.aDc, j5, length);
                                        }
                                        i2 = i5;
                                        j = j4;
                                    }
                                    int i6 = i3 + 1;
                                    if (i6 > 2 * j2) {
                                        sb.append("|possbile dead loop found. tryCount=").append(i6).append(", chunkNo=").append(j2);
                                        randomAccessFile3 = randomAccessFile2;
                                        imageUploadResult = imageUploadResult2;
                                        break;
                                    }
                                    i3 = i6;
                                    j3 = j;
                                    bArr2 = bArr;
                                } catch (Exception e3) {
                                    randomAccessFile = randomAccessFile2;
                                    imageUploadResult2 = randomAccessFile3;
                                    e = e3;
                                }
                            }
                            try {
                                sb.append("|startChunk=");
                                sb.append(i);
                                imageUploadResult = null;
                                randomAccessFile3 = randomAccessFile2;
                            } catch (Exception e4) {
                                randomAccessFile = randomAccessFile2;
                                imageUploadResult2 = null;
                                e = e4;
                                if (!this.isCancelled) {
                                    sb.append("|request cancelled.");
                                } else {
                                    BdLog.e(e.getMessage());
                                }
                                com.baidu.tbadk.core.log.b.a("img", -1L, -1, "imageUpload", imageUploadResult2.error_code, imageUploadResult2.error_msg, "comment", sb.toString());
                                com.baidu.adp.lib.g.a.b(randomAccessFile);
                                this.mNetwork = null;
                                return imageUploadResult2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            randomAccessFile = randomAccessFile2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        com.baidu.adp.lib.g.a.b(randomAccessFile2);
                        this.mNetwork = null;
                        throw th;
                    }
                }
                com.baidu.adp.lib.g.a.b(randomAccessFile3);
                this.mNetwork = null;
                return imageUploadResult;
            } catch (Throwable th4) {
                randomAccessFile2 = null;
                th = th4;
            }
        } catch (Exception e6) {
            randomAccessFile = null;
            e = e6;
        }
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
