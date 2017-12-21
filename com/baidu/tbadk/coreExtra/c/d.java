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
    public static final String auT = k.xR + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int aaJ;
    public String auF;
    public String auK;
    public String auL;
    public int auO;
    private Bundle auR;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String uid;
    public boolean aux = false;
    public boolean auy = false;
    public boolean auz = false;
    public boolean auA = false;
    public boolean auB = false;
    public boolean auC = false;
    public boolean auD = false;
    public String auE = "";
    public int auM = 0;
    public int auN = 3;
    public boolean auP = false;
    public boolean auS = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String auG = null;
    public Uri auH = null;
    public Location auI = null;
    private WeakReference<Bitmap> auQ = null;
    public String auJ = null;
    public String extData = null;

    public Bundle AU() {
        return this.auR;
    }

    public void e(Bundle bundle) {
        this.auR = bundle;
    }

    public Bitmap AV() {
        Bitmap bitmap;
        if (this.auQ == null || (bitmap = this.auQ.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void e(Bitmap bitmap) {
        this.auQ = new WeakReference<>(bitmap);
    }
}
