package com.baidu.tieba.VideoCache;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.play.x;
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
/* loaded from: classes2.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private String bOE;
    private long bOF;
    private long bOG;
    private long bOH;
    private long bOI;
    private long bOJ;
    private FileInputStream bON;
    private String bOT;
    private long bOV;
    private Context mContext;
    private long bOK = 0;
    private long bOL = -1;
    private boolean bOM = false;
    private boolean bOO = false;
    private String bOP = "";
    private Object mLock = new Object();
    private boolean bOQ = false;
    private long bOR = -1;
    boolean bOS = false;
    private Object bOW = new Object();
    private long bfw = 0;
    private Runnable bOX = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
        @Override // java.lang.Runnable
        public void run() {
            long j;
            long j2;
            long j3;
            File file;
            String str;
            long j4;
            String str2;
            FileOutputStream fileOutputStream;
            boolean z;
            long j5;
            long parseInt;
            j.au(c.TAG, "test run in " + c.this);
            while (e.SW().y(c.this)) {
                e.SW().ht(c.this.bOE);
                try {
                    j.au(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.au(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.bOO) {
                    break;
                }
            }
            if (!c.this.bOO) {
                e.SW().w(c.this);
            }
            while (true) {
                if (c.this.bOO) {
                    break;
                }
                j.au(c.TAG, "download in " + c.this);
                if (c.this.SS()) {
                    break;
                }
                c.this.bOR = -1L;
                File file2 = new File(c.this.bOP);
                long j6 = c.this.bOH;
                long j7 = c.this.bOG;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.bOO) {
                            break;
                        }
                        if (file3 != null && file3.exists()) {
                            try {
                                Long.parseLong(file3.getName());
                                if (m.h(file3) == 0) {
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
                if (c.this.bOO) {
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
                    j.au(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + " " + c.this);
                    i = i2 + 1;
                }
                if (fileArr == null || fileArr.length <= 0) {
                    j = 0;
                    j2 = j7;
                    j3 = 0;
                    file = null;
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 < fileArr.length) {
                            if (c.this.bOO) {
                                j = 0;
                                j5 = j6;
                                j3 = 0;
                                file = null;
                                break;
                            }
                            File file4 = fileArr[i3];
                            try {
                                long parseInt2 = Integer.parseInt(file4.getName());
                                long h = m.h(file4);
                                j.au(c.TAG, "file size " + h);
                                long j8 = (parseInt2 + h) - 1;
                                if (c.this.bOH >= parseInt2 && c.this.bOH <= j8) {
                                    j3 = h;
                                    file = file4;
                                    j = parseInt2;
                                    j5 = parseInt2 + h;
                                    break;
                                }
                            } catch (Exception e3) {
                            }
                            i3++;
                        } else {
                            j = 0;
                            j5 = j6;
                            j3 = 0;
                            file = null;
                            break;
                        }
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 < fileArr.length) {
                            if (!c.this.bOO) {
                                try {
                                    parseInt = Integer.parseInt(fileArr[i4].getName());
                                } catch (Exception e4) {
                                }
                                if (parseInt < j5) {
                                    i4++;
                                } else {
                                    j6 = j5;
                                    j2 = parseInt - 1;
                                    break;
                                }
                            } else {
                                j6 = j5;
                                j2 = j7;
                                break;
                            }
                        } else {
                            j6 = j5;
                            j2 = j7;
                            break;
                        }
                    }
                }
                if (c.this.bOO) {
                    break;
                }
                j.au(c.TAG, "total range is " + c.this.bOH + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.bOG + " " + c.this);
                j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.bOP + "/" + c.this.bOH;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new ak("c12027").ab("errormsg", "创建缓存文件出现异常").ab("name", str3).ab("error", e5.getMessage()).ab("url", c.this.bOE));
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
                } else {
                    String absolutePath = file.getAbsolutePath();
                    long length = file.length();
                    if (length >= 1048576) {
                        j4 = j2;
                        z = true;
                    } else if ((j2 - j6) + 1 + length <= 1048576) {
                        j4 = j2;
                        z = false;
                    } else {
                        j4 = ((1048576 - length) + j6) - 1;
                        z = false;
                    }
                    z2 = z;
                    str2 = absolutePath;
                }
                if (str2 != null) {
                    try {
                        c.this.bON = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.bON = null;
                }
                if (file != null) {
                    try {
                        if (c.this.bON != null) {
                            c.this.bON.skip(c.this.bOH - j);
                        }
                        j.au(c.TAG, "skip: " + (c.this.bOH - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.au(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.bOJ = j + j3;
                } else {
                    j.au(c.TAG, "hit file: null " + c.this);
                }
                j.au(c.TAG, "first mReadPosition " + c.this.bOI + " first writeposition " + c.this.bOJ + " " + c.this);
                c.this.bOQ = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.bOG) {
                    if (c.this.bOO) {
                        break;
                    }
                    j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.bOR = (j + j3) - 1;
                    } else {
                        try {
                            j.au(c.TAG, "download start waitting ...... ");
                            while (c.this.ST()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.bOO) {
                                    break;
                                }
                            }
                            c.this.bOL = -1L;
                            URL url = new URL(c.this.bOE);
                            j.au(c.TAG, "url opt 1 " + c.this);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            j.au(c.TAG, "url opt 2 " + c.this);
                            httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            j.au(c.TAG, "url opt 3 " + c.this);
                            InputStream inputStream = httpURLConnection.getInputStream();
                            while (inputStream == null) {
                                j.au(c.TAG, "conn input is null " + c.this);
                                if (c.this.bOO) {
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
                            if (str2 == null) {
                                fileOutputStream = null;
                            } else {
                                fileOutputStream = new FileOutputStream(str2, true);
                            }
                            j.au(c.TAG, "read start ..." + c.this);
                            while (true) {
                                try {
                                    int read = inputStream.read(c.this.bOU);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.au(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.bOO) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.bOU, 0, read);
                                    } else {
                                        c.this.bOV = read;
                                    }
                                    c.this.bOJ += read;
                                    i5 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.bOV != 0) {
                                            synchronized (c.this.bOW) {
                                                try {
                                                    c.this.bOW.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.bOO) {
                                                break;
                                            }
                                        }
                                        if (c.this.bOO) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new ak("c12027").ab("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ab("error", e11.getMessage()).s("dsize", i5).ab("url", c.this.bOE));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.bOK = 0L;
                            x.m(c.this.bOE, i5, (int) c.this.bfw);
                            j.au(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.Tf().h(inputStream);
                            c.this.bOR = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new ak("c12027").ab("errormsg", "连接中断，文件下载出现异常").ab("error", e12.getMessage()).ab("url", c.this.bOE));
                            j.au(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.au(c.TAG, "download out " + c.this);
                    while (c.this.bOI < c.this.bOJ && !c.this.bOO) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.bOO) {
                            break;
                        }
                    }
                    if (c.this.bOK > 0 && c.this.bOK <= 3) {
                        j.au(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bOR);
                        c.this.bOR = c.this.bOI - 1;
                        j.au(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bOR);
                    }
                    if (c.this.bOO) {
                        break;
                    }
                    long j9 = c.this.bOI;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length && !c.this.bOO; i7++) {
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.bOS) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.au(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long h2 = m.h(file5);
                                if ((Integer.parseInt(file5.getName()) + h2) - 1 < j9 && (i6 = (int) (i6 + h2)) > 31457280) {
                                    c.this.bOS = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.au(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.au(c.TAG, "mLastRequestRangeEnd " + c.this.bOR + " mReadPosition " + c.this.bOI + "  " + c.this);
                    if (c.this.bOR == -1 || c.this.bOI <= c.this.bOR || c.this.bOR >= c.this.bOG) {
                        break;
                    }
                    try {
                        if (c.this.bON != null) {
                            c.this.bON.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.bOQ = false;
                    c.this.bOH = c.this.bOR + 1;
                    j.au(c.TAG, "continue to download... " + c.this);
                } else {
                    j.au(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.SW().x(c.this);
            j.au(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] bOU = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.bOK;
        cVar.bOK = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.bOE = str;
    }

    public void Y(long j) {
        this.bfw = j;
    }

    public void b(long j, long j2) {
        j.au(TAG, "open *************************************************************" + this);
        if (this.bOE != null) {
            this.bOF = j;
            this.bOG = j2;
            this.bOT = m.hD(this.bOE);
            if (this.bOT != null) {
                File file = new File(i.bPr + this.bOT);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.bOP = file2.getAbsolutePath();
                    this.bOJ = this.bOF;
                    this.bOI = this.bOF;
                    this.bOH = this.bOF;
                    this.bOO = false;
                    this.bOQ = false;
                    this.bOR = -1L;
                    this.bOS = false;
                    l.Tg().f(this.bOX);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.bOE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SS() {
        if (m.hC(this.bOT) > this.bfw) {
            m.z(new File(i.bPr + this.bOT + "/segments"));
            TiebaStatic.log(new ak("c12028").ab("errormsg", "校验到缓存文件片段大小有异常").ab("url", this.bOE));
            j.au(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void aB(long j) {
        if (j == -1) {
            j.au(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.bOM = true;
        } else if (j == 0 && this.bOM) {
            j.au(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.bOL = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ST() {
        if (!this.bOM || this.bOL != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.au(TAG, "close ***********************************************************************" + this);
        this.bOO = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.bON != null) {
                this.bON.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.bPr + this.bOT + "/completed");
        if (this.bOS) {
            return;
        }
        if (file == null || !file.exists()) {
            k.Tf().hA(this.bOE);
        }
    }

    public boolean canRead() {
        return !this.bOO && this.bOI <= this.bOG;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.bOO) {
            return 0;
        }
        do {
            if (this.bOI == this.bOJ || !this.bOQ) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.bOI + ((long) i) < this.bOJ ? i : this.bOJ - this.bOI);
                try {
                    if (this.bON == null) {
                        if (this.bOV > 0) {
                            System.arraycopy(this.bOU, 0, bArr, 0, (int) this.bOV);
                            read = (int) this.bOV;
                            this.bOV = 0L;
                            synchronized (this.bOW) {
                                this.bOW.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.bON.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.bOI += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.bOO);
        return 0;
    }
}
