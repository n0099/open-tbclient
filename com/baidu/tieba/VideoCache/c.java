package com.baidu.tieba.VideoCache;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
    private String bNk;
    private long cLh;
    private long cLi;
    private long cLj;
    private long cLk;
    private long cLl;
    private FileInputStream cLp;
    private String cLu;
    private long cLw;
    private Context mContext;
    private long cLm = 0;
    private long cLn = -1;
    private boolean cLo = false;
    private boolean cLq = false;
    private String bNm = "";
    private Object mLock = new Object();
    private boolean cLr = false;
    private long cLs = -1;
    boolean cLt = false;
    private Object cLx = new Object();
    private long bWP = 0;
    private Runnable cLy = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.as(c.TAG, "test run in " + c.this);
            while (e.avI().y(c.this)) {
                e.avI().qr(c.this.bNk);
                try {
                    j.as(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.as(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.cLq) {
                    break;
                }
            }
            if (!c.this.cLq) {
                e.avI().w(c.this);
            }
            while (true) {
                if (c.this.cLq) {
                    break;
                }
                j.as(c.TAG, "download in " + c.this);
                if (c.this.avE()) {
                    break;
                }
                c.this.cLs = -1L;
                File file2 = new File(c.this.bNm);
                long j6 = c.this.cLj;
                long j7 = c.this.cLi;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.cLq) {
                            break;
                        }
                        if (file3 != null && file3.exists()) {
                            try {
                                Long.parseLong(file3.getName());
                                if (m.o(file3) == 0) {
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
                if (c.this.cLq) {
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
                    j.as(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + " " + c.this);
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
                        } else if (c.this.cLq) {
                            j = 0;
                            j5 = j6;
                            j3 = 0;
                            file = null;
                            break;
                        } else {
                            File file4 = fileArr[i3];
                            try {
                                long parseInt2 = Integer.parseInt(file4.getName());
                                long o = m.o(file4);
                                j.as(c.TAG, "file size " + o);
                                long j8 = (parseInt2 + o) - 1;
                                if (c.this.cLj >= parseInt2 && c.this.cLj <= j8) {
                                    j3 = o;
                                    file = file4;
                                    j = parseInt2;
                                    j5 = parseInt2 + o;
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
                        } else if (c.this.cLq) {
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
                if (c.this.cLq) {
                    break;
                }
                j.as(c.TAG, "total range is " + c.this.cLj + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.cLi + " " + c.this);
                j.as(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file != null) {
                    String absolutePath = file.getAbsolutePath();
                    long length = file.length();
                    if (length >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                        j4 = j2;
                        z = true;
                    } else if ((j2 - j6) + 1 + length > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                        j4 = ((PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - length) + j6) - 1;
                        z = false;
                    } else {
                        j4 = j2;
                        z = false;
                    }
                    z2 = z;
                    str2 = absolutePath;
                } else {
                    String str3 = c.this.bNm + "/" + c.this.cLj;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new am("c12027").bJ("errormsg", "创建缓存文件出现异常").bJ("name", str3).bJ("error", e5.getMessage()).bJ("url", c.this.bNk));
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
                }
                if (str2 != null) {
                    try {
                        c.this.cLp = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.cLp = null;
                }
                if (file != null) {
                    try {
                        if (c.this.cLp != null) {
                            c.this.cLp.skip(c.this.cLj - j);
                        }
                        j.as(c.TAG, "skip: " + (c.this.cLj - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.as(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.cLl = j + j3;
                } else {
                    j.as(c.TAG, "hit file: null " + c.this);
                }
                j.as(c.TAG, "first mReadPosition " + c.this.cLk + " first writeposition " + c.this.cLl + " " + c.this);
                c.this.cLr = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.cLi) {
                    if (c.this.cLq) {
                        break;
                    } else {
                        j.as(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                        HttpURLConnection httpURLConnection3 = null;
                        if (j6 > j4 || z2) {
                            c.this.cLs = (j + j3) - 1;
                            httpURLConnection = null;
                        } else {
                            try {
                                j.as(c.TAG, "download start waitting ...... ");
                                while (c.this.avF()) {
                                    try {
                                        Thread.sleep(20L);
                                    } catch (InterruptedException e8) {
                                        e8.printStackTrace();
                                    }
                                    if (c.this.cLq) {
                                        break;
                                    }
                                }
                                c.this.cLn = -1L;
                                URL url = new URL(c.this.bNk);
                                j.as(c.TAG, "url opt 1 " + c.this);
                                httpURLConnection = (HttpURLConnection) url.openConnection();
                                try {
                                    try {
                                        j.as(c.TAG, "url opt 2 " + c.this);
                                        httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                        httpURLConnection.setConnectTimeout(5000);
                                        httpURLConnection.setReadTimeout(5000);
                                        j.as(c.TAG, "url opt 3 " + c.this);
                                        InputStream inputStream = httpURLConnection.getInputStream();
                                        while (inputStream == null) {
                                            j.as(c.TAG, "conn input is null " + c.this);
                                            if (c.this.cLq) {
                                                break;
                                            }
                                            try {
                                                Thread.sleep(10L);
                                            } catch (InterruptedException e9) {
                                                e9.printStackTrace();
                                            }
                                            inputStream = httpURLConnection.getInputStream();
                                        }
                                        j.as(c.TAG, "got conn input " + c.this);
                                        j.as(c.TAG, "url opt 4 " + c.this);
                                        int i5 = 0;
                                        FileOutputStream fileOutputStream = str2 != null ? new FileOutputStream(str2, true) : null;
                                        j.as(c.TAG, "read start ..." + c.this);
                                        while (true) {
                                            try {
                                                int read = inputStream.read(c.this.cLv);
                                                if (read == -1) {
                                                    break;
                                                }
                                                j.as(c.TAG, "read length " + read + " " + c.this);
                                                if (c.this.cLq) {
                                                    break;
                                                }
                                                if (str2 != null) {
                                                    fileOutputStream.write(c.this.cLv, 0, read);
                                                } else {
                                                    c.this.cLw = read;
                                                }
                                                c.this.cLl += read;
                                                i5 += read;
                                                synchronized (c.this.mLock) {
                                                    c.this.mLock.notify();
                                                }
                                                if (str2 == null) {
                                                    while (c.this.cLw != 0) {
                                                        synchronized (c.this.cLx) {
                                                            try {
                                                                c.this.cLx.wait(100L);
                                                            } catch (InterruptedException e10) {
                                                                e10.printStackTrace();
                                                            }
                                                        }
                                                        if (c.this.cLq) {
                                                            break;
                                                        }
                                                    }
                                                    if (c.this.cLq) {
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e11) {
                                                TiebaStatic.log(new am("c12027").bJ("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").bJ("error", e11.getMessage()).T("dsize", i5).bJ("url", c.this.bNk));
                                                e11.printStackTrace();
                                                c.p(c.this);
                                            }
                                        }
                                        c.this.cLm = 0L;
                                        w.w(c.this.bNk, i5, (int) c.this.bWP);
                                        j.as(c.TAG, "read end ..." + c.this);
                                        if (str2 != null) {
                                            fileOutputStream.close();
                                        }
                                        k.avR().o(inputStream);
                                        c.this.cLs = j4;
                                    } catch (Exception e12) {
                                        httpURLConnection2 = httpURLConnection;
                                        e = e12;
                                        try {
                                            TiebaStatic.log(new am("c12027").bJ("errormsg", "连接中断，文件下载出现异常").bJ("error", e.getMessage()).bJ("url", c.this.bNk));
                                            j.as(c.TAG, "download exception " + c.this);
                                            e.printStackTrace();
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable th) {
                                                }
                                            }
                                            j.as(c.TAG, "download out " + c.this);
                                            while (c.this.cLk < c.this.cLl) {
                                                try {
                                                    Thread.sleep(10L);
                                                } catch (InterruptedException e13) {
                                                    e13.printStackTrace();
                                                }
                                                if (c.this.cLq) {
                                                }
                                            }
                                            if (c.this.cLm > 0) {
                                                j.as(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.cLs);
                                                c.this.cLs = c.this.cLk - 1;
                                                j.as(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.cLs);
                                            }
                                            if (!c.this.cLq) {
                                            }
                                            e.avI().x(c.this);
                                            j.as(c.TAG, "test run out ***************************************************************" + c.this);
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
                        j.as(c.TAG, "download out " + c.this);
                        while (c.this.cLk < c.this.cLl && !c.this.cLq) {
                            Thread.sleep(10L);
                            if (c.this.cLq) {
                                break;
                            }
                        }
                        if (c.this.cLm > 0 && c.this.cLm <= 3) {
                            j.as(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.cLs);
                            c.this.cLs = c.this.cLk - 1;
                            j.as(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.cLs);
                        }
                        if (!c.this.cLq) {
                            break;
                        }
                        long j9 = c.this.cLk;
                        int i6 = 0;
                        for (int i7 = 0; i7 < fileArr.length && !c.this.cLq; i7++) {
                            int length2 = (fileArr.length - 1) - i7;
                            File file5 = fileArr[length2];
                            if (file5 != null && file5.exists()) {
                                if (!c.this.cLt) {
                                    long o2 = m.o(file5);
                                    if ((Integer.parseInt(file5.getName()) + o2) - 1 < j9 && (i6 = (int) (i6 + o2)) > 31457280) {
                                        c.this.cLt = true;
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.as(c.TAG, "release some cached slices " + c.this);
                                        }
                                    }
                                } else if (length2 != 0) {
                                    file5.delete();
                                    j.as(c.TAG, "release some cached slices " + c.this);
                                }
                            }
                        }
                        j.as(c.TAG, "mLastRequestRangeEnd " + c.this.cLs + " mReadPosition " + c.this.cLk + "  " + c.this);
                        if (c.this.cLs == -1 || c.this.cLk <= c.this.cLs || c.this.cLs >= c.this.cLi) {
                            break;
                        }
                        try {
                            if (c.this.cLp != null) {
                                c.this.cLp.close();
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                        c.this.cLr = false;
                        c.this.cLj = c.this.cLs + 1;
                        j.as(c.TAG, "continue to download... " + c.this);
                    }
                } else {
                    j.as(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.avI().x(c.this);
            j.as(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] cLv = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.cLm;
        cVar.cLm = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.bNk = str;
    }

    public void aO(long j) {
        this.bWP = j;
    }

    public void i(long j, long j2) {
        j.as(TAG, "open *************************************************************" + this);
        if (this.bNk != null) {
            this.cLh = j;
            this.cLi = j2;
            this.cLu = m.qB(this.bNk);
            if (this.cLu != null) {
                File file = new File(i.cLR + this.cLu);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.bNm = file2.getAbsolutePath();
                    this.cLl = this.cLh;
                    this.cLk = this.cLh;
                    this.cLj = this.cLh;
                    this.cLq = false;
                    this.cLr = false;
                    this.cLs = -1L;
                    this.cLt = false;
                    l.avS().k(this.cLy);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.bNk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avE() {
        if (m.qA(this.cLu) > this.bWP) {
            m.O(new File(i.cLR + this.cLu + "/segments"));
            TiebaStatic.log(new am("c12028").bJ("errormsg", "校验到缓存文件片段大小有异常").bJ("url", this.bNk));
            j.as(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void bs(long j) {
        if (j == -1) {
            j.as(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.cLo = true;
        } else if (j == 0 && this.cLo) {
            j.as(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.cLn = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avF() {
        if (!this.cLo || this.cLn != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.as(TAG, "close ***********************************************************************" + this);
        this.cLq = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.cLp != null) {
                this.cLp.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.cLR + this.cLu + "/completed");
        if (this.cLt) {
            return;
        }
        if (file == null || !file.exists()) {
            k.avR().qy(this.bNk);
        }
    }

    public boolean canRead() {
        return !this.cLq && this.cLk <= this.cLi;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.cLq) {
            return 0;
        }
        do {
            if (this.cLk == this.cLl || !this.cLr) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.cLk + ((long) i) < this.cLl ? i : this.cLl - this.cLk);
                try {
                    if (this.cLp == null) {
                        if (this.cLw > 0) {
                            System.arraycopy(this.cLv, 0, bArr, 0, (int) this.cLw);
                            read = (int) this.cLw;
                            this.cLw = 0L;
                            synchronized (this.cLx) {
                                this.cLx.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.cLp.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.cLk += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.cLq);
        return 0;
    }
}
