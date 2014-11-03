package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.y;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h {
    private boolean Vl;
    private e Vm;
    private i Vn;
    private Object Vo;
    private int bigHeight;
    private int bigWidth;
    private String from;
    private int smallHeight;
    private int smallWidth;
    private int Vk = 102400;
    private String groupId = "1";
    private ac yV = null;

    public h(String str) {
        this.from = str;
    }

    public void b(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(i iVar, Object obj) {
        this.Vn = iVar;
        this.Vo = obj;
        if (iVar != null) {
            this.Vk = 10240;
        }
    }

    public void cancel() {
        this.Vl = true;
        if (this.yV != null) {
            this.yV.dM();
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
                        if (!this.Vl) {
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
        if (this.Vm == null) {
            this.Vm = new e(TbadkApplication.m251getInst().getApp());
        }
        LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
        imageFileInfo.setPageActionsList(null);
        com.baidu.adp.widget.a.a a2 = this.Vm.a(imageFileInfo, true);
        if (a2 != null) {
            b = a2.hl();
        } else {
            b = this.Vm.b(imageFileInfo, true);
        }
        imageFileInfo.setPageActionsList(pageActionsList);
        if (b != null && (a = s.a(TbConfig.IMAGE_RESIZED_FILE, b, 80)) != null) {
            return du(a);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0396, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x013e, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r4 = r3;
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x022a, code lost:
        r19.append("|startChunk=");
        r19.append(r6);
        r19.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x023d, code lost:
        if (r11 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x023f, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0240, code lost:
        r19.append(r3);
        r19.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x024c, code lost:
        if (r11 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x024e, code lost:
        r19.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0255, code lost:
        r3 = r10;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02e6, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02ab A[Catch: all -> 0x0364, TryCatch #2 {all -> 0x0364, blocks: (B:15:0x00cb, B:22:0x0138, B:24:0x013e, B:25:0x014e, B:28:0x0157, B:30:0x0181, B:31:0x018f, B:33:0x0195, B:35:0x019b, B:36:0x01bd, B:38:0x01c3, B:40:0x01c9, B:41:0x01eb, B:43:0x0209, B:44:0x0212, B:46:0x0220, B:48:0x0224, B:78:0x02e9, B:80:0x02ef, B:82:0x02f3, B:87:0x0308, B:88:0x030b, B:90:0x0316, B:85:0x02f8, B:72:0x02a5, B:74:0x02ab, B:75:0x02b2, B:98:0x035b, B:91:0x0331, B:93:0x033a, B:94:0x0344, B:96:0x034a, B:50:0x022a, B:53:0x0240, B:55:0x024e, B:68:0x028f, B:59:0x025e, B:61:0x0264, B:64:0x0269, B:63:0x0267, B:65:0x027b, B:67:0x0280), top: B:120:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x035b A[Catch: all -> 0x0364, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0364, blocks: (B:15:0x00cb, B:22:0x0138, B:24:0x013e, B:25:0x014e, B:28:0x0157, B:30:0x0181, B:31:0x018f, B:33:0x0195, B:35:0x019b, B:36:0x01bd, B:38:0x01c3, B:40:0x01c9, B:41:0x01eb, B:43:0x0209, B:44:0x0212, B:46:0x0220, B:48:0x0224, B:78:0x02e9, B:80:0x02ef, B:82:0x02f3, B:87:0x0308, B:88:0x030b, B:90:0x0316, B:85:0x02f8, B:72:0x02a5, B:74:0x02ab, B:75:0x02b2, B:98:0x035b, B:91:0x0331, B:93:0x033a, B:94:0x0344, B:96:0x034a, B:50:0x022a, B:53:0x0240, B:55:0x024e, B:68:0x028f, B:59:0x025e, B:61:0x0264, B:64:0x0269, B:63:0x0267, B:65:0x027b, B:67:0x0280), top: B:120:0x00cb }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult du(String str) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        Exception e;
        ImageUploadResult imageUploadResult;
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
                String b = u.b(s.k(file));
                sb.append("path=");
                sb.append(str);
                sb.append("|length=");
                sb.append(length);
                sb.append("|md5=");
                sb.append(b);
                if (length == 0 || b == null) {
                    imageUploadResult = new ImageUploadResult();
                    try {
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult.error_msg = TbadkApplication.m251getInst().getApp().getString(y.file_not_exist);
                        TiebaStatic.imgError("", TbErrInfo.ERR_IMG_FILE, "file error: " + imageUploadResult.error_msg, sb.toString());
                    } catch (Exception e2) {
                        randomAccessFile = null;
                        e = e2;
                        if (!this.Vl) {
                            sb.append("|request cancelled.");
                        } else {
                            BdLog.e(e.getMessage());
                        }
                        TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, String.valueOf(this.from) + "ex: " + e.getMessage(), sb.toString());
                        com.baidu.adp.lib.g.a.a(randomAccessFile);
                        this.yV = null;
                        return imageUploadResult;
                    }
                } else {
                    String str2 = String.valueOf(b) + this.Vk;
                    long j2 = length % ((long) this.Vk) == 0 ? length / this.Vk : (length / this.Vk) + 1;
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
                                    if (!this.Vl) {
                                        int i4 = 0;
                                        if (i > j2) {
                                            i4 = 0;
                                            bArr = null;
                                        } else {
                                            if (i < j2) {
                                                i4 = this.Vk;
                                            } else if (i == j2) {
                                                i4 = (int) (length - (this.Vk * (j2 - 1)));
                                            }
                                            if (bArr2 == null || bArr2.length != i4) {
                                                bArr2 = new byte[i4];
                                            }
                                            randomAccessFile.seek(this.Vk * (i - 1));
                                            randomAccessFile.read(bArr2, 0, i4);
                                            bArr = bArr2;
                                        }
                                        this.yV = new ac(TbConfig.UPLOAD_IMG_URL);
                                        this.yV.k("resourceId", str2);
                                        this.yV.k("chunkNo", String.valueOf(i));
                                        if (i >= j2) {
                                            this.yV.k("isFinish", String.valueOf(1));
                                        } else {
                                            this.yV.k("isFinish", String.valueOf(0));
                                        }
                                        if (this.bigWidth > 0 && this.bigHeight > 0) {
                                            this.yV.k("width", String.valueOf(this.bigWidth));
                                            this.yV.k("height", String.valueOf(this.bigHeight));
                                        }
                                        if (this.smallWidth > 0 && this.smallHeight > 0) {
                                            this.yV.k("smallWidth", String.valueOf(this.smallWidth));
                                            this.yV.k("smallHeight", String.valueOf(this.smallHeight));
                                        }
                                        this.yV.k("groupId", String.valueOf(this.groupId));
                                        this.yV.k("alt", "json");
                                        if (bArr != null) {
                                            this.yV.e("chunk", bArr);
                                        }
                                        imageUploadResult2 = ImageUploadResult.parser(this.yV.lD());
                                        if (imageUploadResult2 == null) {
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
                                                long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.Vk) : j4;
                                                if (this.Vn != null) {
                                                    this.Vn.a(str, this.Vo, j5, length);
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
                        } catch (Exception e5) {
                            e = e5;
                            imageUploadResult = null;
                        }
                        try {
                            sb.append("|startChunk=");
                            sb.append(i);
                            imageUploadResult = null;
                            randomAccessFile2 = randomAccessFile;
                        } catch (Exception e6) {
                            imageUploadResult = null;
                            e = e6;
                            if (!this.Vl) {
                            }
                            TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, String.valueOf(this.from) + "ex: " + e.getMessage(), sb.toString());
                            com.baidu.adp.lib.g.a.a(randomAccessFile);
                            this.yV = null;
                            return imageUploadResult;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.g.a.a(randomAccessFile);
                        this.yV = null;
                        throw th;
                    }
                }
                com.baidu.adp.lib.g.a.a(randomAccessFile2);
                this.yV = null;
            } catch (Exception e7) {
                randomAccessFile = null;
                e = e7;
                imageUploadResult = null;
            }
            return imageUploadResult;
        } catch (Throwable th3) {
            randomAccessFile = null;
            th = th3;
        }
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
