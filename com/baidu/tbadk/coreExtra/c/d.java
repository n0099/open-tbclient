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
    public static final String aFx = l.CF + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public String aFh;
    public String aFm;
    public String aFn;
    public int aFq;
    private Bundle aFt;
    public int ajZ;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String price;
    public String tid;
    public String uid;
    public boolean aEY = false;
    public boolean aEZ = false;
    public boolean aFa = false;
    public boolean aFb = false;
    public boolean aFc = false;
    public boolean aFd = false;
    public boolean aFe = false;
    public boolean aFf = false;
    public String aFg = "";
    public int aFo = 0;
    public int aFp = 3;
    public boolean aFr = false;
    public boolean aFu = true;
    public boolean aFv = true;
    public boolean aFw = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String aFi = null;
    public Uri aFj = null;
    public Location aFk = null;
    private WeakReference<Bitmap> aFs = null;
    public String aFl = null;
    public String extData = null;

    public Bundle Fl() {
        return this.aFt;
    }

    public void f(Bundle bundle) {
        this.aFt = bundle;
    }

    public Bitmap Fm() {
        Bitmap bitmap;
        if (this.aFs == null || (bitmap = this.aFs.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void f(Bitmap bitmap) {
        this.aFs = new WeakReference<>(bitmap);
    }

    public byte[] Fn() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.aFs == null || (bitmap = this.aFs.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [205=4, 206=4, 208=4, 209=4] */
    public void Fo() {
        FileOutputStream fileOutputStream = null;
        if (this.aFs == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (l.ge()) {
                    File file = new File(aFx);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] Fn = Fn();
                    if (Fn != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(Fn);
                            fileOutputStream3.close();
                            this.aFj = Uri.fromFile(file);
                            this.aFs = null;
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
