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
    private static b bPy;
    private int bPz = 0;

    private b() {
        a.Tv();
    }

    public static b Ty() {
        if (bPy == null) {
            synchronized (b.class) {
                if (bPy == null) {
                    bPy = new b();
                }
            }
        }
        return bPy;
    }

    private static long Tt() {
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

    private boolean Tz() {
        d.au(TAG, "sdcard avalible size " + ((Tt() / 1024) / 1024) + "M");
        return Tt() > 314572800 && getPort() > 0;
    }

    public void br(Context context) {
        if (context != null) {
            e.bt(context).SI();
        }
    }

    @Override // com.baidu.tieba.play.i
    public String hE(String str) {
        if (Tz()) {
            String hF = hF(str);
            if (hF == null) {
                String hC = hC(str);
                if (hC != null && new File(c.bPk + hC + "/header_downloaded").exists()) {
                    return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                }
                return str;
            }
            return hF;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String r(String str, boolean z) {
        if (Tz()) {
            String hF = hF(str);
            if (hF == null) {
                String hC = hC(str);
                if (hC != null) {
                    if (z) {
                        return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                    }
                    if (new File(c.bPk + hC + "/header_downloaded").exists()) {
                        return "http://127.0.0.1:" + getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str);
                    }
                    return str;
                }
                return str;
            }
            return hF;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.i
    public String hF(String str) {
        String hC;
        File file;
        if (str == null || !str.contains("/") || (hC = hC(str)) == null || (file = new File(c.bPk + hC + "/completed")) == null || !file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @Override // com.baidu.tieba.play.i
    public void f(Context context, String str, int i) {
        e.bt(context).J(str, i);
    }

    @Override // com.baidu.tieba.play.i
    public void ad(Context context, String str) {
        e.bt(context).hH(str);
    }

    @Override // com.baidu.tieba.play.i
    public void ae(Context context, String str) {
        e.bt(context).hI(str);
    }

    @Override // com.baidu.tieba.play.i
    public void hG(String str) {
        a.Tv().hD(str);
    }

    @Override // com.baidu.tieba.play.i
    public void bs(Context context) {
        e.bt(context).clearCache();
    }

    public static String hC(String str) {
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
        if (this.bPz == 0) {
            File file = new File(c.bPl);
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
                                return this.bPz;
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
        return this.bPz;
    }

    public void TA() {
        this.bPz = 0;
    }
}
