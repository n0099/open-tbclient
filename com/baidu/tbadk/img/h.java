package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ab;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.y;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h {
    private e alx;
    private i aly;
    private Object alz;
    private int bigHeight;
    private int bigWidth;
    private String from;
    private boolean isCancelled;
    private int smallHeight;
    private int smallWidth;
    private int alw = 102400;
    private String groupId = "1";
    private aa ZF = null;

    public h(String str) {
        this.from = str;
    }

    public void e(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(i iVar, Object obj) {
        this.aly = iVar;
        this.alz = obj;
        if (iVar != null) {
            this.alw = 10240;
        }
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.ZF != null) {
            this.ZF.hh();
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
        if (this.alx == null) {
            this.alx = new e(TbadkCoreApplication.m411getInst().getApp());
        }
        LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
        imageFileInfo.setPageActionsList(null);
        com.baidu.adp.widget.a.a a2 = this.alx.a(imageFileInfo, true);
        if (a2 != null) {
            b = a2.mz();
        } else {
            b = this.alx.b(imageFileInfo, true);
        }
        imageFileInfo.setPageActionsList(pageActionsList);
        if (b != null && (a = o.a(TbConfig.IMAGE_RESIZED_FILE, b, 80)) != null) {
            return ev(a);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0398, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x013e, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r4 = r3;
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x022c, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r19.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x023f, code lost:
        if (r11 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0241, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0242, code lost:
        r19.append(r3);
        r19.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x024e, code lost:
        if (r11 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0250, code lost:
        r19.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0257, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02e8, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02ad A[Catch: all -> 0x0366, TryCatch #3 {all -> 0x0366, blocks: (B:15:0x00cb, B:22:0x0138, B:24:0x013e, B:25:0x014e, B:28:0x0157, B:30:0x0181, B:31:0x018f, B:33:0x0195, B:35:0x019b, B:36:0x01bd, B:38:0x01c3, B:40:0x01c9, B:41:0x01eb, B:43:0x0209, B:44:0x0212, B:47:0x0222, B:49:0x0226, B:79:0x02eb, B:81:0x02f1, B:83:0x02f5, B:88:0x030a, B:89:0x030d, B:91:0x0318, B:86:0x02fa, B:73:0x02a7, B:75:0x02ad, B:76:0x02b4, B:99:0x035d, B:92:0x0333, B:94:0x033c, B:95:0x0346, B:97:0x034c, B:51:0x022c, B:54:0x0242, B:56:0x0250, B:69:0x0291, B:60:0x0260, B:62:0x0266, B:65:0x026b, B:64:0x0269, B:66:0x027d, B:68:0x0282), top: B:120:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x035d A[Catch: all -> 0x0366, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0366, blocks: (B:15:0x00cb, B:22:0x0138, B:24:0x013e, B:25:0x014e, B:28:0x0157, B:30:0x0181, B:31:0x018f, B:33:0x0195, B:35:0x019b, B:36:0x01bd, B:38:0x01c3, B:40:0x01c9, B:41:0x01eb, B:43:0x0209, B:44:0x0212, B:47:0x0222, B:49:0x0226, B:79:0x02eb, B:81:0x02f1, B:83:0x02f5, B:88:0x030a, B:89:0x030d, B:91:0x0318, B:86:0x02fa, B:73:0x02a7, B:75:0x02ad, B:76:0x02b4, B:99:0x035d, B:92:0x0333, B:94:0x033c, B:95:0x0346, B:97:0x034c, B:51:0x022c, B:54:0x0242, B:56:0x0250, B:69:0x0291, B:60:0x0260, B:62:0x0266, B:65:0x026b, B:64:0x0269, B:66:0x027d, B:68:0x0282), top: B:120:0x00cb }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult ev(String str) {
        RandomAccessFile randomAccessFile;
        Exception e;
        ImageUploadResult imageUploadResult;
        Throwable th;
        int i;
        byte[] bArr;
        long j;
        ImageUploadResult imageUploadResult2 = null;
        RandomAccessFile randomAccessFile2 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                File file = new File(str);
                long length = file.length();
                String e2 = ab.e(o.l(file));
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
                        imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(y.file_not_exist);
                        TiebaStatic.imgError("", TbErrInfo.ERR_IMG_FILE, "file error: " + imageUploadResult.error_msg, sb.toString());
                    } catch (Exception e3) {
                        randomAccessFile = null;
                        e = e3;
                        if (!this.isCancelled) {
                            sb.append("|request cancelled.");
                        } else {
                            BdLog.e(e.getMessage());
                        }
                        TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, String.valueOf(this.from) + "ex: " + e.getMessage(), sb.toString());
                        com.baidu.adp.lib.g.a.c(randomAccessFile);
                        this.ZF = null;
                        return imageUploadResult;
                    }
                } else {
                    String str2 = String.valueOf(e2) + this.alw;
                    long j2 = length % ((long) this.alw) == 0 ? length / this.alw : (length / this.alw) + 1;
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
                                randomAccessFile2 = imageUploadResult2;
                                if (i > j2) {
                                    imageUploadResult = randomAccessFile2;
                                    randomAccessFile2 = randomAccessFile;
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
                                                i4 = this.alw;
                                            } else if (i == j2) {
                                                i4 = (int) (length - (this.alw * (j2 - 1)));
                                            }
                                            if (bArr2 == null || bArr2.length != i4) {
                                                bArr2 = new byte[i4];
                                            }
                                            randomAccessFile.seek(this.alw * (i - 1));
                                            randomAccessFile.read(bArr2, 0, i4);
                                            bArr = bArr2;
                                        }
                                        this.ZF = new aa(TbConfig.UPLOAD_IMG_URL);
                                        this.ZF.o("resourceId", str2);
                                        this.ZF.o("chunkNo", String.valueOf(i));
                                        if (i >= j2) {
                                            this.ZF.o("isFinish", String.valueOf(1));
                                        } else {
                                            this.ZF.o("isFinish", String.valueOf(0));
                                        }
                                        if (this.bigWidth > 0 && this.bigHeight > 0) {
                                            this.ZF.o("width", String.valueOf(this.bigWidth));
                                            this.ZF.o("height", String.valueOf(this.bigHeight));
                                        }
                                        if (this.smallWidth > 0 && this.smallHeight > 0) {
                                            this.ZF.o("smallWidth", String.valueOf(this.smallWidth));
                                            this.ZF.o("smallHeight", String.valueOf(this.smallHeight));
                                        }
                                        this.ZF.o("groupId", String.valueOf(this.groupId));
                                        this.ZF.o("alt", "json");
                                        if (bArr != null) {
                                            this.ZF.g("chunk", bArr);
                                        }
                                        String rR = this.ZF.rR();
                                        imageUploadResult2 = ImageUploadResult.parser(rR);
                                        if (rR == null || imageUploadResult2 == null) {
                                            break;
                                        }
                                        try {
                                            if (imageUploadResult2.error_code != 0 && imageUploadResult2.error_code != ImageUploadResult.CHUNK_ERROR) {
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
                                                long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.alw) : j4;
                                                if (this.aly != null) {
                                                    this.aly.a(str, this.alz, j5, length);
                                                }
                                                i2 = i5;
                                                j = j4;
                                            }
                                            int i6 = i3 + 1;
                                            if (i6 > 2 * j2) {
                                                sb.append("|possbile dead loop found. tryCount=").append(i6).append(", chunkNo=").append(j2);
                                                randomAccessFile2 = randomAccessFile;
                                                imageUploadResult = imageUploadResult2;
                                                break;
                                            }
                                            i3 = i6;
                                            j3 = j;
                                            bArr2 = bArr;
                                        } catch (Exception e4) {
                                            e = e4;
                                            imageUploadResult = imageUploadResult2;
                                        }
                                    } else {
                                        break;
                                    }
                                } catch (Exception e5) {
                                    imageUploadResult = randomAccessFile2;
                                    e = e5;
                                }
                            }
                        } catch (Exception e6) {
                            e = e6;
                            imageUploadResult = null;
                        }
                        try {
                            sb.append("|startChunk=");
                            sb.append(i);
                            imageUploadResult = null;
                            randomAccessFile2 = randomAccessFile;
                        } catch (Exception e7) {
                            imageUploadResult = null;
                            e = e7;
                            if (!this.isCancelled) {
                            }
                            TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, String.valueOf(this.from) + "ex: " + e.getMessage(), sb.toString());
                            com.baidu.adp.lib.g.a.c(randomAccessFile);
                            this.ZF = null;
                            return imageUploadResult;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.g.a.c(randomAccessFile);
                        this.ZF = null;
                        throw th;
                    }
                }
                com.baidu.adp.lib.g.a.c(randomAccessFile2);
                this.ZF = null;
            } catch (Throwable th3) {
                randomAccessFile = null;
                th = th3;
            }
        } catch (Exception e8) {
            randomAccessFile = null;
            e = e8;
            imageUploadResult = null;
        }
        return imageUploadResult;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
