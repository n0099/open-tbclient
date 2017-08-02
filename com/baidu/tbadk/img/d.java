package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.d;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d {
    private b aFA;
    private a aFB;
    private Object aFC;
    private int bigHeight;
    private int bigWidth;
    private String from;
    private boolean isCancelled;
    private int smallHeight;
    private int smallWidth;
    private int aFz = 512000;
    private String groupId = "1";
    private w mNetwork = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, Object obj, long j, long j2);
    }

    public d(String str) {
        this.from = str;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(a aVar, Object obj) {
        this.aFB = aVar;
        this.aFC = obj;
        if (aVar != null) {
            this.aFz = 10240;
        }
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.fp();
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
            for (int i = 0; i < chosedFiles.size(); i++) {
                ImageFileInfo imageFileInfo = chosedFiles.get(i);
                if (imageFileInfo != null && !imageFileInfo.isAlreadyUploadedToServer()) {
                    if (!this.isCancelled) {
                        ImageUploadResult a2 = a(imageFileInfo, writeImagesInfo.isOriginalImg() || imageFileInfo.isGif(), z);
                        if (a2 != null && (uploadedPicInfo = a2.getUploadedPicInfo()) != null) {
                            imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                            imageFileInfo.serverPicInfo = a2.picInfo;
                        }
                    } else {
                        return;
                    }
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
        if (z && !imageFileInfo.hasActionsWithoutResize() && k.getFileSize(imageFileInfo.getFilePath()) <= 5242880) {
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
                    filePath = k.a(TbConfig.LOCAL_CAMERA_DIR, "camera.jpg", rotateBitmapBydegree, 95);
                    rotateBitmapBydegree.recycle();
                    if (decodeFile != null) {
                    }
                }
            } catch (Exception e) {
            }
            return f(filePath, z, z2);
        }
        if (this.aFA == null) {
            this.aFA = new b();
        }
        LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
        imageFileInfo.setPageActionsList(null);
        com.baidu.adp.widget.a.a a3 = this.aFA.a(imageFileInfo, true);
        if (a3 != null) {
            bitmap = a3.kN();
        } else {
            Bitmap b = this.aFA.b(imageFileInfo, true);
            try {
                int readPictureDegree2 = BitmapHelper.readPictureDegree(imageFileInfo.getFilePath());
                if (readPictureDegree2 != 0) {
                    bitmap = BitmapHelper.rotateBitmapBydegree(b, readPictureDegree2);
                    if (b != bitmap) {
                        b.recycle();
                    }
                } else {
                    bitmap = b;
                }
            } catch (Exception e2) {
                bitmap = b;
            }
        }
        imageFileInfo.setPageActionsList(pageActionsList);
        if (bitmap != null && (a2 = k.a(TbConfig.IMAGE_RESIZED_FILE, bitmap, 80)) != null) {
            return f(a2, z, z2);
        }
        return null;
    }

    public ImageUploadResult c(ImageFileInfo imageFileInfo, boolean z) {
        return a(imageFileInfo, false, z);
    }

    public ImageUploadResult s(String str, boolean z) {
        return f(str, false, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [490=4] */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0375, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x041f, code lost:
        r5 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0140, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02df, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
        r20.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x02f4, code lost:
        if (r12 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02f6, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02f7, code lost:
        r20.append(r5);
        r20.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0304, code lost:
        if (r12 == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0306, code lost:
        r20.append(r12.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x030d, code lost:
        r5 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03f7 A[Catch: all -> 0x0400, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0400, blocks: (B:26:0x0153, B:28:0x015a, B:29:0x0162, B:125:0x03f7), top: B:141:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x015a A[Catch: all -> 0x0400, TryCatch #0 {all -> 0x0400, blocks: (B:26:0x0153, B:28:0x015a, B:29:0x0162, B:125:0x03f7), top: B:141:0x0153 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult f(String str, boolean z, boolean z2) {
        RandomAccessFile randomAccessFile;
        Exception e;
        ImageUploadResult imageUploadResult;
        ImageUploadResult imageUploadResult2;
        RandomAccessFile randomAccessFile2;
        int i;
        byte[] bArr;
        ImageUploadResult imageUploadResult3 = null;
        RandomAccessFile randomAccessFile3 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                File file = new File(str);
                long length = file.length();
                long j = 0;
                String k = r.k(k.q(file));
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
                        imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.file_not_exist);
                        TiebaStatic.imgError(TbErrInfo.ERR_IMG_FILE, "file error: " + imageUploadResult.error_msg, sb.toString());
                        imageUploadResult2 = imageUploadResult;
                        randomAccessFile2 = null;
                    } catch (Exception e2) {
                        randomAccessFile = null;
                        e = e2;
                        try {
                            if (!this.isCancelled) {
                                sb.append("|request cancelled.");
                            } else {
                                BdLog.e(e.getMessage());
                            }
                            com.baidu.tbadk.core.d.a.a("img", -1L, -1, "imageUpload", imageUploadResult.error_code, imageUploadResult.error_msg, "comment", sb.toString());
                            com.baidu.adp.lib.g.a.b(randomAccessFile);
                            this.mNetwork = null;
                            return imageUploadResult;
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile3 = randomAccessFile;
                            com.baidu.adp.lib.g.a.b(randomAccessFile3);
                            this.mNetwork = null;
                            throw th;
                        }
                    }
                } else {
                    String str2 = k + this.aFz;
                    long j2 = length % ((long) this.aFz) == 0 ? length / this.aFz : (length / this.aFz) + 1;
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
                            while (true) {
                                long j3 = j;
                                i = i2;
                                imageUploadResult2 = imageUploadResult3;
                                if (i > j2) {
                                    break;
                                }
                                try {
                                    if (!this.isCancelled) {
                                        int i4 = 0;
                                        if (i > j2) {
                                            i4 = 0;
                                            bArr = null;
                                        } else {
                                            if (i < j2) {
                                                i4 = this.aFz;
                                            } else if (i == j2) {
                                                i4 = (int) (length - (this.aFz * (j2 - 1)));
                                            }
                                            if (bArr2 == null || bArr2.length != i4) {
                                                bArr2 = new byte[i4];
                                            }
                                            randomAccessFile2.seek(this.aFz * (i - 1));
                                            randomAccessFile2.read(bArr2, 0, i4);
                                            bArr = bArr2;
                                        }
                                        this.mNetwork = new w(TbConfig.UPLOAD_IMG_URL);
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
                                            int oR = h.oN().oR();
                                            if (oR != 0) {
                                                this.mNetwork.n("pic_water_type", String.valueOf(oR));
                                            }
                                            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                            if (!StringUtils.isNull(currentAccountName) && oR == 1) {
                                                this.mNetwork.n("user_name", currentAccountName);
                                            }
                                            String oS = h.oN().oS();
                                            if (!StringUtils.isNull(oS) && oR == 2) {
                                                this.mNetwork.n("forum_name", oS);
                                            }
                                        }
                                        String uG = this.mNetwork.uG();
                                        imageUploadResult3 = ImageUploadResult.parser(uG);
                                        if (uG == null || imageUploadResult3 == null) {
                                            break;
                                        }
                                        try {
                                            if (imageUploadResult3.error_code != 0 && imageUploadResult3.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                break;
                                            }
                                            if (imageUploadResult3.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                int i5 = i + 1;
                                                long j4 = j3 + i4;
                                                long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.aFz) : j4;
                                                if (this.aFB != null) {
                                                    this.aFB.a(str, this.aFC, j5, length);
                                                }
                                                i2 = i5;
                                                j = j4;
                                            } else if (i == imageUploadResult3.chunkNo || imageUploadResult3.chunkNo <= 0) {
                                                break;
                                            } else {
                                                i2 = imageUploadResult3.chunkNo;
                                                j = j3;
                                            }
                                            int i6 = i3 + 1;
                                            if (i6 > 2 * j2) {
                                                sb.append("|possbile dead loop found. tryCount=").append(i6).append(", chunkNo=").append(j2);
                                                imageUploadResult2 = imageUploadResult3;
                                                break;
                                            }
                                            i3 = i6;
                                            bArr2 = bArr;
                                        } catch (Exception e3) {
                                            e = e3;
                                            randomAccessFile = randomAccessFile2;
                                            imageUploadResult = imageUploadResult3;
                                        }
                                    } else {
                                        break;
                                    }
                                } catch (Exception e4) {
                                    randomAccessFile = randomAccessFile2;
                                    imageUploadResult = imageUploadResult2;
                                    e = e4;
                                }
                            }
                            imageUploadResult2 = null;
                            try {
                                sb.append("|startChunk=");
                                sb.append(i);
                            } catch (Exception e5) {
                                randomAccessFile = randomAccessFile2;
                                imageUploadResult = null;
                                e = e5;
                                if (!this.isCancelled) {
                                }
                                com.baidu.tbadk.core.d.a.a("img", -1L, -1, "imageUpload", imageUploadResult.error_code, imageUploadResult.error_msg, "comment", sb.toString());
                                com.baidu.adp.lib.g.a.b(randomAccessFile);
                                this.mNetwork = null;
                                return imageUploadResult;
                            }
                        } catch (Throwable th2) {
                            randomAccessFile3 = randomAccessFile2;
                            th = th2;
                            com.baidu.adp.lib.g.a.b(randomAccessFile3);
                            this.mNetwork = null;
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        randomAccessFile = randomAccessFile2;
                        imageUploadResult = null;
                    }
                }
                com.baidu.adp.lib.g.a.b(randomAccessFile2);
                this.mNetwork = null;
                return imageUploadResult2;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e7) {
            randomAccessFile = null;
            e = e7;
            imageUploadResult = null;
        }
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
