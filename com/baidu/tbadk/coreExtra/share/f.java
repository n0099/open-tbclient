package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String aiZ = n.xU + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String aiW;
    public String aiX;
    public boolean aiS = false;
    public boolean aiT = false;
    public boolean aiU = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> aiY = null;
    public String aiV = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.aiY == null || (bitmap = this.aiY.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void j(Bitmap bitmap) {
        this.aiY = new WeakReference<>(bitmap);
    }
}
