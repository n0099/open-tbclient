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
    public static final String clf = m.Dz + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int bMt;
    public String ckC;
    public Bundle ckF;
    public String ckI;
    public String ckJ;
    public int ckP;
    public String ckQ;
    public String ckR;
    public String ckS;
    private Bundle ckU;
    public String ckZ;
    public String clc;
    public int cld;
    public String cle;
    public String fid;
    public String imageUrl;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String topic;
    public String uid;
    public boolean ckq = false;
    public boolean ckr = false;
    public boolean cks = false;
    public boolean ckt = false;
    public boolean cku = false;
    public boolean ckv = false;
    public boolean ckw = false;
    public boolean ckx = false;
    public boolean cky = false;
    public boolean ckz = false;
    public boolean ckA = false;
    public String ckB = "";
    public int ckK = 0;
    public int ckL = 3;
    public int ckM = 0;
    public int ckN = 0;
    public int ckO = 0;
    public int shareType = 0;
    public boolean ckV = true;
    public boolean ckW = true;
    public boolean ckX = true;
    public int ckY = 0;
    public boolean cla = true;
    public boolean clb = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String ckD = null;
    public Uri imageUri = null;
    public Location ckG = null;
    private WeakReference<Bitmap> ckT = null;
    public String ckH = null;
    public String extData = null;
    public String ckE = null;

    public Bundle apW() {
        return this.ckU;
    }

    public void E(Bundle bundle) {
        this.ckU = bundle;
    }

    public Bitmap apX() {
        Bitmap bitmap;
        if (this.ckT == null || (bitmap = this.ckT.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void n(Bitmap bitmap) {
        this.ckT = new WeakReference<>(bitmap);
    }

    public byte[] apY() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.ckT == null || (bitmap = this.ckT.get()) == null || bitmap.isRecycled()) {
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
    public void apZ() {
        FileOutputStream fileOutputStream = null;
        if (this.ckT == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.gB()) {
                    File file = new File(clf);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] apY = apY();
                    if (apY != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(apY);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.ckT = null;
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
