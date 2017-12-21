package com.baidu.tbadk.img;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private a aGV;
    private Object aGW;
    private e aGX;
    private int bigHeight;
    private int bigWidth;
    private String from;
    private boolean isCancelled;
    private int smallHeight;
    private int smallWidth;
    private int aGU = 512000;
    private String groupId = "1";
    private x mNetwork = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, Object obj, long j, long j2);
    }

    public f(String str) {
        this.from = str;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(a aVar, Object obj) {
        this.aGV = aVar;
        this.aGW = obj;
        if (aVar != null) {
            this.aGU = 10240;
        }
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.fo();
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
        if (imageFileInfo == null) {
            return null;
        }
        if (this.aGX == null) {
            this.aGX = new e();
        }
        return e(this.aGX.c(imageFileInfo, z), z, z2);
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        return a(imageFileInfo, false, z);
    }

    public ImageUploadResult q(String str, boolean z) {
        return e(str, false, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [409=5] */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0389, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x038a, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0399, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x039a, code lost:
        r13 = r4;
        r4 = null;
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0140, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03fb A[Catch: all -> 0x0404, TRY_ENTER, TryCatch #3 {all -> 0x0404, blocks: (B:26:0x0153, B:28:0x015a, B:30:0x0164, B:32:0x0168, B:33:0x016a, B:133:0x040c, B:129:0x03fb), top: B:152:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x040c A[Catch: all -> 0x0404, TRY_LEAVE, TryCatch #3 {all -> 0x0404, blocks: (B:26:0x0153, B:28:0x015a, B:30:0x0164, B:32:0x0168, B:33:0x016a, B:133:0x040c, B:129:0x03fb), top: B:152:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x015a A[Catch: all -> 0x0404, TryCatch #3 {all -> 0x0404, blocks: (B:26:0x0153, B:28:0x015a, B:30:0x0164, B:32:0x0168, B:33:0x016a, B:133:0x040c, B:129:0x03fb), top: B:152:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0164 A[Catch: all -> 0x0404, TryCatch #3 {all -> 0x0404, blocks: (B:26:0x0153, B:28:0x015a, B:30:0x0164, B:32:0x0168, B:33:0x016a, B:133:0x040c, B:129:0x03fb), top: B:152:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0168 A[Catch: all -> 0x0404, TryCatch #3 {all -> 0x0404, blocks: (B:26:0x0153, B:28:0x015a, B:30:0x0164, B:32:0x0168, B:33:0x016a, B:133:0x040c, B:129:0x03fb), top: B:152:0x0153 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult e(String str, boolean z, boolean z2) {
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
                String e2 = s.e(k.q(file));
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
                        imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.file_not_exist);
                        TiebaStatic.imgError(TbErrInfo.ERR_IMG_FILE, "file error: " + imageUploadResult.error_msg, sb.toString());
                        imageUploadResult2 = imageUploadResult;
                        randomAccessFile2 = null;
                    } catch (Exception e3) {
                        randomAccessFile = null;
                        e = e3;
                        try {
                            if (!this.isCancelled) {
                                sb.append("|request cancelled.");
                            } else {
                                BdLog.e(e.getMessage());
                            }
                            com.baidu.tbadk.core.d.a.a("img", -1L, -1, "imageUpload", imageUploadResult == null ? imageUploadResult.error_code : TbErrInfo.ERR_IMG_SEND, imageUploadResult == null ? imageUploadResult.error_msg : e.getMessage(), "comment", sb.toString());
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
                    String str2 = e2 + this.aGU;
                    long j2 = length % ((long) this.aGU) == 0 ? length / this.aGU : (length / this.aGU) + 1;
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
                                                i4 = this.aGU;
                                            } else if (i == j2) {
                                                i4 = (int) (length - (this.aGU * (j2 - 1)));
                                            }
                                            if (bArr2 == null || bArr2.length != i4) {
                                                bArr2 = new byte[i4];
                                            }
                                            randomAccessFile2.seek(this.aGU * (i - 1));
                                            randomAccessFile2.read(bArr2, 0, i4);
                                            bArr = bArr2;
                                        }
                                        this.mNetwork = new x(TbConfig.UPLOAD_IMG_URL);
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
                                            int pc = h.oY().pc();
                                            if (pc != 0) {
                                                this.mNetwork.n("pic_water_type", String.valueOf(pc));
                                            }
                                            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                            if (!StringUtils.isNull(currentAccountName) && pc == 1) {
                                                this.mNetwork.n("user_name", currentAccountName);
                                            }
                                            String pd = h.oY().pd();
                                            if (!StringUtils.isNull(pd) && pc == 2) {
                                                this.mNetwork.n("forum_name", pd);
                                            }
                                        }
                                        String us = this.mNetwork.us();
                                        imageUploadResult3 = ImageUploadResult.parser(us);
                                        if (us == null || imageUploadResult3 == null) {
                                            break;
                                        }
                                        try {
                                            if (imageUploadResult3.error_code != 0 && imageUploadResult3.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                break;
                                            }
                                            if (imageUploadResult3.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                int i5 = i + 1;
                                                long j4 = j3 + i4;
                                                long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.aGU) : j4;
                                                if (this.aGV != null) {
                                                    this.aGV.a(str, this.aGW, j5, length);
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
                                        } catch (Exception e4) {
                                            e = e4;
                                            randomAccessFile = randomAccessFile2;
                                            imageUploadResult = imageUploadResult3;
                                        }
                                    } else {
                                        break;
                                    }
                                } catch (Exception e5) {
                                    randomAccessFile = randomAccessFile2;
                                    imageUploadResult = imageUploadResult2;
                                    e = e5;
                                }
                            }
                            sb.append("|startChunk=");
                            sb.append(i);
                            sb.append("|picNull=");
                            sb.append(imageUploadResult3 == null);
                            sb.append("|picErrNo=");
                            if (imageUploadResult3 != null) {
                                sb.append(imageUploadResult3.error_code);
                                imageUploadResult2 = imageUploadResult3;
                            } else {
                                imageUploadResult2 = imageUploadResult3;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            randomAccessFile = randomAccessFile2;
                            imageUploadResult = null;
                        }
                    } catch (Throwable th2) {
                        randomAccessFile3 = randomAccessFile2;
                        th = th2;
                        com.baidu.adp.lib.g.a.b(randomAccessFile3);
                        this.mNetwork = null;
                        throw th;
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
