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
/* loaded from: classes2.dex */
public class b implements i {
    public static final String TAG = b.class.getSimpleName();
    private static b brR;
    private int brS = 0;

    private b() {
        a.Sl();
    }

    public static b Sn() {
        if (brR == null) {
            synchronized (b.class) {
                if (brR == null) {
                    brR = new b();
                }
            }
        }
        return brR;
    }

    private static long Sj() {
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

    private boolean So() {
        d.aF(TAG, "sdcard avalible size " + ((Sj() / 1024) / 1024) + "M");
        return Sj() > 314572800 && getPort() > 0;
    }

    public void bQ(Context context) {
        if (context != null) {
            e.bR(context).Rv();
        }
    }

    @Override // com.baidu.tieba.play.i
    public String iT(String str) {
        if (So()) {
            String iU = iU(str);
            if (iU == null) {
                String iR = iR(str);
                if (iR != null && new File(c.brE + iR + "/header_downloaded").exists()) {
                    return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                }
                return str;
            }
            return iU;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String o(String str, boolean z) {
        if (So()) {
            String iU = iU(str);
            if (iU == null) {
                String iR = iR(str);
                if (iR != null) {
                    if (z) {
                        return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                    }
                    if (new File(c.brE + iR + "/header_downloaded").exists()) {
                        return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                    }
                    return str;
                }
                return str;
            }
            return iU;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String iU(String str) {
        String iR;
        File file;
        if (str == null || !str.contains("/") || (iR = iR(str)) == null || (file = new File(c.brE + iR + "/completed")) == null || !file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @Override // com.baidu.tieba.play.i
    public void g(Context context, String str, int i) {
        e.bR(context).J(str, i);
    }

    @Override // com.baidu.tieba.play.i
    public void ar(Context context, String str) {
        e.bR(context).iX(str);
    }

    @Override // com.baidu.tieba.play.i
    public void as(Context context, String str) {
        e.bR(context).iY(str);
    }

    @Override // com.baidu.tieba.play.i
    public void iV(String str) {
        a.Sl().iS(str);
    }

    @Override // com.baidu.tieba.play.i
    public void clearCache(Context context) {
        e.bR(context).clearCache();
    }

    public static String iR(String str) {
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
        if (this.brS == 0) {
            File file = new File(c.brF);
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
                                return this.brS;
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
        return this.brS;
    }

    public void Sp() {
        this.brS = 0;
    }

    @Override // com.baidu.tieba.play.i
    public String iW(String str) {
        return com.baidu.tieba.VideoCache.i.brE + iR(str);
    }
}
