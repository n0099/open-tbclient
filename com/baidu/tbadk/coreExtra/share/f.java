package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String amB = l.ru + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String amy;
    public String amz;
    public boolean ams = false;
    public boolean amt = false;
    public boolean amu = false;
    public boolean amv = false;
    public boolean amw = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> amA = null;
    public String amx = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.amA == null || (bitmap = this.amA.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void i(Bitmap bitmap) {
        this.amA = new WeakReference<>(bitmap);
    }
}
