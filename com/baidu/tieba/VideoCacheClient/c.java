package com.baidu.tieba.VideoCacheClient;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.tieba.play.x;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class c implements x {
    public static final String TAG = c.class.getSimpleName();
    private static c aUW;
    private int aUX = 0;

    private c() {
        a.Ln();
    }

    public static c Lp() {
        if (aUW == null) {
            synchronized (c.class) {
                if (aUW == null) {
                    aUW = new c();
                }
            }
        }
        return aUW;
    }

    private static long Ll() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return 0L;
    }

    private boolean Lq() {
        e.log(TAG, "sdcard avalible size " + ((Ll() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M");
        return Ll() > 314572800 && getPort() > 0;
    }

    public void aS(Context context) {
        if (context != null) {
            f.aU(context).JE();
        }
    }

    @Override // com.baidu.tieba.play.x
    public String gS(String str) {
        if (Lq()) {
            String gT = gT(str);
            if (gT == null) {
                String gQ = gQ(str);
                if (gQ != null && new File(String.valueOf(d.aUH) + gQ + "/header_downloaded").exists()) {
                    return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                }
                return str;
            }
            return gT;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.x
    public String gT(String str) {
        String gQ;
        File file;
        if (str == null || !str.contains("/") || (gQ = gQ(str)) == null || (file = new File(String.valueOf(d.aUH) + gQ + "/completed")) == null || !file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @Override // com.baidu.tieba.play.x
    public void aa(Context context, String str) {
        f.aU(context).gV(str);
    }

    @Override // com.baidu.tieba.play.x
    public void ab(Context context, String str) {
        f.aU(context).gW(str);
    }

    @Override // com.baidu.tieba.play.x
    public void gU(String str) {
        a.Ln().gR(str);
    }

    @Override // com.baidu.tieba.play.x
    public void aT(Context context) {
        f.aU(context).clearCache();
    }

    public static String gQ(String str) {
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
        if (this.aUX == 0) {
            File file = new File(d.aUI);
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
                                return this.aUX;
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
        return this.aUX;
    }

    public void Lr() {
        this.aUX = 0;
    }
}
