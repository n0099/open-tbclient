package com.baidu.tieba.VideoCacheClient;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.tieba.play.v;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class c implements v {
    public static final String TAG = c.class.getSimpleName();
    private static c aQR;
    private int aQS = 0;

    private c() {
        a.La();
    }

    public static c Lc() {
        if (aQR == null) {
            synchronized (c.class) {
                if (aQR == null) {
                    aQR = new c();
                }
            }
        }
        return aQR;
    }

    private static long KY() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return 0L;
    }

    private boolean Ld() {
        e.log(TAG, "sdcard avalible size " + ((KY() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M");
        return KY() > 314572800 && getPort() > 0;
    }

    public void au(Context context) {
        if (context != null) {
            f.aw(context).Jr();
        }
    }

    @Override // com.baidu.tieba.play.v
    public String hh(String str) {
        if (Ld()) {
            String hi = hi(str);
            if (hi == null) {
                String hf = hf(str);
                if (hf != null && new File(String.valueOf(d.aQB) + hf + "/header_downloaded").exists()) {
                    return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                }
                return str;
            }
            return hi;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.v
    public String hi(String str) {
        String hf;
        File file;
        if (str == null || !str.contains("/") || (hf = hf(str)) == null || (file = new File(String.valueOf(d.aQB) + hf + "/completed")) == null || !file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @Override // com.baidu.tieba.play.v
    public void G(Context context, String str) {
        f.aw(context).hk(str);
    }

    @Override // com.baidu.tieba.play.v
    public void H(Context context, String str) {
        f.aw(context).hl(str);
    }

    @Override // com.baidu.tieba.play.v
    public void hj(String str) {
        a.La().hg(str);
    }

    @Override // com.baidu.tieba.play.v
    public void av(Context context) {
        f.aw(context).clearCache();
    }

    public static String hf(String str) {
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
        if (this.aQS == 0) {
            File file = new File(d.aQC);
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
                                return this.aQS;
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
        return this.aQS;
    }

    public void Le() {
        this.aQS = 0;
    }
}
