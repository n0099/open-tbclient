package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.s;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String Tu = s.mJ + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String title = null;
    public String content = null;
    public String Tq = null;
    public Uri Tr = null;
    public Location Ts = null;
    private WeakReference<Bitmap> Tt = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.Tt == null || (bitmap = this.Tt.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.Tt = new WeakReference<>(bitmap);
    }
}
