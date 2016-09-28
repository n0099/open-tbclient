package com.baidu.tieba.VideoCache;

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
public class e implements Runnable {
    final /* synthetic */ d aOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aOb = dVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:129:0x04f8 */
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
        boolean z11;
        byte[] bArr2;
        long j21;
        Object obj3;
        Object obj4;
        String str25;
        boolean z12;
        long j22;
        String str26;
        long j23;
        boolean z13;
        long parseInt;
        boolean z14;
        long j24;
        long j25;
        boolean z15;
        String str27;
        boolean z16;
        String str28;
        String str29;
        str = d.TAG;
        m.log(str, "test run in " + this.aOb);
        while (g.Kk().t(this.aOb)) {
            g Kk = g.Kk();
            str27 = this.aOb.aNM;
            Kk.gU(str27);
            try {
                str28 = d.TAG;
                m.log(str28, "mDownloadRunnable sleep in..." + this.aOb);
                Thread.sleep(100L);
                str29 = d.TAG;
                m.log(str29, "mDownloadRunnable sleep out..." + this.aOb);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            z16 = this.aOb.aNT;
            if (z16) {
                break;
            }
        }
        z = this.aOb.aNT;
        if (!z) {
            g.Kk().r(this.aOb);
        }
        while (true) {
            z2 = this.aOb.aNT;
            if (z2) {
                break;
            }
            str3 = d.TAG;
            m.log(str3, "download in " + this.aOb);
            str4 = this.aOb.aNY;
            long hd = q.hd(str4);
            j = this.aOb.ajy;
            if (hd <= j) {
                this.aOb.aNW = -1L;
                str7 = this.aOb.aNU;
                File file2 = new File(str7);
                j2 = this.aOb.aNP;
                j3 = this.aOb.aNO;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        z15 = this.aOb.aNT;
                        if (z15) {
                            break;
                        }
                        if (file3 != null && file3.exists()) {
                            try {
                                Long.parseLong(file3.getName());
                                if (q.getFileSize(file3) == 0) {
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
                z3 = this.aOb.aNT;
                if (z3) {
                    break;
                }
                Collections.sort(arrayList, new k());
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
                            z14 = this.aOb.aNT;
                            if (z14) {
                                j4 = 0;
                                j5 = 0;
                                j23 = j2;
                                file = null;
                                break;
                            }
                            File file4 = fileArr[i3];
                            try {
                                long parseInt2 = Integer.parseInt(file4.getName());
                                long fileSize = q.getFileSize(file4);
                                long j26 = (parseInt2 + fileSize) - 1;
                                j24 = this.aOb.aNP;
                                if (j24 >= parseInt2) {
                                    j25 = this.aOb.aNP;
                                    if (j25 <= j26) {
                                        file = file4;
                                        j23 = parseInt2 + fileSize;
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
                            j23 = j2;
                            file = null;
                            break;
                        }
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= fileArr.length) {
                            j2 = j23;
                            j6 = j3;
                            break;
                        }
                        z13 = this.aOb.aNT;
                        if (z13) {
                            j2 = j23;
                            j6 = j3;
                            break;
                        }
                        try {
                            parseInt = Integer.parseInt(fileArr[i4].getName());
                        } catch (Exception e4) {
                        }
                        if (parseInt < j23) {
                            i4++;
                        } else {
                            j2 = j23;
                            j6 = parseInt - 1;
                            break;
                        }
                    }
                }
                z4 = this.aOb.aNT;
                if (z4) {
                    break;
                }
                if (file == null) {
                    str8 = this.aOb.aNU;
                    StringBuilder append = new StringBuilder(String.valueOf(str8)).append("/");
                    j7 = this.aOb.aNP;
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
                    this.aOb.aNS = new FileInputStream(str9);
                    if (file != null) {
                        try {
                            fileInputStream = this.aOb.aNS;
                            j9 = this.aOb.aNP;
                            fileInputStream.skip(j9 - j4);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (file != null) {
                        this.aOb.aNR = j4 + j5;
                    }
                    this.aOb.aNV = true;
                    obj = this.aOb.mLock;
                    synchronized (obj) {
                        obj2 = this.aOb.mLock;
                        obj2.notify();
                    }
                    if (file != null) {
                        j22 = this.aOb.aNO;
                        if (j2 > j22) {
                            str26 = d.TAG;
                            m.log(str26, "do not download, return " + this.aOb);
                            break;
                        }
                    }
                    z6 = this.aOb.aNT;
                    if (z6) {
                        break;
                    }
                    str10 = d.TAG;
                    m.log(str10, "download range is " + j2 + "-" + j8);
                    if (j2 <= j8 && !z5) {
                        try {
                            str17 = this.aOb.aNM;
                            URL url = new URL(str17);
                            str18 = d.TAG;
                            m.log(str18, "url opt 1 " + this.aOb);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            str19 = d.TAG;
                            m.log(str19, "url opt 2 " + this.aOb);
                            httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + "-" + j8);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            str20 = d.TAG;
                            m.log(str20, "url opt 3 " + this.aOb);
                            InputStream inputStream = httpURLConnection.getInputStream();
                            while (inputStream == null) {
                                str25 = d.TAG;
                                m.log(str25, "conn input is null " + this.aOb);
                                z12 = this.aOb.aNT;
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
                            str21 = d.TAG;
                            m.log(str21, "got conn input " + this.aOb);
                            str22 = d.TAG;
                            m.log(str22, "url opt 4 " + this.aOb);
                            FileOutputStream fileOutputStream = new FileOutputStream(str9, true);
                            str23 = d.TAG;
                            m.log(str23, "read start ..." + this.aOb);
                            while (true) {
                                try {
                                    bArr = this.aOb.aNZ;
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    z11 = this.aOb.aNT;
                                    if (z11) {
                                        break;
                                    }
                                    bArr2 = this.aOb.aNZ;
                                    fileOutputStream.write(bArr2, 0, read);
                                    d dVar = this.aOb;
                                    j21 = dVar.aNR;
                                    dVar.aNR = j21 + read;
                                    obj3 = this.aOb.mLock;
                                    synchronized (obj3) {
                                        obj4 = this.aOb.mLock;
                                        obj4.notify();
                                    }
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                }
                            }
                            str24 = d.TAG;
                            m.log(str24, "read end ..." + this.aOb);
                            fileOutputStream.close();
                            n.Ks().n(inputStream);
                            this.aOb.aNW = j8;
                        } catch (IOException e9) {
                            str16 = d.TAG;
                            m.log(str16, "download exception " + this.aOb);
                            e9.printStackTrace();
                        }
                    } else {
                        this.aOb.aNW = (j4 + j5) - 1;
                    }
                    str11 = d.TAG;
                    m.log(str11, "download out " + this.aOb);
                    while (j10 < j11) {
                        z9 = this.aOb.aNT;
                        if (z9) {
                            break;
                        }
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e10) {
                            e10.printStackTrace();
                        }
                        z10 = this.aOb.aNT;
                        if (z10) {
                            break;
                        }
                    }
                    z7 = this.aOb.aNT;
                    if (z7) {
                        break;
                    }
                    j12 = this.aOb.aNQ;
                    int i5 = 0;
                    for (int i6 = 0; i6 < fileArr.length; i6++) {
                        z8 = this.aOb.aNT;
                        if (z8) {
                            break;
                        }
                        int length2 = (fileArr.length - 1) - i6;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (this.aOb.aNX) {
                                if (length2 != 0) {
                                    file5.delete();
                                    str15 = d.TAG;
                                    m.log(str15, "release some cached slices " + this.aOb);
                                }
                            } else {
                                long fileSize2 = q.getFileSize(file5);
                                if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j12 && (i5 = (int) (i5 + fileSize2)) > 31457280) {
                                    this.aOb.aNX = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        str14 = d.TAG;
                                        m.log(str14, "release some cached slices " + this.aOb);
                                    }
                                }
                            }
                        }
                    }
                    str12 = d.TAG;
                    StringBuilder sb2 = new StringBuilder("mLastRequestRangeEnd ");
                    j13 = this.aOb.aNW;
                    StringBuilder append2 = sb2.append(j13).append(" mReadPosition ");
                    j14 = this.aOb.aNQ;
                    m.log(str12, append2.append(j14).append(" ").append(" ").append(this.aOb).toString());
                    j15 = this.aOb.aNW;
                    if (j15 == -1) {
                        break;
                    }
                    j16 = this.aOb.aNQ;
                    j17 = this.aOb.aNW;
                    if (j16 <= j17) {
                        break;
                    }
                    j18 = this.aOb.aNW;
                    j19 = this.aOb.aNO;
                    if (j18 >= j19) {
                        break;
                    }
                    try {
                        fileInputStream2 = this.aOb.aNS;
                        fileInputStream2.close();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    this.aOb.aNV = false;
                    d dVar2 = this.aOb;
                    j20 = this.aOb.aNW;
                    dVar2.aNP = j20 + 1;
                    str13 = d.TAG;
                    m.log(str13, "continue to download... " + this.aOb);
                } catch (FileNotFoundException e12) {
                    e12.printStackTrace();
                }
            } else {
                StringBuilder sb3 = new StringBuilder(String.valueOf(l.aOv));
                str5 = this.aOb.aNY;
                q.w(new File(sb3.append(str5).append("/").append("segments").toString()));
                str6 = d.TAG;
                m.log(str6, "cache error !");
                break;
            }
        }
        g.Kk().s(this.aOb);
        str2 = d.TAG;
        m.log(str2, "test run out ***************************************************************" + this.aOb);
    }
}
