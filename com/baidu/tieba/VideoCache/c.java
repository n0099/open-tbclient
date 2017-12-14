package com.baidu.tieba.VideoCache;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
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
/* loaded from: classes2.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private String baI;
    private long baJ;
    private long baK;
    private long baL;
    private long baM;
    private long baN;
    private FileInputStream baR;
    private String baX;
    private long baZ;
    private Context mContext;
    private long baO = 0;
    private long baP = -1;
    private boolean baQ = false;
    private boolean baS = false;
    private String baT = "";
    private Object mLock = new Object();
    private boolean baU = false;
    private long baV = -1;
    boolean baW = false;
    private Object bba = new Object();
    private long arn = 0;
    private Runnable bbb = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.av(c.TAG, "test run in " + c.this);
            while (e.LJ().y(c.this)) {
                e.LJ().hq(c.this.baI);
                try {
                    j.av(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.av(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.baS) {
                    break;
                }
            }
            if (!c.this.baS) {
                e.LJ().w(c.this);
            }
            while (true) {
                if (c.this.baS) {
                    break;
                }
                j.av(c.TAG, "download in " + c.this);
                if (c.this.LF()) {
                    break;
                }
                c.this.baV = -1L;
                File file2 = new File(c.this.baT);
                long j6 = c.this.baL;
                long j7 = c.this.baK;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.baS) {
                            break;
                        }
                        if (file3 != null && file3.exists()) {
                            try {
                                Long.parseLong(file3.getName());
                                if (m.g(file3) == 0) {
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
                if (c.this.baS) {
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
                    j.av(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + " " + c.this);
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
                            if (c.this.baS) {
                                j = 0;
                                j5 = j6;
                                j3 = 0;
                                file = null;
                                break;
                            }
                            File file4 = fileArr[i3];
                            try {
                                long parseInt2 = Integer.parseInt(file4.getName());
                                long g = m.g(file4);
                                j.av(c.TAG, "file size " + g);
                                long j8 = (parseInt2 + g) - 1;
                                if (c.this.baL >= parseInt2 && c.this.baL <= j8) {
                                    j3 = g;
                                    file = file4;
                                    j = parseInt2;
                                    j5 = parseInt2 + g;
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
                            if (!c.this.baS) {
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
                if (c.this.baS) {
                    break;
                }
                j.av(c.TAG, "total range is " + c.this.baL + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.baK + " " + c.this);
                j.av(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.baT + "/" + c.this.baL;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new ak("c12027").ac("errormsg", "创建缓存文件出现异常").ac("name", str3).ac("error", e5.getMessage()).ac("url", c.this.baI));
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
                        c.this.baR = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.baR = null;
                }
                if (file != null) {
                    try {
                        if (c.this.baR != null) {
                            c.this.baR.skip(c.this.baL - j);
                        }
                        j.av(c.TAG, "skip: " + (c.this.baL - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.av(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.baN = j + j3;
                } else {
                    j.av(c.TAG, "hit file: null " + c.this);
                }
                j.av(c.TAG, "first mReadPosition " + c.this.baM + " first writeposition " + c.this.baN + " " + c.this);
                c.this.baU = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.baK) {
                    if (c.this.baS) {
                        break;
                    }
                    j.av(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.baV = (j + j3) - 1;
                    } else {
                        try {
                            j.av(c.TAG, "download start waitting ...... ");
                            while (c.this.LG()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.baS) {
                                    break;
                                }
                            }
                            c.this.baP = -1L;
                            URL url = new URL(c.this.baI);
                            j.av(c.TAG, "url opt 1 " + c.this);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            j.av(c.TAG, "url opt 2 " + c.this);
                            httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            j.av(c.TAG, "url opt 3 " + c.this);
                            InputStream inputStream = httpURLConnection.getInputStream();
                            while (inputStream == null) {
                                j.av(c.TAG, "conn input is null " + c.this);
                                if (c.this.baS) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e9) {
                                    e9.printStackTrace();
                                }
                                inputStream = httpURLConnection.getInputStream();
                            }
                            j.av(c.TAG, "got conn input " + c.this);
                            j.av(c.TAG, "url opt 4 " + c.this);
                            int i5 = 0;
                            if (str2 == null) {
                                fileOutputStream = null;
                            } else {
                                fileOutputStream = new FileOutputStream(str2, true);
                            }
                            j.av(c.TAG, "read start ..." + c.this);
                            while (true) {
                                try {
                                    int read = inputStream.read(c.this.baY);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.av(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.baS) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.baY, 0, read);
                                    } else {
                                        c.this.baZ = read;
                                    }
                                    c.this.baN += read;
                                    i5 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.baZ != 0) {
                                            synchronized (c.this.bba) {
                                                try {
                                                    c.this.bba.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.baS) {
                                                break;
                                            }
                                        }
                                        if (c.this.baS) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new ak("c12027").ac("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ac("error", e11.getMessage()).r("dsize", i5).ac("url", c.this.baI));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.baO = 0L;
                            w.j(c.this.baI, i5, (int) c.this.arn);
                            j.av(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.LS().h(inputStream);
                            c.this.baV = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new ak("c12027").ac("errormsg", "连接中断，文件下载出现异常").ac("error", e12.getMessage()).ac("url", c.this.baI));
                            j.av(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.av(c.TAG, "download out " + c.this);
                    while (c.this.baM < c.this.baN && !c.this.baS) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.baS) {
                            break;
                        }
                    }
                    if (c.this.baO > 0 && c.this.baO <= 3) {
                        j.av(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.baV);
                        c.this.baV = c.this.baM - 1;
                        j.av(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.baV);
                    }
                    if (c.this.baS) {
                        break;
                    }
                    long j9 = c.this.baM;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length && !c.this.baS; i7++) {
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.baW) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.av(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long g2 = m.g(file5);
                                if ((Integer.parseInt(file5.getName()) + g2) - 1 < j9 && (i6 = (int) (i6 + g2)) > 31457280) {
                                    c.this.baW = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.av(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.av(c.TAG, "mLastRequestRangeEnd " + c.this.baV + " mReadPosition " + c.this.baM + "  " + c.this);
                    if (c.this.baV == -1 || c.this.baM <= c.this.baV || c.this.baV >= c.this.baK) {
                        break;
                    }
                    try {
                        if (c.this.baR != null) {
                            c.this.baR.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.baU = false;
                    c.this.baL = c.this.baV + 1;
                    j.av(c.TAG, "continue to download... " + c.this);
                } else {
                    j.av(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.LJ().x(c.this);
            j.av(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] baY = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.baO;
        cVar.baO = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.baI = str;
    }

    public void Q(long j) {
        this.arn = j;
    }

    public void b(long j, long j2) {
        j.av(TAG, "open *************************************************************" + this);
        if (this.baI != null) {
            this.baJ = j;
            this.baK = j2;
            this.baX = m.hA(this.baI);
            if (this.baX != null) {
                File file = new File(i.bbv + this.baX);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.baT = file2.getAbsolutePath();
                    this.baN = this.baJ;
                    this.baM = this.baJ;
                    this.baL = this.baJ;
                    this.baS = false;
                    this.baU = false;
                    this.baV = -1L;
                    this.baW = false;
                    l.LT().e(this.bbb);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.baI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean LF() {
        if (m.hz(this.baX) > this.arn) {
            m.y(new File(i.bbv + this.baX + "/segments"));
            TiebaStatic.log(new ak("c12028").ac("errormsg", "校验到缓存文件片段大小有异常").ac("url", this.baI));
            j.av(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void at(long j) {
        if (j == -1) {
            j.av(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.baQ = true;
        } else if (j == 0 && this.baQ) {
            j.av(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.baP = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean LG() {
        if (!this.baQ || this.baP != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.av(TAG, "close ***********************************************************************" + this);
        this.baS = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.baR != null) {
                this.baR.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.bbv + this.baX + "/completed");
        if (this.baW) {
            return;
        }
        if (file == null || !file.exists()) {
            k.LS().hx(this.baI);
        }
    }

    public boolean canRead() {
        return !this.baS && this.baM <= this.baK;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.baS) {
            return 0;
        }
        do {
            if (this.baM == this.baN || !this.baU) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.baM + ((long) i) < this.baN ? i : this.baN - this.baM);
                try {
                    if (this.baR == null) {
                        if (this.baZ > 0) {
                            System.arraycopy(this.baY, 0, bArr, 0, (int) this.baZ);
                            read = (int) this.baZ;
                            this.baZ = 0L;
                            synchronized (this.bba) {
                                this.bba.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.baR.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.baM += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.baS);
        return 0;
    }
}
