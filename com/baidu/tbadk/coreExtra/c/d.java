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
    public static final String aOV = l.FL + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public String aOG;
    public String aOK;
    public String aOL;
    public int aOO;
    private Bundle aOR;
    public int ask;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String uid;
    public boolean aOx = false;
    public boolean aOy = false;
    public boolean aOz = false;
    public boolean aOA = false;
    public boolean aOB = false;
    public boolean aOC = false;
    public boolean aOD = false;
    public boolean aOE = false;
    public String aOF = "";
    public int aOM = 0;
    public int aON = 3;
    public boolean aOP = false;
    public boolean aOS = true;
    public boolean aOT = true;
    public boolean aOU = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String aOH = null;
    public Uri imageUri = null;
    public Location aOI = null;
    private WeakReference<Bitmap> aOQ = null;
    public String aOJ = null;
    public String extData = null;

    public Bundle Jc() {
        return this.aOR;
    }

    public void i(Bundle bundle) {
        this.aOR = bundle;
    }

    public Bitmap Jd() {
        Bitmap bitmap;
        if (this.aOQ == null || (bitmap = this.aOQ.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void g(Bitmap bitmap) {
        this.aOQ = new WeakReference<>(bitmap);
    }

    public byte[] Je() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.aOQ == null || (bitmap = this.aOQ.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [197=4, 198=4, 200=4, 201=4] */
    public void Jf() {
        FileOutputStream fileOutputStream = null;
        if (this.aOQ == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (l.hA()) {
                    File file = new File(aOV);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] Je = Je();
                    if (Je != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(Je);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.aOQ = null;
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
