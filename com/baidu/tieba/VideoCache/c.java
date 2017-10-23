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
    private String aXe;
    private long aXf;
    private long aXg;
    private long aXh;
    private long aXi;
    private long aXj;
    private FileInputStream aXk;
    private String aXq;
    private Context mContext;
    private boolean aXl = false;
    private String aXm = "";
    private Object mLock = new Object();
    private boolean aXn = false;
    private long aXo = -1;
    boolean aXp = false;
    private long aqq = 0;
    private Runnable aXs = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.av(c.TAG, "test run in " + c.this);
            while (e.KP().t(c.this)) {
                e.KP().hg(c.this.aXe);
                try {
                    j.av(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.av(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.aXl) {
                    break;
                }
            }
            if (!c.this.aXl) {
                e.KP().r(c.this);
            }
            while (true) {
                if (c.this.aXl) {
                    break;
                }
                j.av(c.TAG, "download in " + c.this);
                if (m.hp(c.this.aXq) <= c.this.aqq) {
                    c.this.aXo = -1L;
                    File file2 = new File(c.this.aXm);
                    long j6 = c.this.aXh;
                    long j7 = c.this.aXg;
                    File[] listFiles = file2.listFiles();
                    ArrayList arrayList = new ArrayList();
                    if (listFiles != null) {
                        for (File file3 : listFiles) {
                            if (c.this.aXl) {
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
                    if (c.this.aXl) {
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
                                if (c.this.aXl) {
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
                                    if (c.this.aXh >= parseInt2 && c.this.aXh <= j8) {
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
                                if (!c.this.aXl) {
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
                    if (c.this.aXl) {
                        break;
                    }
                    boolean z2 = false;
                    if (file == null) {
                        String str2 = c.this.aXm + "/" + c.this.aXh;
                        try {
                            new File(str2).createNewFile();
                        } catch (IOException e5) {
                            TiebaStatic.log(new ak("c12027").ac("errormsg", "创建缓存文件出现异常").ac("name", str2).ac("error", e5.getMessage()).ac("url", c.this.aXe));
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
                        c.this.aXk = new FileInputStream(str);
                        if (file != null) {
                            try {
                                c.this.aXk.skip(c.this.aXh - j);
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (file != null) {
                            c.this.aXj = j + j3;
                        }
                        c.this.aXn = true;
                        synchronized (c.this.mLock) {
                            c.this.mLock.notify();
                        }
                        if (file == null || j6 <= c.this.aXg) {
                            if (c.this.aXl) {
                                break;
                            }
                            j.av(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            if (j6 > j4 || z2) {
                                c.this.aXo = (j + j3) - 1;
                            } else {
                                try {
                                    URL url = new URL(c.this.aXe);
                                    j.av(c.TAG, "url opt 1 " + c.this);
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                    j.av(c.TAG, "url opt 2 " + c.this);
                                    httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                    httpURLConnection.setConnectTimeout(5000);
                                    httpURLConnection.setReadTimeout(5000);
                                    j.av(c.TAG, "url opt 3 " + c.this);
                                    InputStream inputStream = httpURLConnection.getInputStream();
                                    while (inputStream == null) {
                                        j.av(c.TAG, "conn input is null " + c.this);
                                        if (c.this.aXl) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(10L);
                                        } catch (InterruptedException e7) {
                                            e7.printStackTrace();
                                        }
                                        inputStream = httpURLConnection.getInputStream();
                                    }
                                    j.av(c.TAG, "got conn input " + c.this);
                                    j.av(c.TAG, "url opt 4 " + c.this);
                                    int i5 = 0;
                                    FileOutputStream fileOutputStream = new FileOutputStream(str, true);
                                    j.av(c.TAG, "read start ..." + c.this);
                                    while (true) {
                                        try {
                                            int read = inputStream.read(c.this.aXr);
                                            if (read == -1 || c.this.aXl) {
                                                break;
                                            }
                                            fileOutputStream.write(c.this.aXr, 0, read);
                                            c.this.aXj += read;
                                            i5 += read;
                                            synchronized (c.this.mLock) {
                                                c.this.mLock.notify();
                                            }
                                        } catch (Exception e8) {
                                            TiebaStatic.log(new ak("c12027").ac("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ac("error", e8.getMessage()).r("dsize", i5).ac("url", c.this.aXe));
                                            e8.printStackTrace();
                                        }
                                    }
                                    v.j(c.this.aXe, i5, (int) c.this.aqq);
                                    j.av(c.TAG, "read end ..." + c.this);
                                    fileOutputStream.close();
                                    k.KX().h(inputStream);
                                    c.this.aXo = j4;
                                } catch (Exception e9) {
                                    TiebaStatic.log(new ak("c12027").ac("errormsg", "连接中断，文件下载出现异常").ac("error", e9.getMessage()).ac("url", c.this.aXe));
                                    j.av(c.TAG, "download exception " + c.this);
                                    e9.printStackTrace();
                                }
                            }
                            j.av(c.TAG, "download out " + c.this);
                            while (c.this.aXi < c.this.aXj && !c.this.aXl) {
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e10) {
                                    e10.printStackTrace();
                                }
                                if (c.this.aXl) {
                                    break;
                                }
                            }
                            if (c.this.aXl) {
                                break;
                            }
                            long j9 = c.this.aXi;
                            int i6 = 0;
                            for (int i7 = 0; i7 < fileArr.length && !c.this.aXl; i7++) {
                                int length2 = (fileArr.length - 1) - i7;
                                File file5 = fileArr[length2];
                                if (file5 != null && file5.exists()) {
                                    if (c.this.aXp) {
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.av(c.TAG, "release some cached slices " + c.this);
                                        }
                                    } else {
                                        long g2 = m.g(file5);
                                        if ((Integer.parseInt(file5.getName()) + g2) - 1 < j9 && (i6 = (int) (i6 + g2)) > 31457280) {
                                            c.this.aXp = true;
                                            if (length2 != 0) {
                                                file5.delete();
                                                j.av(c.TAG, "release some cached slices " + c.this);
                                            }
                                        }
                                    }
                                }
                            }
                            j.av(c.TAG, "mLastRequestRangeEnd " + c.this.aXo + " mReadPosition " + c.this.aXi + "  " + c.this);
                            if (c.this.aXo == -1 || c.this.aXi <= c.this.aXo || c.this.aXo >= c.this.aXg) {
                                break;
                            }
                            try {
                                c.this.aXk.close();
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            c.this.aXn = false;
                            c.this.aXh = c.this.aXo + 1;
                            j.av(c.TAG, "continue to download... " + c.this);
                        } else {
                            j.av(c.TAG, "do not download, return " + c.this);
                            break;
                        }
                    } catch (FileNotFoundException e12) {
                        e12.printStackTrace();
                    }
                } else {
                    m.A(new File(i.aXL + c.this.aXq + "/segments"));
                    TiebaStatic.log(new ak("c12028").ac("errormsg", "校验到缓存文件片段大小有异常").ac("url", c.this.aXe));
                    j.av(c.TAG, "cache error !");
                    break;
                }
            }
            e.KP().s(c.this);
            j.av(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] aXr = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aXe = str;
    }

    public void N(long j) {
        this.aqq = j;
    }

    public void b(long j, long j2) {
        j.av(TAG, "open *************************************************************" + this);
        if (this.aXe != null) {
            this.aXf = j;
            this.aXg = j2;
            this.aXq = m.hq(this.aXe);
            if (this.aXq != null) {
                File file = new File(i.aXL + this.aXq);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aXm = file2.getAbsolutePath();
                    this.aXj = this.aXf;
                    this.aXi = this.aXf;
                    this.aXh = this.aXf;
                    this.aXl = false;
                    this.aXn = false;
                    this.aXo = -1L;
                    this.aXp = false;
                    l.KY().e(this.aXs);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aXe;
    }

    public void close() {
        j.av(TAG, "close ***********************************************************************" + this);
        this.aXl = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aXk != null) {
                this.aXk.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.aXL + this.aXq + "/completed");
        if (this.aXp) {
            return;
        }
        if (file == null || !file.exists()) {
            k.KX().hn(this.aXe);
        }
    }

    public boolean canRead() {
        return !this.aXl && this.aXi <= this.aXg;
    }

    public int read(byte[] bArr, int i) {
        if (this.aXl) {
            return 0;
        }
        do {
            if (this.aXi == this.aXj || !this.aXn) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aXk.read(bArr, 0, (int) (this.aXi + ((long) i) < this.aXj ? i : this.aXj - this.aXi));
                    if (read >= 0) {
                        this.aXi += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aXl);
        return 0;
    }
}
