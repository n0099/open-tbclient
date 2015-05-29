package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ac;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.t;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h {
    private Object amA;
    private e amy;
    private i amz;
    private int bigHeight;
    private int bigWidth;
    private String from;
    private boolean isCancelled;
    private int smallHeight;
    private int smallWidth;
    private int amx = 102400;
    private String groupId = "1";
    private aa aaG = null;

    public h(String str) {
        this.from = str;
    }

    public void f(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(i iVar, Object obj) {
        this.amz = iVar;
        this.amA = obj;
        if (iVar != null) {
            this.amx = 10240;
        }
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.aaG != null) {
            this.aaG.gS();
        }
    }

    public void a(WriteImagesInfo writeImagesInfo) {
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
                            ImageUploadResult a = a(imageFileInfo);
                            if (a != null && (uploadedPicInfo = a.getUploadedPicInfo()) != null) {
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
        String a;
        if (this.amy == null) {
            this.amy = new e(TbadkCoreApplication.m411getInst().getApp());
        }
        LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
        imageFileInfo.setPageActionsList(null);
        com.baidu.adp.widget.a.a a2 = this.amy.a(imageFileInfo, true);
        if (a2 != null) {
            b = a2.mS();
        } else {
            b = this.amy.b(imageFileInfo, true);
        }
        imageFileInfo.setPageActionsList(pageActionsList);
        if (b != null && (a = o.a(TbConfig.IMAGE_RESIZED_FILE, b, 80)) != null) {
            return eM(a);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x0387, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x013e, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r4 = r3;
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x023f, code lost:
        if (r11 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0241, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0242, code lost:
        r19.append(r3);
        r19.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x024e, code lost:
        if (r11 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0250, code lost:
        r19.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0257, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02da, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02ab A[Catch: all -> 0x0358, TryCatch #4 {all -> 0x0358, blocks: (B:73:0x02a5, B:75:0x02ab, B:76:0x02b2, B:99:0x034f), top: B:124:0x02a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x034f A[Catch: all -> 0x0358, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0358, blocks: (B:73:0x02a5, B:75:0x02ab, B:76:0x02b2, B:99:0x034f), top: B:124:0x02a5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult eM(String str) {
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
                String e2 = ac.e(o.n(file));
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
                        imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(t.file_not_exist);
                        TiebaStatic.imgError("", TbErrInfo.ERR_IMG_FILE, "file error: " + imageUploadResult.error_msg, sb.toString());
                    } catch (Exception e3) {
                        randomAccessFile = null;
                        imageUploadResult2 = imageUploadResult;
                        e = e3;
                        try {
                            if (!this.isCancelled) {
                                sb.append("|request cancelled.");
                            } else {
                                BdLog.e(e.getMessage());
                            }
                            com.baidu.tbadk.core.log.b.a("img", -1L, -1, "imageUpload", imageUploadResult2.error_code, imageUploadResult2.error_msg, "comment", sb.toString());
                            com.baidu.adp.lib.g.a.c(randomAccessFile);
                            this.aaG = null;
                            return imageUploadResult2;
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile;
                            com.baidu.adp.lib.g.a.c(randomAccessFile2);
                            this.aaG = null;
                            throw th;
                        }
                    }
                } else {
                    String str2 = String.valueOf(e2) + this.amx;
                    long j2 = length % ((long) this.amx) == 0 ? length / this.amx : (length / this.amx) + 1;
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
                                            i4 = this.amx;
                                        } else if (i == j2) {
                                            i4 = (int) (length - (this.amx * (j2 - 1)));
                                        }
                                        if (bArr2 == null || bArr2.length != i4) {
                                            bArr2 = new byte[i4];
                                        }
                                        randomAccessFile2.seek(this.amx * (i - 1));
                                        randomAccessFile2.read(bArr2, 0, i4);
                                        bArr = bArr2;
                                    }
                                    this.aaG = new aa(TbConfig.UPLOAD_IMG_URL);
                                    this.aaG.o("resourceId", str2);
                                    this.aaG.o("chunkNo", String.valueOf(i));
                                    if (i >= j2) {
                                        this.aaG.o("isFinish", String.valueOf(1));
                                    } else {
                                        this.aaG.o("isFinish", String.valueOf(0));
                                    }
                                    if (this.bigWidth > 0 && this.bigHeight > 0) {
                                        this.aaG.o("width", String.valueOf(this.bigWidth));
                                        this.aaG.o("height", String.valueOf(this.bigHeight));
                                    }
                                    if (this.smallWidth > 0 && this.smallHeight > 0) {
                                        this.aaG.o("smallWidth", String.valueOf(this.smallWidth));
                                        this.aaG.o("smallHeight", String.valueOf(this.smallHeight));
                                    }
                                    this.aaG.o("groupId", String.valueOf(this.groupId));
                                    this.aaG.o("alt", "json");
                                    if (bArr != null) {
                                        this.aaG.d("chunk", bArr);
                                    }
                                    String sz = this.aaG.sz();
                                    imageUploadResult2 = ImageUploadResult.parser(sz);
                                    if (sz == null || imageUploadResult2 == null || !(imageUploadResult2.error_code == 0 || imageUploadResult2.error_code == ImageUploadResult.CHUNK_ERROR)) {
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
                                        long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.amx) : j4;
                                        if (this.amz != null) {
                                            this.amz.a(str, this.amA, j5, length);
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
                                if (!this.isCancelled) {
                                }
                                com.baidu.tbadk.core.log.b.a("img", -1L, -1, "imageUpload", imageUploadResult2.error_code, imageUploadResult2.error_msg, "comment", sb.toString());
                                com.baidu.adp.lib.g.a.c(randomAccessFile);
                                this.aaG = null;
                                return imageUploadResult2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            com.baidu.adp.lib.g.a.c(randomAccessFile2);
                            this.aaG = null;
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        randomAccessFile = randomAccessFile2;
                    }
                }
                com.baidu.adp.lib.g.a.c(randomAccessFile3);
                this.aaG = null;
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
