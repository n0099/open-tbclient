package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.i;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c {
    private boolean avN;
    private b avO;
    private a avP;
    private Object avQ;
    private int bigHeight;
    private int bigWidth;
    private String from;
    private int smallHeight;
    private int smallWidth;
    private int avM = 102400;
    private String groupId = "1";
    private v afT = null;

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
        this.avP = aVar;
        this.avQ = obj;
        if (aVar != null) {
            this.avM = 10240;
        }
    }

    public void cancel() {
        this.avN = true;
        if (this.afT != null) {
            this.afT.gJ();
        }
    }

    public void b(WriteImagesInfo writeImagesInfo) {
        UploadedImageInfo uploadedPicInfo;
        if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < chosedFiles.size()) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                    if (!imageFileInfo.isAlreadyUploadedToServer()) {
                        if (!this.avN) {
                            ImageUploadResult a2 = a(imageFileInfo);
                            if (a2 != null && (uploadedPicInfo = a2.getUploadedPicInfo()) != null) {
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

    public ImageUploadResult a(ImageFileInfo imageFileInfo) {
        Bitmap b;
        String a2;
        if (this.avO == null) {
            this.avO = new b();
        }
        LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
        imageFileInfo.setPageActionsList(null);
        com.baidu.adp.widget.a.a a3 = this.avO.a(imageFileInfo, true);
        if (a3 != null) {
            b = a3.mZ();
        } else {
            b = this.avO.b(imageFileInfo, true);
        }
        imageFileInfo.setPageActionsList(pageActionsList);
        if (b != null && (a2 = n.a(TbConfig.IMAGE_RESIZED_FILE, b, 80)) != null) {
            return fk(a2);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x0385, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x013c, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r4 = r3;
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x023d, code lost:
        if (r11 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x023f, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0240, code lost:
        r19.append(r3);
        r19.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x024c, code lost:
        if (r11 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x024e, code lost:
        r19.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0255, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02d8, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02a9 A[Catch: all -> 0x0356, TryCatch #4 {all -> 0x0356, blocks: (B:73:0x02a3, B:75:0x02a9, B:76:0x02b0, B:99:0x034d), top: B:126:0x02a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x034d A[Catch: all -> 0x0356, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0356, blocks: (B:73:0x02a3, B:75:0x02a9, B:76:0x02b0, B:99:0x034d), top: B:126:0x02a3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult fk(String str) {
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
                        randomAccessFile = null;
                        imageUploadResult2 = imageUploadResult;
                        e = e3;
                        try {
                            if (!this.avN) {
                                sb.append("|request cancelled.");
                            } else {
                                BdLog.e(e.getMessage());
                            }
                            com.baidu.tbadk.core.log.b.a("img", -1L, -1, "imageUpload", imageUploadResult2.error_code, imageUploadResult2.error_msg, "comment", sb.toString());
                            com.baidu.adp.lib.g.a.b(randomAccessFile);
                            this.afT = null;
                            return imageUploadResult2;
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile;
                            com.baidu.adp.lib.g.a.b(randomAccessFile2);
                            this.afT = null;
                            throw th;
                        }
                    }
                } else {
                    String str2 = String.valueOf(e2) + this.avM;
                    long j2 = length % ((long) this.avM) == 0 ? length / this.avM : (length / this.avM) + 1;
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
                                    if (this.avN) {
                                        break;
                                    }
                                    int i4 = 0;
                                    if (i > j2) {
                                        i4 = 0;
                                        bArr = null;
                                    } else {
                                        if (i < j2) {
                                            i4 = this.avM;
                                        } else if (i == j2) {
                                            i4 = (int) (length - (this.avM * (j2 - 1)));
                                        }
                                        if (bArr2 == null || bArr2.length != i4) {
                                            bArr2 = new byte[i4];
                                        }
                                        randomAccessFile2.seek(this.avM * (i - 1));
                                        randomAccessFile2.read(bArr2, 0, i4);
                                        bArr = bArr2;
                                    }
                                    this.afT = new v(TbConfig.UPLOAD_IMG_URL);
                                    this.afT.o("resourceId", str2);
                                    this.afT.o("chunkNo", String.valueOf(i));
                                    if (i >= j2) {
                                        this.afT.o("isFinish", String.valueOf(1));
                                    } else {
                                        this.afT.o("isFinish", String.valueOf(0));
                                    }
                                    if (this.bigWidth > 0 && this.bigHeight > 0) {
                                        this.afT.o("width", String.valueOf(this.bigWidth));
                                        this.afT.o("height", String.valueOf(this.bigHeight));
                                    }
                                    if (this.smallWidth > 0 && this.smallHeight > 0) {
                                        this.afT.o("smallWidth", String.valueOf(this.smallWidth));
                                        this.afT.o("smallHeight", String.valueOf(this.smallHeight));
                                    }
                                    this.afT.o("groupId", String.valueOf(this.groupId));
                                    this.afT.o("alt", "json");
                                    if (bArr != null) {
                                        this.afT.d("chunk", bArr);
                                    }
                                    String tL = this.afT.tL();
                                    imageUploadResult2 = ImageUploadResult.parser(tL);
                                    if (tL == null || imageUploadResult2 == null || !(imageUploadResult2.error_code == 0 || imageUploadResult2.error_code == ImageUploadResult.CHUNK_ERROR)) {
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
                                        long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.avM) : j4;
                                        if (this.avP != null) {
                                            this.avP.a(str, this.avQ, j5, length);
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
                                } catch (Exception e4) {
                                    randomAccessFile = randomAccessFile2;
                                    imageUploadResult2 = randomAccessFile3;
                                    e = e4;
                                }
                            }
                            try {
                                sb.append("|startChunk=");
                                sb.append(i);
                                imageUploadResult = null;
                                randomAccessFile3 = randomAccessFile2;
                            } catch (Exception e5) {
                                randomAccessFile = randomAccessFile2;
                                imageUploadResult2 = null;
                                e = e5;
                                if (!this.avN) {
                                }
                                com.baidu.tbadk.core.log.b.a("img", -1L, -1, "imageUpload", imageUploadResult2.error_code, imageUploadResult2.error_msg, "comment", sb.toString());
                                com.baidu.adp.lib.g.a.b(randomAccessFile);
                                this.afT = null;
                                return imageUploadResult2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            com.baidu.adp.lib.g.a.b(randomAccessFile2);
                            this.afT = null;
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        randomAccessFile = randomAccessFile2;
                    }
                }
                com.baidu.adp.lib.g.a.b(randomAccessFile3);
                this.afT = null;
                return imageUploadResult;
            } catch (Throwable th4) {
                randomAccessFile2 = null;
                th = th4;
            }
        } catch (Exception e7) {
            randomAccessFile = null;
            e = e7;
        }
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
