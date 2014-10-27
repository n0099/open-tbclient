package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.s;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h {
    public static final String Na = s.mI + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String title = null;
    public String content = null;
    public String MW = null;
    public Uri MX = null;
    public Location MY = null;
    private WeakReference<Bitmap> MZ = null;

    public Bitmap pN() {
        Bitmap bitmap;
        if (this.MZ == null || (bitmap = this.MZ.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void f(Bitmap bitmap) {
        this.MZ = new WeakReference<>(bitmap);
    }
}
