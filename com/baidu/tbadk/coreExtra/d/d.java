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
    public static final String auM = k.xQ + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String Xe;
    public String auA;
    public String auF;
    public String auG;
    public int auJ;
    private Bundle auL;
    public int auz;
    public String fid;
    public String uid;
    public boolean aur = false;
    public boolean aus = false;
    public boolean aut = false;
    public boolean auu = false;
    public boolean auv = false;
    public boolean auw = false;
    public boolean aux = false;
    public String auy = "";
    public int auH = 0;
    public int auI = 3;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String auB = null;
    public Uri auC = null;
    public Location auD = null;
    private WeakReference<Bitmap> auK = null;
    public String auE = null;
    public String extData = null;

    public Bundle AW() {
        return this.auL;
    }

    public void e(Bundle bundle) {
        this.auL = bundle;
    }

    public Bitmap AX() {
        Bitmap bitmap;
        if (this.auK == null || (bitmap = this.auK.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void e(Bitmap bitmap) {
        this.auK = new WeakReference<>(bitmap);
    }
}
