package com.baidu.tieba.VideoCache;

import com.baidu.tieba.play.aw;
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
    final /* synthetic */ c aPy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aPy = cVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:129:0x0509 */
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
        long j2;
        long j3;
        boolean z3;
        long j4;
        long j5;
        long j6;
        File file;
        boolean z4;
        String str8;
        long j7;
        String sb;
        String str9;
        long j8;
        boolean z5;
        FileInputStream fileInputStream;
        long j9;
        Object obj;
        Object obj2;
        boolean z6;
        String str10;
        String str11;
        long j10;
        long j11;
        boolean z7;
        long j12;
        String str12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j20;
        String str13;
        FileInputStream fileInputStream2;
        boolean z8;
        String str14;
        String str15;
        boolean z9;
        boolean z10;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        byte[] bArr;
        String str25;
        long j21;
        boolean z11;
        byte[] bArr2;
        long j22;
        Object obj3;
        Object obj4;
        String str26;
        boolean z12;
        long j23;
        String str27;
        long j24;
        boolean z13;
        long parseInt;
        boolean z14;
        long j25;
        long j26;
        boolean z15;
        String str28;
        boolean z16;
        String str29;
        String str30;
        str = c.TAG;
        k.log(str, "test run in " + this.aPy);
        while (f.Kh().t(this.aPy)) {
            f Kh = f.Kh();
            str28 = this.aPy.aPj;
            Kh.gQ(str28);
            try {
                str29 = c.TAG;
                k.log(str29, "mDownloadRunnable sleep in..." + this.aPy);
                Thread.sleep(100L);
                str30 = c.TAG;
                k.log(str30, "mDownloadRunnable sleep out..." + this.aPy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            z16 = this.aPy.aPq;
            if (z16) {
                break;
            }
        }
        z = this.aPy.aPq;
        if (!z) {
            f.Kh().r(this.aPy);
        }
        while (true) {
            z2 = this.aPy.aPq;
            if (z2) {
                break;
            }
            str3 = c.TAG;
            k.log(str3, "download in " + this.aPy);
            str4 = this.aPy.aPv;
            long gZ = o.gZ(str4);
            j = this.aPy.ajS;
            if (gZ <= j) {
                this.aPy.aPt = -1L;
                str7 = this.aPy.aPr;
                File file2 = new File(str7);
                j2 = this.aPy.aPm;
                j3 = this.aPy.aPl;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        z15 = this.aPy.aPq;
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
                z3 = this.aPy.aPq;
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
                            z14 = this.aPy.aPq;
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
                                j25 = this.aPy.aPm;
                                if (j25 >= parseInt2) {
                                    j26 = this.aPy.aPm;
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
                        z13 = this.aPy.aPq;
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
                z4 = this.aPy.aPq;
                if (z4) {
                    break;
                }
                if (file == null) {
                    str8 = this.aPy.aPr;
                    StringBuilder append = new StringBuilder(String.valueOf(str8)).append("/");
                    j7 = this.aPy.aPm;
                    sb = append.append(j7).toString();
                    try {
                        new File(sb).createNewFile();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    if ((j6 - j2) + 1 > 4194304) {
                        str9 = sb;
                        j8 = (4194304 + j2) - 1;
                        z5 = false;
                    }
                    str9 = sb;
                    j8 = j6;
                    z5 = false;
                } else {
                    sb = file.getAbsolutePath();
                    long length = file.length();
                    if (length >= 4194304) {
                        str9 = sb;
                        j8 = j6;
                        z5 = true;
                    } else {
                        if ((j6 - j2) + 1 + length > 4194304) {
                            str9 = sb;
                            j8 = ((4194304 - length) + j2) - 1;
                            z5 = false;
                        }
                        str9 = sb;
                        j8 = j6;
                        z5 = false;
                    }
                }
                try {
                    this.aPy.aPp = new FileInputStream(str9);
                    if (file != null) {
                        try {
                            fileInputStream = this.aPy.aPp;
                            j9 = this.aPy.aPm;
                            fileInputStream.skip(j9 - j4);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (file != null) {
                        this.aPy.aPo = j4 + j5;
                    }
                    this.aPy.aPs = true;
                    obj = this.aPy.mLock;
                    synchronized (obj) {
                        obj2 = this.aPy.mLock;
                        obj2.notify();
                    }
                    if (file != null) {
                        j23 = this.aPy.aPl;
                        if (j2 > j23) {
                            str27 = c.TAG;
                            k.log(str27, "do not download, return " + this.aPy);
                            break;
                        }
                    }
                    z6 = this.aPy.aPq;
                    if (z6) {
                        break;
                    }
                    str10 = c.TAG;
                    k.log(str10, "download range is " + j2 + "-" + j8);
                    if (j2 <= j8 && !z5) {
                        try {
                            str17 = this.aPy.aPj;
                            URL url = new URL(str17);
                            str18 = c.TAG;
                            k.log(str18, "url opt 1 " + this.aPy);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            str19 = c.TAG;
                            k.log(str19, "url opt 2 " + this.aPy);
                            httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + "-" + j8);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            str20 = c.TAG;
                            k.log(str20, "url opt 3 " + this.aPy);
                            InputStream inputStream = httpURLConnection.getInputStream();
                            while (inputStream == null) {
                                str26 = c.TAG;
                                k.log(str26, "conn input is null " + this.aPy);
                                z12 = this.aPy.aPq;
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
                            str21 = c.TAG;
                            k.log(str21, "got conn input " + this.aPy);
                            str22 = c.TAG;
                            k.log(str22, "url opt 4 " + this.aPy);
                            int i5 = 0;
                            FileOutputStream fileOutputStream = new FileOutputStream(str9, true);
                            str23 = c.TAG;
                            k.log(str23, "read start ..." + this.aPy);
                            while (true) {
                                try {
                                    bArr = this.aPy.aPw;
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    z11 = this.aPy.aPq;
                                    if (z11) {
                                        break;
                                    }
                                    bArr2 = this.aPy.aPw;
                                    fileOutputStream.write(bArr2, 0, read);
                                    c cVar = this.aPy;
                                    j22 = cVar.aPo;
                                    cVar.aPo = j22 + read;
                                    i5 += read;
                                    obj3 = this.aPy.mLock;
                                    synchronized (obj3) {
                                        obj4 = this.aPy.mLock;
                                        obj4.notify();
                                    }
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                }
                            }
                            str25 = this.aPy.aPj;
                            j21 = this.aPy.ajS;
                            aw.i(str25, i5, (int) j21);
                            str24 = c.TAG;
                            k.log(str24, "read end ..." + this.aPy);
                            fileOutputStream.close();
                            l.Kp().n(inputStream);
                            this.aPy.aPt = j8;
                        } catch (Exception e9) {
                            str16 = c.TAG;
                            k.log(str16, "download exception " + this.aPy);
                            e9.printStackTrace();
                        }
                    } else {
                        this.aPy.aPt = (j4 + j5) - 1;
                    }
                    str11 = c.TAG;
                    k.log(str11, "download out " + this.aPy);
                    while (j10 < j11) {
                        z9 = this.aPy.aPq;
                        if (z9) {
                            break;
                        }
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e10) {
                            e10.printStackTrace();
                        }
                        z10 = this.aPy.aPq;
                        if (z10) {
                            break;
                        }
                    }
                    z7 = this.aPy.aPq;
                    if (z7) {
                        break;
                    }
                    j12 = this.aPy.aPn;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length; i7++) {
                        z8 = this.aPy.aPq;
                        if (z8) {
                            break;
                        }
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (this.aPy.aPu) {
                                if (length2 != 0) {
                                    file5.delete();
                                    str15 = c.TAG;
                                    k.log(str15, "release some cached slices " + this.aPy);
                                }
                            } else {
                                long fileSize2 = o.getFileSize(file5);
                                if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j12 && (i6 = (int) (i6 + fileSize2)) > 31457280) {
                                    this.aPy.aPu = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        str14 = c.TAG;
                                        k.log(str14, "release some cached slices " + this.aPy);
                                    }
                                }
                            }
                        }
                    }
                    str12 = c.TAG;
                    StringBuilder sb2 = new StringBuilder("mLastRequestRangeEnd ");
                    j13 = this.aPy.aPt;
                    StringBuilder append2 = sb2.append(j13).append(" mReadPosition ");
                    j14 = this.aPy.aPn;
                    k.log(str12, append2.append(j14).append(" ").append(" ").append(this.aPy).toString());
                    j15 = this.aPy.aPt;
                    if (j15 == -1) {
                        break;
                    }
                    j16 = this.aPy.aPn;
                    j17 = this.aPy.aPt;
                    if (j16 <= j17) {
                        break;
                    }
                    j18 = this.aPy.aPt;
                    j19 = this.aPy.aPl;
                    if (j18 >= j19) {
                        break;
                    }
                    try {
                        fileInputStream2 = this.aPy.aPp;
                        fileInputStream2.close();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    this.aPy.aPs = false;
                    c cVar2 = this.aPy;
                    j20 = this.aPy.aPt;
                    cVar2.aPm = j20 + 1;
                    str13 = c.TAG;
                    k.log(str13, "continue to download... " + this.aPy);
                } catch (FileNotFoundException e12) {
                    e12.printStackTrace();
                }
            } else {
                StringBuilder sb3 = new StringBuilder(String.valueOf(j.aPS));
                str5 = this.aPy.aPv;
                o.w(new File(sb3.append(str5).append("/").append("segments").toString()));
                str6 = c.TAG;
                k.log(str6, "cache error !");
                break;
            }
        }
        f.Kh().s(this.aPy);
        str2 = c.TAG;
        k.log(str2, "test run out ***************************************************************" + this.aPy);
    }
}
