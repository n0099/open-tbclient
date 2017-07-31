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
    private long aVV;
    private long aVW;
    private long aVX;
    private long aVY;
    private long aVZ;
    private FileInputStream aWa;
    private String aWg;
    private Context mContext;
    private String mVideoUrl;
    private boolean aWb = false;
    private String aWc = "";
    private Object mLock = new Object();
    private boolean aWd = false;
    private long aWe = -1;
    boolean aWf = false;
    private long arQ = 0;
    private Runnable aWi = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.log(c.TAG, "test run in " + c.this);
            while (e.Ku().t(c.this)) {
                e.Ku().hl(c.this.mVideoUrl);
                try {
                    j.log(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.log(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.aWb) {
                    break;
                }
            }
            if (!c.this.aWb) {
                e.Ku().r(c.this);
            }
            while (true) {
                if (c.this.aWb) {
                    break;
                }
                j.log(c.TAG, "download in " + c.this);
                if (m.hu(c.this.aWg) <= c.this.arQ) {
                    c.this.aWe = -1L;
                    File file2 = new File(c.this.aWc);
                    long j6 = c.this.aVX;
                    long j7 = c.this.aVW;
                    File[] listFiles = file2.listFiles();
                    ArrayList arrayList = new ArrayList();
                    if (listFiles != null) {
                        for (File file3 : listFiles) {
                            if (c.this.aWb) {
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
                    if (c.this.aWb) {
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
                                if (c.this.aWb) {
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
                                    if (c.this.aVX >= parseInt2 && c.this.aVX <= j8) {
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
                                if (!c.this.aWb) {
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
                    if (c.this.aWb) {
                        break;
                    }
                    boolean z2 = false;
                    if (file == null) {
                        String str2 = c.this.aWc + "/" + c.this.aVX;
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
                        c.this.aWa = new FileInputStream(str);
                        if (file != null) {
                            try {
                                c.this.aWa.skip(c.this.aVX - j);
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (file != null) {
                            c.this.aVZ = j + j3;
                        }
                        c.this.aWd = true;
                        synchronized (c.this.mLock) {
                            c.this.mLock.notify();
                        }
                        if (file == null || j6 <= c.this.aVW) {
                            if (c.this.aWb) {
                                break;
                            }
                            j.log(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            if (j6 > j4 || z2) {
                                c.this.aWe = (j + j3) - 1;
                            } else {
                                try {
                                    URL url = new URL(c.this.mVideoUrl);
                                    j.log(c.TAG, "url opt 1 " + c.this);
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                    j.log(c.TAG, "url opt 2 " + c.this);
                                    httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                    httpURLConnection.setConnectTimeout(5000);
                                    httpURLConnection.setReadTimeout(5000);
                                    j.log(c.TAG, "url opt 3 " + c.this);
                                    InputStream inputStream = httpURLConnection.getInputStream();
                                    while (inputStream == null) {
                                        j.log(c.TAG, "conn input is null " + c.this);
                                        if (c.this.aWb) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(10L);
                                        } catch (InterruptedException e7) {
                                            e7.printStackTrace();
                                        }
                                        inputStream = httpURLConnection.getInputStream();
                                    }
                                    j.log(c.TAG, "got conn input " + c.this);
                                    j.log(c.TAG, "url opt 4 " + c.this);
                                    int i5 = 0;
                                    FileOutputStream fileOutputStream = new FileOutputStream(str, true);
                                    j.log(c.TAG, "read start ..." + c.this);
                                    while (true) {
                                        try {
                                            int read = inputStream.read(c.this.aWh);
                                            if (read == -1 || c.this.aWb) {
                                                break;
                                            }
                                            fileOutputStream.write(c.this.aWh, 0, read);
                                            c.this.aVZ += read;
                                            i5 += read;
                                            synchronized (c.this.mLock) {
                                                c.this.mLock.notify();
                                            }
                                        } catch (Exception e8) {
                                            TiebaStatic.log(new aj("c12027").aa("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").aa("error", e8.getMessage()).r("dsize", i5).aa("url", c.this.mVideoUrl));
                                            e8.printStackTrace();
                                        }
                                    }
                                    u.j(c.this.mVideoUrl, i5, (int) c.this.arQ);
                                    j.log(c.TAG, "read end ..." + c.this);
                                    fileOutputStream.close();
                                    k.KB().w(inputStream);
                                    c.this.aWe = j4;
                                } catch (Exception e9) {
                                    TiebaStatic.log(new aj("c12027").aa("errormsg", "连接中断，文件下载出现异常").aa("error", e9.getMessage()).aa("url", c.this.mVideoUrl));
                                    j.log(c.TAG, "download exception " + c.this);
                                    e9.printStackTrace();
                                }
                            }
                            j.log(c.TAG, "download out " + c.this);
                            while (c.this.aVY < c.this.aVZ && !c.this.aWb) {
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e10) {
                                    e10.printStackTrace();
                                }
                                if (c.this.aWb) {
                                    break;
                                }
                            }
                            if (c.this.aWb) {
                                break;
                            }
                            long j9 = c.this.aVY;
                            int i6 = 0;
                            for (int i7 = 0; i7 < fileArr.length && !c.this.aWb; i7++) {
                                int length2 = (fileArr.length - 1) - i7;
                                File file5 = fileArr[length2];
                                if (file5 != null && file5.exists()) {
                                    if (c.this.aWf) {
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.log(c.TAG, "release some cached slices " + c.this);
                                        }
                                    } else {
                                        long fileSize2 = m.getFileSize(file5);
                                        if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j9 && (i6 = (int) (i6 + fileSize2)) > 31457280) {
                                            c.this.aWf = true;
                                            if (length2 != 0) {
                                                file5.delete();
                                                j.log(c.TAG, "release some cached slices " + c.this);
                                            }
                                        }
                                    }
                                }
                            }
                            j.log(c.TAG, "mLastRequestRangeEnd " + c.this.aWe + " mReadPosition " + c.this.aVY + "  " + c.this);
                            if (c.this.aWe == -1 || c.this.aVY <= c.this.aWe || c.this.aWe >= c.this.aVW) {
                                break;
                            }
                            try {
                                c.this.aWa.close();
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            c.this.aWd = false;
                            c.this.aVX = c.this.aWe + 1;
                            j.log(c.TAG, "continue to download... " + c.this);
                        } else {
                            j.log(c.TAG, "do not download, return " + c.this);
                            break;
                        }
                    } catch (FileNotFoundException e12) {
                        e12.printStackTrace();
                    }
                } else {
                    m.z(new File(i.aWB + c.this.aWg + "/segments"));
                    TiebaStatic.log(new aj("c12028").aa("errormsg", "校验到缓存文件片段大小有异常").aa("url", c.this.mVideoUrl));
                    j.log(c.TAG, "cache error !");
                    break;
                }
            }
            e.Ku().s(c.this);
            j.log(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] aWh = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void O(long j) {
        this.arQ = j;
    }

    public void b(long j, long j2) {
        j.log(TAG, "open *************************************************************" + this);
        if (this.mVideoUrl != null) {
            this.aVV = j;
            this.aVW = j2;
            this.aWg = m.hv(this.mVideoUrl);
            if (this.aWg != null) {
                File file = new File(i.aWB + this.aWg);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aWc = file2.getAbsolutePath();
                    this.aVZ = this.aVV;
                    this.aVY = this.aVV;
                    this.aVX = this.aVV;
                    this.aWb = false;
                    this.aWd = false;
                    this.aWe = -1L;
                    this.aWf = false;
                    l.KC().g(this.aWi);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public void close() {
        j.log(TAG, "close ***********************************************************************" + this);
        this.aWb = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aWa != null) {
                this.aWa.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.aWB + this.aWg + "/completed");
        if (this.aWf) {
            return;
        }
        if (file == null || !file.exists()) {
            k.KB().hs(this.mVideoUrl);
        }
    }

    public boolean canRead() {
        return !this.aWb && this.aVY <= this.aVW;
    }

    public int e(byte[] bArr, int i) {
        if (this.aWb) {
            return 0;
        }
        do {
            if (this.aVY == this.aVZ || !this.aWd) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aWa.read(bArr, 0, (int) (this.aVY + ((long) i) < this.aVZ ? i : this.aVZ - this.aVY));
                    if (read >= 0) {
                        this.aVY += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aWb);
        return 0;
    }
}
