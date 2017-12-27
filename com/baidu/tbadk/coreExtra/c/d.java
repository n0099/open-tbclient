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
    public static final String biZ = k.amc + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int aPf;
    public String biL;
    public String biQ;
    public String biR;
    public int biU;
    private Bundle biX;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String tid;
    public String uid;
    public boolean biD = false;
    public boolean biE = false;
    public boolean biF = false;
    public boolean biG = false;
    public boolean biH = false;
    public boolean biI = false;
    public boolean biJ = false;
    public String biK = "";
    public int biS = 0;
    public int biT = 3;
    public boolean biV = false;
    public boolean biY = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String biM = null;
    public Uri biN = null;
    public Location biO = null;
    private WeakReference<Bitmap> biW = null;
    public String biP = null;
    public String extData = null;

    public Bundle Iw() {
        return this.biX;
    }

    public void h(Bundle bundle) {
        this.biX = bundle;
    }

    public Bitmap Ix() {
        Bitmap bitmap;
        if (this.biW == null || (bitmap = this.biW.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.biW = new WeakReference<>(bitmap);
    }
}
