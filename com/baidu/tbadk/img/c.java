package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.t;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c {
    private a axA;
    private Object axB;
    private boolean axy;
    private b axz;
    private int bigHeight;
    private int bigWidth;
    private String from;
    private int smallHeight;
    private int smallWidth;
    private int axx = 512000;
    private String groupId = "1";
    private aa aiG = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, Object obj, long j, long j2);
    }

    public c(String str) {
        this.from = str;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(a aVar, Object obj) {
        this.axA = aVar;
        this.axB = obj;
        if (aVar != null) {
            this.axx = 10240;
        }
    }

    public void cancel() {
        this.axy = true;
        if (this.aiG != null) {
            this.aiG.gT();
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
                if (this.axy) {
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
                        if (!this.axy) {
                            ImageUploadResult a2 = a(imageFileInfo, writeImagesInfo.isOriginalImg(), z);
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

    public ImageUploadResult a(ImageFileInfo imageFileInfo, boolean z, boolean z2) {
        Bitmap b;
        String a2;
        if (imageFileInfo == null) {
            return null;
        }
        if (z && !imageFileInfo.hasActionsWithoutResize() && m.da(imageFileInfo.getFilePath()) <= 5242880) {
            return f(imageFileInfo.getFilePath(), z, z2);
        }
        if (this.axz == null) {
            this.axz = new b();
        }
        LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
        imageFileInfo.setPageActionsList(null);
        com.baidu.adp.widget.a.a a3 = this.axz.a(imageFileInfo, true);
        if (a3 != null) {
            b = a3.mS();
        } else {
            b = this.axz.b(imageFileInfo, true);
        }
        imageFileInfo.setPageActionsList(pageActionsList);
        if (b != null && (a2 = m.a(TbConfig.IMAGE_RESIZED_FILE, b, 80)) != null) {
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

    /* JADX WARN: Code restructure failed: missing block: B:107:0x035b, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0367, code lost:
        r4 = null;
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x03be, code lost:
        com.baidu.adp.lib.util.BdLog.e(r3.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x03df, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x03e0, code lost:
        r12 = r10;
        r11 = null;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x013c, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r4 = r3;
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0303, code lost:
        r19.append("|request cancelled.");
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03be A[Catch: all -> 0x03c7, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x03c7, blocks: (B:89:0x02fd, B:91:0x0303, B:92:0x030a, B:120:0x03be), top: B:141:0x02fd }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0303 A[Catch: all -> 0x03c7, TryCatch #3 {all -> 0x03c7, blocks: (B:89:0x02fd, B:91:0x0303, B:92:0x030a, B:120:0x03be), top: B:141:0x02fd }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult f(String str, boolean z, boolean z2) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        RandomAccessFile randomAccessFile2;
        Exception e;
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
                String f = t.f(m.o(file));
                sb.append("path=");
                sb.append(str);
                sb.append("|length=");
                sb.append(length);
                sb.append("|md5=");
                sb.append(f);
                if (length == 0 || f == null) {
                    imageUploadResult = new ImageUploadResult();
                    try {
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(t.j.file_not_exist);
                        TiebaStatic.imgError(TbErrInfo.ERR_IMG_FILE, "file error: " + imageUploadResult.error_msg, sb.toString());
                    } catch (Exception e2) {
                        randomAccessFile2 = null;
                        imageUploadResult2 = imageUploadResult;
                        e = e2;
                        try {
                            if (!this.axy) {
                            }
                            com.baidu.tbadk.core.log.b.a("img", -1L, -1, "imageUpload", imageUploadResult2.error_code, imageUploadResult2.error_msg, "comment", sb.toString());
                            com.baidu.adp.lib.h.a.b(randomAccessFile2);
                            this.aiG = null;
                            return imageUploadResult2;
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile = randomAccessFile2;
                            com.baidu.adp.lib.h.a.b(randomAccessFile);
                            this.aiG = null;
                            throw th;
                        }
                    }
                } else {
                    String str2 = String.valueOf(f) + this.axx;
                    long j2 = length % ((long) this.axx) == 0 ? length / this.axx : (length / this.axx) + 1;
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
                            int i2 = 1;
                            int i3 = 0;
                            long j3 = 0;
                            while (true) {
                                i = i2;
                                randomAccessFile3 = imageUploadResult2;
                                if (i > j2) {
                                    imageUploadResult = randomAccessFile3;
                                    randomAccessFile3 = randomAccessFile;
                                    break;
                                }
                                try {
                                    if (this.axy) {
                                        break;
                                    }
                                    int i4 = 0;
                                    if (i > j2) {
                                        i4 = 0;
                                        bArr = null;
                                    } else {
                                        if (i < j2) {
                                            i4 = this.axx;
                                        } else if (i == j2) {
                                            i4 = (int) (length - (this.axx * (j2 - 1)));
                                        }
                                        if (bArr2 == null || bArr2.length != i4) {
                                            bArr2 = new byte[i4];
                                        }
                                        randomAccessFile.seek(this.axx * (i - 1));
                                        randomAccessFile.read(bArr2, 0, i4);
                                        bArr = bArr2;
                                    }
                                    this.aiG = new aa(TbConfig.UPLOAD_IMG_URL);
                                    this.aiG.p("resourceId", str2);
                                    this.aiG.p("chunkNo", String.valueOf(i));
                                    if (i >= j2) {
                                        this.aiG.p("isFinish", String.valueOf(1));
                                    } else {
                                        this.aiG.p("isFinish", String.valueOf(0));
                                    }
                                    if (this.bigWidth > 0 && this.bigHeight > 0) {
                                        this.aiG.p("width", String.valueOf(this.bigWidth));
                                        this.aiG.p("height", String.valueOf(this.bigHeight));
                                    }
                                    if (this.smallWidth > 0 && this.smallHeight > 0) {
                                        this.aiG.p("smallWidth", String.valueOf(this.smallWidth));
                                        this.aiG.p("smallHeight", String.valueOf(this.smallHeight));
                                    }
                                    this.aiG.p("groupId", String.valueOf(this.groupId));
                                    this.aiG.p("alt", "json");
                                    if (bArr != null) {
                                        this.aiG.d("chunk", bArr);
                                    }
                                    if (z) {
                                        this.aiG.p("saveOrigin", "1");
                                    } else {
                                        this.aiG.p("saveOrigin", "0");
                                    }
                                    if (z2) {
                                        int rr = l.rn().rr();
                                        if (rr != 0) {
                                            this.aiG.p("pic_water_type", String.valueOf(rr));
                                        }
                                        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                        if (!StringUtils.isNull(currentAccountName) && rr == 1) {
                                            this.aiG.p("user_name", currentAccountName);
                                        }
                                        String rs = l.rn().rs();
                                        if (!StringUtils.isNull(rs) && rr == 2) {
                                            this.aiG.p("forum_name", rs);
                                        }
                                    }
                                    String vc = this.aiG.vc();
                                    imageUploadResult2 = ImageUploadResult.parser(vc);
                                    if (vc == null || imageUploadResult2 == null || !(imageUploadResult2.error_code == 0 || imageUploadResult2.error_code == ImageUploadResult.CHUNK_ERROR)) {
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
                                        long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.axx) : j4;
                                        if (this.axA != null) {
                                            this.axA.a(str, this.axB, j5, length);
                                        }
                                        i2 = i5;
                                        j = j4;
                                    }
                                    int i6 = i3 + 1;
                                    if (i6 > 2 * j2) {
                                        sb.append("|possbile dead loop found. tryCount=").append(i6).append(", chunkNo=").append(j2);
                                        randomAccessFile3 = randomAccessFile;
                                        imageUploadResult = imageUploadResult2;
                                        break;
                                    }
                                    i3 = i6;
                                    j3 = j;
                                    bArr2 = bArr;
                                } catch (Exception e3) {
                                    randomAccessFile2 = randomAccessFile;
                                    imageUploadResult2 = randomAccessFile3;
                                    e = e3;
                                }
                            }
                            sb.append("|startChunk=");
                            sb.append(i);
                            sb.append("|picNull=");
                            sb.append(imageUploadResult2 == null);
                            sb.append("|picErrNo=");
                            if (imageUploadResult2 != null) {
                                sb.append(imageUploadResult2.error_code);
                                randomAccessFile3 = randomAccessFile;
                                imageUploadResult = imageUploadResult2;
                            } else {
                                randomAccessFile3 = randomAccessFile;
                                imageUploadResult = imageUploadResult2;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            randomAccessFile2 = randomAccessFile;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        com.baidu.adp.lib.h.a.b(randomAccessFile);
                        this.aiG = null;
                        throw th;
                    }
                }
                com.baidu.adp.lib.h.a.b(randomAccessFile3);
                this.aiG = null;
                return imageUploadResult;
            } catch (Exception e5) {
                randomAccessFile2 = null;
                e = e5;
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
