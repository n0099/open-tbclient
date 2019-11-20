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
public class e {
    public static final String cyq = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int cdP;
    public String cxN;
    public Bundle cxQ;
    public String cxT;
    public String cxU;
    public int cya;
    public String cyb;
    public String cyc;
    public String cyd;
    private Bundle cyf;
    public String cyk;
    public String cyn;
    public int cyo;
    public String cyp;
    public String fid;
    public String imageUrl;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String topic;
    public String uid;
    public boolean cxB = false;
    public boolean cxC = false;
    public boolean cxD = false;
    public boolean cxE = false;
    public boolean cxF = false;
    public boolean cxG = false;
    public boolean cxH = false;
    public boolean cxI = false;
    public boolean cxJ = false;
    public boolean cxK = false;
    public boolean cxL = false;
    public String cxM = "";
    public int cxV = 0;
    public int cxW = 3;
    public int cxX = 0;
    public int cxY = 0;
    public int cxZ = 0;
    public int shareType = 0;
    public boolean cyg = true;
    public boolean cyh = true;
    public boolean cyi = true;
    public int cyj = 0;
    public boolean cyl = true;
    public boolean cym = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String cxO = null;
    public Uri imageUri = null;
    public Location cxR = null;
    private WeakReference<Bitmap> cye = null;
    public String cxS = null;
    public String extData = null;
    public String cxP = null;

    public Bundle asc() {
        return this.cyf;
    }

    public void E(Bundle bundle) {
        this.cyf = bundle;
    }

    public Bitmap asd() {
        Bitmap bitmap;
        if (this.cye == null || (bitmap = this.cye.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void p(Bitmap bitmap) {
        this.cye = new WeakReference<>(bitmap);
    }

    public byte[] ase() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.cye == null || (bitmap = this.cye.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [249=4, 250=4, 252=4, 253=4] */
    public void asf() {
        FileOutputStream fileOutputStream = null;
        if (this.cye == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.checkSD()) {
                    File file = new File(cyq);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] ase = ase();
                    if (ase != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(ase);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.cye = null;
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
