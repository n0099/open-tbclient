package com.baidu.tieba.VideoCache;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
    private String avN;
    private long bqT;
    private long bqU;
    private long bqV;
    private long bqW;
    private long bqX;
    private FileInputStream brb;
    private String brg;
    private long bri;
    private Context mContext;
    private long bqY = 0;
    private long bqZ = -1;
    private boolean bra = false;
    private boolean brc = false;
    private String avP = "";
    private Object mLock = new Object();
    private boolean brd = false;
    private long bre = -1;
    boolean brf = false;
    private Object brj = new Object();
    private long aEU = 0;
    private Runnable brk = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.aF(c.TAG, "test run in " + c.this);
            while (e.RY().y(c.this)) {
                e.RY().iH(c.this.avN);
                try {
                    j.aF(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.aF(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.brc) {
                    break;
                }
            }
            if (!c.this.brc) {
                e.RY().w(c.this);
            }
            while (true) {
                if (c.this.brc) {
                    break;
                }
                j.aF(c.TAG, "download in " + c.this);
                if (c.this.RU()) {
                    break;
                }
                c.this.bre = -1L;
                File file2 = new File(c.this.avP);
                long j6 = c.this.bqV;
                long j7 = c.this.bqU;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.brc) {
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
                if (c.this.brc) {
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
                    j.aF(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + " " + c.this);
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
                            if (c.this.brc) {
                                j = 0;
                                j5 = j6;
                                j3 = 0;
                                file = null;
                                break;
                            }
                            File file4 = fileArr[i3];
                            try {
                                long parseInt2 = Integer.parseInt(file4.getName());
                                long n = m.n(file4);
                                j.aF(c.TAG, "file size " + n);
                                long j8 = (parseInt2 + n) - 1;
                                if (c.this.bqV >= parseInt2 && c.this.bqV <= j8) {
                                    j3 = n;
                                    file = file4;
                                    j = parseInt2;
                                    j5 = parseInt2 + n;
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
                            if (!c.this.brc) {
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
                if (c.this.brc) {
                    break;
                }
                j.aF(c.TAG, "total range is " + c.this.bqV + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.bqU + " " + c.this);
                j.aF(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.avP + "/" + c.this.bqV;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new am("c12027").al("errormsg", "创建缓存文件出现异常").al("name", str3).al("error", e5.getMessage()).al("url", c.this.avN));
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
                } else {
                    String absolutePath = file.getAbsolutePath();
                    long length = file.length();
                    if (length >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                        j4 = j2;
                        z = true;
                    } else if ((j2 - j6) + 1 + length <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                        j4 = j2;
                        z = false;
                    } else {
                        j4 = ((PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - length) + j6) - 1;
                        z = false;
                    }
                    z2 = z;
                    str2 = absolutePath;
                }
                if (str2 != null) {
                    try {
                        c.this.brb = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.brb = null;
                }
                if (file != null) {
                    try {
                        if (c.this.brb != null) {
                            c.this.brb.skip(c.this.bqV - j);
                        }
                        j.aF(c.TAG, "skip: " + (c.this.bqV - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.aF(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.bqX = j + j3;
                } else {
                    j.aF(c.TAG, "hit file: null " + c.this);
                }
                j.aF(c.TAG, "first mReadPosition " + c.this.bqW + " first writeposition " + c.this.bqX + " " + c.this);
                c.this.brd = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.bqU) {
                    if (c.this.brc) {
                        break;
                    }
                    j.aF(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.bre = (j + j3) - 1;
                    } else {
                        try {
                            j.aF(c.TAG, "download start waitting ...... ");
                            while (c.this.RV()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.brc) {
                                    break;
                                }
                            }
                            c.this.bqZ = -1L;
                            URL url = new URL(c.this.avN);
                            j.aF(c.TAG, "url opt 1 " + c.this);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            j.aF(c.TAG, "url opt 2 " + c.this);
                            httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            j.aF(c.TAG, "url opt 3 " + c.this);
                            InputStream inputStream = httpURLConnection.getInputStream();
                            while (inputStream == null) {
                                j.aF(c.TAG, "conn input is null " + c.this);
                                if (c.this.brc) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e9) {
                                    e9.printStackTrace();
                                }
                                inputStream = httpURLConnection.getInputStream();
                            }
                            j.aF(c.TAG, "got conn input " + c.this);
                            j.aF(c.TAG, "url opt 4 " + c.this);
                            int i5 = 0;
                            if (str2 == null) {
                                fileOutputStream = null;
                            } else {
                                fileOutputStream = new FileOutputStream(str2, true);
                            }
                            j.aF(c.TAG, "read start ..." + c.this);
                            while (true) {
                                try {
                                    int read = inputStream.read(c.this.brh);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.aF(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.brc) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.brh, 0, read);
                                    } else {
                                        c.this.bri = read;
                                    }
                                    c.this.bqX += read;
                                    i5 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.bri != 0) {
                                            synchronized (c.this.brj) {
                                                try {
                                                    c.this.brj.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.brc) {
                                                break;
                                            }
                                        }
                                        if (c.this.brc) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new am("c12027").al("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").al("error", e11.getMessage()).w("dsize", i5).al("url", c.this.avN));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.bqY = 0L;
                            v.v(c.this.avN, i5, (int) c.this.aEU);
                            j.aF(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.Sh().l(inputStream);
                            c.this.bre = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new am("c12027").al("errormsg", "连接中断，文件下载出现异常").al("error", e12.getMessage()).al("url", c.this.avN));
                            j.aF(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.aF(c.TAG, "download out " + c.this);
                    while (c.this.bqW < c.this.bqX && !c.this.brc) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.brc) {
                            break;
                        }
                    }
                    if (c.this.bqY > 0 && c.this.bqY <= 3) {
                        j.aF(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bre);
                        c.this.bre = c.this.bqW - 1;
                        j.aF(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bre);
                    }
                    if (c.this.brc) {
                        break;
                    }
                    long j9 = c.this.bqW;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length && !c.this.brc; i7++) {
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.brf) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.aF(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long n2 = m.n(file5);
                                if ((Integer.parseInt(file5.getName()) + n2) - 1 < j9 && (i6 = (int) (i6 + n2)) > 31457280) {
                                    c.this.brf = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.aF(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.aF(c.TAG, "mLastRequestRangeEnd " + c.this.bre + " mReadPosition " + c.this.bqW + "  " + c.this);
                    if (c.this.bre == -1 || c.this.bqW <= c.this.bre || c.this.bre >= c.this.bqU) {
                        break;
                    }
                    try {
                        if (c.this.brb != null) {
                            c.this.brb.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.brd = false;
                    c.this.bqV = c.this.bre + 1;
                    j.aF(c.TAG, "continue to download... " + c.this);
                } else {
                    j.aF(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.RY().x(c.this);
            j.aF(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] brh = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.bqY;
        cVar.bqY = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.avN = str;
    }

    public void aa(long j) {
        this.aEU = j;
    }

    public void d(long j, long j2) {
        j.aF(TAG, "open *************************************************************" + this);
        if (this.avN != null) {
            this.bqT = j;
            this.bqU = j2;
            this.brg = m.iR(this.avN);
            if (this.brg != null) {
                File file = new File(i.brE + this.brg);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.avP = file2.getAbsolutePath();
                    this.bqX = this.bqT;
                    this.bqW = this.bqT;
                    this.bqV = this.bqT;
                    this.brc = false;
                    this.brd = false;
                    this.bre = -1L;
                    this.brf = false;
                    l.Si().e(this.brk);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.avN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean RU() {
        if (m.iQ(this.brg) > this.aEU) {
            m.E(new File(i.brE + this.brg + "/segments"));
            TiebaStatic.log(new am("c12028").al("errormsg", "校验到缓存文件片段大小有异常").al("url", this.avN));
            j.aF(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void aE(long j) {
        if (j == -1) {
            j.aF(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.bra = true;
        } else if (j == 0 && this.bra) {
            j.aF(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.bqZ = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean RV() {
        if (!this.bra || this.bqZ != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.aF(TAG, "close ***********************************************************************" + this);
        this.brc = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.brb != null) {
                this.brb.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.brE + this.brg + "/completed");
        if (this.brf) {
            return;
        }
        if (file == null || !file.exists()) {
            k.Sh().iO(this.avN);
        }
    }

    public boolean canRead() {
        return !this.brc && this.bqW <= this.bqU;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.brc) {
            return 0;
        }
        do {
            if (this.bqW == this.bqX || !this.brd) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.bqW + ((long) i) < this.bqX ? i : this.bqX - this.bqW);
                try {
                    if (this.brb == null) {
                        if (this.bri > 0) {
                            System.arraycopy(this.brh, 0, bArr, 0, (int) this.bri);
                            read = (int) this.bri;
                            this.bri = 0L;
                            synchronized (this.brj) {
                                this.brj.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.brb.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.bqW += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.brc);
        return 0;
    }
}
