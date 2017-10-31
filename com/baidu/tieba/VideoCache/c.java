package com.baidu.tieba.VideoCache;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.play.v;
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes2.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private FileInputStream aXA;
    private String aXG;
    private String aXu;
    private long aXv;
    private long aXw;
    private long aXx;
    private long aXy;
    private long aXz;
    private Context mContext;
    private boolean aXB = false;
    private String aXC = "";
    private Object mLock = new Object();
    private boolean aXD = false;
    private long aXE = -1;
    boolean aXF = false;
    private long aqK = 0;
    private Runnable aXI = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
        @Override // java.lang.Runnable
        public void run() {
            long j;
            long j2;
            long j3;
            File file;
            long j4;
            String str;
            boolean z;
            long j5;
            long parseInt;
            j.au(c.TAG, "test run in " + c.this);
            while (e.KY().t(c.this)) {
                e.KY().ho(c.this.aXu);
                try {
                    j.au(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.au(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.aXB) {
                    break;
                }
            }
            if (!c.this.aXB) {
                e.KY().r(c.this);
            }
            while (true) {
                if (c.this.aXB) {
                    break;
                }
                j.au(c.TAG, "download in " + c.this);
                if (m.hx(c.this.aXG) <= c.this.aqK) {
                    c.this.aXE = -1L;
                    File file2 = new File(c.this.aXC);
                    long j6 = c.this.aXx;
                    long j7 = c.this.aXw;
                    File[] listFiles = file2.listFiles();
                    ArrayList arrayList = new ArrayList();
                    if (listFiles != null) {
                        for (File file3 : listFiles) {
                            if (c.this.aXB) {
                                break;
                            }
                            if (file3 != null && file3.exists()) {
                                try {
                                    Long.parseLong(file3.getName());
                                    if (m.g(file3) == 0) {
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
                    if (c.this.aXB) {
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
                        j = 0;
                        j2 = j7;
                        j3 = 0;
                        file = null;
                    } else {
                        int i3 = 0;
                        while (true) {
                            if (i3 < fileArr.length) {
                                if (c.this.aXB) {
                                    j = 0;
                                    j5 = j6;
                                    j3 = 0;
                                    file = null;
                                    break;
                                }
                                File file4 = fileArr[i3];
                                try {
                                    long parseInt2 = Integer.parseInt(file4.getName());
                                    long g = m.g(file4);
                                    long j8 = (parseInt2 + g) - 1;
                                    if (c.this.aXx >= parseInt2 && c.this.aXx <= j8) {
                                        j3 = g;
                                        file = file4;
                                        j = parseInt2;
                                        j5 = parseInt2 + g;
                                        break;
                                    }
                                } catch (Exception e3) {
                                }
                                i3++;
                            } else {
                                j = 0;
                                j5 = j6;
                                j3 = 0;
                                file = null;
                                break;
                            }
                        }
                        int i4 = 0;
                        while (true) {
                            if (i4 < fileArr.length) {
                                if (!c.this.aXB) {
                                    try {
                                        parseInt = Integer.parseInt(fileArr[i4].getName());
                                    } catch (Exception e4) {
                                    }
                                    if (parseInt < j5) {
                                        i4++;
                                    } else {
                                        j6 = j5;
                                        j2 = parseInt - 1;
                                        break;
                                    }
                                } else {
                                    j6 = j5;
                                    j2 = j7;
                                    break;
                                }
                            } else {
                                j6 = j5;
                                j2 = j7;
                                break;
                            }
                        }
                    }
                    if (c.this.aXB) {
                        break;
                    }
                    boolean z2 = false;
                    if (file == null) {
                        String str2 = c.this.aXC + "/" + c.this.aXx;
                        try {
                            new File(str2).createNewFile();
                        } catch (IOException e5) {
                            TiebaStatic.log(new ak("c12027").ac("errormsg", "创建缓存文件出现异常").ac("name", str2).ac("error", e5.getMessage()).ac("url", c.this.aXu));
                            e5.printStackTrace();
                        }
                        if ((j2 - j6) + 1 > 4194304) {
                            j4 = (4194304 + j6) - 1;
                            str = str2;
                        } else {
                            j4 = j2;
                            str = str2;
                        }
                    } else {
                        String absolutePath = file.getAbsolutePath();
                        long length = file.length();
                        if (length >= 4194304) {
                            j4 = j2;
                            z = true;
                        } else if ((j2 - j6) + 1 + length <= 4194304) {
                            j4 = j2;
                            z = false;
                        } else {
                            j4 = ((4194304 - length) + j6) - 1;
                            z = false;
                        }
                        z2 = z;
                        str = absolutePath;
                    }
                    try {
                        c.this.aXA = new FileInputStream(str);
                        if (file != null) {
                            try {
                                c.this.aXA.skip(c.this.aXx - j);
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (file != null) {
                            c.this.aXz = j + j3;
                        }
                        c.this.aXD = true;
                        synchronized (c.this.mLock) {
                            c.this.mLock.notify();
                        }
                        if (file == null || j6 <= c.this.aXw) {
                            if (c.this.aXB) {
                                break;
                            }
                            j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            if (j6 > j4 || z2) {
                                c.this.aXE = (j + j3) - 1;
                            } else {
                                try {
                                    URL url = new URL(c.this.aXu);
                                    j.au(c.TAG, "url opt 1 " + c.this);
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                    j.au(c.TAG, "url opt 2 " + c.this);
                                    httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                    httpURLConnection.setConnectTimeout(5000);
                                    httpURLConnection.setReadTimeout(5000);
                                    j.au(c.TAG, "url opt 3 " + c.this);
                                    InputStream inputStream = httpURLConnection.getInputStream();
                                    while (inputStream == null) {
                                        j.au(c.TAG, "conn input is null " + c.this);
                                        if (c.this.aXB) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(10L);
                                        } catch (InterruptedException e7) {
                                            e7.printStackTrace();
                                        }
                                        inputStream = httpURLConnection.getInputStream();
                                    }
                                    j.au(c.TAG, "got conn input " + c.this);
                                    j.au(c.TAG, "url opt 4 " + c.this);
                                    int i5 = 0;
                                    FileOutputStream fileOutputStream = new FileOutputStream(str, true);
                                    j.au(c.TAG, "read start ..." + c.this);
                                    while (true) {
                                        try {
                                            int read = inputStream.read(c.this.aXH);
                                            if (read == -1 || c.this.aXB) {
                                                break;
                                            }
                                            fileOutputStream.write(c.this.aXH, 0, read);
                                            c.this.aXz += read;
                                            i5 += read;
                                            synchronized (c.this.mLock) {
                                                c.this.mLock.notify();
                                            }
                                        } catch (Exception e8) {
                                            TiebaStatic.log(new ak("c12027").ac("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ac("error", e8.getMessage()).r("dsize", i5).ac("url", c.this.aXu));
                                            e8.printStackTrace();
                                        }
                                    }
                                    v.j(c.this.aXu, i5, (int) c.this.aqK);
                                    j.au(c.TAG, "read end ..." + c.this);
                                    fileOutputStream.close();
                                    k.Lg().h(inputStream);
                                    c.this.aXE = j4;
                                } catch (Exception e9) {
                                    TiebaStatic.log(new ak("c12027").ac("errormsg", "连接中断，文件下载出现异常").ac("error", e9.getMessage()).ac("url", c.this.aXu));
                                    j.au(c.TAG, "download exception " + c.this);
                                    e9.printStackTrace();
                                }
                            }
                            j.au(c.TAG, "download out " + c.this);
                            while (c.this.aXy < c.this.aXz && !c.this.aXB) {
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e10) {
                                    e10.printStackTrace();
                                }
                                if (c.this.aXB) {
                                    break;
                                }
                            }
                            if (c.this.aXB) {
                                break;
                            }
                            long j9 = c.this.aXy;
                            int i6 = 0;
                            for (int i7 = 0; i7 < fileArr.length && !c.this.aXB; i7++) {
                                int length2 = (fileArr.length - 1) - i7;
                                File file5 = fileArr[length2];
                                if (file5 != null && file5.exists()) {
                                    if (c.this.aXF) {
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.au(c.TAG, "release some cached slices " + c.this);
                                        }
                                    } else {
                                        long g2 = m.g(file5);
                                        if ((Integer.parseInt(file5.getName()) + g2) - 1 < j9 && (i6 = (int) (i6 + g2)) > 31457280) {
                                            c.this.aXF = true;
                                            if (length2 != 0) {
                                                file5.delete();
                                                j.au(c.TAG, "release some cached slices " + c.this);
                                            }
                                        }
                                    }
                                }
                            }
                            j.au(c.TAG, "mLastRequestRangeEnd " + c.this.aXE + " mReadPosition " + c.this.aXy + "  " + c.this);
                            if (c.this.aXE == -1 || c.this.aXy <= c.this.aXE || c.this.aXE >= c.this.aXw) {
                                break;
                            }
                            try {
                                c.this.aXA.close();
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            c.this.aXD = false;
                            c.this.aXx = c.this.aXE + 1;
                            j.au(c.TAG, "continue to download... " + c.this);
                        } else {
                            j.au(c.TAG, "do not download, return " + c.this);
                            break;
                        }
                    } catch (FileNotFoundException e12) {
                        e12.printStackTrace();
                    }
                } else {
                    m.z(new File(i.aYb + c.this.aXG + "/segments"));
                    TiebaStatic.log(new ak("c12028").ac("errormsg", "校验到缓存文件片段大小有异常").ac("url", c.this.aXu));
                    j.au(c.TAG, "cache error !");
                    break;
                }
            }
            e.KY().s(c.this);
            j.au(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] aXH = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aXu = str;
    }

    public void N(long j) {
        this.aqK = j;
    }

    public void b(long j, long j2) {
        j.au(TAG, "open *************************************************************" + this);
        if (this.aXu != null) {
            this.aXv = j;
            this.aXw = j2;
            this.aXG = m.hy(this.aXu);
            if (this.aXG != null) {
                File file = new File(i.aYb + this.aXG);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aXC = file2.getAbsolutePath();
                    this.aXz = this.aXv;
                    this.aXy = this.aXv;
                    this.aXx = this.aXv;
                    this.aXB = false;
                    this.aXD = false;
                    this.aXE = -1L;
                    this.aXF = false;
                    l.Lh().e(this.aXI);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aXu;
    }

    public void close() {
        j.au(TAG, "close ***********************************************************************" + this);
        this.aXB = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aXA != null) {
                this.aXA.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.aYb + this.aXG + "/completed");
        if (this.aXF) {
            return;
        }
        if (file == null || !file.exists()) {
            k.Lg().hv(this.aXu);
        }
    }

    public boolean canRead() {
        return !this.aXB && this.aXy <= this.aXw;
    }

    public int read(byte[] bArr, int i) {
        if (this.aXB) {
            return 0;
        }
        do {
            if (this.aXy == this.aXz || !this.aXD) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aXA.read(bArr, 0, (int) (this.aXy + ((long) i) < this.aXz ? i : this.aXz - this.aXy));
                    if (read >= 0) {
                        this.aXy += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aXB);
        return 0;
    }
}
