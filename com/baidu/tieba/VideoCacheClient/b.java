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
/* loaded from: classes6.dex */
public class b implements i {
    public static final String TAG = b.class.getSimpleName();
    private static b bwK;
    private int mPort = 0;

    private b() {
        a.Uq();
    }

    public static b Us() {
        if (bwK == null) {
            synchronized (b.class) {
                if (bwK == null) {
                    bwK = new b();
                }
            }
        }
        return bwK;
    }

    private static long Uo() {
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

    private boolean Ut() {
        d.log(TAG, "sdcard avalible size " + ((Uo() / 1024) / 1024) + "M");
        return Uo() > 314572800 && getPort() > 0;
    }

    public void bV(Context context) {
        if (context != null) {
            e.bW(context).TA();
        }
    }

    @Override // com.baidu.tieba.play.i
    public String ji(String str) {
        if (Ut()) {
            String jj = jj(str);
            if (jj == null) {
                String jg = jg(str);
                if (jg != null && new File(c.bwx + jg + "/header_downloaded").exists()) {
                    return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                }
                return str;
            }
            return jj;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String v(String str, boolean z) {
        if (Ut()) {
            String jj = jj(str);
            if (jj == null) {
                String jg = jg(str);
                if (jg != null) {
                    if (z) {
                        return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                    }
                    if (new File(c.bwx + jg + "/header_downloaded").exists()) {
                        return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                    }
                    return str;
                }
                return str;
            }
            return jj;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String jj(String str) {
        String jg;
        File file;
        if (str == null || !str.contains("/") || (jg = jg(str)) == null || (file = new File(c.bwx + jg + "/completed")) == null || !file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @Override // com.baidu.tieba.play.i
    public void g(Context context, String str, int i) {
        e.bW(context).K(str, i);
    }

    @Override // com.baidu.tieba.play.i
    public void ap(Context context, String str) {
        e.bW(context).jm(str);
    }

    @Override // com.baidu.tieba.play.i
    public void aq(Context context, String str) {
        e.bW(context).jn(str);
    }

    @Override // com.baidu.tieba.play.i
    public void jk(String str) {
        a.Uq().jh(str);
    }

    @Override // com.baidu.tieba.play.i
    public void clearCache(Context context) {
        e.bW(context).clearCache();
    }

    public static String jg(String str) {
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
            File file = new File(c.bwy);
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

    public void Uu() {
        this.mPort = 0;
    }

    @Override // com.baidu.tieba.play.i
    public String jl(String str) {
        return com.baidu.tieba.VideoCache.i.bwx + jg(str);
    }
}
