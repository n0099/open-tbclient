package com.baidu.tieba.im.model;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.InfoData;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.data.UploadPicData2;
import com.baidu.tieba.util.ax;
import com.baidu.tieba.util.bu;
import com.baidu.tieba.util.by;
import com.slidingmenu.lib.R;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class ag {
    public static int a = -1;
    public static int b = -2;
    public static int c = -3;
    public static int d = 2230203;
    public com.baidu.tieba.im.message.b e;
    private String h;
    private int j;
    private int k;
    private int l;
    private int m;
    private ak f = null;
    private aj g = null;
    private String i = null;
    private ai n = null;

    public ag(String str, int i, int i2, int i3, int i4) {
        this.h = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.h = str;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
        LocalViewSize.ImageSize c2 = LocalViewSize.a().c();
        LocalViewSize.ImageSize d2 = LocalViewSize.a().d();
        if (this.j <= 0) {
            this.j = c2.width;
        }
        if (this.k <= 0) {
            this.k = c2.height;
        }
        if (this.l <= 0) {
            this.l = d2.width;
        }
        if (this.m <= 0) {
            this.m = d2.height;
        }
    }

    public void a() {
        if (this.n == null) {
            this.n = new ai(this);
            this.n.execute(new String[0]);
        }
    }

    public void b() {
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
        }
    }

    public void a(ak akVar) {
        this.f = akVar;
    }

    public void a(aj ajVar) {
        this.g = ajVar;
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(com.baidu.tieba.im.message.b bVar) {
        this.e = bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02a4, code lost:
        r3 = null;
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0120, code lost:
        r8.append("|startChunk=");
        r8.append(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0128, code lost:
        r2 = r1;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x026d, code lost:
        r8.append("|startChunk=");
        r8.append(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0275, code lost:
        r2 = null;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02a3, code lost:
        r3 = move-exception;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InfoData a(boolean z, String str) {
        RandomAccessFile randomAccessFile;
        Exception e;
        Throwable th;
        UploadPicData2 uploadPicData2;
        InfoData infoData;
        String str2;
        long length;
        String a2;
        int i;
        int i2;
        UploadPicData2 uploadPicData22 = null;
        RandomAccessFile randomAccessFile2 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                str2 = this.h;
                File file = new File(str2);
                length = file.length();
                a2 = bu.a(com.baidu.tieba.util.ad.a(file));
                sb.append("path=");
                sb.append(str2);
                sb.append("|length=");
                sb.append(length);
                sb.append("|md5=");
                sb.append(a2);
            } catch (Throwable th2) {
                randomAccessFile = null;
                th = th2;
            }
        } catch (Exception e2) {
            randomAccessFile = null;
            e = e2;
        }
        if (length == 0 || a2 == null) {
            uploadPicData2 = new UploadPicData2();
            try {
                uploadPicData2.error_code = a;
                uploadPicData2.error_msg = TiebaApplication.h().getString(R.string.file_not_exist);
                by.a("", -1007, "file error: " + uploadPicData2.error_msg, sb.toString());
            } catch (Exception e3) {
                uploadPicData22 = uploadPicData2;
                randomAccessFile = null;
                e = e3;
                com.baidu.adp.lib.g.e.a(e.getMessage());
                by.a("", -1002, str + "ex: " + e.getMessage(), sb.toString());
                com.baidu.adp.lib.f.a.a(randomAccessFile);
                uploadPicData2 = uploadPicData22;
                infoData = null;
                if (uploadPicData2 != null) {
                }
                return infoData;
            }
        } else {
            String str3 = a2 + 10240;
            long j = length % 10240 == 0 ? length / 10240 : (length / 10240) + 1;
            sb.append("|chunkNo=");
            sb.append(j);
            randomAccessFile = new RandomAccessFile(str2, "r");
            byte[] bArr = null;
            try {
                try {
                    sb.append("|width=");
                    sb.append(this.l);
                    sb.append("|height=");
                    sb.append(this.m);
                    sb.append("|smallWidth=");
                    sb.append(this.j);
                    sb.append("|smallHeight=");
                    sb.append(this.k);
                    sb.append("|groupId=");
                    sb.append(1);
                    i = 1;
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.f.a.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
            while (true) {
                i2 = i;
                UploadPicData2 uploadPicData23 = uploadPicData22;
                byte[] bArr2 = bArr;
                if (i2 > j) {
                    uploadPicData2 = uploadPicData23;
                    randomAccessFile2 = randomAccessFile;
                    break;
                }
                if (z) {
                    break;
                }
                int i3 = 0;
                if (i2 > j) {
                    bArr = null;
                } else {
                    if (i2 < j) {
                        i3 = 10240;
                    } else if (i2 == j) {
                        i3 = (int) (length - (10240 * (j - 1)));
                    }
                    if (bArr2 == null || bArr2.length != i3) {
                        bArr2 = new byte[i3];
                    }
                    randomAccessFile.seek((i2 - 1) * 10240);
                    randomAccessFile.read(bArr2, 0, i3);
                    bArr = bArr2;
                }
                ax axVar = new ax(com.baidu.tieba.im.j.g);
                axVar.a("resourceId", str3);
                axVar.a("chunkNo", String.valueOf(i2));
                if (i2 >= j) {
                    try {
                        axVar.a("isFinish", String.valueOf(1));
                    } catch (Exception e5) {
                        uploadPicData22 = uploadPicData23;
                        e = e5;
                        com.baidu.adp.lib.g.e.a(e.getMessage());
                        by.a("", -1002, str + "ex: " + e.getMessage(), sb.toString());
                        com.baidu.adp.lib.f.a.a(randomAccessFile);
                        uploadPicData2 = uploadPicData22;
                        infoData = null;
                        if (uploadPicData2 != null) {
                        }
                        return infoData;
                    }
                } else {
                    axVar.a("isFinish", String.valueOf(0));
                }
                axVar.a("width", String.valueOf(this.l));
                axVar.a("height", String.valueOf(this.m));
                axVar.a("smallWidth", String.valueOf(this.j));
                axVar.a("smallHeight", String.valueOf(this.k));
                axVar.a("groupId", String.valueOf(1));
                axVar.a("alt", "json");
                if (bArr != null) {
                    axVar.a("chunk", bArr);
                }
                uploadPicData22 = UploadPicData2.parser(axVar.o());
                if (uploadPicData22 == null || !(uploadPicData22.error_code == 0 || uploadPicData22.error_code == d)) {
                    break;
                } else if (uploadPicData22.error_code == d) {
                    if (i2 == uploadPicData22.chunkNo || uploadPicData22.chunkNo <= 0) {
                        break;
                    }
                    i = uploadPicData22.chunkNo;
                } else {
                    i = i2 + 1;
                }
                infoData = null;
                if (uploadPicData2 != null && uploadPicData2.error_code == 0) {
                    infoData = new InfoData();
                    infoData.setPic_id(String.valueOf(uploadPicData2.picId));
                    if (uploadPicData2.picInfo != null && uploadPicData2.picInfo.originPic != null) {
                        infoData.setHeight(uploadPicData2.picInfo.originPic.height);
                        infoData.setWidth(uploadPicData2.picInfo.originPic.width);
                    }
                }
                return infoData;
            }
            sb.append("|startChunk=");
            sb.append(i2);
            sb.append("|picNull=");
            sb.append(uploadPicData22 == null);
            sb.append("|picErrNo=");
            if (uploadPicData22 != null) {
                sb.append(uploadPicData22.error_code);
                randomAccessFile2 = randomAccessFile;
                uploadPicData2 = uploadPicData22;
            } else {
                randomAccessFile2 = randomAccessFile;
                uploadPicData2 = uploadPicData22;
            }
        }
        com.baidu.adp.lib.f.a.a(randomAccessFile2);
        infoData = null;
        if (uploadPicData2 != null) {
            infoData = new InfoData();
            infoData.setPic_id(String.valueOf(uploadPicData2.picId));
            if (uploadPicData2.picInfo != null) {
                infoData.setHeight(uploadPicData2.picInfo.originPic.height);
                infoData.setWidth(uploadPicData2.picInfo.originPic.width);
            }
        }
        return infoData;
    }
}
