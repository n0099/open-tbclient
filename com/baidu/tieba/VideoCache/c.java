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
    private String bQV;
    private long bQW;
    private long bQX;
    private long bQY;
    private long bQZ;
    private long bRa;
    private FileInputStream bRe;
    private String bRk;
    private long bRm;
    private Context mContext;
    private long bRb = 0;
    private long bRc = -1;
    private boolean bRd = false;
    private boolean bRf = false;
    private String bRg = "";
    private Object mLock = new Object();
    private boolean bRh = false;
    private long bRi = -1;
    boolean bRj = false;
    private Object bRn = new Object();
    private long bhx = 0;
    private Runnable bRo = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            while (e.TH().y(c.this)) {
                e.TH().hK(c.this.bQV);
                try {
                    j.au(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.au(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.bRf) {
                    break;
                }
            }
            if (!c.this.bRf) {
                e.TH().w(c.this);
            }
            while (true) {
                if (c.this.bRf) {
                    break;
                }
                j.au(c.TAG, "download in " + c.this);
                if (c.this.TD()) {
                    break;
                }
                c.this.bRi = -1L;
                File file2 = new File(c.this.bRg);
                long j6 = c.this.bQY;
                long j7 = c.this.bQX;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.bRf) {
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
                if (c.this.bRf) {
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
                            if (c.this.bRf) {
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
                                if (c.this.bQY >= parseInt2 && c.this.bQY <= j8) {
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
                            if (!c.this.bRf) {
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
                if (c.this.bRf) {
                    break;
                }
                j.au(c.TAG, "total range is " + c.this.bQY + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.bQX + " " + c.this);
                j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.bRg + "/" + c.this.bQY;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new ak("c12027").ab("errormsg", "创建缓存文件出现异常").ab("name", str3).ab("error", e5.getMessage()).ab("url", c.this.bQV));
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
                        c.this.bRe = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.bRe = null;
                }
                if (file != null) {
                    try {
                        if (c.this.bRe != null) {
                            c.this.bRe.skip(c.this.bQY - j);
                        }
                        j.au(c.TAG, "skip: " + (c.this.bQY - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.au(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.bRa = j + j3;
                } else {
                    j.au(c.TAG, "hit file: null " + c.this);
                }
                j.au(c.TAG, "first mReadPosition " + c.this.bQZ + " first writeposition " + c.this.bRa + " " + c.this);
                c.this.bRh = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.bQX) {
                    if (c.this.bRf) {
                        break;
                    }
                    j.au(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.bRi = (j + j3) - 1;
                    } else {
                        try {
                            j.au(c.TAG, "download start waitting ...... ");
                            while (c.this.TE()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.bRf) {
                                    break;
                                }
                            }
                            c.this.bRc = -1L;
                            URL url = new URL(c.this.bQV);
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
                                if (c.this.bRf) {
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
                                    int read = inputStream.read(c.this.bRl);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.au(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.bRf) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.bRl, 0, read);
                                    } else {
                                        c.this.bRm = read;
                                    }
                                    c.this.bRa += read;
                                    i6 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.bRm != 0) {
                                            synchronized (c.this.bRn) {
                                                try {
                                                    c.this.bRn.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.bRf) {
                                                break;
                                            }
                                        }
                                        if (c.this.bRf) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new ak("c12027").ab("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ab("error", e11.getMessage()).s("dsize", i6).ab("url", c.this.bQV));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.bRb = 0L;
                            x.o(c.this.bQV, i6, (int) c.this.bhx);
                            j.au(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.TQ().h(inputStream);
                            c.this.bRi = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new ak("c12027").ab("errormsg", "连接中断，文件下载出现异常").ab("error", e12.getMessage()).ab("url", c.this.bQV));
                            j.au(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.au(c.TAG, "download out " + c.this);
                    while (c.this.bQZ < c.this.bRa && !c.this.bRf) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.bRf) {
                            break;
                        }
                    }
                    if (c.this.bRb > 0 && c.this.bRb <= 3) {
                        j.au(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bRi);
                        c.this.bRi = c.this.bQZ - 1;
                        j.au(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bRi);
                    }
                    if (c.this.bRf) {
                        break;
                    }
                    long j9 = c.this.bQZ;
                    int i7 = 0;
                    for (int i8 = 0; i8 < fileArr.length && !c.this.bRf; i8++) {
                        int length2 = (fileArr.length - 1) - i8;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.bRj) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.au(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long i9 = m.i(file5);
                                if ((Integer.parseInt(file5.getName()) + i9) - 1 < j9 && (i7 = (int) (i7 + i9)) > 31457280) {
                                    c.this.bRj = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.au(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.au(c.TAG, "mLastRequestRangeEnd " + c.this.bRi + " mReadPosition " + c.this.bQZ + "  " + c.this);
                    if (c.this.bRi == -1 || c.this.bQZ <= c.this.bRi || c.this.bRi >= c.this.bQX) {
                        break;
                    }
                    try {
                        if (c.this.bRe != null) {
                            c.this.bRe.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.bRh = false;
                    c.this.bQY = c.this.bRi + 1;
                    j.au(c.TAG, "continue to download... " + c.this);
                } else {
                    j.au(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.TH().x(c.this);
            j.au(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] bRl = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.bRb;
        cVar.bRb = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.bQV = str;
    }

    public void Y(long j) {
        this.bhx = j;
    }

    public void b(long j, long j2) {
        j.au(TAG, "open *************************************************************" + this);
        if (this.bQV != null) {
            this.bQW = j;
            this.bQX = j2;
            this.bRk = m.hU(this.bQV);
            if (this.bRk != null) {
                File file = new File(i.bRH + this.bRk);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.bRg = file2.getAbsolutePath();
                    this.bRa = this.bQW;
                    this.bQZ = this.bQW;
                    this.bQY = this.bQW;
                    this.bRf = false;
                    this.bRh = false;
                    this.bRi = -1L;
                    this.bRj = false;
                    l.TR().f(this.bRo);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.bQV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TD() {
        if (m.hT(this.bRk) > this.bhx) {
            m.z(new File(i.bRH + this.bRk + "/segments"));
            TiebaStatic.log(new ak("c12028").ab("errormsg", "校验到缓存文件片段大小有异常").ab("url", this.bQV));
            j.au(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void aB(long j) {
        if (j == -1) {
            j.au(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.bRd = true;
        } else if (j == 0 && this.bRd) {
            j.au(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.bRc = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TE() {
        if (!this.bRd || this.bRc != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.au(TAG, "close ***********************************************************************" + this);
        this.bRf = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.bRe != null) {
                this.bRe.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.bRH + this.bRk + "/completed");
        if (this.bRj) {
            return;
        }
        if (file == null || !file.exists()) {
            k.TQ().hR(this.bQV);
        }
    }

    public boolean canRead() {
        return !this.bRf && this.bQZ <= this.bQX;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.bRf) {
            return 0;
        }
        do {
            if (this.bQZ == this.bRa || !this.bRh) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.bQZ + ((long) i) < this.bRa ? i : this.bRa - this.bQZ);
                try {
                    if (this.bRe == null) {
                        if (this.bRm > 0) {
                            System.arraycopy(this.bRl, 0, bArr, 0, (int) this.bRm);
                            read = (int) this.bRm;
                            this.bRm = 0L;
                            synchronized (this.bRn) {
                                this.bRn.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.bRe.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.bQZ += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.bRf);
        return 0;
    }
}
