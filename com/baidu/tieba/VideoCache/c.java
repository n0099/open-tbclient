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
    private long ble;
    private long blf;
    private long blg;
    private long blh;
    private long bli;
    private FileInputStream blm;
    private String bls;
    private long blu;
    private Context mContext;
    private long blj = 0;
    private long blk = -1;
    private boolean bll = false;
    private boolean bln = false;
    private String blo = "";
    private Object mLock = new Object();
    private boolean blp = false;
    private long blq = -1;
    boolean blr = false;
    private Object blv = new Object();
    private long aBO = 0;
    private Runnable blw = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            while (e.Qk().y(c.this)) {
                e.Qk().ig(c.this.bdb);
                try {
                    j.ax(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.ax(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.bln) {
                    break;
                }
            }
            if (!c.this.bln) {
                e.Qk().w(c.this);
            }
            while (true) {
                if (c.this.bln) {
                    break;
                }
                j.ax(c.TAG, "download in " + c.this);
                if (c.this.Qg()) {
                    break;
                }
                c.this.blq = -1L;
                File file2 = new File(c.this.blo);
                long j6 = c.this.blg;
                long j7 = c.this.blf;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.bln) {
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
                if (c.this.bln) {
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
                            if (c.this.bln) {
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
                                if (c.this.blg >= parseInt2 && c.this.blg <= j8) {
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
                            if (!c.this.bln) {
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
                if (c.this.bln) {
                    break;
                }
                j.ax(c.TAG, "total range is " + c.this.blg + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.blf + " " + c.this);
                j.ax(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.blo + "/" + c.this.blg;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new an("c12027").ae("errormsg", "创建缓存文件出现异常").ae("name", str3).ae("error", e5.getMessage()).ae("url", c.this.bdb));
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
                        c.this.blm = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.blm = null;
                }
                if (file != null) {
                    try {
                        if (c.this.blm != null) {
                            c.this.blm.skip(c.this.blg - j);
                        }
                        j.ax(c.TAG, "skip: " + (c.this.blg - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.ax(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.bli = j + j3;
                } else {
                    j.ax(c.TAG, "hit file: null " + c.this);
                }
                j.ax(c.TAG, "first mReadPosition " + c.this.blh + " first writeposition " + c.this.bli + " " + c.this);
                c.this.blp = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.blf) {
                    if (c.this.bln) {
                        break;
                    }
                    j.ax(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.blq = (j + j3) - 1;
                    } else {
                        try {
                            j.ax(c.TAG, "download start waitting ...... ");
                            while (c.this.Qh()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.bln) {
                                    break;
                                }
                            }
                            c.this.blk = -1L;
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
                                if (c.this.bln) {
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
                                    int read = inputStream.read(c.this.blt);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.ax(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.bln) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.blt, 0, read);
                                    } else {
                                        c.this.blu = read;
                                    }
                                    c.this.bli += read;
                                    i5 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.blu != 0) {
                                            synchronized (c.this.blv) {
                                                try {
                                                    c.this.blv.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.bln) {
                                                break;
                                            }
                                        }
                                        if (c.this.bln) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new an("c12027").ae("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ae("error", e11.getMessage()).r("dsize", i5).ae("url", c.this.bdb));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.blj = 0L;
                            v.p(c.this.bdb, i5, (int) c.this.aBO);
                            j.ax(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.Qt().j(inputStream);
                            c.this.blq = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new an("c12027").ae("errormsg", "连接中断，文件下载出现异常").ae("error", e12.getMessage()).ae("url", c.this.bdb));
                            j.ax(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.ax(c.TAG, "download out " + c.this);
                    while (c.this.blh < c.this.bli && !c.this.bln) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.bln) {
                            break;
                        }
                    }
                    if (c.this.blj > 0 && c.this.blj <= 3) {
                        j.ax(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.blq);
                        c.this.blq = c.this.blh - 1;
                        j.ax(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.blq);
                    }
                    if (c.this.bln) {
                        break;
                    }
                    long j9 = c.this.blh;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length && !c.this.bln; i7++) {
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.blr) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.ax(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long h2 = m.h(file5);
                                if ((Integer.parseInt(file5.getName()) + h2) - 1 < j9 && (i6 = (int) (i6 + h2)) > 31457280) {
                                    c.this.blr = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.ax(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.ax(c.TAG, "mLastRequestRangeEnd " + c.this.blq + " mReadPosition " + c.this.blh + "  " + c.this);
                    if (c.this.blq == -1 || c.this.blh <= c.this.blq || c.this.blq >= c.this.blf) {
                        break;
                    }
                    try {
                        if (c.this.blm != null) {
                            c.this.blm.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.blp = false;
                    c.this.blg = c.this.blq + 1;
                    j.ax(c.TAG, "continue to download... " + c.this);
                } else {
                    j.ax(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.Qk().x(c.this);
            j.ax(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] blt = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.blj;
        cVar.blj = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.bdb = str;
    }

    public void W(long j) {
        this.aBO = j;
    }

    public void d(long j, long j2) {
        j.ax(TAG, "open *************************************************************" + this);
        if (this.bdb != null) {
            this.ble = j;
            this.blf = j2;
            this.bls = m.iq(this.bdb);
            if (this.bls != null) {
                File file = new File(i.blQ + this.bls);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.blo = file2.getAbsolutePath();
                    this.bli = this.ble;
                    this.blh = this.ble;
                    this.blg = this.ble;
                    this.bln = false;
                    this.blp = false;
                    this.blq = -1L;
                    this.blr = false;
                    l.Qu().e(this.blw);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.bdb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Qg() {
        if (m.ip(this.bls) > this.aBO) {
            m.y(new File(i.blQ + this.bls + "/segments"));
            TiebaStatic.log(new an("c12028").ae("errormsg", "校验到缓存文件片段大小有异常").ae("url", this.bdb));
            j.ax(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void aA(long j) {
        if (j == -1) {
            j.ax(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.bll = true;
        } else if (j == 0 && this.bll) {
            j.ax(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.blk = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Qh() {
        if (!this.bll || this.blk != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.ax(TAG, "close ***********************************************************************" + this);
        this.bln = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.blm != null) {
                this.blm.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.blQ + this.bls + "/completed");
        if (this.blr) {
            return;
        }
        if (file == null || !file.exists()) {
            k.Qt().in(this.bdb);
        }
    }

    public boolean canRead() {
        return !this.bln && this.blh <= this.blf;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.bln) {
            return 0;
        }
        do {
            if (this.blh == this.bli || !this.blp) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.blh + ((long) i) < this.bli ? i : this.bli - this.blh);
                try {
                    if (this.blm == null) {
                        if (this.blu > 0) {
                            System.arraycopy(this.blt, 0, bArr, 0, (int) this.blu);
                            read = (int) this.blu;
                            this.blu = 0L;
                            synchronized (this.blv) {
                                this.blv.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.blm.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.blh += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.bln);
        return 0;
    }
}
