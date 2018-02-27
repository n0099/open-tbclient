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
    private String bQI;
    private long bQJ;
    private long bQK;
    private long bQL;
    private long bQM;
    private long bQN;
    private FileInputStream bQR;
    private String bQX;
    private long bQZ;
    private Context mContext;
    private long bQO = 0;
    private long bQP = -1;
    private boolean bQQ = false;
    private boolean bQS = false;
    private String bQT = "";
    private Object mLock = new Object();
    private boolean bQU = false;
    private long bQV = -1;
    boolean bQW = false;
    private Object bRa = new Object();
    private long bhl = 0;
    private Runnable bRb = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            while (e.TG().y(c.this)) {
                e.TG().hK(c.this.bQI);
                try {
                    j.au(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.au(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.bQS) {
                    break;
                }
            }
            if (!c.this.bQS) {
                e.TG().w(c.this);
            }
            while (true) {
                if (c.this.bQS) {
                    break;
                }
                j.au(c.TAG, "download in " + c.this);
                if (c.this.TC()) {
                    break;
                }
                c.this.bQV = -1L;
                File file2 = new File(c.this.bQT);
                long j6 = c.this.bQL;
                long j7 = c.this.bQK;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.bQS) {
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
                if (c.this.bQS) {
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
                            if (c.this.bQS) {
                                j = 0;
                                j5 = j6;
                                j3 = 0;
                                file = null;
                                break;
                            }
                            File file4 = fileArr[i3];
                            try {
                                long parseInt2 = Integer.parseInt(file4.getName());
                                long i4 = m.i(file4);
                                j.au(c.TAG, "file size " + i4);
                                long j8 = (parseInt2 + i4) - 1;
                                if (c.this.bQL >= parseInt2 && c.this.bQL <= j8) {
                                    j3 = i4;
                                    file = file4;
                                    j = parseInt2;
                                    j5 = parseInt2 + i4;
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
                    int i5 = 0;
                    while (true) {
                        if (i5 < fileArr.length) {
                            if (!c.this.bQS) {
                                try {
                                    parseInt = Integer.parseInt(fileArr[i5].getName());
                                } catch (Exception e4) {
                                }
                                if (parseInt < j5) {
                                    i5++;
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
                if (c.this.bQS) {
                    break;
                }
                j.au(c.TAG, "total range is " + c.this.bQL + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.bQK + " " + c.this);
                j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.bQT + "/" + c.this.bQL;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new ak("c12027").ab("errormsg", "创建缓存文件出现异常").ab("name", str3).ab("error", e5.getMessage()).ab("url", c.this.bQI));
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
                        c.this.bQR = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.bQR = null;
                }
                if (file != null) {
                    try {
                        if (c.this.bQR != null) {
                            c.this.bQR.skip(c.this.bQL - j);
                        }
                        j.au(c.TAG, "skip: " + (c.this.bQL - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.au(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.bQN = j + j3;
                } else {
                    j.au(c.TAG, "hit file: null " + c.this);
                }
                j.au(c.TAG, "first mReadPosition " + c.this.bQM + " first writeposition " + c.this.bQN + " " + c.this);
                c.this.bQU = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.bQK) {
                    if (c.this.bQS) {
                        break;
                    }
                    j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.bQV = (j + j3) - 1;
                    } else {
                        try {
                            j.au(c.TAG, "download start waitting ...... ");
                            while (c.this.TD()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.bQS) {
                                    break;
                                }
                            }
                            c.this.bQP = -1L;
                            URL url = new URL(c.this.bQI);
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
                                if (c.this.bQS) {
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
                            int i6 = 0;
                            if (str2 == null) {
                                fileOutputStream = null;
                            } else {
                                fileOutputStream = new FileOutputStream(str2, true);
                            }
                            j.au(c.TAG, "read start ..." + c.this);
                            while (true) {
                                try {
                                    int read = inputStream.read(c.this.bQY);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.au(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.bQS) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.bQY, 0, read);
                                    } else {
                                        c.this.bQZ = read;
                                    }
                                    c.this.bQN += read;
                                    i6 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.bQZ != 0) {
                                            synchronized (c.this.bRa) {
                                                try {
                                                    c.this.bRa.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.bQS) {
                                                break;
                                            }
                                        }
                                        if (c.this.bQS) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new ak("c12027").ab("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ab("error", e11.getMessage()).s("dsize", i6).ab("url", c.this.bQI));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.bQO = 0L;
                            x.o(c.this.bQI, i6, (int) c.this.bhl);
                            j.au(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.TP().h(inputStream);
                            c.this.bQV = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new ak("c12027").ab("errormsg", "连接中断，文件下载出现异常").ab("error", e12.getMessage()).ab("url", c.this.bQI));
                            j.au(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.au(c.TAG, "download out " + c.this);
                    while (c.this.bQM < c.this.bQN && !c.this.bQS) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.bQS) {
                            break;
                        }
                    }
                    if (c.this.bQO > 0 && c.this.bQO <= 3) {
                        j.au(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bQV);
                        c.this.bQV = c.this.bQM - 1;
                        j.au(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bQV);
                    }
                    if (c.this.bQS) {
                        break;
                    }
                    long j9 = c.this.bQM;
                    int i7 = 0;
                    for (int i8 = 0; i8 < fileArr.length && !c.this.bQS; i8++) {
                        int length2 = (fileArr.length - 1) - i8;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.bQW) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.au(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long i9 = m.i(file5);
                                if ((Integer.parseInt(file5.getName()) + i9) - 1 < j9 && (i7 = (int) (i7 + i9)) > 31457280) {
                                    c.this.bQW = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.au(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.au(c.TAG, "mLastRequestRangeEnd " + c.this.bQV + " mReadPosition " + c.this.bQM + "  " + c.this);
                    if (c.this.bQV == -1 || c.this.bQM <= c.this.bQV || c.this.bQV >= c.this.bQK) {
                        break;
                    }
                    try {
                        if (c.this.bQR != null) {
                            c.this.bQR.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.bQU = false;
                    c.this.bQL = c.this.bQV + 1;
                    j.au(c.TAG, "continue to download... " + c.this);
                } else {
                    j.au(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.TG().x(c.this);
            j.au(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] bQY = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.bQO;
        cVar.bQO = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.bQI = str;
    }

    public void Y(long j) {
        this.bhl = j;
    }

    public void b(long j, long j2) {
        j.au(TAG, "open *************************************************************" + this);
        if (this.bQI != null) {
            this.bQJ = j;
            this.bQK = j2;
            this.bQX = m.hU(this.bQI);
            if (this.bQX != null) {
                File file = new File(i.bRu + this.bQX);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.bQT = file2.getAbsolutePath();
                    this.bQN = this.bQJ;
                    this.bQM = this.bQJ;
                    this.bQL = this.bQJ;
                    this.bQS = false;
                    this.bQU = false;
                    this.bQV = -1L;
                    this.bQW = false;
                    l.TQ().f(this.bRb);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.bQI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TC() {
        if (m.hT(this.bQX) > this.bhl) {
            m.z(new File(i.bRu + this.bQX + "/segments"));
            TiebaStatic.log(new ak("c12028").ab("errormsg", "校验到缓存文件片段大小有异常").ab("url", this.bQI));
            j.au(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void aB(long j) {
        if (j == -1) {
            j.au(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.bQQ = true;
        } else if (j == 0 && this.bQQ) {
            j.au(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.bQP = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TD() {
        if (!this.bQQ || this.bQP != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.au(TAG, "close ***********************************************************************" + this);
        this.bQS = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.bQR != null) {
                this.bQR.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.bRu + this.bQX + "/completed");
        if (this.bQW) {
            return;
        }
        if (file == null || !file.exists()) {
            k.TP().hR(this.bQI);
        }
    }

    public boolean canRead() {
        return !this.bQS && this.bQM <= this.bQK;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.bQS) {
            return 0;
        }
        do {
            if (this.bQM == this.bQN || !this.bQU) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.bQM + ((long) i) < this.bQN ? i : this.bQN - this.bQM);
                try {
                    if (this.bQR == null) {
                        if (this.bQZ > 0) {
                            System.arraycopy(this.bQY, 0, bArr, 0, (int) this.bQZ);
                            read = (int) this.bQZ;
                            this.bQZ = 0L;
                            synchronized (this.bRa) {
                                this.bRa.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.bQR.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.bQM += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.bQS);
        return 0;
    }
}
