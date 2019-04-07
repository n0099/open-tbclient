package com.baidu.tbadk.coreExtra.c;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    public static final String cbR = m.FK + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int bDY;
    public String cbA;
    public String cbB;
    public int cbH;
    public String cbI;
    public String cbJ;
    public String cbK;
    private Bundle cbM;
    public String cbu;
    public Bundle cbx;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String topic;
    public String uid;
    public boolean cbj = false;
    public boolean cbk = false;
    public boolean cbl = false;
    public boolean cbm = false;
    public boolean cbn = false;
    public boolean cbo = false;
    public boolean cbp = false;
    public boolean cbq = false;
    public boolean cbr = false;
    public boolean cbs = false;
    public String cbt = "";
    public int cbC = 0;
    public int cbD = 3;
    public int cbE = 0;
    public int cbF = 0;
    public int cbG = 0;
    public int shareType = 0;
    public boolean cbN = true;
    public boolean cbO = true;
    public boolean cbP = true;
    public int cbQ = 0;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String cbv = null;
    public Uri imageUri = null;
    public Location cby = null;
    private WeakReference<Bitmap> cbL = null;
    public String cbz = null;
    public String extData = null;
    public String cbw = null;

    public Bundle ajP() {
        return this.cbM;
    }

    public void D(Bundle bundle) {
        this.cbM = bundle;
    }

    public Bitmap ajQ() {
        Bitmap bitmap;
        if (this.cbL == null || (bitmap = this.cbL.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void n(Bitmap bitmap) {
        this.cbL = new WeakReference<>(bitmap);
    }

    public byte[] ajR() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.cbL == null || (bitmap = this.cbL.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [232=4, 233=4, 235=4, 236=4] */
    public void ajS() {
        FileOutputStream fileOutputStream = null;
        if (this.cbL == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.hy()) {
                    File file = new File(cbR);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] ajR = ajR();
                    if (ajR != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(ajR);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.cbL = null;
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
