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
/* loaded from: classes2.dex */
public class b implements i {
    public static final String TAG = b.class.getSimpleName();
    private static b bPF;
    private int bPG = 0;

    private b() {
        a.Tj();
    }

    public static b Tm() {
        if (bPF == null) {
            synchronized (b.class) {
                if (bPF == null) {
                    bPF = new b();
                }
            }
        }
        return bPF;
    }

    private static long Th() {
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

    private boolean Tn() {
        d.au(TAG, "sdcard avalible size " + ((Th() / 1024) / 1024) + "M");
        return Th() > 314572800 && getPort() > 0;
    }

    public void br(Context context) {
        if (context != null) {
            e.bt(context).Sw();
        }
    }

    @Override // com.baidu.tieba.play.i
    public String hF(String str) {
        if (Tn()) {
            String hG = hG(str);
            if (hG == null) {
                String hD = hD(str);
                if (hD != null && new File(c.bPr + hD + "/header_downloaded").exists()) {
                    return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                }
                return str;
            }
            return hG;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String r(String str, boolean z) {
        if (Tn()) {
            String hG = hG(str);
            if (hG == null) {
                String hD = hD(str);
                if (hD != null) {
                    if (z) {
                        return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                    }
                    if (new File(c.bPr + hD + "/header_downloaded").exists()) {
                        return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                    }
                    return str;
                }
                return str;
            }
            return hG;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String hG(String str) {
        String hD;
        File file;
        if (str == null || !str.contains("/") || (hD = hD(str)) == null || (file = new File(c.bPr + hD + "/completed")) == null || !file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @Override // com.baidu.tieba.play.i
    public void f(Context context, String str, int i) {
        e.bt(context).J(str, i);
    }

    @Override // com.baidu.tieba.play.i
    public void ac(Context context, String str) {
        e.bt(context).hI(str);
    }

    @Override // com.baidu.tieba.play.i
    public void ad(Context context, String str) {
        e.bt(context).hJ(str);
    }

    @Override // com.baidu.tieba.play.i
    public void hH(String str) {
        a.Tj().hE(str);
    }

    @Override // com.baidu.tieba.play.i
    public void bs(Context context) {
        e.bt(context).clearCache();
    }

    public static String hD(String str) {
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
        if (this.bPG == 0) {
            File file = new File(c.bPs);
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
                                return this.bPG;
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
        return this.bPG;
    }

    public void To() {
        this.bPG = 0;
    }
}
