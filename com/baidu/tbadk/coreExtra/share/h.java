package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h {
    public static final String asc = l.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String arX;
    public String arY;
    public boolean arQ = false;
    public boolean arR = false;
    public boolean arS = false;
    public boolean arT = false;
    public boolean arU = false;
    public int arZ = 0;
    public int asa = 3;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String arV = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> asb = null;
    public String arW = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.asb == null || (bitmap = this.asb.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.asb = new WeakReference<>(bitmap);
    }
}
