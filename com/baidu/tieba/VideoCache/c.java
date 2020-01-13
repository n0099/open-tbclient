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
/* loaded from: classes7.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private String dSC;
    private long dSE;
    private long dSp;
    private long dSq;
    private long dSr;
    private long dSs;
    private long dSt;
    private FileInputStream dSx;
    private Context mContext;
    private String mVideoUrl;
    private long dSu = 0;
    private long dSv = -1;
    private boolean dSw = false;
    private boolean dSy = false;
    private String cYV = "";
    private Object mLock = new Object();
    private boolean dSz = false;
    private long dSA = -1;
    boolean dSB = false;
    private Object dSF = new Object();
    private long mTotalLength = 0;
    private Runnable dSG = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.aK(c.TAG, "test run in " + c.this);
            while (e.aUN().y(c.this)) {
                e.aUN().vY(c.this.mVideoUrl);
                try {
                    j.aK(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.aK(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.dSy) {
                    break;
                }
            }
            if (!c.this.dSy) {
                e.aUN().w(c.this);
            }
            while (true) {
                if (c.this.dSy) {
                    break;
                }
                j.aK(c.TAG, "download in " + c.this);
                if (c.this.aUK()) {
                    break;
                }
                c.this.dSA = -1L;
                File file2 = new File(c.this.cYV);
                long j6 = c.this.dSr;
                long j7 = c.this.dSq;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.dSy) {
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
                if (c.this.dSy) {
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
                    j.aK(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + HanziToPinyin.Token.SEPARATOR + c.this);
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
                        } else if (c.this.dSy) {
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
                                j.aK(c.TAG, "file size " + fileSize);
                                long j8 = (parseInt2 + fileSize) - 1;
                                if (c.this.dSr >= parseInt2 && c.this.dSr <= j8) {
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
                        } else if (c.this.dSy) {
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
                if (c.this.dSy) {
                    break;
                }
                j.aK(c.TAG, "total range is " + c.this.dSr + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.dSq + HanziToPinyin.Token.SEPARATOR + c.this);
                j.aK(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + HanziToPinyin.Token.SEPARATOR + c.this);
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
                    String str3 = c.this.cYV + "/" + c.this.dSr;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new an("c12027").cp("errormsg", "创建缓存文件出现异常").cp("name", str3).cp(BdStatsConstant.StatsType.ERROR, e5.getMessage()).cp("url", c.this.mVideoUrl));
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
                        c.this.dSx = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.dSx = null;
                }
                if (file != null) {
                    try {
                        if (c.this.dSx != null) {
                            c.this.dSx.skip(c.this.dSr - j);
                        }
                        j.aK(c.TAG, "skip: " + (c.this.dSr - j) + HanziToPinyin.Token.SEPARATOR + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.aK(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + HanziToPinyin.Token.SEPARATOR + c.this);
                    c.this.dSt = j + j3;
                } else {
                    j.aK(c.TAG, "hit file: null " + c.this);
                }
                j.aK(c.TAG, "first mReadPosition " + c.this.dSs + " first writeposition " + c.this.dSt + HanziToPinyin.Token.SEPARATOR + c.this);
                c.this.dSz = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.dSq) {
                    if (c.this.dSy) {
                        break;
                    } else {
                        j.aK(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                        HttpURLConnection httpURLConnection3 = null;
                        if (j6 > j4 || z2) {
                            c.this.dSA = (j + j3) - 1;
                            httpURLConnection = null;
                        } else {
                            try {
                                j.aK(c.TAG, "download start waitting ...... ");
                                while (c.this.aUL()) {
                                    try {
                                        Thread.sleep(20L);
                                    } catch (InterruptedException e8) {
                                        e8.printStackTrace();
                                    }
                                    if (c.this.dSy) {
                                        break;
                                    }
                                }
                                c.this.dSv = -1L;
                                URL url = new URL(c.this.mVideoUrl);
                                j.aK(c.TAG, "url opt 1 " + c.this);
                                httpURLConnection = (HttpURLConnection) url.openConnection();
                                try {
                                    try {
                                        j.aK(c.TAG, "url opt 2 " + c.this);
                                        httpURLConnection.setRequestProperty(Headers.RANGE, "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                        httpURLConnection.setConnectTimeout(5000);
                                        httpURLConnection.setReadTimeout(5000);
                                        j.aK(c.TAG, "url opt 3 " + c.this);
                                        InputStream inputStream = httpURLConnection.getInputStream();
                                        while (inputStream == null) {
                                            j.aK(c.TAG, "conn input is null " + c.this);
                                            if (c.this.dSy) {
                                                break;
                                            }
                                            try {
                                                Thread.sleep(10L);
                                            } catch (InterruptedException e9) {
                                                e9.printStackTrace();
                                            }
                                            inputStream = httpURLConnection.getInputStream();
                                        }
                                        j.aK(c.TAG, "got conn input " + c.this);
                                        j.aK(c.TAG, "url opt 4 " + c.this);
                                        int i5 = 0;
                                        FileOutputStream fileOutputStream = str2 != null ? new FileOutputStream(str2, true) : null;
                                        j.aK(c.TAG, "read start ..." + c.this);
                                        while (true) {
                                            try {
                                                int read = inputStream.read(c.this.dSD);
                                                if (read == -1) {
                                                    break;
                                                }
                                                j.aK(c.TAG, "read length " + read + HanziToPinyin.Token.SEPARATOR + c.this);
                                                if (c.this.dSy) {
                                                    break;
                                                }
                                                if (str2 != null) {
                                                    fileOutputStream.write(c.this.dSD, 0, read);
                                                } else {
                                                    c.this.dSE = read;
                                                }
                                                c.this.dSt += read;
                                                i5 += read;
                                                synchronized (c.this.mLock) {
                                                    c.this.mLock.notify();
                                                }
                                                if (str2 == null) {
                                                    while (c.this.dSE != 0) {
                                                        synchronized (c.this.dSF) {
                                                            try {
                                                                c.this.dSF.wait(100L);
                                                            } catch (InterruptedException e10) {
                                                                e10.printStackTrace();
                                                            }
                                                        }
                                                        if (c.this.dSy) {
                                                            break;
                                                        }
                                                    }
                                                    if (c.this.dSy) {
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e11) {
                                                TiebaStatic.log(new an("c12027").cp("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").cp(BdStatsConstant.StatsType.ERROR, e11.getMessage()).Z("dsize", i5).cp("url", c.this.mVideoUrl));
                                                e11.printStackTrace();
                                                c.p(c.this);
                                            }
                                        }
                                        c.this.dSu = 0L;
                                        v.x(c.this.mVideoUrl, i5, (int) c.this.mTotalLength);
                                        j.aK(c.TAG, "read end ..." + c.this);
                                        if (str2 != null) {
                                            fileOutputStream.close();
                                        }
                                        k.aUV().l(inputStream);
                                        c.this.dSA = j4;
                                    } catch (Exception e12) {
                                        httpURLConnection2 = httpURLConnection;
                                        e = e12;
                                        try {
                                            TiebaStatic.log(new an("c12027").cp("errormsg", "连接中断，文件下载出现异常").cp(BdStatsConstant.StatsType.ERROR, e.getMessage()).cp("url", c.this.mVideoUrl));
                                            j.aK(c.TAG, "download exception " + c.this);
                                            e.printStackTrace();
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable th) {
                                                }
                                            }
                                            j.aK(c.TAG, "download out " + c.this);
                                            while (c.this.dSs < c.this.dSt) {
                                                try {
                                                    Thread.sleep(10L);
                                                } catch (InterruptedException e13) {
                                                    e13.printStackTrace();
                                                }
                                                if (c.this.dSy) {
                                                }
                                            }
                                            if (c.this.dSu > 0) {
                                                j.aK(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.dSA);
                                                c.this.dSA = c.this.dSs - 1;
                                                j.aK(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.dSA);
                                            }
                                            if (!c.this.dSy) {
                                            }
                                            e.aUN().x(c.this);
                                            j.aK(c.TAG, "test run out ***************************************************************" + c.this);
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
                        j.aK(c.TAG, "download out " + c.this);
                        while (c.this.dSs < c.this.dSt && !c.this.dSy) {
                            Thread.sleep(10L);
                            if (c.this.dSy) {
                                break;
                            }
                        }
                        if (c.this.dSu > 0 && c.this.dSu <= 3) {
                            j.aK(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.dSA);
                            c.this.dSA = c.this.dSs - 1;
                            j.aK(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.dSA);
                        }
                        if (!c.this.dSy) {
                            break;
                        }
                        long j9 = c.this.dSs;
                        int i6 = 0;
                        for (int i7 = 0; i7 < fileArr.length && !c.this.dSy; i7++) {
                            int length2 = (fileArr.length - 1) - i7;
                            File file5 = fileArr[length2];
                            if (file5 != null && file5.exists()) {
                                if (!c.this.dSB) {
                                    long fileSize2 = m.getFileSize(file5);
                                    if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j9 && (i6 = (int) (i6 + fileSize2)) > 31457280) {
                                        c.this.dSB = true;
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.aK(c.TAG, "release some cached slices " + c.this);
                                        }
                                    }
                                } else if (length2 != 0) {
                                    file5.delete();
                                    j.aK(c.TAG, "release some cached slices " + c.this);
                                }
                            }
                        }
                        j.aK(c.TAG, "mLastRequestRangeEnd " + c.this.dSA + " mReadPosition " + c.this.dSs + HanziToPinyin.Token.SEPARATOR + HanziToPinyin.Token.SEPARATOR + c.this);
                        if (c.this.dSA == -1 || c.this.dSs <= c.this.dSA || c.this.dSA >= c.this.dSq) {
                            break;
                        }
                        try {
                            if (c.this.dSx != null) {
                                c.this.dSx.close();
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                        c.this.dSz = false;
                        c.this.dSr = c.this.dSA + 1;
                        j.aK(c.TAG, "continue to download... " + c.this);
                    }
                } else {
                    j.aK(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.aUN().x(c.this);
            j.aK(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] dSD = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.dSu;
        cVar.dSu = 1 + j;
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
        j.aK(TAG, "open *************************************************************" + this);
        if (this.mVideoUrl != null) {
            this.dSp = j;
            this.dSq = j2;
            this.dSC = m.wi(this.mVideoUrl);
            if (this.dSC != null) {
                File file = new File(i.dSZ + this.dSC);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.cYV = file2.getAbsolutePath();
                    this.dSt = this.dSp;
                    this.dSs = this.dSp;
                    this.dSr = this.dSp;
                    this.dSy = false;
                    this.dSz = false;
                    this.dSA = -1L;
                    this.dSB = false;
                    l.aUW().n(this.dSG);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aUK() {
        if (m.wh(this.dSC) > this.mTotalLength) {
            m.H(new File(i.dSZ + this.dSC + "/segments"));
            TiebaStatic.log(new an("c12028").cp("errormsg", "校验到缓存文件片段大小有异常").cp("url", this.mVideoUrl));
            j.aK(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void cg(long j) {
        if (j == -1) {
            j.aK(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.dSw = true;
        } else if (j == 0 && this.dSw) {
            j.aK(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.dSv = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aUL() {
        if (!this.dSw || this.dSv != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.aK(TAG, "close ***********************************************************************" + this);
        this.dSy = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.dSx != null) {
                this.dSx.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.dSZ + this.dSC + "/completed");
        if (this.dSB) {
            return;
        }
        if (file == null || !file.exists()) {
            k.aUV().wf(this.mVideoUrl);
        }
    }

    public boolean canRead() {
        return !this.dSy && this.dSs <= this.dSq;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.dSy) {
            return 0;
        }
        do {
            if (this.dSs == this.dSt || !this.dSz) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.dSs + ((long) i) < this.dSt ? i : this.dSt - this.dSs);
                try {
                    if (this.dSx == null) {
                        if (this.dSE > 0) {
                            System.arraycopy(this.dSD, 0, bArr, 0, (int) this.dSE);
                            read = (int) this.dSE;
                            this.dSE = 0L;
                            synchronized (this.dSF) {
                                this.dSF.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.dSx.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.dSs += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.dSy);
        return 0;
    }
}
