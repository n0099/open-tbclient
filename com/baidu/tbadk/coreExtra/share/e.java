package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    public static final String avo = k.zU + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String avj;
    public String avk;
    public String fid;
    public boolean ava = false;
    public boolean avb = false;
    public boolean avc = false;
    public boolean avd = false;
    public boolean ave = false;
    public boolean avf = false;
    public String avg = "";
    public int avl = 0;
    public int avm = 3;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String avh = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> avn = null;
    public String avi = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.avn == null || (bitmap = this.avn.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void i(Bitmap bitmap) {
        this.avn = new WeakReference<>(bitmap);
    }
}
