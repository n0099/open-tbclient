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
    private String baM;
    private long baN;
    private long baO;
    private long baP;
    private long baQ;
    private long baR;
    private FileInputStream baV;
    private String bbb;
    private long bbd;
    private Context mContext;
    private long baS = 0;
    private long baT = -1;
    private boolean baU = false;
    private boolean baW = false;
    private String baX = "";
    private Object mLock = new Object();
    private boolean baY = false;
    private long baZ = -1;
    boolean bba = false;
    private Object bbe = new Object();
    private long arq = 0;
    private Runnable bbf = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
                e.LJ().hq(c.this.baM);
                try {
                    j.av(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.av(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.baW) {
                    break;
                }
            }
            if (!c.this.baW) {
                e.LJ().w(c.this);
            }
            while (true) {
                if (c.this.baW) {
                    break;
                }
                j.av(c.TAG, "download in " + c.this);
                if (c.this.LF()) {
                    break;
                }
                c.this.baZ = -1L;
                File file2 = new File(c.this.baX);
                long j6 = c.this.baP;
                long j7 = c.this.baO;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.baW) {
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
                if (c.this.baW) {
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
                            if (c.this.baW) {
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
                                if (c.this.baP >= parseInt2 && c.this.baP <= j8) {
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
                            if (!c.this.baW) {
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
                if (c.this.baW) {
                    break;
                }
                j.av(c.TAG, "total range is " + c.this.baP + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.baO + " " + c.this);
                j.av(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.baX + "/" + c.this.baP;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new ak("c12027").ac("errormsg", "创建缓存文件出现异常").ac("name", str3).ac("error", e5.getMessage()).ac("url", c.this.baM));
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
                        c.this.baV = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.baV = null;
                }
                if (file != null) {
                    try {
                        if (c.this.baV != null) {
                            c.this.baV.skip(c.this.baP - j);
                        }
                        j.av(c.TAG, "skip: " + (c.this.baP - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.av(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.baR = j + j3;
                } else {
                    j.av(c.TAG, "hit file: null " + c.this);
                }
                j.av(c.TAG, "first mReadPosition " + c.this.baQ + " first writeposition " + c.this.baR + " " + c.this);
                c.this.baY = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.baO) {
                    if (c.this.baW) {
                        break;
                    }
                    j.av(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.baZ = (j + j3) - 1;
                    } else {
                        try {
                            j.av(c.TAG, "download start waitting ...... ");
                            while (c.this.LG()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.baW) {
                                    break;
                                }
                            }
                            c.this.baT = -1L;
                            URL url = new URL(c.this.baM);
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
                                if (c.this.baW) {
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
                                    int read = inputStream.read(c.this.bbc);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.av(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.baW) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.bbc, 0, read);
                                    } else {
                                        c.this.bbd = read;
                                    }
                                    c.this.baR += read;
                                    i5 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.bbd != 0) {
                                            synchronized (c.this.bbe) {
                                                try {
                                                    c.this.bbe.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.baW) {
                                                break;
                                            }
                                        }
                                        if (c.this.baW) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new ak("c12027").ac("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ac("error", e11.getMessage()).r("dsize", i5).ac("url", c.this.baM));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.baS = 0L;
                            w.j(c.this.baM, i5, (int) c.this.arq);
                            j.av(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.LS().h(inputStream);
                            c.this.baZ = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new ak("c12027").ac("errormsg", "连接中断，文件下载出现异常").ac("error", e12.getMessage()).ac("url", c.this.baM));
                            j.av(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.av(c.TAG, "download out " + c.this);
                    while (c.this.baQ < c.this.baR && !c.this.baW) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.baW) {
                            break;
                        }
                    }
                    if (c.this.baS > 0 && c.this.baS <= 3) {
                        j.av(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.baZ);
                        c.this.baZ = c.this.baQ - 1;
                        j.av(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.baZ);
                    }
                    if (c.this.baW) {
                        break;
                    }
                    long j9 = c.this.baQ;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length && !c.this.baW; i7++) {
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.bba) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.av(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long g2 = m.g(file5);
                                if ((Integer.parseInt(file5.getName()) + g2) - 1 < j9 && (i6 = (int) (i6 + g2)) > 31457280) {
                                    c.this.bba = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.av(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.av(c.TAG, "mLastRequestRangeEnd " + c.this.baZ + " mReadPosition " + c.this.baQ + "  " + c.this);
                    if (c.this.baZ == -1 || c.this.baQ <= c.this.baZ || c.this.baZ >= c.this.baO) {
                        break;
                    }
                    try {
                        if (c.this.baV != null) {
                            c.this.baV.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.baY = false;
                    c.this.baP = c.this.baZ + 1;
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
    private byte[] bbc = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.baS;
        cVar.baS = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.baM = str;
    }

    public void Q(long j) {
        this.arq = j;
    }

    public void b(long j, long j2) {
        j.av(TAG, "open *************************************************************" + this);
        if (this.baM != null) {
            this.baN = j;
            this.baO = j2;
            this.bbb = m.hA(this.baM);
            if (this.bbb != null) {
                File file = new File(i.bbz + this.bbb);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.baX = file2.getAbsolutePath();
                    this.baR = this.baN;
                    this.baQ = this.baN;
                    this.baP = this.baN;
                    this.baW = false;
                    this.baY = false;
                    this.baZ = -1L;
                    this.bba = false;
                    l.LT().e(this.bbf);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.baM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean LF() {
        if (m.hz(this.bbb) > this.arq) {
            m.y(new File(i.bbz + this.bbb + "/segments"));
            TiebaStatic.log(new ak("c12028").ac("errormsg", "校验到缓存文件片段大小有异常").ac("url", this.baM));
            j.av(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void at(long j) {
        if (j == -1) {
            j.av(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.baU = true;
        } else if (j == 0 && this.baU) {
            j.av(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.baT = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean LG() {
        if (!this.baU || this.baT != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.av(TAG, "close ***********************************************************************" + this);
        this.baW = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.baV != null) {
                this.baV.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.bbz + this.bbb + "/completed");
        if (this.bba) {
            return;
        }
        if (file == null || !file.exists()) {
            k.LS().hx(this.baM);
        }
    }

    public boolean canRead() {
        return !this.baW && this.baQ <= this.baO;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.baW) {
            return 0;
        }
        do {
            if (this.baQ == this.baR || !this.baY) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.baQ + ((long) i) < this.baR ? i : this.baR - this.baQ);
                try {
                    if (this.baV == null) {
                        if (this.bbd > 0) {
                            System.arraycopy(this.bbc, 0, bArr, 0, (int) this.bbd);
                            read = (int) this.bbd;
                            this.bbd = 0L;
                            synchronized (this.bbe) {
                                this.bbe.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.baV.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.baQ += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.baW);
        return 0;
    }
}
