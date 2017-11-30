package com.baidu.tbadk.coreExtra.c;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.k;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    public static final String auL = k.xT + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int aaM;
    public String auC;
    public String auD;
    public int auG;
    private Bundle auJ;
    public String aux;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String uid;
    public boolean aup = false;
    public boolean auq = false;
    public boolean aur = false;
    public boolean aus = false;
    public boolean aut = false;
    public boolean auu = false;
    public boolean auv = false;
    public String auw = "";
    public int auE = 0;
    public int auF = 3;
    public boolean auH = false;
    public boolean auK = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String auy = null;
    public Uri auz = null;
    public Location auA = null;
    private WeakReference<Bitmap> auI = null;
    public String auB = null;
    public String extData = null;

    public Bundle AT() {
        return this.auJ;
    }

    public void e(Bundle bundle) {
        this.auJ = bundle;
    }

    public Bitmap AU() {
        Bitmap bitmap;
        if (this.auI == null || (bitmap = this.auI.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void e(Bitmap bitmap) {
        this.auI = new WeakReference<>(bitmap);
    }
}
