package com.baidu.tieba.VideoCache;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.play.u;
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
    private String aVG;
    private long aVH;
    private long aVI;
    private long aVJ;
    private long aVK;
    private long aVL;
    private FileInputStream aVM;
    private String aVS;
    private Context mContext;
    private boolean aVN = false;
    private String aVO = "";
    private Object mLock = new Object();
    private boolean aVP = false;
    private long aVQ = -1;
    boolean aVR = false;
    private long arx = 0;
    private Runnable aVU = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.aw(c.TAG, "test run in " + c.this);
            while (e.KD().t(c.this)) {
                e.KD().hk(c.this.aVG);
                try {
                    j.aw(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.aw(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.aVN) {
                    break;
                }
            }
            if (!c.this.aVN) {
                e.KD().r(c.this);
            }
            while (true) {
                if (c.this.aVN) {
                    break;
                }
                j.aw(c.TAG, "download in " + c.this);
                if (m.ht(c.this.aVS) <= c.this.arx) {
                    c.this.aVQ = -1L;
                    File file2 = new File(c.this.aVO);
                    long j6 = c.this.aVJ;
                    long j7 = c.this.aVI;
                    File[] listFiles = file2.listFiles();
                    ArrayList arrayList = new ArrayList();
                    if (listFiles != null) {
                        for (File file3 : listFiles) {
                            if (c.this.aVN) {
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
                    if (c.this.aVN) {
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
                                if (c.this.aVN) {
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
                                    if (c.this.aVJ >= parseInt2 && c.this.aVJ <= j8) {
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
                                if (!c.this.aVN) {
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
                    if (c.this.aVN) {
                        break;
                    }
                    boolean z2 = false;
                    if (file == null) {
                        String str2 = c.this.aVO + "/" + c.this.aVJ;
                        try {
                            new File(str2).createNewFile();
                        } catch (IOException e5) {
                            TiebaStatic.log(new ak("c12027").ad("errormsg", "创建缓存文件出现异常").ad("name", str2).ad("error", e5.getMessage()).ad("url", c.this.aVG));
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
                        c.this.aVM = new FileInputStream(str);
                        if (file != null) {
                            try {
                                c.this.aVM.skip(c.this.aVJ - j);
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (file != null) {
                            c.this.aVL = j + j3;
                        }
                        c.this.aVP = true;
                        synchronized (c.this.mLock) {
                            c.this.mLock.notify();
                        }
                        if (file == null || j6 <= c.this.aVI) {
                            if (c.this.aVN) {
                                break;
                            }
                            j.aw(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            if (j6 > j4 || z2) {
                                c.this.aVQ = (j + j3) - 1;
                            } else {
                                try {
                                    URL url = new URL(c.this.aVG);
                                    j.aw(c.TAG, "url opt 1 " + c.this);
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                    j.aw(c.TAG, "url opt 2 " + c.this);
                                    httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                    httpURLConnection.setConnectTimeout(5000);
                                    httpURLConnection.setReadTimeout(5000);
                                    j.aw(c.TAG, "url opt 3 " + c.this);
                                    InputStream inputStream = httpURLConnection.getInputStream();
                                    while (inputStream == null) {
                                        j.aw(c.TAG, "conn input is null " + c.this);
                                        if (c.this.aVN) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(10L);
                                        } catch (InterruptedException e7) {
                                            e7.printStackTrace();
                                        }
                                        inputStream = httpURLConnection.getInputStream();
                                    }
                                    j.aw(c.TAG, "got conn input " + c.this);
                                    j.aw(c.TAG, "url opt 4 " + c.this);
                                    int i5 = 0;
                                    FileOutputStream fileOutputStream = new FileOutputStream(str, true);
                                    j.aw(c.TAG, "read start ..." + c.this);
                                    while (true) {
                                        try {
                                            int read = inputStream.read(c.this.aVT);
                                            if (read == -1 || c.this.aVN) {
                                                break;
                                            }
                                            fileOutputStream.write(c.this.aVT, 0, read);
                                            c.this.aVL += read;
                                            i5 += read;
                                            synchronized (c.this.mLock) {
                                                c.this.mLock.notify();
                                            }
                                        } catch (Exception e8) {
                                            TiebaStatic.log(new ak("c12027").ad("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ad("error", e8.getMessage()).r("dsize", i5).ad("url", c.this.aVG));
                                            e8.printStackTrace();
                                        }
                                    }
                                    u.k(c.this.aVG, i5, (int) c.this.arx);
                                    j.aw(c.TAG, "read end ..." + c.this);
                                    fileOutputStream.close();
                                    k.KL().k(inputStream);
                                    c.this.aVQ = j4;
                                } catch (Exception e9) {
                                    TiebaStatic.log(new ak("c12027").ad("errormsg", "连接中断，文件下载出现异常").ad("error", e9.getMessage()).ad("url", c.this.aVG));
                                    j.aw(c.TAG, "download exception " + c.this);
                                    e9.printStackTrace();
                                }
                            }
                            j.aw(c.TAG, "download out " + c.this);
                            while (c.this.aVK < c.this.aVL && !c.this.aVN) {
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e10) {
                                    e10.printStackTrace();
                                }
                                if (c.this.aVN) {
                                    break;
                                }
                            }
                            if (c.this.aVN) {
                                break;
                            }
                            long j9 = c.this.aVK;
                            int i6 = 0;
                            for (int i7 = 0; i7 < fileArr.length && !c.this.aVN; i7++) {
                                int length2 = (fileArr.length - 1) - i7;
                                File file5 = fileArr[length2];
                                if (file5 != null && file5.exists()) {
                                    if (c.this.aVR) {
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.aw(c.TAG, "release some cached slices " + c.this);
                                        }
                                    } else {
                                        long g2 = m.g(file5);
                                        if ((Integer.parseInt(file5.getName()) + g2) - 1 < j9 && (i6 = (int) (i6 + g2)) > 31457280) {
                                            c.this.aVR = true;
                                            if (length2 != 0) {
                                                file5.delete();
                                                j.aw(c.TAG, "release some cached slices " + c.this);
                                            }
                                        }
                                    }
                                }
                            }
                            j.aw(c.TAG, "mLastRequestRangeEnd " + c.this.aVQ + " mReadPosition " + c.this.aVK + "  " + c.this);
                            if (c.this.aVQ == -1 || c.this.aVK <= c.this.aVQ || c.this.aVQ >= c.this.aVI) {
                                break;
                            }
                            try {
                                c.this.aVM.close();
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            c.this.aVP = false;
                            c.this.aVJ = c.this.aVQ + 1;
                            j.aw(c.TAG, "continue to download... " + c.this);
                        } else {
                            j.aw(c.TAG, "do not download, return " + c.this);
                            break;
                        }
                    } catch (FileNotFoundException e12) {
                        e12.printStackTrace();
                    }
                } else {
                    m.B(new File(i.aWn + c.this.aVS + "/segments"));
                    TiebaStatic.log(new ak("c12028").ad("errormsg", "校验到缓存文件片段大小有异常").ad("url", c.this.aVG));
                    j.aw(c.TAG, "cache error !");
                    break;
                }
            }
            e.KD().s(c.this);
            j.aw(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] aVT = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aVG = str;
    }

    public void N(long j) {
        this.arx = j;
    }

    public void b(long j, long j2) {
        j.aw(TAG, "open *************************************************************" + this);
        if (this.aVG != null) {
            this.aVH = j;
            this.aVI = j2;
            this.aVS = m.hu(this.aVG);
            if (this.aVS != null) {
                File file = new File(i.aWn + this.aVS);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aVO = file2.getAbsolutePath();
                    this.aVL = this.aVH;
                    this.aVK = this.aVH;
                    this.aVJ = this.aVH;
                    this.aVN = false;
                    this.aVP = false;
                    this.aVQ = -1L;
                    this.aVR = false;
                    l.KM().e(this.aVU);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aVG;
    }

    public void close() {
        j.aw(TAG, "close ***********************************************************************" + this);
        this.aVN = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aVM != null) {
                this.aVM.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.aWn + this.aVS + "/completed");
        if (this.aVR) {
            return;
        }
        if (file == null || !file.exists()) {
            k.KL().hr(this.aVG);
        }
    }

    public boolean canRead() {
        return !this.aVN && this.aVK <= this.aVI;
    }

    public int e(byte[] bArr, int i) {
        if (this.aVN) {
            return 0;
        }
        do {
            if (this.aVK == this.aVL || !this.aVP) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aVM.read(bArr, 0, (int) (this.aVK + ((long) i) < this.aVL ? i : this.aVL - this.aVK));
                    if (read >= 0) {
                        this.aVK += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aVN);
        return 0;
    }
}
