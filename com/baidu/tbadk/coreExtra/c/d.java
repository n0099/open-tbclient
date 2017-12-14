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
    public static final String auQ = k.xQ + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int aaG;
    public String auC;
    public String auH;
    public String auI;
    public int auL;
    private Bundle auO;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String uid;
    public boolean auu = false;
    public boolean auv = false;
    public boolean auw = false;
    public boolean aux = false;
    public boolean auy = false;
    public boolean auz = false;
    public boolean auA = false;
    public String auB = "";
    public int auJ = 0;
    public int auK = 3;
    public boolean auM = false;
    public boolean auP = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String auD = null;
    public Uri auE = null;
    public Location auF = null;
    private WeakReference<Bitmap> auN = null;
    public String auG = null;
    public String extData = null;

    public Bundle AU() {
        return this.auO;
    }

    public void e(Bundle bundle) {
        this.auO = bundle;
    }

    public Bitmap AV() {
        Bitmap bitmap;
        if (this.auN == null || (bitmap = this.auN.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void e(Bitmap bitmap) {
        this.auN = new WeakReference<>(bitmap);
    }
}
