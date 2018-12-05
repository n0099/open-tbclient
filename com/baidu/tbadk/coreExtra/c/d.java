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
    public static final String aSu = l.FL + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public String aSf;
    public String aSj;
    public String aSk;
    public int aSn;
    public String aSo;
    private Bundle aSq;
    public int avK;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String topic;
    public String uid;
    public boolean aRW = false;
    public boolean aRX = false;
    public boolean aRY = false;
    public boolean aRZ = false;
    public boolean aSa = false;
    public boolean aSb = false;
    public boolean aSc = false;
    public boolean aSd = false;
    public String aSe = "";
    public int aSl = 0;
    public int aSm = 3;
    public int shareType = 0;
    public boolean aSr = true;
    public boolean aSs = true;
    public boolean aSt = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String aSg = null;
    public Uri imageUri = null;
    public Location aSh = null;
    private WeakReference<Bitmap> aSp = null;
    public String aSi = null;
    public String extData = null;

    public Bundle Kg() {
        return this.aSq;
    }

    public void k(Bundle bundle) {
        this.aSq = bundle;
    }

    public Bitmap Kh() {
        Bitmap bitmap;
        if (this.aSp == null || (bitmap = this.aSp.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void g(Bitmap bitmap) {
        this.aSp = new WeakReference<>(bitmap);
    }

    public byte[] Ki() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.aSp == null || (bitmap = this.aSp.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=4, 203=4, 205=4, 206=4] */
    public void Kj() {
        FileOutputStream fileOutputStream = null;
        if (this.aSp == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (l.hA()) {
                    File file = new File(aSu);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] Ki = Ki();
                    if (Ki != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(Ki);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.aSp = null;
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
