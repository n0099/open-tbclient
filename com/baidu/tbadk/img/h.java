package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.u;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h {
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;
    private boolean g;
    private e j;
    private i k;
    private Object l;
    private int a = 102400;
    private String h = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
    private al i = null;

    public h(String str) {
        this.f = str;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public void a(i iVar, Object obj) {
        this.k = iVar;
        this.l = obj;
        if (iVar != null) {
            this.a = 10240;
        }
    }

    public void a() {
        this.g = true;
        if (this.i != null) {
            this.i.g();
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
                        if (!this.g) {
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
        if (this.j == null) {
            this.j = new e(TbadkApplication.m252getInst().getApp());
        }
        LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
        imageFileInfo.setPageActionsList(null);
        com.baidu.adp.widget.a.a a2 = this.j.a(imageFileInfo, true);
        if (a2 != null) {
            b = a2.h();
        } else {
            b = this.j.b(imageFileInfo, true);
        }
        imageFileInfo.setPageActionsList(pageActionsList);
        if (b != null && (a = x.a(TbConfig.IMAGE_RESIZED_FILE, b, 80)) != null) {
            return a(a);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x039c, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x039d, code lost:
        r4 = null;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x03ab, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x014a, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r4 = r3;
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0242, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r19.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0257, code lost:
        if (r11 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0259, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x025a, code lost:
        r19.append(r3);
        r19.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0267, code lost:
        if (r11 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0269, code lost:
        r19.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0270, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0305, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0317, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0324, code lost:
        r4 = null;
        r3 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02c7 A[Catch: all -> 0x037b, TryCatch #6 {all -> 0x037b, blocks: (B:15:0x00d2, B:22:0x0144, B:24:0x014a, B:25:0x015b, B:28:0x0164, B:30:0x0190, B:31:0x019f, B:33:0x01a5, B:35:0x01ab, B:36:0x01cf, B:38:0x01d5, B:40:0x01db, B:41:0x01ff, B:43:0x0220, B:44:0x022a, B:46:0x0238, B:48:0x023c, B:78:0x0308, B:80:0x030e, B:82:0x0312, B:87:0x0328, B:88:0x032b, B:90:0x0336, B:85:0x0317, B:72:0x02c1, B:74:0x02c7, B:75:0x02cf, B:95:0x0372, B:91:0x0353, B:93:0x035e, B:50:0x0242, B:53:0x025a, B:55:0x0269, B:68:0x02aa, B:59:0x0279, B:61:0x027f, B:64:0x0284, B:63:0x0282, B:65:0x0296, B:67:0x029b), top: B:122:0x00d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0372 A[Catch: all -> 0x037b, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x037b, blocks: (B:15:0x00d2, B:22:0x0144, B:24:0x014a, B:25:0x015b, B:28:0x0164, B:30:0x0190, B:31:0x019f, B:33:0x01a5, B:35:0x01ab, B:36:0x01cf, B:38:0x01d5, B:40:0x01db, B:41:0x01ff, B:43:0x0220, B:44:0x022a, B:46:0x0238, B:48:0x023c, B:78:0x0308, B:80:0x030e, B:82:0x0312, B:87:0x0328, B:88:0x032b, B:90:0x0336, B:85:0x0317, B:72:0x02c1, B:74:0x02c7, B:75:0x02cf, B:95:0x0372, B:91:0x0353, B:93:0x035e, B:50:0x0242, B:53:0x025a, B:55:0x0269, B:68:0x02aa, B:59:0x0279, B:61:0x027f, B:64:0x0284, B:63:0x0282, B:65:0x0296, B:67:0x029b), top: B:122:0x00d2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult a(String str) {
        RandomAccessFile randomAccessFile;
        Exception e;
        ImageUploadResult imageUploadResult;
        Throwable th;
        byte[] bArr;
        long j;
        ImageUploadResult imageUploadResult2 = null;
        RandomAccessFile randomAccessFile2 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                File file = new File(str);
                long length = file.length();
                String a = be.a(x.a(file));
                sb.append("path=");
                sb.append(str);
                sb.append("|length=");
                sb.append(length);
                sb.append("|md5=");
                sb.append(a);
                if (length == 0 || a == null) {
                    imageUploadResult = new ImageUploadResult();
                    try {
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult.error_msg = TbadkApplication.m252getInst().getApp().getString(u.file_not_exist);
                        TiebaStatic.imgError("", TbErrInfo.ERR_IMG_FILE, "file error: " + imageUploadResult.error_msg, sb.toString());
                    } catch (Exception e2) {
                        randomAccessFile = null;
                        e = e2;
                        if (!this.g) {
                            sb.append("|request cancelled.");
                        } else {
                            BdLog.e(e.getMessage());
                        }
                        TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, String.valueOf(this.f) + "ex: " + e.getMessage(), sb.toString());
                        com.baidu.adp.lib.f.a.a(randomAccessFile);
                        this.i = null;
                        return imageUploadResult;
                    }
                } else {
                    String str2 = String.valueOf(a) + this.a;
                    long j2 = length % ((long) this.a) == 0 ? length / this.a : (length / this.a) + 1;
                    sb.append("|chunkNo=");
                    sb.append(j2);
                    randomAccessFile = new RandomAccessFile(str, "r");
                    byte[] bArr2 = null;
                    try {
                        try {
                            sb.append("|width=");
                            sb.append(this.b);
                            sb.append("|height=");
                            sb.append(this.c);
                            sb.append("|smallWidth=");
                            sb.append(this.d);
                            sb.append("|smallHeight=");
                            sb.append(this.e);
                            sb.append("|groupId=");
                            sb.append(this.h);
                            int i = 1;
                            int i2 = 0;
                            long j3 = 0;
                            while (true) {
                                int i3 = i;
                                randomAccessFile2 = imageUploadResult2;
                                if (i3 > j2) {
                                    imageUploadResult = randomAccessFile2;
                                    randomAccessFile2 = randomAccessFile;
                                    break;
                                }
                                try {
                                    if (!this.g) {
                                        int i4 = 0;
                                        if (i3 > j2) {
                                            i4 = 0;
                                            bArr = null;
                                        } else {
                                            if (i3 < j2) {
                                                i4 = this.a;
                                            } else if (i3 == j2) {
                                                i4 = (int) (length - (this.a * (j2 - 1)));
                                            }
                                            if (bArr2 == null || bArr2.length != i4) {
                                                bArr2 = new byte[i4];
                                            }
                                            randomAccessFile.seek(this.a * (i3 - 1));
                                            randomAccessFile.read(bArr2, 0, i4);
                                            bArr = bArr2;
                                        }
                                        this.i = new al(TbConfig.UPLOAD_IMG_URL);
                                        this.i.a("resourceId", str2);
                                        this.i.a("chunkNo", String.valueOf(i3));
                                        if (i3 >= j2) {
                                            this.i.a("isFinish", String.valueOf(1));
                                        } else {
                                            this.i.a("isFinish", String.valueOf(0));
                                        }
                                        if (this.b > 0 && this.c > 0) {
                                            this.i.a("width", String.valueOf(this.b));
                                            this.i.a("height", String.valueOf(this.c));
                                        }
                                        if (this.d > 0 && this.e > 0) {
                                            this.i.a("smallWidth", String.valueOf(this.d));
                                            this.i.a("smallHeight", String.valueOf(this.e));
                                        }
                                        this.i.a("groupId", String.valueOf(this.h));
                                        this.i.a("alt", "json");
                                        if (bArr != null) {
                                            this.i.a("chunk", bArr);
                                        }
                                        imageUploadResult2 = ImageUploadResult.parser(this.i.j());
                                        if (imageUploadResult2 == null) {
                                            break;
                                        }
                                        try {
                                            if (imageUploadResult2.error_code != 0 && imageUploadResult2.error_code != ImageUploadResult.CHUNK_ERROR) {
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
                                                if (this.k != null) {
                                                    this.k.a(str, this.l, j4, length);
                                                }
                                                i = i5;
                                                j = j4;
                                            }
                                            int i6 = i2 + 1;
                                            if (i6 > 2 * j2) {
                                                sb.append("|possbile dead loop found. tryCount=").append(i6).append(", chunkNo=").append(j2);
                                                randomAccessFile2 = randomAccessFile;
                                                imageUploadResult = imageUploadResult2;
                                                break;
                                            }
                                            i2 = i6;
                                            j3 = j;
                                            bArr2 = bArr;
                                        } catch (Exception e3) {
                                            e = e3;
                                            imageUploadResult = imageUploadResult2;
                                        }
                                    } else {
                                        break;
                                    }
                                } catch (Exception e4) {
                                    imageUploadResult = randomAccessFile2;
                                    e = e4;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            com.baidu.adp.lib.f.a.a(randomAccessFile);
                            this.i = null;
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        imageUploadResult = null;
                    }
                }
                com.baidu.adp.lib.f.a.a(randomAccessFile2);
                this.i = null;
            } catch (Throwable th3) {
                randomAccessFile = null;
                th = th3;
            }
        } catch (Exception e6) {
            randomAccessFile = null;
            e = e6;
            imageUploadResult = null;
        }
        return imageUploadResult;
    }

    public void b(String str) {
        this.h = str;
    }
}
