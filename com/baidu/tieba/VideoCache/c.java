package com.baidu.tieba.VideoCache;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes6.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private String aAy;
    private long bvc;
    private long bvd;
    private long bve;
    private long bvf;
    private long bvg;
    private FileInputStream bvk;
    private String bvp;
    private long bvr;
    private Context mContext;
    private long bvh = 0;
    private long bvi = -1;
    private boolean bvj = false;
    private boolean bvl = false;
    private String aAA = "";
    private Object mLock = new Object();
    private boolean bvm = false;
    private long bvn = -1;
    boolean bvo = false;
    private Object bvs = new Object();
    private long aJx = 0;
    private Runnable bvt = new Runnable() { // from class: com.baidu.tieba.VideoCache.c.1
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
            j.log(c.TAG, "test run in " + c.this);
            while (e.TU().y(c.this)) {
                e.TU().iU(c.this.aAy);
                try {
                    j.log(c.TAG, "mDownloadRunnable sleep in..." + c.this);
                    Thread.sleep(100L);
                    j.log(c.TAG, "mDownloadRunnable sleep out..." + c.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.this.bvl) {
                    break;
                }
            }
            if (!c.this.bvl) {
                e.TU().w(c.this);
            }
            while (true) {
                if (c.this.bvl) {
                    break;
                }
                j.log(c.TAG, "download in " + c.this);
                if (c.this.TQ()) {
                    break;
                }
                c.this.bvn = -1L;
                File file2 = new File(c.this.aAA);
                long j6 = c.this.bve;
                long j7 = c.this.bvd;
                File[] listFiles = file2.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (c.this.bvl) {
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
                if (c.this.bvl) {
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
                    j.log(c.TAG, "file name:" + fileArr[i2].getName() + " size:" + fileArr[i2].length() + " " + c.this);
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
                            if (c.this.bvl) {
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
                                j.log(c.TAG, "file size " + n);
                                long j8 = (parseInt2 + n) - 1;
                                if (c.this.bve >= parseInt2 && c.this.bve <= j8) {
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
                            if (!c.this.bvl) {
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
                if (c.this.bvl) {
                    break;
                }
                j.log(c.TAG, "total range is " + c.this.bve + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c.this.bvd + " " + c.this);
                j.log(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " " + c.this);
                boolean z2 = false;
                if (file == null) {
                    String str3 = c.this.aAA + "/" + c.this.bve;
                    try {
                        new File(str3).createNewFile();
                        str = str3;
                    } catch (IOException e5) {
                        TiebaStatic.log(new am("c12027").ax("errormsg", "创建缓存文件出现异常").ax("name", str3).ax(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e5.getMessage()).ax("url", c.this.aAy));
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
                        c.this.bvk = new FileInputStream(str2);
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    c.this.bvk = null;
                }
                if (file != null) {
                    try {
                        if (c.this.bvk != null) {
                            c.this.bvk.skip(c.this.bve - j);
                        }
                        j.log(c.TAG, "skip: " + (c.this.bve - j) + " " + c.this);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (file != null) {
                    j.log(c.TAG, "hit file: rangeStart " + j + " rangeEnd " + ((j + j3) - 1) + " " + c.this);
                    c.this.bvg = j + j3;
                } else {
                    j.log(c.TAG, "hit file: null " + c.this);
                }
                j.log(c.TAG, "first mReadPosition " + c.this.bvf + " first writeposition " + c.this.bvg + " " + c.this);
                c.this.bvm = true;
                synchronized (c.this.mLock) {
                    c.this.mLock.notify();
                }
                if (file == null || j6 <= c.this.bvd) {
                    if (c.this.bvl) {
                        break;
                    }
                    j.log(c.TAG, "download range is " + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                    if (j6 > j4 || z2) {
                        c.this.bvn = (j + j3) - 1;
                    } else {
                        try {
                            j.log(c.TAG, "download start waitting ...... ");
                            while (c.this.TR()) {
                                try {
                                    Thread.sleep(20L);
                                } catch (InterruptedException e8) {
                                    e8.printStackTrace();
                                }
                                if (c.this.bvl) {
                                    break;
                                }
                            }
                            c.this.bvi = -1L;
                            URL url = new URL(c.this.aAy);
                            j.log(c.TAG, "url opt 1 " + c.this);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            j.log(c.TAG, "url opt 2 " + c.this);
                            httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j4);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setReadTimeout(5000);
                            j.log(c.TAG, "url opt 3 " + c.this);
                            InputStream inputStream = httpURLConnection.getInputStream();
                            while (inputStream == null) {
                                j.log(c.TAG, "conn input is null " + c.this);
                                if (c.this.bvl) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                } catch (InterruptedException e9) {
                                    e9.printStackTrace();
                                }
                                inputStream = httpURLConnection.getInputStream();
                            }
                            j.log(c.TAG, "got conn input " + c.this);
                            j.log(c.TAG, "url opt 4 " + c.this);
                            int i5 = 0;
                            if (str2 == null) {
                                fileOutputStream = null;
                            } else {
                                fileOutputStream = new FileOutputStream(str2, true);
                            }
                            j.log(c.TAG, "read start ..." + c.this);
                            while (true) {
                                try {
                                    int read = inputStream.read(c.this.bvq);
                                    if (read == -1) {
                                        break;
                                    }
                                    j.log(c.TAG, "read length " + read + " " + c.this);
                                    if (c.this.bvl) {
                                        break;
                                    }
                                    if (str2 != null) {
                                        fileOutputStream.write(c.this.bvq, 0, read);
                                    } else {
                                        c.this.bvr = read;
                                    }
                                    c.this.bvg += read;
                                    i5 += read;
                                    synchronized (c.this.mLock) {
                                        c.this.mLock.notify();
                                    }
                                    if (str2 == null) {
                                        while (c.this.bvr != 0) {
                                            synchronized (c.this.bvs) {
                                                try {
                                                    c.this.bvs.wait(100L);
                                                } catch (InterruptedException e10) {
                                                    e10.printStackTrace();
                                                }
                                            }
                                            if (c.this.bvl) {
                                                break;
                                            }
                                        }
                                        if (c.this.bvl) {
                                            break;
                                        }
                                    }
                                } catch (Exception e11) {
                                    TiebaStatic.log(new am("c12027").ax("errormsg", "下载文件出现异常，网络文件流读取数据出现异常").ax(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e11.getMessage()).x("dsize", i5).ax("url", c.this.aAy));
                                    e11.printStackTrace();
                                    c.p(c.this);
                                }
                            }
                            c.this.bvh = 0L;
                            w.v(c.this.aAy, i5, (int) c.this.aJx);
                            j.log(c.TAG, "read end ..." + c.this);
                            if (str2 != null) {
                                fileOutputStream.close();
                            }
                            k.Ud().l(inputStream);
                            c.this.bvn = j4;
                        } catch (Exception e12) {
                            TiebaStatic.log(new am("c12027").ax("errormsg", "连接中断，文件下载出现异常").ax(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e12.getMessage()).ax("url", c.this.aAy));
                            j.log(c.TAG, "download exception " + c.this);
                            e12.printStackTrace();
                        }
                    }
                    j.log(c.TAG, "download out " + c.this);
                    while (c.this.bvf < c.this.bvg && !c.this.bvl) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e13) {
                            e13.printStackTrace();
                        }
                        if (c.this.bvl) {
                            break;
                        }
                    }
                    if (c.this.bvh > 0 && c.this.bvh <= 3) {
                        j.log(c.TAG, "exception  want mLastRequestRangeEnd =  " + c.this.bvn);
                        c.this.bvn = c.this.bvf - 1;
                        j.log(c.TAG, "exception  but mLastRequestRangeEnd =  " + c.this.bvn);
                    }
                    if (c.this.bvl) {
                        break;
                    }
                    long j9 = c.this.bvf;
                    int i6 = 0;
                    for (int i7 = 0; i7 < fileArr.length && !c.this.bvl; i7++) {
                        int length2 = (fileArr.length - 1) - i7;
                        File file5 = fileArr[length2];
                        if (file5 != null && file5.exists()) {
                            if (c.this.bvo) {
                                if (length2 != 0) {
                                    file5.delete();
                                    j.log(c.TAG, "release some cached slices " + c.this);
                                }
                            } else {
                                long n2 = m.n(file5);
                                if ((Integer.parseInt(file5.getName()) + n2) - 1 < j9 && (i6 = (int) (i6 + n2)) > 31457280) {
                                    c.this.bvo = true;
                                    if (length2 != 0) {
                                        file5.delete();
                                        j.log(c.TAG, "release some cached slices " + c.this);
                                    }
                                }
                            }
                        }
                    }
                    j.log(c.TAG, "mLastRequestRangeEnd " + c.this.bvn + " mReadPosition " + c.this.bvf + "  " + c.this);
                    if (c.this.bvn == -1 || c.this.bvf <= c.this.bvn || c.this.bvn >= c.this.bvd) {
                        break;
                    }
                    try {
                        if (c.this.bvk != null) {
                            c.this.bvk.close();
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    c.this.bvm = false;
                    c.this.bve = c.this.bvn + 1;
                    j.log(c.TAG, "continue to download... " + c.this);
                } else {
                    j.log(c.TAG, "do not download, return " + c.this);
                    break;
                }
            }
            e.TU().x(c.this);
            j.log(c.TAG, "test run out ***************************************************************" + c.this);
        }
    };
    private byte[] bvq = new byte[10240];

    static /* synthetic */ long p(c cVar) {
        long j = cVar.bvh;
        cVar.bvh = 1 + j;
        return j;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aAy = str;
    }

    public void ac(long j) {
        this.aJx = j;
    }

    public void d(long j, long j2) {
        j.log(TAG, "open *************************************************************" + this);
        if (this.aAy != null) {
            this.bvc = j;
            this.bvd = j2;
            this.bvp = m.je(this.aAy);
            if (this.bvp != null) {
                File file = new File(i.bvM + this.bvp);
                File file2 = new File(file.getAbsolutePath() + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aAA = file2.getAbsolutePath();
                    this.bvg = this.bvc;
                    this.bvf = this.bvc;
                    this.bve = this.bvc;
                    this.bvl = false;
                    this.bvm = false;
                    this.bvn = -1L;
                    this.bvo = false;
                    l.Ue().e(this.bvt);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aAy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TQ() {
        if (m.jd(this.bvp) > this.aJx) {
            m.E(new File(i.bvM + this.bvp + "/segments"));
            TiebaStatic.log(new am("c12028").ax("errormsg", "校验到缓存文件片段大小有异常").ax("url", this.aAy));
            j.log(TAG, "cache error !");
            return true;
        }
        return false;
    }

    public void aG(long j) {
        if (j == -1) {
            j.log(TAG, "notifyDownloadSegment  mStepByStepDownload = true ###### " + this);
            this.bvj = true;
        } else if (j == 0 && this.bvj) {
            j.log(TAG, "notifyDownloadSegment  mNextSemgmentEndPosition = 0 ------ " + this);
            this.bvi = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TR() {
        if (!this.bvj || this.bvi != -1) {
            return false;
        }
        return true;
    }

    public void close() {
        j.log(TAG, "close ***********************************************************************" + this);
        this.bvl = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.bvk != null) {
                this.bvk.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(i.bvM + this.bvp + "/completed");
        if (this.bvo) {
            return;
        }
        if (file == null || !file.exists()) {
            k.Ud().jb(this.aAy);
        }
    }

    public boolean canRead() {
        return !this.bvl && this.bvf <= this.bvd;
    }

    public int read(byte[] bArr, int i) {
        int read;
        if (this.bvl) {
            return 0;
        }
        do {
            if (this.bvf == this.bvg || !this.bvm) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.bvf + ((long) i) < this.bvg ? i : this.bvg - this.bvf);
                try {
                    if (this.bvk == null) {
                        if (this.bvr > 0) {
                            System.arraycopy(this.bvq, 0, bArr, 0, (int) this.bvr);
                            read = (int) this.bvr;
                            this.bvr = 0L;
                            synchronized (this.bvs) {
                                this.bvs.notify();
                            }
                        } else {
                            read = 0;
                        }
                    } else {
                        read = this.bvk.read(bArr, 0, i2);
                    }
                    if (read >= 0) {
                        this.bvf += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.bvl);
        return 0;
    }
}
