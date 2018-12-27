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
    public static final String aSw = l.FL + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public String aSh;
    public String aSl;
    public String aSm;
    public int aSp;
    public String aSq;
    private Bundle aSs;
    public int avL;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String topic;
    public String uid;
    public boolean aRY = false;
    public boolean aRZ = false;
    public boolean aSa = false;
    public boolean aSb = false;
    public boolean aSc = false;
    public boolean aSd = false;
    public boolean aSe = false;
    public boolean aSf = false;
    public String aSg = "";
    public int aSn = 0;
    public int aSo = 3;
    public int shareType = 0;
    public boolean aSt = true;
    public boolean aSu = true;
    public boolean aSv = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String aSi = null;
    public Uri imageUri = null;
    public Location aSj = null;
    private WeakReference<Bitmap> aSr = null;
    public String aSk = null;
    public String extData = null;

    public Bundle Kh() {
        return this.aSs;
    }

    public void k(Bundle bundle) {
        this.aSs = bundle;
    }

    public Bitmap Ki() {
        Bitmap bitmap;
        if (this.aSr == null || (bitmap = this.aSr.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void g(Bitmap bitmap) {
        this.aSr = new WeakReference<>(bitmap);
    }

    public byte[] Kj() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.aSr == null || (bitmap = this.aSr.get()) == null || bitmap.isRecycled()) {
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
    public void Kk() {
        FileOutputStream fileOutputStream = null;
        if (this.aSr == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (l.hA()) {
                    File file = new File(aSw);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] Kj = Kj();
                    if (Kj != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(Kj);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.aSr = null;
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
