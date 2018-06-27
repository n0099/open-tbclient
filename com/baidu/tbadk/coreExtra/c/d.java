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
    public static final String aGq = l.CH + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public String aGb;
    public String aGf;
    public String aGg;
    public int aGj;
    private Bundle aGm;
    public int aky;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String price;
    public String tid;
    public String uid;
    public boolean aFS = false;
    public boolean aFT = false;
    public boolean aFU = false;
    public boolean aFV = false;
    public boolean aFW = false;
    public boolean aFX = false;
    public boolean aFY = false;
    public boolean aFZ = false;
    public String aGa = "";
    public int aGh = 0;
    public int aGi = 3;
    public boolean aGk = false;
    public boolean aGn = true;
    public boolean aGo = true;
    public boolean aGp = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String aGc = null;
    public Uri imageUri = null;
    public Location aGd = null;
    private WeakReference<Bitmap> aGl = null;
    public String aGe = null;
    public String extData = null;

    public Bundle FD() {
        return this.aGm;
    }

    public void f(Bundle bundle) {
        this.aGm = bundle;
    }

    public Bitmap FE() {
        Bitmap bitmap;
        if (this.aGl == null || (bitmap = this.aGl.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void f(Bitmap bitmap) {
        this.aGl = new WeakReference<>(bitmap);
    }

    public byte[] FF() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.aGl == null || (bitmap = this.aGl.get()) == null || bitmap.isRecycled()) {
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
    public void FG() {
        FileOutputStream fileOutputStream = null;
        if (this.aGl == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (l.ge()) {
                    File file = new File(aGq);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] FF = FF();
                    if (FF != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(FF);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.aGl = null;
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
