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
    final /* synthetic */ c aUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aUE = cVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:129:0x0562 */
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
        k.log(str, "test run in " + this.aUE);
        while (f.LB().t(this.aUE)) {
            f LB = f.LB();
            str32 = this.aUE.mVideoUrl;
            LB.gK(str32);
            try {
                str33 = c.TAG;
                k.log(str33, "mDownloadRunnable sleep in..." + this.aUE);
                Thread.sleep(100L);
                str34 = c.TAG;
                k.log(str34, "mDownloadRunnable sleep out..." + this.aUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            z16 = this.aUE.aUw;
            if (z16) {
                break;
            }
        }
        z = this.aUE.aUw;
        if (!z) {
            f.LB().r(this.aUE);
        }
        while (true) {
            z2 = this.aUE.aUw;
            if (z2) {
                break;
            }
            str3 = c.TAG;
            k.log(str3, "download in " + this.aUE);
            str4 = this.aUE.aUB;
            long gT = o.gT(str4);
            j = this.aUE.aoR;
            if (gT <= j) {
                this.aUE.aUz = -1L;
                str8 = this.aUE.aUx;
                File file2 = new File(str8);
                j2 = this.aUE.aUs;
                j3 = this.aUE.aUr;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        z15 = this.aUE.aUw;
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
                z3 = this.aUE.aUw;
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
                            z14 = this.aUE.aUw;
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
                                j25 = this.aUE.aUs;
                                if (j25 >= parseInt2) {
                                    j26 = this.aUE.aUs;
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
                        z13 = this.aUE.aUw;
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
                z4 = this.aUE.aUw;
                if (z4) {
                    break;
                }
                if (file == null) {
                    str9 = this.aUE.aUx;
                    StringBuilder append = new StringBuilder(String.valueOf(str9)).append("/");
                    j7 = this.aUE.aUs;
                    sb = append.append(j7).toString();
                    try {
                        new File(sb).createNewFile();
                    } catch (IOException e5) {
                        as aa = new as("c12027").aa("errormsg", "创建缓存文件出现异常").aa("name", sb).aa("error", e5.getMessage());
                        str10 = this.aUE.mVideoUrl;
                        TiebaStatic.log(aa.aa("url", str10));
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
                    this.aUE.aUv = new FileInputStream(str11);
                    if (file != null) {
                        try {
                            fileInputStream = this.aUE.aUv;
                            j9 = this.aUE.aUs;
                            fileInputStream.skip(j9 - j4);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (file != null) {
                        this.aUE.aUu = j4 + j5;
                    }
                    this.aUE.aUy = true;
                    obj = this.aUE.mLock;
                    synchronized (obj) {
                        obj2 = this.aUE.mLock;
                        obj2.notify();
                    }
                    if (file != null) {
                        j23 = this.aUE.aUr;
                        if (j2 > j23) {
                            str31 = c.TAG;
                            k.log(str31, "do not download, return " + this.aUE);
                            break;
                        }
                    }
                    z6 = this.aUE.aUw;
                    if (z6) {
                        break;
                    }
                    str12 = c.TAG;
                    k.log(str12, "download range is " + j2 + "-" + j8);
                    if (j2 <= j8 && !z5) {
                        try {
                            str20 = this.aUE.mVideoUrl;
                            URL url = new URL(str20);
                            str21 = c.TAG;
                            k.log(str21, "url opt 1 " + this.aUE);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            str22 = c.TAG;
                            k.log(str22, "url opt 2 " + this.aUE);
                            httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + "-" + j8);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            str23 = c.TAG;
                            k.log(str23, "url opt 3 " + this.aUE);
                            InputStream inputStream = httpURLConnection.getInputStream();
                            while (inputStream == null) {
                                str30 = c.TAG;
                                k.log(str30, "conn input is null " + this.aUE);
                                z12 = this.aUE.aUw;
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
                            k.log(str24, "got conn input " + this.aUE);
                            str25 = c.TAG;
                            k.log(str25, "url opt 4 " + this.aUE);
                            int i5 = 0;
                            FileOutputStream fileOutputStream = new FileOutputStream(str11, true);
                            str26 = c.TAG;
                            k.log(str26, "read start ..." + this.aUE);
                            while (true) {
                                try {
                                    bArr = this.aUE.aUC;
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    z11 = this.aUE.aUw;
                                    if (z11) {
                                        break;
                                    }
                                    bArr2 = this.aUE.aUC;
                                    fileOutputStream.write(bArr2, 0, read);
                                    c cVar = this.aUE;
                                    j22 = cVar.aUu;
                                    cVar.aUu = j22 + read;
                                    i5 += read;
                                    obj3 = this.aUE.mLock;
                                    synchronized (obj3) {
                                        obj4 = this.aUE.mLock;
                                        obj4.notify();
                                    }
                                } catch (Exception e8) {
                                    as s = new as("c12027").aa("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").aa("error", e8.getMessage()).s("dsize", i5);
                                    str27 = this.aUE.mVideoUrl;
                                    TiebaStatic.log(s.aa("url", str27));
                                    e8.printStackTrace();
                                }
                            }
                            str29 = this.aUE.mVideoUrl;
                            j21 = this.aUE.aoR;
                            ay.i(str29, i5, (int) j21);
                            str28 = c.TAG;
                            k.log(str28, "read end ..." + this.aUE);
                            fileOutputStream.close();
                            l.LJ().q(inputStream);
                            this.aUE.aUz = j8;
                        } catch (Exception e9) {
                            as aa2 = new as("c12027").aa("errormsg", "连接中断，文件下载出现异常").aa("error", e9.getMessage());
                            str18 = this.aUE.mVideoUrl;
                            TiebaStatic.log(aa2.aa("url", str18));
                            str19 = c.TAG;
                            k.log(str19, "download exception " + this.aUE);
                            e9.printStackTrace();
                        }
                    } else {
                        this.aUE.aUz = (j4 + j5) - 1;
                    }
                    str13 = c.TAG;
                    k.log(str13, "download out " + this.aUE);
                    while (j10 < j11) {
                        z9 = this.aUE.aUw;
                        if (z9) {
                            break;
                        }
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e10) {
                            e10.printStackTrace();
                        }
                        z10 = this.aUE.aUw;
                        if (z10) {
                            break;
                        }
                    }
                    z7 = this.aUE.aUw;
                    if (z7) {
                        break;
                    }
                    j12 = this.aUE.aUt;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length; i7++) {
                        z8 = this.aUE.aUw;
                        if (z8) {
                            break;
                        }
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (this.aUE.aUA) {
                                if (length2 != 0) {
                                    file5.delete();
                                    str17 = c.TAG;
                                    k.log(str17, "release some cached slices " + this.aUE);
                                }
                            } else {
                                long fileSize2 = o.getFileSize(file5);
                                if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j12 && (i6 = (int) (i6 + fileSize2)) > 31457280) {
                                    this.aUE.aUA = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        str16 = c.TAG;
                                        k.log(str16, "release some cached slices " + this.aUE);
                                    }
                                }
                            }
                        }
                    }
                    str14 = c.TAG;
                    StringBuilder sb2 = new StringBuilder("mLastRequestRangeEnd ");
                    j13 = this.aUE.aUz;
                    StringBuilder append2 = sb2.append(j13).append(" mReadPosition ");
                    j14 = this.aUE.aUt;
                    k.log(str14, append2.append(j14).append(" ").append(" ").append(this.aUE).toString());
                    j15 = this.aUE.aUz;
                    if (j15 == -1) {
                        break;
                    }
                    j16 = this.aUE.aUt;
                    j17 = this.aUE.aUz;
                    if (j16 <= j17) {
                        break;
                    }
                    j18 = this.aUE.aUz;
                    j19 = this.aUE.aUr;
                    if (j18 >= j19) {
                        break;
                    }
                    try {
                        fileInputStream2 = this.aUE.aUv;
                        fileInputStream2.close();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    this.aUE.aUy = false;
                    c cVar2 = this.aUE;
                    j20 = this.aUE.aUz;
                    cVar2.aUs = j20 + 1;
                    str15 = c.TAG;
                    k.log(str15, "continue to download... " + this.aUE);
                } catch (FileNotFoundException e12) {
                    e12.printStackTrace();
                }
            } else {
                StringBuilder sb3 = new StringBuilder(String.valueOf(j.aUW));
                str5 = this.aUE.aUB;
                o.x(new File(sb3.append(str5).append("/").append("segments").toString()));
                as aa3 = new as("c12028").aa("errormsg", "校验到缓存文件片段大小有异常");
                str6 = this.aUE.mVideoUrl;
                TiebaStatic.log(aa3.aa("url", str6));
                str7 = c.TAG;
                k.log(str7, "cache error !");
                break;
            }
        }
        f.LB().s(this.aUE);
        str2 = c.TAG;
        k.log(str2, "test run out ***************************************************************" + this.aUE);
    }
}
