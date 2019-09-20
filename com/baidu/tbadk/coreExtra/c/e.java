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
    public static final String cmi = m.Dz + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int bMX;
    public String clE;
    public Bundle clH;
    public String clK;
    public String clL;
    public int clR;
    public String clS;
    public String clT;
    public String clU;
    private Bundle clW;
    public String cmb;
    public String cmf;
    public int cmg;
    public String cmh;
    public String fid;
    public String imageUrl;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String topic;
    public String uid;
    public boolean cls = false;
    public boolean clt = false;
    public boolean clu = false;
    public boolean clv = false;
    public boolean clw = false;
    public boolean clx = false;
    public boolean cly = false;
    public boolean clz = false;
    public boolean clA = false;
    public boolean clB = false;
    public boolean clC = false;
    public String clD = "";
    public int clM = 0;
    public int clN = 3;
    public int clO = 0;
    public int clP = 0;
    public int clQ = 0;
    public int shareType = 0;
    public boolean clX = true;
    public boolean clY = true;
    public boolean clZ = true;
    public int cma = 0;
    public boolean cmc = true;
    public boolean cme = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String clF = null;
    public Uri imageUri = null;
    public Location clI = null;
    private WeakReference<Bitmap> clV = null;
    public String clJ = null;
    public String extData = null;
    public String clG = null;

    public Bundle aqk() {
        return this.clW;
    }

    public void E(Bundle bundle) {
        this.clW = bundle;
    }

    public Bitmap aql() {
        Bitmap bitmap;
        if (this.clV == null || (bitmap = this.clV.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void n(Bitmap bitmap) {
        this.clV = new WeakReference<>(bitmap);
    }

    public byte[] aqm() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.clV == null || (bitmap = this.clV.get()) == null || bitmap.isRecycled()) {
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
    public void aqn() {
        FileOutputStream fileOutputStream = null;
        if (this.clV == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.gB()) {
                    File file = new File(cmi);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] aqm = aqm();
                    if (aqm != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(aqm);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.clV = null;
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
