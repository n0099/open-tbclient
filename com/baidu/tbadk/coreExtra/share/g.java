package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g {
    public static final String arW = l.yP + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String arT;
    public String arU;
    public boolean arM = false;
    public boolean arN = false;
    public boolean arO = false;
    public boolean arP = false;
    public boolean arQ = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String arR = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> arV = null;
    public String arS = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.arV == null || (bitmap = this.arV.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void i(Bitmap bitmap) {
        this.arV = new WeakReference<>(bitmap);
    }
}
