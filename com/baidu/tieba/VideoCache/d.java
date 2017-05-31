package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.az;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d implements Runnable {
    final /* synthetic */ c aSB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aSB = cVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:129:0x055a */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String str;
        boolean z;
        boolean z2;
        String str2;
        String str3;
        String str4;
        long j;
        String str5;
        String str6;
        String str7;
        String str8;
        long j2;
        long j3;
        boolean z3;
        long j4;
        long j5;
        long j6;
        File file;
        boolean z4;
        String str9;
        long j7;
        String sb;
        String str10;
        String str11;
        long j8;
        boolean z5;
        FileInputStream fileInputStream;
        long j9;
        Object obj;
        Object obj2;
        boolean z6;
        String str12;
        String str13;
        long j10;
        long j11;
        boolean z7;
        long j12;
        String str14;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j20;
        String str15;
        FileInputStream fileInputStream2;
        boolean z8;
        String str16;
        String str17;
        boolean z9;
        boolean z10;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        byte[] bArr;
        String str29;
        long j21;
        boolean z11;
        byte[] bArr2;
        long j22;
        Object obj3;
        Object obj4;
        String str30;
        boolean z12;
        long j23;
        String str31;
        long j24;
        boolean z13;
        long parseInt;
        boolean z14;
        long j25;
        long j26;
        boolean z15;
        String str32;
        boolean z16;
        String str33;
        String str34;
        str = c.TAG;
        k.log(str, "test run in " + this.aSB);
        while (f.JK().t(this.aSB)) {
            f JK = f.JK();
            str32 = this.aSB.mVideoUrl;
            JK.gD(str32);
            try {
                str33 = c.TAG;
                k.log(str33, "mDownloadRunnable sleep in..." + this.aSB);
                Thread.sleep(100L);
                str34 = c.TAG;
                k.log(str34, "mDownloadRunnable sleep out..." + this.aSB);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            z16 = this.aSB.aSt;
            if (z16) {
                break;
            }
        }
        z = this.aSB.aSt;
        if (!z) {
            f.JK().r(this.aSB);
        }
        while (true) {
            z2 = this.aSB.aSt;
            if (z2) {
                break;
            }
            str3 = c.TAG;
            k.log(str3, "download in " + this.aSB);
            str4 = this.aSB.aSy;
            long gM = o.gM(str4);
            j = this.aSB.aoG;
            if (gM <= j) {
                this.aSB.aSw = -1L;
                str8 = this.aSB.aSu;
                File file2 = new File(str8);
                j2 = this.aSB.aSp;
                j3 = this.aSB.aSo;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        z15 = this.aSB.aSt;
                        if (z15) {
                            break;
                        }
                        if (file3 != null && file3.exists()) {
                            try {
                                Long.parseLong(file3.getName());
                                if (o.getFileSize(file3) == 0) {
                                    file3.delete();
                                } else {
                                    arrayList.add(file3);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                file3.delete();
                            }
                        }
                    }
                }
                z3 = this.aSB.aSt;
                if (z3) {
                    break;
                }
                Collections.sort(arrayList, new StartPositionComparator());
                File[] fileArr = new File[arrayList.size()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= fileArr.length) {
                        break;
                    }
                    fileArr[i2] = (File) arrayList.get(i2);
                    i = i2 + 1;
                }
                if (fileArr == null || fileArr.length <= 0) {
                    j4 = 0;
                    j5 = 0;
                    j6 = j3;
                    file = null;
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 < fileArr.length) {
                            z14 = this.aSB.aSt;
                            if (z14) {
                                j4 = 0;
                                j5 = 0;
                                j24 = j2;
                                file = null;
                                break;
                            }
                            File file4 = fileArr[i3];
                            try {
                                long parseInt2 = Integer.parseInt(file4.getName());
                                long fileSize = o.getFileSize(file4);
                                long j27 = (parseInt2 + fileSize) - 1;
                                j25 = this.aSB.aSp;
                                if (j25 >= parseInt2) {
                                    j26 = this.aSB.aSp;
                                    if (j26 <= j27) {
                                        file = file4;
                                        j24 = parseInt2 + fileSize;
                                        j4 = parseInt2;
                                        j5 = fileSize;
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            } catch (Exception e3) {
                            }
                            i3++;
                        } else {
                            j4 = 0;
                            j5 = 0;
                            j24 = j2;
                            file = null;
                            break;
                        }
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= fileArr.length) {
                            j2 = j24;
                            j6 = j3;
                            break;
                        }
                        z13 = this.aSB.aSt;
                        if (z13) {
                            j2 = j24;
                            j6 = j3;
                            break;
                        }
                        try {
                            parseInt = Integer.parseInt(fileArr[i4].getName());
                        } catch (Exception e4) {
                        }
                        if (parseInt < j24) {
                            i4++;
                        } else {
                            j2 = j24;
                            j6 = parseInt - 1;
                            break;
                        }
                    }
                }
                z4 = this.aSB.aSt;
                if (z4) {
                    break;
                }
                if (file == null) {
                    str9 = this.aSB.aSu;
                    StringBuilder append = new StringBuilder(String.valueOf(str9)).append("/");
                    j7 = this.aSB.aSp;
                    sb = append.append(j7).toString();
                    try {
                        new File(sb).createNewFile();
                    } catch (IOException e5) {
                        as Z = new as("c12027").Z("errormsg", "创建缓存文件出现异常").Z("name", sb).Z("error", e5.getMessage());
                        str10 = this.aSB.mVideoUrl;
                        TiebaStatic.log(Z.Z("url", str10));
                        e5.printStackTrace();
                    }
                    if ((j6 - j2) + 1 > 4194304) {
                        str11 = sb;
                        j8 = (4194304 + j2) - 1;
                        z5 = false;
                    }
                    str11 = sb;
                    j8 = j6;
                    z5 = false;
                } else {
                    sb = file.getAbsolutePath();
                    long length = file.length();
                    if (length >= 4194304) {
                        str11 = sb;
                        j8 = j6;
                        z5 = true;
                    } else {
                        if ((j6 - j2) + 1 + length > 4194304) {
                            str11 = sb;
                            j8 = ((4194304 - length) + j2) - 1;
                            z5 = false;
                        }
                        str11 = sb;
                        j8 = j6;
                        z5 = false;
                    }
                }
                try {
                    this.aSB.aSs = new FileInputStream(str11);
                    if (file != null) {
                        try {
                            fileInputStream = this.aSB.aSs;
                            j9 = this.aSB.aSp;
                            fileInputStream.skip(j9 - j4);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (file != null) {
                        this.aSB.aSr = j4 + j5;
                    }
                    this.aSB.aSv = true;
                    obj = this.aSB.mLock;
                    synchronized (obj) {
                        obj2 = this.aSB.mLock;
                        obj2.notify();
                    }
                    if (file != null) {
                        j23 = this.aSB.aSo;
                        if (j2 > j23) {
                            str31 = c.TAG;
                            k.log(str31, "do not download, return " + this.aSB);
                            break;
                        }
                    }
                    z6 = this.aSB.aSt;
                    if (z6) {
                        break;
                    }
                    str12 = c.TAG;
                    k.log(str12, "download range is " + j2 + "-" + j8);
                    if (j2 <= j8 && !z5) {
                        try {
                            str20 = this.aSB.mVideoUrl;
                            URL url = new URL(str20);
                            str21 = c.TAG;
                            k.log(str21, "url opt 1 " + this.aSB);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            str22 = c.TAG;
                            k.log(str22, "url opt 2 " + this.aSB);
                            httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + "-" + j8);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            str23 = c.TAG;
                            k.log(str23, "url opt 3 " + this.aSB);
                            InputStream inputStream = httpURLConnection.getInputStream();
                            while (inputStream == null) {
                                str30 = c.TAG;
                                k.log(str30, "conn input is null " + this.aSB);
                                z12 = this.aSB.aSt;
                                if (z12) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e7) {
                                    e7.printStackTrace();
                                }
                                inputStream = httpURLConnection.getInputStream();
                            }
                            str24 = c.TAG;
                            k.log(str24, "got conn input " + this.aSB);
                            str25 = c.TAG;
                            k.log(str25, "url opt 4 " + this.aSB);
                            int i5 = 0;
                            FileOutputStream fileOutputStream = new FileOutputStream(str11, true);
                            str26 = c.TAG;
                            k.log(str26, "read start ..." + this.aSB);
                            while (true) {
                                try {
                                    bArr = this.aSB.aSz;
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    z11 = this.aSB.aSt;
                                    if (z11) {
                                        break;
                                    }
                                    bArr2 = this.aSB.aSz;
                                    fileOutputStream.write(bArr2, 0, read);
                                    c cVar = this.aSB;
                                    j22 = cVar.aSr;
                                    cVar.aSr = j22 + read;
                                    i5 += read;
                                    obj3 = this.aSB.mLock;
                                    synchronized (obj3) {
                                        obj4 = this.aSB.mLock;
                                        obj4.notify();
                                    }
                                } catch (Exception e8) {
                                    as r = new as("c12027").Z("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").Z("error", e8.getMessage()).r("dsize", i5);
                                    str27 = this.aSB.mVideoUrl;
                                    TiebaStatic.log(r.Z("url", str27));
                                    e8.printStackTrace();
                                }
                            }
                            str29 = this.aSB.mVideoUrl;
                            j21 = this.aSB.aoG;
                            az.i(str29, i5, (int) j21);
                            str28 = c.TAG;
                            k.log(str28, "read end ..." + this.aSB);
                            fileOutputStream.close();
                            l.JS().q(inputStream);
                            this.aSB.aSw = j8;
                        } catch (Exception e9) {
                            as Z2 = new as("c12027").Z("errormsg", "连接中断，文件下载出现异常").Z("error", e9.getMessage());
                            str18 = this.aSB.mVideoUrl;
                            TiebaStatic.log(Z2.Z("url", str18));
                            str19 = c.TAG;
                            k.log(str19, "download exception " + this.aSB);
                            e9.printStackTrace();
                        }
                    } else {
                        this.aSB.aSw = (j4 + j5) - 1;
                    }
                    str13 = c.TAG;
                    k.log(str13, "download out " + this.aSB);
                    while (j10 < j11) {
                        z9 = this.aSB.aSt;
                        if (z9) {
                            break;
                        }
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e10) {
                            e10.printStackTrace();
                        }
                        z10 = this.aSB.aSt;
                        if (z10) {
                            break;
                        }
                    }
                    z7 = this.aSB.aSt;
                    if (z7) {
                        break;
                    }
                    j12 = this.aSB.aSq;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length; i7++) {
                        z8 = this.aSB.aSt;
                        if (z8) {
                            break;
                        }
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (this.aSB.aSx) {
                                if (length2 != 0) {
                                    file5.delete();
                                    str17 = c.TAG;
                                    k.log(str17, "release some cached slices " + this.aSB);
                                }
                            } else {
                                long fileSize2 = o.getFileSize(file5);
                                if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j12 && (i6 = (int) (i6 + fileSize2)) > 31457280) {
                                    this.aSB.aSx = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        str16 = c.TAG;
                                        k.log(str16, "release some cached slices " + this.aSB);
                                    }
                                }
                            }
                        }
                    }
                    str14 = c.TAG;
                    StringBuilder sb2 = new StringBuilder("mLastRequestRangeEnd ");
                    j13 = this.aSB.aSw;
                    StringBuilder append2 = sb2.append(j13).append(" mReadPosition ");
                    j14 = this.aSB.aSq;
                    k.log(str14, append2.append(j14).append(" ").append(" ").append(this.aSB).toString());
                    j15 = this.aSB.aSw;
                    if (j15 == -1) {
                        break;
                    }
                    j16 = this.aSB.aSq;
                    j17 = this.aSB.aSw;
                    if (j16 <= j17) {
                        break;
                    }
                    j18 = this.aSB.aSw;
                    j19 = this.aSB.aSo;
                    if (j18 >= j19) {
                        break;
                    }
                    try {
                        fileInputStream2 = this.aSB.aSs;
                        fileInputStream2.close();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    this.aSB.aSv = false;
                    c cVar2 = this.aSB;
                    j20 = this.aSB.aSw;
                    cVar2.aSp = j20 + 1;
                    str15 = c.TAG;
                    k.log(str15, "continue to download... " + this.aSB);
                } catch (FileNotFoundException e12) {
                    e12.printStackTrace();
                }
            } else {
                StringBuilder sb3 = new StringBuilder(String.valueOf(j.aST));
                str5 = this.aSB.aSy;
                o.x(new File(sb3.append(str5).append("/").append("segments").toString()));
                as Z3 = new as("c12028").Z("errormsg", "校验到缓存文件片段大小有异常");
                str6 = this.aSB.mVideoUrl;
                TiebaStatic.log(Z3.Z("url", str6));
                str7 = c.TAG;
                k.log(str7, "cache error !");
                break;
            }
        }
        f.JK().s(this.aSB);
        str2 = c.TAG;
        k.log(str2, "test run out ***************************************************************" + this.aSB);
    }
}
