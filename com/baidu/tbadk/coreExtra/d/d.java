package com.baidu.tbadk.coreExtra.d;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    public static final String atF = k.xT + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String WT;
    public int atC;
    private Bundle atE;
    public int ats;
    public String att;
    public String aty;
    public String atz;
    public String fid;
    public String uid;
    public boolean atk = false;
    public boolean atl = false;
    public boolean atm = false;
    public boolean atn = false;
    public boolean ato = false;
    public boolean atp = false;
    public boolean atq = false;
    public String atr = "";
    public int atA = 0;
    public int atB = 3;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String atu = null;
    public Uri atv = null;
    public Location atw = null;
    private WeakReference<Bitmap> atD = null;
    public String atx = null;
    public String extData = null;

    public Bundle Ao() {
        return this.atE;
    }

    public void e(Bundle bundle) {
        this.atE = bundle;
    }

    public Bitmap Ap() {
        Bitmap bitmap;
        if (this.atD == null || (bitmap = this.atD.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void e(Bitmap bitmap) {
        this.atD = new WeakReference<>(bitmap);
    }
}
