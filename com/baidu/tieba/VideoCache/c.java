package com.baidu.tieba.VideoCache;

import android.content.Context;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.play.w;
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
/* loaded from: classes4.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private String cmf;
    private long dfA;
    private long dfl;
    private long dfm;
    private long dfn;
    private long dfo;
    private long dfp;
    private FileInputStream dft;
    private String dfy;
    private Context mContext;
    private long dfq = 0;
    private long dfr = -1;
    private boolean dfs = false;
    private boolean dfu = false;
    private String cmh = "";
    private Object mLock = new Object();
    private boolean dfv = false;
    private long dfw = -1;
    boolean dfx = false;
    private Object dfB = new Object();
    private long mTotalLength = 0;
    private Runnable dfC = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.au(c.TAG, "test run in " + c.this);
            while (e.aCB().y(c.this)) {
                e.aCB().qL(c.this.cmf);
                try {
                    j.au(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.au(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.dfu) {
                    break;
                }
            }
            if (!c.this.dfu) {
                e.aCB().w(c.this);
            }
            while (true) {
                if (c.this.dfu) {
                    break;
                }
                j.au(c.TAG, "download in " + c.this);
                if (c.this.aCx()) {
                    break;
                }
                c.this.dfw = -1L;
                File file2 = new File(c.this.cmh);
                long j6 = c.this.dfn;
                long j7 = c.this.dfm;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.dfu) {
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
                if (c.this.dfu) {
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
                    j.au(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + HanziToPinyin.Token.SEPARATOR + c.this);
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
                        } else if (c.this.dfu) {
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
                                j.au(c.TAG, "file size " + fileSize);
                                long j8 = (parseInt2 + fileSize) - 1;
                                if (c.this.dfn >= parseInt2 && c.this.dfn <= j8) {
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
                        } else if (c.this.dfu) {
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
                if (c.this.dfu) {
                    break;
                }
                j.au(c.TAG, "total range is " + c.this.dfn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.dfm + HanziToPinyin.Token.SEPARATOR + c.this);
                j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + HanziToPinyin.Token.SEPARATOR + c.this);
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
                    String str3 = c.this.cmh + "/" + c.this.dfn;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new an("c12027").bS("errormsg", "创建缓存文件出现异常").bS("name", str3).bS(BdStatsConstant.StatsType.ERROR, e5.getMessage()).bS("url", c.this.cmf));
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
                        c.this.dft = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.dft = null;
                }
                if (file != null) {
                    try {
                        if (c.this.dft != null) {
                            c.this.dft.skip(c.this.dfn - j);
                        }
                        j.au(c.TAG, "skip: " + (c.this.dfn - j) + HanziToPinyin.Token.SEPARATOR + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.au(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + HanziToPinyin.Token.SEPARATOR + c.this);
                    c.this.dfp = j + j3;
                } else {
                    j.au(c.TAG, "hit file: null " + c.this);
                }
                j.au(c.TAG, "first mReadPosition " + c.this.dfo + " first writeposition " + c.this.dfp + HanziToPinyin.Token.SEPARATOR + c.this);
                c.this.dfv = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.dfm) {
                    if (c.this.dfu) {
                        break;
                    } else {
                        j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                        HttpURLConnection httpURLConnection3 = null;
                        if (j6 > j4 || z2) {
                            c.this.dfw = (j + j3) - 1;
                            httpURLConnection = null;
                        } else {
                            try {
                                j.au(c.TAG, "download start waitting ...... ");
                                while (c.this.aCy()) {
                                    try {
                                        Thread.sleep(20L);
                                    } catch (InterruptedException e8) {
                                        e8.printStackTrace();
                                    }
                                    if (c.this.dfu) {
                                        break;
                                    }
                                }
                                c.this.dfr = -1L;
                                URL url = new URL(c.this.cmf);
                                j.au(c.TAG, "url opt 1 " + c.this);
                                httpURLConnection = (HttpURLConnection) url.openConnection();
                                try {
                                    try {
                                        j.au(c.TAG, "url opt 2 " + c.this);
                                        httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                        httpURLConnection.setConnectTimeout(5000);
                                        httpURLConnection.setReadTimeout(5000);
                                        j.au(c.TAG, "url opt 3 " + c.this);
                                        InputStream inputStream = httpURLConnection.getInputStream();
                                        while (inputStream == null) {
                                            j.au(c.TAG, "conn input is null " + c.this);
                                            if (c.this.dfu) {
                                                break;
                                            }
                                            try {
                                                Thread.sleep(10L);
                                            } catch (InterruptedException e9) {
                                                e9.printStackTrace();
                                            }
                                            inputStream = httpURLConnection.getInputStream();
                                        }
                                        j.au(c.TAG, "got conn input " + c.this);
                                        j.au(c.TAG, "url opt 4 " + c.this);
                                        int i5 = 0;
                                        FileOutputStream fileOutputStream = str2 != null ? new FileOutputStream(str2, true) : null;
                                        j.au(c.TAG, "read start ..." + c.this);
                                        while (true) {
                                            try {
                                                int read = inputStream.read(c.this.dfz);
                                                if (read == -1) {
                                                    break;
                                                }
                                                j.au(c.TAG, "read length " + read + HanziToPinyin.Token.SEPARATOR + c.this);
                                                if (c.this.dfu) {
                                                    break;
                                                }
                                                if (str2 != null) {
                                                    fileOutputStream.write(c.this.dfz, 0, read);
                                                } else {
                                                    c.this.dfA = read;
                                                }
                                                c.this.dfp += read;
                                                i5 += read;
                                                synchronized (c.this.mLock) {
                                                    c.this.mLock.notify();
                                                }
                                                if (str2 == null) {
                                                    while (c.this.dfA != 0) {
                                                        synchronized (c.this.dfB) {
                                                            try {
                                                                c.this.dfB.wait(100L);
                                                            } catch (InterruptedException e10) {
                                                                e10.printStackTrace();
                                                            }
                                                        }
                                                        if (c.this.dfu) {
                                                            break;
                                                        }
                                                    }
                                                    if (c.this.dfu) {
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e11) {
                                                TiebaStatic.log(new an("c12027").bS("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").bS(BdStatsConstant.StatsType.ERROR, e11.getMessage()).O("dsize", i5).bS("url", c.this.cmf));
                                                e11.printStackTrace();
                                                c.p(c.this);
                                            }
                                        }
                                        c.this.dfq = 0L;
                                        w.v(c.this.cmf, i5, (int) c.this.mTotalLength);
                                        j.au(c.TAG, "read end ..." + c.this);
                                        if (str2 != null) {
                                            fileOutputStream.close();
                                        }
                                        k.aCK().l(inputStream);
                                        c.this.dfw = j4;
                                    } catch (Exception e12) {
                                        httpURLConnection2 = httpURLConnection;
                                        e = e12;
                                        try {
                                            TiebaStatic.log(new an("c12027").bS("errormsg", "连接中断，文件下载出现异常").bS(BdStatsConstant.StatsType.ERROR, e.getMessage()).bS("url", c.this.cmf));
                                            j.au(c.TAG, "download exception " + c.this);
                                            e.printStackTrace();
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable th) {
                                                }
                                            }
                                            j.au(c.TAG, "download out " + c.this);
                                            while (c.this.dfo < c.this.dfp) {
                                                try {
                                                    Thread.sleep(10L);
                                                } catch (InterruptedException e13) {
                                                    e13.printStackTrace();
                                                }
                                                if (c.this.dfu) {
                                                }
                                            }
                                            if (c.this.dfq > 0) {
                                                j.au(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.dfw);
                                                c.this.dfw = c.this.dfo - 1;
                                                j.au(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.dfw);
                                            }
                                            if (!c.this.dfu) {
                                            }
                                            e.aCB().x(c.this);
                                            j.au(c.TAG, "test run out ***************************************************************" + c.this);
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
                        j.au(c.TAG, "download out " + c.this);
                        while (c.this.dfo < c.this.dfp && !c.this.dfu) {
                            Thread.sleep(10L);
                            if (c.this.dfu) {
                                break;
                            }
                        }
                        if (c.this.dfq > 0 && c.this.dfq <= 3) {
                            j.au(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.dfw);
                            c.this.dfw = c.this.dfo - 1;
                            j.au(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.dfw);
                        }
                        if (!c.this.dfu) {
                            break;
                        }
                        long j9 = c.this.dfo;
                        int i6 = 0;
                        for (int i7 = 0; i7 < fileArr.length && !c.this.dfu; i7++) {
                            int length2 = (fileArr.length - 1) - i7;
                            File file5 = fileArr[length2];
                            if (file5 != null && file5.exists()) {
                                if (!c.this.dfx) {
                                    long fileSize2 = m.getFileSize(file5);
                                    if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j9 && (i6 = (int) (i6 + fileSize2)) > 31457280) {
                                        c.this.dfx = true;
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.au(c.TAG, "release some cached slices " + c.this);
                                        }
                                    }
                                } else if (length2 != 0) {
                                    file5.delete();
                                    j.au(c.TAG, "release some cached slices " + c.this);
                                }
                            }
                        }
                        j.au(c.TAG, "mLastRequestRangeEnd " + c.this.dfw + " mReadPosition " + c.this.dfo + HanziToPinyin.Token.SEPARATOR + HanziToPinyin.Token.SEPARATOR + c.this);
                        if (c.this.dfw == -1 || c.this.dfo <= c.this.dfw || c.this.dfw >= c.this.dfm) {
                            break;
                        }
                        try {
                            if (c.this.dft != null) {
                                c.this.dft.close();
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                        c.this.dfv = false;
                        c.this.dfn = c.this.dfw + 1;
                        j.au(c.TAG, "continue to download... " + c.this);
                    }
                } else {
                    j.au(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.aCB().x(c.this);
            j.au(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] dfz = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.dfq;
        cVar.dfq = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.cmf = str;
    }

    public void setTotalLength(long j) {
        this.mTotalLength = j;
    }

    public void o(long j, long j2) {
        j.au(TAG, "open *************************************************************" + this);
        if (this.cmf != null) {
            this.dfl = j;
            this.dfm = j2;
            this.dfy = m.qV(this.cmf);
            if (this.dfy != null) {
                File file = new File(i.dfV + this.dfy);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.cmh = file2.getAbsolutePath();
                    this.dfp = this.dfl;
                    this.dfo = this.dfl;
                    this.dfn = this.dfl;
                    this.dfu = false;
                    this.dfv = false;
                    this.dfw = -1L;
                    this.dfx = false;
                    l.aCL().k(this.dfC);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.cmf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCx() {
        if (m.qU(this.dfy) > this.mTotalLength) {
            m.u(new File(i.dfV + this.dfy + "/segments"));
            TiebaStatic.log(new an("c12028").bS("errormsg", "校验到缓存文件片段大小有异常").bS("url", this.cmf));
            j.au(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void bA(long j) {
        if (j == -1) {
            j.au(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.dfs = true;
        } else if (j == 0 && this.dfs) {
            j.au(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.dfr = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCy() {
        if (!this.dfs || this.dfr != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.au(TAG, "close ***********************************************************************" + this);
        this.dfu = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.dft != null) {
                this.dft.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.dfV + this.dfy + "/completed");
        if (this.dfx) {
            return;
        }
        if (file == null || !file.exists()) {
            k.aCK().qS(this.cmf);
        }
    }

    public boolean canRead() {
        return !this.dfu && this.dfo <= this.dfm;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.dfu) {
            return 0;
        }
        do {
            if (this.dfo == this.dfp || !this.dfv) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.dfo + ((long) i) < this.dfp ? i : this.dfp - this.dfo);
                try {
                    if (this.dft == null) {
                        if (this.dfA > 0) {
                            System.arraycopy(this.dfz, 0, bArr, 0, (int) this.dfA);
                            read = (int) this.dfA;
                            this.dfA = 0L;
                            synchronized (this.dfB) {
                                this.dfB.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.dft.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.dfo += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.dfu);
        return 0;
    }
}
