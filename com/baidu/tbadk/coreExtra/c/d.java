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
    public static final String bjq = k.amc + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int aPe;
    public String bjc;
    public String bjh;
    public String bji;
    public int bjl;
    private Bundle bjo;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String price;
    public String tid;
    public String uid;
    public boolean biU = false;
    public boolean biV = false;
    public boolean biW = false;
    public boolean biX = false;
    public boolean biY = false;
    public boolean biZ = false;
    public boolean bja = false;
    public String bjb = "";
    public int bjj = 0;
    public int bjk = 3;
    public boolean bjm = false;
    public boolean bjp = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String bjd = null;
    public Uri bje = null;
    public Location bjf = null;
    private WeakReference<Bitmap> bjn = null;
    public String bjg = null;
    public String extData = null;

    public Bundle Ip() {
        return this.bjo;
    }

    public void h(Bundle bundle) {
        this.bjo = bundle;
    }

    public Bitmap Iq() {
        Bitmap bitmap;
        if (this.bjn == null || (bitmap = this.bjn.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.bjn = new WeakReference<>(bitmap);
    }
}
