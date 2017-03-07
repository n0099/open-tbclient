package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.ay;
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
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aUo = cVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:129:0x0564 */
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
        k.log(str, "test run in " + this.aUo);
        while (f.Lb().t(this.aUo)) {
            f Lb = f.Lb();
            str32 = this.aUo.aTZ;
            Lb.gG(str32);
            try {
                str33 = c.TAG;
                k.log(str33, "mDownloadRunnable sleep in..." + this.aUo);
                Thread.sleep(100L);
                str34 = c.TAG;
                k.log(str34, "mDownloadRunnable sleep out..." + this.aUo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            z16 = this.aUo.aUg;
            if (z16) {
                break;
            }
        }
        z = this.aUo.aUg;
        if (!z) {
            f.Lb().r(this.aUo);
        }
        while (true) {
            z2 = this.aUo.aUg;
            if (z2) {
                break;
            }
            str3 = c.TAG;
            k.log(str3, "download in " + this.aUo);
            str4 = this.aUo.aUl;
            long gP = o.gP(str4);
            j = this.aUo.aoC;
            if (gP <= j) {
                this.aUo.aUj = -1L;
                str8 = this.aUo.aUh;
                File file2 = new File(str8);
                j2 = this.aUo.aUc;
                j3 = this.aUo.aUb;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        z15 = this.aUo.aUg;
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
                z3 = this.aUo.aUg;
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
                            z14 = this.aUo.aUg;
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
                                j25 = this.aUo.aUc;
                                if (j25 >= parseInt2) {
                                    j26 = this.aUo.aUc;
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
                        z13 = this.aUo.aUg;
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
                z4 = this.aUo.aUg;
                if (z4) {
                    break;
                }
                if (file == null) {
                    str9 = this.aUo.aUh;
                    StringBuilder append = new StringBuilder(String.valueOf(str9)).append("/");
                    j7 = this.aUo.aUc;
                    sb = append.append(j7).toString();
                    try {
                        new File(sb).createNewFile();
                    } catch (IOException e5) {
                        as Z = new as("c12027").Z("errormsg", "创建缓存文件出现异常").Z("name", sb).Z("error", e5.getMessage());
                        str10 = this.aUo.aTZ;
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
                    this.aUo.aUf = new FileInputStream(str11);
                    if (file != null) {
                        try {
                            fileInputStream = this.aUo.aUf;
                            j9 = this.aUo.aUc;
                            fileInputStream.skip(j9 - j4);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (file != null) {
                        this.aUo.aUe = j4 + j5;
                    }
                    this.aUo.aUi = true;
                    obj = this.aUo.mLock;
                    synchronized (obj) {
                        obj2 = this.aUo.mLock;
                        obj2.notify();
                    }
                    if (file != null) {
                        j23 = this.aUo.aUb;
                        if (j2 > j23) {
                            str31 = c.TAG;
                            k.log(str31, "do not download, return " + this.aUo);
                            break;
                        }
                    }
                    z6 = this.aUo.aUg;
                    if (z6) {
                        break;
                    }
                    str12 = c.TAG;
                    k.log(str12, "download range is " + j2 + "-" + j8);
                    if (j2 <= j8 && !z5) {
                        try {
                            str20 = this.aUo.aTZ;
                            URL url = new URL(str20);
                            str21 = c.TAG;
                            k.log(str21, "url opt 1 " + this.aUo);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            str22 = c.TAG;
                            k.log(str22, "url opt 2 " + this.aUo);
                            httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + "-" + j8);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            str23 = c.TAG;
                            k.log(str23, "url opt 3 " + this.aUo);
                            InputStream inputStream = httpURLConnection.getInputStream();
                            while (inputStream == null) {
                                str30 = c.TAG;
                                k.log(str30, "conn input is null " + this.aUo);
                                z12 = this.aUo.aUg;
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
                            k.log(str24, "got conn input " + this.aUo);
                            str25 = c.TAG;
                            k.log(str25, "url opt 4 " + this.aUo);
                            int i5 = 0;
                            FileOutputStream fileOutputStream = new FileOutputStream(str11, true);
                            str26 = c.TAG;
                            k.log(str26, "read start ..." + this.aUo);
                            while (true) {
                                try {
                                    bArr = this.aUo.aUm;
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    z11 = this.aUo.aUg;
                                    if (z11) {
                                        break;
                                    }
                                    bArr2 = this.aUo.aUm;
                                    fileOutputStream.write(bArr2, 0, read);
                                    c cVar = this.aUo;
                                    j22 = cVar.aUe;
                                    cVar.aUe = j22 + read;
                                    i5 += read;
                                    obj3 = this.aUo.mLock;
                                    synchronized (obj3) {
                                        obj4 = this.aUo.mLock;
                                        obj4.notify();
                                    }
                                } catch (Exception e8) {
                                    as s = new as("c12027").Z("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").Z("error", e8.getMessage()).s("dsize", i5);
                                    str27 = this.aUo.aTZ;
                                    TiebaStatic.log(s.Z("url", str27));
                                    e8.printStackTrace();
                                }
                            }
                            str29 = this.aUo.aTZ;
                            j21 = this.aUo.aoC;
                            ay.i(str29, i5, (int) j21);
                            str28 = c.TAG;
                            k.log(str28, "read end ..." + this.aUo);
                            fileOutputStream.close();
                            l.Lj().n(inputStream);
                            this.aUo.aUj = j8;
                        } catch (Exception e9) {
                            as Z2 = new as("c12027").Z("errormsg", "连接中断，文件下载出现异常").Z("error", e9.getMessage());
                            str18 = this.aUo.aTZ;
                            TiebaStatic.log(Z2.Z("url", str18));
                            str19 = c.TAG;
                            k.log(str19, "download exception " + this.aUo);
                            e9.printStackTrace();
                        }
                    } else {
                        this.aUo.aUj = (j4 + j5) - 1;
                    }
                    str13 = c.TAG;
                    k.log(str13, "download out " + this.aUo);
                    while (j10 < j11) {
                        z9 = this.aUo.aUg;
                        if (z9) {
                            break;
                        }
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e10) {
                            e10.printStackTrace();
                        }
                        z10 = this.aUo.aUg;
                        if (z10) {
                            break;
                        }
                    }
                    z7 = this.aUo.aUg;
                    if (z7) {
                        break;
                    }
                    j12 = this.aUo.aUd;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length; i7++) {
                        z8 = this.aUo.aUg;
                        if (z8) {
                            break;
                        }
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (this.aUo.aUk) {
                                if (length2 != 0) {
                                    file5.delete();
                                    str17 = c.TAG;
                                    k.log(str17, "release some cached slices " + this.aUo);
                                }
                            } else {
                                long fileSize2 = o.getFileSize(file5);
                                if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j12 && (i6 = (int) (i6 + fileSize2)) > 31457280) {
                                    this.aUo.aUk = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        str16 = c.TAG;
                                        k.log(str16, "release some cached slices " + this.aUo);
                                    }
                                }
                            }
                        }
                    }
                    str14 = c.TAG;
                    StringBuilder sb2 = new StringBuilder("mLastRequestRangeEnd ");
                    j13 = this.aUo.aUj;
                    StringBuilder append2 = sb2.append(j13).append(" mReadPosition ");
                    j14 = this.aUo.aUd;
                    k.log(str14, append2.append(j14).append(" ").append(" ").append(this.aUo).toString());
                    j15 = this.aUo.aUj;
                    if (j15 == -1) {
                        break;
                    }
                    j16 = this.aUo.aUd;
                    j17 = this.aUo.aUj;
                    if (j16 <= j17) {
                        break;
                    }
                    j18 = this.aUo.aUj;
                    j19 = this.aUo.aUb;
                    if (j18 >= j19) {
                        break;
                    }
                    try {
                        fileInputStream2 = this.aUo.aUf;
                        fileInputStream2.close();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    this.aUo.aUi = false;
                    c cVar2 = this.aUo;
                    j20 = this.aUo.aUj;
                    cVar2.aUc = j20 + 1;
                    str15 = c.TAG;
                    k.log(str15, "continue to download... " + this.aUo);
                } catch (FileNotFoundException e12) {
                    e12.printStackTrace();
                }
            } else {
                StringBuilder sb3 = new StringBuilder(String.valueOf(j.aUH));
                str5 = this.aUo.aUl;
                o.w(new File(sb3.append(str5).append("/").append("segments").toString()));
                as Z3 = new as("c12028").Z("errormsg", "校验到缓存文件片段大小有异常");
                str6 = this.aUo.aTZ;
                TiebaStatic.log(Z3.Z("url", str6));
                str7 = c.TAG;
                k.log(str7, "cache error !");
                break;
            }
        }
        f.Lb().s(this.aUo);
        str2 = c.TAG;
        k.log(str2, "test run out ***************************************************************" + this.aUo);
    }
}
