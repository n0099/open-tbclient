package com.baidu.tieba.VideoCacheClient;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.tieba.play.i;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class b implements i {
    public static final String TAG = b.class.getSimpleName();
    private static b aYx;
    private int aYy = 0;

    private b() {
        a.Lv();
    }

    public static b Ly() {
        if (aYx == null) {
            synchronized (b.class) {
                if (aYx == null) {
                    aYx = new b();
                }
            }
        }
        return aYx;
    }

    private static long Lt() {
        File externalStorageDirectory;
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && externalStorageDirectory.exists() && externalStorageDirectory.canRead() && externalStorageDirectory.canWrite()) {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private boolean Lz() {
        d.au(TAG, "sdcard avalible size " + ((Lt() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M");
        return Lt() > 314572800 && getPort() > 0;
    }

    public void bd(Context context) {
        if (context != null) {
            e.bf(context).KN();
        }
    }

    @Override // com.baidu.tieba.play.i
    public String hB(String str) {
        if (Lz()) {
            String hC = hC(str);
            if (hC == null) {
                String hz = hz(str);
                if (hz != null && new File(c.aYk + hz + "/header_downloaded").exists()) {
                    return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                }
                return str;
            }
            return hC;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String hC(String str) {
        String hz;
        File file;
        if (str == null || !str.contains("/") || (hz = hz(str)) == null || (file = new File(c.aYk + hz + "/completed")) == null || !file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @Override // com.baidu.tieba.play.i
    public void aa(Context context, String str) {
        e.bf(context).hE(str);
    }

    @Override // com.baidu.tieba.play.i
    public void ab(Context context, String str) {
        e.bf(context).hF(str);
    }

    @Override // com.baidu.tieba.play.i
    public void hD(String str) {
        a.Lv().hA(str);
    }

    @Override // com.baidu.tieba.play.i
    public void be(Context context) {
        e.bf(context).clearCache();
    }

    public static String hz(String str) {
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
        if (this.aYy == 0) {
            File file = new File(c.aYl);
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
                                return this.aYy;
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
        return this.aYy;
    }

    public void LA() {
        this.aYy = 0;
    }
}
