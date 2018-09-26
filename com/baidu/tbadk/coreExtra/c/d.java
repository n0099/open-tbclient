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
    public static final String aJD = l.EZ + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public String aJo;
    public String aJs;
    public String aJt;
    public int aJw;
    private Bundle aJz;
    public int amC;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String uid;
    public boolean aJf = false;
    public boolean aJg = false;
    public boolean aJh = false;
    public boolean aJi = false;
    public boolean aJj = false;
    public boolean aJk = false;
    public boolean aJl = false;
    public boolean aJm = false;
    public String aJn = "";
    public int aJu = 0;
    public int aJv = 3;
    public boolean aJx = false;
    public boolean aJA = true;
    public boolean aJB = true;
    public boolean aJC = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String aJp = null;
    public Uri imageUri = null;
    public Location aJq = null;
    private WeakReference<Bitmap> aJy = null;
    public String aJr = null;
    public String extData = null;

    public Bundle GP() {
        return this.aJz;
    }

    public void f(Bundle bundle) {
        this.aJz = bundle;
    }

    public Bitmap GQ() {
        Bitmap bitmap;
        if (this.aJy == null || (bitmap = this.aJy.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void g(Bitmap bitmap) {
        this.aJy = new WeakReference<>(bitmap);
    }

    public byte[] GR() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.aJy == null || (bitmap = this.aJy.get()) == null || bitmap.isRecycled()) {
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
    public void GS() {
        FileOutputStream fileOutputStream = null;
        if (this.aJy == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (l.hk()) {
                    File file = new File(aJD);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] GR = GR();
                    if (GR != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(GR);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.aJy = null;
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
