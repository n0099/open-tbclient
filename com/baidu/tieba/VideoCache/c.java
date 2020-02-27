package com.baidu.tieba.VideoCache;

import android.content.Context;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.play.v;
import com.baidubce.http.Headers;
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
/* loaded from: classes9.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private FileInputStream dWC;
    private String dWH;
    private long dWJ;
    private long dWu;
    private long dWv;
    private long dWw;
    private long dWx;
    private long dWy;
    private Context mContext;
    private String mVideoUrl;
    private long dWz = 0;
    private long dWA = -1;
    private boolean dWB = false;
    private boolean dWD = false;
    private String dcZ = "";
    private Object mLock = new Object();
    private boolean dWE = false;
    private long dWF = -1;
    boolean dWG = false;
    private Object dWK = new Object();
    private long mTotalLength = 0;
    private Runnable dWL = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [526=4] */
        /* JADX WARN: Removed duplicated region for block: B:163:0x082f  */
        /* JADX WARN: Removed duplicated region for block: B:283:0x0a58 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:319:0x00d1 A[EDGE_INSN: B:319:0x00d1->B:16:0x00d1 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:370:0x07b1 A[EDGE_INSN: B:370:0x07b1->B:156:0x07b1 ?: BREAK  , SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            long j;
            long j2;
            long j3;
            File file;
            String str;
            long j4;
            String str2;
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2;
            boolean z;
            long j5;
            long parseInt;
            j.z(c.TAG, "test run in " + c.this);
            while (e.aXd().y(c.this)) {
                e.aXd().ws(c.this.mVideoUrl);
                try {
                    j.z(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.z(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.dWD) {
                    break;
                }
            }
            if (!c.this.dWD) {
                e.aXd().w(c.this);
            }
            while (true) {
                if (c.this.dWD) {
                    break;
                }
                j.z(c.TAG, "download in " + c.this);
                if (c.this.aXa()) {
                    break;
                }
                c.this.dWF = -1L;
                File file2 = new File(c.this.dcZ);
                long j6 = c.this.dWw;
                long j7 = c.this.dWv;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.dWD) {
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
                if (c.this.dWD) {
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
                    j.z(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + HanziToPinyin.Token.SEPARATOR + c.this);
                    i = i2 + 1;
                }
                if (fileArr != null && fileArr.length > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= fileArr.length) {
                            j = 0;
                            j5 = j6;
                            j3 = 0;
                            file = null;
                            break;
                        } else if (c.this.dWD) {
                            j = 0;
                            j5 = j6;
                            j3 = 0;
                            file = null;
                            break;
                        } else {
                            File file4 = fileArr[i3];
                            try {
                                long parseInt2 = Integer.parseInt(file4.getName());
                                long fileSize = m.getFileSize(file4);
                                j.z(c.TAG, "file size " + fileSize);
                                long j8 = (parseInt2 + fileSize) - 1;
                                if (c.this.dWw >= parseInt2 && c.this.dWw <= j8) {
                                    j3 = fileSize;
                                    file = file4;
                                    j = parseInt2;
                                    j5 = parseInt2 + fileSize;
                                    break;
                                }
                            } catch (Exception e3) {
                            }
                            i3++;
                        }
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= fileArr.length) {
                            j6 = j5;
                            j2 = j7;
                            break;
                        } else if (c.this.dWD) {
                            j6 = j5;
                            j2 = j7;
                            break;
                        } else {
                            try {
                                parseInt = Integer.parseInt(fileArr[i4].getName());
                            } catch (Exception e4) {
                            }
                            if (parseInt >= j5) {
                                j6 = j5;
                                j2 = parseInt - 1;
                                break;
                            }
                            i4++;
                        }
                    }
                } else {
                    j = 0;
                    j2 = j7;
                    j3 = 0;
                    file = null;
                }
                if (c.this.dWD) {
                    break;
                }
                j.z(c.TAG, "total range is " + c.this.dWw + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.dWv + HanziToPinyin.Token.SEPARATOR + c.this);
                j.z(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + HanziToPinyin.Token.SEPARATOR + c.this);
                boolean z2 = false;
                if (file != null) {
                    String absolutePath = file.getAbsolutePath();
                    long length = file.length();
                    if (length >= 1048576) {
                        j4 = j2;
                        z = true;
                    } else if ((j2 - j6) + 1 + length > 1048576) {
                        j4 = ((1048576 - length) + j6) - 1;
                        z = false;
                    } else {
                        j4 = j2;
                        z = false;
                    }
                    z2 = z;
                    str2 = absolutePath;
                } else {
                    String str3 = c.this.dcZ + "/" + c.this.dWw;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new an("c12027").cy("errormsg", "创建缓存文件出现异常").cy("name", str3).cy(BdStatsConstant.StatsType.ERROR, e5.getMessage()).cy("url", c.this.mVideoUrl));
                        e5.printStackTrace();
                        str = null;
                    }
                    if ((j2 - j6) + 1 > 1048576) {
                        String str4 = str;
                        j4 = (1048576 + j6) - 1;
                        str2 = str4;
                    } else {
                        String str5 = str;
                        j4 = j2;
                        str2 = str5;
                    }
                }
                if (str2 != null) {
                    try {
                        c.this.dWC = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.dWC = null;
                }
                if (file != null) {
                    try {
                        if (c.this.dWC != null) {
                            c.this.dWC.skip(c.this.dWw - j);
                        }
                        j.z(c.TAG, "skip: " + (c.this.dWw - j) + HanziToPinyin.Token.SEPARATOR + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.z(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + HanziToPinyin.Token.SEPARATOR + c.this);
                    c.this.dWy = j + j3;
                } else {
                    j.z(c.TAG, "hit file: null " + c.this);
                }
                j.z(c.TAG, "first mReadPosition " + c.this.dWx + " first writeposition " + c.this.dWy + HanziToPinyin.Token.SEPARATOR + c.this);
                c.this.dWE = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.dWv) {
                    if (c.this.dWD) {
                        break;
                    } else {
                        j.z(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                        HttpURLConnection httpURLConnection3 = null;
                        if (j6 > j4 || z2) {
                            c.this.dWF = (j + j3) - 1;
                            httpURLConnection = null;
                        } else {
                            try {
                                j.z(c.TAG, "download start waitting ...... ");
                                while (c.this.aXb()) {
                                    try {
                                        Thread.sleep(20L);
                                    } catch (InterruptedException e8) {
                                        e8.printStackTrace();
                                    }
                                    if (c.this.dWD) {
                                        break;
                                    }
                                }
                                c.this.dWA = -1L;
                                URL url = new URL(c.this.mVideoUrl);
                                j.z(c.TAG, "url opt 1 " + c.this);
                                httpURLConnection = (HttpURLConnection) url.openConnection();
                                try {
                                    try {
                                        j.z(c.TAG, "url opt 2 " + c.this);
                                        httpURLConnection.setRequestProperty(Headers.RANGE, "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                        httpURLConnection.setConnectTimeout(5000);
                                        httpURLConnection.setReadTimeout(5000);
                                        j.z(c.TAG, "url opt 3 " + c.this);
                                        InputStream inputStream = httpURLConnection.getInputStream();
                                        while (inputStream == null) {
                                            j.z(c.TAG, "conn input is null " + c.this);
                                            if (c.this.dWD) {
                                                break;
                                            }
                                            try {
                                                Thread.sleep(10L);
                                            } catch (InterruptedException e9) {
                                                e9.printStackTrace();
                                            }
                                            inputStream = httpURLConnection.getInputStream();
                                        }
                                        j.z(c.TAG, "got conn input " + c.this);
                                        j.z(c.TAG, "url opt 4 " + c.this);
                                        int i5 = 0;
                                        FileOutputStream fileOutputStream = str2 != null ? new FileOutputStream(str2, true) : null;
                                        j.z(c.TAG, "read start ..." + c.this);
                                        while (true) {
                                            try {
                                                int read = inputStream.read(c.this.dWI);
                                                if (read == -1) {
                                                    break;
                                                }
                                                j.z(c.TAG, "read length " + read + HanziToPinyin.Token.SEPARATOR + c.this);
                                                if (c.this.dWD) {
                                                    break;
                                                }
                                                if (str2 != null) {
                                                    fileOutputStream.write(c.this.dWI, 0, read);
                                                } else {
                                                    c.this.dWJ = read;
                                                }
                                                c.this.dWy += read;
                                                i5 += read;
                                                synchronized (c.this.mLock) {
                                                    c.this.mLock.notify();
                                                }
                                                if (str2 == null) {
                                                    while (c.this.dWJ != 0) {
                                                        synchronized (c.this.dWK) {
                                                            try {
                                                                c.this.dWK.wait(100L);
                                                            } catch (InterruptedException e10) {
                                                                e10.printStackTrace();
                                                            }
                                                        }
                                                        if (c.this.dWD) {
                                                            break;
                                                        }
                                                    }
                                                    if (c.this.dWD) {
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e11) {
                                                TiebaStatic.log(new an("c12027").cy("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").cy(BdStatsConstant.StatsType.ERROR, e11.getMessage()).X("dsize", i5).cy("url", c.this.mVideoUrl));
                                                e11.printStackTrace();
                                                c.p(c.this);
                                            }
                                        }
                                        c.this.dWz = 0L;
                                        v.x(c.this.mVideoUrl, i5, (int) c.this.mTotalLength);
                                        j.z(c.TAG, "read end ..." + c.this);
                                        if (str2 != null) {
                                            fileOutputStream.close();
                                        }
                                        k.aXl().l(inputStream);
                                        c.this.dWF = j4;
                                    } catch (Exception e12) {
                                        httpURLConnection2 = httpURLConnection;
                                        e = e12;
                                        try {
                                            TiebaStatic.log(new an("c12027").cy("errormsg", "连接中断，文件下载出现异常").cy(BdStatsConstant.StatsType.ERROR, e.getMessage()).cy("url", c.this.mVideoUrl));
                                            j.z(c.TAG, "download exception " + c.this);
                                            e.printStackTrace();
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable th) {
                                                }
                                            }
                                            j.z(c.TAG, "download out " + c.this);
                                            while (c.this.dWx < c.this.dWy) {
                                                try {
                                                    Thread.sleep(10L);
                                                } catch (InterruptedException e13) {
                                                    e13.printStackTrace();
                                                }
                                                if (c.this.dWD) {
                                                }
                                            }
                                            if (c.this.dWz > 0) {
                                                j.z(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.dWF);
                                                c.this.dWF = c.this.dWx - 1;
                                                j.z(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.dWF);
                                            }
                                            if (!c.this.dWD) {
                                            }
                                            e.aXd().x(c.this);
                                            j.z(c.TAG, "test run out ***************************************************************" + c.this);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            httpURLConnection3 = httpURLConnection2;
                                            if (httpURLConnection3 != null) {
                                                try {
                                                    httpURLConnection3.disconnect();
                                                } catch (Throwable th3) {
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    httpURLConnection3 = httpURLConnection;
                                    th = th4;
                                    if (httpURLConnection3 != null) {
                                    }
                                    throw th;
                                }
                            } catch (Exception e14) {
                                e = e14;
                                httpURLConnection2 = null;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        }
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th6) {
                            }
                        }
                        j.z(c.TAG, "download out " + c.this);
                        while (c.this.dWx < c.this.dWy && !c.this.dWD) {
                            Thread.sleep(10L);
                            if (c.this.dWD) {
                                break;
                            }
                        }
                        if (c.this.dWz > 0 && c.this.dWz <= 3) {
                            j.z(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.dWF);
                            c.this.dWF = c.this.dWx - 1;
                            j.z(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.dWF);
                        }
                        if (!c.this.dWD) {
                            break;
                        }
                        long j9 = c.this.dWx;
                        int i6 = 0;
                        for (int i7 = 0; i7 < fileArr.length && !c.this.dWD; i7++) {
                            int length2 = (fileArr.length - 1) - i7;
                            File file5 = fileArr[length2];
                            if (file5 != null && file5.exists()) {
                                if (!c.this.dWG) {
                                    long fileSize2 = m.getFileSize(file5);
                                    if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j9 && (i6 = (int) (i6 + fileSize2)) > 31457280) {
                                        c.this.dWG = true;
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.z(c.TAG, "release some cached slices " + c.this);
                                        }
                                    }
                                } else if (length2 != 0) {
                                    file5.delete();
                                    j.z(c.TAG, "release some cached slices " + c.this);
                                }
                            }
                        }
                        j.z(c.TAG, "mLastRequestRangeEnd " + c.this.dWF + " mReadPosition " + c.this.dWx + HanziToPinyin.Token.SEPARATOR + HanziToPinyin.Token.SEPARATOR + c.this);
                        if (c.this.dWF == -1 || c.this.dWx <= c.this.dWF || c.this.dWF >= c.this.dWv) {
                            break;
                        }
                        try {
                            if (c.this.dWC != null) {
                                c.this.dWC.close();
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                        c.this.dWE = false;
                        c.this.dWw = c.this.dWF + 1;
                        j.z(c.TAG, "continue to download... " + c.this);
                    }
                } else {
                    j.z(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.aXd().x(c.this);
            j.z(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] dWI = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.dWz;
        cVar.dWz = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void setTotalLength(long j) {
        this.mTotalLength = j;
    }

    public void t(long j, long j2) {
        j.z(TAG, "open *************************************************************" + this);
        if (this.mVideoUrl != null) {
            this.dWu = j;
            this.dWv = j2;
            this.dWH = m.wC(this.mVideoUrl);
            if (this.dWH != null) {
                File file = new File(i.dXe + this.dWH);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.dcZ = file2.getAbsolutePath();
                    this.dWy = this.dWu;
                    this.dWx = this.dWu;
                    this.dWw = this.dWu;
                    this.dWD = false;
                    this.dWE = false;
                    this.dWF = -1L;
                    this.dWG = false;
                    l.aXm().n(this.dWL);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXa() {
        if (m.wB(this.dWH) > this.mTotalLength) {
            m.J(new File(i.dXe + this.dWH + "/segments"));
            TiebaStatic.log(new an("c12028").cy("errormsg", "校验到缓存文件片段大小有异常").cy("url", this.mVideoUrl));
            j.z(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void ck(long j) {
        if (j == -1) {
            j.z(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.dWB = true;
        } else if (j == 0 && this.dWB) {
            j.z(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.dWA = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXb() {
        if (!this.dWB || this.dWA != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.z(TAG, "close ***********************************************************************" + this);
        this.dWD = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.dWC != null) {
                this.dWC.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.dXe + this.dWH + "/completed");
        if (this.dWG) {
            return;
        }
        if (file == null || !file.exists()) {
            k.aXl().wz(this.mVideoUrl);
        }
    }

    public boolean canRead() {
        return !this.dWD && this.dWx <= this.dWv;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.dWD) {
            return 0;
        }
        do {
            if (this.dWx == this.dWy || !this.dWE) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.dWx + ((long) i) < this.dWy ? i : this.dWy - this.dWx);
                try {
                    if (this.dWC == null) {
                        if (this.dWJ > 0) {
                            System.arraycopy(this.dWI, 0, bArr, 0, (int) this.dWJ);
                            read = (int) this.dWJ;
                            this.dWJ = 0L;
                            synchronized (this.dWK) {
                                this.dWK.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.dWC.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.dWx += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.dWD);
        return 0;
    }
}
