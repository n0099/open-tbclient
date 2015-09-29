package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.i;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c {
    private boolean auk;
    private b aul;
    private a aum;
    private Object aun;
    private int bigHeight;
    private int bigWidth;
    private String from;
    private int smallHeight;
    private int smallWidth;
    private int auj = 512000;
    private String groupId = "1";
    private w afg = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, Object obj, long j, long j2);
    }

    public c(String str) {
        this.from = str;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(a aVar, Object obj) {
        this.aum = aVar;
        this.aun = obj;
        if (aVar != null) {
            this.auj = 10240;
        }
    }

    public void cancel() {
        this.auk = true;
        if (this.afg != null) {
            this.afg.gJ();
        }
    }

    public boolean b(WriteImagesInfo writeImagesInfo) {
        UploadedImageInfo uploadedPicInfo;
        if (writeImagesInfo == null || writeImagesInfo.size() == 0) {
            return false;
        }
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        for (int i = 0; i < chosedFiles.size(); i++) {
            ImageFileInfo imageFileInfo = chosedFiles.get(i);
            if (!imageFileInfo.isAlreadyUploadedToServer()) {
                if (this.auk) {
                    break;
                }
                ImageUploadResult c = c(imageFileInfo, writeImagesInfo.isOriginalImg());
                if (c == null || (uploadedPicInfo = c.getUploadedPicInfo()) == null || TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                    return false;
                }
                imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
            }
        }
        return true;
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        UploadedImageInfo uploadedPicInfo;
        if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < chosedFiles.size()) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                    if (!imageFileInfo.isAlreadyUploadedToServer()) {
                        if (!this.auk) {
                            ImageUploadResult c = c(imageFileInfo, writeImagesInfo.isOriginalImg());
                            if (c != null && (uploadedPicInfo = c.getUploadedPicInfo()) != null) {
                                imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
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

    public ImageUploadResult c(ImageFileInfo imageFileInfo, boolean z) {
        Bitmap b;
        String a2;
        if (imageFileInfo == null) {
            return null;
        }
        if (z && !imageFileInfo.hasActionsWithoutResize() && n.cR(imageFileInfo.getFilePath()) <= 5242880) {
            return t(imageFileInfo.getFilePath(), z);
        }
        if (this.aul == null) {
            this.aul = new b();
        }
        LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
        imageFileInfo.setPageActionsList(null);
        com.baidu.adp.widget.a.a a3 = this.aul.a(imageFileInfo, true);
        if (a3 != null) {
            b = a3.na();
        } else {
            b = this.aul.b(imageFileInfo, true);
        }
        imageFileInfo.setPageActionsList(pageActionsList);
        if (b != null && (a2 = n.a(TbConfig.IMAGE_RESIZED_FILE, b, 80)) != null) {
            return t(a2, z);
        }
        return null;
    }

    public ImageUploadResult a(ImageFileInfo imageFileInfo) {
        return c(imageFileInfo, false);
    }

    public ImageUploadResult fp(String str) {
        return t(str, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0392, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0393, code lost:
        r12 = r10;
        r11 = null;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x03a1, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x013c, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r4 = r3;
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x024a, code lost:
        if (r11 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x024c, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x024d, code lost:
        r19.append(r3);
        r19.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0259, code lost:
        if (r11 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x025b, code lost:
        r19.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0262, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02fc, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x030e, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x031a, code lost:
        r4 = null;
        r3 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0371 A[Catch: all -> 0x037a, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x037a, blocks: (B:75:0x02b0, B:77:0x02b6, B:78:0x02bd, B:106:0x0371), top: B:128:0x02b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02b6 A[Catch: all -> 0x037a, TryCatch #4 {all -> 0x037a, blocks: (B:75:0x02b0, B:77:0x02b6, B:78:0x02bd, B:106:0x0371), top: B:128:0x02b0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult t(String str, boolean z) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        RandomAccessFile randomAccessFile2;
        Exception e;
        ImageUploadResult imageUploadResult;
        byte[] bArr;
        long j;
        ImageUploadResult imageUploadResult2 = null;
        RandomAccessFile randomAccessFile3 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                File file = new File(str);
                long length = file.length();
                String e2 = t.e(n.o(file));
                sb.append("path=");
                sb.append(str);
                sb.append("|length=");
                sb.append(length);
                sb.append("|md5=");
                sb.append(e2);
                if (length == 0 || e2 == null) {
                    imageUploadResult = new ImageUploadResult();
                    try {
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(i.h.file_not_exist);
                        TiebaStatic.imgError(TbErrInfo.ERR_IMG_FILE, "file error: " + imageUploadResult.error_msg, sb.toString());
                    } catch (Exception e3) {
                        randomAccessFile2 = null;
                        imageUploadResult2 = imageUploadResult;
                        e = e3;
                        try {
                            if (!this.auk) {
                                sb.append("|request cancelled.");
                            } else {
                                BdLog.e(e.getMessage());
                            }
                            com.baidu.tbadk.core.log.b.a("img", -1L, -1, "imageUpload", imageUploadResult2.error_code, imageUploadResult2.error_msg, "comment", sb.toString());
                            com.baidu.adp.lib.g.a.c(randomAccessFile2);
                            this.afg = null;
                            return imageUploadResult2;
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile = randomAccessFile2;
                            com.baidu.adp.lib.g.a.c(randomAccessFile);
                            this.afg = null;
                            throw th;
                        }
                    }
                } else {
                    String str2 = String.valueOf(e2) + this.auj;
                    long j2 = length % ((long) this.auj) == 0 ? length / this.auj : (length / this.auj) + 1;
                    sb.append("|chunkNo=");
                    sb.append(j2);
                    randomAccessFile = new RandomAccessFile(str, "r");
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
                            int i = 1;
                            int i2 = 0;
                            long j3 = 0;
                            while (true) {
                                int i3 = i;
                                randomAccessFile3 = imageUploadResult2;
                                if (i3 > j2) {
                                    imageUploadResult = randomAccessFile3;
                                    randomAccessFile3 = randomAccessFile;
                                    break;
                                }
                                try {
                                    if (this.auk) {
                                        break;
                                    }
                                    int i4 = 0;
                                    if (i3 > j2) {
                                        i4 = 0;
                                        bArr = null;
                                    } else {
                                        if (i3 < j2) {
                                            i4 = this.auj;
                                        } else if (i3 == j2) {
                                            i4 = (int) (length - (this.auj * (j2 - 1)));
                                        }
                                        if (bArr2 == null || bArr2.length != i4) {
                                            bArr2 = new byte[i4];
                                        }
                                        randomAccessFile.seek(this.auj * (i3 - 1));
                                        randomAccessFile.read(bArr2, 0, i4);
                                        bArr = bArr2;
                                    }
                                    this.afg = new w(TbConfig.UPLOAD_IMG_URL);
                                    this.afg.o("resourceId", str2);
                                    this.afg.o("chunkNo", String.valueOf(i3));
                                    if (i3 >= j2) {
                                        this.afg.o("isFinish", String.valueOf(1));
                                    } else {
                                        this.afg.o("isFinish", String.valueOf(0));
                                    }
                                    if (this.bigWidth > 0 && this.bigHeight > 0) {
                                        this.afg.o("width", String.valueOf(this.bigWidth));
                                        this.afg.o("height", String.valueOf(this.bigHeight));
                                    }
                                    if (this.smallWidth > 0 && this.smallHeight > 0) {
                                        this.afg.o("smallWidth", String.valueOf(this.smallWidth));
                                        this.afg.o("smallHeight", String.valueOf(this.smallHeight));
                                    }
                                    this.afg.o("groupId", String.valueOf(this.groupId));
                                    this.afg.o("alt", "json");
                                    if (bArr != null) {
                                        this.afg.d("chunk", bArr);
                                    }
                                    if (z) {
                                        this.afg.o("saveOrigin", "1");
                                    } else {
                                        this.afg.o("saveOrigin", "0");
                                    }
                                    String tJ = this.afg.tJ();
                                    imageUploadResult2 = ImageUploadResult.parser(tJ);
                                    if (tJ == null || imageUploadResult2 == null || !(imageUploadResult2.error_code == 0 || imageUploadResult2.error_code == ImageUploadResult.CHUNK_ERROR)) {
                                        break;
                                    }
                                    if (imageUploadResult2.error_code == ImageUploadResult.CHUNK_ERROR) {
                                        if (i3 == imageUploadResult2.chunkNo || imageUploadResult2.chunkNo <= 0) {
                                            break;
                                        }
                                        i = imageUploadResult2.chunkNo;
                                        j = j3;
                                    } else {
                                        int i5 = i3 + 1;
                                        long j4 = j3 + i4;
                                        long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.auj) : j4;
                                        if (this.aum != null) {
                                            this.aum.a(str, this.aun, j5, length);
                                        }
                                        i = i5;
                                        j = j4;
                                    }
                                    int i6 = i2 + 1;
                                    if (i6 > 2 * j2) {
                                        sb.append("|possbile dead loop found. tryCount=").append(i6).append(", chunkNo=").append(j2);
                                        randomAccessFile3 = randomAccessFile;
                                        imageUploadResult = imageUploadResult2;
                                        break;
                                    }
                                    i2 = i6;
                                    j3 = j;
                                    bArr2 = bArr;
                                } catch (Exception e4) {
                                    randomAccessFile2 = randomAccessFile;
                                    imageUploadResult2 = randomAccessFile3;
                                    e = e4;
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            randomAccessFile2 = randomAccessFile;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        com.baidu.adp.lib.g.a.c(randomAccessFile);
                        this.afg = null;
                        throw th;
                    }
                }
                com.baidu.adp.lib.g.a.c(randomAccessFile3);
                this.afg = null;
                return imageUploadResult;
            } catch (Exception e6) {
                randomAccessFile2 = null;
                e = e6;
            }
        } catch (Throwable th4) {
            randomAccessFile = null;
            th = th4;
        }
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
