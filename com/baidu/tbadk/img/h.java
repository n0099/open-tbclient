package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.l;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class h {
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
    private String h = "1";
    private ak i = null;

    public h(String str) {
        this.f = str;
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public final void a(i iVar, Object obj) {
        this.k = iVar;
        this.l = null;
        if (iVar != null) {
            this.a = 10240;
        }
    }

    public final void a() {
        this.g = true;
        if (this.i != null) {
            this.i.g();
        }
    }

    public final void a(WriteImagesInfo writeImagesInfo) {
        Bitmap b;
        UploadedImageInfo uploadedPicInfo;
        String a;
        if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < chosedFiles.size()) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                    if (!imageFileInfo.isAlreadyUploadedToServer()) {
                        if (!this.g) {
                            if (this.j == null) {
                                this.j = new e(TbadkApplication.j().b());
                            }
                            LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                            imageFileInfo.setPageActionsList(null);
                            e eVar = this.j;
                            com.baidu.adp.widget.ImageView.b a2 = e.a(imageFileInfo, true);
                            if (a2 != null) {
                                b = a2.h();
                            } else {
                                e eVar2 = this.j;
                                b = e.b(imageFileInfo, true);
                            }
                            imageFileInfo.setPageActionsList(pageActionsList);
                            ImageUploadResult a3 = (b == null || (a = w.a("tieba_resized_image", b, 80)) == null) ? null : a(a);
                            if (a3 != null && (uploadedPicInfo = a3.getUploadedPicInfo()) != null) {
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

    /* JADX WARN: Code restructure failed: missing block: B:88:0x032c, code lost:
        r3 = null;
        r12.append("|startChunk=");
        r12.append(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0129 A[Catch: all -> 0x0380, TryCatch #0 {all -> 0x0380, blocks: (B:26:0x0123, B:28:0x0129, B:29:0x012e, B:97:0x0377), top: B:110:0x0123 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0377 A[Catch: all -> 0x0380, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0380, blocks: (B:26:0x0123, B:28:0x0129, B:29:0x012e, B:97:0x0377), top: B:110:0x0123 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ImageUploadResult a(String str) {
        ImageUploadResult imageUploadResult;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        int i;
        RandomAccessFile randomAccessFile3 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                File file = new File(str);
                long length = file.length();
                String a = bc.a(w.a(file));
                sb.append("path=");
                sb.append(str);
                sb.append("|length=");
                sb.append(length);
                sb.append("|md5=");
                sb.append(a);
                if (length == 0 || a == null) {
                    ImageUploadResult imageUploadResult2 = new ImageUploadResult();
                    try {
                        imageUploadResult2.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult2.error_msg = TbadkApplication.j().b().getString(l.file_not_exist);
                        TiebaStatic.a("", -1007, "file error: " + imageUploadResult2.error_msg, sb.toString());
                        imageUploadResult = imageUploadResult2;
                        randomAccessFile2 = null;
                    } catch (Exception e) {
                        randomAccessFile = null;
                        imageUploadResult = imageUploadResult2;
                        e = e;
                        try {
                            if (!this.g) {
                                sb.append("|request cancelled.");
                            } else {
                                com.baidu.adp.lib.util.f.b(e.getMessage());
                            }
                            TiebaStatic.a("", -1002, String.valueOf(this.f) + "ex: " + e.getMessage(), sb.toString());
                            com.baidu.adp.lib.f.a.a(randomAccessFile);
                            this.i = null;
                            return imageUploadResult;
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile3 = randomAccessFile;
                            com.baidu.adp.lib.f.a.a(randomAccessFile3);
                            this.i = null;
                            throw th;
                        }
                    }
                } else {
                    String str2 = String.valueOf(a) + this.a;
                    long j = length % ((long) this.a) == 0 ? length / this.a : (length / this.a) + 1;
                    sb.append("|chunkNo=");
                    sb.append(j);
                    randomAccessFile2 = new RandomAccessFile(str, "r");
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
                            imageUploadResult = null;
                            byte[] bArr = null;
                            long j2 = 0;
                            int i2 = 1;
                            int i3 = 0;
                            while (true) {
                                if (i2 > j) {
                                    break;
                                }
                                try {
                                    if (this.g) {
                                        sb.append("|startChunk=");
                                        sb.append(i2);
                                        break;
                                    }
                                    int i4 = 0;
                                    if (i2 > j) {
                                        i4 = 0;
                                        bArr = null;
                                    } else {
                                        if (i2 < j) {
                                            i4 = this.a;
                                        } else if (i2 == j) {
                                            i4 = (int) (length - (this.a * (j - 1)));
                                        }
                                        if (bArr == null || bArr.length != i4) {
                                            bArr = new byte[i4];
                                        }
                                        randomAccessFile2.seek(this.a * (i2 - 1));
                                        randomAccessFile2.read(bArr, 0, i4);
                                    }
                                    this.i = new ak(n.e);
                                    this.i.a("resourceId", str2);
                                    this.i.a("chunkNo", String.valueOf(i2));
                                    if (i2 >= j) {
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
                                    imageUploadResult = ImageUploadResult.parser(this.i.j());
                                    if (imageUploadResult == null || !(imageUploadResult.error_code == 0 || imageUploadResult.error_code == ImageUploadResult.CHUNK_ERROR)) {
                                        break;
                                    }
                                    if (imageUploadResult.error_code == ImageUploadResult.CHUNK_ERROR) {
                                        if (i2 == imageUploadResult.chunkNo || imageUploadResult.chunkNo <= 0) {
                                            break;
                                        }
                                        i = imageUploadResult.chunkNo;
                                    } else {
                                        int i5 = i2 + 1;
                                        j2 += i4;
                                        if (this.k != null) {
                                            i iVar = this.k;
                                            Object obj = this.l;
                                            iVar.a(j2, length);
                                        }
                                        i = i5;
                                    }
                                    int i6 = i3 + 1;
                                    if (i6 > 2 * j) {
                                        sb.append("|possbile dead loop found. tryCount=").append(i6).append(", chunkNo=").append(j);
                                        break;
                                    }
                                    i3 = i6;
                                    i2 = i;
                                } catch (Exception e2) {
                                    randomAccessFile = randomAccessFile2;
                                    e = e2;
                                    if (!this.g) {
                                    }
                                    TiebaStatic.a("", -1002, String.valueOf(this.f) + "ex: " + e.getMessage(), sb.toString());
                                    com.baidu.adp.lib.f.a.a(randomAccessFile);
                                    this.i = null;
                                    return imageUploadResult;
                                }
                            }
                            sb.append("|startChunk=");
                            sb.append(i2);
                            sb.append("|picNull=");
                            sb.append(imageUploadResult == null);
                            sb.append("|picErrNo=");
                            if (imageUploadResult != null) {
                                sb.append(imageUploadResult.error_code);
                            }
                        } catch (Throwable th2) {
                            randomAccessFile3 = randomAccessFile2;
                            th = th2;
                            com.baidu.adp.lib.f.a.a(randomAccessFile3);
                            this.i = null;
                            throw th;
                        }
                    } catch (Exception e3) {
                        imageUploadResult = null;
                        randomAccessFile = randomAccessFile2;
                        e = e3;
                    }
                }
                com.baidu.adp.lib.f.a.a(randomAccessFile2);
                this.i = null;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e4) {
            e = e4;
            imageUploadResult = null;
            randomAccessFile = null;
        }
        return imageUploadResult;
    }

    public final void b(String str) {
        this.h = str;
    }
}
