package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String akm = m.po + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String akj;
    public String akk;
    public boolean akd = false;
    public boolean ake = false;
    public boolean akf = false;
    public boolean akg = false;
    public boolean akh = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> akl = null;
    public String aki = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.akl == null || (bitmap = this.akl.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.akl = new WeakReference<>(bitmap);
    }
}
