package com.baidu.tieba.VideoCache;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
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
/* loaded from: classes6.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private String aFq;
    private long bAa;
    private long bAb;
    private long bAc;
    private long bAd;
    private long bAe;
    private FileInputStream bAi;
    private String bAn;
    private long bAp;
    private Context mContext;
    private long bAf = 0;
    private long bAg = -1;
    private boolean bAh = false;
    private boolean bAj = false;
    private String aFs = "";
    private Object mLock = new Object();
    private boolean bAk = false;
    private long bAl = -1;
    boolean bAm = false;
    private Object bAq = new Object();
    private long aOq = 0;
    private Runnable bAr = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.log(c.TAG, "test run in " + c.this);
            while (e.VH().y(c.this)) {
                e.VH().jF(c.this.aFq);
                try {
                    j.log(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.log(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.bAj) {
                    break;
                }
            }
            if (!c.this.bAj) {
                e.VH().w(c.this);
            }
            while (true) {
                if (c.this.bAj) {
                    break;
                }
                j.log(c.TAG, "download in " + c.this);
                if (c.this.VD()) {
                    break;
                }
                c.this.bAl = -1L;
                File file2 = new File(c.this.aFs);
                long j6 = c.this.bAc;
                long j7 = c.this.bAb;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.bAj) {
                            break;
                        }
                        if (file3 != null && file3.exists()) {
                            try {
                                Long.parseLong(file3.getName());
                                if (m.n(file3) == 0) {
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
                if (c.this.bAj) {
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
                    j.log(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + " " + c.this);
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
                        } else if (c.this.bAj) {
                            j = 0;
                            j5 = j6;
                            j3 = 0;
                            file = null;
                            break;
                        } else {
                            File file4 = fileArr[i3];
                            try {
                                long parseInt2 = Integer.parseInt(file4.getName());
                                long n = m.n(file4);
                                j.log(c.TAG, "file size " + n);
                                long j8 = (parseInt2 + n) - 1;
                                if (c.this.bAc >= parseInt2 && c.this.bAc <= j8) {
                                    j3 = n;
                                    file = file4;
                                    j = parseInt2;
                                    j5 = parseInt2 + n;
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
                        } else if (c.this.bAj) {
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
                if (c.this.bAj) {
                    break;
                }
                j.log(c.TAG, "total range is " + c.this.bAc + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.bAb + " " + c.this);
                j.log(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
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
                    String str3 = c.this.aFs + "/" + c.this.bAc;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new am("c12027").aB("errormsg", "创建缓存文件出现异常").aB("name", str3).aB(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e5.getMessage()).aB("url", c.this.aFq));
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
                        c.this.bAi = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.bAi = null;
                }
                if (file != null) {
                    try {
                        if (c.this.bAi != null) {
                            c.this.bAi.skip(c.this.bAc - j);
                        }
                        j.log(c.TAG, "skip: " + (c.this.bAc - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.log(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.bAe = j + j3;
                } else {
                    j.log(c.TAG, "hit file: null " + c.this);
                }
                j.log(c.TAG, "first mReadPosition " + c.this.bAd + " first writeposition " + c.this.bAe + " " + c.this);
                c.this.bAk = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.bAb) {
                    if (c.this.bAj) {
                        break;
                    } else {
                        j.log(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                        HttpURLConnection httpURLConnection3 = null;
                        if (j6 > j4 || z2) {
                            c.this.bAl = (j + j3) - 1;
                            httpURLConnection = null;
                        } else {
                            try {
                                j.log(c.TAG, "download start waitting ...... ");
                                while (c.this.VE()) {
                                    try {
                                        Thread.sleep(20L);
                                    } catch (InterruptedException e8) {
                                        e8.printStackTrace();
                                    }
                                    if (c.this.bAj) {
                                        break;
                                    }
                                }
                                c.this.bAg = -1L;
                                URL url = new URL(c.this.aFq);
                                j.log(c.TAG, "url opt 1 " + c.this);
                                httpURLConnection = (HttpURLConnection) url.openConnection();
                                try {
                                    try {
                                        j.log(c.TAG, "url opt 2 " + c.this);
                                        httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                        httpURLConnection.setConnectTimeout(UIMsg.m_AppUI.MSG_APP_GPS);
                                        httpURLConnection.setReadTimeout(UIMsg.m_AppUI.MSG_APP_GPS);
                                        j.log(c.TAG, "url opt 3 " + c.this);
                                        InputStream inputStream = httpURLConnection.getInputStream();
                                        while (inputStream == null) {
                                            j.log(c.TAG, "conn input is null " + c.this);
                                            if (c.this.bAj) {
                                                break;
                                            }
                                            try {
                                                Thread.sleep(10L);
                                            } catch (InterruptedException e9) {
                                                e9.printStackTrace();
                                            }
                                            inputStream = httpURLConnection.getInputStream();
                                        }
                                        j.log(c.TAG, "got conn input " + c.this);
                                        j.log(c.TAG, "url opt 4 " + c.this);
                                        int i5 = 0;
                                        FileOutputStream fileOutputStream = str2 != null ? new FileOutputStream(str2, true) : null;
                                        j.log(c.TAG, "read start ..." + c.this);
                                        while (true) {
                                            try {
                                                int read = inputStream.read(c.this.bAo);
                                                if (read == -1) {
                                                    break;
                                                }
                                                j.log(c.TAG, "read length " + read + " " + c.this);
                                                if (c.this.bAj) {
                                                    break;
                                                }
                                                if (str2 != null) {
                                                    fileOutputStream.write(c.this.bAo, 0, read);
                                                } else {
                                                    c.this.bAp = read;
                                                }
                                                c.this.bAe += read;
                                                i5 += read;
                                                synchronized (c.this.mLock) {
                                                    c.this.mLock.notify();
                                                }
                                                if (str2 == null) {
                                                    while (c.this.bAp != 0) {
                                                        synchronized (c.this.bAq) {
                                                            try {
                                                                c.this.bAq.wait(100L);
                                                            } catch (InterruptedException e10) {
                                                                e10.printStackTrace();
                                                            }
                                                        }
                                                        if (c.this.bAj) {
                                                            break;
                                                        }
                                                    }
                                                    if (c.this.bAj) {
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e11) {
                                                TiebaStatic.log(new am("c12027").aB("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").aB(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e11.getMessage()).y("dsize", i5).aB("url", c.this.aFq));
                                                e11.printStackTrace();
                                                c.p(c.this);
                                            }
                                        }
                                        c.this.bAf = 0L;
                                        w.x(c.this.aFq, i5, (int) c.this.aOq);
                                        j.log(c.TAG, "read end ..." + c.this);
                                        if (str2 != null) {
                                            fileOutputStream.close();
                                        }
                                        k.VQ().m(inputStream);
                                        c.this.bAl = j4;
                                    } catch (Exception e12) {
                                        httpURLConnection2 = httpURLConnection;
                                        e = e12;
                                        try {
                                            TiebaStatic.log(new am("c12027").aB("errormsg", "连接中断，文件下载出现异常").aB(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e.getMessage()).aB("url", c.this.aFq));
                                            j.log(c.TAG, "download exception " + c.this);
                                            e.printStackTrace();
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable th) {
                                                }
                                            }
                                            j.log(c.TAG, "download out " + c.this);
                                            while (c.this.bAd < c.this.bAe) {
                                                try {
                                                    Thread.sleep(10L);
                                                } catch (InterruptedException e13) {
                                                    e13.printStackTrace();
                                                }
                                                if (c.this.bAj) {
                                                }
                                            }
                                            if (c.this.bAf > 0) {
                                                j.log(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bAl);
                                                c.this.bAl = c.this.bAd - 1;
                                                j.log(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bAl);
                                            }
                                            if (!c.this.bAj) {
                                            }
                                            e.VH().x(c.this);
                                            j.log(c.TAG, "test run out ***************************************************************" + c.this);
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
                        j.log(c.TAG, "download out " + c.this);
                        while (c.this.bAd < c.this.bAe && !c.this.bAj) {
                            Thread.sleep(10L);
                            if (c.this.bAj) {
                                break;
                            }
                        }
                        if (c.this.bAf > 0 && c.this.bAf <= 3) {
                            j.log(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bAl);
                            c.this.bAl = c.this.bAd - 1;
                            j.log(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bAl);
                        }
                        if (!c.this.bAj) {
                            break;
                        }
                        long j9 = c.this.bAd;
                        int i6 = 0;
                        for (int i7 = 0; i7 < fileArr.length && !c.this.bAj; i7++) {
                            int length2 = (fileArr.length - 1) - i7;
                            File file5 = fileArr[length2];
                            if (file5 != null && file5.exists()) {
                                if (!c.this.bAm) {
                                    long n2 = m.n(file5);
                                    if ((Integer.parseInt(file5.getName()) + n2) - 1 < j9 && (i6 = (int) (i6 + n2)) > 31457280) {
                                        c.this.bAm = true;
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.log(c.TAG, "release some cached slices " + c.this);
                                        }
                                    }
                                } else if (length2 != 0) {
                                    file5.delete();
                                    j.log(c.TAG, "release some cached slices " + c.this);
                                }
                            }
                        }
                        j.log(c.TAG, "mLastRequestRangeEnd " + c.this.bAl + " mReadPosition " + c.this.bAd + "  " + c.this);
                        if (c.this.bAl == -1 || c.this.bAd <= c.this.bAl || c.this.bAl >= c.this.bAb) {
                            break;
                        }
                        try {
                            if (c.this.bAi != null) {
                                c.this.bAi.close();
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                        c.this.bAk = false;
                        c.this.bAc = c.this.bAl + 1;
                        j.log(c.TAG, "continue to download... " + c.this);
                    }
                } else {
                    j.log(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.VH().x(c.this);
            j.log(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] bAo = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.bAf;
        cVar.bAf = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aFq = str;
    }

    public void am(long j) {
        this.aOq = j;
    }

    public void d(long j, long j2) {
        j.log(TAG, "open *************************************************************" + this);
        if (this.aFq != null) {
            this.bAa = j;
            this.bAb = j2;
            this.bAn = m.jP(this.aFq);
            if (this.bAn != null) {
                File file = new File(i.bAK + this.bAn);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aFs = file2.getAbsolutePath();
                    this.bAe = this.bAa;
                    this.bAd = this.bAa;
                    this.bAc = this.bAa;
                    this.bAj = false;
                    this.bAk = false;
                    this.bAl = -1L;
                    this.bAm = false;
                    l.VR().f(this.bAr);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aFq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean VD() {
        if (m.jO(this.bAn) > this.aOq) {
            m.G(new File(i.bAK + this.bAn + "/segments"));
            TiebaStatic.log(new am("c12028").aB("errormsg", "校验到缓存文件片段大小有异常").aB("url", this.aFq));
            j.log(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void aQ(long j) {
        if (j == -1) {
            j.log(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.bAh = true;
        } else if (j == 0 && this.bAh) {
            j.log(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.bAg = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean VE() {
        if (!this.bAh || this.bAg != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.log(TAG, "close ***********************************************************************" + this);
        this.bAj = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.bAi != null) {
                this.bAi.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.bAK + this.bAn + "/completed");
        if (this.bAm) {
            return;
        }
        if (file == null || !file.exists()) {
            k.VQ().jM(this.aFq);
        }
    }

    public boolean canRead() {
        return !this.bAj && this.bAd <= this.bAb;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.bAj) {
            return 0;
        }
        do {
            if (this.bAd == this.bAe || !this.bAk) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.bAd + ((long) i) < this.bAe ? i : this.bAe - this.bAd);
                try {
                    if (this.bAi == null) {
                        if (this.bAp > 0) {
                            System.arraycopy(this.bAo, 0, bArr, 0, (int) this.bAp);
                            read = (int) this.bAp;
                            this.bAp = 0L;
                            synchronized (this.bAq) {
                                this.bAq.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.bAi.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.bAd += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.bAj);
        return 0;
    }
}
