package com.baidu.tieba.VideoCache;

import android.content.Context;
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
    private long eLA;
    private long eLB;
    private long eLC;
    private long eLD;
    private long eLE;
    private FileInputStream eLI;
    private String eLN;
    private long eLP;
    private Context mContext;
    private String mVideoUrl;
    private long eLF = 0;
    private long eLG = -1;
    private boolean eLH = false;
    private boolean eLJ = false;
    private String dRl = "";
    private Object mLock = new Object();
    private boolean eLK = false;
    private long eLL = -1;
    boolean eLM = false;
    private Object eLQ = new Object();
    private long mTotalLength = 0;
    private Runnable eLR = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.D(c.TAG, "test run in " + c.this);
            while (e.blz().y(c.this)) {
                e.blz().zp(c.this.mVideoUrl);
                try {
                    j.D(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.D(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.eLJ) {
                    break;
                }
            }
            if (!c.this.eLJ) {
                e.blz().w(c.this);
            }
            while (true) {
                if (c.this.eLJ) {
                    break;
                }
                j.D(c.TAG, "download in " + c.this);
                if (c.this.blv()) {
                    break;
                }
                c.this.eLL = -1L;
                File file2 = new File(c.this.dRl);
                long j6 = c.this.eLC;
                long j7 = c.this.eLB;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.eLJ) {
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
                if (c.this.eLJ) {
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
                    j.D(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + " " + c.this);
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
                        } else if (c.this.eLJ) {
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
                                j.D(c.TAG, "file size " + fileSize);
                                long j8 = (parseInt2 + fileSize) - 1;
                                if (c.this.eLC >= parseInt2 && c.this.eLC <= j8) {
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
                        } else if (c.this.eLJ) {
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
                if (c.this.eLJ) {
                    break;
                }
                j.D(c.TAG, "total range is " + c.this.eLC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.eLB + " " + c.this);
                j.D(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
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
                    String str3 = c.this.dRl + "/" + c.this.eLC;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new an("c12027").dh("errormsg", "创建缓存文件出现异常").dh("name", str3).dh(BdStatsConstant.StatsType.ERROR, e5.getMessage()).dh("url", c.this.mVideoUrl));
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
                        c.this.eLI = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.eLI = null;
                }
                if (file != null) {
                    try {
                        if (c.this.eLI != null) {
                            c.this.eLI.skip(c.this.eLC - j);
                        }
                        j.D(c.TAG, "skip: " + (c.this.eLC - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.D(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.eLE = j + j3;
                } else {
                    j.D(c.TAG, "hit file: null " + c.this);
                }
                j.D(c.TAG, "first mReadPosition " + c.this.eLD + " first writeposition " + c.this.eLE + " " + c.this);
                c.this.eLK = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.eLB) {
                    if (c.this.eLJ) {
                        break;
                    } else {
                        j.D(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                        HttpURLConnection httpURLConnection3 = null;
                        if (j6 > j4 || z2) {
                            c.this.eLL = (j + j3) - 1;
                            httpURLConnection = null;
                        } else {
                            try {
                                j.D(c.TAG, "download start waitting ...... ");
                                while (c.this.blw()) {
                                    try {
                                        Thread.sleep(20L);
                                    } catch (InterruptedException e8) {
                                        e8.printStackTrace();
                                    }
                                    if (c.this.eLJ) {
                                        break;
                                    }
                                }
                                c.this.eLG = -1L;
                                URL url = new URL(c.this.mVideoUrl);
                                j.D(c.TAG, "url opt 1 " + c.this);
                                httpURLConnection = (HttpURLConnection) url.openConnection();
                                try {
                                    try {
                                        j.D(c.TAG, "url opt 2 " + c.this);
                                        httpURLConnection.setRequestProperty(Headers.RANGE, "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                        httpURLConnection.setConnectTimeout(5000);
                                        httpURLConnection.setReadTimeout(5000);
                                        j.D(c.TAG, "url opt 3 " + c.this);
                                        InputStream inputStream = httpURLConnection.getInputStream();
                                        while (inputStream == null) {
                                            j.D(c.TAG, "conn input is null " + c.this);
                                            if (c.this.eLJ) {
                                                break;
                                            }
                                            try {
                                                Thread.sleep(10L);
                                            } catch (InterruptedException e9) {
                                                e9.printStackTrace();
                                            }
                                            inputStream = httpURLConnection.getInputStream();
                                        }
                                        j.D(c.TAG, "got conn input " + c.this);
                                        j.D(c.TAG, "url opt 4 " + c.this);
                                        int i5 = 0;
                                        FileOutputStream fileOutputStream = str2 != null ? new FileOutputStream(str2, true) : null;
                                        j.D(c.TAG, "read start ..." + c.this);
                                        while (true) {
                                            try {
                                                int read = inputStream.read(c.this.eLO);
                                                if (read == -1) {
                                                    break;
                                                }
                                                j.D(c.TAG, "read length " + read + " " + c.this);
                                                if (c.this.eLJ) {
                                                    break;
                                                }
                                                if (str2 != null) {
                                                    fileOutputStream.write(c.this.eLO, 0, read);
                                                } else {
                                                    c.this.eLP = read;
                                                }
                                                c.this.eLE += read;
                                                i5 += read;
                                                synchronized (c.this.mLock) {
                                                    c.this.mLock.notify();
                                                }
                                                if (str2 == null) {
                                                    while (c.this.eLP != 0) {
                                                        synchronized (c.this.eLQ) {
                                                            try {
                                                                c.this.eLQ.wait(100L);
                                                            } catch (InterruptedException e10) {
                                                                e10.printStackTrace();
                                                            }
                                                        }
                                                        if (c.this.eLJ) {
                                                            break;
                                                        }
                                                    }
                                                    if (c.this.eLJ) {
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e11) {
                                                TiebaStatic.log(new an("c12027").dh("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").dh(BdStatsConstant.StatsType.ERROR, e11.getMessage()).ag("dsize", i5).dh("url", c.this.mVideoUrl));
                                                e11.printStackTrace();
                                                c.p(c.this);
                                            }
                                        }
                                        c.this.eLF = 0L;
                                        v.y(c.this.mVideoUrl, i5, (int) c.this.mTotalLength);
                                        j.D(c.TAG, "read end ..." + c.this);
                                        if (str2 != null) {
                                            fileOutputStream.close();
                                        }
                                        k.blH().n(inputStream);
                                        c.this.eLL = j4;
                                    } catch (Exception e12) {
                                        httpURLConnection2 = httpURLConnection;
                                        e = e12;
                                        try {
                                            TiebaStatic.log(new an("c12027").dh("errormsg", "连接中断，文件下载出现异常").dh(BdStatsConstant.StatsType.ERROR, e.getMessage()).dh("url", c.this.mVideoUrl));
                                            j.D(c.TAG, "download exception " + c.this);
                                            e.printStackTrace();
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable th) {
                                                }
                                            }
                                            j.D(c.TAG, "download out " + c.this);
                                            while (c.this.eLD < c.this.eLE) {
                                                try {
                                                    Thread.sleep(10L);
                                                } catch (InterruptedException e13) {
                                                    e13.printStackTrace();
                                                }
                                                if (c.this.eLJ) {
                                                }
                                            }
                                            if (c.this.eLF > 0) {
                                                j.D(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.eLL);
                                                c.this.eLL = c.this.eLD - 1;
                                                j.D(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.eLL);
                                            }
                                            if (!c.this.eLJ) {
                                            }
                                            e.blz().x(c.this);
                                            j.D(c.TAG, "test run out ***************************************************************" + c.this);
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
                        j.D(c.TAG, "download out " + c.this);
                        while (c.this.eLD < c.this.eLE && !c.this.eLJ) {
                            Thread.sleep(10L);
                            if (c.this.eLJ) {
                                break;
                            }
                        }
                        if (c.this.eLF > 0 && c.this.eLF <= 3) {
                            j.D(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.eLL);
                            c.this.eLL = c.this.eLD - 1;
                            j.D(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.eLL);
                        }
                        if (!c.this.eLJ) {
                            break;
                        }
                        long j9 = c.this.eLD;
                        int i6 = 0;
                        for (int i7 = 0; i7 < fileArr.length && !c.this.eLJ; i7++) {
                            int length2 = (fileArr.length - 1) - i7;
                            File file5 = fileArr[length2];
                            if (file5 != null && file5.exists()) {
                                if (!c.this.eLM) {
                                    long fileSize2 = m.getFileSize(file5);
                                    if ((Integer.parseInt(file5.getName()) + fileSize2) - 1 < j9 && (i6 = (int) (i6 + fileSize2)) > 31457280) {
                                        c.this.eLM = true;
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.D(c.TAG, "release some cached slices " + c.this);
                                        }
                                    }
                                } else if (length2 != 0) {
                                    file5.delete();
                                    j.D(c.TAG, "release some cached slices " + c.this);
                                }
                            }
                        }
                        j.D(c.TAG, "mLastRequestRangeEnd " + c.this.eLL + " mReadPosition " + c.this.eLD + "  " + c.this);
                        if (c.this.eLL == -1 || c.this.eLD <= c.this.eLL || c.this.eLL >= c.this.eLB) {
                            break;
                        }
                        try {
                            if (c.this.eLI != null) {
                                c.this.eLI.close();
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                        c.this.eLK = false;
                        c.this.eLC = c.this.eLL + 1;
                        j.D(c.TAG, "continue to download... " + c.this);
                    }
                } else {
                    j.D(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.blz().x(c.this);
            j.D(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] eLO = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.eLF;
        cVar.eLF = 1 + j;
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

    public void v(long j, long j2) {
        j.D(TAG, "open *************************************************************" + this);
        if (this.mVideoUrl != null) {
            this.eLA = j;
            this.eLB = j2;
            this.eLN = m.zz(this.mVideoUrl);
            if (this.eLN != null) {
                File file = new File(i.eMk + this.eLN);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.dRl = file2.getAbsolutePath();
                    this.eLE = this.eLA;
                    this.eLD = this.eLA;
                    this.eLC = this.eLA;
                    this.eLJ = false;
                    this.eLK = false;
                    this.eLL = -1L;
                    this.eLM = false;
                    l.blI().s(this.eLR);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blv() {
        if (m.zy(this.eLN) > this.mTotalLength) {
            m.N(new File(i.eMk + this.eLN + "/segments"));
            TiebaStatic.log(new an("c12028").dh("errormsg", "校验到缓存文件片段大小有异常").dh("url", this.mVideoUrl));
            j.D(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void cT(long j) {
        if (j == -1) {
            j.D(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.eLH = true;
        } else if (j == 0 && this.eLH) {
            j.D(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.eLG = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blw() {
        if (!this.eLH || this.eLG != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.D(TAG, "close ***********************************************************************" + this);
        this.eLJ = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.eLI != null) {
                this.eLI.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.eMk + this.eLN + "/completed");
        if (this.eLM) {
            return;
        }
        if (file == null || !file.exists()) {
            k.blH().zw(this.mVideoUrl);
        }
    }

    public boolean canRead() {
        return !this.eLJ && this.eLD <= this.eLB;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.eLJ) {
            return 0;
        }
        do {
            if (this.eLD == this.eLE || !this.eLK) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.eLD + ((long) i) < this.eLE ? i : this.eLE - this.eLD);
                try {
                    if (this.eLI == null) {
                        if (this.eLP > 0) {
                            System.arraycopy(this.eLO, 0, bArr, 0, (int) this.eLP);
                            read = (int) this.eLP;
                            this.eLP = 0L;
                            synchronized (this.eLQ) {
                                this.eLQ.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.eLI.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.eLD += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.eLJ);
        return 0;
    }
}
