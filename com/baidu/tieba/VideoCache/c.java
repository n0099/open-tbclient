package com.baidu.tieba.VideoCache;

import android.content.Context;
import com.baidu.mapapi.UIMsg;
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
    private String bWb;
    private long cUQ;
    private long cUR;
    private long cUS;
    private long cUT;
    private long cUU;
    private FileInputStream cUY;
    private String cVd;
    private long cVf;
    private Context mContext;
    private long cUV = 0;
    private long cUW = -1;
    private boolean cUX = false;
    private boolean cUZ = false;
    private String bWd = "";
    private Object mLock = new Object();
    private boolean cVa = false;
    private long cVb = -1;
    boolean cVc = false;
    private Object cVg = new Object();
    private long cfU = 0;
    private Runnable cVh = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.am(c.TAG, "test run in " + c.this);
            while (e.aCc().y(c.this)) {
                e.aCc().rQ(c.this.bWb);
                try {
                    j.am(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.am(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.cUZ) {
                    break;
                }
            }
            if (!c.this.cUZ) {
                e.aCc().w(c.this);
            }
            while (true) {
                if (c.this.cUZ) {
                    break;
                }
                j.am(c.TAG, "download in " + c.this);
                if (c.this.aBY()) {
                    break;
                }
                c.this.cVb = -1L;
                File file2 = new File(c.this.bWd);
                long j6 = c.this.cUS;
                long j7 = c.this.cUR;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.cUZ) {
                            break;
                        }
                        if (file3 != null && file3.exists()) {
                            try {
                                Long.parseLong(file3.getName());
                                if (m.i(file3) == 0) {
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
                if (c.this.cUZ) {
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
                    j.am(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + " " + c.this);
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
                        } else if (c.this.cUZ) {
                            j = 0;
                            j5 = j6;
                            j3 = 0;
                            file = null;
                            break;
                        } else {
                            File file4 = fileArr[i3];
                            try {
                                long parseInt2 = Integer.parseInt(file4.getName());
                                long i4 = m.i(file4);
                                j.am(c.TAG, "file size " + i4);
                                long j8 = (parseInt2 + i4) - 1;
                                if (c.this.cUS >= parseInt2 && c.this.cUS <= j8) {
                                    j3 = i4;
                                    file = file4;
                                    j = parseInt2;
                                    j5 = parseInt2 + i4;
                                    break;
                                }
                            } catch (Exception e3) {
                            }
                            i3++;
                        }
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 >= fileArr.length) {
                            j6 = j5;
                            j2 = j7;
                            break;
                        } else if (c.this.cUZ) {
                            j6 = j5;
                            j2 = j7;
                            break;
                        } else {
                            try {
                                parseInt = Integer.parseInt(fileArr[i5].getName());
                            } catch (Exception e4) {
                            }
                            if (parseInt >= j5) {
                                j6 = j5;
                                j2 = parseInt - 1;
                                break;
                            }
                            i5++;
                        }
                    }
                } else {
                    j = 0;
                    j2 = j7;
                    j3 = 0;
                    file = null;
                }
                if (c.this.cUZ) {
                    break;
                }
                j.am(c.TAG, "total range is " + c.this.cUS + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.cUR + " " + c.this);
                j.am(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
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
                    String str3 = c.this.bWd + "/" + c.this.cUS;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new an("c12027").bT("errormsg", "创建缓存文件出现异常").bT("name", str3).bT("error", e5.getMessage()).bT("url", c.this.bWb));
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
                        c.this.cUY = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.cUY = null;
                }
                if (file != null) {
                    try {
                        if (c.this.cUY != null) {
                            c.this.cUY.skip(c.this.cUS - j);
                        }
                        j.am(c.TAG, "skip: " + (c.this.cUS - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.am(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.cUU = j + j3;
                } else {
                    j.am(c.TAG, "hit file: null " + c.this);
                }
                j.am(c.TAG, "first mReadPosition " + c.this.cUT + " first writeposition " + c.this.cUU + " " + c.this);
                c.this.cVa = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.cUR) {
                    if (c.this.cUZ) {
                        break;
                    } else {
                        j.am(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                        HttpURLConnection httpURLConnection3 = null;
                        if (j6 > j4 || z2) {
                            c.this.cVb = (j + j3) - 1;
                            httpURLConnection = null;
                        } else {
                            try {
                                j.am(c.TAG, "download start waitting ...... ");
                                while (c.this.aBZ()) {
                                    try {
                                        Thread.sleep(20L);
                                    } catch (InterruptedException e8) {
                                        e8.printStackTrace();
                                    }
                                    if (c.this.cUZ) {
                                        break;
                                    }
                                }
                                c.this.cUW = -1L;
                                URL url = new URL(c.this.bWb);
                                j.am(c.TAG, "url opt 1 " + c.this);
                                httpURLConnection = (HttpURLConnection) url.openConnection();
                                try {
                                    try {
                                        j.am(c.TAG, "url opt 2 " + c.this);
                                        httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                                        httpURLConnection.setConnectTimeout(UIMsg.m_AppUI.MSG_APP_GPS);
                                        httpURLConnection.setReadTimeout(UIMsg.m_AppUI.MSG_APP_GPS);
                                        j.am(c.TAG, "url opt 3 " + c.this);
                                        InputStream inputStream = httpURLConnection.getInputStream();
                                        while (inputStream == null) {
                                            j.am(c.TAG, "conn input is null " + c.this);
                                            if (c.this.cUZ) {
                                                break;
                                            }
                                            try {
                                                Thread.sleep(10L);
                                            } catch (InterruptedException e9) {
                                                e9.printStackTrace();
                                            }
                                            inputStream = httpURLConnection.getInputStream();
                                        }
                                        j.am(c.TAG, "got conn input " + c.this);
                                        j.am(c.TAG, "url opt 4 " + c.this);
                                        int i6 = 0;
                                        FileOutputStream fileOutputStream = str2 != null ? new FileOutputStream(str2, true) : null;
                                        j.am(c.TAG, "read start ..." + c.this);
                                        while (true) {
                                            try {
                                                int read = inputStream.read(c.this.cVe);
                                                if (read == -1) {
                                                    break;
                                                }
                                                j.am(c.TAG, "read length " + read + " " + c.this);
                                                if (c.this.cUZ) {
                                                    break;
                                                }
                                                if (str2 != null) {
                                                    fileOutputStream.write(c.this.cVe, 0, read);
                                                } else {
                                                    c.this.cVf = read;
                                                }
                                                c.this.cUU += read;
                                                i6 += read;
                                                synchronized (c.this.mLock) {
                                                    c.this.mLock.notify();
                                                }
                                                if (str2 == null) {
                                                    while (c.this.cVf != 0) {
                                                        synchronized (c.this.cVg) {
                                                            try {
                                                                c.this.cVg.wait(100L);
                                                            } catch (InterruptedException e10) {
                                                                e10.printStackTrace();
                                                            }
                                                        }
                                                        if (c.this.cUZ) {
                                                            break;
                                                        }
                                                    }
                                                    if (c.this.cUZ) {
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e11) {
                                                TiebaStatic.log(new an("c12027").bT("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").bT("error", e11.getMessage()).P("dsize", i6).bT("url", c.this.bWb));
                                                e11.printStackTrace();
                                                c.p(c.this);
                                            }
                                        }
                                        c.this.cUV = 0L;
                                        w.w(c.this.bWb, i6, (int) c.this.cfU);
                                        j.am(c.TAG, "read end ..." + c.this);
                                        if (str2 != null) {
                                            fileOutputStream.close();
                                        }
                                        k.aCl().o(inputStream);
                                        c.this.cVb = j4;
                                    } catch (Exception e12) {
                                        httpURLConnection2 = httpURLConnection;
                                        e = e12;
                                        try {
                                            TiebaStatic.log(new an("c12027").bT("errormsg", "连接中断，文件下载出现异常").bT("error", e.getMessage()).bT("url", c.this.bWb));
                                            j.am(c.TAG, "download exception " + c.this);
                                            e.printStackTrace();
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable th) {
                                                }
                                            }
                                            j.am(c.TAG, "download out " + c.this);
                                            while (c.this.cUT < c.this.cUU) {
                                                try {
                                                    Thread.sleep(10L);
                                                } catch (InterruptedException e13) {
                                                    e13.printStackTrace();
                                                }
                                                if (c.this.cUZ) {
                                                }
                                            }
                                            if (c.this.cUV > 0) {
                                                j.am(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.cVb);
                                                c.this.cVb = c.this.cUT - 1;
                                                j.am(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.cVb);
                                            }
                                            if (!c.this.cUZ) {
                                            }
                                            e.aCc().x(c.this);
                                            j.am(c.TAG, "test run out ***************************************************************" + c.this);
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
                        j.am(c.TAG, "download out " + c.this);
                        while (c.this.cUT < c.this.cUU && !c.this.cUZ) {
                            Thread.sleep(10L);
                            if (c.this.cUZ) {
                                break;
                            }
                        }
                        if (c.this.cUV > 0 && c.this.cUV <= 3) {
                            j.am(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.cVb);
                            c.this.cVb = c.this.cUT - 1;
                            j.am(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.cVb);
                        }
                        if (!c.this.cUZ) {
                            break;
                        }
                        long j9 = c.this.cUT;
                        int i7 = 0;
                        for (int i8 = 0; i8 < fileArr.length && !c.this.cUZ; i8++) {
                            int length2 = (fileArr.length - 1) - i8;
                            File file5 = fileArr[length2];
                            if (file5 != null && file5.exists()) {
                                if (!c.this.cVc) {
                                    long i9 = m.i(file5);
                                    if ((Integer.parseInt(file5.getName()) + i9) - 1 < j9 && (i7 = (int) (i7 + i9)) > 31457280) {
                                        c.this.cVc = true;
                                        if (length2 != 0) {
                                            file5.delete();
                                            j.am(c.TAG, "release some cached slices " + c.this);
                                        }
                                    }
                                } else if (length2 != 0) {
                                    file5.delete();
                                    j.am(c.TAG, "release some cached slices " + c.this);
                                }
                            }
                        }
                        j.am(c.TAG, "mLastRequestRangeEnd " + c.this.cVb + " mReadPosition " + c.this.cUT + "  " + c.this);
                        if (c.this.cVb == -1 || c.this.cUT <= c.this.cVb || c.this.cVb >= c.this.cUR) {
                            break;
                        }
                        try {
                            if (c.this.cUY != null) {
                                c.this.cUY.close();
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                        c.this.cVa = false;
                        c.this.cUS = c.this.cVb + 1;
                        j.am(c.TAG, "continue to download... " + c.this);
                    }
                } else {
                    j.am(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.aCc().x(c.this);
            j.am(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] cVe = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.cUV;
        cVar.cUV = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.bWb = str;
    }

    public void be(long j) {
        this.cfU = j;
    }

    public void i(long j, long j2) {
        j.am(TAG, "open *************************************************************" + this);
        if (this.bWb != null) {
            this.cUQ = j;
            this.cUR = j2;
            this.cVd = m.sa(this.bWb);
            if (this.cVd != null) {
                File file = new File(i.cVA + this.cVd);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.bWd = file2.getAbsolutePath();
                    this.cUU = this.cUQ;
                    this.cUT = this.cUQ;
                    this.cUS = this.cUQ;
                    this.cUZ = false;
                    this.cVa = false;
                    this.cVb = -1L;
                    this.cVc = false;
                    l.aCm().m(this.cVh);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.bWb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBY() {
        if (m.rZ(this.cVd) > this.cfU) {
            m.I(new File(i.cVA + this.cVd + "/segments"));
            TiebaStatic.log(new an("c12028").bT("errormsg", "校验到缓存文件片段大小有异常").bT("url", this.bWb));
            j.am(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void bI(long j) {
        if (j == -1) {
            j.am(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.cUX = true;
        } else if (j == 0 && this.cUX) {
            j.am(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.cUW = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBZ() {
        if (!this.cUX || this.cUW != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.am(TAG, "close ***********************************************************************" + this);
        this.cUZ = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.cUY != null) {
                this.cUY.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.cVA + this.cVd + "/completed");
        if (this.cVc) {
            return;
        }
        if (file == null || !file.exists()) {
            k.aCl().rX(this.bWb);
        }
    }

    public boolean canRead() {
        return !this.cUZ && this.cUT <= this.cUR;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.cUZ) {
            return 0;
        }
        do {
            if (this.cUT == this.cUU || !this.cVa) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.cUT + ((long) i) < this.cUU ? i : this.cUU - this.cUT);
                try {
                    if (this.cUY == null) {
                        if (this.cVf > 0) {
                            System.arraycopy(this.cVe, 0, bArr, 0, (int) this.cVf);
                            read = (int) this.cVf;
                            this.cVf = 0L;
                            synchronized (this.cVg) {
                                this.cVg.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.cUY.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.cUT += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.cUZ);
        return 0;
    }
}
