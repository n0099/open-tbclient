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
    public static final String clm = m.Dz + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int bMy;
    public String ckJ;
    public Bundle ckM;
    public String ckP;
    public String ckQ;
    public int ckW;
    public String ckX;
    public String ckY;
    public String ckZ;
    private Bundle clb;
    public String clg;
    public String clj;
    public int clk;
    public String cll;
    public String fid;
    public String imageUrl;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String topic;
    public String uid;
    public boolean ckx = false;
    public boolean cky = false;
    public boolean ckz = false;
    public boolean ckA = false;
    public boolean ckB = false;
    public boolean ckC = false;
    public boolean ckD = false;
    public boolean ckE = false;
    public boolean ckF = false;
    public boolean ckG = false;
    public boolean ckH = false;
    public String ckI = "";
    public int ckR = 0;
    public int ckS = 3;
    public int ckT = 0;
    public int ckU = 0;
    public int ckV = 0;
    public int shareType = 0;
    public boolean clc = true;
    public boolean cld = true;
    public boolean cle = true;
    public int clf = 0;
    public boolean clh = true;
    public boolean cli = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String ckK = null;
    public Uri imageUri = null;
    public Location ckN = null;
    private WeakReference<Bitmap> cla = null;
    public String ckO = null;
    public String extData = null;
    public String ckL = null;

    public Bundle apY() {
        return this.clb;
    }

    public void E(Bundle bundle) {
        this.clb = bundle;
    }

    public Bitmap apZ() {
        Bitmap bitmap;
        if (this.cla == null || (bitmap = this.cla.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void n(Bitmap bitmap) {
        this.cla = new WeakReference<>(bitmap);
    }

    public byte[] aqa() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.cla == null || (bitmap = this.cla.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [249=4, 250=4, 252=4, 253=4] */
    public void aqb() {
        FileOutputStream fileOutputStream = null;
        if (this.cla == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.gB()) {
                    File file = new File(clm);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] aqa = aqa();
                    if (aqa != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(aqa);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.cla = null;
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
