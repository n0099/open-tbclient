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
    private String cln;
    private FileInputStream deC;
    private String deH;
    private long deJ;
    private long deu;
    private long dev;
    private long dew;
    private long dex;
    private long dey;
    private Context mContext;
    private long dez = 0;
    private long deA = -1;
    private boolean deB = false;
    private boolean deD = false;
    private String clp = "";
    private Object mLock = new Object();
    private boolean deE = false;
    private long deF = -1;
    boolean deG = false;
    private Object deK = new Object();
    private long mTotalLength = 0;
    private Runnable deL = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            while (e.aCz().y(c.this)) {
                e.aCz().qL(c.this.cln);
                try {
                    j.au(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.au(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.deD) {
                    break;
                }
            }
            if (!c.this.deD) {
                e.aCz().w(c.this);
            }
            while (true) {
                if (c.this.deD) {
                    break;
                }
                j.au(c.TAG, "download in " + c.this);
                if (c.this.aCv()) {
                    break;
                }
                c.this.deF = -1L;
                File file2 = new File(c.this.clp);
                long j6 = c.this.dew;
                long j7 = c.this.dev;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.deD) {
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
                if (c.this.deD) {
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
                        } else if (c.this.deD) {
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
                                if (c.this.dew >= parseInt2 && c.this.dew <= j8) {
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
                        } else if (c.this.deD) {
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
                if (c.this.deD) {
                    break;
                }
                j.au(c.TAG, "total range is " + c.this.dew + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.dev + HanziToPinyin.Token.SEPARATOR + c.this);
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
                    String str3 = c.this.clp + "/" + c.this.dew;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new an("c12027").bS("errormsg", "创建缓存文件出现异常").bS("name", str3).bS(BdStatsConstant.StatsType.ERROR, e5.getMessage()).bS("url", c.this.cln));
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
                        c.this.deC = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.deC = null;
                }
                if (file != null) {
                    try {
                        if (c.this.deC != null) {
                            c.this.deC.skip(c.this.dew - j);
                        }
                        j.au(c.TAG, "skip: " + (c.this.dew - j) + HanziToPinyin.Token.SEPARATOR + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.au(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + HanziToPinyin.Token.SEPARATOR + c.this);
                    c.this.dey = j + j3;
                } else {
                    j.au(c.TAG, "hit file: null " + c.this);
                }
                j.au(c.TAG, "first mReadPosition " + c.this.dex + " first writeposition " + c.this.dey + HanziToPinyin.Token.SEPARATOR + c.this);
                c.this.deE = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.dev) {
                    if (c.this.deD) {
                        break;
                    } else {
                        j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                        HttpURLConnection httpURLConnection3 = null;
                        if (j6 > j4 || z2) {
                            c.this.deF = (j + j3) - 1;
                            httpURLConnection = null;
                        } else {
                            try {
                                j.au(c.TAG, "download start waitting ...... ");
                                while (c.this.aCw()) {
                                    try {
                                        Thread.sleep(20L);
                                    } catch (InterruptedException e8) {
                                        e8.printStackTrace();
                                    }
                                    if (c.this.deD) {
                                        break;
                                    }
                                }
                                c.this.deA = -1L;
                                URL url = new URL(c.this.cln);
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
                                            if (c.this.deD) {
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
                                                int read = inputStream.read(c.this.deI);
                                                if (read == -1) {
                                                    break;
                                                }
                                                j.au(c.TAG, "read length " + read + HanziToPinyin.Token.SEPARATOR + c.this);
                                                if (c.this.deD) {
                                                    break;
                                                }
                                                if (str2 != null) {
                                                    fileOutputStream.write(c.this.deI, 0, read);
                                                } else {
                                                    c.this.deJ = read;
                                                }
                                                c.this.dey += read;
                                                i5 += read;
                                                synchronized (c.this.mLock) {
                                                    c.this.mLock.notify();
                                                }
                                                if (str2 == null) {
                                                    while (c.this.deJ != 0) {
                                                        synchronized (c.this.deK) {
                                                            try {
                                                                c.this.deK.wait(100L);
                                                            } catch (InterruptedException e10) {
                                                                e10.printStackTrace();
                                                            }
                                                        }
                                                        if (c.this.deD) {
                                                            break;
                                                        }
                                                    }
                                                    if (c.this.deD) {
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e11) {
                                                TiebaStatic.log(new an("c12027").bS("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").bS(BdStatsConstant.StatsType.ERROR, e11.getMessage()).O("dsize", i5).bS("url", c.this.cln));
                                                e11.printStackTrace();
                                                c.p(c.this);
                                            }
                                        }
                                        c.this.dez = 0L;
                                        w.v(c.this.cln, i5, (int) c.this.mTotalLength);
                                        j.au(c.TAG, "read end ..." + c.this);
                                        if (str2 != null) {
                                            fileOutputStream.close();
                                        }
                                        k.aCI().l(inputStream);
                                        c.this.deF = j4;
                                    } catch (Exception e12) {
                                        httpURLConnection2 = httpURLConnection;
                                        e = e12;
                                        try {
                                            TiebaStatic.log(new an("c12027").bS("errormsg", "连接中断，文件下载出现异常").bS(BdStatsConstant.StatsType.ERROR, e.getMessage()).bS("url", c.this.cln));
                                            j.au(c.TAG, "download exception " + c.this);
                                            e.printStackTrace();
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable th) {
                                                }
                                            }
                                            j.au(c.TAG, "download out " + c.this);
                                            while (c.this.dex < c.this.dey) {
                                                try {
                                                    Thread.sleep(10L);
                                                } catch (InterruptedException e13) {
                                                    e13.printStackTrace();
                                                }
                                                if (c.this.deD) {
                                                }
                                            }
                                            if (c.this.dez > 0) {
                                                j.au(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.deF);
                                                c.this.deF = c.this.dex - 1;
                                                j.au(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.deF);
                                            }
                                            if (!c.this.deD) {
                                            }
                                            e.aCz().x(c.this);
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
                        while (c.this.dex < c.this.dey && !c.this.deD) {
                            Thread.sleep(10L);
                            if (c.this.deD) {
                                break;
                            }
                        }
                        if (c.this.dez > 0 && c.this.dez <= 3) {
                            j.au(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.deF);
                            c.this.deF = c.this.dex - 1;
                            j.au(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.deF);
                        }
                        if (!c.this.deD) {
                            break;
                        }
                        long j9 = c.this.dex;
                        int i6 = 0;
                        for (int i7 = 0; i7 < fileArr.length && !c.this.deD; i7++) {
                            int length2 = (fileArr.length - 1) - i7;
                            File file5 = fileArr[length2];
                            if (file5 != null && file5.exists()) {
                                if (!c.this.deG) {
                                    long fileSize2 = m.getFileSize(file5);
                                    if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j9 && (i6 = (int) (i6 + fileSize2)) > 31457280) {
                                        c.this.deG = true;
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
                        j.au(c.TAG, "mLastRequestRangeEnd " + c.this.deF + " mReadPosition " + c.this.dex + HanziToPinyin.Token.SEPARATOR + HanziToPinyin.Token.SEPARATOR + c.this);
                        if (c.this.deF == -1 || c.this.dex <= c.this.deF || c.this.deF >= c.this.dev) {
                            break;
                        }
                        try {
                            if (c.this.deC != null) {
                                c.this.deC.close();
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                        c.this.deE = false;
                        c.this.dew = c.this.deF + 1;
                        j.au(c.TAG, "continue to download... " + c.this);
                    }
                } else {
                    j.au(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.aCz().x(c.this);
            j.au(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] deI = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.dez;
        cVar.dez = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.cln = str;
    }

    public void setTotalLength(long j) {
        this.mTotalLength = j;
    }

    public void o(long j, long j2) {
        j.au(TAG, "open *************************************************************" + this);
        if (this.cln != null) {
            this.deu = j;
            this.dev = j2;
            this.deH = m.qV(this.cln);
            if (this.deH != null) {
                File file = new File(i.dfe + this.deH);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.clp = file2.getAbsolutePath();
                    this.dey = this.deu;
                    this.dex = this.deu;
                    this.dew = this.deu;
                    this.deD = false;
                    this.deE = false;
                    this.deF = -1L;
                    this.deG = false;
                    l.aCJ().k(this.deL);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.cln;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCv() {
        if (m.qU(this.deH) > this.mTotalLength) {
            m.u(new File(i.dfe + this.deH + "/segments"));
            TiebaStatic.log(new an("c12028").bS("errormsg", "校验到缓存文件片段大小有异常").bS("url", this.cln));
            j.au(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void bz(long j) {
        if (j == -1) {
            j.au(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.deB = true;
        } else if (j == 0 && this.deB) {
            j.au(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.deA = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCw() {
        if (!this.deB || this.deA != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.au(TAG, "close ***********************************************************************" + this);
        this.deD = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.deC != null) {
                this.deC.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.dfe + this.deH + "/completed");
        if (this.deG) {
            return;
        }
        if (file == null || !file.exists()) {
            k.aCI().qS(this.cln);
        }
    }

    public boolean canRead() {
        return !this.deD && this.dex <= this.dev;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.deD) {
            return 0;
        }
        do {
            if (this.dex == this.dey || !this.deE) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.dex + ((long) i) < this.dey ? i : this.dey - this.dex);
                try {
                    if (this.deC == null) {
                        if (this.deJ > 0) {
                            System.arraycopy(this.deI, 0, bArr, 0, (int) this.deJ);
                            read = (int) this.deJ;
                            this.deJ = 0L;
                            synchronized (this.deK) {
                                this.deK.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.deC.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.dex += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.deD);
        return 0;
    }
}
