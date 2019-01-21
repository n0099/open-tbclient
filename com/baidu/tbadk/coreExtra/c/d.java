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
    public static final String aTf = l.FL + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public String aSM;
    public String aSR;
    public String aSS;
    public int aSV;
    public String aSW;
    public String aSX;
    public String aSY;
    private Bundle aTa;
    public int awo;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String topic;
    public String uid;
    public boolean aSD = false;
    public boolean aSE = false;
    public boolean aSF = false;
    public boolean aSG = false;
    public boolean aSH = false;
    public boolean aSI = false;
    public boolean aSJ = false;
    public boolean aSK = false;
    public String aSL = "";
    public int aST = 0;
    public int aSU = 3;
    public int shareType = 0;
    public boolean aTb = true;
    public boolean aTc = true;
    public boolean aTd = true;
    public int aTe = 0;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String aSN = null;
    public Uri imageUri = null;
    public Location aSP = null;
    private WeakReference<Bitmap> aSZ = null;
    public String aSQ = null;
    public String extData = null;
    public String aSO = null;

    public Bundle Kw() {
        return this.aTa;
    }

    public void k(Bundle bundle) {
        this.aTa = bundle;
    }

    public void hq(String str) {
        this.aSO = str;
    }

    public Bitmap Kx() {
        Bitmap bitmap;
        if (this.aSZ == null || (bitmap = this.aSZ.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void g(Bitmap bitmap) {
        this.aSZ = new WeakReference<>(bitmap);
    }

    public byte[] Ky() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.aSZ == null || (bitmap = this.aSZ.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [216=4, 217=4, 219=4, 220=4] */
    public void Kz() {
        FileOutputStream fileOutputStream = null;
        if (this.aSZ == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (l.hA()) {
                    File file = new File(aTf);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] Ky = Ky();
                    if (Ky != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(Ky);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.aSZ = null;
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
