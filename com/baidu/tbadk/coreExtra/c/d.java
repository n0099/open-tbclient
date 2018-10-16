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
    public static final String aOf = l.FH + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public String aNQ;
    public String aNU;
    public String aNV;
    public int aNY;
    private Bundle aOb;
    public int arx;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String uid;
    public boolean aNH = false;
    public boolean aNI = false;
    public boolean aNJ = false;
    public boolean aNK = false;
    public boolean aNL = false;
    public boolean aNM = false;
    public boolean aNN = false;
    public boolean aNO = false;
    public String aNP = "";
    public int aNW = 0;
    public int aNX = 3;
    public boolean aNZ = false;
    public boolean aOc = true;
    public boolean aOd = true;
    public boolean aOe = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String aNR = null;
    public Uri imageUri = null;
    public Location aNS = null;
    private WeakReference<Bitmap> aOa = null;
    public String aNT = null;
    public String extData = null;

    public Bundle IQ() {
        return this.aOb;
    }

    public void f(Bundle bundle) {
        this.aOb = bundle;
    }

    public Bitmap IR() {
        Bitmap bitmap;
        if (this.aOa == null || (bitmap = this.aOa.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void g(Bitmap bitmap) {
        this.aOa = new WeakReference<>(bitmap);
    }

    public byte[] IS() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.aOa == null || (bitmap = this.aOa.get()) == null || bitmap.isRecycled()) {
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
    public void IT() {
        FileOutputStream fileOutputStream = null;
        if (this.aOa == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (l.hB()) {
                    File file = new File(aOf);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] IS = IS();
                    if (IS != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(IS);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.aOa = null;
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
