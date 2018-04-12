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
    public static final String axj = k.wB + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public int abU;
    public String awT;
    public String awY;
    public String awZ;
    public int axc;
    private Bundle axf;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String price;
    public String tid;
    public String uid;
    public boolean awL = false;
    public boolean awM = false;
    public boolean awN = false;
    public boolean awO = false;
    public boolean awP = false;
    public boolean awQ = false;
    public boolean awR = false;
    public String awS = "";
    public int axa = 0;
    public int axb = 3;
    public boolean axd = false;
    public boolean axg = true;
    public boolean axh = true;
    public boolean axi = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String awU = null;
    public Uri awV = null;
    public Location awW = null;
    private WeakReference<Bitmap> axe = null;
    public String awX = null;
    public String extData = null;

    public Bundle BL() {
        return this.axf;
    }

    public void f(Bundle bundle) {
        this.axf = bundle;
    }

    public Bitmap BM() {
        Bitmap bitmap;
        if (this.axe == null || (bitmap = this.axe.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void g(Bitmap bitmap) {
        this.axe = new WeakReference<>(bitmap);
    }

    public byte[] BN() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.axe == null || (bitmap = this.axe.get()) == null || bitmap.isRecycled()) {
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
    public void BO() {
        FileOutputStream fileOutputStream = null;
        if (this.axe == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (k.m15do()) {
                    File file = new File(axj);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] BN = BN();
                    if (BN != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(BN);
                            fileOutputStream3.close();
                            this.awV = Uri.fromFile(file);
                            this.axe = null;
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
