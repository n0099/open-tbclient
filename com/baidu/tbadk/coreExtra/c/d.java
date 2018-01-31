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
    public static final String bjy = k.amf + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int aPh;
    public String bjk;
    public String bjp;
    public String bjq;
    public int bjt;
    private Bundle bjw;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String price;
    public String tid;
    public String uid;
    public boolean bjc = false;
    public boolean bjd = false;
    public boolean bje = false;
    public boolean bjf = false;
    public boolean bjg = false;
    public boolean bjh = false;
    public boolean bji = false;
    public String bjj = "";
    public int bjr = 0;
    public int bjs = 3;
    public boolean bju = false;
    public boolean bjx = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String bjl = null;
    public Uri bjm = null;
    public Location bjn = null;
    private WeakReference<Bitmap> bjv = null;
    public String bjo = null;
    public String extData = null;

    public Bundle Ir() {
        return this.bjw;
    }

    public void h(Bundle bundle) {
        this.bjw = bundle;
    }

    public Bitmap Is() {
        Bitmap bitmap;
        if (this.bjv == null || (bitmap = this.bjv.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.bjv = new WeakReference<>(bitmap);
    }
}
