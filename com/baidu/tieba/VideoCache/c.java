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
/* loaded from: classes6.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private long dSg;
    private long dSh;
    private long dSi;
    private long dSj;
    private long dSk;
    private FileInputStream dSo;
    private String dSt;
    private long dSv;
    private Context mContext;
    private String mVideoUrl;
    private long dSl = 0;
    private long dSm = -1;
    private boolean dSn = false;
    private boolean dSp = false;
    private String cYL = "";
    private Object mLock = new Object();
    private boolean dSq = false;
    private long dSr = -1;
    boolean dSs = false;
    private Object dSw = new Object();
    private long mTotalLength = 0;
    private Runnable dSx = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.aJ(c.TAG, "test run in " + c.this);
            while (e.aUt().y(c.this)) {
                e.aUt().vU(c.this.mVideoUrl);
                try {
                    j.aJ(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.aJ(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.dSp) {
                    break;
                }
            }
            if (!c.this.dSp) {
                e.aUt().w(c.this);
            }
            while (true) {
                if (c.this.dSp) {
                    break;
                }
                j.aJ(c.TAG, "download in " + c.this);
                if (c.this.aUq()) {
                    break;
                }
                c.this.dSr = -1L;
                File file2 = new File(c.this.cYL);
                long j6 = c.this.dSi;
                long j7 = c.this.dSh;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.dSp) {
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
                if (c.this.dSp) {
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
                    j.aJ(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + HanziToPinyin.Token.SEPARATOR + c.this);
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
                        } else if (c.this.dSp) {
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
                                j.aJ(c.TAG, "file size " + fileSize);
                                long j8 = (parseInt2 + fileSize) - 1;
                                if (c.this.dSi >= parseInt2 && c.this.dSi <= j8) {
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
                        } else if (c.this.dSp) {
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
                if (c.this.dSp) {
                    break;
                }
                j.aJ(c.TAG, "total range is " + c.this.dSi + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.dSh + HanziToPinyin.Token.SEPARATOR + c.this);
                j.aJ(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + HanziToPinyin.Token.SEPARATOR + c.this);
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
                    String str3 = c.this.cYL + "/" + c.this.dSi;
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
                        c.this.dSo = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.dSo = null;
                }
                if (file != null) {
                    try {
                        if (c.this.dSo != null) {
                            c.this.dSo.skip(c.this.dSi - j);
                        }
                        j.aJ(c.TAG, "skip: " + (c.this.dSi - j) + HanziToPinyin.Token.SEPARATOR + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.aJ(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + HanziToPinyin.Token.SEPARATOR + c.this);
                    c.this.dSk = j + j3;
                } else {
                    j.aJ(c.TAG, "hit file: null " + c.this);
                }
                j.aJ(c.TAG, "first mReadPosition " + c.this.dSj + " first writeposition " + c.this.dSk + HanziToPinyin.Token.SEPARATOR + c.this);
                c.this.dSq = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.dSh) {
                    if (c.this.dSp) {
                        break;
                    } else {
                        j.aJ(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                        HttpURLConnection httpURLConnection3 = null;
                        if (j6 > j4 || z2) {
                            c.this.dSr = (j + j3) - 1;
                            httpURLConnection = null;
                        } else {
                            try {
                                j.aJ(c.TAG, "download start waitting ...... ");
                                while (c.this.aUr()) {
                                    try {
                                        Thread.sleep(20L);
                                    } catch (InterruptedException e8) {
                                        e8.printStackTrace();
                                    }
                                    if (c.this.dSp) {
                                        break;
                                    }
                                }
                                c.this.dSm = -1L;
                                URL url = new URL(c.this.mVideoUrl);
                                j.aJ(c.TAG, "url opt 1 " + c.this);
                                httpURLConnection = (HttpURLConnection) url.openConnection();
                                try {
                                    try {
                                        j.aJ(c.TAG, "url opt 2 " + c.this);
                                        httpURLConnection.setRequestProperty(Headers.RANGE, "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                        httpURLConnection.setConnectTimeout(5000);
                                        httpURLConnection.setReadTimeout(5000);
                                        j.aJ(c.TAG, "url opt 3 " + c.this);
                                        InputStream inputStream = httpURLConnection.getInputStream();
                                        while (inputStream == null) {
                                            j.aJ(c.TAG, "conn input is null " + c.this);
                                            if (c.this.dSp) {
                                                break;
                                            }
                                            try {
                                                Thread.sleep(10L);
                                            } catch (InterruptedException e9) {
                                                e9.printStackTrace();
                                            }
                                            inputStream = httpURLConnection.getInputStream();
                                        }
                                        j.aJ(c.TAG, "got conn input " + c.this);
                                        j.aJ(c.TAG, "url opt 4 " + c.this);
                                        int i5 = 0;
                                        FileOutputStream fileOutputStream = str2 != null ? new FileOutputStream(str2, true) : null;
                                        j.aJ(c.TAG, "read start ..." + c.this);
                                        while (true) {
                                            try {
                                                int read = inputStream.read(c.this.dSu);
                                                if (read == -1) {
                                                    break;
                                                }
                                                j.aJ(c.TAG, "read length " + read + HanziToPinyin.Token.SEPARATOR + c.this);
                                                if (c.this.dSp) {
                                                    break;
                                                }
                                                if (str2 != null) {
                                                    fileOutputStream.write(c.this.dSu, 0, read);
                                                } else {
                                                    c.this.dSv = read;
                                                }
                                                c.this.dSk += read;
                                                i5 += read;
                                                synchronized (c.this.mLock) {
                                                    c.this.mLock.notify();
                                                }
                                                if (str2 == null) {
                                                    while (c.this.dSv != 0) {
                                                        synchronized (c.this.dSw) {
                                                            try {
                                                                c.this.dSw.wait(100L);
                                                            } catch (InterruptedException e10) {
                                                                e10.printStackTrace();
                                                            }
                                                        }
                                                        if (c.this.dSp) {
                                                            break;
                                                        }
                                                    }
                                                    if (c.this.dSp) {
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e11) {
                                                TiebaStatic.log(new an("c12027").cp("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").cp(BdStatsConstant.StatsType.ERROR, e11.getMessage()).Z("dsize", i5).cp("url", c.this.mVideoUrl));
                                                e11.printStackTrace();
                                                c.p(c.this);
                                            }
                                        }
                                        c.this.dSl = 0L;
                                        v.x(c.this.mVideoUrl, i5, (int) c.this.mTotalLength);
                                        j.aJ(c.TAG, "read end ..." + c.this);
                                        if (str2 != null) {
                                            fileOutputStream.close();
                                        }
                                        k.aUB().l(inputStream);
                                        c.this.dSr = j4;
                                    } catch (Exception e12) {
                                        httpURLConnection2 = httpURLConnection;
                                        e = e12;
                                        try {
                                            TiebaStatic.log(new an("c12027").cp("errormsg", "连接中断，文件下载出现异常").cp(BdStatsConstant.StatsType.ERROR, e.getMessage()).cp("url", c.this.mVideoUrl));
                                            j.aJ(c.TAG, "download exception " + c.this);
                                            e.printStackTrace();
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable th) {
                                                }
                                            }
                                            j.aJ(c.TAG, "download out " + c.this);
                                            while (c.this.dSj < c.this.dSk) {
                                                try {
                                                    Thread.sleep(10L);
                                                } catch (InterruptedException e13) {
                                                    e13.printStackTrace();
                                                }
                                                if (c.this.dSp) {
                                                }
                                            }
                                            if (c.this.dSl > 0) {
                                                j.aJ(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.dSr);
                                                c.this.dSr = c.this.dSj - 1;
                                                j.aJ(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.dSr);
                                            }
                                            if (!c.this.dSp) {
                                            }
                                            e.aUt().x(c.this);
                                            j.aJ(c.TAG, "test run out ***************************************************************" + c.this);
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
                        j.aJ(c.TAG, "download out " + c.this);
                        while (c.this.dSj < c.this.dSk && !c.this.dSp) {
                            Thread.sleep(10L);
                            if (c.this.dSp) {
                                break;
                            }
                        }
                        if (c.this.dSl > 0 && c.this.dSl <= 3) {
                            j.aJ(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.dSr);
                            c.this.dSr = c.this.dSj - 1;
                            j.aJ(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.dSr);
                        }
                        if (!c.this.dSp) {
                            break;
                        }
                        long j9 = c.this.dSj;
                        int i6 = 0;
                        for (int i7 = 0; i7 < fileArr.length && !c.this.dSp; i7++) {
                            int length2 = (fileArr.length - 1) - i7;
                            File file5 = fileArr[length2];
                            if (file5 != null && file5.exists()) {
                                if (!c.this.dSs) {
                                    long fileSize2 = m.getFileSize(file5);
                                    if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j9 && (i6 = (int) (i6 + fileSize2)) > 31457280) {
                                        c.this.dSs = true;
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.aJ(c.TAG, "release some cached slices " + c.this);
                                        }
                                    }
                                } else if (length2 != 0) {
                                    file5.delete();
                                    j.aJ(c.TAG, "release some cached slices " + c.this);
                                }
                            }
                        }
                        j.aJ(c.TAG, "mLastRequestRangeEnd " + c.this.dSr + " mReadPosition " + c.this.dSj + HanziToPinyin.Token.SEPARATOR + HanziToPinyin.Token.SEPARATOR + c.this);
                        if (c.this.dSr == -1 || c.this.dSj <= c.this.dSr || c.this.dSr >= c.this.dSh) {
                            break;
                        }
                        try {
                            if (c.this.dSo != null) {
                                c.this.dSo.close();
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                        c.this.dSq = false;
                        c.this.dSi = c.this.dSr + 1;
                        j.aJ(c.TAG, "continue to download... " + c.this);
                    }
                } else {
                    j.aJ(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.aUt().x(c.this);
            j.aJ(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] dSu = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.dSl;
        cVar.dSl = 1 + j;
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
        j.aJ(TAG, "open *************************************************************" + this);
        if (this.mVideoUrl != null) {
            this.dSg = j;
            this.dSh = j2;
            this.dSt = m.we(this.mVideoUrl);
            if (this.dSt != null) {
                File file = new File(i.dSQ + this.dSt);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.cYL = file2.getAbsolutePath();
                    this.dSk = this.dSg;
                    this.dSj = this.dSg;
                    this.dSi = this.dSg;
                    this.dSp = false;
                    this.dSq = false;
                    this.dSr = -1L;
                    this.dSs = false;
                    l.aUC().n(this.dSx);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aUq() {
        if (m.wd(this.dSt) > this.mTotalLength) {
            m.H(new File(i.dSQ + this.dSt + "/segments"));
            TiebaStatic.log(new an("c12028").cp("errormsg", "校验到缓存文件片段大小有异常").cp("url", this.mVideoUrl));
            j.aJ(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void cb(long j) {
        if (j == -1) {
            j.aJ(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.dSn = true;
        } else if (j == 0 && this.dSn) {
            j.aJ(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.dSm = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aUr() {
        if (!this.dSn || this.dSm != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.aJ(TAG, "close ***********************************************************************" + this);
        this.dSp = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.dSo != null) {
                this.dSo.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.dSQ + this.dSt + "/completed");
        if (this.dSs) {
            return;
        }
        if (file == null || !file.exists()) {
            k.aUB().wb(this.mVideoUrl);
        }
    }

    public boolean canRead() {
        return !this.dSp && this.dSj <= this.dSh;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.dSp) {
            return 0;
        }
        do {
            if (this.dSj == this.dSk || !this.dSq) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.dSj + ((long) i) < this.dSk ? i : this.dSk - this.dSj);
                try {
                    if (this.dSo == null) {
                        if (this.dSv > 0) {
                            System.arraycopy(this.dSu, 0, bArr, 0, (int) this.dSv);
                            read = (int) this.dSv;
                            this.dSv = 0L;
                            synchronized (this.dSw) {
                                this.dSw.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.dSo.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.dSj += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.dSp);
        return 0;
    }
}
