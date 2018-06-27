package com.baidu.tieba.VideoCache;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
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
    private String bcS;
    private FileInputStream bkC;
    private String bkI;
    private long bkK;
    private long bku;
    private long bkv;
    private long bkw;
    private long bkx;
    private long bky;
    private Context mContext;
    private long bkz = 0;
    private long bkA = -1;
    private boolean bkB = false;
    private boolean bkD = false;
    private String bkE = "";
    private Object mLock = new Object();
    private boolean bkF = false;
    private long bkG = -1;
    boolean bkH = false;
    private Object bkL = new Object();
    private long aBX = 0;
    private Runnable bkM = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
        @Override // java.lang.Runnable
        public void run() {
            long j;
            long j2;
            long j3;
            File file;
            String str;
            long j4;
            String str2;
            FileOutputStream fileOutputStream;
            boolean z;
            long j5;
            long parseInt;
            j.aB(c.TAG, "test run in " + c.this);
            while (e.PX().y(c.this)) {
                e.PX().ii(c.this.bcS);
                try {
                    j.aB(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.aB(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.bkD) {
                    break;
                }
            }
            if (!c.this.bkD) {
                e.PX().w(c.this);
            }
            while (true) {
                if (c.this.bkD) {
                    break;
                }
                j.aB(c.TAG, "download in " + c.this);
                if (c.this.PU()) {
                    break;
                }
                c.this.bkG = -1L;
                File file2 = new File(c.this.bkE);
                long j6 = c.this.bkw;
                long j7 = c.this.bkv;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.bkD) {
                            break;
                        }
                        if (file3 != null && file3.exists()) {
                            try {
                                Long.parseLong(file3.getName());
                                if (m.h(file3) == 0) {
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
                if (c.this.bkD) {
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
                    j.aB(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + " " + c.this);
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
                            if (c.this.bkD) {
                                j = 0;
                                j5 = j6;
                                j3 = 0;
                                file = null;
                                break;
                            }
                            File file4 = fileArr[i3];
                            try {
                                long parseInt2 = Integer.parseInt(file4.getName());
                                long h = m.h(file4);
                                j.aB(c.TAG, "file size " + h);
                                long j8 = (parseInt2 + h) - 1;
                                if (c.this.bkw >= parseInt2 && c.this.bkw <= j8) {
                                    j3 = h;
                                    file = file4;
                                    j = parseInt2;
                                    j5 = parseInt2 + h;
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
                            if (!c.this.bkD) {
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
                if (c.this.bkD) {
                    break;
                }
                j.aB(c.TAG, "total range is " + c.this.bkw + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.bkv + " " + c.this);
                j.aB(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.bkE + "/" + c.this.bkw;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new an("c12027").ah("errormsg", "创建缓存文件出现异常").ah("name", str3).ah("error", e5.getMessage()).ah("url", c.this.bcS));
                        e5.printStackTrace();
                        str = null;
                    }
                    if ((j2 - j6) + 1 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                        String str4 = str;
                        j4 = (PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED + j6) - 1;
                        str2 = str4;
                    } else {
                        String str5 = str;
                        j4 = j2;
                        str2 = str5;
                    }
                } else {
                    String absolutePath = file.getAbsolutePath();
                    long length = file.length();
                    if (length >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                        j4 = j2;
                        z = true;
                    } else if ((j2 - j6) + 1 + length <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                        j4 = j2;
                        z = false;
                    } else {
                        j4 = ((PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - length) + j6) - 1;
                        z = false;
                    }
                    z2 = z;
                    str2 = absolutePath;
                }
                if (str2 != null) {
                    try {
                        c.this.bkC = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.bkC = null;
                }
                if (file != null) {
                    try {
                        if (c.this.bkC != null) {
                            c.this.bkC.skip(c.this.bkw - j);
                        }
                        j.aB(c.TAG, "skip: " + (c.this.bkw - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.aB(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.bky = j + j3;
                } else {
                    j.aB(c.TAG, "hit file: null " + c.this);
                }
                j.aB(c.TAG, "first mReadPosition " + c.this.bkx + " first writeposition " + c.this.bky + " " + c.this);
                c.this.bkF = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.bkv) {
                    if (c.this.bkD) {
                        break;
                    }
                    j.aB(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.bkG = (j + j3) - 1;
                    } else {
                        try {
                            j.aB(c.TAG, "download start waitting ...... ");
                            while (c.this.PV()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.bkD) {
                                    break;
                                }
                            }
                            c.this.bkA = -1L;
                            URL url = new URL(c.this.bcS);
                            j.aB(c.TAG, "url opt 1 " + c.this);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            j.aB(c.TAG, "url opt 2 " + c.this);
                            httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            j.aB(c.TAG, "url opt 3 " + c.this);
                            InputStream inputStream = httpURLConnection.getInputStream();
                            while (inputStream == null) {
                                j.aB(c.TAG, "conn input is null " + c.this);
                                if (c.this.bkD) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e9) {
                                    e9.printStackTrace();
                                }
                                inputStream = httpURLConnection.getInputStream();
                            }
                            j.aB(c.TAG, "got conn input " + c.this);
                            j.aB(c.TAG, "url opt 4 " + c.this);
                            int i5 = 0;
                            if (str2 == null) {
                                fileOutputStream = null;
                            } else {
                                fileOutputStream = new FileOutputStream(str2, true);
                            }
                            j.aB(c.TAG, "read start ..." + c.this);
                            while (true) {
                                try {
                                    int read = inputStream.read(c.this.bkJ);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.aB(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.bkD) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.bkJ, 0, read);
                                    } else {
                                        c.this.bkK = read;
                                    }
                                    c.this.bky += read;
                                    i5 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.bkK != 0) {
                                            synchronized (c.this.bkL) {
                                                try {
                                                    c.this.bkL.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.bkD) {
                                                break;
                                            }
                                        }
                                        if (c.this.bkD) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new an("c12027").ah("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ah("error", e11.getMessage()).r("dsize", i5).ah("url", c.this.bcS));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.bkz = 0L;
                            v.r(c.this.bcS, i5, (int) c.this.aBX);
                            j.aB(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.Qg().j(inputStream);
                            c.this.bkG = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new an("c12027").ah("errormsg", "连接中断，文件下载出现异常").ah("error", e12.getMessage()).ah("url", c.this.bcS));
                            j.aB(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.aB(c.TAG, "download out " + c.this);
                    while (c.this.bkx < c.this.bky && !c.this.bkD) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.bkD) {
                            break;
                        }
                    }
                    if (c.this.bkz > 0 && c.this.bkz <= 3) {
                        j.aB(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bkG);
                        c.this.bkG = c.this.bkx - 1;
                        j.aB(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bkG);
                    }
                    if (c.this.bkD) {
                        break;
                    }
                    long j9 = c.this.bkx;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length && !c.this.bkD; i7++) {
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.bkH) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.aB(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long h2 = m.h(file5);
                                if ((Integer.parseInt(file5.getName()) + h2) - 1 < j9 && (i6 = (int) (i6 + h2)) > 31457280) {
                                    c.this.bkH = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.aB(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.aB(c.TAG, "mLastRequestRangeEnd " + c.this.bkG + " mReadPosition " + c.this.bkx + "  " + c.this);
                    if (c.this.bkG == -1 || c.this.bkx <= c.this.bkG || c.this.bkG >= c.this.bkv) {
                        break;
                    }
                    try {
                        if (c.this.bkC != null) {
                            c.this.bkC.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.bkF = false;
                    c.this.bkw = c.this.bkG + 1;
                    j.aB(c.TAG, "continue to download... " + c.this);
                } else {
                    j.aB(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.PX().x(c.this);
            j.aB(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] bkJ = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.bkz;
        cVar.bkz = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.bcS = str;
    }

    public void U(long j) {
        this.aBX = j;
    }

    public void c(long j, long j2) {
        j.aB(TAG, "open *************************************************************" + this);
        if (this.bcS != null) {
            this.bku = j;
            this.bkv = j2;
            this.bkI = m.is(this.bcS);
            if (this.bkI != null) {
                File file = new File(i.blf + this.bkI);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.bkE = file2.getAbsolutePath();
                    this.bky = this.bku;
                    this.bkx = this.bku;
                    this.bkw = this.bku;
                    this.bkD = false;
                    this.bkF = false;
                    this.bkG = -1L;
                    this.bkH = false;
                    l.Qh().e(this.bkM);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.bcS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PU() {
        if (m.ir(this.bkI) > this.aBX) {
            m.y(new File(i.blf + this.bkI + "/segments"));
            TiebaStatic.log(new an("c12028").ah("errormsg", "校验到缓存文件片段大小有异常").ah("url", this.bcS));
            j.aB(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void ay(long j) {
        if (j == -1) {
            j.aB(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.bkB = true;
        } else if (j == 0 && this.bkB) {
            j.aB(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.bkA = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PV() {
        if (!this.bkB || this.bkA != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.aB(TAG, "close ***********************************************************************" + this);
        this.bkD = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.bkC != null) {
                this.bkC.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.blf + this.bkI + "/completed");
        if (this.bkH) {
            return;
        }
        if (file == null || !file.exists()) {
            k.Qg().ip(this.bcS);
        }
    }

    public boolean canRead() {
        return !this.bkD && this.bkx <= this.bkv;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.bkD) {
            return 0;
        }
        do {
            if (this.bkx == this.bky || !this.bkF) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.bkx + ((long) i) < this.bky ? i : this.bky - this.bkx);
                try {
                    if (this.bkC == null) {
                        if (this.bkK > 0) {
                            System.arraycopy(this.bkJ, 0, bArr, 0, (int) this.bkK);
                            read = (int) this.bkK;
                            this.bkK = 0L;
                            synchronized (this.bkL) {
                                this.bkL.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.bkC.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.bkx += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.bkD);
        return 0;
    }
}
