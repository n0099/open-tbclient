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
    private String aBn;
    private long bvN;
    private long bvO;
    private long bvP;
    private long bvQ;
    private long bvR;
    private FileInputStream bvV;
    private String bwa;
    private long bwc;
    private Context mContext;
    private long bvS = 0;
    private long bvT = -1;
    private boolean bvU = false;
    private boolean bvW = false;
    private String aBp = "";
    private Object mLock = new Object();
    private boolean bvX = false;
    private long bvY = -1;
    boolean bvZ = false;
    private Object bwd = new Object();
    private long aKn = 0;
    private Runnable bwe = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            while (e.Ud().y(c.this)) {
                e.Ud().iW(c.this.aBn);
                try {
                    j.log(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.log(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.bvW) {
                    break;
                }
            }
            if (!c.this.bvW) {
                e.Ud().w(c.this);
            }
            while (true) {
                if (c.this.bvW) {
                    break;
                }
                j.log(c.TAG, "download in " + c.this);
                if (c.this.TZ()) {
                    break;
                }
                c.this.bvY = -1L;
                File file2 = new File(c.this.aBp);
                long j6 = c.this.bvP;
                long j7 = c.this.bvO;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.bvW) {
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
                if (c.this.bvW) {
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
                        } else if (c.this.bvW) {
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
                                if (c.this.bvP >= parseInt2 && c.this.bvP <= j8) {
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
                        } else if (c.this.bvW) {
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
                if (c.this.bvW) {
                    break;
                }
                j.log(c.TAG, "total range is " + c.this.bvP + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.bvO + " " + c.this);
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
                    String str3 = c.this.aBp + "/" + c.this.bvP;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new am("c12027").ax("errormsg", "创建缓存文件出现异常").ax("name", str3).ax(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e5.getMessage()).ax("url", c.this.aBn));
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
                        c.this.bvV = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.bvV = null;
                }
                if (file != null) {
                    try {
                        if (c.this.bvV != null) {
                            c.this.bvV.skip(c.this.bvP - j);
                        }
                        j.log(c.TAG, "skip: " + (c.this.bvP - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.log(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.bvR = j + j3;
                } else {
                    j.log(c.TAG, "hit file: null " + c.this);
                }
                j.log(c.TAG, "first mReadPosition " + c.this.bvQ + " first writeposition " + c.this.bvR + " " + c.this);
                c.this.bvX = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.bvO) {
                    if (c.this.bvW) {
                        break;
                    } else {
                        j.log(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                        HttpURLConnection httpURLConnection3 = null;
                        if (j6 > j4 || z2) {
                            c.this.bvY = (j + j3) - 1;
                            httpURLConnection = null;
                        } else {
                            try {
                                j.log(c.TAG, "download start waitting ...... ");
                                while (c.this.Ua()) {
                                    try {
                                        Thread.sleep(20L);
                                    } catch (InterruptedException e8) {
                                        e8.printStackTrace();
                                    }
                                    if (c.this.bvW) {
                                        break;
                                    }
                                }
                                c.this.bvT = -1L;
                                URL url = new URL(c.this.aBn);
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
                                            if (c.this.bvW) {
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
                                                int read = inputStream.read(c.this.bwb);
                                                if (read == -1) {
                                                    break;
                                                }
                                                j.log(c.TAG, "read length " + read + " " + c.this);
                                                if (c.this.bvW) {
                                                    break;
                                                }
                                                if (str2 != null) {
                                                    fileOutputStream.write(c.this.bwb, 0, read);
                                                } else {
                                                    c.this.bwc = read;
                                                }
                                                c.this.bvR += read;
                                                i5 += read;
                                                synchronized (c.this.mLock) {
                                                    c.this.mLock.notify();
                                                }
                                                if (str2 == null) {
                                                    while (c.this.bwc != 0) {
                                                        synchronized (c.this.bwd) {
                                                            try {
                                                                c.this.bwd.wait(100L);
                                                            } catch (InterruptedException e10) {
                                                                e10.printStackTrace();
                                                            }
                                                        }
                                                        if (c.this.bvW) {
                                                            break;
                                                        }
                                                    }
                                                    if (c.this.bvW) {
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e11) {
                                                TiebaStatic.log(new am("c12027").ax("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ax(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e11.getMessage()).x("dsize", i5).ax("url", c.this.aBn));
                                                e11.printStackTrace();
                                                c.p(c.this);
                                            }
                                        }
                                        c.this.bvS = 0L;
                                        w.v(c.this.aBn, i5, (int) c.this.aKn);
                                        j.log(c.TAG, "read end ..." + c.this);
                                        if (str2 != null) {
                                            fileOutputStream.close();
                                        }
                                        k.Um().l(inputStream);
                                        c.this.bvY = j4;
                                    } catch (Exception e12) {
                                        httpURLConnection2 = httpURLConnection;
                                        e = e12;
                                        try {
                                            TiebaStatic.log(new am("c12027").ax("errormsg", "连接中断，文件下载出现异常").ax(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e.getMessage()).ax("url", c.this.aBn));
                                            j.log(c.TAG, "download exception " + c.this);
                                            e.printStackTrace();
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable th) {
                                                }
                                            }
                                            j.log(c.TAG, "download out " + c.this);
                                            while (c.this.bvQ < c.this.bvR) {
                                                try {
                                                    Thread.sleep(10L);
                                                } catch (InterruptedException e13) {
                                                    e13.printStackTrace();
                                                }
                                                if (c.this.bvW) {
                                                }
                                            }
                                            if (c.this.bvS > 0) {
                                                j.log(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bvY);
                                                c.this.bvY = c.this.bvQ - 1;
                                                j.log(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bvY);
                                            }
                                            if (!c.this.bvW) {
                                            }
                                            e.Ud().x(c.this);
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
                        while (c.this.bvQ < c.this.bvR && !c.this.bvW) {
                            Thread.sleep(10L);
                            if (c.this.bvW) {
                                break;
                            }
                        }
                        if (c.this.bvS > 0 && c.this.bvS <= 3) {
                            j.log(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bvY);
                            c.this.bvY = c.this.bvQ - 1;
                            j.log(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bvY);
                        }
                        if (!c.this.bvW) {
                            break;
                        }
                        long j9 = c.this.bvQ;
                        int i6 = 0;
                        for (int i7 = 0; i7 < fileArr.length && !c.this.bvW; i7++) {
                            int length2 = (fileArr.length - 1) - i7;
                            File file5 = fileArr[length2];
                            if (file5 != null && file5.exists()) {
                                if (!c.this.bvZ) {
                                    long n2 = m.n(file5);
                                    if ((Integer.parseInt(file5.getName()) + n2) - 1 < j9 && (i6 = (int) (i6 + n2)) > 31457280) {
                                        c.this.bvZ = true;
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
                        j.log(c.TAG, "mLastRequestRangeEnd " + c.this.bvY + " mReadPosition " + c.this.bvQ + "  " + c.this);
                        if (c.this.bvY == -1 || c.this.bvQ <= c.this.bvY || c.this.bvY >= c.this.bvO) {
                            break;
                        }
                        try {
                            if (c.this.bvV != null) {
                                c.this.bvV.close();
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                        c.this.bvX = false;
                        c.this.bvP = c.this.bvY + 1;
                        j.log(c.TAG, "continue to download... " + c.this);
                    }
                } else {
                    j.log(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.Ud().x(c.this);
            j.log(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] bwb = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.bvS;
        cVar.bvS = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aBn = str;
    }

    public void ae(long j) {
        this.aKn = j;
    }

    public void d(long j, long j2) {
        j.log(TAG, "open *************************************************************" + this);
        if (this.aBn != null) {
            this.bvN = j;
            this.bvO = j2;
            this.bwa = m.jg(this.aBn);
            if (this.bwa != null) {
                File file = new File(i.bwx + this.bwa);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aBp = file2.getAbsolutePath();
                    this.bvR = this.bvN;
                    this.bvQ = this.bvN;
                    this.bvP = this.bvN;
                    this.bvW = false;
                    this.bvX = false;
                    this.bvY = -1L;
                    this.bvZ = false;
                    l.Un().e(this.bwe);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aBn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TZ() {
        if (m.jf(this.bwa) > this.aKn) {
            m.E(new File(i.bwx + this.bwa + "/segments"));
            TiebaStatic.log(new am("c12028").ax("errormsg", "校验到缓存文件片段大小有异常").ax("url", this.aBn));
            j.log(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void aI(long j) {
        if (j == -1) {
            j.log(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.bvU = true;
        } else if (j == 0 && this.bvU) {
            j.log(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.bvT = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ua() {
        if (!this.bvU || this.bvT != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.log(TAG, "close ***********************************************************************" + this);
        this.bvW = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.bvV != null) {
                this.bvV.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.bwx + this.bwa + "/completed");
        if (this.bvZ) {
            return;
        }
        if (file == null || !file.exists()) {
            k.Um().jd(this.aBn);
        }
    }

    public boolean canRead() {
        return !this.bvW && this.bvQ <= this.bvO;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.bvW) {
            return 0;
        }
        do {
            if (this.bvQ == this.bvR || !this.bvX) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.bvQ + ((long) i) < this.bvR ? i : this.bvR - this.bvQ);
                try {
                    if (this.bvV == null) {
                        if (this.bwc > 0) {
                            System.arraycopy(this.bwb, 0, bArr, 0, (int) this.bwc);
                            read = (int) this.bwc;
                            this.bwc = 0L;
                            synchronized (this.bwd) {
                                this.bwd.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.bvV.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.bvQ += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.bvW);
        return 0;
    }
}
