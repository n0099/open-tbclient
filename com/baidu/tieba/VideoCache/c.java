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
    private String aXD;
    private long aXE;
    private long aXF;
    private long aXG;
    private long aXH;
    private long aXI;
    private FileInputStream aXJ;
    private String aXP;
    private Context mContext;
    private boolean aXK = false;
    private String aXL = "";
    private Object mLock = new Object();
    private boolean aXM = false;
    private long aXN = -1;
    boolean aXO = false;
    private long aqQ = 0;
    private Runnable aXR = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            while (e.Lj().t(c.this)) {
                e.Lj().hp(c.this.aXD);
                try {
                    j.au(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.au(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.aXK) {
                    break;
                }
            }
            if (!c.this.aXK) {
                e.Lj().r(c.this);
            }
            while (true) {
                if (c.this.aXK) {
                    break;
                }
                j.au(c.TAG, "download in " + c.this);
                if (m.hy(c.this.aXP) <= c.this.aqQ) {
                    c.this.aXN = -1L;
                    File file2 = new File(c.this.aXL);
                    long j6 = c.this.aXG;
                    long j7 = c.this.aXF;
                    File[] listFiles = file2.listFiles();
                    ArrayList arrayList = new ArrayList();
                    if (listFiles != null) {
                        for (File file3 : listFiles) {
                            if (c.this.aXK) {
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
                    if (c.this.aXK) {
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
                                if (c.this.aXK) {
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
                                    if (c.this.aXG >= parseInt2 && c.this.aXG <= j8) {
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
                                if (!c.this.aXK) {
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
                    if (c.this.aXK) {
                        break;
                    }
                    boolean z2 = false;
                    if (file == null) {
                        String str2 = c.this.aXL + "/" + c.this.aXG;
                        try {
                            new File(str2).createNewFile();
                        } catch (IOException e5) {
                            TiebaStatic.log(new ak("c12027").ac("errormsg", "创建缓存文件出现异常").ac("name", str2).ac("error", e5.getMessage()).ac("url", c.this.aXD));
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
                        c.this.aXJ = new FileInputStream(str);
                        if (file != null) {
                            try {
                                c.this.aXJ.skip(c.this.aXG - j);
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (file != null) {
                            c.this.aXI = j + j3;
                        }
                        c.this.aXM = true;
                        synchronized (c.this.mLock) {
                            c.this.mLock.notify();
                        }
                        if (file == null || j6 <= c.this.aXF) {
                            if (c.this.aXK) {
                                break;
                            }
                            j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            if (j6 > j4 || z2) {
                                c.this.aXN = (j + j3) - 1;
                            } else {
                                try {
                                    URL url = new URL(c.this.aXD);
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
                                        if (c.this.aXK) {
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
                                            int read = inputStream.read(c.this.aXQ);
                                            if (read == -1 || c.this.aXK) {
                                                break;
                                            }
                                            fileOutputStream.write(c.this.aXQ, 0, read);
                                            c.this.aXI += read;
                                            i5 += read;
                                            synchronized (c.this.mLock) {
                                                c.this.mLock.notify();
                                            }
                                        } catch (Exception e8) {
                                            TiebaStatic.log(new ak("c12027").ac("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ac("error", e8.getMessage()).r("dsize", i5).ac("url", c.this.aXD));
                                            e8.printStackTrace();
                                        }
                                    }
                                    v.j(c.this.aXD, i5, (int) c.this.aqQ);
                                    j.au(c.TAG, "read end ..." + c.this);
                                    fileOutputStream.close();
                                    k.Lr().h(inputStream);
                                    c.this.aXN = j4;
                                } catch (Exception e9) {
                                    TiebaStatic.log(new ak("c12027").ac("errormsg", "连接中断，文件下载出现异常").ac("error", e9.getMessage()).ac("url", c.this.aXD));
                                    j.au(c.TAG, "download exception " + c.this);
                                    e9.printStackTrace();
                                }
                            }
                            j.au(c.TAG, "download out " + c.this);
                            while (c.this.aXH < c.this.aXI && !c.this.aXK) {
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e10) {
                                    e10.printStackTrace();
                                }
                                if (c.this.aXK) {
                                    break;
                                }
                            }
                            if (c.this.aXK) {
                                break;
                            }
                            long j9 = c.this.aXH;
                            int i6 = 0;
                            for (int i7 = 0; i7 < fileArr.length && !c.this.aXK; i7++) {
                                int length2 = (fileArr.length - 1) - i7;
                                File file5 = fileArr[length2];
                                if (file5 != null && file5.exists()) {
                                    if (c.this.aXO) {
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.au(c.TAG, "release some cached slices " + c.this);
                                        }
                                    } else {
                                        long g2 = m.g(file5);
                                        if ((Integer.parseInt(file5.getName()) + g2) - 1 < j9 && (i6 = (int) (i6 + g2)) > 31457280) {
                                            c.this.aXO = true;
                                            if (length2 != 0) {
                                                file5.delete();
                                                j.au(c.TAG, "release some cached slices " + c.this);
                                            }
                                        }
                                    }
                                }
                            }
                            j.au(c.TAG, "mLastRequestRangeEnd " + c.this.aXN + " mReadPosition " + c.this.aXH + "  " + c.this);
                            if (c.this.aXN == -1 || c.this.aXH <= c.this.aXN || c.this.aXN >= c.this.aXF) {
                                break;
                            }
                            try {
                                c.this.aXJ.close();
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            c.this.aXM = false;
                            c.this.aXG = c.this.aXN + 1;
                            j.au(c.TAG, "continue to download... " + c.this);
                        } else {
                            j.au(c.TAG, "do not download, return " + c.this);
                            break;
                        }
                    } catch (FileNotFoundException e12) {
                        e12.printStackTrace();
                    }
                } else {
                    m.z(new File(i.aYk + c.this.aXP + "/segments"));
                    TiebaStatic.log(new ak("c12028").ac("errormsg", "校验到缓存文件片段大小有异常").ac("url", c.this.aXD));
                    j.au(c.TAG, "cache error !");
                    break;
                }
            }
            e.Lj().s(c.this);
            j.au(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] aXQ = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aXD = str;
    }

    public void N(long j) {
        this.aqQ = j;
    }

    public void b(long j, long j2) {
        j.au(TAG, "open *************************************************************" + this);
        if (this.aXD != null) {
            this.aXE = j;
            this.aXF = j2;
            this.aXP = m.hz(this.aXD);
            if (this.aXP != null) {
                File file = new File(i.aYk + this.aXP);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aXL = file2.getAbsolutePath();
                    this.aXI = this.aXE;
                    this.aXH = this.aXE;
                    this.aXG = this.aXE;
                    this.aXK = false;
                    this.aXM = false;
                    this.aXN = -1L;
                    this.aXO = false;
                    l.Ls().e(this.aXR);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aXD;
    }

    public void close() {
        j.au(TAG, "close ***********************************************************************" + this);
        this.aXK = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aXJ != null) {
                this.aXJ.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.aYk + this.aXP + "/completed");
        if (this.aXO) {
            return;
        }
        if (file == null || !file.exists()) {
            k.Lr().hw(this.aXD);
        }
    }

    public boolean canRead() {
        return !this.aXK && this.aXH <= this.aXF;
    }

    public int read(byte[] bArr, int i) {
        if (this.aXK) {
            return 0;
        }
        do {
            if (this.aXH == this.aXI || !this.aXM) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aXJ.read(bArr, 0, (int) (this.aXH + ((long) i) < this.aXI ? i : this.aXI - this.aXH));
                    if (read >= 0) {
                        this.aXH += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aXK);
        return 0;
    }
}
