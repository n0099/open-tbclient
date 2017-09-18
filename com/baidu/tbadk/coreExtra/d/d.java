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
    public static final String auJ = k.xQ + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String Xe;
    public String auC;
    public String auD;
    public int auG;
    private Bundle auI;
    public int auw;
    public String aux;
    public String fid;
    public String uid;
    public boolean auo = false;
    public boolean aup = false;
    public boolean auq = false;
    public boolean aur = false;
    public boolean aus = false;
    public boolean aut = false;
    public boolean auu = false;
    public String auv = "";
    public int auE = 0;
    public int auF = 3;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String auy = null;
    public Uri auz = null;
    public Location auA = null;
    private WeakReference<Bitmap> auH = null;
    public String auB = null;
    public String extData = null;

    public Bundle AW() {
        return this.auI;
    }

    public void e(Bundle bundle) {
        this.auI = bundle;
    }

    public Bitmap AX() {
        Bitmap bitmap;
        if (this.auH == null || (bitmap = this.auH.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void e(Bitmap bitmap) {
        this.auH = new WeakReference<>(bitmap);
    }
}
