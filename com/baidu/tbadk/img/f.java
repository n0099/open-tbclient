package com.baidu.tbadk.img;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private int bigHeight;
    private int bigWidth;
    private a buY;
    private Object buZ;
    private e bva;
    private String from;
    private boolean isCancelled;
    private int smallHeight;
    private int smallWidth;
    private int buX = 512000;
    private String groupId = "1";
    private x mNetwork = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, Object obj, long j, long j2);
    }

    public f(String str) {
        this.from = str;
    }

    public void p(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(a aVar, Object obj) {
        this.buY = aVar;
        this.buZ = obj;
        if (aVar != null) {
            this.buX = 10240;
        }
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.mR();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
        r2.setError_code(-53);
        r2.setError_msg(r4.error_msg);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ErrorData b(WriteImagesInfo writeImagesInfo, boolean z) {
        ErrorData errorData = new ErrorData();
        if (writeImagesInfo == null || writeImagesInfo.size() == 0) {
            errorData.setError_code(-53);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(d.j.upload_error));
            return errorData;
        }
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= chosedFiles.size()) {
                break;
            }
            ImageFileInfo imageFileInfo = chosedFiles.get(i2);
            if (!imageFileInfo.isAlreadyUploadedToServer()) {
                if (this.isCancelled) {
                    break;
                }
                ImageUploadResult a2 = a(imageFileInfo, writeImagesInfo.isOriginalImg(), z);
                if (a2 != null) {
                    UploadedImageInfo uploadedPicInfo = a2.getUploadedPicInfo();
                    if (uploadedPicInfo == null || TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                        break;
                    }
                    imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                } else {
                    errorData.setError_code(-53);
                    errorData.setError_msg(TbadkCoreApplication.getInst().getString(d.j.upload_error));
                    return errorData;
                }
            }
            i = i2 + 1;
        }
        return null;
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
        if (this.bva == null) {
            this.bva = new e();
        }
        return e(this.bva.c(imageFileInfo, z), z, z2);
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        return a(imageFileInfo, false, z);
    }

    public ImageUploadResult p(String str, boolean z) {
        return e(str, false, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [428=6, 429=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: java.io.File */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x03ba, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x03ca, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x03cb, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x03da, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x03db, code lost:
        r13 = r4;
        r4 = null;
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x043c, code lost:
        com.baidu.adp.lib.util.BdLog.e(r5.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0445, code lost:
        r4 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0446, code lost:
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0449, code lost:
        r10 = com.baidu.tbadk.core.util.TbErrInfo.ERR_IMG_SEND;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x044d, code lost:
        r11 = r5.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x046e, code lost:
        r5 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:?, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0182, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0199, code lost:
        if (r25.isCancelled != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x019b, code lost:
        r20.append("|request cancelled.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01a3, code lost:
        if (r4 != null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01a5, code lost:
        r10 = r4.error_code;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01a7, code lost:
        if (r4 != null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01a9, code lost:
        r11 = r4.error_msg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01ab, code lost:
        com.baidu.tbadk.core.d.a.a("img", -1, -1, "imageUpload", r10, r11, org.apache.http.cookie.ClientCookie.COMMENT_ATTR, r20.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01c7, code lost:
        com.baidu.adp.lib.g.a.b(r13);
        r25.mNetwork = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0324, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
        r20.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0339, code lost:
        if (r12 != null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x033b, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x033c, code lost:
        r20.append(r5);
        r20.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0349, code lost:
        if (r12 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x034b, code lost:
        r20.append(r12.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0352, code lost:
        r5 = r12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult e(String str, boolean z, boolean z2) {
        RandomAccessFile randomAccessFile;
        Exception e;
        ImageUploadResult imageUploadResult;
        ImageUploadResult imageUploadResult2;
        RandomAccessFile randomAccessFile2;
        byte[] bArr;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth == 0 || options.outHeight == 0) {
            return null;
        }
        ImageUploadResult imageUploadResult3 = null;
        RandomAccessFile randomAccessFile3 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                File file = new File(str);
                long length = file.length();
                long j = 0;
                try {
                    if (length > 5242880) {
                        ImageUploadResult imageUploadResult4 = new ImageUploadResult();
                        imageUploadResult4.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult4.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.file_size_over);
                        com.baidu.adp.lib.g.a.b((Closeable) null);
                        this.mNetwork = null;
                        return imageUploadResult4;
                    }
                    String e2 = s.e(k.r(file));
                    sb.append("path=");
                    sb.append(str);
                    sb.append("|length=");
                    sb.append(length);
                    sb.append("|md5=");
                    sb.append(e2);
                    if (length == 0 || e2 == null) {
                        ImageUploadResult imageUploadResult5 = new ImageUploadResult();
                        imageUploadResult5.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult5.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.file_not_exist);
                        TiebaStatic.imgError(TbErrInfo.ERR_IMG_FILE, "file error: " + imageUploadResult5.error_msg, sb.toString());
                        imageUploadResult2 = imageUploadResult5;
                        randomAccessFile2 = null;
                    } else {
                        String str2 = e2 + this.buX;
                        long j2 = length % ((long) this.buX) == 0 ? length / this.buX : (length / this.buX) + 1;
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
                                int i = 1;
                                int i2 = 0;
                                while (true) {
                                    long j3 = j;
                                    int i3 = i;
                                    imageUploadResult2 = imageUploadResult3;
                                    if (i3 > j2) {
                                        break;
                                    }
                                    try {
                                        if (!this.isCancelled) {
                                            int i4 = 0;
                                            if (i3 > j2) {
                                                i4 = 0;
                                                bArr = null;
                                            } else {
                                                if (i3 < j2) {
                                                    i4 = this.buX;
                                                } else if (i3 == j2) {
                                                    i4 = (int) (length - (this.buX * (j2 - 1)));
                                                }
                                                if (bArr2 == null || bArr2.length != i4) {
                                                    bArr2 = new byte[i4];
                                                }
                                                randomAccessFile2.seek(this.buX * (i3 - 1));
                                                randomAccessFile2.read(bArr2, 0, i4);
                                                bArr = bArr2;
                                            }
                                            this.mNetwork = new x(TbConfig.UPLOAD_IMG_URL);
                                            this.mNetwork.n("resourceId", str2);
                                            this.mNetwork.n("chunkNo", String.valueOf(i3));
                                            if (i3 >= j2) {
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
                                                int wE = i.wA().wE();
                                                if (wE != 0) {
                                                    this.mNetwork.n("pic_water_type", String.valueOf(wE));
                                                }
                                                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                if (!StringUtils.isNull(currentAccountName) && wE == 1) {
                                                    this.mNetwork.n("user_name", currentAccountName);
                                                }
                                                String wF = i.wA().wF();
                                                if (!StringUtils.isNull(wF) && wE == 2) {
                                                    this.mNetwork.n("forum_name", wF);
                                                }
                                            }
                                            String BK = this.mNetwork.BK();
                                            imageUploadResult3 = ImageUploadResult.parser(BK);
                                            if (BK == null || imageUploadResult3 == null) {
                                                break;
                                            }
                                            try {
                                                if (imageUploadResult3.error_code != 0 && imageUploadResult3.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                    break;
                                                }
                                                if (imageUploadResult3.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                    int i5 = i3 + 1;
                                                    long j4 = j3 + i4;
                                                    long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.buX) : j4;
                                                    if (this.buY != null) {
                                                        this.buY.a(str, this.buZ, j5, length);
                                                    }
                                                    i = i5;
                                                    j = j4;
                                                } else if (i3 == imageUploadResult3.chunkNo || imageUploadResult3.chunkNo <= 0) {
                                                    break;
                                                } else {
                                                    i = imageUploadResult3.chunkNo;
                                                    j = j3;
                                                }
                                                int i6 = i2 + 1;
                                                if (i6 > 2 * j2) {
                                                    sb.append("|possbile dead loop found. tryCount=").append(i6).append(", chunkNo=").append(j2);
                                                    imageUploadResult2 = imageUploadResult3;
                                                    break;
                                                }
                                                i2 = i6;
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
                            } catch (Throwable th) {
                                randomAccessFile3 = randomAccessFile2;
                                th = th;
                                com.baidu.adp.lib.g.a.b(randomAccessFile3);
                                this.mNetwork = null;
                                throw th;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            randomAccessFile = randomAccessFile2;
                            imageUploadResult = null;
                        }
                    }
                    com.baidu.adp.lib.g.a.b(randomAccessFile2);
                    this.mNetwork = null;
                    return imageUploadResult2;
                } catch (Exception e6) {
                    randomAccessFile = null;
                    e = e6;
                    imageUploadResult = file;
                }
            } catch (Throwable th2) {
                th = th2;
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
