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
    private String bON;
    private long bOO;
    private long bOP;
    private long bOQ;
    private long bOR;
    private long bOS;
    private FileInputStream bOW;
    private String bPc;
    private long bPe;
    private Context mContext;
    private long bOT = 0;
    private long bOU = -1;
    private boolean bOV = false;
    private boolean bOX = false;
    private String bOY = "";
    private Object mLock = new Object();
    private boolean bOZ = false;
    private long bPa = -1;
    boolean bPb = false;
    private Object bPf = new Object();
    private long bfE = 0;
    private Runnable bPg = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.at(c.TAG, "test run in " + c.this);
            while (e.SY().y(c.this)) {
                e.SY().hB(c.this.bON);
                try {
                    j.at(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.at(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.bOX) {
                    break;
                }
            }
            if (!c.this.bOX) {
                e.SY().w(c.this);
            }
            while (true) {
                if (c.this.bOX) {
                    break;
                }
                j.at(c.TAG, "download in " + c.this);
                if (c.this.SU()) {
                    break;
                }
                c.this.bPa = -1L;
                File file2 = new File(c.this.bOY);
                long j6 = c.this.bOQ;
                long j7 = c.this.bOP;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.bOX) {
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
                if (c.this.bOX) {
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
                    j.at(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + " " + c.this);
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
                            if (c.this.bOX) {
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
                                j.at(c.TAG, "file size " + h);
                                long j8 = (parseInt2 + h) - 1;
                                if (c.this.bOQ >= parseInt2 && c.this.bOQ <= j8) {
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
                            if (!c.this.bOX) {
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
                if (c.this.bOX) {
                    break;
                }
                j.at(c.TAG, "total range is " + c.this.bOQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.bOP + " " + c.this);
                j.at(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.bOY + "/" + c.this.bOQ;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new ak("c12027").aa("errormsg", "创建缓存文件出现异常").aa("name", str3).aa("error", e5.getMessage()).aa("url", c.this.bON));
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
                        c.this.bOW = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.bOW = null;
                }
                if (file != null) {
                    try {
                        if (c.this.bOW != null) {
                            c.this.bOW.skip(c.this.bOQ - j);
                        }
                        j.at(c.TAG, "skip: " + (c.this.bOQ - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.at(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.bOS = j + j3;
                } else {
                    j.at(c.TAG, "hit file: null " + c.this);
                }
                j.at(c.TAG, "first mReadPosition " + c.this.bOR + " first writeposition " + c.this.bOS + " " + c.this);
                c.this.bOZ = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.bOP) {
                    if (c.this.bOX) {
                        break;
                    }
                    j.at(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.bPa = (j + j3) - 1;
                    } else {
                        try {
                            j.at(c.TAG, "download start waitting ...... ");
                            while (c.this.SV()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.bOX) {
                                    break;
                                }
                            }
                            c.this.bOU = -1L;
                            URL url = new URL(c.this.bON);
                            j.at(c.TAG, "url opt 1 " + c.this);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            j.at(c.TAG, "url opt 2 " + c.this);
                            httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            j.at(c.TAG, "url opt 3 " + c.this);
                            InputStream inputStream = httpURLConnection.getInputStream();
                            while (inputStream == null) {
                                j.at(c.TAG, "conn input is null " + c.this);
                                if (c.this.bOX) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e9) {
                                    e9.printStackTrace();
                                }
                                inputStream = httpURLConnection.getInputStream();
                            }
                            j.at(c.TAG, "got conn input " + c.this);
                            j.at(c.TAG, "url opt 4 " + c.this);
                            int i5 = 0;
                            if (str2 == null) {
                                fileOutputStream = null;
                            } else {
                                fileOutputStream = new FileOutputStream(str2, true);
                            }
                            j.at(c.TAG, "read start ..." + c.this);
                            while (true) {
                                try {
                                    int read = inputStream.read(c.this.bPd);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.at(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.bOX) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.bPd, 0, read);
                                    } else {
                                        c.this.bPe = read;
                                    }
                                    c.this.bOS += read;
                                    i5 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.bPe != 0) {
                                            synchronized (c.this.bPf) {
                                                try {
                                                    c.this.bPf.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.bOX) {
                                                break;
                                            }
                                        }
                                        if (c.this.bOX) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new ak("c12027").aa("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").aa("error", e11.getMessage()).s("dsize", i5).aa("url", c.this.bON));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.bOT = 0L;
                            x.m(c.this.bON, i5, (int) c.this.bfE);
                            j.at(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.Th().h(inputStream);
                            c.this.bPa = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new ak("c12027").aa("errormsg", "连接中断，文件下载出现异常").aa("error", e12.getMessage()).aa("url", c.this.bON));
                            j.at(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.at(c.TAG, "download out " + c.this);
                    while (c.this.bOR < c.this.bOS && !c.this.bOX) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.bOX) {
                            break;
                        }
                    }
                    if (c.this.bOT > 0 && c.this.bOT <= 3) {
                        j.at(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bPa);
                        c.this.bPa = c.this.bOR - 1;
                        j.at(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bPa);
                    }
                    if (c.this.bOX) {
                        break;
                    }
                    long j9 = c.this.bOR;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length && !c.this.bOX; i7++) {
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.bPb) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.at(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long h2 = m.h(file5);
                                if ((Integer.parseInt(file5.getName()) + h2) - 1 < j9 && (i6 = (int) (i6 + h2)) > 31457280) {
                                    c.this.bPb = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.at(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.at(c.TAG, "mLastRequestRangeEnd " + c.this.bPa + " mReadPosition " + c.this.bOR + "  " + c.this);
                    if (c.this.bPa == -1 || c.this.bOR <= c.this.bPa || c.this.bPa >= c.this.bOP) {
                        break;
                    }
                    try {
                        if (c.this.bOW != null) {
                            c.this.bOW.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.bOZ = false;
                    c.this.bOQ = c.this.bPa + 1;
                    j.at(c.TAG, "continue to download... " + c.this);
                } else {
                    j.at(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.SY().x(c.this);
            j.at(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] bPd = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.bOT;
        cVar.bOT = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.bON = str;
    }

    public void Y(long j) {
        this.bfE = j;
    }

    public void b(long j, long j2) {
        j.at(TAG, "open *************************************************************" + this);
        if (this.bON != null) {
            this.bOO = j;
            this.bOP = j2;
            this.bPc = m.hL(this.bON);
            if (this.bPc != null) {
                File file = new File(i.bPz + this.bPc);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.bOY = file2.getAbsolutePath();
                    this.bOS = this.bOO;
                    this.bOR = this.bOO;
                    this.bOQ = this.bOO;
                    this.bOX = false;
                    this.bOZ = false;
                    this.bPa = -1L;
                    this.bPb = false;
                    l.Ti().f(this.bPg);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.bON;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SU() {
        if (m.hK(this.bPc) > this.bfE) {
            m.z(new File(i.bPz + this.bPc + "/segments"));
            TiebaStatic.log(new ak("c12028").aa("errormsg", "校验到缓存文件片段大小有异常").aa("url", this.bON));
            j.at(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void aB(long j) {
        if (j == -1) {
            j.at(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.bOV = true;
        } else if (j == 0 && this.bOV) {
            j.at(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.bOU = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SV() {
        if (!this.bOV || this.bOU != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.at(TAG, "close ***********************************************************************" + this);
        this.bOX = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.bOW != null) {
                this.bOW.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.bPz + this.bPc + "/completed");
        if (this.bPb) {
            return;
        }
        if (file == null || !file.exists()) {
            k.Th().hI(this.bON);
        }
    }

    public boolean canRead() {
        return !this.bOX && this.bOR <= this.bOP;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.bOX) {
            return 0;
        }
        do {
            if (this.bOR == this.bOS || !this.bOZ) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.bOR + ((long) i) < this.bOS ? i : this.bOS - this.bOR);
                try {
                    if (this.bOW == null) {
                        if (this.bPe > 0) {
                            System.arraycopy(this.bPd, 0, bArr, 0, (int) this.bPe);
                            read = (int) this.bPe;
                            this.bPe = 0L;
                            synchronized (this.bPf) {
                                this.bPf.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.bOW.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.bOR += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.bOX);
        return 0;
    }
}
