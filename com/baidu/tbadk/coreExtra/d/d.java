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
    public static final String auc = k.xT + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String Xl;
    public int atO;
    public String atP;
    public String atU;
    public String atV;
    public int atY;
    private Bundle aub;
    public String fid;
    public String uid;
    public boolean atG = false;
    public boolean atH = false;
    public boolean atI = false;
    public boolean atJ = false;
    public boolean atK = false;
    public boolean atL = false;
    public boolean atM = false;
    public String atN = "";
    public int atW = 0;
    public int atX = 3;
    public boolean atZ = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String atQ = null;
    public Uri atR = null;
    public Location atS = null;
    private WeakReference<Bitmap> aua = null;
    public String atT = null;
    public String extData = null;

    public Bundle Ax() {
        return this.aub;
    }

    public void e(Bundle bundle) {
        this.aub = bundle;
    }

    public Bitmap Ay() {
        Bitmap bitmap;
        if (this.aua == null || (bitmap = this.aua.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void e(Bitmap bitmap) {
        this.aua = new WeakReference<>(bitmap);
    }
}
