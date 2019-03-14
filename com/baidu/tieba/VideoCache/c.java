package com.baidu.tieba.VideoCache;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.mapapi.UIMsg;
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
    private String bNl;
    private long cLe;
    private long cLf;
    private long cLg;
    private long cLh;
    private long cLi;
    private FileInputStream cLm;
    private String cLr;
    private long cLt;
    private Context mContext;
    private long cLj = 0;
    private long cLk = -1;
    private boolean cLl = false;
    private boolean cLn = false;
    private String bNn = "";
    private Object mLock = new Object();
    private boolean cLo = false;
    private long cLp = -1;
    boolean cLq = false;
    private Object cLu = new Object();
    private long bWQ = 0;
    private Runnable cLv = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            while (e.avH().y(c.this)) {
                e.avH().qp(c.this.bNl);
                try {
                    j.as(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.as(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.cLn) {
                    break;
                }
            }
            if (!c.this.cLn) {
                e.avH().w(c.this);
            }
            while (true) {
                if (c.this.cLn) {
                    break;
                }
                j.as(c.TAG, "download in " + c.this);
                if (c.this.avD()) {
                    break;
                }
                c.this.cLp = -1L;
                File file2 = new File(c.this.bNn);
                long j6 = c.this.cLg;
                long j7 = c.this.cLf;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.cLn) {
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
                if (c.this.cLn) {
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
                        } else if (c.this.cLn) {
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
                                if (c.this.cLg >= parseInt2 && c.this.cLg <= j8) {
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
                        } else if (c.this.cLn) {
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
                if (c.this.cLn) {
                    break;
                }
                j.as(c.TAG, "total range is " + c.this.cLg + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.cLf + " " + c.this);
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
                    String str3 = c.this.bNn + "/" + c.this.cLg;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new am("c12027").bJ("errormsg", "创建缓存文件出现异常").bJ("name", str3).bJ("error", e5.getMessage()).bJ("url", c.this.bNl));
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
                        c.this.cLm = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.cLm = null;
                }
                if (file != null) {
                    try {
                        if (c.this.cLm != null) {
                            c.this.cLm.skip(c.this.cLg - j);
                        }
                        j.as(c.TAG, "skip: " + (c.this.cLg - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.as(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.cLi = j + j3;
                } else {
                    j.as(c.TAG, "hit file: null " + c.this);
                }
                j.as(c.TAG, "first mReadPosition " + c.this.cLh + " first writeposition " + c.this.cLi + " " + c.this);
                c.this.cLo = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.cLf) {
                    if (c.this.cLn) {
                        break;
                    } else {
                        j.as(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                        HttpURLConnection httpURLConnection3 = null;
                        if (j6 > j4 || z2) {
                            c.this.cLp = (j + j3) - 1;
                            httpURLConnection = null;
                        } else {
                            try {
                                j.as(c.TAG, "download start waitting ...... ");
                                while (c.this.avE()) {
                                    try {
                                        Thread.sleep(20L);
                                    } catch (InterruptedException e8) {
                                        e8.printStackTrace();
                                    }
                                    if (c.this.cLn) {
                                        break;
                                    }
                                }
                                c.this.cLk = -1L;
                                URL url = new URL(c.this.bNl);
                                j.as(c.TAG, "url opt 1 " + c.this);
                                httpURLConnection = (HttpURLConnection) url.openConnection();
                                try {
                                    try {
                                        j.as(c.TAG, "url opt 2 " + c.this);
                                        httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                        httpURLConnection.setConnectTimeout(UIMsg.m_AppUI.MSG_APP_GPS);
                                        httpURLConnection.setReadTimeout(UIMsg.m_AppUI.MSG_APP_GPS);
                                        j.as(c.TAG, "url opt 3 " + c.this);
                                        InputStream inputStream = httpURLConnection.getInputStream();
                                        while (inputStream == null) {
                                            j.as(c.TAG, "conn input is null " + c.this);
                                            if (c.this.cLn) {
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
                                                int read = inputStream.read(c.this.cLs);
                                                if (read == -1) {
                                                    break;
                                                }
                                                j.as(c.TAG, "read length " + read + " " + c.this);
                                                if (c.this.cLn) {
                                                    break;
                                                }
                                                if (str2 != null) {
                                                    fileOutputStream.write(c.this.cLs, 0, read);
                                                } else {
                                                    c.this.cLt = read;
                                                }
                                                c.this.cLi += read;
                                                i5 += read;
                                                synchronized (c.this.mLock) {
                                                    c.this.mLock.notify();
                                                }
                                                if (str2 == null) {
                                                    while (c.this.cLt != 0) {
                                                        synchronized (c.this.cLu) {
                                                            try {
                                                                c.this.cLu.wait(100L);
                                                            } catch (InterruptedException e10) {
                                                                e10.printStackTrace();
                                                            }
                                                        }
                                                        if (c.this.cLn) {
                                                            break;
                                                        }
                                                    }
                                                    if (c.this.cLn) {
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e11) {
                                                TiebaStatic.log(new am("c12027").bJ("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").bJ("error", e11.getMessage()).T("dsize", i5).bJ("url", c.this.bNl));
                                                e11.printStackTrace();
                                                c.p(c.this);
                                            }
                                        }
                                        c.this.cLj = 0L;
                                        w.w(c.this.bNl, i5, (int) c.this.bWQ);
                                        j.as(c.TAG, "read end ..." + c.this);
                                        if (str2 != null) {
                                            fileOutputStream.close();
                                        }
                                        k.avQ().o(inputStream);
                                        c.this.cLp = j4;
                                    } catch (Exception e12) {
                                        httpURLConnection2 = httpURLConnection;
                                        e = e12;
                                        try {
                                            TiebaStatic.log(new am("c12027").bJ("errormsg", "连接中断，文件下载出现异常").bJ("error", e.getMessage()).bJ("url", c.this.bNl));
                                            j.as(c.TAG, "download exception " + c.this);
                                            e.printStackTrace();
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable th) {
                                                }
                                            }
                                            j.as(c.TAG, "download out " + c.this);
                                            while (c.this.cLh < c.this.cLi) {
                                                try {
                                                    Thread.sleep(10L);
                                                } catch (InterruptedException e13) {
                                                    e13.printStackTrace();
                                                }
                                                if (c.this.cLn) {
                                                }
                                            }
                                            if (c.this.cLj > 0) {
                                                j.as(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.cLp);
                                                c.this.cLp = c.this.cLh - 1;
                                                j.as(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.cLp);
                                            }
                                            if (!c.this.cLn) {
                                            }
                                            e.avH().x(c.this);
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
                        while (c.this.cLh < c.this.cLi && !c.this.cLn) {
                            Thread.sleep(10L);
                            if (c.this.cLn) {
                                break;
                            }
                        }
                        if (c.this.cLj > 0 && c.this.cLj <= 3) {
                            j.as(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.cLp);
                            c.this.cLp = c.this.cLh - 1;
                            j.as(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.cLp);
                        }
                        if (!c.this.cLn) {
                            break;
                        }
                        long j9 = c.this.cLh;
                        int i6 = 0;
                        for (int i7 = 0; i7 < fileArr.length && !c.this.cLn; i7++) {
                            int length2 = (fileArr.length - 1) - i7;
                            File file5 = fileArr[length2];
                            if (file5 != null && file5.exists()) {
                                if (!c.this.cLq) {
                                    long o2 = m.o(file5);
                                    if ((Integer.parseInt(file5.getName()) + o2) - 1 < j9 && (i6 = (int) (i6 + o2)) > 31457280) {
                                        c.this.cLq = true;
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
                        j.as(c.TAG, "mLastRequestRangeEnd " + c.this.cLp + " mReadPosition " + c.this.cLh + "  " + c.this);
                        if (c.this.cLp == -1 || c.this.cLh <= c.this.cLp || c.this.cLp >= c.this.cLf) {
                            break;
                        }
                        try {
                            if (c.this.cLm != null) {
                                c.this.cLm.close();
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                        c.this.cLo = false;
                        c.this.cLg = c.this.cLp + 1;
                        j.as(c.TAG, "continue to download... " + c.this);
                    }
                } else {
                    j.as(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.avH().x(c.this);
            j.as(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] cLs = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.cLj;
        cVar.cLj = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.bNl = str;
    }

    public void aO(long j) {
        this.bWQ = j;
    }

    public void i(long j, long j2) {
        j.as(TAG, "open *************************************************************" + this);
        if (this.bNl != null) {
            this.cLe = j;
            this.cLf = j2;
            this.cLr = m.qz(this.bNl);
            if (this.cLr != null) {
                File file = new File(i.cLO + this.cLr);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.bNn = file2.getAbsolutePath();
                    this.cLi = this.cLe;
                    this.cLh = this.cLe;
                    this.cLg = this.cLe;
                    this.cLn = false;
                    this.cLo = false;
                    this.cLp = -1L;
                    this.cLq = false;
                    l.avR().k(this.cLv);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.bNl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avD() {
        if (m.qy(this.cLr) > this.bWQ) {
            m.O(new File(i.cLO + this.cLr + "/segments"));
            TiebaStatic.log(new am("c12028").bJ("errormsg", "校验到缓存文件片段大小有异常").bJ("url", this.bNl));
            j.as(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void bs(long j) {
        if (j == -1) {
            j.as(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.cLl = true;
        } else if (j == 0 && this.cLl) {
            j.as(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.cLk = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avE() {
        if (!this.cLl || this.cLk != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.as(TAG, "close ***********************************************************************" + this);
        this.cLn = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.cLm != null) {
                this.cLm.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.cLO + this.cLr + "/completed");
        if (this.cLq) {
            return;
        }
        if (file == null || !file.exists()) {
            k.avQ().qw(this.bNl);
        }
    }

    public boolean canRead() {
        return !this.cLn && this.cLh <= this.cLf;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.cLn) {
            return 0;
        }
        do {
            if (this.cLh == this.cLi || !this.cLo) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.cLh + ((long) i) < this.cLi ? i : this.cLi - this.cLh);
                try {
                    if (this.cLm == null) {
                        if (this.cLt > 0) {
                            System.arraycopy(this.cLs, 0, bArr, 0, (int) this.cLt);
                            read = (int) this.cLt;
                            this.cLt = 0L;
                            synchronized (this.cLu) {
                                this.cLu.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.cLm.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.cLh += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.cLn);
        return 0;
    }
}
