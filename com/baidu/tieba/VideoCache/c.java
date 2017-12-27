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
    private long bOA;
    private long bOB;
    private FileInputStream bOF;
    private String bOL;
    private long bON;
    private String bOw;
    private long bOx;
    private long bOy;
    private long bOz;
    private Context mContext;
    private long bOC = 0;
    private long bOD = -1;
    private boolean bOE = false;
    private boolean bOG = false;
    private String bOH = "";
    private Object mLock = new Object();
    private boolean bOI = false;
    private long bOJ = -1;
    boolean bOK = false;
    private Object bOO = new Object();
    private long bfq = 0;
    private Runnable bOP = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            while (e.Ti().y(c.this)) {
                e.Ti().hs(c.this.bOw);
                try {
                    j.au(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.au(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.bOG) {
                    break;
                }
            }
            if (!c.this.bOG) {
                e.Ti().w(c.this);
            }
            while (true) {
                if (c.this.bOG) {
                    break;
                }
                j.au(c.TAG, "download in " + c.this);
                if (c.this.Te()) {
                    break;
                }
                c.this.bOJ = -1L;
                File file2 = new File(c.this.bOH);
                long j6 = c.this.bOz;
                long j7 = c.this.bOy;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.bOG) {
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
                if (c.this.bOG) {
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
                            if (c.this.bOG) {
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
                                if (c.this.bOz >= parseInt2 && c.this.bOz <= j8) {
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
                            if (!c.this.bOG) {
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
                if (c.this.bOG) {
                    break;
                }
                j.au(c.TAG, "total range is " + c.this.bOz + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.bOy + " " + c.this);
                j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.bOH + "/" + c.this.bOz;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new ak("c12027").ab("errormsg", "创建缓存文件出现异常").ab("name", str3).ab("error", e5.getMessage()).ab("url", c.this.bOw));
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
                        c.this.bOF = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.bOF = null;
                }
                if (file != null) {
                    try {
                        if (c.this.bOF != null) {
                            c.this.bOF.skip(c.this.bOz - j);
                        }
                        j.au(c.TAG, "skip: " + (c.this.bOz - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.au(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.bOB = j + j3;
                } else {
                    j.au(c.TAG, "hit file: null " + c.this);
                }
                j.au(c.TAG, "first mReadPosition " + c.this.bOA + " first writeposition " + c.this.bOB + " " + c.this);
                c.this.bOI = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.bOy) {
                    if (c.this.bOG) {
                        break;
                    }
                    j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.bOJ = (j + j3) - 1;
                    } else {
                        try {
                            j.au(c.TAG, "download start waitting ...... ");
                            while (c.this.Tf()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.bOG) {
                                    break;
                                }
                            }
                            c.this.bOD = -1L;
                            URL url = new URL(c.this.bOw);
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
                                if (c.this.bOG) {
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
                                    int read = inputStream.read(c.this.bOM);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.au(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.bOG) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.bOM, 0, read);
                                    } else {
                                        c.this.bON = read;
                                    }
                                    c.this.bOB += read;
                                    i5 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.bON != 0) {
                                            synchronized (c.this.bOO) {
                                                try {
                                                    c.this.bOO.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.bOG) {
                                                break;
                                            }
                                        }
                                        if (c.this.bOG) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new ak("c12027").ab("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ab("error", e11.getMessage()).s("dsize", i5).ab("url", c.this.bOw));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.bOC = 0L;
                            x.o(c.this.bOw, i5, (int) c.this.bfq);
                            j.au(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.Tr().h(inputStream);
                            c.this.bOJ = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new ak("c12027").ab("errormsg", "连接中断，文件下载出现异常").ab("error", e12.getMessage()).ab("url", c.this.bOw));
                            j.au(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.au(c.TAG, "download out " + c.this);
                    while (c.this.bOA < c.this.bOB && !c.this.bOG) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.bOG) {
                            break;
                        }
                    }
                    if (c.this.bOC > 0 && c.this.bOC <= 3) {
                        j.au(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bOJ);
                        c.this.bOJ = c.this.bOA - 1;
                        j.au(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bOJ);
                    }
                    if (c.this.bOG) {
                        break;
                    }
                    long j9 = c.this.bOA;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length && !c.this.bOG; i7++) {
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.bOK) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.au(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long h2 = m.h(file5);
                                if ((Integer.parseInt(file5.getName()) + h2) - 1 < j9 && (i6 = (int) (i6 + h2)) > 31457280) {
                                    c.this.bOK = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.au(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.au(c.TAG, "mLastRequestRangeEnd " + c.this.bOJ + " mReadPosition " + c.this.bOA + "  " + c.this);
                    if (c.this.bOJ == -1 || c.this.bOA <= c.this.bOJ || c.this.bOJ >= c.this.bOy) {
                        break;
                    }
                    try {
                        if (c.this.bOF != null) {
                            c.this.bOF.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.bOI = false;
                    c.this.bOz = c.this.bOJ + 1;
                    j.au(c.TAG, "continue to download... " + c.this);
                } else {
                    j.au(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.Ti().x(c.this);
            j.au(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] bOM = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.bOC;
        cVar.bOC = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.bOw = str;
    }

    public void Y(long j) {
        this.bfq = j;
    }

    public void b(long j, long j2) {
        j.au(TAG, "open *************************************************************" + this);
        if (this.bOw != null) {
            this.bOx = j;
            this.bOy = j2;
            this.bOL = m.hC(this.bOw);
            if (this.bOL != null) {
                File file = new File(i.bPk + this.bOL);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.bOH = file2.getAbsolutePath();
                    this.bOB = this.bOx;
                    this.bOA = this.bOx;
                    this.bOz = this.bOx;
                    this.bOG = false;
                    this.bOI = false;
                    this.bOJ = -1L;
                    this.bOK = false;
                    l.Ts().f(this.bOP);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.bOw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Te() {
        if (m.hB(this.bOL) > this.bfq) {
            m.z(new File(i.bPk + this.bOL + "/segments"));
            TiebaStatic.log(new ak("c12028").ab("errormsg", "校验到缓存文件片段大小有异常").ab("url", this.bOw));
            j.au(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void aB(long j) {
        if (j == -1) {
            j.au(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.bOE = true;
        } else if (j == 0 && this.bOE) {
            j.au(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.bOD = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Tf() {
        if (!this.bOE || this.bOD != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.au(TAG, "close ***********************************************************************" + this);
        this.bOG = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.bOF != null) {
                this.bOF.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.bPk + this.bOL + "/completed");
        if (this.bOK) {
            return;
        }
        if (file == null || !file.exists()) {
            k.Tr().hz(this.bOw);
        }
    }

    public boolean canRead() {
        return !this.bOG && this.bOA <= this.bOy;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.bOG) {
            return 0;
        }
        do {
            if (this.bOA == this.bOB || !this.bOI) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.bOA + ((long) i) < this.bOB ? i : this.bOB - this.bOA);
                try {
                    if (this.bOF == null) {
                        if (this.bON > 0) {
                            System.arraycopy(this.bOM, 0, bArr, 0, (int) this.bON);
                            read = (int) this.bON;
                            this.bON = 0L;
                            synchronized (this.bOO) {
                                this.bOO.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.bOF.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.bOA += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.bOG);
        return 0;
    }
}
