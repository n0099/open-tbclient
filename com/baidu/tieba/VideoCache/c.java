package com.baidu.tieba.VideoCache;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.play.v;
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
    private String baJ;
    private long baK;
    private long baL;
    private long baM;
    private long baN;
    private long baO;
    private FileInputStream baS;
    private String baY;
    private long bba;
    private Context mContext;
    private long baP = 0;
    private long baQ = -1;
    private boolean baR = false;
    private boolean baT = false;
    private String baU = "";
    private Object mLock = new Object();
    private boolean baV = false;
    private long baW = -1;
    boolean baX = false;
    private Object bbb = new Object();
    private long asW = 0;
    private Runnable bbc = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            while (e.Mb().y(c.this)) {
                e.Mb().hE(c.this.baJ);
                try {
                    j.au(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.au(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.baT) {
                    break;
                }
            }
            if (!c.this.baT) {
                e.Mb().w(c.this);
            }
            while (true) {
                if (c.this.baT) {
                    break;
                }
                j.au(c.TAG, "download in " + c.this);
                if (c.this.LY()) {
                    break;
                }
                c.this.baW = -1L;
                File file2 = new File(c.this.baU);
                long j6 = c.this.baM;
                long j7 = c.this.baL;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.baT) {
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
                if (c.this.baT) {
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
                            if (c.this.baT) {
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
                                if (c.this.baM >= parseInt2 && c.this.baM <= j8) {
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
                            if (!c.this.baT) {
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
                if (c.this.baT) {
                    break;
                }
                j.au(c.TAG, "total range is " + c.this.baM + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.baL + " " + c.this);
                j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.baU + "/" + c.this.baM;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new al("c12027").ac("errormsg", "创建缓存文件出现异常").ac("name", str3).ac("error", e5.getMessage()).ac("url", c.this.baJ));
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
                        c.this.baS = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.baS = null;
                }
                if (file != null) {
                    try {
                        if (c.this.baS != null) {
                            c.this.baS.skip(c.this.baM - j);
                        }
                        j.au(c.TAG, "skip: " + (c.this.baM - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.au(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.baO = j + j3;
                } else {
                    j.au(c.TAG, "hit file: null " + c.this);
                }
                j.au(c.TAG, "first mReadPosition " + c.this.baN + " first writeposition " + c.this.baO + " " + c.this);
                c.this.baV = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.baL) {
                    if (c.this.baT) {
                        break;
                    }
                    j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.baW = (j + j3) - 1;
                    } else {
                        try {
                            j.au(c.TAG, "download start waitting ...... ");
                            while (c.this.LZ()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.baT) {
                                    break;
                                }
                            }
                            c.this.baQ = -1L;
                            URL url = new URL(c.this.baJ);
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
                                if (c.this.baT) {
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
                                    int read = inputStream.read(c.this.baZ);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.au(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.baT) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.baZ, 0, read);
                                    } else {
                                        c.this.bba = read;
                                    }
                                    c.this.baO += read;
                                    i5 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.bba != 0) {
                                            synchronized (c.this.bbb) {
                                                try {
                                                    c.this.bbb.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.baT) {
                                                break;
                                            }
                                        }
                                        if (c.this.baT) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new al("c12027").ac("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ac("error", e11.getMessage()).r("dsize", i5).ac("url", c.this.baJ));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.baP = 0L;
                            v.p(c.this.baJ, i5, (int) c.this.asW);
                            j.au(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.Mk().h(inputStream);
                            c.this.baW = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new al("c12027").ac("errormsg", "连接中断，文件下载出现异常").ac("error", e12.getMessage()).ac("url", c.this.baJ));
                            j.au(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.au(c.TAG, "download out " + c.this);
                    while (c.this.baN < c.this.baO && !c.this.baT) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.baT) {
                            break;
                        }
                    }
                    if (c.this.baP > 0 && c.this.baP <= 3) {
                        j.au(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.baW);
                        c.this.baW = c.this.baN - 1;
                        j.au(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.baW);
                    }
                    if (c.this.baT) {
                        break;
                    }
                    long j9 = c.this.baN;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length && !c.this.baT; i7++) {
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.baX) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.au(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long h2 = m.h(file5);
                                if ((Integer.parseInt(file5.getName()) + h2) - 1 < j9 && (i6 = (int) (i6 + h2)) > 31457280) {
                                    c.this.baX = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.au(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.au(c.TAG, "mLastRequestRangeEnd " + c.this.baW + " mReadPosition " + c.this.baN + "  " + c.this);
                    if (c.this.baW == -1 || c.this.baN <= c.this.baW || c.this.baW >= c.this.baL) {
                        break;
                    }
                    try {
                        if (c.this.baS != null) {
                            c.this.baS.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.baV = false;
                    c.this.baM = c.this.baW + 1;
                    j.au(c.TAG, "continue to download... " + c.this);
                } else {
                    j.au(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.Mb().x(c.this);
            j.au(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] baZ = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.baP;
        cVar.baP = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.baJ = str;
    }

    public void Q(long j) {
        this.asW = j;
    }

    public void b(long j, long j2) {
        j.au(TAG, "open *************************************************************" + this);
        if (this.baJ != null) {
            this.baK = j;
            this.baL = j2;
            this.baY = m.hO(this.baJ);
            if (this.baY != null) {
                File file = new File(i.bbv + this.baY);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.baU = file2.getAbsolutePath();
                    this.baO = this.baK;
                    this.baN = this.baK;
                    this.baM = this.baK;
                    this.baT = false;
                    this.baV = false;
                    this.baW = -1L;
                    this.baX = false;
                    l.Ml().e(this.bbc);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.baJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean LY() {
        if (m.hN(this.baY) > this.asW) {
            m.y(new File(i.bbv + this.baY + "/segments"));
            TiebaStatic.log(new al("c12028").ac("errormsg", "校验到缓存文件片段大小有异常").ac("url", this.baJ));
            j.au(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void at(long j) {
        if (j == -1) {
            j.au(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.baR = true;
        } else if (j == 0 && this.baR) {
            j.au(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.baQ = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean LZ() {
        if (!this.baR || this.baQ != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.au(TAG, "close ***********************************************************************" + this);
        this.baT = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.baS != null) {
                this.baS.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.bbv + this.baY + "/completed");
        if (this.baX) {
            return;
        }
        if (file == null || !file.exists()) {
            k.Mk().hL(this.baJ);
        }
    }

    public boolean canRead() {
        return !this.baT && this.baN <= this.baL;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.baT) {
            return 0;
        }
        do {
            if (this.baN == this.baO || !this.baV) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.baN + ((long) i) < this.baO ? i : this.baO - this.baN);
                try {
                    if (this.baS == null) {
                        if (this.bba > 0) {
                            System.arraycopy(this.baZ, 0, bArr, 0, (int) this.bba);
                            read = (int) this.bba;
                            this.bba = 0L;
                            synchronized (this.bbb) {
                                this.bbb.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.baS.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.baN += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.baT);
        return 0;
    }
}
