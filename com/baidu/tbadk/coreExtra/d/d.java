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
    public static final String auk = k.xT + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String Xl;
    public int atW;
    public String atX;
    public String auc;
    public String aud;
    public int aug;
    private Bundle auj;
    public String fid;
    public String uid;
    public boolean atO = false;
    public boolean atP = false;
    public boolean atQ = false;
    public boolean atR = false;
    public boolean atS = false;
    public boolean atT = false;
    public boolean atU = false;
    public String atV = "";
    public int aue = 0;
    public int auf = 3;
    public boolean auh = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String atY = null;
    public Uri atZ = null;
    public Location aua = null;
    private WeakReference<Bitmap> aui = null;
    public String aub = null;
    public String extData = null;

    public Bundle AJ() {
        return this.auj;
    }

    public void e(Bundle bundle) {
        this.auj = bundle;
    }

    public Bitmap AK() {
        Bitmap bitmap;
        if (this.aui == null || (bitmap = this.aui.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void e(Bitmap bitmap) {
        this.aui = new WeakReference<>(bitmap);
    }
}
