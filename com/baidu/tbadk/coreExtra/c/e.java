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
    public static final String cjV = m.Dt + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int bLt;
    public Bundle cjA;
    public String cjD;
    public String cjE;
    public int cjK;
    public String cjL;
    public String cjM;
    public String cjN;
    private Bundle cjP;
    public String cjU;
    public String cjx;
    public String fid;
    public String imageUrl;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String topic;
    public String uid;
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
    public boolean cjv = false;
    public String cjw = "";
    public int cjF = 0;
    public int cjG = 3;
    public int cjH = 0;
    public int cjI = 0;
    public int cjJ = 0;
    public int shareType = 0;
    public boolean cjQ = true;
    public boolean cjR = true;
    public boolean cjS = true;
    public int cjT = 0;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String cjy = null;
    public Uri imageUri = null;
    public Location cjB = null;
    private WeakReference<Bitmap> cjO = null;
    public String cjC = null;
    public String extData = null;
    public String cjz = null;

    public Bundle aoQ() {
        return this.cjP;
    }

    public void E(Bundle bundle) {
        this.cjP = bundle;
    }

    public Bitmap aoR() {
        Bitmap bitmap;
        if (this.cjO == null || (bitmap = this.cjO.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void n(Bitmap bitmap) {
        this.cjO = new WeakReference<>(bitmap);
    }

    public byte[] aoS() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.cjO == null || (bitmap = this.cjO.get()) == null || bitmap.isRecycled()) {
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
        if (this.cjO == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.gs()) {
                    File file = new File(cjV);
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
                            this.cjO = null;
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
