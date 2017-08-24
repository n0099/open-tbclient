package com.baidu.tieba.VideoCache;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
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
    private long aVX;
    private long aVY;
    private long aVZ;
    private long aWa;
    private long aWb;
    private FileInputStream aWc;
    private String aWi;
    private Context mContext;
    private String mVideoUrl;
    private boolean aWd = false;
    private String aWe = "";
    private Object mLock = new Object();
    private boolean aWf = false;
    private long aWg = -1;
    boolean aWh = false;
    private long arR = 0;
    private Runnable aWk = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.at(c.TAG, "test run in " + c.this);
            while (e.Ku().t(c.this)) {
                e.Ku().ho(c.this.mVideoUrl);
                try {
                    j.at(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.at(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.aWd) {
                    break;
                }
            }
            if (!c.this.aWd) {
                e.Ku().r(c.this);
            }
            while (true) {
                if (c.this.aWd) {
                    break;
                }
                j.at(c.TAG, "download in " + c.this);
                if (m.hx(c.this.aWi) <= c.this.arR) {
                    c.this.aWg = -1L;
                    File file2 = new File(c.this.aWe);
                    long j6 = c.this.aVZ;
                    long j7 = c.this.aVY;
                    File[] listFiles = file2.listFiles();
                    ArrayList arrayList = new ArrayList();
                    if (listFiles != null) {
                        for (File file3 : listFiles) {
                            if (c.this.aWd) {
                                break;
                            }
                            if (file3 != null && file3.exists()) {
                                try {
                                    Long.parseLong(file3.getName());
                                    if (m.getFileSize(file3) == 0) {
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
                    if (c.this.aWd) {
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
                                if (c.this.aWd) {
                                    j = 0;
                                    j5 = j6;
                                    j3 = 0;
                                    file = null;
                                    break;
                                }
                                File file4 = fileArr[i3];
                                try {
                                    long parseInt2 = Integer.parseInt(file4.getName());
                                    long fileSize = m.getFileSize(file4);
                                    long j8 = (parseInt2 + fileSize) - 1;
                                    if (c.this.aVZ >= parseInt2 && c.this.aVZ <= j8) {
                                        j3 = fileSize;
                                        file = file4;
                                        j = parseInt2;
                                        j5 = parseInt2 + fileSize;
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
                                if (!c.this.aWd) {
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
                    if (c.this.aWd) {
                        break;
                    }
                    boolean z2 = false;
                    if (file == null) {
                        String str2 = c.this.aWe + "/" + c.this.aVZ;
                        try {
                            new File(str2).createNewFile();
                        } catch (IOException e5) {
                            TiebaStatic.log(new aj("c12027").aa("errormsg", "创建缓存文件出现异常").aa("name", str2).aa("error", e5.getMessage()).aa("url", c.this.mVideoUrl));
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
                        c.this.aWc = new FileInputStream(str);
                        if (file != null) {
                            try {
                                c.this.aWc.skip(c.this.aVZ - j);
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (file != null) {
                            c.this.aWb = j + j3;
                        }
                        c.this.aWf = true;
                        synchronized (c.this.mLock) {
                            c.this.mLock.notify();
                        }
                        if (file == null || j6 <= c.this.aVY) {
                            if (c.this.aWd) {
                                break;
                            }
                            j.at(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            if (j6 > j4 || z2) {
                                c.this.aWg = (j + j3) - 1;
                            } else {
                                try {
                                    URL url = new URL(c.this.mVideoUrl);
                                    j.at(c.TAG, "url opt 1 " + c.this);
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                    j.at(c.TAG, "url opt 2 " + c.this);
                                    httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                    httpURLConnection.setConnectTimeout(5000);
                                    httpURLConnection.setReadTimeout(5000);
                                    j.at(c.TAG, "url opt 3 " + c.this);
                                    InputStream inputStream = httpURLConnection.getInputStream();
                                    while (inputStream == null) {
                                        j.at(c.TAG, "conn input is null " + c.this);
                                        if (c.this.aWd) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(10L);
                                        } catch (InterruptedException e7) {
                                            e7.printStackTrace();
                                        }
                                        inputStream = httpURLConnection.getInputStream();
                                    }
                                    j.at(c.TAG, "got conn input " + c.this);
                                    j.at(c.TAG, "url opt 4 " + c.this);
                                    int i5 = 0;
                                    FileOutputStream fileOutputStream = new FileOutputStream(str, true);
                                    j.at(c.TAG, "read start ..." + c.this);
                                    while (true) {
                                        try {
                                            int read = inputStream.read(c.this.aWj);
                                            if (read == -1 || c.this.aWd) {
                                                break;
                                            }
                                            fileOutputStream.write(c.this.aWj, 0, read);
                                            c.this.aWb += read;
                                            i5 += read;
                                            synchronized (c.this.mLock) {
                                                c.this.mLock.notify();
                                            }
                                        } catch (Exception e8) {
                                            TiebaStatic.log(new aj("c12027").aa("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").aa("error", e8.getMessage()).r("dsize", i5).aa("url", c.this.mVideoUrl));
                                            e8.printStackTrace();
                                        }
                                    }
                                    u.k(c.this.mVideoUrl, i5, (int) c.this.arR);
                                    j.at(c.TAG, "read end ..." + c.this);
                                    fileOutputStream.close();
                                    k.KB().w(inputStream);
                                    c.this.aWg = j4;
                                } catch (Exception e9) {
                                    TiebaStatic.log(new aj("c12027").aa("errormsg", "连接中断，文件下载出现异常").aa("error", e9.getMessage()).aa("url", c.this.mVideoUrl));
                                    j.at(c.TAG, "download exception " + c.this);
                                    e9.printStackTrace();
                                }
                            }
                            j.at(c.TAG, "download out " + c.this);
                            while (c.this.aWa < c.this.aWb && !c.this.aWd) {
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e10) {
                                    e10.printStackTrace();
                                }
                                if (c.this.aWd) {
                                    break;
                                }
                            }
                            if (c.this.aWd) {
                                break;
                            }
                            long j9 = c.this.aWa;
                            int i6 = 0;
                            for (int i7 = 0; i7 < fileArr.length && !c.this.aWd; i7++) {
                                int length2 = (fileArr.length - 1) - i7;
                                File file5 = fileArr[length2];
                                if (file5 != null && file5.exists()) {
                                    if (c.this.aWh) {
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.at(c.TAG, "release some cached slices " + c.this);
                                        }
                                    } else {
                                        long fileSize2 = m.getFileSize(file5);
                                        if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j9 && (i6 = (int) (i6 + fileSize2)) > 31457280) {
                                            c.this.aWh = true;
                                            if (length2 != 0) {
                                                file5.delete();
                                                j.at(c.TAG, "release some cached slices " + c.this);
                                            }
                                        }
                                    }
                                }
                            }
                            j.at(c.TAG, "mLastRequestRangeEnd " + c.this.aWg + " mReadPosition " + c.this.aWa + "  " + c.this);
                            if (c.this.aWg == -1 || c.this.aWa <= c.this.aWg || c.this.aWg >= c.this.aVY) {
                                break;
                            }
                            try {
                                c.this.aWc.close();
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            c.this.aWf = false;
                            c.this.aVZ = c.this.aWg + 1;
                            j.at(c.TAG, "continue to download... " + c.this);
                        } else {
                            j.at(c.TAG, "do not download, return " + c.this);
                            break;
                        }
                    } catch (FileNotFoundException e12) {
                        e12.printStackTrace();
                    }
                } else {
                    m.z(new File(i.aWD + c.this.aWi + "/segments"));
                    TiebaStatic.log(new aj("c12028").aa("errormsg", "校验到缓存文件片段大小有异常").aa("url", c.this.mVideoUrl));
                    j.at(c.TAG, "cache error !");
                    break;
                }
            }
            e.Ku().s(c.this);
            j.at(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] aWj = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void O(long j) {
        this.arR = j;
    }

    public void b(long j, long j2) {
        j.at(TAG, "open *************************************************************" + this);
        if (this.mVideoUrl != null) {
            this.aVX = j;
            this.aVY = j2;
            this.aWi = m.hy(this.mVideoUrl);
            if (this.aWi != null) {
                File file = new File(i.aWD + this.aWi);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aWe = file2.getAbsolutePath();
                    this.aWb = this.aVX;
                    this.aWa = this.aVX;
                    this.aVZ = this.aVX;
                    this.aWd = false;
                    this.aWf = false;
                    this.aWg = -1L;
                    this.aWh = false;
                    l.KC().g(this.aWk);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public void close() {
        j.at(TAG, "close ***********************************************************************" + this);
        this.aWd = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aWc != null) {
                this.aWc.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.aWD + this.aWi + "/completed");
        if (this.aWh) {
            return;
        }
        if (file == null || !file.exists()) {
            k.KB().hv(this.mVideoUrl);
        }
    }

    public boolean canRead() {
        return !this.aWd && this.aWa <= this.aVY;
    }

    public int e(byte[] bArr, int i) {
        if (this.aWd) {
            return 0;
        }
        do {
            if (this.aWa == this.aWb || !this.aWf) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aWc.read(bArr, 0, (int) (this.aWa + ((long) i) < this.aWb ? i : this.aWb - this.aWa));
                    if (read >= 0) {
                        this.aWa += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aWd);
        return 0;
    }
}
