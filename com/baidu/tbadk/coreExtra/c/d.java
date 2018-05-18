package com.baidu.tbadk.coreExtra.c;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.k;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    public static final String axk = k.wA + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public int abV;
    public String awU;
    public String awZ;
    public String axa;
    public int axd;
    private Bundle axg;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String price;
    public String tid;
    public String uid;
    public boolean awM = false;
    public boolean awN = false;
    public boolean awO = false;
    public boolean awP = false;
    public boolean awQ = false;
    public boolean awR = false;
    public boolean awS = false;
    public String awT = "";
    public int axb = 0;
    public int axc = 3;
    public boolean axe = false;
    public boolean axh = true;
    public boolean axi = true;
    public boolean axj = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String awV = null;
    public Uri awW = null;
    public Location awX = null;
    private WeakReference<Bitmap> axf = null;
    public String awY = null;
    public String extData = null;

    public Bundle BJ() {
        return this.axg;
    }

    public void f(Bundle bundle) {
        this.axg = bundle;
    }

    public Bitmap BK() {
        Bitmap bitmap;
        if (this.axf == null || (bitmap = this.axf.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void g(Bitmap bitmap) {
        this.axf = new WeakReference<>(bitmap);
    }

    public byte[] BL() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.axf == null || (bitmap = this.axf.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [204=4, 205=4, 207=4, 208=4] */
    public void BM() {
        FileOutputStream fileOutputStream = null;
        if (this.axf == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (k.m15do()) {
                    File file = new File(axk);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] BL = BL();
                    if (BL != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(BL);
                            fileOutputStream3.close();
                            this.awW = Uri.fromFile(file);
                            this.axf = null;
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
