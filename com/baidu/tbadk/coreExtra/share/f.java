package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.s;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String SP = s.mG + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String title = null;
    public String content = null;
    public String SJ = null;
    public Uri SL = null;
    public Location SM = null;
    private WeakReference<Bitmap> SO = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.SO == null || (bitmap = this.SO.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.SO = new WeakReference<>(bitmap);
    }
}
