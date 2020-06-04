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
/* loaded from: classes9.dex */
public class b implements i {
    public static final String TAG = b.class.getSimpleName();
    private static b eMI;
    private int mPort = 0;

    private b() {
        a.blN();
    }

    public static b blP() {
        if (eMI == null) {
            synchronized (b.class) {
                if (eMI == null) {
                    eMI = new b();
                }
            }
        }
        return eMI;
    }

    private static long blL() {
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

    private boolean blQ() {
        d.D(TAG, "sdcard avalible size " + ((blL() / 1024) / 1024) + "M");
        return blL() > 314572800 && getPort() > 0;
    }

    public void eg(Context context) {
        if (context != null) {
            e.eh(context).bkX();
        }
    }

    @Override // com.baidu.tieba.play.i
    public String zB(String str) {
        if (blQ()) {
            String zC = zC(str);
            if (zC == null) {
                String zz = zz(str);
                if (zz != null && new File(c.eMv + zz + "/header_downloaded").exists()) {
                    return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                }
                return str;
            }
            return zC;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String ao(String str, boolean z) {
        if (blQ()) {
            String zC = zC(str);
            if (zC == null) {
                String zz = zz(str);
                if (zz != null) {
                    if (z) {
                        return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                    }
                    if (new File(c.eMv + zz + "/header_downloaded").exists()) {
                        return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                    }
                    return str;
                }
                return str;
            }
            return zC;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String zC(String str) {
        String zz;
        File file;
        if (str == null || !str.contains("/") || (zz = zz(str)) == null || (file = new File(c.eMv + zz + "/completed")) == null || !file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @Override // com.baidu.tieba.play.i
    public void d(Context context, String str, int i) {
        e.eh(context).aq(str, i);
    }

    @Override // com.baidu.tieba.play.i
    public void aq(Context context, String str) {
        e.eh(context).zF(str);
    }

    @Override // com.baidu.tieba.play.i
    public void ar(Context context, String str) {
        e.eh(context).zG(str);
    }

    @Override // com.baidu.tieba.play.i
    public void zD(String str) {
        a.blN().zA(str);
    }

    @Override // com.baidu.tieba.play.i
    public void clearCache(Context context) {
        e.eh(context).clearCache();
    }

    public static String zz(String str) {
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
            File file = new File(c.eMw);
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

    public void blR() {
        this.mPort = 0;
    }

    @Override // com.baidu.tieba.play.i
    public String zE(String str) {
        return com.baidu.tieba.VideoCache.i.eMv + zz(str);
    }
}
