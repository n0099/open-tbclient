package com.baidu.tieba.VideoCacheClient;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.tieba.VideoCache.VideoCacheService;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.play.e {
    public static final String TAG = c.class.getSimpleName();
    private static c aNC;
    private int aND = 0;

    private c() {
        a.JK();
    }

    public static c JM() {
        if (aNC == null) {
            synchronized (c.class) {
                if (aNC == null) {
                    aNC = new c();
                }
            }
        }
        return aNC;
    }

    private static long JI() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return 0L;
    }

    private boolean JN() {
        e.log(TAG, "sdcard avalible size " + ((JI() / 1024) / 1024) + "M");
        return JI() > 314572800 && getPort() > 0;
    }

    @Override // com.baidu.tieba.play.e
    public void aw(Context context) {
        if (context != null) {
            context.startService(new Intent(context, VideoCacheService.class));
        }
    }

    @Override // com.baidu.tieba.play.e
    public String gZ(String str) {
        if (JN()) {
            String ha = ha(str);
            if (ha == null) {
                String gX = gX(str);
                if (gX != null && new File(String.valueOf(d.aNl) + gX + "/header_downloaded").exists()) {
                    return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                }
                return str;
            }
            return ha;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.e
    public String ha(String str) {
        String gX;
        File file;
        if (str == null || !str.contains("/") || (gX = gX(str)) == null || (file = new File(String.valueOf(d.aNl) + gX + "/completed")) == null || !file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @Override // com.baidu.tieba.play.e
    public void G(Context context, String str) {
        f.ay(context).hc(str);
    }

    @Override // com.baidu.tieba.play.e
    public void H(Context context, String str) {
        f.ay(context).hd(str);
    }

    @Override // com.baidu.tieba.play.e
    public void hb(String str) {
        a.JK().gY(str);
    }

    @Override // com.baidu.tieba.play.e
    public void ax(Context context) {
        f.ay(context).clearCache();
    }

    public static String gX(String str) {
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
        if (this.aND == 0) {
            File file = new File(d.aNm);
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
                                return this.aND;
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
        return this.aND;
    }

    public void JO() {
        this.aND = 0;
    }
}
