package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.s;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String Tr = s.mJ + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String title = null;
    public String content = null;
    public String Tn = null;
    public Uri To = null;
    public Location Tp = null;
    private WeakReference<Bitmap> Tq = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.Tq == null || (bitmap = this.Tq.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.Tq = new WeakReference<>(bitmap);
    }
}
