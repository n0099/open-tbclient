package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String anS = m.rC + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String anQ;
    public String shareAbstract;
    public boolean anJ = false;
    public boolean anK = false;
    public boolean anL = false;
    public boolean anM = false;
    public boolean anN = false;
    public boolean anO = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> anR = null;
    public String anP = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.anR == null || (bitmap = this.anR.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void i(Bitmap bitmap) {
        this.anR = new WeakReference<>(bitmap);
    }
}
