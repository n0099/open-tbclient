package com.baidu.tieba.VideoCacheClient;

import android.content.Context;
import android.os.StatFs;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.play.i;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class b implements i {
    public static final String TAG = b.class.getSimpleName();
    private static b cMe;
    private int mPort = 0;

    private b() {
        a.avV();
    }

    public static b avX() {
        if (cMe == null) {
            synchronized (b.class) {
                if (cMe == null) {
                    cMe = new b();
                }
            }
        }
        return cMe;
    }

    private static long avT() {
        try {
            File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
            if (cacheDir != null && cacheDir.exists() && cacheDir.canRead() && cacheDir.canWrite()) {
                StatFs statFs = new StatFs(cacheDir.getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private boolean avY() {
        d.as(TAG, "sdcard avalible size " + ((avT() / 1024) / 1024) + "M");
        return avT() > 314572800 && getPort() > 0;
    }

    public void dq(Context context) {
        if (context != null) {
            e.dr(context).ave();
        }
    }

    @Override // com.baidu.tieba.play.i
    public String qD(String str) {
        if (avY()) {
            String qE = qE(str);
            if (qE == null) {
                String qB = qB(str);
                if (qB != null && new File(c.cLR + qB + "/header_downloaded").exists()) {
                    return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                }
                return str;
            }
            return qE;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String R(String str, boolean z) {
        if (avY()) {
            String qE = qE(str);
            if (qE == null) {
                String qB = qB(str);
                if (qB != null) {
                    if (z) {
                        return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                    }
                    if (new File(c.cLR + qB + "/header_downloaded").exists()) {
                        return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                    }
                    return str;
                }
                return str;
            }
            return qE;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String qE(String str) {
        String qB;
        File file;
        if (str == null || !str.contains("/") || (qB = qB(str)) == null || (file = new File(c.cLR + qB + "/completed")) == null || !file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @Override // com.baidu.tieba.play.i
    public void g(Context context, String str, int i) {
        e.dr(context).ai(str, i);
    }

    @Override // com.baidu.tieba.play.i
    public void aE(Context context, String str) {
        e.dr(context).qH(str);
    }

    @Override // com.baidu.tieba.play.i
    public void aF(Context context, String str) {
        e.dr(context).qI(str);
    }

    @Override // com.baidu.tieba.play.i
    public void qF(String str) {
        a.avV().qC(str);
    }

    @Override // com.baidu.tieba.play.i
    public void clearCache(Context context) {
        e.dr(context).clearCache();
    }

    public static String qB(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getPort() {
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        dataInputStream2 = null;
        FileInputStream fileInputStream2 = null;
        if (this.mPort == 0) {
            File file = new File(c.cLS);
            if (file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        dataInputStream = new DataInputStream(fileInputStream);
                        try {
                            int parseInt = Integer.parseInt(dataInputStream.readLine());
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                    return parseInt;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return parseInt;
                                }
                            }
                            return parseInt;
                        } catch (Exception e3) {
                            e = e3;
                            fileInputStream2 = fileInputStream;
                            try {
                                e.printStackTrace();
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (dataInputStream != null) {
                                    try {
                                        dataInputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                return this.mPort;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                dataInputStream2 = dataInputStream;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (dataInputStream2 != null) {
                                    try {
                                        dataInputStream2.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            dataInputStream2 = dataInputStream;
                            if (fileInputStream != null) {
                            }
                            if (dataInputStream2 != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        dataInputStream = null;
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    dataInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = null;
                }
            }
        }
        return this.mPort;
    }

    public void avZ() {
        this.mPort = 0;
    }

    @Override // com.baidu.tieba.play.i
    public String qG(String str) {
        return com.baidu.tieba.VideoCache.i.cLR + qB(str);
    }
}
