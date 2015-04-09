package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.o;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String adA = o.yl + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String adx;
    public String ady;
    public boolean adt = false;
    public String title = null;
    public String content = null;
    public String adu = null;
    public Uri adv = null;
    public Location adw = null;
    private WeakReference<Bitmap> adz = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.adz == null || (bitmap = this.adz.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.adz = new WeakReference<>(bitmap);
    }
}
