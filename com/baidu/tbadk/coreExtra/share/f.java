package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String amZ = m.rB + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String amW;
    public String amX;
    public boolean amQ = false;
    public boolean amR = false;
    public boolean amS = false;
    public boolean amT = false;
    public boolean amU = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> amY = null;
    public String amV = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.amY == null || (bitmap = this.amY.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void i(Bitmap bitmap) {
        this.amY = new WeakReference<>(bitmap);
    }
}
