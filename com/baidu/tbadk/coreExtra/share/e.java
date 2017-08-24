package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    public static final String avq = k.zW + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String avl;
    public String avm;
    public String fid;
    public boolean avc = false;
    public boolean avd = false;
    public boolean ave = false;
    public boolean avf = false;
    public boolean avg = false;
    public boolean avh = false;
    public String avi = "";
    public int avn = 0;
    public int avo = 3;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String avj = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> avp = null;
    public String avk = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.avp == null || (bitmap = this.avp.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void i(Bitmap bitmap) {
        this.avp = new WeakReference<>(bitmap);
    }
}
