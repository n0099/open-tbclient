package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    public static final String avp = k.zW + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String avk;
    public String avl;
    public String fid;
    public boolean avb = false;
    public boolean avc = false;
    public boolean avd = false;
    public boolean ave = false;
    public boolean avf = false;
    public boolean avg = false;
    public String avh = "";
    public int avm = 0;
    public int avn = 3;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String avi = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> avo = null;
    public String avj = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.avo == null || (bitmap = this.avo.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void i(Bitmap bitmap) {
        this.avo = new WeakReference<>(bitmap);
    }
}
