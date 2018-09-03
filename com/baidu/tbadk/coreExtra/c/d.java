package com.baidu.tbadk.coreExtra.c;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.l;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    public static final String aGp = l.CD + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public String aGa;
    public String aGe;
    public String aGf;
    public int aGi;
    private Bundle aGl;
    public int ajX;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String uid;
    public boolean aFR = false;
    public boolean aFS = false;
    public boolean aFT = false;
    public boolean aFU = false;
    public boolean aFV = false;
    public boolean aFW = false;
    public boolean aFX = false;
    public boolean aFY = false;
    public String aFZ = "";
    public int aGg = 0;
    public int aGh = 3;
    public boolean aGj = false;
    public boolean aGm = true;
    public boolean aGn = true;
    public boolean aGo = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String aGb = null;
    public Uri imageUri = null;
    public Location aGc = null;
    private WeakReference<Bitmap> aGk = null;
    public String aGd = null;
    public String extData = null;

    public Bundle Fz() {
        return this.aGl;
    }

    public void f(Bundle bundle) {
        this.aGl = bundle;
    }

    public Bitmap FA() {
        Bitmap bitmap;
        if (this.aGk == null || (bitmap = this.aGk.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void f(Bitmap bitmap) {
        this.aGk = new WeakReference<>(bitmap);
    }

    public byte[] FB() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.aGk == null || (bitmap = this.aGk.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4, 199=4, 201=4, 202=4] */
    public void FC() {
        FileOutputStream fileOutputStream = null;
        if (this.aGk == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (l.gd()) {
                    File file = new File(aGp);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] FB = FB();
                    if (FB != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(FB);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.aGk = null;
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
