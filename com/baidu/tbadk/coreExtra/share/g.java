package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.o;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g {
    public static final String aeF = o.ya + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String aeC;
    public String aeD;
    public boolean aeA = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> aeE = null;
    public String aeB = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.aeE == null || (bitmap = this.aeE.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.aeE = new WeakReference<>(bitmap);
    }
}
