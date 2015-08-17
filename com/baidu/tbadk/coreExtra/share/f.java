package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String ajM = n.xV + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String ajJ;
    public String ajK;
    public boolean ajH = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> ajL = null;
    public String ajI = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.ajL == null || (bitmap = this.ajL.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void j(Bitmap bitmap) {
        this.ajL = new WeakReference<>(bitmap);
    }
}
