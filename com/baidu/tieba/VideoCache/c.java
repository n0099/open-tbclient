package com.baidu.tieba.VideoCache;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
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
    private String bdb;
    private long bkZ;
    private long bla;
    private long blb;
    private long blc;
    private long bld;
    private FileInputStream blh;
    private String bln;
    private long blp;
    private Context mContext;
    private long ble = 0;
    private long blf = -1;
    private boolean blg = false;
    private boolean bli = false;
    private String blj = "";
    private Object mLock = new Object();
    private boolean blk = false;
    private long bll = -1;
    boolean blm = false;
    private Object blq = new Object();
    private long aBR = 0;
    private Runnable blr = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.ax(c.TAG, "test run in " + c.this);
            while (e.Qe().y(c.this)) {
                e.Qe().m15if(c.this.bdb);
                try {
                    j.ax(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.ax(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.bli) {
                    break;
                }
            }
            if (!c.this.bli) {
                e.Qe().w(c.this);
            }
            while (true) {
                if (c.this.bli) {
                    break;
                }
                j.ax(c.TAG, "download in " + c.this);
                if (c.this.Qa()) {
                    break;
                }
                c.this.bll = -1L;
                File file2 = new File(c.this.blj);
                long j6 = c.this.blb;
                long j7 = c.this.bla;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.bli) {
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
                if (c.this.bli) {
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
                    j.ax(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + " " + c.this);
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
                            if (c.this.bli) {
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
                                j.ax(c.TAG, "file size " + h);
                                long j8 = (parseInt2 + h) - 1;
                                if (c.this.blb >= parseInt2 && c.this.blb <= j8) {
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
                            if (!c.this.bli) {
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
                if (c.this.bli) {
                    break;
                }
                j.ax(c.TAG, "total range is " + c.this.blb + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.bla + " " + c.this);
                j.ax(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.blj + "/" + c.this.blb;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new an("c12027").af("errormsg", "创建缓存文件出现异常").af("name", str3).af("error", e5.getMessage()).af("url", c.this.bdb));
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
                        c.this.blh = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.blh = null;
                }
                if (file != null) {
                    try {
                        if (c.this.blh != null) {
                            c.this.blh.skip(c.this.blb - j);
                        }
                        j.ax(c.TAG, "skip: " + (c.this.blb - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.ax(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.bld = j + j3;
                } else {
                    j.ax(c.TAG, "hit file: null " + c.this);
                }
                j.ax(c.TAG, "first mReadPosition " + c.this.blc + " first writeposition " + c.this.bld + " " + c.this);
                c.this.blk = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.bla) {
                    if (c.this.bli) {
                        break;
                    }
                    j.ax(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.bll = (j + j3) - 1;
                    } else {
                        try {
                            j.ax(c.TAG, "download start waitting ...... ");
                            while (c.this.Qb()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.bli) {
                                    break;
                                }
                            }
                            c.this.blf = -1L;
                            URL url = new URL(c.this.bdb);
                            j.ax(c.TAG, "url opt 1 " + c.this);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            j.ax(c.TAG, "url opt 2 " + c.this);
                            httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            j.ax(c.TAG, "url opt 3 " + c.this);
                            InputStream inputStream = httpURLConnection.getInputStream();
                            while (inputStream == null) {
                                j.ax(c.TAG, "conn input is null " + c.this);
                                if (c.this.bli) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e9) {
                                    e9.printStackTrace();
                                }
                                inputStream = httpURLConnection.getInputStream();
                            }
                            j.ax(c.TAG, "got conn input " + c.this);
                            j.ax(c.TAG, "url opt 4 " + c.this);
                            int i5 = 0;
                            if (str2 == null) {
                                fileOutputStream = null;
                            } else {
                                fileOutputStream = new FileOutputStream(str2, true);
                            }
                            j.ax(c.TAG, "read start ..." + c.this);
                            while (true) {
                                try {
                                    int read = inputStream.read(c.this.blo);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.ax(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.bli) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.blo, 0, read);
                                    } else {
                                        c.this.blp = read;
                                    }
                                    c.this.bld += read;
                                    i5 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.blp != 0) {
                                            synchronized (c.this.blq) {
                                                try {
                                                    c.this.blq.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.bli) {
                                                break;
                                            }
                                        }
                                        if (c.this.bli) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new an("c12027").af("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").af("error", e11.getMessage()).r("dsize", i5).af("url", c.this.bdb));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.ble = 0L;
                            v.p(c.this.bdb, i5, (int) c.this.aBR);
                            j.ax(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.Qn().j(inputStream);
                            c.this.bll = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new an("c12027").af("errormsg", "连接中断，文件下载出现异常").af("error", e12.getMessage()).af("url", c.this.bdb));
                            j.ax(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.ax(c.TAG, "download out " + c.this);
                    while (c.this.blc < c.this.bld && !c.this.bli) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.bli) {
                            break;
                        }
                    }
                    if (c.this.ble > 0 && c.this.ble <= 3) {
                        j.ax(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bll);
                        c.this.bll = c.this.blc - 1;
                        j.ax(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bll);
                    }
                    if (c.this.bli) {
                        break;
                    }
                    long j9 = c.this.blc;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length && !c.this.bli; i7++) {
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.blm) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.ax(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long h2 = m.h(file5);
                                if ((Integer.parseInt(file5.getName()) + h2) - 1 < j9 && (i6 = (int) (i6 + h2)) > 31457280) {
                                    c.this.blm = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.ax(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.ax(c.TAG, "mLastRequestRangeEnd " + c.this.bll + " mReadPosition " + c.this.blc + "  " + c.this);
                    if (c.this.bll == -1 || c.this.blc <= c.this.bll || c.this.bll >= c.this.bla) {
                        break;
                    }
                    try {
                        if (c.this.blh != null) {
                            c.this.blh.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.blk = false;
                    c.this.blb = c.this.bll + 1;
                    j.ax(c.TAG, "continue to download... " + c.this);
                } else {
                    j.ax(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.Qe().x(c.this);
            j.ax(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] blo = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.ble;
        cVar.ble = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.bdb = str;
    }

    public void W(long j) {
        this.aBR = j;
    }

    public void c(long j, long j2) {
        j.ax(TAG, "open *************************************************************" + this);
        if (this.bdb != null) {
            this.bkZ = j;
            this.bla = j2;
            this.bln = m.ip(this.bdb);
            if (this.bln != null) {
                File file = new File(i.blL + this.bln);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.blj = file2.getAbsolutePath();
                    this.bld = this.bkZ;
                    this.blc = this.bkZ;
                    this.blb = this.bkZ;
                    this.bli = false;
                    this.blk = false;
                    this.bll = -1L;
                    this.blm = false;
                    l.Qo().e(this.blr);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.bdb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Qa() {
        if (m.io(this.bln) > this.aBR) {
            m.y(new File(i.blL + this.bln + "/segments"));
            TiebaStatic.log(new an("c12028").af("errormsg", "校验到缓存文件片段大小有异常").af("url", this.bdb));
            j.ax(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void aA(long j) {
        if (j == -1) {
            j.ax(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.blg = true;
        } else if (j == 0 && this.blg) {
            j.ax(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.blf = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Qb() {
        if (!this.blg || this.blf != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.ax(TAG, "close ***********************************************************************" + this);
        this.bli = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.blh != null) {
                this.blh.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.blL + this.bln + "/completed");
        if (this.blm) {
            return;
        }
        if (file == null || !file.exists()) {
            k.Qn().im(this.bdb);
        }
    }

    public boolean canRead() {
        return !this.bli && this.blc <= this.bla;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.bli) {
            return 0;
        }
        do {
            if (this.blc == this.bld || !this.blk) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.blc + ((long) i) < this.bld ? i : this.bld - this.blc);
                try {
                    if (this.blh == null) {
                        if (this.blp > 0) {
                            System.arraycopy(this.blo, 0, bArr, 0, (int) this.blp);
                            read = (int) this.blp;
                            this.blp = 0L;
                            synchronized (this.blq) {
                                this.blq.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.blh.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.blc += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.bli);
        return 0;
    }
}
