package com.baidu.tbadk.coreExtra.c;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    public static final String cjU = m.Du + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int bLs;
    public String cjC;
    public String cjD;
    public int cjJ;
    public String cjK;
    public String cjL;
    public String cjM;
    private Bundle cjO;
    public String cjT;
    public String cjw;
    public Bundle cjz;
    public String fid;
    public String imageUrl;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String topic;
    public String uid;
    public boolean cjk = false;
    public boolean cjl = false;
    public boolean cjm = false;
    public boolean cjn = false;
    public boolean cjo = false;
    public boolean cjp = false;
    public boolean cjq = false;
    public boolean cjr = false;
    public boolean cjs = false;
    public boolean cjt = false;
    public boolean cju = false;
    public String cjv = "";
    public int cjE = 0;
    public int cjF = 3;
    public int cjG = 0;
    public int cjH = 0;
    public int cjI = 0;
    public int shareType = 0;
    public boolean cjP = true;
    public boolean cjQ = true;
    public boolean cjR = true;
    public int cjS = 0;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String cjx = null;
    public Uri imageUri = null;
    public Location cjA = null;
    private WeakReference<Bitmap> cjN = null;
    public String cjB = null;
    public String extData = null;
    public String cjy = null;

    public Bundle aoQ() {
        return this.cjO;
    }

    public void E(Bundle bundle) {
        this.cjO = bundle;
    }

    public Bitmap aoR() {
        Bitmap bitmap;
        if (this.cjN == null || (bitmap = this.cjN.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void n(Bitmap bitmap) {
        this.cjN = new WeakReference<>(bitmap);
    }

    public byte[] aoS() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.cjN == null || (bitmap = this.cjN.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream)) {
            bArr = null;
        } else {
            bArr = byteArrayOutputStream.toByteArray();
        }
        try {
            byteArrayOutputStream.close();
            return bArr;
        } catch (IOException e) {
            return bArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [240=4, 241=4, 243=4, 244=4] */
    public void aoT() {
        FileOutputStream fileOutputStream = null;
        if (this.cjN == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.gs()) {
                    File file = new File(cjU);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] aoS = aoS();
                    if (aoS != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(aoS);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.cjN = null;
                            if (fileOutputStream3 != null) {
                                try {
                                    fileOutputStream3.close();
                                    return;
                                } catch (IOException e) {
                                    BdLog.e(e.toString());
                                    return;
                                }
                            }
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream3;
                            BdLog.e(e.toString());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return;
                                } catch (IOException e3) {
                                    BdLog.e(e3.toString());
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream3;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    BdLog.e(e4.toString());
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        BdLog.e(e5.toString());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }
}
