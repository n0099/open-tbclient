package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.s;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h {
    public static final String Ne = s.mI + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String title = null;
    public String content = null;
    public String Na = null;
    public Uri Nb = null;
    public Location Nc = null;
    private WeakReference<Bitmap> Nd = null;

    public Bitmap pP() {
        Bitmap bitmap;
        if (this.Nd == null || (bitmap = this.Nd.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void f(Bitmap bitmap) {
        this.Nd = new WeakReference<>(bitmap);
    }
}
