package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CommonVcodeActivityConfig;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.t;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c {
    private boolean aug;
    private b auh;
    private a aui;
    private Object auj;
    private int bigHeight;
    private int bigWidth;
    private String from;
    private int smallHeight;
    private int smallWidth;
    private int auf = 512000;
    private String groupId = "1";
    private ab aeI = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, Object obj, long j, long j2);
    }

    public c(String str) {
        this.from = str;
    }

    public void f(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(a aVar, Object obj) {
        this.aui = aVar;
        this.auj = obj;
        if (aVar != null) {
            this.auf = 10240;
        }
    }

    public void cancel() {
        this.aug = true;
        if (this.aeI != null) {
            this.aeI.dl();
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
                if (this.aug) {
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
                        if (!this.aug) {
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
        if (z && !imageFileInfo.hasActionsWithoutResize() && m.dc(imageFileInfo.getFilePath()) <= 5242880) {
            return f(imageFileInfo.getFilePath(), z, z2);
        }
        if (this.auh == null) {
            this.auh = new b();
        }
        LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
        imageFileInfo.setPageActionsList(null);
        com.baidu.adp.widget.a.a a3 = this.auh.a(imageFileInfo, true);
        if (a3 != null) {
            b = a3.iY();
        } else {
            b = this.auh.b(imageFileInfo, true);
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

    /* JADX WARN: Code restructure failed: missing block: B:136:0x03fe, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0144, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r4 = r3;
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02a3, code lost:
        if (r11 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02a5, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x02a6, code lost:
        r19.append(r3);
        r19.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02b3, code lost:
        if (r11 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02b5, code lost:
        r19.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02bc, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0357, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03ce A[Catch: all -> 0x03d7, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x03d7, blocks: (B:89:0x030a, B:91:0x0310, B:92:0x0318, B:120:0x03ce), top: B:141:0x030a }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0310 A[Catch: all -> 0x03d7, TryCatch #3 {all -> 0x03d7, blocks: (B:89:0x030a, B:91:0x0310, B:92:0x0318, B:120:0x03ce), top: B:141:0x030a }] */
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
                String d = t.d(m.m(file));
                sb.append("path=");
                sb.append(str);
                sb.append("|length=");
                sb.append(length);
                sb.append("|md5=");
                sb.append(d);
                if (length == 0 || d == null) {
                    imageUploadResult = new ImageUploadResult();
                    try {
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult.error_msg = TbadkCoreApplication.m11getInst().getApp().getString(t.j.file_not_exist);
                        TiebaStatic.imgError(TbErrInfo.ERR_IMG_FILE, "file error: " + imageUploadResult.error_msg, sb.toString());
                    } catch (Exception e2) {
                        randomAccessFile2 = null;
                        imageUploadResult2 = imageUploadResult;
                        e = e2;
                        try {
                            if (!this.aug) {
                            }
                            com.baidu.tbadk.core.log.b.a("img", -1L, -1, "imageUpload", imageUploadResult2.error_code, imageUploadResult2.error_msg, "comment", sb.toString());
                            com.baidu.adp.lib.h.a.a(randomAccessFile2);
                            this.aeI = null;
                            return imageUploadResult2;
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile = randomAccessFile2;
                            com.baidu.adp.lib.h.a.a(randomAccessFile);
                            this.aeI = null;
                            throw th;
                        }
                    }
                } else {
                    String str2 = String.valueOf(d) + this.auf;
                    long j2 = length % ((long) this.auf) == 0 ? length / this.auf : (length / this.auf) + 1;
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
                                    if (this.aug) {
                                        break;
                                    }
                                    int i4 = 0;
                                    if (i > j2) {
                                        i4 = 0;
                                        bArr = null;
                                    } else {
                                        if (i < j2) {
                                            i4 = this.auf;
                                        } else if (i == j2) {
                                            i4 = (int) (length - (this.auf * (j2 - 1)));
                                        }
                                        if (bArr2 == null || bArr2.length != i4) {
                                            bArr2 = new byte[i4];
                                        }
                                        randomAccessFile.seek(this.auf * (i - 1));
                                        randomAccessFile.read(bArr2, 0, i4);
                                        bArr = bArr2;
                                    }
                                    this.aeI = new ab(TbConfig.UPLOAD_IMG_URL);
                                    this.aeI.n("resourceId", str2);
                                    this.aeI.n("chunkNo", String.valueOf(i));
                                    if (i >= j2) {
                                        this.aeI.n("isFinish", String.valueOf(1));
                                    } else {
                                        this.aeI.n("isFinish", String.valueOf(0));
                                    }
                                    if (this.bigWidth > 0 && this.bigHeight > 0) {
                                        this.aeI.n(CommonVcodeActivityConfig.WIDTH, String.valueOf(this.bigWidth));
                                        this.aeI.n(CommonVcodeActivityConfig.HEIGHT, String.valueOf(this.bigHeight));
                                    }
                                    if (this.smallWidth > 0 && this.smallHeight > 0) {
                                        this.aeI.n("smallWidth", String.valueOf(this.smallWidth));
                                        this.aeI.n("smallHeight", String.valueOf(this.smallHeight));
                                    }
                                    this.aeI.n("groupId", String.valueOf(this.groupId));
                                    this.aeI.n("alt", "json");
                                    if (bArr != null) {
                                        this.aeI.c("chunk", bArr);
                                    }
                                    if (z) {
                                        this.aeI.n("saveOrigin", "1");
                                    } else {
                                        this.aeI.n("saveOrigin", "0");
                                    }
                                    if (z2) {
                                        int of = l.ob().of();
                                        if (of != 0) {
                                            this.aeI.n("pic_water_type", String.valueOf(of));
                                        }
                                        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                        if (!StringUtils.isNull(currentAccountName) && of == 1) {
                                            this.aeI.n("user_name", currentAccountName);
                                        }
                                        String og = l.ob().og();
                                        if (!StringUtils.isNull(og) && of == 2) {
                                            this.aeI.n("forum_name", og);
                                        }
                                    }
                                    String tg = this.aeI.tg();
                                    imageUploadResult2 = ImageUploadResult.parser(tg);
                                    if (tg == null || imageUploadResult2 == null || !(imageUploadResult2.error_code == 0 || imageUploadResult2.error_code == ImageUploadResult.CHUNK_ERROR)) {
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
                                        long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.auf) : j4;
                                        if (this.aui != null) {
                                            this.aui.a(str, this.auj, j5, length);
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
                            try {
                                sb.append("|startChunk=");
                                sb.append(i);
                                imageUploadResult = null;
                                randomAccessFile3 = randomAccessFile;
                            } catch (Exception e4) {
                                randomAccessFile2 = randomAccessFile;
                                imageUploadResult2 = null;
                                e = e4;
                                if (!this.aug) {
                                    sb.append("|request cancelled.");
                                } else {
                                    BdLog.e(e.getMessage());
                                }
                                com.baidu.tbadk.core.log.b.a("img", -1L, -1, "imageUpload", imageUploadResult2.error_code, imageUploadResult2.error_msg, "comment", sb.toString());
                                com.baidu.adp.lib.h.a.a(randomAccessFile2);
                                this.aeI = null;
                                return imageUploadResult2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            randomAccessFile2 = randomAccessFile;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        com.baidu.adp.lib.h.a.a(randomAccessFile);
                        this.aeI = null;
                        throw th;
                    }
                }
                com.baidu.adp.lib.h.a.a(randomAccessFile3);
                this.aeI = null;
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
