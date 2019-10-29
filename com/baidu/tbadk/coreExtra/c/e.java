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
    public static final String czh = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int ceG;
    public String cyE;
    public Bundle cyH;
    public String cyK;
    public String cyL;
    public int cyR;
    public String cyS;
    public String cyT;
    public String cyU;
    private Bundle cyW;
    public String czb;
    public String cze;
    public int czf;
    public String czg;
    public String fid;
    public String imageUrl;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String topic;
    public String uid;
    public boolean cys = false;
    public boolean cyt = false;
    public boolean cyu = false;
    public boolean cyv = false;
    public boolean cyw = false;
    public boolean cyx = false;
    public boolean cyy = false;
    public boolean cyz = false;
    public boolean cyA = false;
    public boolean cyB = false;
    public boolean cyC = false;
    public String cyD = "";
    public int cyM = 0;
    public int cyN = 3;
    public int cyO = 0;
    public int cyP = 0;
    public int cyQ = 0;
    public int shareType = 0;
    public boolean cyX = true;
    public boolean cyY = true;
    public boolean cyZ = true;
    public int cza = 0;
    public boolean czc = true;
    public boolean czd = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String cyF = null;
    public Uri imageUri = null;
    public Location cyI = null;
    private WeakReference<Bitmap> cyV = null;
    public String cyJ = null;
    public String extData = null;
    public String cyG = null;

    public Bundle ase() {
        return this.cyW;
    }

    public void E(Bundle bundle) {
        this.cyW = bundle;
    }

    public Bitmap asf() {
        Bitmap bitmap;
        if (this.cyV == null || (bitmap = this.cyV.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void p(Bitmap bitmap) {
        this.cyV = new WeakReference<>(bitmap);
    }

    public byte[] asg() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.cyV == null || (bitmap = this.cyV.get()) == null || bitmap.isRecycled()) {
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
    public void ash() {
        FileOutputStream fileOutputStream = null;
        if (this.cyV == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.checkSD()) {
                    File file = new File(czh);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] asg = asg();
                    if (asg != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(asg);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.cyV = null;
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
